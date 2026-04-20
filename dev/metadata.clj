;; required in java 8
(try
  (Class/forName "com.sun.source.util.JavacTask")
  (catch ClassNotFoundException _
    (require '[clojure.repl.deps])
    (clojure.repl.deps/add-lib 'com.sun/tools {:local/root (str (System/getProperty "java.home") "/../lib/tools.jar")})))
(ns metadata
  (:require [clojure.java.io :as io]
            [clojure.string :as str])
  (:import (com.sun.source.tree ClassTree CompilationUnitTree MethodTree Tree$Kind VariableTree)
           (com.sun.source.util JavacTask TreePathScanner Trees)
           (java.io File PrintWriter StringWriter)
           (java.net URI)
           (java.util.zip ZipEntry ZipFile)
           (javax.tools JavaFileObject$Kind SimpleJavaFileObject ToolProvider)))

(set! *warn-on-reflection* true)

(defn- remove-generics
  [s]
  (let [s' (str/replace s #"<[^>]*>" "")]
    (if (= s s')
      s
      (recur s'))))

(defn- method-fqn
  [package cname method]
  (let [fqn (str package \. cname \. (remove-generics method))
        fqn (str/replace fqn "..." "[]")]
    (case fqn
      "java.lang.Enum.compareTo(E)"
      "java.lang.Enum.compareTo(java.lang.Enum)"

      "java.time.temporal.ChronoUnit.addTo(R,long)"
      "java.time.temporal.ChronoUnit.addTo(java.time.temporal.Temporal,long)"

      "java.time.temporal.ChronoField.adjustInto(R,long)"
      "java.time.temporal.ChronoField.adjustInto(java.time.temporal.Temporal,long)"

      "java.time.temporal.TemporalUnit.addTo(R,long)"
      "java.time.temporal.TemporalUnit.addTo(java.time.temporal.Temporal,long)"

      "java.time.temporal.TemporalField.adjustInto(R,long)"
      "java.time.temporal.TemporalField.adjustInto(java.time.temporal.Temporal,long)"
      fqn)))

(defn get-method-params
  "Parse Java source via JavacTask + TreePathScanner and return map of
  method/constructor name → vector of parameter-names."
  [^String code]
  (let [compiler (ToolProvider/getSystemJavaCompiler)]
    (with-open [fm (.getStandardFileManager compiler nil nil nil)]
      (let [;; hide stderr on .analyze
            out (PrintWriter. (StringWriter.))
            cu (proxy [SimpleJavaFileObject]
                      [(URI/create "string:///_.java") JavaFileObject$Kind/SOURCE]
                 (getCharContent [_] code))
            ^JavacTask task (.getTask compiler out fm nil nil nil [cu])
            ^CompilationUnitTree unit (first (.parse task))
            _ (.analyze task)
            trees (Trees/instance task)
            ^TreePathScanner scanner (proxy [TreePathScanner] []
                                       (visitMethod [^MethodTree node ctx]
                                         (let [{:keys [result package cname]} ctx
                                               path (.getCurrentPath ^TreePathScanner this)
                                               fqn (method-fqn package cname (str (.getElement trees path)))
                                               params (mapv #(str (.getName ^VariableTree %)) (.getParameters node))]
                                           (swap! result assoc fqn params))))
            result (atom {})]
        (doseq [^ClassTree td (.getTypeDecls unit)
                :when (instance? ClassTree td)
                :let [package (.getPackageName unit)
                      cname (.getSimpleName td)]]
          (.scan scanner unit {:result result
                               :package package
                               :cname cname})
          (when (= Tree$Kind/ENUM (.getKind td))
            (swap! result assoc
                   (method-fqn package cname "values()") []
                   (method-fqn package cname "valueOf(java.lang.String)") ["name"])))
        (into (sorted-map) @result)))))

(defn get-java-time-params
  "Return a single map of fully qualified method signature → parameter-names
  for all methods/constructors across the java.time package."
  ([] (get-java-time-params (io/file (System/getProperty "java.home") "lib" "src.zip")))
  ([^File f]
   (with-open [zf (ZipFile. f)]
     (->> (enumeration-seq (.entries zf))
          (keep (fn [^ZipEntry e]
                  (let [n (.getName e)]
                    (when (and (str/ends-with? n ".java")
                               (not (str/ends-with? n "package-info.java"))
                               (or (str/starts-with? n "java/time/")
                                   ;; some methods inherited from Enum, e.g., Month
                                   (= "java/lang/Enum.java" n)))
                      (get-method-params (slurp (.getInputStream zf e)))))))
          (mapcat seq)
          (into (sorted-map))))))

(def param-names
  (get-java-time-params (io/file (System/getProperty "java.home") ".." "src.zip")))
