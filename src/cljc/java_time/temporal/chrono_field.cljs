(ns cljc.java-time.temporal.chrono-field
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time.temporal :refer [ChronoField]]))

(def milli-of-second
  (goog.object/get java.time.temporal.ChronoField "MILLI_OF_SECOND"))

(def year-of-era (goog.object/get java.time.temporal.ChronoField "YEAR_OF_ERA"))

(def clock-hour-of-day
  (goog.object/get java.time.temporal.ChronoField "CLOCK_HOUR_OF_DAY"))

(def era (goog.object/get java.time.temporal.ChronoField "ERA"))

(def instant-seconds
  (goog.object/get java.time.temporal.ChronoField "INSTANT_SECONDS"))

(def ampm-of-day (goog.object/get java.time.temporal.ChronoField "AMPM_OF_DAY"))

(def offset-seconds
  (goog.object/get java.time.temporal.ChronoField "OFFSET_SECONDS"))

(def nano-of-second
  (goog.object/get java.time.temporal.ChronoField "NANO_OF_SECOND"))

(def nano-of-day (goog.object/get java.time.temporal.ChronoField "NANO_OF_DAY"))

(def aligned-day-of-week-in-month
  (goog.object/get java.time.temporal.ChronoField
                   "ALIGNED_DAY_OF_WEEK_IN_MONTH"))

(def month-of-year
  (goog.object/get java.time.temporal.ChronoField "MONTH_OF_YEAR"))

(def hour-of-ampm
  (goog.object/get java.time.temporal.ChronoField "HOUR_OF_AMPM"))

(def year (goog.object/get java.time.temporal.ChronoField "YEAR"))

(def micro-of-second
  (goog.object/get java.time.temporal.ChronoField "MICRO_OF_SECOND"))

(def aligned-week-of-year
  (goog.object/get java.time.temporal.ChronoField "ALIGNED_WEEK_OF_YEAR"))

(def proleptic-month
  (goog.object/get java.time.temporal.ChronoField "PROLEPTIC_MONTH"))

(def day-of-month
  (goog.object/get java.time.temporal.ChronoField "DAY_OF_MONTH"))

(def second-of-minute
  (goog.object/get java.time.temporal.ChronoField "SECOND_OF_MINUTE"))

(def second-of-day
  (goog.object/get java.time.temporal.ChronoField "SECOND_OF_DAY"))

(def epoch-day (goog.object/get java.time.temporal.ChronoField "EPOCH_DAY"))

(def day-of-year (goog.object/get java.time.temporal.ChronoField "DAY_OF_YEAR"))

(def aligned-week-of-month
  (goog.object/get java.time.temporal.ChronoField "ALIGNED_WEEK_OF_MONTH"))

(def day-of-week (goog.object/get java.time.temporal.ChronoField "DAY_OF_WEEK"))

(def clock-hour-of-ampm
  (goog.object/get java.time.temporal.ChronoField "CLOCK_HOUR_OF_AMPM"))

(def minute-of-day
  (goog.object/get java.time.temporal.ChronoField "MINUTE_OF_DAY"))

(def aligned-day-of-week-in-year
  (goog.object/get java.time.temporal.ChronoField
                   "ALIGNED_DAY_OF_WEEK_IN_YEAR"))

(def minute-of-hour
  (goog.object/get java.time.temporal.ChronoField "MINUTE_OF_HOUR"))

(def hour-of-day (goog.object/get java.time.temporal.ChronoField "HOUR_OF_DAY"))

(def milli-of-day
  (goog.object/get java.time.temporal.ChronoField "MILLI_OF_DAY"))

(def micro-of-day
  (goog.object/get java.time.temporal.ChronoField "MICRO_OF_DAY"))

(defn get-range-unit
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^js/JSJoda.TemporalUnit [^js/JSJoda.ChronoField this] (.rangeUnit this)))

