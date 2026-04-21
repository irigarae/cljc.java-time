(ns cljc.java-time.duration
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [Duration]]))

(def zero
  "Constant for a duration of zero."
  (goog.object/get java.time.Duration "ZERO"))

(defn minus-minutes
  "Returns a copy of this duration with the specified duration in minutes subtracted.

 The number of hours is multiplied by 60 to obtain the number of seconds to subtract.

 This instance is immutable and unaffected by this method call.

 @param minutesToSubtract  the minutes to subtract, positive or negative
 @return a {@code Duration} based on this duration with the specified minutes subtracted, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^long minutes-to-subtract]
   (.minusMinutes this minutes-to-subtract)))

(defn to-nanos
  "Converts this duration to the total length in nanoseconds expressed as a {@code long}.

 If this duration is too large to fit in a {@code long} nanoseconds, then an
 exception is thrown.

 @return the total length of the duration in nanoseconds
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration"]))}
  (^long [^js/JSJoda.Duration this] (.toNanos this)))

(defn minus-millis
  "Returns a copy of this duration with the specified duration in milliseconds subtracted.

 This instance is immutable and unaffected by this method call.

 @param millisToSubtract  the milliseconds to subtract, positive or negative
 @return a {@code Duration} based on this duration with the specified milliseconds subtracted, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^long millis-to-subtract]
   (.minusMillis this millis-to-subtract)))

(defn minus-hours
  "Returns a copy of this duration with the specified duration in hours subtracted.

 The number of hours is multiplied by 3600 to obtain the number of seconds to subtract.

 This instance is immutable and unaffected by this method call.

 @param hoursToSubtract  the hours to subtract, positive or negative
 @return a {@code Duration} based on this duration with the specified hours subtracted, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^long hours-to-subtract]
   (.minusHours this hours-to-subtract)))

(defn of-days
  "Obtains a {@code Duration} representing a number of standard 24 hour days.

 The seconds are calculated based on the standard definition of a day,
 where each day is 86400 seconds which implies a 24 hour day.
 The nanosecond in second field is set to zero.

 @param days  the number of days, positive or negative
 @return a {@code Duration}, not null
 @throws ArithmeticException if the input days exceeds the capacity of {@code Duration}"
  {:arglists (quote (["long"]))}
  (^js/JSJoda.Duration [^long days]
   (js-invoke java.time.Duration "ofDays" days)))

(defn is-negative
  "Checks if this duration is negative, excluding zero.

 A {@code Duration} represents a directed distance between two points on
 the time-line and can therefore be positive, zero or negative.
 This method checks whether the length is less than zero.

 @return true if this duration has a total length less than zero"
  {:arglists (quote (["java.time.Duration"]))}
  (^boolean [^js/JSJoda.Duration this] (.isNegative this)))

