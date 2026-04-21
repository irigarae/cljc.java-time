(ns cljc.java-time.format.text-style
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time.format TextStyle]))

(def short
  "Short text, typically an abbreviation.
 For example, day-of-week Monday might output \"Mon\"."
  java.time.format.TextStyle/SHORT)

(def full-standalone
  "Full text for stand-alone use, typically the full description.
 For example, day-of-week Monday might output \"Monday\"."
  java.time.format.TextStyle/FULL_STANDALONE)

(def full
  "Full text, typically the full description.
 For example, day-of-week Monday might output \"Monday\"."
  java.time.format.TextStyle/FULL)

(def short-standalone
  "Short text for stand-alone use, typically an abbreviation.
 For example, day-of-week Monday might output \"Mon\"."
  java.time.format.TextStyle/SHORT_STANDALONE)

(def narrow
  "Narrow text, typically a single letter.
 For example, day-of-week Monday might output \"M\"."
  java.time.format.TextStyle/NARROW)

(def narrow-standalone
  "Narrow text for stand-alone use, typically a single letter.
 For example, day-of-week Monday might output \"M\"."
  java.time.format.TextStyle/NARROW_STANDALONE)

(defn values
  {:arglists (quote ([]))}
  (^"java.lang.Class" [] (java.time.format.TextStyle/values)))

(defn value-of
  {:arglists (quote (["java.lang.String"]
                     ["java.lang.Class" "java.lang.String"]))}
  (^java.time.format.TextStyle [^java.lang.String name]
   (java.time.format.TextStyle/valueOf name))
  (^java.lang.Enum [^java.lang.Class enum-type ^java.lang.String name]
   (java.time.format.TextStyle/valueOf enum-type name)))

(defn ordinal
  "Returns the ordinal of this enumeration constant (its position
 in its enum declaration, where the initial constant is assigned
 an ordinal of zero).

 Most programmers will have no use for this method.  It is
 designed for use by sophisticated enum-based data structures, such
 as {@link java.util.EnumSet} and {@link java.util.EnumMap}.

 @return the ordinal of this enumeration constant"
  {:arglists (quote (["java.time.format.TextStyle"]))}
  (^java.lang.Integer [^java.time.format.TextStyle this] (.ordinal this)))

(defn as-standalone
  "Returns the stand-alone style with the same size.
 @return the stand-alone style with the same size"
  {:arglists (quote (["java.time.format.TextStyle"]))}
  (^java.time.format.TextStyle [^java.time.format.TextStyle this]
   (.asStandalone this)))

(defn to-string
  "Returns the name of this enum constant, as contained in the
 declaration.  This method may be overridden, though it typically
 isn't necessary or desirable.  An enum type should override this
 method when a more \"programmer-friendly\" string form exists.

 @return the name of this enum constant"
  {:arglists (quote (["java.time.format.TextStyle"]))}
  (^java.lang.String [^java.time.format.TextStyle this] (.toString this)))

(defn name
  "Returns the name of this enum constant, exactly as declared in its
 enum declaration.

 <b>Most programmers should use the {@link #toString} method in
 preference to this one, as the toString method may return
 a more user-friendly name.</b>  This method is designed primarily for
 use in specialized situations where correctness depends on getting the
 exact name, which will not vary from release to release.

 @return the name of this enum constant"
  {:arglists (quote (["java.time.format.TextStyle"]))}
  (^java.lang.String [^java.time.format.TextStyle this] (.name this)))

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
  {:arglists (quote (["java.time.format.TextStyle"]))}
  (^java.lang.Class [^java.time.format.TextStyle this]
   (.getDeclaringClass this)))

(defn as-normal
  "Returns the normal style with the same size.

 @return the normal style with the same size"
  {:arglists (quote (["java.time.format.TextStyle"]))}
  (^java.time.format.TextStyle [^java.time.format.TextStyle this]
   (.asNormal this)))

(defn hash-code
  "Returns a hash code for this enum constant.

 @return a hash code for this enum constant."
  {:arglists (quote (["java.time.format.TextStyle"]))}
  (^java.lang.Integer [^java.time.format.TextStyle this] (.hashCode this)))

(defn compare-to
  "Compares this enum with the specified object for order.  Returns a
 negative integer, zero, or a positive integer as this object is less
 than, equal to, or greater than the specified object.

 Enum constants are only comparable to other enum constants of the
 same enum type.  The natural order implemented by this
 method is the order in which the constants are declared."
  {:arglists (quote (["java.time.format.TextStyle" "java.lang.Enum"]))}
  (^java.lang.Integer [^java.time.format.TextStyle this ^java.lang.Enum o]
   (.compareTo this o)))

(defn is-standalone
  "Returns true if the Style is a stand-alone style.
 @return true if the style is a stand-alone style."
  {:arglists (quote (["java.time.format.TextStyle"]))}
  (^java.lang.Boolean [^java.time.format.TextStyle this] (.isStandalone this)))

(defn equals
  "Returns true if the specified object is equal to this
 enum constant.

 @param other the object to be compared for equality with this object.
 @return  true if the specified object is equal to this
          enum constant."
  {:arglists (quote (["java.time.format.TextStyle" "java.lang.Object"]))}
  (^java.lang.Boolean [^java.time.format.TextStyle this ^java.lang.Object other]
   (.equals this other)))
