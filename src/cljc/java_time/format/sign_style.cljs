(ns cljc.java-time.format.sign-style
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time.format :refer [SignStyle]]))

(def exceeds-pad
  "Style to always output the sign if the value exceeds the pad width.
 A negative value will always output the '-' sign.

 In strict parsing, the sign will be rejected unless the pad width is exceeded.
 In lenient parsing, any sign will be accepted, with the absence
 of a sign treated as a positive number."
  (goog.object/get java.time.format.SignStyle "EXCEEDS_PAD"))

(def normal
  "Style to output the sign only if the value is negative.

 In strict parsing, the negative sign will be accepted and the positive sign rejected.
 In lenient parsing, any sign will be accepted."
  (goog.object/get java.time.format.SignStyle "NORMAL"))

(def always
  "Style to always output the sign, where zero will output '+'.

 In strict parsing, the absence of a sign will be rejected.
 In lenient parsing, any sign will be accepted, with the absence
 of a sign treated as a positive number."
  (goog.object/get java.time.format.SignStyle "ALWAYS"))

(def never
  "Style to never output sign, only outputting the absolute value.

 In strict parsing, any sign will be rejected.
 In lenient parsing, any sign will be accepted unless the width is fixed."
  (goog.object/get java.time.format.SignStyle "NEVER"))

(def not-negative
  "Style to block negative values, throwing an exception on printing.

 In strict parsing, any sign will be rejected.
 In lenient parsing, any sign will be accepted unless the width is fixed."
  (goog.object/get java.time.format.SignStyle "NOT_NEGATIVE"))

(defn values
  {:arglists (quote ([]))}
  (^"java.lang.Class" [] (js-invoke java.time.format.SignStyle "values")))

(defn value-of
  {:arglists (quote (["java.lang.String"]
                     ["java.lang.Class" "java.lang.String"]))}
  (^js/JSJoda.SignStyle [^java.lang.String name]
   (js-invoke java.time.format.SignStyle "valueOf" name))
  (^java.lang.Enum [^java.lang.Class enum-type ^java.lang.String name]
   (js-invoke java.time.format.SignStyle "valueOf" enum-type name)))

(defn ordinal
  "Returns the ordinal of this enumeration constant (its position
 in its enum declaration, where the initial constant is assigned
 an ordinal of zero).

 Most programmers will have no use for this method.  It is
 designed for use by sophisticated enum-based data structures, such
 as {@link java.util.EnumSet} and {@link java.util.EnumMap}.

 @return the ordinal of this enumeration constant"
  {:arglists (quote (["java.time.format.SignStyle"]))}
  (^int [^js/JSJoda.SignStyle this] (.ordinal this)))

(defn to-string
  "Returns the name of this enum constant, as contained in the
 declaration.  This method may be overridden, though it typically
 isn't necessary or desirable.  An enum type should override this
 method when a more \"programmer-friendly\" string form exists.

 @return the name of this enum constant"
  {:arglists (quote (["java.time.format.SignStyle"]))}
  (^java.lang.String [^js/JSJoda.SignStyle this] (.toString this)))

(defn name
  "Returns the name of this enum constant, exactly as declared in its
 enum declaration.

 <b>Most programmers should use the {@link #toString} method in
 preference to this one, as the toString method may return
 a more user-friendly name.</b>  This method is designed primarily for
 use in specialized situations where correctness depends on getting the
 exact name, which will not vary from release to release.

 @return the name of this enum constant"
  {:arglists (quote (["java.time.format.SignStyle"]))}
  (^java.lang.String [^js/JSJoda.SignStyle this] (.name this)))

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
  {:arglists (quote (["java.time.format.SignStyle"]))}
  (^java.lang.Class [^js/JSJoda.SignStyle this] (.declaringClass this)))

(defn hash-code
  "Returns a hash code for this enum constant.

 @return a hash code for this enum constant."
  {:arglists (quote (["java.time.format.SignStyle"]))}
  (^int [^js/JSJoda.SignStyle this] (.hashCode this)))

(defn compare-to
  "Compares this enum with the specified object for order.  Returns a
 negative integer, zero, or a positive integer as this object is less
 than, equal to, or greater than the specified object.

 Enum constants are only comparable to other enum constants of the
 same enum type.  The natural order implemented by this
 method is the order in which the constants are declared."
  {:arglists (quote (["java.time.format.SignStyle" "java.lang.Enum"]))}
  (^int [^js/JSJoda.SignStyle this ^java.lang.Enum o] (.compareTo this o)))

(defn equals
  "Returns true if the specified object is equal to this
 enum constant.

 @param other the object to be compared for equality with this object.
 @return  true if the specified object is equal to this
          enum constant."
  {:arglists (quote (["java.time.format.SignStyle" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.SignStyle this ^java.lang.Object other]
   (.equals this other)))
