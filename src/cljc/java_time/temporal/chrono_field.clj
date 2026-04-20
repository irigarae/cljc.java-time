(ns cljc.java-time.temporal.chrono-field
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time.temporal ChronoField]))

(def milli-of-second java.time.temporal.ChronoField/MILLI_OF_SECOND)

(def year-of-era java.time.temporal.ChronoField/YEAR_OF_ERA)

(def clock-hour-of-day java.time.temporal.ChronoField/CLOCK_HOUR_OF_DAY)

(def era java.time.temporal.ChronoField/ERA)

(def instant-seconds java.time.temporal.ChronoField/INSTANT_SECONDS)

(def ampm-of-day java.time.temporal.ChronoField/AMPM_OF_DAY)

(def offset-seconds java.time.temporal.ChronoField/OFFSET_SECONDS)

(def nano-of-second java.time.temporal.ChronoField/NANO_OF_SECOND)

(def nano-of-day java.time.temporal.ChronoField/NANO_OF_DAY)

(def aligned-day-of-week-in-month
  java.time.temporal.ChronoField/ALIGNED_DAY_OF_WEEK_IN_MONTH)

(def month-of-year java.time.temporal.ChronoField/MONTH_OF_YEAR)

(def hour-of-ampm java.time.temporal.ChronoField/HOUR_OF_AMPM)

(def year java.time.temporal.ChronoField/YEAR)

(def micro-of-second java.time.temporal.ChronoField/MICRO_OF_SECOND)

(def aligned-week-of-year java.time.temporal.ChronoField/ALIGNED_WEEK_OF_YEAR)

(def proleptic-month java.time.temporal.ChronoField/PROLEPTIC_MONTH)

(def day-of-month java.time.temporal.ChronoField/DAY_OF_MONTH)

(def second-of-minute java.time.temporal.ChronoField/SECOND_OF_MINUTE)

(def second-of-day java.time.temporal.ChronoField/SECOND_OF_DAY)

(def epoch-day java.time.temporal.ChronoField/EPOCH_DAY)

(def day-of-year java.time.temporal.ChronoField/DAY_OF_YEAR)

(def aligned-week-of-month java.time.temporal.ChronoField/ALIGNED_WEEK_OF_MONTH)

(def day-of-week java.time.temporal.ChronoField/DAY_OF_WEEK)

(def clock-hour-of-ampm java.time.temporal.ChronoField/CLOCK_HOUR_OF_AMPM)

(def minute-of-day java.time.temporal.ChronoField/MINUTE_OF_DAY)

(def aligned-day-of-week-in-year
  java.time.temporal.ChronoField/ALIGNED_DAY_OF_WEEK_IN_YEAR)

(def minute-of-hour java.time.temporal.ChronoField/MINUTE_OF_HOUR)

(def hour-of-day java.time.temporal.ChronoField/HOUR_OF_DAY)

(def milli-of-day java.time.temporal.ChronoField/MILLI_OF_DAY)

(def micro-of-day java.time.temporal.ChronoField/MICRO_OF_DAY)

(defn get-range-unit
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.time.temporal.ChronoUnit [^java.time.temporal.ChronoField this]
   (.getRangeUnit this)))

(defn range
  "Gets the range of valid values for the field.\n <p>\n All fields can be expressed as a {@code long} integer.\n This method returns an object that describes the valid range for that value.\n <p>\n This method returns the range of the field in the ISO-8601 calendar system.\n This range may be incorrect for other calendar systems.\n Use {@link Chronology#range(ChronoField)} to access the correct range\n for a different calendar system.\n <p>\n Note that the result only describes the minimum and maximum valid values\n and it is important not to read too much into them. For example, there\n could be values within the range that are invalid for the field.\n\n @return the range of valid values for the field, not null"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.time.temporal.ValueRange [^java.time.temporal.ChronoField this]
   (.range this)))

(defn values
  {:arglists (quote ([]))}
  (^"java.lang.Class" [] (java.time.temporal.ChronoField/values)))

(defn value-of
  {:arglists (quote (["java.lang.String"]
                     ["java.lang.Class" "java.lang.String"]))}
  (^java.time.temporal.ChronoField [^java.lang.String name]
   (java.time.temporal.ChronoField/valueOf name))
  (^java.lang.Enum [^java.lang.Class enum-type ^java.lang.String name]
   (java.time.temporal.ChronoField/valueOf enum-type name)))

