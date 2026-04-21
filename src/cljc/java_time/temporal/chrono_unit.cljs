(ns cljc.java-time.temporal.chrono-unit
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time.temporal :refer [ChronoUnit]]))

(def millis
  "Unit that represents the concept of a millisecond.
 For the ISO calendar system, it is equal to the 1000th part of the second unit."
  (goog.object/get java.time.temporal.ChronoUnit "MILLIS"))

(def minutes
  "Unit that represents the concept of a minute.
 For the ISO calendar system, it is equal to 60 seconds."
  (goog.object/get java.time.temporal.ChronoUnit "MINUTES"))

(def micros
  "Unit that represents the concept of a microsecond.
 For the ISO calendar system, it is equal to the 1,000,000th part of the second unit."
  (goog.object/get java.time.temporal.ChronoUnit "MICROS"))

(def half-days
  "Unit that represents the concept of half a day, as used in AM/PM.
 For the ISO calendar system, it is equal to 12 hours."
  (goog.object/get java.time.temporal.ChronoUnit "HALF_DAYS"))

(def millennia
  "Unit that represents the concept of a millennium.
 For the ISO calendar system, it is equal to 1000 years.

 When used with other calendar systems it must correspond to an integral number of days
 and is normally an integral number of years."
  (goog.object/get java.time.temporal.ChronoUnit "MILLENNIA"))

(def years
  "Unit that represents the concept of a year.
 For the ISO calendar system, it is equal to 12 months.
 The estimated duration of a year is {@code 365.2425 Days}.

 When used with other calendar systems it must correspond to an integral number of days
 or months roughly equal to a year defined by the passage of the Earth around the Sun."
  (goog.object/get java.time.temporal.ChronoUnit "YEARS"))

(def decades
  "Unit that represents the concept of a decade.
 For the ISO calendar system, it is equal to 10 years.

 When used with other calendar systems it must correspond to an integral number of days
 and is normally an integral number of years."
  (goog.object/get java.time.temporal.ChronoUnit "DECADES"))

(def days
  "Unit that represents the concept of a day.
 For the ISO calendar system, it is the standard day from midnight to midnight.
 The estimated duration of a day is {@code 24 Hours}.

 When used with other calendar systems it must correspond to the day defined by
 the rising and setting of the Sun on Earth. It is not required that days begin
 at midnight - when converting between calendar systems, the date should be
 equivalent at midday."
  (goog.object/get java.time.temporal.ChronoUnit "DAYS"))

(def centuries
  "Unit that represents the concept of a century.
 For the ISO calendar system, it is equal to 100 years.

 When used with other calendar systems it must correspond to an integral number of days
 and is normally an integral number of years."
  (goog.object/get java.time.temporal.ChronoUnit "CENTURIES"))

(def weeks
  "Unit that represents the concept of a week.
 For the ISO calendar system, it is equal to 7 days.

 When used with other calendar systems it must correspond to an integral number of days."
  (goog.object/get java.time.temporal.ChronoUnit "WEEKS"))

(def hours
  "Unit that represents the concept of an hour.
 For the ISO calendar system, it is equal to 60 minutes."
  (goog.object/get java.time.temporal.ChronoUnit "HOURS"))

(def eras
  "Unit that represents the concept of an era.
 The ISO calendar system doesn't have eras thus it is impossible to add
 an era to a date or date-time.
 The estimated duration of the era is artificially defined as {@code 1,000,000,000 Years}.

 When used with other calendar systems there are no restrictions on the unit."
  (goog.object/get java.time.temporal.ChronoUnit "ERAS"))

(def seconds
  "Unit that represents the concept of a second.
 For the ISO calendar system, it is equal to the second in the SI system
 of units, except around a leap-second."
  (goog.object/get java.time.temporal.ChronoUnit "SECONDS"))

(def months
  "Unit that represents the concept of a month.
 For the ISO calendar system, the length of the month varies by month-of-year.
 The estimated duration of a month is one twelfth of {@code 365.2425 Days}.

 When used with other calendar systems it must correspond to an integral number of days."
  (goog.object/get java.time.temporal.ChronoUnit "MONTHS"))

(def nanos
  "Unit that represents the concept of a nanosecond, the smallest supported unit of time.
 For the ISO calendar system, it is equal to the 1,000,000,000th part of the second unit."
  (goog.object/get java.time.temporal.ChronoUnit "NANOS"))

(def forever
  "Artificial unit that represents the concept of forever.
 This is primarily used with {@link TemporalField} to represent unbounded fields
 such as the year or era.
 The estimated duration of the era is artificially defined as the largest duration
 supported by {@code Duration}."
  (goog.object/get java.time.temporal.ChronoUnit "FOREVER"))

(defn values
  {:arglists (quote ([]))}
  (^"java.lang.Class" [] (js-invoke java.time.temporal.ChronoUnit "values")))

(defn value-of
  {:arglists (quote (["java.lang.String"]
                     ["java.lang.Class" "java.lang.String"]))}
  (^js/JSJoda.ChronoUnit [^java.lang.String name]
   (js-invoke java.time.temporal.ChronoUnit "valueOf" name))
  (^java.lang.Enum [^java.lang.Class enum-type ^java.lang.String name]
   (js-invoke java.time.temporal.ChronoUnit "valueOf" enum-type name)))

