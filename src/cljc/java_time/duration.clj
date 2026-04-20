(ns cljc.java-time.duration
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time Duration]))

(def zero java.time.Duration/ZERO)

(defn minus-minutes
  "Returns a copy of this duration with the specified duration in minutes subtracted.\n <p>\n The number of hours is multiplied by 60 to obtain the number of seconds to subtract.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param minutesToSubtract  the minutes to subtract, positive or negative\n @return a {@code Duration} based on this duration with the specified minutes subtracted, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^java.time.Duration [^java.time.Duration this ^long minutes-to-subtract]
   (.minusMinutes this minutes-to-subtract)))

(defn to-nanos
  "Converts this duration to the total length in nanoseconds expressed as a {@code long}.\n <p>\n If this duration is too large to fit in a {@code long} nanoseconds, then an\n exception is thrown.\n\n @return the total length of the duration in nanoseconds\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration"]))}
  (^long [^java.time.Duration this] (.toNanos this)))

(defn minus-millis
  "Returns a copy of this duration with the specified duration in milliseconds subtracted.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param millisToSubtract  the milliseconds to subtract, positive or negative\n @return a {@code Duration} based on this duration with the specified milliseconds subtracted, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^java.time.Duration [^java.time.Duration this ^long millis-to-subtract]
   (.minusMillis this millis-to-subtract)))

(defn minus-hours
  "Returns a copy of this duration with the specified duration in hours subtracted.\n <p>\n The number of hours is multiplied by 3600 to obtain the number of seconds to subtract.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param hoursToSubtract  the hours to subtract, positive or negative\n @return a {@code Duration} based on this duration with the specified hours subtracted, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^java.time.Duration [^java.time.Duration this ^long hours-to-subtract]
   (.minusHours this hours-to-subtract)))

(defn of-days
  "Obtains a {@code Duration} representing a number of standard 24 hour days.\n <p>\n The seconds are calculated based on the standard definition of a day,\n where each day is 86400 seconds which implies a 24 hour day.\n The nanosecond in second field is set to zero.\n\n @param days  the number of days, positive or negative\n @return a {@code Duration}, not null\n @throws ArithmeticException if the input days exceeds the capacity of {@code Duration}"
  {:arglists (quote (["long"]))}
  (^java.time.Duration [^long days] (java.time.Duration/ofDays days)))

(defn is-negative
  "Checks if this duration is negative, excluding zero.\n <p>\n A {@code Duration} represents a directed distance between two points on\n the time-line and can therefore be positive, zero or negative.\n This method checks whether the length is less than zero.\n\n @return true if this duration has a total length less than zero"
  {:arglists (quote (["java.time.Duration"]))}
  (^java.lang.Boolean [^java.time.Duration this] (.isNegative this)))

(defn of
  "Obtains a {@code Duration} representing an amount in the specified unit.\n <p>\n The parameters represent the two parts of a phrase like '6 Hours'. For example:\n <pre>\n  Duration.of(3, SECONDS);\n  Duration.of(465, HOURS);\n </pre>\n Only a subset of units are accepted by this method.\n The unit must either have an {@linkplain TemporalUnit#isDurationEstimated() exact duration} or\n be {@link ChronoUnit#DAYS} which is treated as 24 hours. Other units throw an exception.\n\n @param amount  the amount of the duration, measured in terms of the unit, positive or negative\n @param unit  the unit that the duration is measured in, must have an exact duration, not null\n @return a {@code Duration}, not null\n @throws DateTimeException if the period unit has an estimated duration\n @throws ArithmeticException if a numeric overflow occurs"
  {:arglists (quote (["long" "java.time.temporal.TemporalUnit"]))}
  (^java.time.Duration [^long amount ^java.time.temporal.ChronoUnit unit]
   (java.time.Duration/of amount unit)))

(defn is-zero
  "Checks if this duration is zero length.\n <p>\n A {@code Duration} represents a directed distance between two points on\n the time-line and can therefore be positive, zero or negative.\n This method checks whether the length is zero.\n\n @return true if this duration has a total length equal to zero"
  {:arglists (quote (["java.time.Duration"]))}
  (^java.lang.Boolean [^java.time.Duration this] (.isZero this)))

