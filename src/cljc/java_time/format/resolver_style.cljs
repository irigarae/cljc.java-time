(ns cljc.java-time.format.resolver-style
  (:refer-clojure :exclude [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time.format :refer [ResolverStyle]]))

(def smart (goog.object/get java.time.format.ResolverStyle "SMART"))

(def strict (goog.object/get java.time.format.ResolverStyle "STRICT"))

(def lenient (goog.object/get java.time.format.ResolverStyle "LENIENT"))

(defn value-of
  (^js/JSJoda.ResolverStyle [^java.lang.String name]
   (js-invoke java.time.format.ResolverStyle "valueOf" name)))

(defn values
  (^"java.lang.Class" []
   (js-invoke java.time.format.ResolverStyle "values")))
