(ns cljc.java-time.offset-time
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [OffsetTime]]))

(def min (goog.object/get java.time.OffsetTime "MIN"))

(def max (goog.object/get java.time.OffsetTime "MAX"))

(defn minus-minutes
  "Returns a copy of this {@code OffsetTime} with the specified number of minutes subtracted.\n <p>\n This subtracts the specified number of minutes from this time, returning a new time.\n The calculation wraps around midnight.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param minutes  the minutes to subtract, may be negative\n @return an {@code OffsetTime} based on this time with the minutes subtracted, not null"
  {:arglists (quote (["java.time.OffsetTime" "long"]))}
  (^js/JSJoda.OffsetTime [^js/JSJoda.OffsetTime this ^long minutes]
   (.minusMinutes this minutes)))

(defn truncated-to
  "Returns a copy of this {@code OffsetTime} with the time truncated.\n <p>\n Truncation returns a copy of the original time with fields\n smaller than the specified unit set to zero.\n For example, truncating with the {@link ChronoUnit#MINUTES minutes} unit\n will set the second-of-minute and nano-of-second field to zero.\n <p>\n The unit must have a {@linkplain TemporalUnit#getDuration() duration}\n that divides into the length of a standard day without remainder.\n This includes all supplied time units on {@link ChronoUnit} and\n {@link ChronoUnit#DAYS DAYS}. Other units throw an exception.\n <p>\n The offset does not affect the calculation and will be the same in the result.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param unit  the unit to truncate to, not null\n @return an {@code OffsetTime} based on this time with the time truncated, not null\n @throws DateTimeException if unable to truncate\n @throws UnsupportedTemporalTypeException if the unit is not supported"
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.OffsetTime
   [^js/JSJoda.OffsetTime this ^js/JSJoda.TemporalUnit unit]
   (.truncatedTo this unit)))

(defn range
  "Gets the range of valid values for the specified field.\n <p>\n The range object expresses the minimum and maximum valid values for a field.\n This time is used to enhance the accuracy of the returned range.\n If it is not possible to return the range, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return\n appropriate range instances.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)}\n passing {@code this} as the argument.\n Whether the range can be obtained is determined by the field.\n\n @param field  the field to query the range for, not null\n @return the range of valid values for the field, not null\n @throws DateTimeException if the range for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported"
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.temporal.TemporalField"]))}
  (^js/JSJoda.ValueRange
   [^js/JSJoda.OffsetTime this ^js/JSJoda.TemporalField field]
   (.range this field)))

(defn get-hour
  "Gets the hour-of-day field.\n\n @return the hour-of-day, from 0 to 23"
  {:arglists (quote (["java.time.OffsetTime"]))}
  (^int [^js/JSJoda.OffsetTime this] (.hour this)))

(defn minus-hours
  "Returns a copy of this {@code OffsetTime} with the specified number of hours subtracted.\n <p>\n This subtracts the specified number of hours from this time, returning a new time.\n The calculation wraps around midnight.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param hours  the hours to subtract, may be negative\n @return an {@code OffsetTime} based on this time with the hours subtracted, not null"
  {:arglists (quote (["java.time.OffsetTime" "long"]))}
  (^js/JSJoda.OffsetTime [^js/JSJoda.OffsetTime this ^long hours]
   (.minusHours this hours)))

(defn of
  {:arglists (quote (["java.time.LocalTime" "java.time.ZoneOffset"]
                     ["int" "int" "int" "int" "java.time.ZoneOffset"]))}
  (^js/JSJoda.OffsetTime
   [^js/JSJoda.LocalTime time ^js/JSJoda.ZoneOffset offset]
   (js-invoke java.time.OffsetTime "of" time offset))
  (^js/JSJoda.OffsetTime
   [^int hour ^int minute ^int second ^int nano-of-second
    ^js/JSJoda.ZoneOffset offset]
   (js-invoke java.time.OffsetTime
              "of"
              hour
              minute
              second
              nano-of-second
              offset)))

