(ns cljc.java-time.instant
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [Instant]]))

(def min (goog.object/get java.time.Instant "MIN"))

(def epoch (goog.object/get java.time.Instant "EPOCH"))

(def max (goog.object/get java.time.Instant "MAX"))

(defn truncated-to
  "Returns a copy of this {@code Instant} truncated to the specified unit.

 Truncating the instant returns a copy of the original with fields
 smaller than the specified unit set to zero.
 The fields are calculated on the basis of using a UTC offset as seen
 in {@code toString}.
 For example, truncating with the {@link ChronoUnit#MINUTES MINUTES} unit will
 round down to the nearest minute, setting the seconds and nanoseconds to zero.

 The unit must have a {@linkplain TemporalUnit#getDuration() duration}
 that divides into the length of a standard day without remainder.
 This includes all supplied time units on {@link ChronoUnit} and
 {@link ChronoUnit#DAYS DAYS}. Other units throw an exception.

 This instance is immutable and unaffected by this method call.

 @param unit  the unit to truncate to, not null
 @return an {@code Instant} based on this instant with the time truncated, not null
 @throws DateTimeException if the unit is invalid for truncation
 @throws UnsupportedTemporalTypeException if the unit is not supported"
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.Instant [^js/JSJoda.Instant this ^js/JSJoda.TemporalUnit unit]
   (.truncatedTo this unit)))

(defn range
  "Gets the range of valid values for the specified field.

 The range object expresses the minimum and maximum valid values for a field.
 This instant is used to enhance the accuracy of the returned range.
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
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalField"]))}
  (^js/JSJoda.ValueRange
   [^js/JSJoda.Instant this ^js/JSJoda.TemporalField field]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-cljs (.range this
                                                                       field))))

(defn of-epoch-second
  {:arglists (quote (["long"] ["long" "long"]))}
  (^js/JSJoda.Instant [^long epoch-second]
   (js-invoke java.time.Instant "ofEpochSecond" epoch-second))
  (^js/JSJoda.Instant [^long epoch-second ^long nano-adjustment]
   (js-invoke java.time.Instant "ofEpochSecond" epoch-second nano-adjustment)))

(defn at-offset
  "Combines this instant with an offset to create an {@code OffsetDateTime}.

 This returns an {@code OffsetDateTime} formed from this instant at the
 specified offset from UTC/Greenwich. An exception will be thrown if the
 instant is too large to fit into an offset date-time.

 This method is equivalent to
 {@link OffsetDateTime#ofInstant(Instant, ZoneId) OffsetDateTime.ofInstant(this, offset)}.

 @param offset  the offset to combine with, not null
 @return the offset date-time formed from this instant and the specified offset, not null
 @throws DateTimeException if the result exceeds the supported range"
  {:arglists (quote (["java.time.Instant" "java.time.ZoneOffset"]))}
  (^js/JSJoda.OffsetDateTime
   [^js/JSJoda.Instant this ^js/JSJoda.ZoneOffset offset]
   (.atOffset this offset)))

(defn minus-millis
  "Returns a copy of this instant with the specified duration in milliseconds subtracted.

 This instance is immutable and unaffected by this method call.

 @param millisToSubtract  the milliseconds to subtract, positive or negative
 @return an {@code Instant} based on this instant with the specified milliseconds subtracted, not null
 @throws DateTimeException if the result exceeds the maximum or minimum instant
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "long"]))}
  (^js/JSJoda.Instant [^js/JSJoda.Instant this ^long millis-to-subtract]
   (.minusMillis this millis-to-subtract)))

(defn get-nano
  "Gets the number of nanoseconds, later along the time-line, from the start
 of the second.

 The nanosecond-of-second value measures the total number of nanoseconds from
 the second returned by {@code getEpochSecond}.

 @return the nanoseconds within the second, always positive, never exceeds 999,999,999"
  {:arglists (quote (["java.time.Instant"]))}
  (^int [^js/JSJoda.Instant this] (.nano this)))

(defn plus-millis
  "Returns a copy of this instant with the specified duration in milliseconds added.

 This instance is immutable and unaffected by this method call.

 @param millisToAdd  the milliseconds to add, positive or negative
 @return an {@code Instant} based on this instant with the specified milliseconds added, not null
 @throws DateTimeException if the result exceeds the maximum or minimum instant
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "long"]))}
  (^js/JSJoda.Instant [^js/JSJoda.Instant this ^long millis-to-add]
   (.plusMillis this millis-to-add)))

(defn minus-seconds
  "Returns a copy of this instant with the specified duration in seconds subtracted.

 This instance is immutable and unaffected by this method call.

 @param secondsToSubtract  the seconds to subtract, positive or negative
 @return an {@code Instant} based on this instant with the specified seconds subtracted, not null
 @throws DateTimeException if the result exceeds the maximum or minimum instant
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "long"]))}
  (^js/JSJoda.Instant [^js/JSJoda.Instant this ^long seconds-to-subtract]
   (.minusSeconds this seconds-to-subtract)))

