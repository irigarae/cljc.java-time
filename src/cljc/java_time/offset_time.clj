(ns cljc.java-time.offset-time
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time OffsetTime]))

(def min java.time.OffsetTime/MIN)

(def max java.time.OffsetTime/MAX)

(defn minus-minutes
  "Returns a copy of this {@code OffsetTime} with the specified number of minutes subtracted.

 This subtracts the specified number of minutes from this time, returning a new time.
 The calculation wraps around midnight.

 This instance is immutable and unaffected by this method call.

 @param minutes  the minutes to subtract, may be negative
 @return an {@code OffsetTime} based on this time with the minutes subtracted, not null"
  {:arglists (quote (["java.time.OffsetTime" "long"]))}
  (^java.time.OffsetTime [^java.time.OffsetTime this ^long minutes]
   (.minusMinutes this minutes)))

(defn truncated-to
  "Returns a copy of this {@code OffsetTime} with the time truncated.

 Truncation returns a copy of the original time with fields
 smaller than the specified unit set to zero.
 For example, truncating with the {@link ChronoUnit#MINUTES minutes} unit
 will set the second-of-minute and nano-of-second field to zero.

 The unit must have a {@linkplain TemporalUnit#getDuration() duration}
 that divides into the length of a standard day without remainder.
 This includes all supplied time units on {@link ChronoUnit} and
 {@link ChronoUnit#DAYS DAYS}. Other units throw an exception.

 The offset does not affect the calculation and will be the same in the result.

 This instance is immutable and unaffected by this method call.

 @param unit  the unit to truncate to, not null
 @return an {@code OffsetTime} based on this time with the time truncated, not null
 @throws DateTimeException if unable to truncate
 @throws UnsupportedTemporalTypeException if the unit is not supported"
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.OffsetTime
   [^java.time.OffsetTime this ^java.time.temporal.ChronoUnit unit]
   (.truncatedTo this unit)))

(defn range
  "Gets the range of valid values for the specified field.

 The range object expresses the minimum and maximum valid values for a field.
 This time is used to enhance the accuracy of the returned range.
 If it is not possible to return the range, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@link #isSupported(TemporalField) supported fields} will return
 appropriate range instances.
 All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.

 If the field is not a {@code ChronoField}, then the result of this method
 is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)}
 passing {@code this} as the argument.
 Whether the range can be obtained is determined by the field.

 @param field  the field to query the range for, not null
 @return the range of valid values for the field, not null
 @throws DateTimeException if the range for the field cannot be obtained
 @throws UnsupportedTemporalTypeException if the field is not supported"
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ValueRange
   [^java.time.OffsetTime this ^java.time.temporal.TemporalField field]
   (.range this field)))

(defn get-hour
  "Gets the hour-of-day field.

 @return the hour-of-day, from 0 to 23"
  {:arglists (quote (["java.time.OffsetTime"]))}
  (^java.lang.Integer [^java.time.OffsetTime this] (.getHour this)))

(defn minus-hours
  "Returns a copy of this {@code OffsetTime} with the specified number of hours subtracted.

 This subtracts the specified number of hours from this time, returning a new time.
 The calculation wraps around midnight.

 This instance is immutable and unaffected by this method call.

 @param hours  the hours to subtract, may be negative
 @return an {@code OffsetTime} based on this time with the hours subtracted, not null"
  {:arglists (quote (["java.time.OffsetTime" "long"]))}
  (^java.time.OffsetTime [^java.time.OffsetTime this ^long hours]
   (.minusHours this hours)))

(defn of
  {:arglists (quote (["java.time.LocalTime" "java.time.ZoneOffset"]
                     ["int" "int" "int" "int" "java.time.ZoneOffset"]))}
  (^java.time.OffsetTime
   [^java.time.LocalTime time ^java.time.ZoneOffset offset]
   (java.time.OffsetTime/of time offset))
  (^java.time.OffsetTime
   [^java.lang.Integer hour ^java.lang.Integer minute ^java.lang.Integer second
    ^java.lang.Integer nano-of-second ^java.time.ZoneOffset offset]
   (java.time.OffsetTime/of hour minute second nano-of-second offset)))