(defn multiplied-by
  "Returns a copy of this duration multiplied by the scalar.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param multiplicand  the value to multiply the duration by, positive or negative\n @return a {@code Duration} based on this duration multiplied by the specified scalar, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^java.time.Duration [^java.time.Duration this ^long multiplicand]
   (.multipliedBy this multiplicand)))

(defn with-nanos
  "Returns a copy of this duration with the specified nano-of-second.\n <p>\n This returns a duration with the specified nano-of-second, retaining the\n seconds part of this duration.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param nanoOfSecond  the nano-of-second to represent, from 0 to 999,999,999\n @return a {@code Duration} based on this period with the requested nano-of-second, not null\n @throws DateTimeException if the nano-of-second is invalid"
  {:arglists (quote (["java.time.Duration" "int"]))}
  (^java.time.Duration
   [^java.time.Duration this ^java.lang.Integer nano-of-second]
   (.withNanos this nano-of-second)))

(defn get-units
  "Gets the set of units supported by this duration.\n <p>\n The supported units are {@link ChronoUnit#SECONDS SECONDS},\n and {@link ChronoUnit#NANOS NANOS}.\n They are returned in the order seconds, nanos.\n <p>\n This set can be used in conjunction with {@link #get(TemporalUnit)}\n to access the entire state of the duration.\n\n @return a list containing the seconds and nanos units, not null"
  {:arglists (quote (["java.time.Duration"]))}
  (^java.util.List [^java.time.Duration this] (.getUnits this)))

(defn get-nano
  "Gets the number of nanoseconds within the second in this duration.\n <p>\n The length of the duration is stored using two fields - seconds and nanoseconds.\n The nanoseconds part is a value from 0 to 999,999,999 that is an adjustment to\n the length in seconds.\n The total duration is defined by calling this method and {@link #getSeconds()}.\n <p>\n A {@code Duration} represents a directed distance between two points on the time-line.\n A negative duration is expressed by the negative sign of the seconds part.\n A duration of -1 nanosecond is stored as -1 seconds plus 999,999,999 nanoseconds.\n\n @return the nanoseconds within the second part of the length of the duration, from 0 to 999,999,999"
  {:arglists (quote (["java.time.Duration"]))}
  (^java.lang.Integer [^java.time.Duration this] (.getNano this)))

(defn plus-millis
  "Returns a copy of this duration with the specified duration in milliseconds added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param millisToAdd  the milliseconds to add, positive or negative\n @return a {@code Duration} based on this duration with the specified milliseconds added, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^java.time.Duration [^java.time.Duration this ^long millis-to-add]
   (.plusMillis this millis-to-add)))

(defn to-minutes
  "Gets the number of minutes in this duration.\n <p>\n This returns the total number of minutes in the duration by dividing the\n number of seconds by 60.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @return the number of minutes in the duration, may be negative"
  {:arglists (quote (["java.time.Duration"]))}
  (^long [^java.time.Duration this] (.toMinutes this)))

(defn minus-seconds
  "Returns a copy of this duration with the specified duration in seconds subtracted.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param secondsToSubtract  the seconds to subtract, positive or negative\n @return a {@code Duration} based on this duration with the specified seconds subtracted, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^java.time.Duration [^java.time.Duration this ^long seconds-to-subtract]
   (.minusSeconds this seconds-to-subtract)))

(defn plus-nanos
  "Returns a copy of this duration with the specified duration in nanoseconds added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param nanosToAdd  the nanoseconds to add, positive or negative\n @return a {@code Duration} based on this duration with the specified nanoseconds added, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^java.time.Duration [^java.time.Duration this ^long nanos-to-add]
   (.plusNanos this nanos-to-add)))