(defn of
  "Obtains a {@code Duration} representing an amount in the specified unit.

 The parameters represent the two parts of a phrase like '6 Hours'. For example:
 <pre>
  Duration.of(3, SECONDS);
  Duration.of(465, HOURS);
 </pre>
 Only a subset of units are accepted by this method.
 The unit must either have an {@linkplain TemporalUnit#isDurationEstimated() exact duration} or
 be {@link ChronoUnit#DAYS} which is treated as 24 hours. Other units throw an exception.

 @param amount  the amount of the duration, measured in terms of the unit, positive or negative
 @param unit  the unit that the duration is measured in, must have an exact duration, not null
 @return a {@code Duration}, not null
 @throws DateTimeException if the period unit has an estimated duration
 @throws ArithmeticException if a numeric overflow occurs"
  {:arglists (quote (["long" "java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.Duration [^long amount ^js/JSJoda.TemporalUnit unit]
   (js-invoke java.time.Duration "of" amount unit)))

(defn is-zero
  "Checks if this duration is zero length.

 A {@code Duration} represents a directed distance between two points on
 the time-line and can therefore be positive, zero or negative.
 This method checks whether the length is zero.

 @return true if this duration has a total length equal to zero"
  {:arglists (quote (["java.time.Duration"]))}
  (^boolean [^js/JSJoda.Duration this] (.isZero this)))

(defn multiplied-by
  "Returns a copy of this duration multiplied by the scalar.

 This instance is immutable and unaffected by this method call.

 @param multiplicand  the value to multiply the duration by, positive or negative
 @return a {@code Duration} based on this duration multiplied by the specified scalar, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^long multiplicand]
   (.multipliedBy this multiplicand)))

(defn with-nanos
  "Returns a copy of this duration with the specified nano-of-second.

 This returns a duration with the specified nano-of-second, retaining the
 seconds part of this duration.

 This instance is immutable and unaffected by this method call.

 @param nanoOfSecond  the nano-of-second to represent, from 0 to 999,999,999
 @return a {@code Duration} based on this period with the requested nano-of-second, not null
 @throws DateTimeException if the nano-of-second is invalid"
  {:arglists (quote (["java.time.Duration" "int"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^int nano-of-second]
   (.withNanos this nano-of-second)))

(defn get-units
  "Gets the set of units supported by this duration.

 The supported units are {@link ChronoUnit#SECONDS SECONDS},
 and {@link ChronoUnit#NANOS NANOS}.
 They are returned in the order seconds, nanos.

 This set can be used in conjunction with {@link #get(TemporalUnit)}
 to access the entire state of the duration.

 @return a list containing the seconds and nanos units, not null"
  {:arglists (quote (["java.time.Duration"]))}
  (^java.util.List [^js/JSJoda.Duration this] (.units this)))

(defn get-nano
  "Gets the number of nanoseconds within the second in this duration.

 The length of the duration is stored using two fields - seconds and nanoseconds.
 The nanoseconds part is a value from 0 to 999,999,999 that is an adjustment to
 the length in seconds.
 The total duration is defined by calling this method and {@link #getSeconds()}.

 A {@code Duration} represents a directed distance between two points on the time-line.
 A negative duration is expressed by the negative sign of the seconds part.
 A duration of -1 nanosecond is stored as -1 seconds plus 999,999,999 nanoseconds.

 @return the nanoseconds within the second part of the length of the duration, from 0 to 999,999,999"
  {:arglists (quote (["java.time.Duration"]))}
  (^int [^js/JSJoda.Duration this] (.nano this)))

(defn plus-millis
  "Returns a copy of this duration with the specified duration in milliseconds added.

 This instance is immutable and unaffected by this method call.

 @param millisToAdd  the milliseconds to add, positive or negative
 @return a {@code Duration} based on this duration with the specified milliseconds added, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^long millis-to-add]
   (.plusMillis this millis-to-add)))

(defn to-minutes
  "Gets the number of minutes in this duration.

 This returns the total number of minutes in the duration by dividing the
 number of seconds by 60.

 This instance is immutable and unaffected by this method call.

 @return the number of minutes in the duration, may be negative"
  {:arglists (quote (["java.time.Duration"]))}
  (^long [^js/JSJoda.Duration this] (.toMinutes this)))

(defn minus-seconds
  "Returns a copy of this duration with the specified duration in seconds subtracted.

 This instance is immutable and unaffected by this method call.

 @param secondsToSubtract  the seconds to subtract, positive or negative
 @return a {@code Duration} based on this duration with the specified seconds subtracted, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^long seconds-to-subtract]
   (.minusSeconds this seconds-to-subtract)))

(defn plus-nanos
  "Returns a copy of this duration with the specified duration in nanoseconds added.

 This instance is immutable and unaffected by this method call.

 @param nanosToAdd  the nanoseconds to add, positive or negative
 @return a {@code Duration} based on this duration with the specified nanoseconds added, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^long nanos-to-add]
   (.plusNanos this nanos-to-add)))

(defn plus
  {:arglists (quote (["java.time.Duration" "java.time.Duration"]
                     ["java.time.Duration" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^js/JSJoda.Duration duration]
   (.plus this duration))
  (^js/JSJoda.Duration
   [^js/JSJoda.Duration this ^long amount-to-add ^js/JSJoda.TemporalUnit unit]
   (.plus this amount-to-add unit)))

(defn divided-by
  "Returns a copy of this duration divided by the specified value.

 This instance is immutable and unaffected by this method call.

 @param divisor  the value to divide the duration by, positive or negative, not zero
 @return a {@code Duration} based on this duration divided by the specified divisor, not null
 @throws ArithmeticException if the divisor is zero or if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^long divisor]
   (.dividedBy this divisor)))

(defn plus-minutes
  "Returns a copy of this duration with the specified duration in minutes added.

 This instance is immutable and unaffected by this method call.

 @param minutesToAdd  the minutes to add, positive or negative
 @return a {@code Duration} based on this duration with the specified minutes added, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^long minutes-to-add]
   (.plusMinutes this minutes-to-add)))

(defn to-string
  "A string representation of this duration using ISO-8601 seconds
 based representation, such as {@code PT8H6M12.345S}.

 The format of the returned string will be {@code PTnHnMnS}, where n is
 the relevant hours, minutes or seconds part of the duration.
 Any fractional seconds are placed after a decimal point i the seconds section.
 If a section has a zero value, it is omitted.
 The hours, minutes and seconds will all have the same sign.

 Examples:
 <pre>
    \"20.345 seconds\"                 -- \"PT20.345S
    \"15 minutes\" (15 * 60 seconds)   -- \"PT15M\"
    \"10 hours\" (10 * 3600 seconds)   -- \"PT10H\"
    \"2 days\" (2 * 86400 seconds)     -- \"PT48H\"
 </pre>
 Note that multiples of 24 hours are not output as days to avoid confusion
 with {@code Period}.

 @return an ISO-8601 representation of this duration, not null"
  {:arglists (quote (["java.time.Duration"]))}
  (^java.lang.String [^js/JSJoda.Duration this] (.toString this)))

(defn minus
  {:arglists (quote (["java.time.Duration" "java.time.Duration"]
                     ["java.time.Duration" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^js/JSJoda.Duration duration]
   (.minus this duration))
  (^js/JSJoda.Duration
   [^js/JSJoda.Duration this ^long amount-to-subtract
    ^js/JSJoda.TemporalUnit unit]
   (.minus this amount-to-subtract unit)))

(defn add-to
  "Adds this duration to the specified temporal object.

 This returns a temporal object of the same observable type as the input
 with this duration added.

 In most cases, it is clearer to reverse the calling pattern by using
 {@link Temporal#plus(TemporalAmount)}.
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   dateTime = thisDuration.addTo(dateTime);
   dateTime = dateTime.plus(thisDuration);
 </pre>

 The calculation will add the seconds, then nanos.
 Only non-zero amounts will be added.

 This instance is immutable and unaffected by this method call.

 @param temporal  the temporal object to adjust, not null
 @return an object of the same type with the adjustment made, not null
 @throws DateTimeException if unable to add
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Temporal [^js/JSJoda.Duration this ^js/JSJoda.Temporal temporal]
   (.addTo this temporal)))

(defn plus-hours
  "Returns a copy of this duration with the specified duration in hours added.

 This instance is immutable and unaffected by this method call.

 @param hoursToAdd  the hours to add, positive or negative
 @return a {@code Duration} based on this duration with the specified hours added, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^long hours-to-add]
   (.plusHours this hours-to-add)))

(defn plus-days
  "Returns a copy of this duration with the specified duration in standard 24 hour days added.

 The number of days is multiplied by 86400 to obtain the number of seconds to add.
 This is based on the standard definition of a day as 24 hours.

 This instance is immutable and unaffected by this method call.

 @param daysToAdd  the days to add, positive or negative
 @return a {@code Duration} based on this duration with the specified days added, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^long days-to-add]
   (.plusDays this days-to-add)))