(defn resolve
  "Resolves this field to provide a simpler alternative or a date.\n <p>\n This method is invoked during the resolve phase of parsing.\n It is designed to allow application defined fields to be simplified into\n more standard fields, such as those on {@code ChronoField}, or into a date.\n <p>\n Applications should not normally invoke this method directly.\n\n @implSpec\n If an implementation represents a field that can be simplified, or\n combined with others, then this method must be implemented.\n <p>\n The specified map contains the current state of the parse.\n The map is mutable and must be mutated to resolve the field and\n any related fields. This method will only be invoked during parsing\n if the map contains this field, and implementations should therefore\n assume this field is present.\n <p>\n Resolving a field will consist of looking at the value of this field,\n and potentially other fields, and either updating the map with a\n simpler value, such as a {@code ChronoField}, or returning a\n complete {@code ChronoLocalDate}. If a resolve is successful,\n the code must remove all the fields that were resolved from the map,\n including this field.\n <p>\n For example, the {@code IsoFields} class contains the quarter-of-year\n and day-of-quarter fields. The implementation of this method in that class\n resolves the two fields plus the {@link ChronoField#YEAR YEAR} into a\n complete {@code LocalDate}. The resolve method will remove all three\n fields from the map before returning the {@code LocalDate}.\n <p>\n A partially complete temporal is used to allow the chronology and zone\n to be queried. In general, only the chronology will be needed.\n Querying items other than the zone or chronology is undefined and\n must not be relied on.\n The behavior of other methods such as {@code get}, {@code getLong},\n {@code range} and {@code isSupported} is unpredictable and the results undefined.\n <p>\n If resolution should be possible, but the data is invalid, the resolver\n style should be used to determine an appropriate level of leniency, which\n may require throwing a {@code DateTimeException} or {@code ArithmeticException}.\n If no resolution is possible, the resolve method must return null.\n <p>\n When resolving time fields, the map will be altered and null returned.\n When resolving date fields, the date is normally returned from the method,\n with the map altered to remove the resolved fields. However, it would also\n be acceptable for the date fields to be resolved into other {@code ChronoField}\n instances that can produce a date, such as {@code EPOCH_DAY}.\n <p>\n Not all {@code TemporalAccessor} implementations are accepted as return values.\n Implementations that call this method must accept {@code ChronoLocalDate},\n {@code ChronoLocalDateTime}, {@code ChronoZonedDateTime} and {@code LocalTime}.\n <p>\n The default implementation must return null.\n\n @param fieldValues  the map of fields to values, which can be updated, not null\n @param partialTemporal  the partially complete temporal to query for zone and\n  chronology; querying for other things is undefined and not recommended, not null\n @param resolverStyle  the requested type of resolve, not null\n @return the resolved temporal object; null if resolving only\n  changed the map, or no resolve occurred\n @throws ArithmeticException if numeric overflow occurs\n @throws DateTimeException if resolving results in an error. This must not be thrown\n  by querying a field on the temporal without first checking if it is supported"
  {:arglists (quote (["java.time.temporal.ChronoField" "java.util.Map"
                      "java.time.temporal.TemporalAccessor"
                      "java.time.format.ResolverStyle"]))}
  (^java.time.temporal.TemporalAccessor
   [^java.time.temporal.ChronoField this ^java.util.Map field-values
    ^java.time.temporal.TemporalAccessor partial-temporal
    ^java.time.format.ResolverStyle resolver-style]
   (.resolve this field-values partial-temporal resolver-style)))

(defn ordinal
  "Returns the ordinal of this enumeration constant (its position\n in its enum declaration, where the initial constant is assigned\n an ordinal of zero).\n\n Most programmers will have no use for this method.  It is\n designed for use by sophisticated enum-based data structures, such\n as {@link java.util.EnumSet} and {@link java.util.EnumMap}.\n\n @return the ordinal of this enumeration constant"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.lang.Integer [^java.time.temporal.ChronoField this] (.ordinal this)))

(defn check-valid-int-value
  "Checks that the specified value is valid and fits in an {@code int}.\n <p>\n This validates that the value is within the outer range of valid values\n returned by {@link #range()}.\n It also checks that all valid values are within the bounds of an {@code int}.\n <p>\n This method checks against the range of the field in the ISO-8601 calendar system.\n This range may be incorrect for other calendar systems.\n Use {@link Chronology#range(ChronoField)} to access the correct range\n for a different calendar system.\n\n @param value  the value to check\n @return the value that was passed in"
  {:arglists (quote (["java.time.temporal.ChronoField" "long"]))}
  (^java.lang.Integer [^java.time.temporal.ChronoField this ^long value]
   (.checkValidIntValue this value)))

(defn get-base-unit
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.time.temporal.ChronoUnit [^java.time.temporal.ChronoField this]
   (.getBaseUnit this)))

(defn to-string
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.lang.String [^java.time.temporal.ChronoField this] (.toString this)))

(defn is-date-based
  "Checks if this field represents a component of a date.\n <p>\n Fields from day-of-week to era are date-based.\n\n @return true if it is a component of a date"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.lang.Boolean [^java.time.temporal.ChronoField this]
   (.isDateBased this)))