(defn plus
  {:arglists (quote (["java.time.Duration" "java.time.Duration"]
                     ["java.time.Duration" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.Duration [^java.time.Duration this ^java.time.Duration duration]
   (.plus this duration))
  (^java.time.Duration
   [^java.time.Duration this ^long amount-to-add
    ^java.time.temporal.ChronoUnit unit]
   (.plus this amount-to-add unit)))

(defn divided-by
  "Returns a copy of this duration divided by the specified value.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param divisor  the value to divide the duration by, positive or negative, not zero\n @return a {@code Duration} based on this duration divided by the specified divisor, not null\n @throws ArithmeticException if the divisor is zero or if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^java.time.Duration [^java.time.Duration this ^long divisor]
   (.dividedBy this divisor)))

(defn plus-minutes
  "Returns a copy of this duration with the specified duration in minutes added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param minutesToAdd  the minutes to add, positive or negative\n @return a {@code Duration} based on this duration with the specified minutes added, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^java.time.Duration [^java.time.Duration this ^long minutes-to-add]
   (.plusMinutes this minutes-to-add)))

(defn to-string
  "A string representation of this duration using ISO-8601 seconds\n based representation, such as {@code PT8H6M12.345S}.\n <p>\n The format of the returned string will be {@code PTnHnMnS}, where n is\n the relevant hours, minutes or seconds part of the duration.\n Any fractional seconds are placed after a decimal point i the seconds section.\n If a section has a zero value, it is omitted.\n The hours, minutes and seconds will all have the same sign.\n <p>\n Examples:\n <pre>\n    \"20.345 seconds\"                 -- \"PT20.345S\n    \"15 minutes\" (15 * 60 seconds)   -- \"PT15M\"\n    \"10 hours\" (10 * 3600 seconds)   -- \"PT10H\"\n    \"2 days\" (2 * 86400 seconds)     -- \"PT48H\"\n </pre>\n Note that multiples of 24 hours are not output as days to avoid confusion\n with {@code Period}.\n\n @return an ISO-8601 representation of this duration, not null"
  {:arglists (quote (["java.time.Duration"]))}
  (^java.lang.String [^java.time.Duration this] (.toString this)))

(defn minus
  {:arglists (quote (["java.time.Duration" "java.time.Duration"]
                     ["java.time.Duration" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.Duration [^java.time.Duration this ^java.time.Duration duration]
   (.minus this duration))
  (^java.time.Duration
   [^java.time.Duration this ^long amount-to-subtract
    ^java.time.temporal.ChronoUnit unit]
   (.minus this amount-to-subtract unit)))

(defn add-to
  "Adds this duration to the specified temporal object.\n <p>\n This returns a temporal object of the same observable type as the input\n with this duration added.\n <p>\n In most cases, it is clearer to reverse the calling pattern by using\n {@link Temporal#plus(TemporalAmount)}.\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   dateTime = thisDuration.addTo(dateTime);\n   dateTime = dateTime.plus(thisDuration);\n </pre>\n <p>\n The calculation will add the seconds, then nanos.\n Only non-zero amounts will be added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param temporal  the temporal object to adjust, not null\n @return an object of the same type with the adjustment made, not null\n @throws DateTimeException if unable to add\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "java.time.temporal.Temporal"]))}
  (^java.time.temporal.Temporal
   [^java.time.Duration this ^java.time.temporal.Temporal temporal]
   (.addTo this temporal)))

(defn plus-hours
  "Returns a copy of this duration with the specified duration in hours added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param hoursToAdd  the hours to add, positive or negative\n @return a {@code Duration} based on this duration with the specified hours added, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^java.time.Duration [^java.time.Duration this ^long hours-to-add]
   (.plusHours this hours-to-add)))

(defn plus-days
  "Returns a copy of this duration with the specified duration in standard 24 hour days added.\n <p>\n The number of days is multiplied by 86400 to obtain the number of seconds to add.\n This is based on the standard definition of a day as 24 hours.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param daysToAdd  the days to add, positive or negative\n @return a {@code Duration} based on this duration with the specified days added, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^java.time.Duration [^java.time.Duration this ^long days-to-add]
   (.plusDays this days-to-add)))

(defn of-hours
  "Obtains a {@code Duration} representing a number of standard hours.\n <p>\n The seconds are calculated based on the standard definition of an hour,\n where each hour is 3600 seconds.\n The nanosecond in second field is set to zero.\n\n @param hours  the number of hours, positive or negative\n @return a {@code Duration}, not null\n @throws ArithmeticException if the input hours exceeds the capacity of {@code Duration}"
  {:arglists (quote (["long"]))}
  (^java.time.Duration [^long hours] (java.time.Duration/ofHours hours)))

(defn to-millis
  "Converts this duration to the total length in milliseconds.\n <p>\n If this duration is too large to fit in a {@code long} milliseconds, then an\n exception is thrown.\n <p>\n If this duration has greater than millisecond precision, then the conversion\n will drop any excess precision information as though the amount in nanoseconds\n was subject to integer division by one million.\n\n @return the total length of the duration in milliseconds\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration"]))}
  (^long [^java.time.Duration this] (.toMillis this)))

