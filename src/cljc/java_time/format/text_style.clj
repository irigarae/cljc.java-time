(ns cljc.java-time.format.text-style
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time.format TextStyle]))

(def short java.time.format.TextStyle/SHORT)

(def full-standalone java.time.format.TextStyle/FULL_STANDALONE)

(def full java.time.format.TextStyle/FULL)

(def short-standalone java.time.format.TextStyle/SHORT_STANDALONE)

(def narrow java.time.format.TextStyle/NARROW)

(def narrow-standalone java.time.format.TextStyle/NARROW_STANDALONE)

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
  "Returns the ordinal of this enumeration constant (its position\n in its enum declaration, where the initial constant is assigned\n an ordinal of zero).\n\n Most programmers will have no use for this method.  It is\n designed for use by sophisticated enum-based data structures, such\n as {@link java.util.EnumSet} and {@link java.util.EnumMap}.\n\n @return the ordinal of this enumeration constant"
  {:arglists (quote (["java.time.format.TextStyle"]))}
  (^java.lang.Integer [^java.time.format.TextStyle this] (.ordinal this)))

(defn as-standalone
  "Returns the stand-alone style with the same size.\n @return the stand-alone style with the same size"
  {:arglists (quote (["java.time.format.TextStyle"]))}
  (^java.time.format.TextStyle [^java.time.format.TextStyle this]
   (.asStandalone this)))

(defn to-string
  "Returns the name of this enum constant, as contained in the\n declaration.  This method may be overridden, though it typically\n isn't necessary or desirable.  An enum type should override this\n method when a more \"programmer-friendly\" string form exists.\n\n @return the name of this enum constant"
  {:arglists (quote (["java.time.format.TextStyle"]))}
  (^java.lang.String [^java.time.format.TextStyle this] (.toString this)))

(defn name
  "Returns the name of this enum constant, exactly as declared in its\n enum declaration.\n\n <b>Most programmers should use the {@link #toString} method in\n preference to this one, as the toString method may return\n a more user-friendly name.</b>  This method is designed primarily for\n use in specialized situations where correctness depends on getting the\n exact name, which will not vary from release to release.\n\n @return the name of this enum constant"
  {:arglists (quote (["java.time.format.TextStyle"]))}
  (^java.lang.String [^java.time.format.TextStyle this] (.name this)))

(defn get-declaring-class
  "Returns the Class object corresponding to this enum constant's\n enum type.  Two enum constants e1 and  e2 are of the\n same enum type if and only if\n   e1.getDeclaringClass() == e2.getDeclaringClass().\n (The value returned by this method may differ from the one returned\n by the {@link Object#getClass} method for enum constants with\n constant-specific class bodies.)\n\n @return the Class object corresponding to this enum constant's\n     enum type"
  {:arglists (quote (["java.time.format.TextStyle"]))}
  (^java.lang.Class [^java.time.format.TextStyle this]
   (.getDeclaringClass this)))

(defn as-normal
  "Returns the normal style with the same size.\n\n @return the normal style with the same size"
  {:arglists (quote (["java.time.format.TextStyle"]))}
  (^java.time.format.TextStyle [^java.time.format.TextStyle this]
   (.asNormal this)))

(defn hash-code
  "Returns a hash code for this enum constant.\n\n @return a hash code for this enum constant."
  {:arglists (quote (["java.time.format.TextStyle"]))}
  (^java.lang.Integer [^java.time.format.TextStyle this] (.hashCode this)))

(defn compare-to
  "Compares this enum with the specified object for order.  Returns a\n negative integer, zero, or a positive integer as this object is less\n than, equal to, or greater than the specified object.\n\n Enum constants are only comparable to other enum constants of the\n same enum type.  The natural order implemented by this\n method is the order in which the constants are declared."
  {:arglists (quote (["java.time.format.TextStyle" "java.lang.Enum"]))}
  (^java.lang.Integer [^java.time.format.TextStyle this ^java.lang.Enum o]
   (.compareTo this o)))

(defn is-standalone
  "Returns true if the Style is a stand-alone style.\n @return true if the style is a stand-alone style."
  {:arglists (quote (["java.time.format.TextStyle"]))}
  (^java.lang.Boolean [^java.time.format.TextStyle this] (.isStandalone this)))

(defn equals
  "Returns true if the specified object is equal to this\n enum constant.\n\n @param other the object to be compared for equality with this object.\n @return  true if the specified object is equal to this\n          enum constant."
  {:arglists (quote (["java.time.format.TextStyle" "java.lang.Object"]))}
  (^java.lang.Boolean [^java.time.format.TextStyle this ^java.lang.Object other]
   (.equals this other)))