(defn plus-nanos
  "Returns a copy of this instant with the specified duration in nanoseconds added.

 This instance is immutable and unaffected by this method call.

 @param nanosToAdd  the nanoseconds to add, positive or negative
 @return an {@code Instant} based on this instant with the specified nanoseconds added, not null
 @throws DateTimeException if the result exceeds the maximum or minimum instant
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "long"]))}
  (^js/JSJoda.Instant [^js/JSJoda.Instant this ^long nanos-to-add]
   (.plusNanos this nanos-to-add)))

(defn plus
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalAmount"]
                     ["java.time.Instant" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.Instant
   [^js/JSJoda.Instant this ^js/JSJoda.TemporalAmount amount-to-add]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-cljs
     (.plus this amount-to-add)))
  (^js/JSJoda.Instant
   [^js/JSJoda.Instant this ^long amount-to-add ^js/JSJoda.TemporalUnit unit]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-cljs
     (.plus this amount-to-add unit))))

(defn query
  "Queries this instant using the specified query.

 This queries this instant using the specified query strategy object.
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
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object [^js/JSJoda.Instant this ^js/JSJoda.TemporalQuery query]
   (.query this query)))

(defn to-string
  "A string representation of this instant using ISO-8601 representation.

 The format used is the same as {@link DateTimeFormatter#ISO_INSTANT}.

 @return an ISO-8601 representation of this instant, not null"
  {:arglists (quote (["java.time.Instant"]))}
  (^java.lang.String [^js/JSJoda.Instant this] (.toString this)))

(defn is-before
  "Checks if this instant is before the specified instant.

 The comparison is based on the time-line position of the instants.

 @param otherInstant  the other instant to compare to, not null
 @return true if this instant is before the specified instant
 @throws NullPointerException if otherInstant is null"
  {:arglists (quote (["java.time.Instant" "java.time.Instant"]))}
  (^boolean [^js/JSJoda.Instant this ^js/JSJoda.Instant other-instant]
   (.isBefore this other-instant)))

(defn minus
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalAmount"]
                     ["java.time.Instant" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.Instant
   [^js/JSJoda.Instant this ^js/JSJoda.TemporalAmount amount-to-subtract]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-cljs
     (.minus this amount-to-subtract)))
  (^js/JSJoda.Instant
   [^js/JSJoda.Instant this ^long amount-to-subtract
    ^js/JSJoda.TemporalUnit unit]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-cljs
     (.minus this amount-to-subtract unit))))

(defn at-zone
  "Combines this instant with a time-zone to create a {@code ZonedDateTime}.

 This returns an {@code ZonedDateTime} formed from this instant at the
 specified time-zone. An exception will be thrown if the instant is too
 large to fit into a zoned date-time.

 This method is equivalent to
 {@link ZonedDateTime#ofInstant(Instant, ZoneId) ZonedDateTime.ofInstant(this, zone)}.

 @param zone  the zone to combine with, not null
 @return the zoned date-time formed from this instant and the specified zone, not null
 @throws DateTimeException if the result exceeds the supported range"
  {:arglists (quote (["java.time.Instant" "java.time.ZoneId"]))}
  (^js/JSJoda.ZonedDateTime [^js/JSJoda.Instant this ^js/JSJoda.ZoneId zone]
   (.atZone this zone)))

(defn of-epoch-milli
  "Obtains an instance of {@code Instant} using milliseconds from the
 epoch of 1970-01-01T00:00:00Z.

 The seconds and nanoseconds are extracted from the specified milliseconds.

 @param epochMilli  the number of milliseconds from 1970-01-01T00:00:00Z
 @return an instant, not null
 @throws DateTimeException if the instant exceeds the maximum or minimum instant"
  {:arglists (quote (["long"]))}
  (^js/JSJoda.Instant [^long epoch-milli]
   (js-invoke java.time.Instant "ofEpochMilli" epoch-milli)))

(defn get-long
  "Gets the value of the specified field from this instant as a {@code long}.

 This queries this instant for the value of the specified field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@link #isSupported(TemporalField) supported fields} will return valid
 values based on this date-time.
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
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalField"]))}
  (^long [^js/JSJoda.Instant this ^js/JSJoda.TemporalField field]
   (.getLong this field)))

(defn until
  "Calculates the amount of time until another instant in terms of the specified unit.

 This calculates the amount of time between two {@code Instant}
 objects in terms of a single {@code TemporalUnit}.
 The start and end points are {@code this} and the specified instant.
 The result will be negative if the end is before the start.
 The calculation returns a whole number, representing the number of
 complete units between the two instants.
 The {@code Temporal} passed to this method is converted to a
 {@code Instant} using {@link #from(TemporalAccessor)}.
 For example, the amount in days between two dates can be calculated
 using {@code startInstant.until(endInstant, SECONDS)}.

 There are two equivalent ways of using this method.
 The first is to invoke this method.
 The second is to use {@link TemporalUnit#between(Temporal, Temporal)}:
 <pre>
   // these two lines are equivalent
   amount = start.until(end, SECONDS);
   amount = SECONDS.between(start, end);
 </pre>
 The choice should be made based on which makes the code more readable.

 The calculation is implemented in this method for {@link ChronoUnit}.
 The units {@code NANOS}, {@code MICROS}, {@code MILLIS}, {@code SECONDS},
 {@code MINUTES}, {@code HOURS}, {@code HALF_DAYS} and {@code DAYS}
 are supported. Other {@code ChronoUnit} values will throw an exception.

 If the unit is not a {@code ChronoUnit}, then the result of this method
 is obtained by invoking {@code TemporalUnit.between(Temporal, Temporal)}
 passing {@code this} as the first argument and the converted input temporal
 as the second argument.

 This instance is immutable and unaffected by this method call.

 @param endExclusive  the end date, exclusive, which is converted to an {@code Instant}, not null
 @param unit  the unit to measure the amount in, not null
 @return the amount of time between this instant and the end instant
 @throws DateTimeException if the amount cannot be calculated, or the end
  temporal cannot be converted to an {@code Instant}
 @throws UnsupportedTemporalTypeException if the unit is not supported
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "java.time.temporal.Temporal"
                      "java.time.temporal.TemporalUnit"]))}
  (^long
   [^js/JSJoda.Instant this ^js/JSJoda.Temporal end-exclusive
    ^js/JSJoda.TemporalUnit unit]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-cljs
     (.until this end-exclusive unit))))