(defn to-hours
  "Gets the number of hours in this duration.\n <p>\n This returns the total number of hours in the duration by dividing the\n number of seconds by 3600.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @return the number of hours in the duration, may be negative"
  {:arglists (quote (["java.time.Duration"]))}
  (^long [^java.time.Duration this] (.toHours this)))

(defn of-nanos
  "Obtains a {@code Duration} representing a number of nanoseconds.\n <p>\n The seconds and nanoseconds are extracted from the specified nanoseconds.\n\n @param nanos  the number of nanoseconds, positive or negative\n @return a {@code Duration}, not null"
  {:arglists (quote (["long"]))}
  (^java.time.Duration [^long nanos] (java.time.Duration/ofNanos nanos)))

(defn of-millis
  "Obtains a {@code Duration} representing a number of milliseconds.\n <p>\n The seconds and nanoseconds are extracted from the specified milliseconds.\n\n @param millis  the number of milliseconds, positive or negative\n @return a {@code Duration}, not null"
  {:arglists (quote (["long"]))}
  (^java.time.Duration [^long millis] (java.time.Duration/ofMillis millis)))

(defn negated
  "Returns a copy of this duration with the length negated.\n <p>\n This method swaps the sign of the total length of this duration.\n For example, {@code PT1.3S} will be returned as {@code PT-1.3S}.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @return a {@code Duration} based on this duration with the amount negated, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration"]))}
  (^java.time.Duration [^java.time.Duration this] (.negated this)))

(defn abs
  "Returns a copy of this duration with a positive length.\n <p>\n This method returns a positive duration by effectively removing the sign from any negative total length.\n For example, {@code PT-1.3S} will be returned as {@code PT1.3S}.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @return a {@code Duration} based on this duration with an absolute length, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration"]))}
  (^java.time.Duration [^java.time.Duration this] (.abs this)))

(defn between
  "Obtains a {@code Duration} representing the duration between two temporal objects.\n <p>\n This calculates the duration between two temporal objects. If the objects\n are of different types, then the duration is calculated based on the type\n of the first object. For example, if the first argument is a {@code LocalTime}\n then the second argument is converted to a {@code LocalTime}.\n <p>\n The specified temporal objects must support the {@link ChronoUnit#SECONDS SECONDS} unit.\n For full accuracy, either the {@link ChronoUnit#NANOS NANOS} unit or the\n {@link ChronoField#NANO_OF_SECOND NANO_OF_SECOND} field should be supported.\n <p>\n The result of this method can be a negative period if the end is before the start.\n To guarantee to obtain a positive duration call {@link #abs()} on the result.\n\n @param startInclusive  the start instant, inclusive, not null\n @param endExclusive  the end instant, exclusive, not null\n @return a {@code Duration}, not null\n @throws DateTimeException if the seconds between the temporals cannot be obtained\n @throws ArithmeticException if the calculation exceeds the capacity of {@code Duration}"
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.Temporal"]))}
  (^java.time.Duration
   [^java.time.temporal.Temporal start-inclusive
    ^java.time.temporal.Temporal end-exclusive]
   (java.time.Duration/between start-inclusive end-exclusive)))

(defn get-seconds
  "Gets the number of seconds in this duration.\n <p>\n The length of the duration is stored using two fields - seconds and nanoseconds.\n The nanoseconds part is a value from 0 to 999,999,999 that is an adjustment to\n the length in seconds.\n The total duration is defined by calling this method and {@link #getNano()}.\n <p>\n A {@code Duration} represents a directed distance between two points on the time-line.\n A negative duration is expressed by the negative sign of the seconds part.\n A duration of -1 nanosecond is stored as -1 seconds plus 999,999,999 nanoseconds.\n\n @return the whole seconds part of the length of the duration, positive or negative"
  {:arglists (quote (["java.time.Duration"]))}
  (^long [^java.time.Duration this] (.getSeconds this)))

