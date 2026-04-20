(ns cljc.java-time.temporal.chrono-unit
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time.temporal :refer [ChronoUnit]]))

(def millis (goog.object/get java.time.temporal.ChronoUnit "MILLIS"))

(def minutes (goog.object/get java.time.temporal.ChronoUnit "MINUTES"))

(def micros (goog.object/get java.time.temporal.ChronoUnit "MICROS"))

(def half-days (goog.object/get java.time.temporal.ChronoUnit "HALF_DAYS"))

(def millennia (goog.object/get java.time.temporal.ChronoUnit "MILLENNIA"))

(def years (goog.object/get java.time.temporal.ChronoUnit "YEARS"))

(def decades (goog.object/get java.time.temporal.ChronoUnit "DECADES"))

(def days (goog.object/get java.time.temporal.ChronoUnit "DAYS"))

(def centuries (goog.object/get java.time.temporal.ChronoUnit "CENTURIES"))

(def weeks (goog.object/get java.time.temporal.ChronoUnit "WEEKS"))

(def hours (goog.object/get java.time.temporal.ChronoUnit "HOURS"))

(def eras (goog.object/get java.time.temporal.ChronoUnit "ERAS"))

(def seconds (goog.object/get java.time.temporal.ChronoUnit "SECONDS"))

(def months (goog.object/get java.time.temporal.ChronoUnit "MONTHS"))

(def nanos (goog.object/get java.time.temporal.ChronoUnit "NANOS"))

(def forever (goog.object/get java.time.temporal.ChronoUnit "FOREVER"))

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
  "Returns the ordinal of this enumeration constant (its position\n in its enum declaration, where the initial constant is assigned\n an ordinal of zero).\n\n Most programmers will have no use for this method.  It is\n designed for use by sophisticated enum-based data structures, such\n as {@link java.util.EnumSet} and {@link java.util.EnumMap}.\n\n @return the ordinal of this enumeration constant"
  {:arglists (quote (["java.time.temporal.ChronoUnit"]))}
  (^int [^js/JSJoda.ChronoUnit this] (.ordinal this)))

(defn is-duration-estimated
  "Checks if the duration of the unit is an estimate.\n <p>\n All time units in this class are considered to be accurate, while all date\n units in this class are considered to be estimated.\n <p>\n This definition ignores leap seconds, but considers that Days vary due to\n daylight saving time and months have different lengths.\n\n @return true if the duration is estimated, false if accurate"
  {:arglists (quote (["java.time.temporal.ChronoUnit"]))}
  (^boolean [^js/JSJoda.ChronoUnit this] (.isDurationEstimated this)))

(defn to-string
  {:arglists (quote (["java.time.temporal.ChronoUnit"]))}
  (^java.lang.String [^js/JSJoda.ChronoUnit this] (.toString this)))

(defn is-date-based
  "Checks if this unit is a date unit.\n <p>\n All units from days to eras inclusive are date-based.\n Time-based units and {@code FOREVER} return false.\n\n @return true if a date unit, false if a time unit"
  {:arglists (quote (["java.time.temporal.ChronoUnit"]))}
  (^boolean [^js/JSJoda.ChronoUnit this] (.isDateBased this)))

(defn add-to
  {:arglists (quote (["java.time.temporal.ChronoUnit"
                      "java.time.temporal.Temporal" "long"]))}
  (^js/JSJoda.Temporal
   [^js/JSJoda.ChronoUnit this ^js/JSJoda.Temporal temporal ^long amount]
   (.addTo this temporal amount)))

(defn name
  "Returns the name of this enum constant, exactly as declared in its\n enum declaration.\n\n <b>Most programmers should use the {@link #toString} method in\n preference to this one, as the toString method may return\n a more user-friendly name.</b>  This method is designed primarily for\n use in specialized situations where correctness depends on getting the\n exact name, which will not vary from release to release.\n\n @return the name of this enum constant"
  {:arglists (quote (["java.time.temporal.ChronoUnit"]))}
  (^java.lang.String [^js/JSJoda.ChronoUnit this] (.name this)))

(defn is-supported-by
  {:arglists (quote (["java.time.temporal.ChronoUnit"
                      "java.time.temporal.Temporal"]))}
  (^boolean [^js/JSJoda.ChronoUnit this ^js/JSJoda.Temporal temporal]
   (.isSupportedBy this temporal)))

(defn get-declaring-class
  "Returns the Class object corresponding to this enum constant's\n enum type.  Two enum constants e1 and  e2 are of the\n same enum type if and only if\n   e1.getDeclaringClass() == e2.getDeclaringClass().\n (The value returned by this method may differ from the one returned\n by the {@link Object#getClass} method for enum constants with\n constant-specific class bodies.)\n\n @return the Class object corresponding to this enum constant's\n     enum type"
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
  "Returns a hash code for this enum constant.\n\n @return a hash code for this enum constant."
  {:arglists (quote (["java.time.temporal.ChronoUnit"]))}
  (^int [^js/JSJoda.ChronoUnit this] (.hashCode this)))

(defn compare-to
  "Compares this enum with the specified object for order.  Returns a\n negative integer, zero, or a positive integer as this object is less\n than, equal to, or greater than the specified object.\n\n Enum constants are only comparable to other enum constants of the\n same enum type.  The natural order implemented by this\n method is the order in which the constants are declared."
  {:arglists (quote (["java.time.temporal.ChronoUnit" "java.lang.Enum"]))}
  (^int [^js/JSJoda.ChronoUnit this ^java.lang.Enum o] (.compareTo this o)))

(defn get-duration
  "Gets the estimated duration of this unit in the ISO calendar system.\n <p>\n All of the units in this class have an estimated duration.\n Days vary due to daylight saving time, while months have different lengths.\n\n @return the estimated duration of this unit, not null"
  {:arglists (quote (["java.time.temporal.ChronoUnit"]))}
  (^js/JSJoda.Duration [^js/JSJoda.ChronoUnit this] (.duration this)))

(defn equals
  "Returns true if the specified object is equal to this\n enum constant.\n\n @param other the object to be compared for equality with this object.\n @return  true if the specified object is equal to this\n          enum constant."
  {:arglists (quote (["java.time.temporal.ChronoUnit" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.ChronoUnit this ^java.lang.Object other]
   (.equals this other)))

(defn is-time-based
  "Checks if this unit is a time unit.\n <p>\n All units from nanos to half-days inclusive are time-based.\n Date-based units and {@code FOREVER} return false.\n\n @return true if a time unit, false if a date unit"
  {:arglists (quote (["java.time.temporal.ChronoUnit"]))}
  (^boolean [^js/JSJoda.ChronoUnit this] (.isTimeBased this)))