(defn ordinal
  "Returns the ordinal of this enumeration constant (its position
 in its enum declaration, where the initial constant is assigned
 an ordinal of zero).

 Most programmers will have no use for this method.  It is
 designed for use by sophisticated enum-based data structures, such
 as {@link java.util.EnumSet} and {@link java.util.EnumMap}.

 @return the ordinal of this enumeration constant"
  {:arglists (quote (["java.time.temporal.ChronoUnit"]))}
  (^int [^js/JSJoda.ChronoUnit this] (.ordinal this)))

(defn is-duration-estimated
  "Checks if the duration of the unit is an estimate.

 All time units in this class are considered to be accurate, while all date
 units in this class are considered to be estimated.

 This definition ignores leap seconds, but considers that Days vary due to
 daylight saving time and months have different lengths.

 @return true if the duration is estimated, false if accurate"
  {:arglists (quote (["java.time.temporal.ChronoUnit"]))}
  (^boolean [^js/JSJoda.ChronoUnit this] (.isDurationEstimated this)))

(defn to-string
  {:arglists (quote (["java.time.temporal.ChronoUnit"]))}
  (^java.lang.String [^js/JSJoda.ChronoUnit this] (.toString this)))

(defn is-date-based
  "Checks if this unit is a date unit.

 All units from days to eras inclusive are date-based.
 Time-based units and {@code FOREVER} return false.

 @return true if a date unit, false if a time unit"
  {:arglists (quote (["java.time.temporal.ChronoUnit"]))}
  (^boolean [^js/JSJoda.ChronoUnit this] (.isDateBased this)))

(defn add-to
  {:arglists (quote (["java.time.temporal.ChronoUnit"
                      "java.time.temporal.Temporal" "long"]))}
  (^js/JSJoda.Temporal
   [^js/JSJoda.ChronoUnit this ^js/JSJoda.Temporal temporal ^long amount]
   (.addTo this temporal amount)))

(defn name
  "Returns the name of this enum constant, exactly as declared in its
 enum declaration.

 <b>Most programmers should use the {@link #toString} method in
 preference to this one, as the toString method may return
 a more user-friendly name.</b>  This method is designed primarily for
 use in specialized situations where correctness depends on getting the
 exact name, which will not vary from release to release.

 @return the name of this enum constant"
  {:arglists (quote (["java.time.temporal.ChronoUnit"]))}
  (^java.lang.String [^js/JSJoda.ChronoUnit this] (.name this)))

(defn is-supported-by
  {:arglists (quote (["java.time.temporal.ChronoUnit"
                      "java.time.temporal.Temporal"]))}
  (^boolean [^js/JSJoda.ChronoUnit this ^js/JSJoda.Temporal temporal]
   (.isSupportedBy this temporal)))

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
  {:arglists (quote (["java.time.temporal.ChronoUnit"]))}
  (^java.lang.Class [^js/JSJoda.ChronoUnit this] (.declaringClass this)))

(defn between
  {:arglists (quote (["java.time.temporal.ChronoUnit"
                      "java.time.temporal.Temporal"
                      "java.time.temporal.Temporal"]))}
  (^long
   [^js/JSJoda.ChronoUnit this ^js/JSJoda.Temporal temporal1-inclusive
    ^js/JSJoda.Temporal temporal2-exclusive]
   (.between this temporal1-inclusive temporal2-exclusive)))

(defn hash-code
  "Returns a hash code for this enum constant.

 @return a hash code for this enum constant."
  {:arglists (quote (["java.time.temporal.ChronoUnit"]))}
  (^int [^js/JSJoda.ChronoUnit this] (.hashCode this)))

(defn compare-to
  "Compares this enum with the specified object for order.  Returns a
 negative integer, zero, or a positive integer as this object is less
 than, equal to, or greater than the specified object.

 Enum constants are only comparable to other enum constants of the
 same enum type.  The natural order implemented by this
 method is the order in which the constants are declared."
  {:arglists (quote (["java.time.temporal.ChronoUnit" "java.lang.Enum"]))}
  (^int [^js/JSJoda.ChronoUnit this ^java.lang.Enum o] (.compareTo this o)))

(defn get-duration
  "Gets the estimated duration of this unit in the ISO calendar system.

 All of the units in this class have an estimated duration.
 Days vary due to daylight saving time, while months have different lengths.

 @return the estimated duration of this unit, not null"
  {:arglists (quote (["java.time.temporal.ChronoUnit"]))}
  (^js/JSJoda.Duration [^js/JSJoda.ChronoUnit this] (.duration this)))

(defn equals
  "Returns true if the specified object is equal to this
 enum constant.

 @param other the object to be compared for equality with this object.
 @return  true if the specified object is equal to this
          enum constant."
  {:arglists (quote (["java.time.temporal.ChronoUnit" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.ChronoUnit this ^java.lang.Object other]
   (.equals this other)))

(defn is-time-based
  "Checks if this unit is a time unit.

 All units from nanos to half-days inclusive are time-based.
 Date-based units and {@code FOREVER} return false.

 @return true if a time unit, false if a date unit"
  {:arglists (quote (["java.time.temporal.ChronoUnit"]))}
  (^boolean [^js/JSJoda.ChronoUnit this] (.isTimeBased this)))
