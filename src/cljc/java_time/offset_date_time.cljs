(ns cljc.java-time.offset-date-time
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [OffsetDateTime]]))

(def min (goog.object/get java.time.OffsetDateTime "MIN"))

(def max (goog.object/get java.time.OffsetDateTime "MAX"))

(defn minus-minutes
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^long minutes]
   (.minusMinutes this minutes)))

(defn truncated-to
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.OffsetDateTime
   [^js/JSJoda.OffsetDateTime this ^js/JSJoda.TemporalUnit unit]
   (.truncatedTo this unit)))

(defn minus-weeks
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^long weeks]
   (.minusWeeks this weeks)))

(defn to-instant
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^js/JSJoda.Instant [^js/JSJoda.OffsetDateTime this] (.toInstant this)))

(defn plus-weeks
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^long weeks]
   (.plusWeeks this weeks)))

(defn range
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalField"]))}
  (^js/JSJoda.ValueRange
   [^js/JSJoda.OffsetDateTime this ^js/JSJoda.TemporalField field]
   (.range this field)))

(defn get-hour
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^int [^js/JSJoda.OffsetDateTime this] (.hour this)))

(defn at-zone-same-instant
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.ZoneId"]))}
  (^js/JSJoda.ZonedDateTime
   [^js/JSJoda.OffsetDateTime this ^js/JSJoda.ZoneId zone]
   (.atZoneSameInstant this zone)))

(defn minus-hours
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^long hours]
   (.minusHours this hours)))

(defn of
  {:arglists (quote (["java.time.LocalDateTime" "java.time.ZoneOffset"]
                     ["java.time.LocalDate" "java.time.LocalTime"
                      "java.time.ZoneOffset"]
                     ["int" "int" "int" "int" "int" "int" "int"
                      "java.time.ZoneOffset"]))}
  (^js/JSJoda.OffsetDateTime
   [^js/JSJoda.LocalDateTime date-time ^js/JSJoda.ZoneOffset offset]
   (js-invoke java.time.OffsetDateTime "of" date-time offset))
  (^js/JSJoda.OffsetDateTime
   [^js/JSJoda.LocalDate date ^js/JSJoda.LocalTime time
    ^js/JSJoda.ZoneOffset offset]
   (js-invoke java.time.OffsetDateTime "of" date time offset))
  (^js/JSJoda.OffsetDateTime
   [^int year ^int month ^int day-of-month ^int hour ^int minute ^int second
    ^int nano-of-second ^js/JSJoda.ZoneOffset offset]
   (js-invoke java.time.OffsetDateTime
              "of"
              year
              month
              day-of-month
              hour
              minute
              second
              nano-of-second
              offset)))

(defn with-month
  {:arglists (quote (["java.time.OffsetDateTime" "int"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^int month]
   (.withMonth this month)))

(defn is-equal
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.OffsetDateTime"]))}
  (^boolean [^js/JSJoda.OffsetDateTime this ^js/JSJoda.OffsetDateTime other]
   (.isEqual this other)))

(defn get-nano
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^int [^js/JSJoda.OffsetDateTime this] (.nano this)))

(defn to-offset-time
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^js/JSJoda.OffsetTime [^js/JSJoda.OffsetDateTime this] (.toOffsetTime this)))

(defn at-zone-similar-local
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.ZoneId"]))}
  (^js/JSJoda.ZonedDateTime
   [^js/JSJoda.OffsetDateTime this ^js/JSJoda.ZoneId zone]
   (.atZoneSimilarLocal this zone)))

(defn get-year
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^int [^js/JSJoda.OffsetDateTime this] (.year this)))

(defn minus-seconds
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^long seconds]
   (.minusSeconds this seconds)))

(defn get-second
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^int [^js/JSJoda.OffsetDateTime this] (.second this)))

(defn plus-nanos
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^long nanos]
   (.plusNanos this nanos)))

(defn get-day-of-year
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^int [^js/JSJoda.OffsetDateTime this] (.dayOfYear this)))

(defn plus
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalAmount"]
                     ["java.time.OffsetDateTime" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.OffsetDateTime
   [^js/JSJoda.OffsetDateTime this ^js/JSJoda.TemporalAmount amount-to-add]
   (.plus this amount-to-add))
  (^js/JSJoda.OffsetDateTime
   [^js/JSJoda.OffsetDateTime this ^long amount-to-add
    ^js/JSJoda.TemporalUnit unit]
   (.plus this amount-to-add unit)))