(defn of-hours
  "Obtains a {@code Duration} representing a number of standard hours.

 The seconds are calculated based on the standard definition of an hour,
 where each hour is 3600 seconds.
 The nanosecond in second field is set to zero.

 @param hours  the number of hours, positive or negative
 @return a {@code Duration}, not null
 @throws ArithmeticException if the input hours exceeds the capacity of {@code Duration}"
  {:arglists (quote (["long"]))}
  (^js/JSJoda.Duration [^long hours]
   (js-invoke java.time.Duration "ofHours" hours)))

(defn to-millis
  "Converts this duration to the total length in milliseconds.

 If this duration is too large to fit in a {@code long} milliseconds, then an
 exception is thrown.

 If this duration has greater than millisecond precision, then the conversion
 will drop any excess precision information as though the amount in nanoseconds
 was subject to integer division by one million.

 @return the total length of the duration in milliseconds
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration"]))}
  (^long [^js/JSJoda.Duration this] (.toMillis this)))

(defn to-hours
  "Gets the number of hours in this duration.

 This returns the total number of hours in the duration by dividing the
 number of seconds by 3600.

 This instance is immutable and unaffected by this method call.

 @return the number of hours in the duration, may be negative"
  {:arglists (quote (["java.time.Duration"]))}
  (^long [^js/JSJoda.Duration this] (.toHours this)))

