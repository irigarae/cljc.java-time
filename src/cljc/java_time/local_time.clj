(ns cljc.java-time.local-time
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time LocalTime]))

(def max java.time.LocalTime/MAX)

(def noon java.time.LocalTime/NOON)

(def midnight java.time.LocalTime/MIDNIGHT)

(def min java.time.LocalTime/MIN)

(defn minus-minutes
  "Returns a copy of this {@code LocalTime} with the specified number of minutes subtracted.\n <p>\n This subtracts the specified number of minutes from this time, returning a new time.\n The calculation wraps around midnight.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param minutesToSubtract  the minutes to subtract, may be negative\n @return a {@code LocalTime} based on this time with the minutes subtracted, not null"
  {:arglists (quote (["java.time.LocalTime" "long"]))}
  (^java.time.LocalTime [^java.time.LocalTime this ^long minutes-to-subtract]
   (.minusMinutes this minutes-to-subtract)))

(defn truncated-to
  "Returns a copy of this {@code LocalTime} with the time truncated.\n <p>\n Truncation returns a copy of the original time with fields\n smaller than the specified unit set to zero.\n For example, truncating with the {@link ChronoUnit#MINUTES minutes} unit\n will set the second-of-minute and nano-of-second field to zero.\n <p>\n The unit must have a {@linkplain TemporalUnit#getDuration() duration}\n that divides into the length of a standard day without remainder.\n This includes all supplied time units on {@link ChronoUnit} and\n {@link ChronoUnit#DAYS DAYS}. Other units throw an exception.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param unit  the unit to truncate to, not null\n @return a {@code LocalTime} based on this time with the time truncated, not null\n @throws DateTimeException if unable to truncate\n @throws UnsupportedTemporalTypeException if the unit is not supported"
  {:arglists (quote (["java.time.LocalTime"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.LocalTime
   [^java.time.LocalTime this ^java.time.temporal.ChronoUnit unit]
   (.truncatedTo this unit)))

(defn range
  "Gets the range of valid values for the specified field.\n <p>\n The range object expresses the minimum and maximum valid values for a field.\n This time is used to enhance the accuracy of the returned range.\n If it is not possible to return the range, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return\n appropriate range instances.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)}\n passing {@code this} as the argument.\n Whether the range can be obtained is determined by the field.\n\n @param field  the field to query the range for, not null\n @return the range of valid values for the field, not null\n @throws DateTimeException if the range for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported"
  {:arglists (quote (["java.time.LocalTime"
                      "java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ValueRange
   [^java.time.LocalTime this ^java.time.temporal.TemporalField field]
   (.range this field)))

(defn get-hour
  "Gets the hour-of-day field.\n\n @return the hour-of-day, from 0 to 23"
  {:arglists (quote (["java.time.LocalTime"]))}
  (^java.lang.Integer [^java.time.LocalTime this] (.getHour this)))

(defn at-offset
  "Combines this time with an offset to create an {@code OffsetTime}.\n <p>\n This returns an {@code OffsetTime} formed from this time at the specified offset.\n All possible combinations of time and offset are valid.\n\n @param offset  the offset to combine with, not null\n @return the offset time formed from this time and the specified offset, not null"
  {:arglists (quote (["java.time.LocalTime" "java.time.ZoneOffset"]))}
  (^java.time.OffsetTime
   [^java.time.LocalTime this ^java.time.ZoneOffset offset]
   (.atOffset this offset)))

(defn minus-hours
  "Returns a copy of this {@code LocalTime} with the specified number of hours subtracted.\n <p>\n This subtracts the specified number of hours from this time, returning a new time.\n The calculation wraps around midnight.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param hoursToSubtract  the hours to subtract, may be negative\n @return a {@code LocalTime} based on this time with the hours subtracted, not null"
  {:arglists (quote (["java.time.LocalTime" "long"]))}
  (^java.time.LocalTime [^java.time.LocalTime this ^long hours-to-subtract]
   (.minusHours this hours-to-subtract)))

(defn of
  {:arglists (quote
               (["int" "int"] ["int" "int" "int"] ["int" "int" "int" "int"]))}
  (^java.time.LocalTime [^java.lang.Integer hour ^java.lang.Integer minute]
   (java.time.LocalTime/of hour minute))
  (^java.time.LocalTime
   [^java.lang.Integer hour ^java.lang.Integer minute ^java.lang.Integer second]
   (java.time.LocalTime/of hour minute second))
  (^java.time.LocalTime
   [^java.lang.Integer hour ^java.lang.Integer minute ^java.lang.Integer second
    ^java.lang.Integer nano-of-second]
   (java.time.LocalTime/of hour minute second nano-of-second)))

(defn get-nano
  "Gets the nano-of-second field.\n\n @return the nano-of-second, from 0 to 999,999,999"
  {:arglists (quote (["java.time.LocalTime"]))}
  (^java.lang.Integer [^java.time.LocalTime this] (.getNano this)))

(defn minus-seconds
  "Returns a copy of this {@code LocalTime} with the specified number of seconds subtracted.\n <p>\n This subtracts the specified number of seconds from this time, returning a new time.\n The calculation wraps around midnight.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param secondsToSubtract  the seconds to subtract, may be negative\n @return a {@code LocalTime} based on this time with the seconds subtracted, not null"
  {:arglists (quote (["java.time.LocalTime" "long"]))}
  (^java.time.LocalTime [^java.time.LocalTime this ^long seconds-to-subtract]
   (.minusSeconds this seconds-to-subtract)))

(defn get-second
  "Gets the second-of-minute field.\n\n @return the second-of-minute, from 0 to 59"
  {:arglists (quote (["java.time.LocalTime"]))}
  (^java.lang.Integer [^java.time.LocalTime this] (.getSecond this)))

(defn plus-nanos
  "Returns a copy of this {@code LocalTime} with the specified number of nanoseconds added.\n <p>\n This adds the specified number of nanoseconds to this time, returning a new time.\n The calculation wraps around midnight.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param nanosToAdd  the nanos to add, may be negative\n @return a {@code LocalTime} based on this time with the nanoseconds added, not null"
  {:arglists (quote (["java.time.LocalTime" "long"]))}
  (^java.time.LocalTime [^java.time.LocalTime this ^long nanos-to-add]
   (.plusNanos this nanos-to-add)))

(defn plus
  {:arglists (quote (["java.time.LocalTime" "java.time.temporal.TemporalAmount"]
                     ["java.time.LocalTime" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.LocalTime
   [^java.time.LocalTime this ^java.time.temporal.TemporalAmount amount-to-add]
   (.plus this amount-to-add))
  (^java.time.LocalTime
   [^java.time.LocalTime this ^long amount-to-add
    ^java.time.temporal.ChronoUnit unit]
   (.plus this amount-to-add unit)))

(defn with-hour
  "Returns a copy of this {@code LocalTime} with the hour-of-day altered.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param hour  the hour-of-day to set in the result, from 0 to 23\n @return a {@code LocalTime} based on this time with the requested hour, not null\n @throws DateTimeException if the hour value is invalid"
  {:arglists (quote (["java.time.LocalTime" "int"]))}
  (^java.time.LocalTime [^java.time.LocalTime this ^java.lang.Integer hour]
   (.withHour this hour)))

(defn with-minute
  "Returns a copy of this {@code LocalTime} with the minute-of-hour altered.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param minute  the minute-of-hour to set in the result, from 0 to 59\n @return a {@code LocalTime} based on this time with the requested minute, not null\n @throws DateTimeException if the minute value is invalid"
  {:arglists (quote (["java.time.LocalTime" "int"]))}
  (^java.time.LocalTime [^java.time.LocalTime this ^java.lang.Integer minute]
   (.withMinute this minute)))

(defn plus-minutes
  "Returns a copy of this {@code LocalTime} with the specified number of minutes added.\n <p>\n This adds the specified number of minutes to this time, returning a new time.\n The calculation wraps around midnight.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param minutesToAdd  the minutes to add, may be negative\n @return a {@code LocalTime} based on this time with the minutes added, not null"
  {:arglists (quote (["java.time.LocalTime" "long"]))}
  (^java.time.LocalTime [^java.time.LocalTime this ^long minutes-to-add]
   (.plusMinutes this minutes-to-add)))

(defn query
  "Queries this time using the specified query.\n <p>\n This queries this time using the specified query strategy object.\n The {@code TemporalQuery} object defines the logic to be used to\n obtain the result. Read the documentation of the query to understand\n what the result of this method will be.\n <p>\n The result of this method is obtained by invoking the\n {@link TemporalQuery#queryFrom(TemporalAccessor)} method on the\n specified query passing {@code this} as the argument.\n\n @param <R> the type of the result\n @param query  the query to invoke, not null\n @return the query result, null may be returned (defined by the query)\n @throws DateTimeException if unable to query (defined by the query)\n @throws ArithmeticException if numeric overflow occurs (defined by the query)"
  {:arglists (quote (["java.time.LocalTime"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object
   [^java.time.LocalTime this ^java.time.temporal.TemporalQuery query]
   (.query this query)))

(defn at-date
  "Combines this time with a date to create a {@code LocalDateTime}.\n <p>\n This returns a {@code LocalDateTime} formed from this time at the specified date.\n All possible combinations of date and time are valid.\n\n @param date  the date to combine with, not null\n @return the local date-time formed from this time and the specified date, not null"
  {:arglists (quote (["java.time.LocalTime" "java.time.LocalDate"]))}
  (^java.time.LocalDateTime
   [^java.time.LocalTime this ^java.time.LocalDate date]
   (.atDate this date)))

(defn to-string
  "Outputs this time as a {@code String}, such as {@code 10:15}.\n <p>\n The output will be one of the following ISO-8601 formats:\n <ul>\n <li>{@code HH:mm}</li>\n <li>{@code HH:mm:ss}</li>\n <li>{@code HH:mm:ss.SSS}</li>\n <li>{@code HH:mm:ss.SSSSSS}</li>\n <li>{@code HH:mm:ss.SSSSSSSSS}</li>\n </ul>\n The format used will be the shortest that outputs the full value of\n the time where the omitted parts are implied to be zero.\n\n @return a string representation of this time, not null"
  {:arglists (quote (["java.time.LocalTime"]))}
  (^java.lang.String [^java.time.LocalTime this] (.toString this)))

(defn is-before
  "Checks if this time is before the specified time.\n <p>\n The comparison is based on the time-line position of the time within a day.\n\n @param other  the other time to compare to, not null\n @return true if this point is before the specified time\n @throws NullPointerException if {@code other} is null"
  {:arglists (quote (["java.time.LocalTime" "java.time.LocalTime"]))}
  (^java.lang.Boolean [^java.time.LocalTime this ^java.time.LocalTime other]
   (.isBefore this other)))

(defn minus
  {:arglists (quote (["java.time.LocalTime" "java.time.temporal.TemporalAmount"]
                     ["java.time.LocalTime" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.LocalTime
   [^java.time.LocalTime this
    ^java.time.temporal.TemporalAmount amount-to-subtract]
   (.minus this amount-to-subtract))
  (^java.time.LocalTime
   [^java.time.LocalTime this ^long amount-to-subtract
    ^java.time.temporal.ChronoUnit unit]
   (.minus this amount-to-subtract unit)))

(defn plus-hours
  "Returns a copy of this {@code LocalTime} with the specified number of hours added.\n <p>\n This adds the specified number of hours to this time, returning a new time.\n The calculation wraps around midnight.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param hoursToAdd  the hours to add, may be negative\n @return a {@code LocalTime} based on this time with the hours added, not null"
  {:arglists (quote (["java.time.LocalTime" "long"]))}
  (^java.time.LocalTime [^java.time.LocalTime this ^long hours-to-add]
   (.plusHours this hours-to-add)))

(defn to-second-of-day
  "Extracts the time as seconds of day,\n from {@code 0} to {@code 24 * 60 * 60 - 1}.\n\n @return the second-of-day equivalent to this time"
  {:arglists (quote (["java.time.LocalTime"]))}
  (^java.lang.Integer [^java.time.LocalTime this] (.toSecondOfDay this)))

(defn get-long
  "Gets the value of the specified field from this time as a {@code long}.\n <p>\n This queries this time for the value of the specified field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return valid\n values based on this time.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.LocalTime"
                      "java.time.temporal.TemporalField"]))}
  (^long [^java.time.LocalTime this ^java.time.temporal.TemporalField field]
   (.getLong this field)))

(defn with-nano
  "Returns a copy of this {@code LocalTime} with the nano-of-second altered.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param nanoOfSecond  the nano-of-second to set in the result, from 0 to 999,999,999\n @return a {@code LocalTime} based on this time with the requested nanosecond, not null\n @throws DateTimeException if the nanos value is invalid"
  {:arglists (quote (["java.time.LocalTime" "int"]))}
  (^java.time.LocalTime
   [^java.time.LocalTime this ^java.lang.Integer nano-of-second]
   (.withNano this nano-of-second)))

(defn until
  "Calculates the amount of time until another time in terms of the specified unit.\n <p>\n This calculates the amount of time between two {@code LocalTime}\n objects in terms of a single {@code TemporalUnit}.\n The start and end points are {@code this} and the specified time.\n The result will be negative if the end is before the start.\n The {@code Temporal} passed to this method is converted to a\n {@code LocalTime} using {@link #from(TemporalAccessor)}.\n For example, the amount in hours between two times can be calculated\n using {@code startTime.until(endTime, HOURS)}.\n <p>\n The calculation returns a whole number, representing the number of\n complete units between the two times.\n For example, the amount in hours between 11:30 and 13:29 will only\n be one hour as it is one minute short of two hours.\n <p>\n There are two equivalent ways of using this method.\n The first is to invoke this method.\n The second is to use {@link TemporalUnit#between(Temporal, Temporal)}:\n <pre>\n   // these two lines are equivalent\n   amount = start.until(end, MINUTES);\n   amount = MINUTES.between(start, end);\n </pre>\n The choice should be made based on which makes the code more readable.\n <p>\n The calculation is implemented in this method for {@link ChronoUnit}.\n The units {@code NANOS}, {@code MICROS}, {@code MILLIS}, {@code SECONDS},\n {@code MINUTES}, {@code HOURS} and {@code HALF_DAYS} are supported.\n Other {@code ChronoUnit} values will throw an exception.\n <p>\n If the unit is not a {@code ChronoUnit}, then the result of this method\n is obtained by invoking {@code TemporalUnit.between(Temporal, Temporal)}\n passing {@code this} as the first argument and the converted input temporal\n as the second argument.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param endExclusive  the end time, exclusive, which is converted to a {@code LocalTime}, not null\n @param unit  the unit to measure the amount in, not null\n @return the amount of time between this time and the end time\n @throws DateTimeException if the amount cannot be calculated, or the end\n  temporal cannot be converted to a {@code LocalTime}\n @throws UnsupportedTemporalTypeException if the unit is not supported\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.LocalTime" "java.time.temporal.Temporal"
                      "java.time.temporal.TemporalUnit"]))}
  (^long
   [^java.time.LocalTime this ^java.time.temporal.Temporal end-exclusive
    ^java.time.temporal.ChronoUnit unit]
   (.until this end-exclusive unit)))

(defn of-nano-of-day
  "Obtains an instance of {@code LocalTime} from a nanos-of-day value.\n <p>\n This returns a {@code LocalTime} with the specified nanosecond-of-day.\n\n @param nanoOfDay  the nano of day, from {@code 0} to {@code 24 * 60 * 60 * 1,000,000,000 - 1}\n @return the local time, not null\n @throws DateTimeException if the nanos of day value is invalid"
  {:arglists (quote (["long"]))}
  (^java.time.LocalTime [^long nano-of-day]
   (java.time.LocalTime/ofNanoOfDay nano-of-day)))

(defn from
  "Obtains an instance of {@code LocalTime} from a temporal object.\n <p>\n This obtains a local time based on the specified temporal.\n A {@code TemporalAccessor} represents an arbitrary set of date and time information,\n which this factory converts to an instance of {@code LocalTime}.\n <p>\n The conversion uses the {@link TemporalQueries#localTime()} query, which relies\n on extracting the {@link ChronoField#NANO_OF_DAY NANO_OF_DAY} field.\n <p>\n This method matches the signature of the functional interface {@link TemporalQuery}\n allowing it to be used as a query via method reference, {@code LocalTime::from}.\n\n @param temporal  the temporal object to convert, not null\n @return the local time, not null\n @throws DateTimeException if unable to convert to a {@code LocalTime}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^java.time.LocalTime [^java.time.temporal.TemporalAccessor temporal]
   (java.time.LocalTime/from temporal)))

(defn is-after
  "Checks if this time is after the specified time.\n <p>\n The comparison is based on the time-line position of the time within a day.\n\n @param other  the other time to compare to, not null\n @return true if this is after the specified time\n @throws NullPointerException if {@code other} is null"
  {:arglists (quote (["java.time.LocalTime" "java.time.LocalTime"]))}
  (^java.lang.Boolean [^java.time.LocalTime this ^java.time.LocalTime other]
   (.isAfter this other)))

(defn minus-nanos
  "Returns a copy of this {@code LocalTime} with the specified number of nanoseconds subtracted.\n <p>\n This subtracts the specified number of nanoseconds from this time, returning a new time.\n The calculation wraps around midnight.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param nanosToSubtract  the nanos to subtract, may be negative\n @return a {@code LocalTime} based on this time with the nanoseconds subtracted, not null"
  {:arglists (quote (["java.time.LocalTime" "long"]))}
  (^java.time.LocalTime [^java.time.LocalTime this ^long nanos-to-subtract]
   (.minusNanos this nanos-to-subtract)))

(defn is-supported
  {:arglists (quote (["java.time.LocalTime" "java.time.temporal.TemporalField"]
                     ["java.time.LocalTime"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.lang.Boolean [this arg0]
   (clojure.core/cond
     (clojure.core/and (clojure.core/instance? java.time.temporal.TemporalField
                                               arg0))
       (clojure.core/let [field ^"java.time.temporal.TemporalField" arg0]
         (.isSupported ^java.time.LocalTime this field))
     (clojure.core/and (clojure.core/instance? java.time.temporal.ChronoUnit
                                               arg0))
       (clojure.core/let [unit ^"java.time.temporal.ChronoUnit" arg0]
         (.isSupported ^java.time.LocalTime this unit))
     :else (throw (java.lang.IllegalArgumentException.
                    "no corresponding java.time method with these args")))))

(defn parse
  {:arglists (quote (["java.lang.CharSequence"]
                     ["java.lang.CharSequence"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.time.LocalTime [^java.lang.CharSequence text]
   (java.time.LocalTime/parse text))
  (^java.time.LocalTime
   [^java.lang.CharSequence text ^java.time.format.DateTimeFormatter formatter]
   (java.time.LocalTime/parse text formatter)))

(defn with-second
  "Returns a copy of this {@code LocalTime} with the second-of-minute altered.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param second  the second-of-minute to set in the result, from 0 to 59\n @return a {@code LocalTime} based on this time with the requested second, not null\n @throws DateTimeException if the second value is invalid"
  {:arglists (quote (["java.time.LocalTime" "int"]))}
  (^java.time.LocalTime [^java.time.LocalTime this ^java.lang.Integer second]
   (.withSecond this second)))

(defn get-minute
  "Gets the minute-of-hour field.\n\n @return the minute-of-hour, from 0 to 59"
  {:arglists (quote (["java.time.LocalTime"]))}
  (^java.lang.Integer [^java.time.LocalTime this] (.getMinute this)))

(defn hash-code
  "A hash code for this time.\n\n @return a suitable hash code"
  {:arglists (quote (["java.time.LocalTime"]))}
  (^java.lang.Integer [^java.time.LocalTime this] (.hashCode this)))

(defn adjust-into
  "Adjusts the specified temporal object to have the same time as this object.\n <p>\n This returns a temporal object of the same observable type as the input\n with the time changed to be the same as this.\n <p>\n The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}\n passing {@link ChronoField#NANO_OF_DAY} as the field.\n <p>\n In most cases, it is clearer to reverse the calling pattern by using\n {@link Temporal#with(TemporalAdjuster)}:\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   temporal = thisLocalTime.adjustInto(temporal);\n   temporal = temporal.with(thisLocalTime);\n </pre>\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param temporal  the target object to be adjusted, not null\n @return the adjusted object, not null\n @throws DateTimeException if unable to make the adjustment\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.LocalTime" "java.time.temporal.Temporal"]))}
  (^java.time.temporal.Temporal
   [^java.time.LocalTime this ^java.time.temporal.Temporal temporal]
   (.adjustInto this temporal)))

(defn with
  {:arglists (quote (["java.time.LocalTime"
                      "java.time.temporal.TemporalAdjuster"]
                     ["java.time.LocalTime" "java.time.temporal.TemporalField"
                      "long"]))}
  (^java.time.LocalTime
   [^java.time.LocalTime this ^java.time.temporal.TemporalAdjuster adjuster]
   (.with this adjuster))
  (^java.time.LocalTime
   [^java.time.LocalTime this ^java.time.temporal.TemporalField field
    ^long new-value]
   (.with this field new-value)))

(defn now
  {:arglists (quote ([] ["java.time.Clock"] ["java.time.ZoneId"]))}
  (^java.time.LocalTime [] (java.time.LocalTime/now))
  (^java.time.LocalTime [arg0]
   (clojure.core/cond
     (clojure.core/and (clojure.core/instance? java.time.Clock arg0))
       (clojure.core/let [clock ^"java.time.Clock" arg0]
         (java.time.LocalTime/now clock))
     (clojure.core/and (clojure.core/instance? java.time.ZoneId arg0))
       (clojure.core/let [zone ^"java.time.ZoneId" arg0]
         (java.time.LocalTime/now zone))
     :else (throw (java.lang.IllegalArgumentException.
                    "no corresponding java.time method with these args")))))

(defn compare-to
  "Compares this time to another time.\n <p>\n The comparison is based on the time-line position of the local times within a day.\n It is \"consistent with equals\", as defined by {@link Comparable}.\n\n @param other  the other time to compare to, not null\n @return the comparator value, negative if less, positive if greater\n @throws NullPointerException if {@code other} is null"
  {:arglists (quote (["java.time.LocalTime" "java.time.LocalTime"]))}
  (^java.lang.Integer [^java.time.LocalTime this ^java.time.LocalTime other]
   (.compareTo this other)))

(defn to-nano-of-day
  "Extracts the time as nanos of day,\n from {@code 0} to {@code 24 * 60 * 60 * 1,000,000,000 - 1}.\n\n @return the nano of day equivalent to this time"
  {:arglists (quote (["java.time.LocalTime"]))}
  (^long [^java.time.LocalTime this] (.toNanoOfDay this)))

(defn plus-seconds
  "Returns a copy of this {@code LocalTime} with the specified number of seconds added.\n <p>\n This adds the specified number of seconds to this time, returning a new time.\n The calculation wraps around midnight.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param secondstoAdd  the seconds to add, may be negative\n @return a {@code LocalTime} based on this time with the seconds added, not null"
  {:arglists (quote (["java.time.LocalTime" "long"]))}
  (^java.time.LocalTime [^java.time.LocalTime this ^long secondsto-add]
   (.plusSeconds this secondsto-add)))

(defn get
  "Gets the value of the specified field from this time as an {@code int}.\n <p>\n This queries this time for the value of the specified field.\n The returned value will always be within the valid range of values for the field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return valid\n values based on this time, except {@code NANO_OF_DAY} and {@code MICRO_OF_DAY}\n which are too large to fit in an {@code int} and throw a {@code DateTimeException}.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained or\n         the value is outside the range of valid values for the field\n @throws UnsupportedTemporalTypeException if the field is not supported or\n         the range of values exceeds an {@code int}\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.LocalTime"
                      "java.time.temporal.TemporalField"]))}
  (^java.lang.Integer
   [^java.time.LocalTime this ^java.time.temporal.TemporalField field]
   (.get this field)))

(defn of-second-of-day
  "Obtains an instance of {@code LocalTime} from a second-of-day value.\n <p>\n This returns a {@code LocalTime} with the specified second-of-day.\n The nanosecond field will be set to zero.\n\n @param secondOfDay  the second-of-day, from {@code 0} to {@code 24 * 60 * 60 - 1}\n @return the local time, not null\n @throws DateTimeException if the second-of-day value is invalid"
  {:arglists (quote (["long"]))}
  (^java.time.LocalTime [^long second-of-day]
   (java.time.LocalTime/ofSecondOfDay second-of-day)))

(defn equals
  "Checks if this time is equal to another time.\n <p>\n The comparison is based on the time-line position of the time within a day.\n <p>\n Only objects of type {@code LocalTime} are compared, other types return false.\n To compare the date of two {@code TemporalAccessor} instances, use\n {@link ChronoField#NANO_OF_DAY} as a comparator.\n\n @param obj  the object to check, null returns false\n @return true if this is equal to the other time"
  {:arglists (quote (["java.time.LocalTime" "java.lang.Object"]))}
  (^java.lang.Boolean [^java.time.LocalTime this ^java.lang.Object obj]
   (.equals this obj)))

(defn format
  "Formats this time using the specified formatter.\n <p>\n This time will be passed to the formatter to produce a string.\n\n @param formatter  the formatter to use, not null\n @return the formatted time string, not null\n @throws DateTimeException if an error occurs during printing"
  {:arglists (quote (["java.time.LocalTime"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.lang.String
   [^java.time.LocalTime this ^java.time.format.DateTimeFormatter formatter]
   (.format this formatter)))