(defn time-line-order
  {:arglists (quote ([]))}
  (^java.util.Comparator []
   (js-invoke java.time.OffsetDateTime "timeLineOrder")))

(defn with-hour
  {:arglists (quote (["java.time.OffsetDateTime" "int"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^int hour]
   (.withHour this hour)))

(defn with-minute
  {:arglists (quote (["java.time.OffsetDateTime" "int"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^int minute]
   (.withMinute this minute)))

(defn plus-minutes
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^long minutes]
   (.plusMinutes this minutes)))

(defn query
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object
   [^js/JSJoda.OffsetDateTime this ^js/JSJoda.TemporalQuery query]
   (.query this query)))

(defn with-offset-same-instant
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.ZoneOffset"]))}
  (^js/JSJoda.OffsetDateTime
   [^js/JSJoda.OffsetDateTime this ^js/JSJoda.ZoneOffset offset]
   (.withOffsetSameInstant this offset)))

(defn get-day-of-week
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^js/JSJoda.DayOfWeek [^js/JSJoda.OffsetDateTime this] (.dayOfWeek this)))

(defn to-string
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.lang.String [^js/JSJoda.OffsetDateTime this] (.toString this)))

(defn plus-months
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^long months]
   (.plusMonths this months)))

(defn is-before
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.OffsetDateTime"]))}
  (^boolean [^js/JSJoda.OffsetDateTime this ^js/JSJoda.OffsetDateTime other]
   (.isBefore this other)))

(defn minus-months
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^long months]
   (.minusMonths this months)))

(defn minus
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalAmount"]
                     ["java.time.OffsetDateTime" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.OffsetDateTime
   [^js/JSJoda.OffsetDateTime this ^js/JSJoda.TemporalAmount amount-to-subtract]
   (.minus this amount-to-subtract))
  (^js/JSJoda.OffsetDateTime
   [^js/JSJoda.OffsetDateTime this ^long amount-to-subtract
    ^js/JSJoda.TemporalUnit unit]
   (.minus this amount-to-subtract unit)))

(defn plus-hours
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^long hours]
   (.plusHours this hours)))

(defn plus-days
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^long days]
   (.plusDays this days)))

(defn to-local-time
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^js/JSJoda.LocalTime [^js/JSJoda.OffsetDateTime this] (.toLocalTime this)))

(defn get-long
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalField"]))}
  (^long [^js/JSJoda.OffsetDateTime this ^js/JSJoda.TemporalField field]
   (.getLong this field)))

(defn get-offset
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^js/JSJoda.ZoneOffset [^js/JSJoda.OffsetDateTime this] (.offset this)))

(defn to-zoned-date-time
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^js/JSJoda.ZonedDateTime [^js/JSJoda.OffsetDateTime this]
   (.toZonedDateTime this)))

(defn with-year
  {:arglists (quote (["java.time.OffsetDateTime" "int"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^int year]
   (.withYear this year)))

(defn with-nano
  {:arglists (quote (["java.time.OffsetDateTime" "int"]))}
  (^js/JSJoda.OffsetDateTime
   [^js/JSJoda.OffsetDateTime this ^int nano-of-second]
   (.withNano this nano-of-second)))

(defn to-epoch-second
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^long [^js/JSJoda.OffsetDateTime this] (.toEpochSecond this)))

(defn until
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.temporal.Temporal"
                      "java.time.temporal.TemporalUnit"]))}
  (^long
   [^js/JSJoda.OffsetDateTime this ^js/JSJoda.Temporal end-exclusive
    ^js/JSJoda.TemporalUnit unit]
   (.until this end-exclusive unit)))

(defn with-offset-same-local
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.ZoneOffset"]))}
  (^js/JSJoda.OffsetDateTime
   [^js/JSJoda.OffsetDateTime this ^js/JSJoda.ZoneOffset offset]
   (.withOffsetSameLocal this offset)))

(defn with-day-of-month
  {:arglists (quote (["java.time.OffsetDateTime" "int"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^int day-of-month]
   (.withDayOfMonth this day-of-month)))

(defn get-day-of-month
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^int [^js/JSJoda.OffsetDateTime this] (.dayOfMonth this)))

(defn from
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.TemporalAccessor temporal]
   (js-invoke java.time.OffsetDateTime "from" temporal)))

