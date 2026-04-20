(ns cljc.java-time.temporal.temporal-unit
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time.temporal TemporalUnit]))

(defn add-to
  "Returns a copy of the specified temporal object with the specified period added.

 The period added is a multiple of this unit. For example, this method
 could be used to add \"3 days\" to a date by calling this method on the
 instance representing \"days\", passing the date and the period \"3\".
 The period to be added may be negative, which is equivalent to subtraction.

 There are two equivalent ways of using this method.
 The first is to invoke this method directly.
 The second is to use {@link Temporal#plus(long, TemporalUnit)}:
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   temporal = thisUnit.addTo(temporal);
   temporal = temporal.plus(thisUnit);
 </pre>
 It is recommended to use the second approach, {@code plus(TemporalUnit)},
 as it is a lot clearer to read in code.

 Implementations should perform any queries or calculations using the units
 available in {@link ChronoUnit} or the fields available in {@link ChronoField}.
 If the unit is not supported an {@code UnsupportedTemporalTypeException} must be thrown.

 Implementations must not alter the specified temporal object.
 Instead, an adjusted copy of the original must be returned.
 This provides equivalent, safe behavior for immutable and mutable implementations.

 @param <R>  the type of the Temporal object
 @param temporal  the temporal object to adjust, not null
 @param amount  the amount of this unit to add, positive or negative
 @return the adjusted temporal object, not null
 @throws DateTimeException if the amount cannot be added
 @throws UnsupportedTemporalTypeException if the unit is not supported by the temporal"
  {:arglists (quote (["java.time.temporal.TemporalUnit"
                      "java.time.temporal.Temporal" "long"]))}
  (^java.time.temporal.Temporal
   [^java.time.temporal.ChronoUnit this ^java.time.temporal.Temporal temporal
    ^long amount]
   (.addTo this temporal amount)))

(defn between
  "Calculates the amount of time between two temporal objects.

 This calculates the amount in terms of this unit. The start and end
 points are supplied as temporal objects and must be of compatible types.
 The implementation will convert the second type to be an instance of the
 first type before the calculating the amount.
 The result will be negative if the end is before the start.
 For example, the amount in hours between two temporal objects can be
 calculated using {@code HOURS.between(startTime, endTime)}.

 The calculation returns a whole number, representing the number of
 complete units between the two temporals.
 For example, the amount in hours between the times 11:30 and 13:29
 will only be one hour as it is one minute short of two hours.

 There are two equivalent ways of using this method.
 The first is to invoke this method directly.
 The second is to use {@link Temporal#until(Temporal, TemporalUnit)}:
 <pre>
   // these two lines are equivalent
   between = thisUnit.between(start, end);
   between = start.until(end, thisUnit);
 </pre>
 The choice should be made based on which makes the code more readable.

 For example, this method allows the number of days between two dates to
 be calculated:
 <pre>
  long daysBetween = DAYS.between(start, end);
  // or alternatively
  long daysBetween = start.until(end, DAYS);
 </pre>

 Implementations should perform any queries or calculations using the units
 available in {@link ChronoUnit} or the fields available in {@link ChronoField}.
 If the unit is not supported an {@code UnsupportedTemporalTypeException} must be thrown.
 Implementations must not alter the specified temporal objects.

 @implSpec
 Implementations must begin by checking to if the two temporals have the
 same type using {@code getClass()}. If they do not, then the result must be
 obtained by calling {@code temporal1Inclusive.until(temporal2Exclusive, this)}.

 @param temporal1Inclusive  the base temporal object, not null
 @param temporal2Exclusive  the other temporal object, exclusive, not null
 @return the amount of time between temporal1Inclusive and temporal2Exclusive
  in terms of this unit; positive if temporal2Exclusive is later than
  temporal1Inclusive, negative if earlier
 @throws DateTimeException if the amount cannot be calculated, or the end
  temporal cannot be converted to the same type as the start temporal
 @throws UnsupportedTemporalTypeException if the unit is not supported by the temporal
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalUnit"
                      "java.time.temporal.Temporal"
                      "java.time.temporal.Temporal"]))}
  (^long
   [^java.time.temporal.ChronoUnit this
    ^java.time.temporal.Temporal temporal1-inclusive
    ^java.time.temporal.Temporal temporal2-exclusive]
   (.between this temporal1-inclusive temporal2-exclusive)))