(defn is-equal
  "Checks if the instant of this {@code OffsetTime} is equal to that of the\n specified time applying both times to a common date.\n <p>\n This method differs from the comparison in {@link #compareTo} and {@link #equals}\n in that it only compares the instant of the time. This is equivalent to converting both\n times to an instant using the same date and comparing the instants.\n\n @param other  the other time to compare to, not null\n @return true if this is equal to the instant of the specified time"
  {:arglists (quote (["java.time.OffsetTime" "java.time.OffsetTime"]))}
  (^boolean [^js/JSJoda.OffsetTime this ^js/JSJoda.OffsetTime other]
   (.isEqual this other)))

(defn get-nano
  "Gets the nano-of-second field.\n\n @return the nano-of-second, from 0 to 999,999,999"
  {:arglists (quote (["java.time.OffsetTime"]))}
  (^int [^js/JSJoda.OffsetTime this] (.nano this)))

(defn minus-seconds
  "Returns a copy of this {@code OffsetTime} with the specified number of seconds subtracted.\n <p>\n This subtracts the specified number of seconds from this time, returning a new time.\n The calculation wraps around midnight.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param seconds  the seconds to subtract, may be negative\n @return an {@code OffsetTime} based on this time with the seconds subtracted, not null"
  {:arglists (quote (["java.time.OffsetTime" "long"]))}
  (^js/JSJoda.OffsetTime [^js/JSJoda.OffsetTime this ^long seconds]
   (.minusSeconds this seconds)))

(defn get-second
  "Gets the second-of-minute field.\n\n @return the second-of-minute, from 0 to 59"
  {:arglists (quote (["java.time.OffsetTime"]))}
  (^int [^js/JSJoda.OffsetTime this] (.second this)))

(defn plus-nanos
  "Returns a copy of this {@code OffsetTime} with the specified number of nanoseconds added.\n <p>\n This adds the specified number of nanoseconds to this time, returning a new time.\n The calculation wraps around midnight.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param nanos  the nanos to add, may be negative\n @return an {@code OffsetTime} based on this time with the nanoseconds added, not null"
  {:arglists (quote (["java.time.OffsetTime" "long"]))}
  (^js/JSJoda.OffsetTime [^js/JSJoda.OffsetTime this ^long nanos]
   (.plusNanos this nanos)))

(defn plus
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.temporal.TemporalAmount"]
                     ["java.time.OffsetTime" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.OffsetTime
   [^js/JSJoda.OffsetTime this ^js/JSJoda.TemporalAmount amount-to-add]
   (.plus this amount-to-add))
  (^js/JSJoda.OffsetTime
   [^js/JSJoda.OffsetTime this ^long amount-to-add ^js/JSJoda.TemporalUnit unit]
   (.plus this amount-to-add unit)))

(defn with-hour
  "Returns a copy of this {@code OffsetTime} with the hour-of-day altered.\n <p>\n The offset does not affect the calculation and will be the same in the result.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param hour  the hour-of-day to set in the result, from 0 to 23\n @return an {@code OffsetTime} based on this time with the requested hour, not null\n @throws DateTimeException if the hour value is invalid"
  {:arglists (quote (["java.time.OffsetTime" "int"]))}
  (^js/JSJoda.OffsetTime [^js/JSJoda.OffsetTime this ^int hour]
   (.withHour this hour)))

(defn with-minute
  "Returns a copy of this {@code OffsetTime} with the minute-of-hour altered.\n <p>\n The offset does not affect the calculation and will be the same in the result.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param minute  the minute-of-hour to set in the result, from 0 to 59\n @return an {@code OffsetTime} based on this time with the requested minute, not null\n @throws DateTimeException if the minute value is invalid"
  {:arglists (quote (["java.time.OffsetTime" "int"]))}
  (^js/JSJoda.OffsetTime [^js/JSJoda.OffsetTime this ^int minute]
   (.withMinute this minute)))

(defn plus-minutes
  "Returns a copy of this {@code OffsetTime} with the specified number of minutes added.\n <p>\n This adds the specified number of minutes to this time, returning a new time.\n The calculation wraps around midnight.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param minutes  the minutes to add, may be negative\n @return an {@code OffsetTime} based on this time with the minutes added, not null"
  {:arglists (quote (["java.time.OffsetTime" "long"]))}
  (^js/JSJoda.OffsetTime [^js/JSJoda.OffsetTime this ^long minutes]
   (.plusMinutes this minutes)))

