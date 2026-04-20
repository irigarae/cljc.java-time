(ns cljc.java-time.temporal.temporal-unit
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time.temporal :refer [TemporalUnit]]))

(defn add-to
  "Returns a copy of the specified temporal object with the specified period added.\n <p>\n The period added is a multiple of this unit. For example, this method\n could be used to add \"3 days\" to a date by calling this method on the\n instance representing \"days\", passing the date and the period \"3\".\n The period to be added may be negative, which is equivalent to subtraction.\n <p>\n There are two equivalent ways of using this method.\n The first is to invoke this method directly.\n The second is to use {@link Temporal#plus(long, TemporalUnit)}:\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   temporal = thisUnit.addTo(temporal);\n   temporal = temporal.plus(thisUnit);\n </pre>\n It is recommended to use the second approach, {@code plus(TemporalUnit)},\n as it is a lot clearer to read in code.\n <p>\n Implementations should perform any queries or calculations using the units\n available in {@link ChronoUnit} or the fields available in {@link ChronoField}.\n If the unit is not supported an {@code UnsupportedTemporalTypeException} must be thrown.\n <p>\n Implementations must not alter the specified temporal object.\n Instead, an adjusted copy of the original must be returned.\n This provides equivalent, safe behavior for immutable and mutable implementations.\n\n @param <R>  the type of the Temporal object\n @param temporal  the temporal object to adjust, not null\n @param amount  the amount of this unit to add, positive or negative\n @return the adjusted temporal object, not null\n @throws DateTimeException if the amount cannot be added\n @throws UnsupportedTemporalTypeException if the unit is not supported by the temporal"
  {:arglists (quote (["java.time.temporal.TemporalUnit"
                      "java.time.temporal.Temporal" "long"]))}
  (^js/JSJoda.Temporal
   [^js/JSJoda.TemporalUnit this ^js/JSJoda.Temporal temporal ^long amount]
   (.addTo this temporal amount)))

(defn between
  "Calculates the amount of time between two temporal objects.\n <p>\n This calculates the amount in terms of this unit. The start and end\n points are supplied as temporal objects and must be of compatible types.\n The implementation will convert the second type to be an instance of the\n first type before the calculating the amount.\n The result will be negative if the end is before the start.\n For example, the amount in hours between two temporal objects can be\n calculated using {@code HOURS.between(startTime, endTime)}.\n <p>\n The calculation returns a whole number, representing the number of\n complete units between the two temporals.\n For example, the amount in hours between the times 11:30 and 13:29\n will only be one hour as it is one minute short of two hours.\n <p>\n There are two equivalent ways of using this method.\n The first is to invoke this method directly.\n The second is to use {@link Temporal#until(Temporal, TemporalUnit)}:\n <pre>\n   // these two lines are equivalent\n   between = thisUnit.between(start, end);\n   between = start.until(end, thisUnit);\n </pre>\n The choice should be made based on which makes the code more readable.\n <p>\n For example, this method allows the number of days between two dates to\n be calculated:\n <pre>\n  long daysBetween = DAYS.between(start, end);\n  // or alternatively\n  long daysBetween = start.until(end, DAYS);\n </pre>\n <p>\n Implementations should perform any queries or calculations using the units\n available in {@link ChronoUnit} or the fields available in {@link ChronoField}.\n If the unit is not supported an {@code UnsupportedTemporalTypeException} must be thrown.\n Implementations must not alter the specified temporal objects.\n\n @implSpec\n Implementations must begin by checking to if the two temporals have the\n same type using {@code getClass()}. If they do not, then the result must be\n obtained by calling {@code temporal1Inclusive.until(temporal2Exclusive, this)}.\n\n @param temporal1Inclusive  the base temporal object, not null\n @param temporal2Exclusive  the other temporal object, exclusive, not null\n @return the amount of time between temporal1Inclusive and temporal2Exclusive\n  in terms of this unit; positive if temporal2Exclusive is later than\n  temporal1Inclusive, negative if earlier\n @throws DateTimeException if the amount cannot be calculated, or the end\n  temporal cannot be converted to the same type as the start temporal\n @throws UnsupportedTemporalTypeException if the unit is not supported by the temporal\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalUnit"
                      "java.time.temporal.Temporal"
                      "java.time.temporal.Temporal"]))}
  (^long
   [^js/JSJoda.TemporalUnit this ^js/JSJoda.Temporal temporal1-inclusive
    ^js/JSJoda.Temporal temporal2-exclusive]
   (.between this temporal1-inclusive temporal2-exclusive)))

