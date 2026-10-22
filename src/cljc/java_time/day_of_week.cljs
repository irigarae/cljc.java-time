(ns cljc.java-time.day-of-week
  (:refer-clojure :exclude [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [DayOfWeek]]))

(def saturday (goog.object/get java.time.DayOfWeek "SATURDAY"))

(def thursday (goog.object/get java.time.DayOfWeek "THURSDAY"))

(def friday (goog.object/get java.time.DayOfWeek "FRIDAY"))

(def wednesday (goog.object/get java.time.DayOfWeek "WEDNESDAY"))

(def sunday (goog.object/get java.time.DayOfWeek "SUNDAY"))

(def monday (goog.object/get java.time.DayOfWeek "MONDAY"))

(def tuesday (goog.object/get java.time.DayOfWeek "TUESDAY"))

(defn range
  (^js/JSJoda.ValueRange [^js/JSJoda.DayOfWeek this ^js/JSJoda.TemporalField field]
   (.range this field)))

(defn values
  (^"java.lang.Class" []
   (js-invoke java.time.DayOfWeek "values")))

(defn value-of
  (^js/JSJoda.DayOfWeek [^java.lang.String name]
   (js-invoke java.time.DayOfWeek "valueOf" name)))

(defn of
  (^js/JSJoda.DayOfWeek [^int day-of-week]
   (js-invoke java.time.DayOfWeek "of" day-of-week)))

(defn plus
  (^js/JSJoda.DayOfWeek [^js/JSJoda.DayOfWeek this ^long days]
   (.plus this days)))

(defn query
  (^java.lang.Object [^js/JSJoda.DayOfWeek this ^js/JSJoda.TemporalQuery query]
   (.query this query)))

(defn minus
  (^js/JSJoda.DayOfWeek [^js/JSJoda.DayOfWeek this ^long days]
   (.minus this days)))

(defn get-display-name
  (^java.lang.String [^js/JSJoda.DayOfWeek this ^js/JSJoda.TextStyle style ^java.util.Locale locale]
   (.displayName this style locale)))

(defn get-value
  (^int [^js/JSJoda.DayOfWeek this]
   (.value this)))

(defn get-long
  (^long [^js/JSJoda.DayOfWeek this ^js/JSJoda.TemporalField field]
   (.getLong this field)))

(defn from
  (^js/JSJoda.DayOfWeek [^js/JSJoda.TemporalAccessor temporal]
   (js-invoke java.time.DayOfWeek "from" temporal)))

(defn is-supported
  (^boolean [^js/JSJoda.DayOfWeek this ^js/JSJoda.TemporalField field]
   (.isSupported this field)))

(defn adjust-into
  (^js/JSJoda.Temporal [^js/JSJoda.DayOfWeek this ^js/JSJoda.Temporal temporal]
   (.adjustInto this temporal)))

(defn get
  (^int [^js/JSJoda.DayOfWeek this ^js/JSJoda.TemporalField field]
   (.get this field)))