(defn of-nanos
  "Obtains a {@code Duration} representing a number of nanoseconds.

 The seconds and nanoseconds are extracted from the specified nanoseconds.

 @param nanos  the number of nanoseconds, positive or negative
 @return a {@code Duration}, not null"
  {:arglists (quote (["long"]))}
  (^js/JSJoda.Duration [^long nanos]
   (js-invoke java.time.Duration "ofNanos" nanos)))

(defn of-millis
  "Obtains a {@code Duration} representing a number of milliseconds.

 The seconds and nanoseconds are extracted from the specified milliseconds.

 @param millis  the number of milliseconds, positive or negative
 @return a {@code Duration}, not null"
  {:arglists (quote (["long"]))}
  (^js/JSJoda.Duration [^long millis]
   (js-invoke java.time.Duration "ofMillis" millis)))

(defn negated
  "Returns a copy of this duration with the length negated.

 This method swaps the sign of the total length of this duration.
 For example, {@code PT1.3S} will be returned as {@code PT-1.3S}.

 This instance is immutable and unaffected by this method call.

 @return a {@code Duration} based on this duration with the amount negated, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this] (.negated this)))

(defn abs
  "Returns a copy of this duration with a positive length.

 This method returns a positive duration by effectively removing the sign from any negative total length.
 For example, {@code PT-1.3S} will be returned as {@code PT1.3S}.

 This instance is immutable and unaffected by this method call.

 @return a {@code Duration} based on this duration with an absolute length, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this] (.abs this)))

