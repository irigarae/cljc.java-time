(ns cljc.java-time.instant
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time Instant]))

(def min java.time.Instant/MIN)

(def epoch java.time.Instant/EPOCH)

(def max java.time.Instant/MAX)

(defn truncated-to
  "Returns a copy of this {@code Instant} truncated to the specified unit.\n <p>\n Truncating the instant returns a copy of the original with fields\n smaller than the specified unit set to zero.\n The fields are calculated on the basis of using a UTC offset as seen\n in {@code toString}.\n For example, truncating with the {@link ChronoUnit#MINUTES MINUTES} unit will\n round down to the nearest minute, setting the seconds and nanoseconds to zero.\n <p>\n The unit must have a {@linkplain TemporalUnit#getDuration() duration}\n that divides into the length of a standard day without remainder.\n This includes all supplied time units on {@link ChronoUnit} and\n {@link ChronoUnit#DAYS DAYS}. Other units throw an exception.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param unit  the unit to truncate to, not null\n @return an {@code Instant} based on this instant with the time truncated, not null\n @throws DateTimeException if the unit is invalid for truncation\n @throws UnsupportedTemporalTypeException if the unit is not supported"
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalUnit"]))}
  (^java.time.Instant
   [^java.time.Instant this ^java.time.temporal.ChronoUnit unit]
   (.truncatedTo this unit)))

(defn range
  "Gets the range of valid values for the specified field.\n <p>\n The range object expresses the minimum and maximum valid values for a field.\n This instant is used to enhance the accuracy of the returned range.\n If it is not possible to return the range, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return\n appropriate range instances.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)}\n passing {@code this} as the argument.\n Whether the range can be obtained is determined by the field.\n\n @param field  the field to query the range for, not null\n @return the range of valid values for the field, not null\n @throws DateTimeException if the range for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported"
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ValueRange
   [^java.time.Instant this ^java.time.temporal.TemporalField field]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-clj (.range this
                                                                      field))))

(defn of-epoch-second
  {:arglists (quote (["long"] ["long" "long"]))}
  (^java.time.Instant [^long epoch-second]
   (java.time.Instant/ofEpochSecond epoch-second))
  (^java.time.Instant [^long epoch-second ^long nano-adjustment]
   (java.time.Instant/ofEpochSecond epoch-second nano-adjustment)))

(defn at-offset
  "Combines this instant with an offset to create an {@code OffsetDateTime}.\n <p>\n This returns an {@code OffsetDateTime} formed from this instant at the\n specified offset from UTC/Greenwich. An exception will be thrown if the\n instant is too large to fit into an offset date-time.\n <p>\n This method is equivalent to\n {@link OffsetDateTime#ofInstant(Instant, ZoneId) OffsetDateTime.ofInstant(this, offset)}.\n\n @param offset  the offset to combine with, not null\n @return the offset date-time formed from this instant and the specified offset, not null\n @throws DateTimeException if the result exceeds the supported range"
  {:arglists (quote (["java.time.Instant" "java.time.ZoneOffset"]))}
  (^java.time.OffsetDateTime
   [^java.time.Instant this ^java.time.ZoneOffset offset]
   (.atOffset this offset)))

(defn minus-millis
  "Returns a copy of this instant with the specified duration in milliseconds subtracted.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param millisToSubtract  the milliseconds to subtract, positive or negative\n @return an {@code Instant} based on this instant with the specified milliseconds subtracted, not null\n @throws DateTimeException if the result exceeds the maximum or minimum instant\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "long"]))}
  (^java.time.Instant [^java.time.Instant this ^long millis-to-subtract]
   (.minusMillis this millis-to-subtract)))

(defn get-nano
  "Gets the number of nanoseconds, later along the time-line, from the start\n of the second.\n <p>\n The nanosecond-of-second value measures the total number of nanoseconds from\n the second returned by {@code getEpochSecond}.\n\n @return the nanoseconds within the second, always positive, never exceeds 999,999,999"
  {:arglists (quote (["java.time.Instant"]))}
  (^java.lang.Integer [^java.time.Instant this] (.getNano this)))