(defn query
  "Queries this time using the specified query.\n <p>\n This queries this time using the specified query strategy object.\n The {@code TemporalQuery} object defines the logic to be used to\n obtain the result. Read the documentation of the query to understand\n what the result of this method will be.\n <p>\n The result of this method is obtained by invoking the\n {@link TemporalQuery#queryFrom(TemporalAccessor)} method on the\n specified query passing {@code this} as the argument.\n\n @param <R> the type of the result\n @param query  the query to invoke, not null\n @return the query result, null may be returned (defined by the query)\n @throws DateTimeException if unable to query (defined by the query)\n @throws ArithmeticException if numeric overflow occurs (defined by the query)"
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object [^js/JSJoda.OffsetTime this ^js/JSJoda.TemporalQuery query]
   (.query this query)))

(defn at-date
  "Combines this time with a date to create an {@code OffsetDateTime}.\n <p>\n This returns an {@code OffsetDateTime} formed from this time and the specified date.\n All possible combinations of date and time are valid.\n\n @param date  the date to combine with, not null\n @return the offset date-time formed from this time and the specified date, not null"
  {:arglists (quote (["java.time.OffsetTime" "java.time.LocalDate"]))}
  (^js/JSJoda.OffsetDateTime
   [^js/JSJoda.OffsetTime this ^js/JSJoda.LocalDate date]
   (.atDate this date)))

(defn with-offset-same-instant
  "Returns a copy of this {@code OffsetTime} with the specified offset ensuring\n that the result is at the same instant on an implied day.\n <p>\n This method returns an object with the specified {@code ZoneOffset} and a {@code LocalTime}\n adjusted by the difference between the two offsets.\n This will result in the old and new objects representing the same instant on an implied day.\n This is useful for finding the local time in a different offset.\n For example, if this time represents {@code 10:30+02:00} and the offset specified is\n {@code +03:00}, then this method will return {@code 11:30+03:00}.\n <p>\n To change the offset without adjusting the local time use {@link #withOffsetSameLocal}.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param offset  the zone offset to change to, not null\n @return an {@code OffsetTime} based on this time with the requested offset, not null"
  {:arglists (quote (["java.time.OffsetTime" "java.time.ZoneOffset"]))}
  (^js/JSJoda.OffsetTime
   [^js/JSJoda.OffsetTime this ^js/JSJoda.ZoneOffset offset]
   (.withOffsetSameInstant this offset)))

(defn to-string
  "Outputs this time as a {@code String}, such as {@code 10:15:30+01:00}.\n <p>\n The output will be one of the following ISO-8601 formats:\n <ul>\n <li>{@code HH:mmXXXXX}</li>\n <li>{@code HH:mm:ssXXXXX}</li>\n <li>{@code HH:mm:ss.SSSXXXXX}</li>\n <li>{@code HH:mm:ss.SSSSSSXXXXX}</li>\n <li>{@code HH:mm:ss.SSSSSSSSSXXXXX}</li>\n </ul>\n The format used will be the shortest that outputs the full value of\n the time where the omitted parts are implied to be zero.\n\n @return a string representation of this time, not null"
  {:arglists (quote (["java.time.OffsetTime"]))}
  (^java.lang.String [^js/JSJoda.OffsetTime this] (.toString this)))

(defn is-before
  "Checks if the instant of this {@code OffsetTime} is before that of the\n specified time applying both times to a common date.\n <p>\n This method differs from the comparison in {@link #compareTo} in that it\n only compares the instant of the time. This is equivalent to converting both\n times to an instant using the same date and comparing the instants.\n\n @param other  the other time to compare to, not null\n @return true if this is before the instant of the specified time"
  {:arglists (quote (["java.time.OffsetTime" "java.time.OffsetTime"]))}
  (^boolean [^js/JSJoda.OffsetTime this ^js/JSJoda.OffsetTime other]
   (.isBefore this other)))