(defn from
  "Obtains an instance of {@code Instant} from a temporal object.

 This obtains an instant based on the specified temporal.
 A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 which this factory converts to an instance of {@code Instant}.

 The conversion extracts the {@link ChronoField#INSTANT_SECONDS INSTANT_SECONDS}
 and {@link ChronoField#NANO_OF_SECOND NANO_OF_SECOND} fields.

 This method matches the signature of the functional interface {@link TemporalQuery}
 allowing it to be used as a query via method reference, {@code Instant::from}.

 @param temporal  the temporal object to convert, not null
 @return the instant, not null
 @throws DateTimeException if unable to convert to an {@code Instant}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^js/JSJoda.Instant [^js/JSJoda.TemporalAccessor temporal]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-cljs
     (js-invoke java.time.Instant "from" temporal))))

(defn is-after
  "Checks if this instant is after the specified instant.

 The comparison is based on the time-line position of the instants.

 @param otherInstant  the other instant to compare to, not null
 @return true if this instant is after the specified instant
 @throws NullPointerException if otherInstant is null"
  {:arglists (quote (["java.time.Instant" "java.time.Instant"]))}
  (^boolean [^js/JSJoda.Instant this ^js/JSJoda.Instant other-instant]
   (.isAfter this other-instant)))

(defn minus-nanos
  "Returns a copy of this instant with the specified duration in nanoseconds subtracted.

 This instance is immutable and unaffected by this method call.

 @param nanosToSubtract  the nanoseconds to subtract, positive or negative
 @return an {@code Instant} based on this instant with the specified nanoseconds subtracted, not null
 @throws DateTimeException if the result exceeds the maximum or minimum instant
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "long"]))}
  (^js/JSJoda.Instant [^js/JSJoda.Instant this ^long nanos-to-subtract]
   (.minusNanos this nanos-to-subtract)))

(defn is-supported
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalField"]
                     ["java.time.Instant" "java.time.temporal.TemporalUnit"]))}
  (^boolean [this arg0] (.isSupported ^js/JSJoda.Instant this arg0)))