(defn plus-millis
  "Returns a copy of this instant with the specified duration in milliseconds added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param millisToAdd  the milliseconds to add, positive or negative\n @return an {@code Instant} based on this instant with the specified milliseconds added, not null\n @throws DateTimeException if the result exceeds the maximum or minimum instant\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "long"]))}
  (^java.time.Instant [^java.time.Instant this ^long millis-to-add]
   (.plusMillis this millis-to-add)))

(defn minus-seconds
  "Returns a copy of this instant with the specified duration in seconds subtracted.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param secondsToSubtract  the seconds to subtract, positive or negative\n @return an {@code Instant} based on this instant with the specified seconds subtracted, not null\n @throws DateTimeException if the result exceeds the maximum or minimum instant\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "long"]))}
  (^java.time.Instant [^java.time.Instant this ^long seconds-to-subtract]
   (.minusSeconds this seconds-to-subtract)))

(defn plus-nanos
  "Returns a copy of this instant with the specified duration in nanoseconds added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param nanosToAdd  the nanoseconds to add, positive or negative\n @return an {@code Instant} based on this instant with the specified nanoseconds added, not null\n @throws DateTimeException if the result exceeds the maximum or minimum instant\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "long"]))}
  (^java.time.Instant [^java.time.Instant this ^long nanos-to-add]
   (.plusNanos this nanos-to-add)))

(defn plus
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalAmount"]
                     ["java.time.Instant" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.Instant
   [^java.time.Instant this ^java.time.temporal.TemporalAmount amount-to-add]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-clj
     (.plus this amount-to-add)))
  (^java.time.Instant
   [^java.time.Instant this ^long amount-to-add
    ^java.time.temporal.ChronoUnit unit]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-clj
     (.plus this amount-to-add unit))))

(defn query
  "Queries this instant using the specified query.\n <p>\n This queries this instant using the specified query strategy object.\n The {@code TemporalQuery} object defines the logic to be used to\n obtain the result. Read the documentation of the query to understand\n what the result of this method will be.\n <p>\n The result of this method is obtained by invoking the\n {@link TemporalQuery#queryFrom(TemporalAccessor)} method on the\n specified query passing {@code this} as the argument.\n\n @param <R> the type of the result\n @param query  the query to invoke, not null\n @return the query result, null may be returned (defined by the query)\n @throws DateTimeException if unable to query (defined by the query)\n @throws ArithmeticException if numeric overflow occurs (defined by the query)"
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object
   [^java.time.Instant this ^java.time.temporal.TemporalQuery query]
   (.query this query)))

(defn to-string
  "A string representation of this instant using ISO-8601 representation.\n <p>\n The format used is the same as {@link DateTimeFormatter#ISO_INSTANT}.\n\n @return an ISO-8601 representation of this instant, not null"
  {:arglists (quote (["java.time.Instant"]))}
  (^java.lang.String [^java.time.Instant this] (.toString this)))

(defn is-before
  "Checks if this instant is before the specified instant.\n <p>\n The comparison is based on the time-line position of the instants.\n\n @param otherInstant  the other instant to compare to, not null\n @return true if this instant is before the specified instant\n @throws NullPointerException if otherInstant is null"
  {:arglists (quote (["java.time.Instant" "java.time.Instant"]))}
  (^java.lang.Boolean [^java.time.Instant this ^java.time.Instant other-instant]
   (.isBefore this other-instant)))

(defn minus
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalAmount"]
                     ["java.time.Instant" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.Instant
   [^java.time.Instant this
    ^java.time.temporal.TemporalAmount amount-to-subtract]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-clj
     (.minus this amount-to-subtract)))
  (^java.time.Instant
   [^java.time.Instant this ^long amount-to-subtract
    ^java.time.temporal.ChronoUnit unit]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-clj
     (.minus this amount-to-subtract unit))))