(defn minus
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.temporal.TemporalAmount"]
                     ["java.time.OffsetTime" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.OffsetTime
   [^js/JSJoda.OffsetTime this ^js/JSJoda.TemporalAmount amount-to-subtract]
   (.minus this amount-to-subtract))
  (^js/JSJoda.OffsetTime
   [^js/JSJoda.OffsetTime this ^long amount-to-subtract
    ^js/JSJoda.TemporalUnit unit]
   (.minus this amount-to-subtract unit)))

(defn plus-hours
  "Returns a copy of this {@code OffsetTime} with the specified number of hours added.\n <p>\n This adds the specified number of hours to this time, returning a new time.\n The calculation wraps around midnight.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param hours  the hours to add, may be negative\n @return an {@code OffsetTime} based on this time with the hours added, not null"
  {:arglists (quote (["java.time.OffsetTime" "long"]))}
  (^js/JSJoda.OffsetTime [^js/JSJoda.OffsetTime this ^long hours]
   (.plusHours this hours)))

(defn to-local-time
  "Gets the {@code LocalTime} part of this date-time.\n <p>\n This returns a {@code LocalTime} with the same hour, minute, second and\n nanosecond as this date-time.\n\n @return the time part of this date-time, not null"
  {:arglists (quote (["java.time.OffsetTime"]))}
  (^js/JSJoda.LocalTime [^js/JSJoda.OffsetTime this] (.toLocalTime this)))

(defn get-long
  "Gets the value of the specified field from this time as a {@code long}.\n <p>\n This queries this time for the value of the specified field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return valid\n values based on this time.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.temporal.TemporalField"]))}
  (^long [^js/JSJoda.OffsetTime this ^js/JSJoda.TemporalField field]
   (.getLong this field)))

(defn get-offset
  "Gets the zone offset, such as '+01:00'.\n <p>\n This is the offset of the local time from UTC/Greenwich.\n\n @return the zone offset, not null"
  {:arglists (quote (["java.time.OffsetTime"]))}
  (^js/JSJoda.ZoneOffset [^js/JSJoda.OffsetTime this] (.offset this)))

(defn with-nano
  "Returns a copy of this {@code OffsetTime} with the nano-of-second altered.\n <p>\n The offset does not affect the calculation and will be the same in the result.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param nanoOfSecond  the nano-of-second to set in the result, from 0 to 999,999,999\n @return an {@code OffsetTime} based on this time with the requested nanosecond, not null\n @throws DateTimeException if the nanos value is invalid"
  {:arglists (quote (["java.time.OffsetTime" "int"]))}
  (^js/JSJoda.OffsetTime [^js/JSJoda.OffsetTime this ^int nano-of-second]
   (.withNano this nano-of-second)))

(defn until
  "Calculates the amount of time until another time in terms of the specified unit.\n <p>\n This calculates the amount of time between two {@code OffsetTime}\n objects in terms of a single {@code TemporalUnit}.\n The start and end points are {@code this} and the specified time.\n The result will be negative if the end is before the start.\n For example, the amount in hours between two times can be calculated\n using {@code startTime.until(endTime, HOURS)}.\n <p>\n The {@code Temporal} passed to this method is converted to a\n {@code OffsetTime} using {@link #from(TemporalAccessor)}.\n If the offset differs between the two times, then the specified\n end time is normalized to have the same offset as this time.\n <p>\n The calculation returns a whole number, representing the number of\n complete units between the two times.\n For example, the amount in hours between 11:30Z and 13:29Z will only\n be one hour as it is one minute short of two hours.\n <p>\n There are two equivalent ways of using this method.\n The first is to invoke this method.\n The second is to use {@link TemporalUnit#between(Temporal, Temporal)}:\n <pre>\n   // these two lines are equivalent\n   amount = start.until(end, MINUTES);\n   amount = MINUTES.between(start, end);\n </pre>\n The choice should be made based on which makes the code more readable.\n <p>\n The calculation is implemented in this method for {@link ChronoUnit}.\n The units {@code NANOS}, {@code MICROS}, {@code MILLIS}, {@code SECONDS},\n {@code MINUTES}, {@code HOURS} and {@code HALF_DAYS} are supported.\n Other {@code ChronoUnit} values will throw an exception.\n <p>\n If the unit is not a {@code ChronoUnit}, then the result of this method\n is obtained by invoking {@code TemporalUnit.between(Temporal, Temporal)}\n passing {@code this} as the first argument and the converted input temporal\n as the second argument.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param endExclusive  the end time, exclusive, which is converted to an {@code OffsetTime}, not null\n @param unit  the unit to measure the amount in, not null\n @return the amount of time between this time and the end time\n @throws DateTimeException if the amount cannot be calculated, or the end\n  temporal cannot be converted to an {@code OffsetTime}\n @throws UnsupportedTemporalTypeException if the unit is not supported\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.OffsetTime" "java.time.temporal.Temporal"
                      "java.time.temporal.TemporalUnit"]))}
  (^long
   [^js/JSJoda.OffsetTime this ^js/JSJoda.Temporal end-exclusive
    ^js/JSJoda.TemporalUnit unit]
   (.until this end-exclusive unit)))

