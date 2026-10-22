(ns cljc.java-time.format.resolver-style
  (:refer-clojure :exclude [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import (java.time.format ResolverStyle)))

(def smart java.time.format.ResolverStyle/SMART)

(def strict java.time.format.ResolverStyle/STRICT)

(def lenient java.time.format.ResolverStyle/LENIENT)

(defn value-of
  (^java.time.format.ResolverStyle [^java.lang.String name]
   (java.time.format.ResolverStyle/valueOf name)))

(defn values
  (^"java.lang.Class" []
   (java.time.format.ResolverStyle/values)))