(defn at-zone
  "Combines this instant with a time-zone to create a {@code ZonedDateTime}.\n <p>\n This returns an {@code ZonedDateTime} formed from this instant at the\n specified time-zone. An exception will be thrown if the instant is too\n large to fit into a zoned date-time.\n <p>\n This method is equivalent to\n {@link ZonedDateTime#ofInstant(Instant, ZoneId) ZonedDateTime.ofInstant(this, zone)}.\n\n @param zone  the zone to combine with, not null\n @return the zoned date-time formed from this instant and the specified zone, not null\n @throws DateTimeException if the result exceeds the supported range"
  {:arglists (quote (["java.time.Instant" "java.time.ZoneId"]))}
  (^java.time.ZonedDateTime [^java.time.Instant this ^java.time.ZoneId zone]
   (.atZone this zone)))

(defn of-epoch-milli
  "Obtains an instance of {@code Instant} using milliseconds from the\n epoch of 1970-01-01T00:00:00Z.\n <p>\n The seconds and nanoseconds are extracted from the specified milliseconds.\n\n @param epochMilli  the number of milliseconds from 1970-01-01T00:00:00Z\n @return an instant, not null\n @throws DateTimeException if the instant exceeds the maximum or minimum instant"
  {:arglists (quote (["long"]))}
  (^java.time.Instant [^long epoch-milli]
   (java.time.Instant/ofEpochMilli epoch-milli)))

(defn get-long
  "Gets the value of the specified field from this instant as a {@code long}.\n <p>\n This queries this instant for the value of the specified field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return valid\n values based on this date-time.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalField"]))}
  (^long [^java.time.Instant this ^java.time.temporal.TemporalField field]
   (.getLong this field)))

(defn until
  "Calculates the amount of time until another instant in terms of the specified unit.\n <p>\n This calculates the amount of time between two {@code Instant}\n objects in terms of a single {@code TemporalUnit}.\n The start and end points are {@code this} and the specified instant.\n The result will be negative if the end is before the start.\n The calculation returns a whole number, representing the number of\n complete units between the two instants.\n The {@code Temporal} passed to this method is converted to a\n {@code Instant} using {@link #from(TemporalAccessor)}.\n For example, the amount in days between two dates can be calculated\n using {@code startInstant.until(endInstant, SECONDS)}.\n <p>\n There are two equivalent ways of using this method.\n The first is to invoke this method.\n The second is to use {@link TemporalUnit#between(Temporal, Temporal)}:\n <pre>\n   // these two lines are equivalent\n   amount = start.until(end, SECONDS);\n   amount = SECONDS.between(start, end);\n </pre>\n The choice should be made based on which makes the code more readable.\n <p>\n The calculation is implemented in this method for {@link ChronoUnit}.\n The units {@code NANOS}, {@code MICROS}, {@code MILLIS}, {@code SECONDS},\n {@code MINUTES}, {@code HOURS}, {@code HALF_DAYS} and {@code DAYS}\n are supported. Other {@code ChronoUnit} values will throw an exception.\n <p>\n If the unit is not a {@code ChronoUnit}, then the result of this method\n is obtained by invoking {@code TemporalUnit.between(Temporal, Temporal)}\n passing {@code this} as the first argument and the converted input temporal\n as the second argument.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param endExclusive  the end date, exclusive, which is converted to an {@code Instant}, not null\n @param unit  the unit to measure the amount in, not null\n @return the amount of time between this instant and the end instant\n @throws DateTimeException if the amount cannot be calculated, or the end\n  temporal cannot be converted to an {@code Instant}\n @throws UnsupportedTemporalTypeException if the unit is not supported\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "java.time.temporal.Temporal"
                      "java.time.temporal.TemporalUnit"]))}
  (^long
   [^java.time.Instant this ^java.time.temporal.Temporal end-exclusive
    ^java.time.temporal.ChronoUnit unit]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-clj
     (.until this end-exclusive unit))))

