(ns cljc.java-time.clock
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time Clock]))

(defn tick
  {:arglists (quote (["java.time.Clock" "java.time.Duration"]))}
  (^java.time.Clock
   [^java.time.Clock base-clock ^java.time.Duration tick-duration]
   (java.time.Clock/tick base-clock tick-duration)))

(defn offset
  {:arglists (quote (["java.time.Clock" "java.time.Duration"]))}
  (^java.time.Clock
   [^java.time.Clock base-clock ^java.time.Duration offset-duration]
   (java.time.Clock/offset base-clock offset-duration)))

(defn system-utc
  {:arglists (quote ([]))}
  (^java.time.Clock [] (java.time.Clock/systemUTC)))

(defn system-default-zone
  {:arglists (quote ([]))}
  (^java.time.Clock [] (java.time.Clock/systemDefaultZone)))

(defn fixed
  {:arglists (quote (["java.time.Instant" "java.time.ZoneId"]))}
  (^java.time.Clock [^java.time.Instant fixed-instant ^java.time.ZoneId zone]
   (java.time.Clock/fixed fixed-instant zone)))

(defn tick-minutes
  {:arglists (quote (["java.time.ZoneId"]))}
  (^java.time.Clock [^java.time.ZoneId zone]
   (java.time.Clock/tickMinutes zone)))

(defn tick-seconds
  {:arglists (quote (["java.time.ZoneId"]))}
  (^java.time.Clock [^java.time.ZoneId zone]
   (java.time.Clock/tickSeconds zone)))

(defn millis
  {:arglists (quote (["java.time.Clock"]))}
  (^long [^java.time.Clock this] (.millis this)))

(defn with-zone
  {:arglists (quote (["java.time.Clock" "java.time.ZoneId"]))}
  (^java.time.Clock [^java.time.Clock this ^java.time.ZoneId zone]
   (.withZone this zone)))

(defn get-zone
  {:arglists (quote (["java.time.Clock"]))}
  (^java.time.ZoneId [^java.time.Clock this] (.getZone this)))

(defn hash-code
  {:arglists (quote (["java.time.Clock"]))}
  (^java.lang.Integer [^java.time.Clock this] (.hashCode this)))

(defn system
  {:arglists (quote (["java.time.ZoneId"]))}
  (^java.time.Clock [^java.time.ZoneId zone] (java.time.Clock/system zone)))

(defn instant
  {:arglists (quote (["java.time.Clock"]))}
  (^java.time.Instant [^java.time.Clock this] (.instant this)))

(defn equals
  {:arglists (quote (["java.time.Clock" "java.lang.Object"]))}
  (^java.lang.Boolean [^java.time.Clock this ^java.lang.Object obj]
   (.equals this obj)))