(defn with-offset-same-local
  "Returns a copy of this {@code OffsetTime} with the specified offset ensuring\n that the result has the same local time.\n <p>\n This method returns an object with the same {@code LocalTime} and the specified {@code ZoneOffset}.\n No calculation is needed or performed.\n For example, if this time represents {@code 10:30+02:00} and the offset specified is\n {@code +03:00}, then this method will return {@code 10:30+03:00}.\n <p>\n To take into account the difference between the offsets, and adjust the time fields,\n use {@link #withOffsetSameInstant}.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param offset  the zone offset to change to, not null\n @return an {@code OffsetTime} based on this time with the requested offset, not null"
  {:arglists (quote (["java.time.OffsetTime" "java.time.ZoneOffset"]))}
  (^js/JSJoda.OffsetTime
   [^js/JSJoda.OffsetTime this ^js/JSJoda.ZoneOffset offset]
   (.withOffsetSameLocal this offset)))

(defn from
  "Obtains an instance of {@code OffsetTime} from a temporal object.\n <p>\n This obtains an offset time based on the specified temporal.\n A {@code TemporalAccessor} represents an arbitrary set of date and time information,\n which this factory converts to an instance of {@code OffsetTime}.\n <p>\n The conversion extracts and combines the {@code ZoneOffset} and the\n {@code LocalTime} from the temporal object.\n Implementations are permitted to perform optimizations such as accessing\n those fields that are equivalent to the relevant objects.\n <p>\n This method matches the signature of the functional interface {@link TemporalQuery}\n allowing it to be used as a query via method reference, {@code OffsetTime::from}.\n\n @param temporal  the temporal object to convert, not null\n @return the offset time, not null\n @throws DateTimeException if unable to convert to an {@code OffsetTime}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^js/JSJoda.OffsetTime [^js/JSJoda.TemporalAccessor temporal]
   (js-invoke java.time.OffsetTime "from" temporal)))

(defn is-after
  "Checks if the instant of this {@code OffsetTime} is after that of the\n specified time applying both times to a common date.\n <p>\n This method differs from the comparison in {@link #compareTo} in that it\n only compares the instant of the time. This is equivalent to converting both\n times to an instant using the same date and comparing the instants.\n\n @param other  the other time to compare to, not null\n @return true if this is after the instant of the specified time"
  {:arglists (quote (["java.time.OffsetTime" "java.time.OffsetTime"]))}
  (^boolean [^js/JSJoda.OffsetTime this ^js/JSJoda.OffsetTime other]
   (.isAfter this other)))

(defn minus-nanos
  "Returns a copy of this {@code OffsetTime} with the specified number of nanoseconds subtracted.\n <p>\n This subtracts the specified number of nanoseconds from this time, returning a new time.\n The calculation wraps around midnight.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param nanos  the nanos to subtract, may be negative\n @return an {@code OffsetTime} based on this time with the nanoseconds subtracted, not null"
  {:arglists (quote (["java.time.OffsetTime" "long"]))}
  (^js/JSJoda.OffsetTime [^js/JSJoda.OffsetTime this ^long nanos]
   (.minusNanos this nanos)))