(defn from
  "Obtains an instance of {@code Duration} from a temporal amount.\n <p>\n This obtains a duration based on the specified amount.\n A {@code TemporalAmount} represents an  amount of time, which may be\n date-based or time-based, which this factory extracts to a duration.\n <p>\n The conversion loops around the set of units from the amount and uses\n the {@linkplain TemporalUnit#getDuration() duration} of the unit to\n calculate the total {@code Duration}.\n Only a subset of units are accepted by this method. The unit must either\n have an {@linkplain TemporalUnit#isDurationEstimated() exact duration}\n or be {@link ChronoUnit#DAYS} which is treated as 24 hours.\n If any other units are found then an exception is thrown.\n\n @param amount  the temporal amount to convert, not null\n @return the equivalent duration, not null\n @throws DateTimeException if unable to convert to a {@code Duration}\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalAmount"]))}
  (^java.time.Duration [^java.time.temporal.TemporalAmount amount]
   (java.time.Duration/from amount)))

(defn minus-nanos
  "Returns a copy of this duration with the specified duration in nanoseconds subtracted.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param nanosToSubtract  the nanoseconds to subtract, positive or negative\n @return a {@code Duration} based on this duration with the specified nanoseconds subtracted, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^java.time.Duration [^java.time.Duration this ^long nanos-to-subtract]
   (.minusNanos this nanos-to-subtract)))

(defn parse
  "Obtains a {@code Duration} from a text string such as {@code PnDTnHnMn.nS}.\n <p>\n This will parse a textual representation of a duration, including the\n string produced by {@code toString()}. The formats accepted are based\n on the ISO-8601 duration format {@code PnDTnHnMn.nS} with days\n considered to be exactly 24 hours.\n <p>\n The string starts with an optional sign, denoted by the ASCII negative\n or positive symbol. If negative, the whole period is negated.\n The ASCII letter \"P\" is next in upper or lower case.\n There are then four sections, each consisting of a number and a suffix.\n The sections have suffixes in ASCII of \"D\", \"H\", \"M\" and \"S\" for\n days, hours, minutes and seconds, accepted in upper or lower case.\n The suffixes must occur in order. The ASCII letter \"T\" must occur before\n the first occurrence, if any, of an hour, minute or second section.\n At least one of the four sections must be present, and if \"T\" is present\n there must be at least one section after the \"T\".\n The number part of each section must consist of one or more ASCII digits.\n The number may be prefixed by the ASCII negative or positive symbol.\n The number of days, hours and minutes must parse to an {@code long}.\n The number of seconds must parse to an {@code long} with optional fraction.\n The decimal point may be either a dot or a comma.\n The fractional part may have from zero to 9 digits.\n <p>\n The leading plus/minus sign, and negative values for other units are\n not part of the ISO-8601 standard.\n <p>\n Examples:\n <pre>\n    \"PT20.345S\" -- parses as \"20.345 seconds\"\n    \"PT15M\"     -- parses as \"15 minutes\" (where a minute is 60 seconds)\n    \"PT10H\"     -- parses as \"10 hours\" (where an hour is 3600 seconds)\n    \"P2D\"       -- parses as \"2 days\" (where a day is 24 hours or 86400 seconds)\n    \"P2DT3H4M\"  -- parses as \"2 days, 3 hours and 4 minutes\"\n    \"P-6H3M\"    -- parses as \"-6 hours and +3 minutes\"\n    \"-P6H3M\"    -- parses as \"-6 hours and -3 minutes\"\n    \"-P-6H+3M\"  -- parses as \"+6 hours and -3 minutes\"\n </pre>\n\n @param text  the text to parse, not null\n @return the parsed duration, not null\n @throws DateTimeParseException if the text cannot be parsed to a duration"
  {:arglists (quote (["java.lang.CharSequence"]))}
  (^java.time.Duration [^java.lang.CharSequence text]
   (java.time.Duration/parse text)))

(defn hash-code
  "A hash code for this duration.\n\n @return a suitable hash code"
  {:arglists (quote (["java.time.Duration"]))}
  (^java.lang.Integer [^java.time.Duration this] (.hashCode this)))

(defn with-seconds
  "Returns a copy of this duration with the specified amount of seconds.\n <p>\n This returns a duration with the specified seconds, retaining the\n nano-of-second part of this duration.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param seconds  the seconds to represent, may be negative\n @return a {@code Duration} based on this period with the requested seconds, not null"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^java.time.Duration [^java.time.Duration this ^long seconds]
   (.withSeconds this seconds)))

