(ns cljc.java-time.format.text-style
  (:refer-clojure :exclude [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import (java.time.format TextStyle)))

(def short java.time.format.TextStyle/SHORT)

(def full-standalone java.time.format.TextStyle/FULL_STANDALONE)

(def full java.time.format.TextStyle/FULL)

(def short-standalone java.time.format.TextStyle/SHORT_STANDALONE)

(def narrow java.time.format.TextStyle/NARROW)

(def narrow-standalone java.time.format.TextStyle/NARROW_STANDALONE)

(defn as-normal
  (^java.time.format.TextStyle [^java.time.format.TextStyle this]
   (.asNormal this)))

(defn as-standalone
  (^java.time.format.TextStyle [^java.time.format.TextStyle this]
   (.asStandalone this)))

(defn is-standalone
  (^java.lang.Boolean [^java.time.format.TextStyle this]
   (.isStandalone this)))

(defn value-of
  (^java.time.format.TextStyle [^java.lang.String name]
   (java.time.format.TextStyle/valueOf name)))

(defn values
  (^"java.lang.Class" []
   (java.time.format.TextStyle/values)))
