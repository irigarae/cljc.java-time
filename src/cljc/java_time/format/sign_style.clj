(ns cljc.java-time.format.sign-style
  (:refer-clojure :exclude [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import (java.time.format SignStyle)))

(def exceeds-pad java.time.format.SignStyle/EXCEEDS_PAD)

(def normal java.time.format.SignStyle/NORMAL)

(def always java.time.format.SignStyle/ALWAYS)

(def never java.time.format.SignStyle/NEVER)

(def not-negative java.time.format.SignStyle/NOT_NEGATIVE)

(defn value-of
  (^java.time.format.SignStyle [^java.lang.String name]
   (java.time.format.SignStyle/valueOf name)))

(defn values
  (^"java.lang.Class" []
   (java.time.format.SignStyle/values)))
