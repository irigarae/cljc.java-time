(ns cljc.java-time.zone-offset
  (:refer-clojure :exclude [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [ZoneOffset]]))

(def max (goog.object/get java.time.ZoneOffset "MAX"))

(def min (goog.object/get java.time.ZoneOffset "MIN"))

(def utc (goog.object/get java.time.ZoneOffset "UTC"))

(defn range
  (^js/JSJoda.ValueRange [^js/JSJoda.ZoneOffset this ^js/JSJoda.TemporalField field]
   (.range this field)))

(defn of-total-seconds
  (^js/JSJoda.ZoneOffset [^int total-seconds]
   (js-invoke java.time.ZoneOffset "ofTotalSeconds" total-seconds)))

(defn of
  (^js/JSJoda.ZoneOffset [^java.lang.String offset-id]
   (js-invoke java.time.ZoneOffset "of" offset-id)))

(defn query
  (^java.lang.Object [^js/JSJoda.ZoneOffset this ^js/JSJoda.TemporalQuery query]
   (.query this query)))

(defn to-string
  (^java.lang.String [^js/JSJoda.ZoneOffset this]
   (.toString this)))

(defn get-long
  (^long [^js/JSJoda.ZoneOffset this ^js/JSJoda.TemporalField field]
   (.getLong this field)))

(defn get-rules
  (^js/JSJoda.ZoneRules [^js/JSJoda.ZoneOffset this]
   (.rules this)))

(defn of-hours
  (^js/JSJoda.ZoneOffset [^int hours]
   (js-invoke java.time.ZoneOffset "ofHours" hours)))

(defn get-id
  (^java.lang.String [^js/JSJoda.ZoneOffset this]
   (.id this)))

(defn from
  (^js/JSJoda.ZoneOffset [^js/JSJoda.TemporalAccessor temporal]
   (js-invoke java.time.ZoneOffset "from" temporal)))

(defn of-hours-minutes-seconds
  (^js/JSJoda.ZoneOffset [^int hours ^int minutes ^int seconds]
   (js-invoke java.time.ZoneOffset "ofHoursMinutesSeconds" hours minutes seconds)))

(defn is-supported
  (^boolean [^js/JSJoda.ZoneOffset this ^js/JSJoda.TemporalField field]
   (.isSupported this field)))

(defn hash-code
  (^int [^js/JSJoda.ZoneOffset this]
   (.hashCode this)))

(defn get-total-seconds
  (^int [^js/JSJoda.ZoneOffset this]
   (.totalSeconds this)))

(defn adjust-into
  (^js/JSJoda.Temporal [^js/JSJoda.ZoneOffset this ^js/JSJoda.Temporal temporal]
   (.adjustInto this temporal)))

(defn of-hours-minutes
  (^js/JSJoda.ZoneOffset [^int hours ^int minutes]
   (js-invoke java.time.ZoneOffset "ofHoursMinutes" hours minutes)))

(defn compare-to
  (^int [^js/JSJoda.ZoneOffset this ^js/JSJoda.ZoneOffset other]
   (.compareTo this other)))

(defn get
  (^int [^js/JSJoda.ZoneOffset this ^js/JSJoda.TemporalField field]
   (.get this field)))

(defn equals
  (^boolean [^js/JSJoda.ZoneOffset this ^java.lang.Object obj]
   (.equals this obj)))
