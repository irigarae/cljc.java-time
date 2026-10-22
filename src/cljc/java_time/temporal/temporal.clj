(ns cljc.java-time.temporal.temporal
  (:refer-clojure :exclude [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import (java.time.temporal Temporal)))

(defn is-supported
  (^java.lang.Boolean [^java.time.temporal.Temporal this ^java.time.temporal.ChronoUnit unit]
   (.isSupported this unit)))

(defn minus
  (^java.time.temporal.Temporal [^java.time.temporal.Temporal this ^java.time.temporal.TemporalAmount amount]
   (.minus this amount))
  (^java.time.temporal.Temporal
   [^java.time.temporal.Temporal this ^long amount-to-subtract ^java.time.temporal.ChronoUnit unit]
   (.minus this amount-to-subtract unit)))

(defn plus
  (^java.time.temporal.Temporal [^java.time.temporal.Temporal this ^java.time.temporal.TemporalAmount amount]
   (.plus this amount))
  (^java.time.temporal.Temporal
   [^java.time.temporal.Temporal this ^long amount-to-add ^java.time.temporal.ChronoUnit unit]
   (.plus this amount-to-add unit)))

(defn until
  (^long
   [^java.time.temporal.Temporal this ^java.time.temporal.Temporal end-exclusive ^java.time.temporal.ChronoUnit unit]
   (.until this end-exclusive unit)))

(defn with
  (^java.time.temporal.Temporal [^java.time.temporal.Temporal this ^java.time.temporal.TemporalAdjuster adjuster]
   (.with this adjuster))
  (^java.time.temporal.Temporal
   [^java.time.temporal.Temporal this ^java.time.temporal.TemporalField field ^long new-value]
   (.with this field new-value)))