(defn from
  "Obtains an instance of {@code Instant} from a temporal object.\n <p>\n This obtains an instant based on the specified temporal.\n A {@code TemporalAccessor} represents an arbitrary set of date and time information,\n which this factory converts to an instance of {@code Instant}.\n <p>\n The conversion extracts the {@link ChronoField#INSTANT_SECONDS INSTANT_SECONDS}\n and {@link ChronoField#NANO_OF_SECOND NANO_OF_SECOND} fields.\n <p>\n This method matches the signature of the functional interface {@link TemporalQuery}\n allowing it to be used as a query via method reference, {@code Instant::from}.\n\n @param temporal  the temporal object to convert, not null\n @return the instant, not null\n @throws DateTimeException if unable to convert to an {@code Instant}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^java.time.Instant [^java.time.temporal.TemporalAccessor temporal]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-clj
     (java.time.Instant/from temporal))))

(defn is-after
  "Checks if this instant is after the specified instant.\n <p>\n The comparison is based on the time-line position of the instants.\n\n @param otherInstant  the other instant to compare to, not null\n @return true if this instant is after the specified instant\n @throws NullPointerException if otherInstant is null"
  {:arglists (quote (["java.time.Instant" "java.time.Instant"]))}
  (^java.lang.Boolean [^java.time.Instant this ^java.time.Instant other-instant]
   (.isAfter this other-instant)))

(defn minus-nanos
  "Returns a copy of this instant with the specified duration in nanoseconds subtracted.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param nanosToSubtract  the nanoseconds to subtract, positive or negative\n @return an {@code Instant} based on this instant with the specified nanoseconds subtracted, not null\n @throws DateTimeException if the result exceeds the maximum or minimum instant\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "long"]))}
  (^java.time.Instant [^java.time.Instant this ^long nanos-to-subtract]
   (.minusNanos this nanos-to-subtract)))

(defn is-supported
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalField"]
                     ["java.time.Instant" "java.time.temporal.TemporalUnit"]))}
  (^java.lang.Boolean [this arg0]
   (clojure.core/cond
     (clojure.core/and (clojure.core/instance? java.time.temporal.TemporalField
                                               arg0))
       (clojure.core/let [field ^"java.time.temporal.TemporalField" arg0]
         (.isSupported ^java.time.Instant this field))
     (clojure.core/and (clojure.core/instance? java.time.temporal.ChronoUnit
                                               arg0))
       (clojure.core/let [unit ^"java.time.temporal.ChronoUnit" arg0]
         (.isSupported ^java.time.Instant this unit))
     :else (throw (java.lang.IllegalArgumentException.
                    "no corresponding java.time method with these args")))))

(defn parse
  "Obtains an instance of {@code Instant} from a text string such as\n {@code 2007-12-03T10:15:30.00Z}.\n <p>\n The string must represent a valid instant in UTC and is parsed using\n {@link DateTimeFormatter#ISO_INSTANT}.\n\n @param text  the text to parse, not null\n @return the parsed instant, not null\n @throws DateTimeParseException if the text cannot be parsed"
  {:arglists (quote (["java.lang.CharSequence"]))}
  (^java.time.Instant [^java.lang.CharSequence text]
   (java.time.Instant/parse text)))

(defn hash-code
  "Returns a hash code for this instant.\n\n @return a suitable hash code"
  {:arglists (quote (["java.time.Instant"]))}
  (^java.lang.Integer [^java.time.Instant this] (.hashCode this)))

(defn adjust-into
  "Adjusts the specified temporal object to have this instant.\n <p>\n This returns a temporal object of the same observable type as the input\n with the instant changed to be the same as this.\n <p>\n The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}\n twice, passing {@link ChronoField#INSTANT_SECONDS} and\n {@link ChronoField#NANO_OF_SECOND} as the fields.\n <p>\n In most cases, it is clearer to reverse the calling pattern by using\n {@link Temporal#with(TemporalAdjuster)}:\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   temporal = thisInstant.adjustInto(temporal);\n   temporal = temporal.with(thisInstant);\n </pre>\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param temporal  the target object to be adjusted, not null\n @return the adjusted object, not null\n @throws DateTimeException if unable to make the adjustment\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "java.time.temporal.Temporal"]))}
  (^java.time.temporal.Temporal
   [^java.time.Instant this ^java.time.temporal.Temporal temporal]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-clj
     (.adjustInto this temporal))))