(defn is-equal
  "Checks if the instant of this {@code OffsetTime} is equal to that of the
 specified time applying both times to a common date.

 This method differs from the comparison in {@link #compareTo} and {@link #equals}
 in that it only compares the instant of the time. This is equivalent to converting both
 times to an instant using the same date and comparing the instants.

 @param other  the other time to compare to, not null
 @return true if this is equal to the instant of the specified time"
  {:arglists (quote (["java.time.OffsetTime" "java.time.OffsetTime"]))}
  (^java.lang.Boolean [^java.time.OffsetTime this ^java.time.OffsetTime other]
   (.isEqual this other)))

(defn get-nano
  "Gets the nano-of-second field.

 @return the nano-of-second, from 0 to 999,999,999"
  {:arglists (quote (["java.time.OffsetTime"]))}
  (^java.lang.Integer [^java.time.OffsetTime this] (.getNano this)))

(defn minus-seconds
  "Returns a copy of this {@code OffsetTime} with the specified number of seconds subtracted.

 This subtracts the specified number of seconds from this time, returning a new time.
 The calculation wraps around midnight.

 This instance is immutable and unaffected by this method call.

 @param seconds  the seconds to subtract, may be negative
 @return an {@code OffsetTime} based on this time with the seconds subtracted, not null"
  {:arglists (quote (["java.time.OffsetTime" "long"]))}
  (^java.time.OffsetTime [^java.time.OffsetTime this ^long seconds]
   (.minusSeconds this seconds)))

(defn get-second
  "Gets the second-of-minute field.

 @return the second-of-minute, from 0 to 59"
  {:arglists (quote (["java.time.OffsetTime"]))}
  (^java.lang.Integer [^java.time.OffsetTime this] (.getSecond this)))

(defn plus-nanos
  "Returns a copy of this {@code OffsetTime} with the specified number of nanoseconds added.

 This adds the specified number of nanoseconds to this time, returning a new time.
 The calculation wraps around midnight.

 This instance is immutable and unaffected by this method call.

 @param nanos  the nanos to add, may be negative
 @return an {@code OffsetTime} based on this time with the nanoseconds added, not null"
  {:arglists (quote (["java.time.OffsetTime" "long"]))}
  (^java.time.OffsetTime [^java.time.OffsetTime this ^long nanos]
   (.plusNanos this nanos)))

(defn plus
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.temporal.TemporalAmount"]
                     ["java.time.OffsetTime" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.OffsetTime
   [^java.time.OffsetTime this ^java.time.temporal.TemporalAmount amount-to-add]
   (.plus this amount-to-add))
  (^java.time.OffsetTime
   [^java.time.OffsetTime this ^long amount-to-add
    ^java.time.temporal.ChronoUnit unit]
   (.plus this amount-to-add unit)))

(defn with-hour
  "Returns a copy of this {@code OffsetTime} with the hour-of-day altered.

 The offset does not affect the calculation and will be the same in the result.

 This instance is immutable and unaffected by this method call.

 @param hour  the hour-of-day to set in the result, from 0 to 23
 @return an {@code OffsetTime} based on this time with the requested hour, not null
 @throws DateTimeException if the hour value is invalid"
  {:arglists (quote (["java.time.OffsetTime" "int"]))}
  (^java.time.OffsetTime [^java.time.OffsetTime this ^java.lang.Integer hour]
   (.withHour this hour)))

(defn with-minute
  "Returns a copy of this {@code OffsetTime} with the minute-of-hour altered.

 The offset does not affect the calculation and will be the same in the result.

 This instance is immutable and unaffected by this method call.

 @param minute  the minute-of-hour to set in the result, from 0 to 59
 @return an {@code OffsetTime} based on this time with the requested minute, not null
 @throws DateTimeException if the minute value is invalid"
  {:arglists (quote (["java.time.OffsetTime" "int"]))}
  (^java.time.OffsetTime [^java.time.OffsetTime this ^java.lang.Integer minute]
   (.withMinute this minute)))

(defn plus-minutes
  "Returns a copy of this {@code OffsetTime} with the specified number of minutes added.

 This adds the specified number of minutes to this time, returning a new time.
 The calculation wraps around midnight.

 This instance is immutable and unaffected by this method call.

 @param minutes  the minutes to add, may be negative
 @return an {@code OffsetTime} based on this time with the minutes added, not null"
  {:arglists (quote (["java.time.OffsetTime" "long"]))}
  (^java.time.OffsetTime [^java.time.OffsetTime this ^long minutes]
   (.plusMinutes this minutes)))

(defn query
  "Queries this time using the specified query.

 This queries this time using the specified query strategy object.
 The {@code TemporalQuery} object defines the logic to be used to
 obtain the result. Read the documentation of the query to understand
 what the result of this method will be.

 The result of this method is obtained by invoking the
 {@link TemporalQuery#queryFrom(TemporalAccessor)} method on the
 specified query passing {@code this} as the argument.

 @param <R> the type of the result
 @param query  the query to invoke, not null
 @return the query result, null may be returned (defined by the query)
 @throws DateTimeException if unable to query (defined by the query)
 @throws ArithmeticException if numeric overflow occurs (defined by the query)"
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object
   [^java.time.OffsetTime this ^java.time.temporal.TemporalQuery query]
   (.query this query)))

(defn at-date
  "Combines this time with a date to create an {@code OffsetDateTime}.

 This returns an {@code OffsetDateTime} formed from this time and the specified date.
 All possible combinations of date and time are valid.

 @param date  the date to combine with, not null
 @return the offset date-time formed from this time and the specified date, not null"
  {:arglists (quote (["java.time.OffsetTime" "java.time.LocalDate"]))}
  (^java.time.OffsetDateTime
   [^java.time.OffsetTime this ^java.time.LocalDate date]
   (.atDate this date)))

(defn with-offset-same-instant
  "Returns a copy of this {@code OffsetTime} with the specified offset ensuring
 that the result is at the same instant on an implied day.

 This method returns an object with the specified {@code ZoneOffset} and a {@code LocalTime}
 adjusted by the difference between the two offsets.
 This will result in the old and new objects representing the same instant on an implied day.
 This is useful for finding the local time in a different offset.
 For example, if this time represents {@code 10:30+02:00} and the offset specified is
 {@code +03:00}, then this method will return {@code 11:30+03:00}.

 To change the offset without adjusting the local time use {@link #withOffsetSameLocal}.

 This instance is immutable and unaffected by this method call.

 @param offset  the zone offset to change to, not null
 @return an {@code OffsetTime} based on this time with the requested offset, not null"
  {:arglists (quote (["java.time.OffsetTime" "java.time.ZoneOffset"]))}
  (^java.time.OffsetTime
   [^java.time.OffsetTime this ^java.time.ZoneOffset offset]
   (.withOffsetSameInstant this offset)))

(defn to-string
  "Outputs this time as a {@code String}, such as {@code 10:15:30+01:00}.

 The output will be one of the following ISO-8601 formats:
 <ul>
 <li>{@code HH:mmXXXXX}</li>
 <li>{@code HH:mm:ssXXXXX}</li>
 <li>{@code HH:mm:ss.SSSXXXXX}</li>
 <li>{@code HH:mm:ss.SSSSSSXXXXX}</li>
 <li>{@code HH:mm:ss.SSSSSSSSSXXXXX}</li>
 </ul>
 The format used will be the shortest that outputs the full value of
 the time where the omitted parts are implied to be zero.

 @return a string representation of this time, not null"
  {:arglists (quote (["java.time.OffsetTime"]))}
  (^java.lang.String [^java.time.OffsetTime this] (.toString this)))

(defn is-before
  "Checks if the instant of this {@code OffsetTime} is before that of the
 specified time applying both times to a common date.

 This method differs from the comparison in {@link #compareTo} in that it
 only compares the instant of the time. This is equivalent to converting both
 times to an instant using the same date and comparing the instants.

 @param other  the other time to compare to, not null
 @return true if this is before the instant of the specified time"
  {:arglists (quote (["java.time.OffsetTime" "java.time.OffsetTime"]))}
  (^java.lang.Boolean [^java.time.OffsetTime this ^java.time.OffsetTime other]
   (.isBefore this other)))

(defn minus
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.temporal.TemporalAmount"]
                     ["java.time.OffsetTime" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.OffsetTime
   [^java.time.OffsetTime this
    ^java.time.temporal.TemporalAmount amount-to-subtract]
   (.minus this amount-to-subtract))
  (^java.time.OffsetTime
   [^java.time.OffsetTime this ^long amount-to-subtract
    ^java.time.temporal.ChronoUnit unit]
   (.minus this amount-to-subtract unit)))

(defn plus-hours
  "Returns a copy of this {@code OffsetTime} with the specified number of hours added.

 This adds the specified number of hours to this time, returning a new time.
 The calculation wraps around midnight.

 This instance is immutable and unaffected by this method call.

 @param hours  the hours to add, may be negative
 @return an {@code OffsetTime} based on this time with the hours added, not null"
  {:arglists (quote (["java.time.OffsetTime" "long"]))}
  (^java.time.OffsetTime [^java.time.OffsetTime this ^long hours]
   (.plusHours this hours)))

(defn to-local-time
  "Gets the {@code LocalTime} part of this date-time.

 This returns a {@code LocalTime} with the same hour, minute, second and
 nanosecond as this date-time.

 @return the time part of this date-time, not null"
  {:arglists (quote (["java.time.OffsetTime"]))}
  (^java.time.LocalTime [^java.time.OffsetTime this] (.toLocalTime this)))

(defn get-long
  "Gets the value of the specified field from this time as a {@code long}.

 This queries this time for the value of the specified field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@link #isSupported(TemporalField) supported fields} will return valid
 values based on this time.
 All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.

 If the field is not a {@code ChronoField}, then the result of this method
 is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}
 passing {@code this} as the argument. Whether the value can be obtained,
 and what the value represents, is determined by the field.

 @param field  the field to get, not null
 @return the value for the field
 @throws DateTimeException if a value for the field cannot be obtained
 @throws UnsupportedTemporalTypeException if the field is not supported
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.temporal.TemporalField"]))}
  (^long [^java.time.OffsetTime this ^java.time.temporal.TemporalField field]
   (.getLong this field)))

(defn get-offset
  "Gets the zone offset, such as '+01:00'.

 This is the offset of the local time from UTC/Greenwich.

 @return the zone offset, not null"
  {:arglists (quote (["java.time.OffsetTime"]))}
  (^java.time.ZoneOffset [^java.time.OffsetTime this] (.getOffset this)))

(defn with-nano
  "Returns a copy of this {@code OffsetTime} with the nano-of-second altered.

 The offset does not affect the calculation and will be the same in the result.

 This instance is immutable and unaffected by this method call.

 @param nanoOfSecond  the nano-of-second to set in the result, from 0 to 999,999,999
 @return an {@code OffsetTime} based on this time with the requested nanosecond, not null
 @throws DateTimeException if the nanos value is invalid"
  {:arglists (quote (["java.time.OffsetTime" "int"]))}
  (^java.time.OffsetTime
   [^java.time.OffsetTime this ^java.lang.Integer nano-of-second]
   (.withNano this nano-of-second)))

(defn until
  "Calculates the amount of time until another time in terms of the specified unit.

 This calculates the amount of time between two {@code OffsetTime}
 objects in terms of a single {@code TemporalUnit}.
 The start and end points are {@code this} and the specified time.
 The result will be negative if the end is before the start.
 For example, the amount in hours between two times can be calculated
 using {@code startTime.until(endTime, HOURS)}.

 The {@code Temporal} passed to this method is converted to a
 {@code OffsetTime} using {@link #from(TemporalAccessor)}.
 If the offset differs between the two times, then the specified
 end time is normalized to have the same offset as this time.

 The calculation returns a whole number, representing the number of
 complete units between the two times.
 For example, the amount in hours between 11:30Z and 13:29Z will only
 be one hour as it is one minute short of two hours.

 There are two equivalent ways of using this method.
 The first is to invoke this method.
 The second is to use {@link TemporalUnit#between(Temporal, Temporal)}:
 <pre>
   // these two lines are equivalent
   amount = start.until(end, MINUTES);
   amount = MINUTES.between(start, end);
 </pre>
 The choice should be made based on which makes the code more readable.

 The calculation is implemented in this method for {@link ChronoUnit}.
 The units {@code NANOS}, {@code MICROS}, {@code MILLIS}, {@code SECONDS},
 {@code MINUTES}, {@code HOURS} and {@code HALF_DAYS} are supported.
 Other {@code ChronoUnit} values will throw an exception.

 If the unit is not a {@code ChronoUnit}, then the result of this method
 is obtained by invoking {@code TemporalUnit.between(Temporal, Temporal)}
 passing {@code this} as the first argument and the converted input temporal
 as the second argument.

 This instance is immutable and unaffected by this method call.

 @param endExclusive  the end time, exclusive, which is converted to an {@code OffsetTime}, not null
 @param unit  the unit to measure the amount in, not null
 @return the amount of time between this time and the end time
 @throws DateTimeException if the amount cannot be calculated, or the end
  temporal cannot be converted to an {@code OffsetTime}
 @throws UnsupportedTemporalTypeException if the unit is not supported
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.OffsetTime" "java.time.temporal.Temporal"
                      "java.time.temporal.TemporalUnit"]))}
  (^long
   [^java.time.OffsetTime this ^java.time.temporal.Temporal end-exclusive
    ^java.time.temporal.ChronoUnit unit]
   (.until this end-exclusive unit)))

