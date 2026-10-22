(ns cljc.java-time.zone-offset
  (:refer-clojure :exclude [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import (java.time ZoneOffset)))

(def max java.time.ZoneOffset/MAX)

(def min java.time.ZoneOffset/MIN)

(def utc java.time.ZoneOffset/UTC)

(defn range
  (^java.time.temporal.ValueRange [^java.time.ZoneOffset this ^java.time.temporal.TemporalField field]
   (.range this field)))

(defn of-total-seconds
  (^java.time.ZoneOffset [^java.lang.Integer total-seconds]
   (java.time.ZoneOffset/ofTotalSeconds total-seconds)))

(defn of
  (^java.time.ZoneOffset [^java.lang.String offset-id]
   (java.time.ZoneOffset/of offset-id)))

(defn query
  (^java.lang.Object [^java.time.ZoneOffset this ^java.time.temporal.TemporalQuery query]
   (.query this query)))

(defn to-string
  (^java.lang.String [^java.time.ZoneOffset this]
   (.toString this)))

(defn get-long
  (^long [^java.time.ZoneOffset this ^java.time.temporal.TemporalField field]
   (.getLong this field)))

(defn get-rules
  (^java.time.zone.ZoneRules [^java.time.ZoneOffset this]
   (.getRules this)))

(defn of-hours
  (^java.time.ZoneOffset [^java.lang.Integer hours]
   (java.time.ZoneOffset/ofHours hours)))

(defn get-id
  (^java.lang.String [^java.time.ZoneOffset this]
   (.getId this)))

(defn from
  (^java.time.ZoneOffset [^java.time.temporal.TemporalAccessor temporal]
   (java.time.ZoneOffset/from temporal)))

(defn of-hours-minutes-seconds
  (^java.time.ZoneOffset [^java.lang.Integer hours ^java.lang.Integer minutes ^java.lang.Integer seconds]
   (java.time.ZoneOffset/ofHoursMinutesSeconds hours minutes seconds)))

(defn is-supported
  (^java.lang.Boolean [^java.time.ZoneOffset this ^java.time.temporal.TemporalField field]
   (.isSupported this field)))

(defn hash-code
  (^java.lang.Integer [^java.time.ZoneOffset this]
   (.hashCode this)))

(defn get-total-seconds
  (^java.lang.Integer [^java.time.ZoneOffset this]
   (.getTotalSeconds this)))

(defn adjust-into
  (^java.time.temporal.Temporal [^java.time.ZoneOffset this ^java.time.temporal.Temporal temporal]
   (.adjustInto this temporal)))

(defn of-hours-minutes
  (^java.time.ZoneOffset [^java.lang.Integer hours ^java.lang.Integer minutes]
   (java.time.ZoneOffset/ofHoursMinutes hours minutes)))

(defn compare-to
  (^java.lang.Integer [^java.time.ZoneOffset this ^java.time.ZoneOffset other]
   (.compareTo this other)))

(defn get
  (^java.lang.Integer [^java.time.ZoneOffset this ^java.time.temporal.TemporalField field]
   (.get this field)))

(defn equals
  (^java.lang.Boolean [^java.time.ZoneOffset this ^java.lang.Object obj]
   (.equals this obj)))