(defn parse
  "Obtains an instance of {@code Instant} from a text string such as
 {@code 2007-12-03T10:15:30.00Z}.

 The string must represent a valid instant in UTC and is parsed using
 {@link DateTimeFormatter#ISO_INSTANT}.

 @param text  the text to parse, not null
 @return the parsed instant, not null
 @throws DateTimeParseException if the text cannot be parsed"
  {:arglists (quote (["java.lang.CharSequence"]))}
  (^js/JSJoda.Instant [^java.lang.CharSequence text]
   (js-invoke java.time.Instant "parse" text)))

(defn hash-code
  "Returns a hash code for this instant.

 @return a suitable hash code"
  {:arglists (quote (["java.time.Instant"]))}
  (^int [^js/JSJoda.Instant this] (.hashCode this)))

(defn adjust-into
  "Adjusts the specified temporal object to have this instant.

 This returns a temporal object of the same observable type as the input
 with the instant changed to be the same as this.

 The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}
 twice, passing {@link ChronoField#INSTANT_SECONDS} and
 {@link ChronoField#NANO_OF_SECOND} as the fields.

 In most cases, it is clearer to reverse the calling pattern by using
 {@link Temporal#with(TemporalAdjuster)}:
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   temporal = thisInstant.adjustInto(temporal);
   temporal = temporal.with(thisInstant);
 </pre>

 This instance is immutable and unaffected by this method call.

 @param temporal  the target object to be adjusted, not null
 @return the adjusted object, not null
 @throws DateTimeException if unable to make the adjustment
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Temporal [^js/JSJoda.Instant this ^js/JSJoda.Temporal temporal]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-cljs
     (.adjustInto this temporal))))

(defn with
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalAdjuster"]
                     ["java.time.Instant" "java.time.temporal.TemporalField"
                      "long"]))}
  (^js/JSJoda.Instant
   [^js/JSJoda.Instant this ^js/JSJoda.TemporalAdjuster adjuster]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-cljs
     (.with this adjuster)))
  (^js/JSJoda.Instant
   [^js/JSJoda.Instant this ^js/JSJoda.TemporalField field ^long new-value]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-cljs
     (.with this field new-value))))

(defn now
  {:arglists (quote ([] ["java.time.Clock"]))}
  (^js/JSJoda.Instant [] (js-invoke java.time.Instant "now"))
  (^js/JSJoda.Instant [^js/JSJoda.Clock clock]
   (js-invoke java.time.Instant "now" clock)))

(defn to-epoch-milli
  "Converts this instant to the number of milliseconds from the epoch
 of 1970-01-01T00:00:00Z.

 If this instant represents a point on the time-line too far in the future
 or past to fit in a {@code long} milliseconds, then an exception is thrown.

 If this instant has greater than millisecond precision, then the conversion
 will drop any excess precision information as though the amount in nanoseconds
 was subject to integer division by one million.

 @return the number of milliseconds since the epoch of 1970-01-01T00:00:00Z
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant"]))}
  (^long [^js/JSJoda.Instant this] (.toEpochMilli this)))

(defn get-epoch-second
  "Gets the number of seconds from the Java epoch of 1970-01-01T00:00:00Z.

 The epoch second count is a simple incrementing count of seconds where
 second 0 is 1970-01-01T00:00:00Z.
 The nanosecond part of the day is returned by {@code getNanosOfSecond}.

 @return the seconds from the epoch of 1970-01-01T00:00:00Z"
  {:arglists (quote (["java.time.Instant"]))}
  (^long [^js/JSJoda.Instant this] (.epochSecond this)))

(defn compare-to
  "Compares this instant to the specified instant.

 The comparison is based on the time-line position of the instants.
 It is \"consistent with equals\", as defined by {@link Comparable}.

 @param otherInstant  the other instant to compare to, not null
 @return the comparator value, negative if less, positive if greater
 @throws NullPointerException if otherInstant is null"
  {:arglists (quote (["java.time.Instant" "java.time.Instant"]))}
  (^int [^js/JSJoda.Instant this ^js/JSJoda.Instant other-instant]
   (.compareTo this other-instant)))

(defn plus-seconds
  "Returns a copy of this instant with the specified duration in seconds added.

 This instance is immutable and unaffected by this method call.

 @param secondsToAdd  the seconds to add, positive or negative
 @return an {@code Instant} based on this instant with the specified seconds added, not null
 @throws DateTimeException if the result exceeds the maximum or minimum instant
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "long"]))}
  (^js/JSJoda.Instant [^js/JSJoda.Instant this ^long seconds-to-add]
   (.plusSeconds this seconds-to-add)))

(defn get
  "Gets the value of the specified field from this instant as an {@code int}.

 This queries this instant for the value of the specified field.
 The returned value will always be within the valid range of values for the field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@link #isSupported(TemporalField) supported fields} will return valid
 values based on this date-time, except {@code INSTANT_SECONDS} which is too
 large to fit in an {@code int} and throws a {@code DateTimeException}.
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
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalField"]))}
  (^int [^js/JSJoda.Instant this ^js/JSJoda.TemporalField field]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-cljs (.get this
                                                                     field))))

(defn equals
  "Checks if this instant is equal to the specified instant.

 The comparison is based on the time-line position of the instants.

 @param otherInstant  the other instant, null returns false
 @return true if the other instant is equal to this one"
  {:arglists (quote (["java.time.Instant" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.Instant this ^java.lang.Object other-instant]
   (.equals this other-instant)))