(defn get-duration
  "Gets the duration of this unit, which may be an estimate.

 All units return a duration measured in standard nanoseconds from this method.
 The duration will be positive and non-zero.
 For example, an hour has a duration of {@code 60 * 60 * 1,000,000,000ns}.

 Some units may return an accurate duration while others return an estimate.
 For example, days have an estimated duration due to the possibility of
 daylight saving time changes.
 To determine if the duration is an estimate, use {@link #isDurationEstimated()}.

 @return the duration of this unit, which may be an estimate, not null"
  {:arglists (quote (["java.time.temporal.TemporalUnit"]))}
  (^java.time.Duration [^java.time.temporal.ChronoUnit this]
   (.getDuration this)))

(defn is-date-based
  "Checks if this unit represents a component of a date.

 A date is time-based if it can be used to imply meaning from a date.
 It must have a {@linkplain #getDuration() duration} that is an integral
 multiple of the length of a standard day.
 Note that it is valid for both {@code isDateBased()} and {@code isTimeBased()}
 to return false, such as when representing a unit like 36 hours.

 @return true if this unit is a component of a date"
  {:arglists (quote (["java.time.temporal.TemporalUnit"]))}
  (^java.lang.Boolean [^java.time.temporal.ChronoUnit this]
   (.isDateBased this)))

(defn is-duration-estimated
  "Checks if the duration of the unit is an estimate.

 All units have a duration, however the duration is not always accurate.
 For example, days have an estimated duration due to the possibility of
 daylight saving time changes.
 This method returns true if the duration is an estimate and false if it is
 accurate. Note that accurate/estimated ignores leap seconds.

 @return true if the duration is estimated, false if accurate"
  {:arglists (quote (["java.time.temporal.TemporalUnit"]))}
  (^java.lang.Boolean [^java.time.temporal.ChronoUnit this]
   (.isDurationEstimated this)))

(defn is-supported-by
  "Checks if this unit is supported by the specified temporal object.

 This checks that the implementing date-time can add/subtract this unit.
 This can be used to avoid throwing an exception.

 This default implementation derives the value using
 {@link Temporal#plus(long, TemporalUnit)}.

 @param temporal  the temporal object to check, not null
 @return true if the unit is supported"
  {:arglists (quote (["java.time.temporal.TemporalUnit"
                      "java.time.temporal.Temporal"]))}
  (^java.lang.Boolean
   [^java.time.temporal.ChronoUnit this ^java.time.temporal.Temporal temporal]
   (.isSupportedBy this temporal)))

(defn is-time-based
  "Checks if this unit represents a component of a time.

 A unit is time-based if it can be used to imply meaning from a time.
 It must have a {@linkplain #getDuration() duration} that divides into
 the length of a standard day without remainder.
 Note that it is valid for both {@code isDateBased()} and {@code isTimeBased()}
 to return false, such as when representing a unit like 36 hours.

 @return true if this unit is a component of a time"
  {:arglists (quote (["java.time.temporal.TemporalUnit"]))}
  (^java.lang.Boolean [^java.time.temporal.ChronoUnit this]
   (.isTimeBased this)))

(defn to-string
  "Gets a descriptive name for the unit.

 This should be in the plural and upper-first camel case, such as 'Days' or 'Minutes'.

 @return the name of this unit, not null"
  {:arglists (quote (["java.time.temporal.TemporalUnit"]))}
  (^java.lang.String [^java.time.temporal.ChronoUnit this] (.toString this)))