(defn with
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalAdjuster"]
                     ["java.time.Instant" "java.time.temporal.TemporalField"
                      "long"]))}
  (^java.time.Instant
   [^java.time.Instant this ^java.time.temporal.TemporalAdjuster adjuster]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-clj (.with this
                                                                     adjuster)))
  (^java.time.Instant
   [^java.time.Instant this ^java.time.temporal.TemporalField field
    ^long new-value]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-clj
     (.with this field new-value))))

(defn now
  {:arglists (quote ([] ["java.time.Clock"]))}
  (^java.time.Instant [] (java.time.Instant/now))
  (^java.time.Instant [^java.time.Clock clock] (java.time.Instant/now clock)))

(defn to-epoch-milli
  "Converts this instant to the number of milliseconds from the epoch\n of 1970-01-01T00:00:00Z.\n <p>\n If this instant represents a point on the time-line too far in the future\n or past to fit in a {@code long} milliseconds, then an exception is thrown.\n <p>\n If this instant has greater than millisecond precision, then the conversion\n will drop any excess precision information as though the amount in nanoseconds\n was subject to integer division by one million.\n\n @return the number of milliseconds since the epoch of 1970-01-01T00:00:00Z\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant"]))}
  (^long [^java.time.Instant this] (.toEpochMilli this)))

(defn get-epoch-second
  "Gets the number of seconds from the Java epoch of 1970-01-01T00:00:00Z.\n <p>\n The epoch second count is a simple incrementing count of seconds where\n second 0 is 1970-01-01T00:00:00Z.\n The nanosecond part of the day is returned by {@code getNanosOfSecond}.\n\n @return the seconds from the epoch of 1970-01-01T00:00:00Z"
  {:arglists (quote (["java.time.Instant"]))}
  (^long [^java.time.Instant this] (.getEpochSecond this)))

(defn compare-to
  "Compares this instant to the specified instant.\n <p>\n The comparison is based on the time-line position of the instants.\n It is \"consistent with equals\", as defined by {@link Comparable}.\n\n @param otherInstant  the other instant to compare to, not null\n @return the comparator value, negative if less, positive if greater\n @throws NullPointerException if otherInstant is null"
  {:arglists (quote (["java.time.Instant" "java.time.Instant"]))}
  (^java.lang.Integer [^java.time.Instant this ^java.time.Instant other-instant]
   (.compareTo this other-instant)))

(defn plus-seconds
  "Returns a copy of this instant with the specified duration in seconds added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param secondsToAdd  the seconds to add, positive or negative\n @return an {@code Instant} based on this instant with the specified seconds added, not null\n @throws DateTimeException if the result exceeds the maximum or minimum instant\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "long"]))}
  (^java.time.Instant [^java.time.Instant this ^long seconds-to-add]
   (.plusSeconds this seconds-to-add)))

(defn get
  "Gets the value of the specified field from this instant as an {@code int}.\n <p>\n This queries this instant for the value of the specified field.\n The returned value will always be within the valid range of values for the field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return valid\n values based on this date-time, except {@code INSTANT_SECONDS} which is too\n large to fit in an {@code int} and throws a {@code DateTimeException}.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained or\n         the value is outside the range of valid values for the field\n @throws UnsupportedTemporalTypeException if the field is not supported or\n         the range of values exceeds an {@code int}\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Instant" "java.time.temporal.TemporalField"]))}
  (^java.lang.Integer
   [^java.time.Instant this ^java.time.temporal.TemporalField field]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-clj (.get this
                                                                    field))))

(defn equals
  "Checks if this instant is equal to the specified instant.\n <p>\n The comparison is based on the time-line position of the instants.\n\n @param otherInstant  the other instant, null returns false\n @return true if the other instant is equal to this one"
  {:arglists (quote (["java.time.Instant" "java.lang.Object"]))}
  (^java.lang.Boolean [^java.time.Instant this ^java.lang.Object other-instant]
   (.equals this other-instant)))