(defn is-supported
  {:arglists (quote (["java.time.OffsetTime" "java.time.temporal.TemporalField"]
                     ["java.time.OffsetTime"
                      "java.time.temporal.TemporalUnit"]))}
  (^boolean [this arg0] (.isSupported ^js/JSJoda.OffsetTime this arg0)))

(defn parse
  {:arglists (quote (["java.lang.CharSequence"]
                     ["java.lang.CharSequence"
                      "java.time.format.DateTimeFormatter"]))}
  (^js/JSJoda.OffsetTime [^java.lang.CharSequence text]
   (js-invoke java.time.OffsetTime "parse" text))
  (^js/JSJoda.OffsetTime
   [^java.lang.CharSequence text ^js/JSJoda.DateTimeFormatter formatter]
   (js-invoke java.time.OffsetTime "parse" text formatter)))

(defn with-second
  "Returns a copy of this {@code OffsetTime} with the second-of-minute altered.\n <p>\n The offset does not affect the calculation and will be the same in the result.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param second  the second-of-minute to set in the result, from 0 to 59\n @return an {@code OffsetTime} based on this time with the requested second, not null\n @throws DateTimeException if the second value is invalid"
  {:arglists (quote (["java.time.OffsetTime" "int"]))}
  (^js/JSJoda.OffsetTime [^js/JSJoda.OffsetTime this ^int second]
   (.withSecond this second)))

(defn get-minute
  "Gets the minute-of-hour field.\n\n @return the minute-of-hour, from 0 to 59"
  {:arglists (quote (["java.time.OffsetTime"]))}
  (^int [^js/JSJoda.OffsetTime this] (.minute this)))

(defn hash-code
  "A hash code for this time.\n\n @return a suitable hash code"
  {:arglists (quote (["java.time.OffsetTime"]))}
  (^int [^js/JSJoda.OffsetTime this] (.hashCode this)))

(defn adjust-into
  "Adjusts the specified temporal object to have the same offset and time\n as this object.\n <p>\n This returns a temporal object of the same observable type as the input\n with the offset and time changed to be the same as this.\n <p>\n The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}\n twice, passing {@link ChronoField#NANO_OF_DAY} and\n {@link ChronoField#OFFSET_SECONDS} as the fields.\n <p>\n In most cases, it is clearer to reverse the calling pattern by using\n {@link Temporal#with(TemporalAdjuster)}:\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   temporal = thisOffsetTime.adjustInto(temporal);\n   temporal = temporal.with(thisOffsetTime);\n </pre>\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param temporal  the target object to be adjusted, not null\n @return the adjusted object, not null\n @throws DateTimeException if unable to make the adjustment\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.OffsetTime" "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Temporal [^js/JSJoda.OffsetTime this ^js/JSJoda.Temporal temporal]
   (.adjustInto this temporal)))

(defn with
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.temporal.TemporalAdjuster"]
                     ["java.time.OffsetTime" "java.time.temporal.TemporalField"
                      "long"]))}
  (^js/JSJoda.OffsetTime
   [^js/JSJoda.OffsetTime this ^js/JSJoda.TemporalAdjuster adjuster]
   (.with this adjuster))
  (^js/JSJoda.OffsetTime
   [^js/JSJoda.OffsetTime this ^js/JSJoda.TemporalField field ^long new-value]
   (.with this field new-value)))

(defn now
  {:arglists (quote ([] ["java.time.Clock"] ["java.time.ZoneId"]))}
  (^js/JSJoda.OffsetTime [] (js-invoke java.time.OffsetTime "now"))
  (^js/JSJoda.OffsetTime [arg0] (js-invoke java.time.OffsetTime "now" arg0)))

