(ns cljc.java-time.temporal.temporal
  (:refer-clojure :exclude [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time.temporal :refer [Temporal]]))

(defn is-supported
  (^boolean [^js/JSJoda.Temporal this ^js/JSJoda.TemporalUnit unit]
   (.isSupported this unit)))

(defn minus
  (^js/JSJoda.Temporal [^js/JSJoda.Temporal this ^js/JSJoda.TemporalAmount amount]
   (.minus this amount))
  (^js/JSJoda.Temporal [^js/JSJoda.Temporal this ^long amount-to-subtract ^js/JSJoda.TemporalUnit unit]
   (.minus this amount-to-subtract unit)))

(defn plus
  (^js/JSJoda.Temporal [^js/JSJoda.Temporal this ^js/JSJoda.TemporalAmount amount]
   (.plus this amount))
  (^js/JSJoda.Temporal [^js/JSJoda.Temporal this ^long amount-to-add ^js/JSJoda.TemporalUnit unit]
   (.plus this amount-to-add unit)))

(defn until
  (^long [^js/JSJoda.Temporal this ^js/JSJoda.Temporal end-exclusive ^js/JSJoda.TemporalUnit unit]
   (.until this end-exclusive unit)))

(defn with
  (^js/JSJoda.Temporal [^js/JSJoda.Temporal this ^js/JSJoda.TemporalAdjuster adjuster]
   (.with this adjuster))
  (^js/JSJoda.Temporal [^js/JSJoda.Temporal this ^js/JSJoda.TemporalField field ^long new-value]
   (.with this field new-value)))