(defn range
  "Gets the range of valid values for the field.

 All fields can be expressed as a {@code long} integer.
 This method returns an object that describes the valid range for that value.

 This method returns the range of the field in the ISO-8601 calendar system.
 This range may be incorrect for other calendar systems.
 Use {@link Chronology#range(ChronoField)} to access the correct range
 for a different calendar system.

 Note that the result only describes the minimum and maximum valid values
 and it is important not to read too much into them. For example, there
 could be values within the range that are invalid for the field.

 @return the range of valid values for the field, not null"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^js/JSJoda.ValueRange [^js/JSJoda.ChronoField this] (.range this)))

(defn values
  {:arglists (quote ([]))}
  (^"java.lang.Class" [] (js-invoke java.time.temporal.ChronoField "values")))

(defn value-of
  {:arglists (quote (["java.lang.String"]
                     ["java.lang.Class" "java.lang.String"]))}
  (^js/JSJoda.ChronoField [^java.lang.String name]
   (js-invoke java.time.temporal.ChronoField "valueOf" name))
  (^java.lang.Enum [^java.lang.Class enum-type ^java.lang.String name]
   (js-invoke java.time.temporal.ChronoField "valueOf" enum-type name)))

(defn resolve
  "Resolves this field to provide a simpler alternative or a date.

 This method is invoked during the resolve phase of parsing.
 It is designed to allow application defined fields to be simplified into
 more standard fields, such as those on {@code ChronoField}, or into a date.

 Applications should not normally invoke this method directly.

 @implSpec
 If an implementation represents a field that can be simplified, or
 combined with others, then this method must be implemented.

 The specified map contains the current state of the parse.
 The map is mutable and must be mutated to resolve the field and
 any related fields. This method will only be invoked during parsing
 if the map contains this field, and implementations should therefore
 assume this field is present.

 Resolving a field will consist of looking at the value of this field,
 and potentially other fields, and either updating the map with a
 simpler value, such as a {@code ChronoField}, or returning a
 complete {@code ChronoLocalDate}. If a resolve is successful,
 the code must remove all the fields that were resolved from the map,
 including this field.

 For example, the {@code IsoFields} class contains the quarter-of-year
 and day-of-quarter fields. The implementation of this method in that class
 resolves the two fields plus the {@link ChronoField#YEAR YEAR} into a
 complete {@code LocalDate}. The resolve method will remove all three
 fields from the map before returning the {@code LocalDate}.

 A partially complete temporal is used to allow the chronology and zone
 to be queried. In general, only the chronology will be needed.
 Querying items other than the zone or chronology is undefined and
 must not be relied on.
 The behavior of other methods such as {@code get}, {@code getLong},
 {@code range} and {@code isSupported} is unpredictable and the results undefined.

 If resolution should be possible, but the data is invalid, the resolver
 style should be used to determine an appropriate level of leniency, which
 may require throwing a {@code DateTimeException} or {@code ArithmeticException}.
 If no resolution is possible, the resolve method must return null.

 When resolving time fields, the map will be altered and null returned.
 When resolving date fields, the date is normally returned from the method,
 with the map altered to remove the resolved fields. However, it would also
 be acceptable for the date fields to be resolved into other {@code ChronoField}
 instances that can produce a date, such as {@code EPOCH_DAY}.

 Not all {@code TemporalAccessor} implementations are accepted as return values.
 Implementations that call this method must accept {@code ChronoLocalDate},
 {@code ChronoLocalDateTime}, {@code ChronoZonedDateTime} and {@code LocalTime}.

 The default implementation must return null.

 @param fieldValues  the map of fields to values, which can be updated, not null
 @param partialTemporal  the partially complete temporal to query for zone and
  chronology; querying for other things is undefined and not recommended, not null
 @param resolverStyle  the requested type of resolve, not null
 @return the resolved temporal object; null if resolving only
  changed the map, or no resolve occurred
 @throws ArithmeticException if numeric overflow occurs
 @throws DateTimeException if resolving results in an error. This must not be thrown
  by querying a field on the temporal without first checking if it is supported"
  {:arglists (quote (["java.time.temporal.ChronoField" "java.util.Map"
                      "java.time.temporal.TemporalAccessor"
                      "java.time.format.ResolverStyle"]))}
  (^js/JSJoda.TemporalAccessor
   [^js/JSJoda.ChronoField this ^java.util.Map field-values
    ^js/JSJoda.TemporalAccessor partial-temporal
    ^js/JSJoda.ResolverStyle resolver-style]
   (.resolve this field-values partial-temporal resolver-style)))

(defn ordinal
  "Returns the ordinal of this enumeration constant (its position
 in its enum declaration, where the initial constant is assigned
 an ordinal of zero).

 Most programmers will have no use for this method.  It is
 designed for use by sophisticated enum-based data structures, such
 as {@link java.util.EnumSet} and {@link java.util.EnumMap}.

 @return the ordinal of this enumeration constant"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^int [^js/JSJoda.ChronoField this] (.ordinal this)))

(defn check-valid-int-value
  "Checks that the specified value is valid and fits in an {@code int}.

 This validates that the value is within the outer range of valid values
 returned by {@link #range()}.
 It also checks that all valid values are within the bounds of an {@code int}.

 This method checks against the range of the field in the ISO-8601 calendar system.
 This range may be incorrect for other calendar systems.
 Use {@link Chronology#range(ChronoField)} to access the correct range
 for a different calendar system.

 @param value  the value to check
 @return the value that was passed in"
  {:arglists (quote (["java.time.temporal.ChronoField" "long"]))}
  (^int [^js/JSJoda.ChronoField this ^long value]
   (.checkValidIntValue this value)))

(defn get-base-unit
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^js/JSJoda.TemporalUnit [^js/JSJoda.ChronoField this] (.baseUnit this)))

(defn to-string
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.lang.String [^js/JSJoda.ChronoField this] (.toString this)))

(defn is-date-based
  "Checks if this field represents a component of a date.

 Fields from day-of-week to era are date-based.

 @return true if it is a component of a date"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^boolean [^js/JSJoda.ChronoField this] (.isDateBased this)))

(defn get-display-name
  {:arglists (quote (["java.time.temporal.ChronoField" "java.util.Locale"]))}
  (^java.lang.String [^js/JSJoda.ChronoField this ^java.util.Locale locale]
   (.displayName this locale)))

(defn name
  "Returns the name of this enum constant, exactly as declared in its
 enum declaration.

 <b>Most programmers should use the {@link #toString} method in
 preference to this one, as the toString method may return
 a more user-friendly name.</b>  This method is designed primarily for
 use in specialized situations where correctness depends on getting the
 exact name, which will not vary from release to release.

 @return the name of this enum constant"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.lang.String [^js/JSJoda.ChronoField this] (.name this)))

(defn is-supported-by
  {:arglists (quote (["java.time.temporal.ChronoField"
                      "java.time.temporal.TemporalAccessor"]))}
  (^boolean [^js/JSJoda.ChronoField this ^js/JSJoda.TemporalAccessor temporal]
   (.isSupportedBy this temporal)))

(defn range-refined-by
  {:arglists (quote (["java.time.temporal.ChronoField"
                      "java.time.temporal.TemporalAccessor"]))}
  (^js/JSJoda.ValueRange
   [^js/JSJoda.ChronoField this ^js/JSJoda.TemporalAccessor temporal]
   (.rangeRefinedBy this temporal)))

(defn get-declaring-class
  "Returns the Class object corresponding to this enum constant's
 enum type.  Two enum constants e1 and  e2 are of the
 same enum type if and only if
   e1.getDeclaringClass() == e2.getDeclaringClass().
 (The value returned by this method may differ from the one returned
 by the {@link Object#getClass} method for enum constants with
 constant-specific class bodies.)

 @return the Class object corresponding to this enum constant's
     enum type"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.lang.Class [^js/JSJoda.ChronoField this] (.declaringClass this)))

(defn hash-code
  "Returns a hash code for this enum constant.

 @return a hash code for this enum constant."
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^int [^js/JSJoda.ChronoField this] (.hashCode this)))

(defn adjust-into
  {:arglists (quote (["java.time.temporal.ChronoField"
                      "java.time.temporal.Temporal" "long"]))}
  (^js/JSJoda.Temporal
   [^js/JSJoda.ChronoField this ^js/JSJoda.Temporal temporal ^long new-value]
   (.adjustInto this temporal new-value)))

(defn get-from
  {:arglists (quote (["java.time.temporal.ChronoField"
                      "java.time.temporal.TemporalAccessor"]))}
  (^long [^js/JSJoda.ChronoField this ^js/JSJoda.TemporalAccessor temporal]
   (.from this temporal)))

(defn compare-to
  "Compares this enum with the specified object for order.  Returns a
 negative integer, zero, or a positive integer as this object is less
 than, equal to, or greater than the specified object.

 Enum constants are only comparable to other enum constants of the
 same enum type.  The natural order implemented by this
 method is the order in which the constants are declared."
  {:arglists (quote (["java.time.temporal.ChronoField" "java.lang.Enum"]))}
  (^int [^js/JSJoda.ChronoField this ^java.lang.Enum o] (.compareTo this o)))

(defn equals
  "Returns true if the specified object is equal to this
 enum constant.

 @param other the object to be compared for equality with this object.
 @return  true if the specified object is equal to this
          enum constant."
  {:arglists (quote (["java.time.temporal.ChronoField" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.ChronoField this ^java.lang.Object other]
   (.equals this other)))

(defn is-time-based
  "Checks if this field represents a component of a time.

 Fields from nano-of-second to am-pm-of-day are time-based.

 @return true if it is a component of a time"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^boolean [^js/JSJoda.ChronoField this] (.isTimeBased this)))

(defn check-valid-value
  "Checks that the specified value is valid for this field.

 This validates that the value is within the outer range of valid values
 returned by {@link #range()}.

 This method checks against the range of the field in the ISO-8601 calendar system.
 This range may be incorrect for other calendar systems.
 Use {@link Chronology#range(ChronoField)} to access the correct range
 for a different calendar system.

 @param value  the value to check
 @return the value that was passed in"
  {:arglists (quote (["java.time.temporal.ChronoField" "long"]))}
  (^long [^js/JSJoda.ChronoField this ^long value]
   (.checkValidValue this value)))