(defn compare-to
  "Compares this {@code OffsetTime} to another time.\n <p>\n The comparison is based first on the UTC equivalent instant, then on the local time.\n It is \"consistent with equals\", as defined by {@link Comparable}.\n <p>\n For example, the following is the comparator order:\n <ol>\n <li>{@code 10:30+01:00}</li>\n <li>{@code 11:00+01:00}</li>\n <li>{@code 12:00+02:00}</li>\n <li>{@code 11:30+01:00}</li>\n <li>{@code 12:00+01:00}</li>\n <li>{@code 12:30+01:00}</li>\n </ol>\n Values #2 and #3 represent the same instant on the time-line.\n When two values represent the same instant, the local time is compared\n to distinguish them. This step is needed to make the ordering\n consistent with {@code equals()}.\n <p>\n To compare the underlying local time of two {@code TemporalAccessor} instances,\n use {@link ChronoField#NANO_OF_DAY} as a comparator.\n\n @param other  the other time to compare to, not null\n @return the comparator value, negative if less, positive if greater\n @throws NullPointerException if {@code other} is null"
  {:arglists (quote (["java.time.OffsetTime" "java.time.OffsetTime"]))}
  (^int [^js/JSJoda.OffsetTime this ^js/JSJoda.OffsetTime other]
   (.compareTo this other)))

(defn of-instant
  "Obtains an instance of {@code OffsetTime} from an {@code Instant} and zone ID.\n <p>\n This creates an offset time with the same instant as that specified.\n Finding the offset from UTC/Greenwich is simple as there is only one valid\n offset for each instant.\n <p>\n The date component of the instant is dropped during the conversion.\n This means that the conversion can never fail due to the instant being\n out of the valid range of dates.\n\n @param instant  the instant to create the time from, not null\n @param zone  the time-zone, which may be an offset, not null\n @return the offset time, not null"
  {:arglists (quote (["java.time.Instant" "java.time.ZoneId"]))}
  (^js/JSJoda.OffsetTime [^js/JSJoda.Instant instant ^js/JSJoda.ZoneId zone]
   (js-invoke java.time.OffsetTime "ofInstant" instant zone)))

(defn plus-seconds
  "Returns a copy of this {@code OffsetTime} with the specified number of seconds added.\n <p>\n This adds the specified number of seconds to this time, returning a new time.\n The calculation wraps around midnight.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param seconds  the seconds to add, may be negative\n @return an {@code OffsetTime} based on this time with the seconds added, not null"
  {:arglists (quote (["java.time.OffsetTime" "long"]))}
  (^js/JSJoda.OffsetTime [^js/JSJoda.OffsetTime this ^long seconds]
   (.plusSeconds this seconds)))

(defn get
  "Gets the value of the specified field from this time as an {@code int}.\n <p>\n This queries this time for the value of the specified field.\n The returned value will always be within the valid range of values for the field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return valid\n values based on this time, except {@code NANO_OF_DAY} and {@code MICRO_OF_DAY}\n which are too large to fit in an {@code int} and throw a {@code DateTimeException}.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained or\n         the value is outside the range of valid values for the field\n @throws UnsupportedTemporalTypeException if the field is not supported or\n         the range of values exceeds an {@code int}\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.temporal.TemporalField"]))}
  (^int [^js/JSJoda.OffsetTime this ^js/JSJoda.TemporalField field]
   (.get this field)))

(defn equals
  "Checks if this time is equal to another time.\n <p>\n The comparison is based on the local-time and the offset.\n To compare for the same instant on the time-line, use {@link #isEqual(OffsetTime)}.\n <p>\n Only objects of type {@code OffsetTime} are compared, other types return false.\n To compare the underlying local time of two {@code TemporalAccessor} instances,\n use {@link ChronoField#NANO_OF_DAY} as a comparator.\n\n @param obj  the object to check, null returns false\n @return true if this is equal to the other time"
  {:arglists (quote (["java.time.OffsetTime" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.OffsetTime this ^java.lang.Object obj]
   (.equals this obj)))

(defn format
  "Formats this time using the specified formatter.\n <p>\n This time will be passed to the formatter to produce a string.\n\n @param formatter  the formatter to use, not null\n @return the formatted time string, not null\n @throws DateTimeException if an error occurs during printing"
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.lang.String
   [^js/JSJoda.OffsetTime this ^js/JSJoda.DateTimeFormatter formatter]
   (.format this formatter)))