(defn between
  "Obtains a {@code Duration} representing the duration between two temporal objects.

 This calculates the duration between two temporal objects. If the objects
 are of different types, then the duration is calculated based on the type
 of the first object. For example, if the first argument is a {@code LocalTime}
 then the second argument is converted to a {@code LocalTime}.

 The specified temporal objects must support the {@link ChronoUnit#SECONDS SECONDS} unit.
 For full accuracy, either the {@link ChronoUnit#NANOS NANOS} unit or the
 {@link ChronoField#NANO_OF_SECOND NANO_OF_SECOND} field should be supported.

 The result of this method can be a negative period if the end is before the start.
 To guarantee to obtain a positive duration call {@link #abs()} on the result.

 @param startInclusive  the start instant, inclusive, not null
 @param endExclusive  the end instant, exclusive, not null
 @return a {@code Duration}, not null
 @throws DateTimeException if the seconds between the temporals cannot be obtained
 @throws ArithmeticException if the calculation exceeds the capacity of {@code Duration}"
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Duration
   [^js/JSJoda.Temporal start-inclusive ^js/JSJoda.Temporal end-exclusive]
   (js-invoke java.time.Duration "between" start-inclusive end-exclusive)))

(defn get-seconds
  "Gets the number of seconds in this duration.

 The length of the duration is stored using two fields - seconds and nanoseconds.
 The nanoseconds part is a value from 0 to 999,999,999 that is an adjustment to
 the length in seconds.
 The total duration is defined by calling this method and {@link #getNano()}.

 A {@code Duration} represents a directed distance between two points on the time-line.
 A negative duration is expressed by the negative sign of the seconds part.
 A duration of -1 nanosecond is stored as -1 seconds plus 999,999,999 nanoseconds.

 @return the whole seconds part of the length of the duration, positive or negative"
  {:arglists (quote (["java.time.Duration"]))}
  (^long [^js/JSJoda.Duration this] (.seconds this)))

(defn from
  "Obtains an instance of {@code Duration} from a temporal amount.

 This obtains a duration based on the specified amount.
 A {@code TemporalAmount} represents an  amount of time, which may be
 date-based or time-based, which this factory extracts to a duration.

 The conversion loops around the set of units from the amount and uses
 the {@linkplain TemporalUnit#getDuration() duration} of the unit to
 calculate the total {@code Duration}.
 Only a subset of units are accepted by this method. The unit must either
 have an {@linkplain TemporalUnit#isDurationEstimated() exact duration}
 or be {@link ChronoUnit#DAYS} which is treated as 24 hours.
 If any other units are found then an exception is thrown.

 @param amount  the temporal amount to convert, not null
 @return the equivalent duration, not null
 @throws DateTimeException if unable to convert to a {@code Duration}
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalAmount"]))}
  (^js/JSJoda.Duration [^js/JSJoda.TemporalAmount amount]
   (js-invoke java.time.Duration "from" amount)))

(defn minus-nanos
  "Returns a copy of this duration with the specified duration in nanoseconds subtracted.

 This instance is immutable and unaffected by this method call.

 @param nanosToSubtract  the nanoseconds to subtract, positive or negative
 @return a {@code Duration} based on this duration with the specified nanoseconds subtracted, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^long nanos-to-subtract]
   (.minusNanos this nanos-to-subtract)))

(defn parse
  "Obtains a {@code Duration} from a text string such as {@code PnDTnHnMn.nS}.

 This will parse a textual representation of a duration, including the
 string produced by {@code toString()}. The formats accepted are based
 on the ISO-8601 duration format {@code PnDTnHnMn.nS} with days
 considered to be exactly 24 hours.

 The string starts with an optional sign, denoted by the ASCII negative
 or positive symbol. If negative, the whole period is negated.
 The ASCII letter \"P\" is next in upper or lower case.
 There are then four sections, each consisting of a number and a suffix.
 The sections have suffixes in ASCII of \"D\", \"H\", \"M\" and \"S\" for
 days, hours, minutes and seconds, accepted in upper or lower case.
 The suffixes must occur in order. The ASCII letter \"T\" must occur before
 the first occurrence, if any, of an hour, minute or second section.
 At least one of the four sections must be present, and if \"T\" is present
 there must be at least one section after the \"T\".
 The number part of each section must consist of one or more ASCII digits.
 The number may be prefixed by the ASCII negative or positive symbol.
 The number of days, hours and minutes must parse to an {@code long}.
 The number of seconds must parse to an {@code long} with optional fraction.
 The decimal point may be either a dot or a comma.
 The fractional part may have from zero to 9 digits.

 The leading plus/minus sign, and negative values for other units are
 not part of the ISO-8601 standard.

 Examples:
 <pre>
    \"PT20.345S\" -- parses as \"20.345 seconds\"
    \"PT15M\"     -- parses as \"15 minutes\" (where a minute is 60 seconds)
    \"PT10H\"     -- parses as \"10 hours\" (where an hour is 3600 seconds)
    \"P2D\"       -- parses as \"2 days\" (where a day is 24 hours or 86400 seconds)
    \"P2DT3H4M\"  -- parses as \"2 days, 3 hours and 4 minutes\"
    \"P-6H3M\"    -- parses as \"-6 hours and +3 minutes\"
    \"-P6H3M\"    -- parses as \"-6 hours and -3 minutes\"
    \"-P-6H+3M\"  -- parses as \"+6 hours and -3 minutes\"
 </pre>

 @param text  the text to parse, not null
 @return the parsed duration, not null
 @throws DateTimeParseException if the text cannot be parsed to a duration"
  {:arglists (quote (["java.lang.CharSequence"]))}
  (^js/JSJoda.Duration [^java.lang.CharSequence text]
   (js-invoke java.time.Duration "parse" text)))

(defn hash-code
  "A hash code for this duration.

 @return a suitable hash code"
  {:arglists (quote (["java.time.Duration"]))}
  (^int [^js/JSJoda.Duration this] (.hashCode this)))

(defn with-seconds
  "Returns a copy of this duration with the specified amount of seconds.

 This returns a duration with the specified seconds, retaining the
 nano-of-second part of this duration.

 This instance is immutable and unaffected by this method call.

 @param seconds  the seconds to represent, may be negative
 @return a {@code Duration} based on this period with the requested seconds, not null"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^long seconds]
   (.withSeconds this seconds)))

(defn of-minutes
  "Obtains a {@code Duration} representing a number of standard minutes.

 The seconds are calculated based on the standard definition of a minute,
 where each minute is 60 seconds.
 The nanosecond in second field is set to zero.

 @param minutes  the number of minutes, positive or negative
 @return a {@code Duration}, not null
 @throws ArithmeticException if the input minutes exceeds the capacity of {@code Duration}"
  {:arglists (quote (["long"]))}
  (^js/JSJoda.Duration [^long minutes]
   (js-invoke java.time.Duration "ofMinutes" minutes)))

(defn subtract-from
  "Subtracts this duration from the specified temporal object.

 This returns a temporal object of the same observable type as the input
 with this duration subtracted.

 In most cases, it is clearer to reverse the calling pattern by using
 {@link Temporal#minus(TemporalAmount)}.
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   dateTime = thisDuration.subtractFrom(dateTime);
   dateTime = dateTime.minus(thisDuration);
 </pre>

 The calculation will subtract the seconds, then nanos.
 Only non-zero amounts will be added.

 This instance is immutable and unaffected by this method call.

 @param temporal  the temporal object to adjust, not null
 @return an object of the same type with the adjustment made, not null
 @throws DateTimeException if unable to subtract
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Temporal [^js/JSJoda.Duration this ^js/JSJoda.Temporal temporal]
   (.subtractFrom this temporal)))

(defn compare-to
  "Compares this duration to the specified {@code Duration}.

 The comparison is based on the total length of the durations.
 It is \"consistent with equals\", as defined by {@link Comparable}.

 @param otherDuration  the other duration to compare to, not null
 @return the comparator value, negative if less, positive if greater"
  {:arglists (quote (["java.time.Duration" "java.time.Duration"]))}
  (^int [^js/JSJoda.Duration this ^js/JSJoda.Duration other-duration]
   (.compareTo this other-duration)))

(defn plus-seconds
  "Returns a copy of this duration with the specified duration in seconds added.

 This instance is immutable and unaffected by this method call.

 @param secondsToAdd  the seconds to add, positive or negative
 @return a {@code Duration} based on this duration with the specified seconds added, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^long seconds-to-add]
   (.plusSeconds this seconds-to-add)))

(defn get
  "Gets the value of the requested unit.

 This returns a value for each of the two supported units,
 {@link ChronoUnit#SECONDS SECONDS} and {@link ChronoUnit#NANOS NANOS}.
 All other units throw an exception.

 @param unit the {@code TemporalUnit} for which to return the value
 @return the long value of the unit
 @throws DateTimeException if the unit is not supported
 @throws UnsupportedTemporalTypeException if the unit is not supported"
  {:arglists (quote (["java.time.Duration" "java.time.temporal.TemporalUnit"]))}
  (^long [^js/JSJoda.Duration this ^js/JSJoda.TemporalUnit unit]
   (.get this unit)))

(defn equals
  "Checks if this duration is equal to the specified {@code Duration}.

 The comparison is based on the total length of the durations.

 @param otherDuration  the other duration, null returns false
 @return true if the other duration is equal to this one"
  {:arglists (quote (["java.time.Duration" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.Duration this ^java.lang.Object other-duration]
   (.equals this other-duration)))

(defn of-seconds
  {:arglists (quote (["long"] ["long" "long"]))}
  (^js/JSJoda.Duration [^long seconds]
   (js-invoke java.time.Duration "ofSeconds" seconds))
  (^js/JSJoda.Duration [^long seconds ^long nano-adjustment]
   (js-invoke java.time.Duration "ofSeconds" seconds nano-adjustment)))

(defn minus-days
  "Returns a copy of this duration with the specified duration in standard 24 hour days subtracted.

 The number of days is multiplied by 86400 to obtain the number of seconds to subtract.
 This is based on the standard definition of a day as 24 hours.

 This instance is immutable and unaffected by this method call.

 @param daysToSubtract  the days to subtract, positive or negative
 @return a {@code Duration} based on this duration with the specified days subtracted, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^js/JSJoda.Duration [^js/JSJoda.Duration this ^long days-to-subtract]
   (.minusDays this days-to-subtract)))

(defn to-days
  "Gets the number of days in this duration.

 This returns the total number of days in the duration by dividing the
 number of seconds by 86400.
 This is based on the standard definition of a day as 24 hours.

 This instance is immutable and unaffected by this method call.

 @return the number of days in the duration, may be negative"
  {:arglists (quote (["java.time.Duration"]))}
  (^long [^js/JSJoda.Duration this] (.toDays this)))