(defn is-after
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.OffsetDateTime"]))}
  (^boolean [^js/JSJoda.OffsetDateTime this ^js/JSJoda.OffsetDateTime other]
   (.isAfter this other)))

(defn minus-nanos
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^long nanos]
   (.minusNanos this nanos)))

(defn is-supported
  {:arglists
     (quote (["java.time.OffsetDateTime" "java.time.temporal.TemporalField"]
             ["java.time.OffsetDateTime" "java.time.temporal.TemporalUnit"]))}
  (^boolean [this arg0] (.isSupported ^js/JSJoda.OffsetDateTime this arg0)))

(defn minus-years
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^long years]
   (.minusYears this years)))

(defn parse
  {:arglists (quote (["java.lang.CharSequence"]
                     ["java.lang.CharSequence"
                      "java.time.format.DateTimeFormatter"]))}
  (^js/JSJoda.OffsetDateTime [^java.lang.CharSequence text]
   (js-invoke java.time.OffsetDateTime "parse" text))
  (^js/JSJoda.OffsetDateTime
   [^java.lang.CharSequence text ^js/JSJoda.DateTimeFormatter formatter]
   (js-invoke java.time.OffsetDateTime "parse" text formatter)))

(defn with-second
  {:arglists (quote (["java.time.OffsetDateTime" "int"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^int second]
   (.withSecond this second)))

(defn to-local-date
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^js/JSJoda.LocalDate [^js/JSJoda.OffsetDateTime this] (.toLocalDate this)))

(defn get-minute
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^int [^js/JSJoda.OffsetDateTime this] (.minute this)))

(defn hash-code
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^int [^js/JSJoda.OffsetDateTime this] (.hashCode this)))

(defn adjust-into
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Temporal
   [^js/JSJoda.OffsetDateTime this ^js/JSJoda.Temporal temporal]
   (.adjustInto this temporal)))

(defn with
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalAdjuster"]
                     ["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalField" "long"]))}
  (^js/JSJoda.OffsetDateTime
   [^js/JSJoda.OffsetDateTime this ^js/JSJoda.TemporalAdjuster adjuster]
   (.with this adjuster))
  (^js/JSJoda.OffsetDateTime
   [^js/JSJoda.OffsetDateTime this ^js/JSJoda.TemporalField field
    ^long new-value]
   (.with this field new-value)))

(defn now
  {:arglists (quote ([] ["java.time.Clock"] ["java.time.ZoneId"]))}
  (^js/JSJoda.OffsetDateTime [] (js-invoke java.time.OffsetDateTime "now"))
  (^js/JSJoda.OffsetDateTime [arg0]
   (js-invoke java.time.OffsetDateTime "now" arg0)))

(defn to-local-date-time
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^js/JSJoda.LocalDateTime [^js/JSJoda.OffsetDateTime this]
   (.toLocalDateTime this)))

(defn get-month-value
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^int [^js/JSJoda.OffsetDateTime this] (.monthValue this)))

(defn with-day-of-year
  {:arglists (quote (["java.time.OffsetDateTime" "int"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^int day-of-year]
   (.withDayOfYear this day-of-year)))

(defn compare-to
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.OffsetDateTime"]))}
  (^int [^js/JSJoda.OffsetDateTime this ^js/JSJoda.OffsetDateTime other]
   (.compareTo this other)))

(defn get-month
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^js/JSJoda.Month [^js/JSJoda.OffsetDateTime this] (.month this)))

(defn of-instant
  {:arglists (quote (["java.time.Instant" "java.time.ZoneId"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.Instant instant ^js/JSJoda.ZoneId zone]
   (js-invoke java.time.OffsetDateTime "ofInstant" instant zone)))

(defn plus-seconds
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^long seconds]
   (.plusSeconds this seconds)))

(defn get
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalField"]))}
  (^int [^js/JSJoda.OffsetDateTime this ^js/JSJoda.TemporalField field]
   (.get this field)))

(defn equals
  {:arglists (quote (["java.time.OffsetDateTime" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.OffsetDateTime this ^java.lang.Object obj]
   (.equals this obj)))

(defn format
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.lang.String
   [^js/JSJoda.OffsetDateTime this ^js/JSJoda.DateTimeFormatter formatter]
   (.format this formatter)))

(defn plus-years
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^long years]
   (.plusYears this years)))

(defn minus-days
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^js/JSJoda.OffsetDateTime [^js/JSJoda.OffsetDateTime this ^long days]
   (.minusDays this days)))