(defn with-offset-same-local
  "Returns a copy of this {@code OffsetTime} with the specified offset ensuring
 that the result has the same local time.

 This method returns an object with the same {@code LocalTime} and the specified {@code ZoneOffset}.
 No calculation is needed or performed.
 For example, if this time represents {@code 10:30+02:00} and the offset specified is
 {@code +03:00}, then this method will return {@code 10:30+03:00}.

 To take into account the difference between the offsets, and adjust the time fields,
 use {@link #withOffsetSameInstant}.

 This instance is immutable and unaffected by this method call.

 @param offset  the zone offset to change to, not null
 @return an {@code OffsetTime} based on this time with the requested offset, not null"
  {:arglists (quote (["java.time.OffsetTime" "java.time.ZoneOffset"]))}
  (^java.time.OffsetTime
   [^java.time.OffsetTime this ^java.time.ZoneOffset offset]
   (.withOffsetSameLocal this offset)))

(defn from
  "Obtains an instance of {@code OffsetTime} from a temporal object.

 This obtains an offset time based on the specified temporal.
 A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 which this factory converts to an instance of {@code OffsetTime}.

 The conversion extracts and combines the {@code ZoneOffset} and the
 {@code LocalTime} from the temporal object.
 Implementations are permitted to perform optimizations such as accessing
 those fields that are equivalent to the relevant objects.

 This method matches the signature of the functional interface {@link TemporalQuery}
 allowing it to be used as a query via method reference, {@code OffsetTime::from}.

 @param temporal  the temporal object to convert, not null
 @return the offset time, not null
 @throws DateTimeException if unable to convert to an {@code OffsetTime}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^java.time.OffsetTime [^java.time.temporal.TemporalAccessor temporal]
   (java.time.OffsetTime/from temporal)))

