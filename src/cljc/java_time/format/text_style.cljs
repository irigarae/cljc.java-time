(ns cljc.java-time.format.text-style
  (:refer-clojure :exclude [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time.format :refer [TextStyle]]))

(def short (goog.object/get java.time.format.TextStyle "SHORT"))

(def full-standalone (goog.object/get java.time.format.TextStyle "FULL_STANDALONE"))

(def full (goog.object/get java.time.format.TextStyle "FULL"))

(def short-standalone (goog.object/get java.time.format.TextStyle "SHORT_STANDALONE"))

(def narrow (goog.object/get java.time.format.TextStyle "NARROW"))

(def narrow-standalone (goog.object/get java.time.format.TextStyle "NARROW_STANDALONE"))

(defn as-normal
  (^js/JSJoda.TextStyle [^js/JSJoda.TextStyle this]
   (.asNormal this)))

(defn as-standalone
  (^js/JSJoda.TextStyle [^js/JSJoda.TextStyle this]
   (.asStandalone this)))

(defn is-standalone
  (^boolean [^js/JSJoda.TextStyle this]
   (.isStandalone this)))

(defn value-of
  (^js/JSJoda.TextStyle [^java.lang.String name]
   (js-invoke java.time.format.TextStyle "valueOf" name)))

(defn values
  (^"java.lang.Class" []
   (js-invoke java.time.format.TextStyle "values")))
