(ns cljc.java-time.year-month
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time YearMonth]))

(defn length-of-year
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.lang.Integer [^java.time.YearMonth this] (.lengthOfYear this)))

(defn range
  {:arglists (quote (["java.time.YearMonth"
                      "java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ValueRange
   [^java.time.YearMonth this ^java.time.temporal.TemporalField field]
   (.range this field)))

(defn is-valid-day
  {:arglists (quote (["java.time.YearMonth" "int"]))}
  (^java.lang.Boolean
   [^java.time.YearMonth this ^java.lang.Integer day-of-month]
   (.isValidDay this day-of-month)))

(defn of
  {:arglists (quote (["int" "int"] ["int" "java.time.Month"]))}
  (^java.time.YearMonth [arg0 arg1]
   (clojure.core/cond
     (clojure.core/and (clojure.core/instance? java.lang.Number arg0)
                       (clojure.core/instance? java.lang.Number arg1))
       (clojure.core/let [year (clojure.core/int arg0)
                          month (clojure.core/int arg1)]
         (java.time.YearMonth/of year month))
     (clojure.core/and (clojure.core/instance? java.lang.Number arg0)
                       (clojure.core/instance? java.time.Month arg1))
       (clojure.core/let [year (clojure.core/int arg0)
                          month ^"java.time.Month" arg1]
         (java.time.YearMonth/of year month))
     :else (throw (java.lang.IllegalArgumentException.
                    "no corresponding java.time method with these args")))))

(defn with-month
  {:arglists (quote (["java.time.YearMonth" "int"]))}
  (^java.time.YearMonth [^java.time.YearMonth this ^java.lang.Integer month]
   (.withMonth this month)))

(defn at-day
  {:arglists (quote (["java.time.YearMonth" "int"]))}
  (^java.time.LocalDate
   [^java.time.YearMonth this ^java.lang.Integer day-of-month]
   (.atDay this day-of-month)))

(defn get-year
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.lang.Integer [^java.time.YearMonth this] (.getYear this)))

(defn plus
  {:arglists (quote (["java.time.YearMonth" "java.time.temporal.TemporalAmount"]
                     ["java.time.YearMonth" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.YearMonth
   [^java.time.YearMonth this ^java.time.temporal.TemporalAmount amount-to-add]
   (.plus this amount-to-add))
  (^java.time.YearMonth
   [^java.time.YearMonth this ^long amount-to-add
    ^java.time.temporal.ChronoUnit unit]
   (.plus this amount-to-add unit)))

(defn is-leap-year
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.lang.Boolean [^java.time.YearMonth this] (.isLeapYear this)))

(defn query
  {:arglists (quote (["java.time.YearMonth"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object
   [^java.time.YearMonth this ^java.time.temporal.TemporalQuery query]
   (.query this query)))

(defn to-string
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.lang.String [^java.time.YearMonth this] (.toString this)))

(defn plus-months
  {:arglists (quote (["java.time.YearMonth" "long"]))}
  (^java.time.YearMonth [^java.time.YearMonth this ^long months-to-add]
   (.plusMonths this months-to-add)))

(defn is-before
  {:arglists (quote (["java.time.YearMonth" "java.time.YearMonth"]))}
  (^java.lang.Boolean [^java.time.YearMonth this ^java.time.YearMonth other]
   (.isBefore this other)))

(defn minus-months
  {:arglists (quote (["java.time.YearMonth" "long"]))}
  (^java.time.YearMonth [^java.time.YearMonth this ^long months-to-subtract]
   (.minusMonths this months-to-subtract)))

(defn minus
  {:arglists (quote (["java.time.YearMonth" "java.time.temporal.TemporalAmount"]
                     ["java.time.YearMonth" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.YearMonth
   [^java.time.YearMonth this
    ^java.time.temporal.TemporalAmount amount-to-subtract]
   (.minus this amount-to-subtract))
  (^java.time.YearMonth
   [^java.time.YearMonth this ^long amount-to-subtract
    ^java.time.temporal.ChronoUnit unit]
   (.minus this amount-to-subtract unit)))

(defn get-long
  {:arglists (quote (["java.time.YearMonth"
                      "java.time.temporal.TemporalField"]))}
  (^long [^java.time.YearMonth this ^java.time.temporal.TemporalField field]
   (.getLong this field)))

(defn with-year
  {:arglists (quote (["java.time.YearMonth" "int"]))}
  (^java.time.YearMonth [^java.time.YearMonth this ^java.lang.Integer year]
   (.withYear this year)))

(defn at-end-of-month
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.time.LocalDate [^java.time.YearMonth this] (.atEndOfMonth this)))

(defn length-of-month
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.lang.Integer [^java.time.YearMonth this] (.lengthOfMonth this)))

(defn until
  {:arglists (quote (["java.time.YearMonth" "java.time.temporal.Temporal"
                      "java.time.temporal.TemporalUnit"]))}
  (^long
   [^java.time.YearMonth this ^java.time.temporal.Temporal end-exclusive
    ^java.time.temporal.ChronoUnit unit]
   (.until this end-exclusive unit)))

(defn from
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^java.time.YearMonth [^java.time.temporal.TemporalAccessor temporal]
   (java.time.YearMonth/from temporal)))

(defn is-after
  {:arglists (quote (["java.time.YearMonth" "java.time.YearMonth"]))}
  (^java.lang.Boolean [^java.time.YearMonth this ^java.time.YearMonth other]
   (.isAfter this other)))

(defn is-supported
  {:arglists (quote (["java.time.YearMonth" "java.time.temporal.TemporalField"]
                     ["java.time.YearMonth"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.lang.Boolean [this arg0]
   (clojure.core/cond
     (clojure.core/and (clojure.core/instance? java.time.temporal.TemporalField
                                               arg0))
       (clojure.core/let [field ^"java.time.temporal.TemporalField" arg0]
         (.isSupported ^java.time.YearMonth this field))
     (clojure.core/and (clojure.core/instance? java.time.temporal.ChronoUnit
                                               arg0))
       (clojure.core/let [unit ^"java.time.temporal.ChronoUnit" arg0]
         (.isSupported ^java.time.YearMonth this unit))
     :else (throw (java.lang.IllegalArgumentException.
                    "no corresponding java.time method with these args")))))

(defn minus-years
  {:arglists (quote (["java.time.YearMonth" "long"]))}
  (^java.time.YearMonth [^java.time.YearMonth this ^long years-to-subtract]
   (.minusYears this years-to-subtract)))

(defn parse
  {:arglists (quote (["java.lang.CharSequence"]
                     ["java.lang.CharSequence"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.time.YearMonth [^java.lang.CharSequence text]
   (java.time.YearMonth/parse text))
  (^java.time.YearMonth
   [^java.lang.CharSequence text ^java.time.format.DateTimeFormatter formatter]
   (java.time.YearMonth/parse text formatter)))

(defn hash-code
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.lang.Integer [^java.time.YearMonth this] (.hashCode this)))

(defn adjust-into
  {:arglists (quote (["java.time.YearMonth" "java.time.temporal.Temporal"]))}
  (^java.time.temporal.Temporal
   [^java.time.YearMonth this ^java.time.temporal.Temporal temporal]
   (.adjustInto this temporal)))

(defn with
  {:arglists (quote (["java.time.YearMonth"
                      "java.time.temporal.TemporalAdjuster"]
                     ["java.time.YearMonth" "java.time.temporal.TemporalField"
                      "long"]))}
  (^java.time.YearMonth
   [^java.time.YearMonth this ^java.time.temporal.TemporalAdjuster adjuster]
   (.with this adjuster))
  (^java.time.YearMonth
   [^java.time.YearMonth this ^java.time.temporal.TemporalField field
    ^long new-value]
   (.with this field new-value)))

(defn now
  {:arglists (quote ([] ["java.time.Clock"] ["java.time.ZoneId"]))}
  (^java.time.YearMonth [] (java.time.YearMonth/now))
  (^java.time.YearMonth [arg0]
   (clojure.core/cond
     (clojure.core/and (clojure.core/instance? java.time.Clock arg0))
       (clojure.core/let [clock ^"java.time.Clock" arg0]
         (java.time.YearMonth/now clock))
     (clojure.core/and (clojure.core/instance? java.time.ZoneId arg0))
       (clojure.core/let [zone ^"java.time.ZoneId" arg0]
         (java.time.YearMonth/now zone))
     :else (throw (java.lang.IllegalArgumentException.
                    "no corresponding java.time method with these args")))))

(defn get-month-value
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.lang.Integer [^java.time.YearMonth this] (.getMonthValue this)))

(defn compare-to
  {:arglists (quote (["java.time.YearMonth" "java.time.YearMonth"]))}
  (^java.lang.Integer [^java.time.YearMonth this ^java.time.YearMonth other]
   (.compareTo this other)))

(defn get-month
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.time.Month [^java.time.YearMonth this] (.getMonth this)))

(defn get
  {:arglists (quote (["java.time.YearMonth"
                      "java.time.temporal.TemporalField"]))}
  (^java.lang.Integer
   [^java.time.YearMonth this ^java.time.temporal.TemporalField field]
   (.get this field)))

(defn equals
  {:arglists (quote (["java.time.YearMonth" "java.lang.Object"]))}
  (^java.lang.Boolean [^java.time.YearMonth this ^java.lang.Object obj]
   (.equals this obj)))

(defn format
  {:arglists (quote (["java.time.YearMonth"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.lang.String
   [^java.time.YearMonth this ^java.time.format.DateTimeFormatter formatter]
   (.format this formatter)))

(defn plus-years
  {:arglists (quote (["java.time.YearMonth" "long"]))}
  (^java.time.YearMonth [^java.time.YearMonth this ^long years-to-add]
   (.plusYears this years-to-add)))