(defn of-minutes
  "Obtains a {@code Duration} representing a number of standard minutes.\n <p>\n The seconds are calculated based on the standard definition of a minute,\n where each minute is 60 seconds.\n The nanosecond in second field is set to zero.\n\n @param minutes  the number of minutes, positive or negative\n @return a {@code Duration}, not null\n @throws ArithmeticException if the input minutes exceeds the capacity of {@code Duration}"
  {:arglists (quote (["long"]))}
  (^java.time.Duration [^long minutes] (java.time.Duration/ofMinutes minutes)))

(defn subtract-from
  "Subtracts this duration from the specified temporal object.\n <p>\n This returns a temporal object of the same observable type as the input\n with this duration subtracted.\n <p>\n In most cases, it is clearer to reverse the calling pattern by using\n {@link Temporal#minus(TemporalAmount)}.\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   dateTime = thisDuration.subtractFrom(dateTime);\n   dateTime = dateTime.minus(thisDuration);\n </pre>\n <p>\n The calculation will subtract the seconds, then nanos.\n Only non-zero amounts will be added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param temporal  the temporal object to adjust, not null\n @return an object of the same type with the adjustment made, not null\n @throws DateTimeException if unable to subtract\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "java.time.temporal.Temporal"]))}
  (^java.time.temporal.Temporal
   [^java.time.Duration this ^java.time.temporal.Temporal temporal]
   (.subtractFrom this temporal)))

(defn compare-to
  "Compares this duration to the specified {@code Duration}.\n <p>\n The comparison is based on the total length of the durations.\n It is \"consistent with equals\", as defined by {@link Comparable}.\n\n @param otherDuration  the other duration to compare to, not null\n @return the comparator value, negative if less, positive if greater"
  {:arglists (quote (["java.time.Duration" "java.time.Duration"]))}
  (^java.lang.Integer
   [^java.time.Duration this ^java.time.Duration other-duration]
   (.compareTo this other-duration)))

(defn plus-seconds
  "Returns a copy of this duration with the specified duration in seconds added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param secondsToAdd  the seconds to add, positive or negative\n @return a {@code Duration} based on this duration with the specified seconds added, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^java.time.Duration [^java.time.Duration this ^long seconds-to-add]
   (.plusSeconds this seconds-to-add)))

(defn get
  "Gets the value of the requested unit.\n <p>\n This returns a value for each of the two supported units,\n {@link ChronoUnit#SECONDS SECONDS} and {@link ChronoUnit#NANOS NANOS}.\n All other units throw an exception.\n\n @param unit the {@code TemporalUnit} for which to return the value\n @return the long value of the unit\n @throws DateTimeException if the unit is not supported\n @throws UnsupportedTemporalTypeException if the unit is not supported"
  {:arglists (quote (["java.time.Duration" "java.time.temporal.TemporalUnit"]))}
  (^long [^java.time.Duration this ^java.time.temporal.ChronoUnit unit]
   (.get this unit)))

(defn equals
  "Checks if this duration is equal to the specified {@code Duration}.\n <p>\n The comparison is based on the total length of the durations.\n\n @param otherDuration  the other duration, null returns false\n @return true if the other duration is equal to this one"
  {:arglists (quote (["java.time.Duration" "java.lang.Object"]))}
  (^java.lang.Boolean
   [^java.time.Duration this ^java.lang.Object other-duration]
   (.equals this other-duration)))

(defn of-seconds
  {:arglists (quote (["long"] ["long" "long"]))}
  (^java.time.Duration [^long seconds] (java.time.Duration/ofSeconds seconds))
  (^java.time.Duration [^long seconds ^long nano-adjustment]
   (java.time.Duration/ofSeconds seconds nano-adjustment)))

(defn minus-days
  "Returns a copy of this duration with the specified duration in standard 24 hour days subtracted.\n <p>\n The number of days is multiplied by 86400 to obtain the number of seconds to subtract.\n This is based on the standard definition of a day as 24 hours.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param daysToSubtract  the days to subtract, positive or negative\n @return a {@code Duration} based on this duration with the specified days subtracted, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Duration" "long"]))}
  (^java.time.Duration [^java.time.Duration this ^long days-to-subtract]
   (.minusDays this days-to-subtract)))

(defn to-days
  "Gets the number of days in this duration.\n <p>\n This returns the total number of days in the duration by dividing the\n number of seconds by 86400.\n This is based on the standard definition of a day as 24 hours.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @return the number of days in the duration, may be negative"
  {:arglists (quote (["java.time.Duration"]))}
  (^long [^java.time.Duration this] (.toDays this)))