(defn get-display-name
  {:arglists (quote (["java.time.temporal.ChronoField" "java.util.Locale"]))}
  (^java.lang.String
   [^java.time.temporal.ChronoField this ^java.util.Locale locale]
   (.getDisplayName this locale)))

(defn name
  "Returns the name of this enum constant, exactly as declared in its\n enum declaration.\n\n <b>Most programmers should use the {@link #toString} method in\n preference to this one, as the toString method may return\n a more user-friendly name.</b>  This method is designed primarily for\n use in specialized situations where correctness depends on getting the\n exact name, which will not vary from release to release.\n\n @return the name of this enum constant"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.lang.String [^java.time.temporal.ChronoField this] (.name this)))

(defn is-supported-by
  {:arglists (quote (["java.time.temporal.ChronoField"
                      "java.time.temporal.TemporalAccessor"]))}
  (^java.lang.Boolean
   [^java.time.temporal.ChronoField this
    ^java.time.temporal.TemporalAccessor temporal]
   (.isSupportedBy this temporal)))

(defn range-refined-by
  {:arglists (quote (["java.time.temporal.ChronoField"
                      "java.time.temporal.TemporalAccessor"]))}
  (^java.time.temporal.ValueRange
   [^java.time.temporal.ChronoField this
    ^java.time.temporal.TemporalAccessor temporal]
   (.rangeRefinedBy this temporal)))

(defn get-declaring-class
  "Returns the Class object corresponding to this enum constant's\n enum type.  Two enum constants e1 and  e2 are of the\n same enum type if and only if\n   e1.getDeclaringClass() == e2.getDeclaringClass().\n (The value returned by this method may differ from the one returned\n by the {@link Object#getClass} method for enum constants with\n constant-specific class bodies.)\n\n @return the Class object corresponding to this enum constant's\n     enum type"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.lang.Class [^java.time.temporal.ChronoField this]
   (.getDeclaringClass this)))

(defn hash-code
  "Returns a hash code for this enum constant.\n\n @return a hash code for this enum constant."
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.lang.Integer [^java.time.temporal.ChronoField this] (.hashCode this)))

(defn adjust-into
  {:arglists (quote (["java.time.temporal.ChronoField"
                      "java.time.temporal.Temporal" "long"]))}
  (^java.time.temporal.Temporal
   [^java.time.temporal.ChronoField this ^java.time.temporal.Temporal temporal
    ^long new-value]
   (.adjustInto this temporal new-value)))

(defn get-from
  {:arglists (quote (["java.time.temporal.ChronoField"
                      "java.time.temporal.TemporalAccessor"]))}
  (^long
   [^java.time.temporal.ChronoField this
    ^java.time.temporal.TemporalAccessor temporal]
   (.getFrom this temporal)))

(defn compare-to
  "Compares this enum with the specified object for order.  Returns a\n negative integer, zero, or a positive integer as this object is less\n than, equal to, or greater than the specified object.\n\n Enum constants are only comparable to other enum constants of the\n same enum type.  The natural order implemented by this\n method is the order in which the constants are declared."
  {:arglists (quote (["java.time.temporal.ChronoField" "java.lang.Enum"]))}
  (^java.lang.Integer [^java.time.temporal.ChronoField this ^java.lang.Enum o]
   (.compareTo this o)))

(defn equals
  "Returns true if the specified object is equal to this\n enum constant.\n\n @param other the object to be compared for equality with this object.\n @return  true if the specified object is equal to this\n          enum constant."
  {:arglists (quote (["java.time.temporal.ChronoField" "java.lang.Object"]))}
  (^java.lang.Boolean
   [^java.time.temporal.ChronoField this ^java.lang.Object other]
   (.equals this other)))

(defn is-time-based
  "Checks if this field represents a component of a time.\n <p>\n Fields from nano-of-second to am-pm-of-day are time-based.\n\n @return true if it is a component of a time"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.lang.Boolean [^java.time.temporal.ChronoField this]
   (.isTimeBased this)))

(defn check-valid-value
  "Checks that the specified value is valid for this field.\n <p>\n This validates that the value is within the outer range of valid values\n returned by {@link #range()}.\n <p>\n This method checks against the range of the field in the ISO-8601 calendar system.\n This range may be incorrect for other calendar systems.\n Use {@link Chronology#range(ChronoField)} to access the correct range\n for a different calendar system.\n\n @param value  the value to check\n @return the value that was passed in"
  {:arglists (quote (["java.time.temporal.ChronoField" "long"]))}
  (^long [^java.time.temporal.ChronoField this ^long value]
   (.checkValidValue this value)))
