(ns cljc.java-time.format.sign-style
  (:refer-clojure :exclude [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time.format :refer [SignStyle]]))

(def exceeds-pad (goog.object/get java.time.format.SignStyle "EXCEEDS_PAD"))

(def normal (goog.object/get java.time.format.SignStyle "NORMAL"))

(def always (goog.object/get java.time.format.SignStyle "ALWAYS"))

(def never (goog.object/get java.time.format.SignStyle "NEVER"))

(def not-negative (goog.object/get java.time.format.SignStyle "NOT_NEGATIVE"))

(defn value-of
  (^js/JSJoda.SignStyle [^java.lang.String name]
   (js-invoke java.time.format.SignStyle "valueOf" name)))

(defn values
  (^"java.lang.Class" []
   (js-invoke java.time.format.SignStyle "values")))