(defn get-duration
  "Gets the duration of this unit, which may be an estimate.\n <p>\n All units return a duration measured in standard nanoseconds from this method.\n The duration will be positive and non-zero.\n For example, an hour has a duration of {@code 60 * 60 * 1,000,000,000ns}.\n <p>\n Some units may return an accurate duration while others return an estimate.\n For example, days have an estimated duration due to the possibility of\n daylight saving time changes.\n To determine if the duration is an estimate, use {@link #isDurationEstimated()}.\n\n @return the duration of this unit, which may be an estimate, not null"
  {:arglists (quote (["java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.Duration [^js/JSJoda.TemporalUnit this] (.duration this)))

(defn is-date-based
  "Checks if this unit represents a component of a date.\n <p>\n A date is time-based if it can be used to imply meaning from a date.\n It must have a {@linkplain #getDuration() duration} that is an integral\n multiple of the length of a standard day.\n Note that it is valid for both {@code isDateBased()} and {@code isTimeBased()}\n to return false, such as when representing a unit like 36 hours.\n\n @return true if this unit is a component of a date"
  {:arglists (quote (["java.time.temporal.TemporalUnit"]))}
  (^boolean [^js/JSJoda.TemporalUnit this] (.isDateBased this)))

(defn is-duration-estimated
  "Checks if the duration of the unit is an estimate.\n <p>\n All units have a duration, however the duration is not always accurate.\n For example, days have an estimated duration due to the possibility of\n daylight saving time changes.\n This method returns true if the duration is an estimate and false if it is\n accurate. Note that accurate/estimated ignores leap seconds.\n\n @return true if the duration is estimated, false if accurate"
  {:arglists (quote (["java.time.temporal.TemporalUnit"]))}
  (^boolean [^js/JSJoda.TemporalUnit this] (.isDurationEstimated this)))

(defn is-supported-by
  "Checks if this unit is supported by the specified temporal object.\n <p>\n This checks that the implementing date-time can add/subtract this unit.\n This can be used to avoid throwing an exception.\n <p>\n This default implementation derives the value using\n {@link Temporal#plus(long, TemporalUnit)}.\n\n @param temporal  the temporal object to check, not null\n @return true if the unit is supported"
  {:arglists (quote (["java.time.temporal.TemporalUnit"
                      "java.time.temporal.Temporal"]))}
  (^boolean [^js/JSJoda.TemporalUnit this ^js/JSJoda.Temporal temporal]
   (.isSupportedBy this temporal)))

(defn is-time-based
  "Checks if this unit represents a component of a time.\n <p>\n A unit is time-based if it can be used to imply meaning from a time.\n It must have a {@linkplain #getDuration() duration} that divides into\n the length of a standard day without remainder.\n Note that it is valid for both {@code isDateBased()} and {@code isTimeBased()}\n to return false, such as when representing a unit like 36 hours.\n\n @return true if this unit is a component of a time"
  {:arglists (quote (["java.time.temporal.TemporalUnit"]))}
  (^boolean [^js/JSJoda.TemporalUnit this] (.isTimeBased this)))

(defn to-string
  "Gets a descriptive name for the unit.\n <p>\n This should be in the plural and upper-first camel case, such as 'Days' or 'Minutes'.\n\n @return the name of this unit, not null"
  {:arglists (quote (["java.time.temporal.TemporalUnit"]))}
  (^java.lang.String [^js/JSJoda.TemporalUnit this] (.toString this)))