(defn is-after
  "Checks if the instant of this {@code OffsetTime} is after that of the
 specified time applying both times to a common date.

 This method differs from the comparison in {@link #compareTo} in that it
 only compares the instant of the time. This is equivalent to converting both
 times to an instant using the same date and comparing the instants.

 @param other  the other time to compare to, not null
 @return true if this is after the instant of the specified time"
  {:arglists (quote (["java.time.OffsetTime" "java.time.OffsetTime"]))}
  (^java.lang.Boolean [^java.time.OffsetTime this ^java.time.OffsetTime other]
   (.isAfter this other)))

(defn minus-nanos
  "Returns a copy of this {@code OffsetTime} with the specified number of nanoseconds subtracted.

 This subtracts the specified number of nanoseconds from this time, returning a new time.
 The calculation wraps around midnight.

 This instance is immutable and unaffected by this method call.

 @param nanos  the nanos to subtract, may be negative
 @return an {@code OffsetTime} based on this time with the nanoseconds subtracted, not null"
  {:arglists (quote (["java.time.OffsetTime" "long"]))}
  (^java.time.OffsetTime [^java.time.OffsetTime this ^long nanos]
   (.minusNanos this nanos)))

(defn is-supported
  {:arglists (quote (["java.time.OffsetTime" "java.time.temporal.TemporalField"]
                     ["java.time.OffsetTime"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.lang.Boolean [this arg0]
   (clojure.core/cond
     (clojure.core/and (clojure.core/instance? java.time.temporal.TemporalField
                                               arg0))
       (clojure.core/let [field ^"java.time.temporal.TemporalField" arg0]
         (.isSupported ^java.time.OffsetTime this field))
     (clojure.core/and (clojure.core/instance? java.time.temporal.ChronoUnit
                                               arg0))
       (clojure.core/let [unit ^"java.time.temporal.ChronoUnit" arg0]
         (.isSupported ^java.time.OffsetTime this unit))
     :else (throw (java.lang.IllegalArgumentException.
                    "no corresponding java.time method with these args")))))

(defn parse
  {:arglists (quote (["java.lang.CharSequence"]
                     ["java.lang.CharSequence"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.time.OffsetTime [^java.lang.CharSequence text]
   (java.time.OffsetTime/parse text))
  (^java.time.OffsetTime
   [^java.lang.CharSequence text ^java.time.format.DateTimeFormatter formatter]
   (java.time.OffsetTime/parse text formatter)))

(defn with-second
  "Returns a copy of this {@code OffsetTime} with the second-of-minute altered.

 The offset does not affect the calculation and will be the same in the result.

 This instance is immutable and unaffected by this method call.

 @param second  the second-of-minute to set in the result, from 0 to 59
 @return an {@code OffsetTime} based on this time with the requested second, not null
 @throws DateTimeException if the second value is invalid"
  {:arglists (quote (["java.time.OffsetTime" "int"]))}
  (^java.time.OffsetTime [^java.time.OffsetTime this ^java.lang.Integer second]
   (.withSecond this second)))

(defn get-minute
  "Gets the minute-of-hour field.

 @return the minute-of-hour, from 0 to 59"
  {:arglists (quote (["java.time.OffsetTime"]))}
  (^java.lang.Integer [^java.time.OffsetTime this] (.getMinute this)))

(defn hash-code
  "A hash code for this time.

 @return a suitable hash code"
  {:arglists (quote (["java.time.OffsetTime"]))}
  (^java.lang.Integer [^java.time.OffsetTime this] (.hashCode this)))

(defn adjust-into
  "Adjusts the specified temporal object to have the same offset and time
 as this object.

 This returns a temporal object of the same observable type as the input
 with the offset and time changed to be the same as this.

 The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}
 twice, passing {@link ChronoField#NANO_OF_DAY} and
 {@link ChronoField#OFFSET_SECONDS} as the fields.

 In most cases, it is clearer to reverse the calling pattern by using
 {@link Temporal#with(TemporalAdjuster)}:
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   temporal = thisOffsetTime.adjustInto(temporal);
   temporal = temporal.with(thisOffsetTime);
 </pre>

 This instance is immutable and unaffected by this method call.

 @param temporal  the target object to be adjusted, not null
 @return the adjusted object, not null
 @throws DateTimeException if unable to make the adjustment
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.OffsetTime" "java.time.temporal.Temporal"]))}
  (^java.time.temporal.Temporal
   [^java.time.OffsetTime this ^java.time.temporal.Temporal temporal]
   (.adjustInto this temporal)))

(defn with
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.temporal.TemporalAdjuster"]
                     ["java.time.OffsetTime" "java.time.temporal.TemporalField"
                      "long"]))}
  (^java.time.OffsetTime
   [^java.time.OffsetTime this ^java.time.temporal.TemporalAdjuster adjuster]
   (.with this adjuster))
  (^java.time.OffsetTime
   [^java.time.OffsetTime this ^java.time.temporal.TemporalField field
    ^long new-value]
   (.with this field new-value)))

(defn now
  {:arglists (quote ([] ["java.time.Clock"] ["java.time.ZoneId"]))}
  (^java.time.OffsetTime [] (java.time.OffsetTime/now))
  (^java.time.OffsetTime [arg0]
   (clojure.core/cond
     (clojure.core/and (clojure.core/instance? java.time.Clock arg0))
       (clojure.core/let [clock ^"java.time.Clock" arg0]
         (java.time.OffsetTime/now clock))
     (clojure.core/and (clojure.core/instance? java.time.ZoneId arg0))
       (clojure.core/let [zone ^"java.time.ZoneId" arg0]
         (java.time.OffsetTime/now zone))
     :else (throw (java.lang.IllegalArgumentException.
                    "no corresponding java.time method with these args")))))

(defn compare-to
  "Compares this {@code OffsetTime} to another time.

 The comparison is based first on the UTC equivalent instant, then on the local time.
 It is \"consistent with equals\", as defined by {@link Comparable}.

 For example, the following is the comparator order:
 <ol>
 <li>{@code 10:30+01:00}</li>
 <li>{@code 11:00+01:00}</li>
 <li>{@code 12:00+02:00}</li>
 <li>{@code 11:30+01:00}</li>
 <li>{@code 12:00+01:00}</li>
 <li>{@code 12:30+01:00}</li>
 </ol>
 Values #2 and #3 represent the same instant on the time-line.
 When two values represent the same instant, the local time is compared
 to distinguish them. This step is needed to make the ordering
 consistent with {@code equals()}.

 To compare the underlying local time of two {@code TemporalAccessor} instances,
 use {@link ChronoField#NANO_OF_DAY} as a comparator.

 @param other  the other time to compare to, not null
 @return the comparator value, negative if less, positive if greater
 @throws NullPointerException if {@code other} is null"
  {:arglists (quote (["java.time.OffsetTime" "java.time.OffsetTime"]))}
  (^java.lang.Integer [^java.time.OffsetTime this ^java.time.OffsetTime other]
   (.compareTo this other)))

(defn of-instant
  "Obtains an instance of {@code OffsetTime} from an {@code Instant} and zone ID.

 This creates an offset time with the same instant as that specified.
 Finding the offset from UTC/Greenwich is simple as there is only one valid
 offset for each instant.

 The date component of the instant is dropped during the conversion.
 This means that the conversion can never fail due to the instant being
 out of the valid range of dates.

 @param instant  the instant to create the time from, not null
 @param zone  the time-zone, which may be an offset, not null
 @return the offset time, not null"
  {:arglists (quote (["java.time.Instant" "java.time.ZoneId"]))}
  (^java.time.OffsetTime [^java.time.Instant instant ^java.time.ZoneId zone]
   (java.time.OffsetTime/ofInstant instant zone)))

(defn plus-seconds
  "Returns a copy of this {@code OffsetTime} with the specified number of seconds added.

 This adds the specified number of seconds to this time, returning a new time.
 The calculation wraps around midnight.

 This instance is immutable and unaffected by this method call.

 @param seconds  the seconds to add, may be negative
 @return an {@code OffsetTime} based on this time with the seconds added, not null"
  {:arglists (quote (["java.time.OffsetTime" "long"]))}
  (^java.time.OffsetTime [^java.time.OffsetTime this ^long seconds]
   (.plusSeconds this seconds)))

(defn get
  "Gets the value of the specified field from this time as an {@code int}.

 This queries this time for the value of the specified field.
 The returned value will always be within the valid range of values for the field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@link #isSupported(TemporalField) supported fields} will return valid
 values based on this time, except {@code NANO_OF_DAY} and {@code MICRO_OF_DAY}
 which are too large to fit in an {@code int} and throw a {@code DateTimeException}.
 All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.

 If the field is not a {@code ChronoField}, then the result of this method
 is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}
 passing {@code this} as the argument. Whether the value can be obtained,
 and what the value represents, is determined by the field.

 @param field  the field to get, not null
 @return the value for the field
 @throws DateTimeException if a value for the field cannot be obtained or
         the value is outside the range of valid values for the field
 @throws UnsupportedTemporalTypeException if the field is not supported or
         the range of values exceeds an {@code int}
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.temporal.TemporalField"]))}
  (^java.lang.Integer
   [^java.time.OffsetTime this ^java.time.temporal.TemporalField field]
   (.get this field)))

(defn equals
  "Checks if this time is equal to another time.

 The comparison is based on the local-time and the offset.
 To compare for the same instant on the time-line, use {@link #isEqual(OffsetTime)}.

 Only objects of type {@code OffsetTime} are compared, other types return false.
 To compare the underlying local time of two {@code TemporalAccessor} instances,
 use {@link ChronoField#NANO_OF_DAY} as a comparator.

 @param obj  the object to check, null returns false
 @return true if this is equal to the other time"
  {:arglists (quote (["java.time.OffsetTime" "java.lang.Object"]))}
  (^java.lang.Boolean [^java.time.OffsetTime this ^java.lang.Object obj]
   (.equals this obj)))

(defn format
  "Formats this time using the specified formatter.

 This time will be passed to the formatter to produce a string.

 @param formatter  the formatter to use, not null
 @return the formatted time string, not null
 @throws DateTimeException if an error occurs during printing"
  {:arglists (quote (["java.time.OffsetTime"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.lang.String
   [^java.time.OffsetTime this ^java.time.format.DateTimeFormatter formatter]
   (.format this formatter)))
