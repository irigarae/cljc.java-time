(ns cljc.java-time.temporal.value-range
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time.temporal :refer [ValueRange]]))

(defn get-minimum
  "Gets the minimum value that the field can take.

 For example, the ISO day-of-month always starts at 1.
 The minimum is therefore 1.

 @return the minimum value for this field"
  {:arglists (quote (["java.time.temporal.ValueRange"]))}
  (^long [^js/JSJoda.ValueRange this] (.minimum this)))

(defn of
  {:arglists (quote (["long" "long"]
                     ["long" "long" "long"]
                     ["long" "long" "long" "long"]))}
  (^js/JSJoda.ValueRange [^long min ^long max]
   (js-invoke java.time.temporal.ValueRange "of" min max))
  (^js/JSJoda.ValueRange [^long min ^long max-smallest ^long max-largest]
   (js-invoke java.time.temporal.ValueRange "of" min max-smallest max-largest))
  (^js/JSJoda.ValueRange
   [^long min-smallest ^long min-largest ^long max-smallest ^long max-largest]
   (js-invoke java.time.temporal.ValueRange
              "of"
              min-smallest
              min-largest
              max-smallest
              max-largest)))

(defn is-valid-value
  "Checks if the value is within the valid range.

 This checks that the value is within the stored range of values.

 @param value  the value to check
 @return true if the value is valid"
  {:arglists (quote (["java.time.temporal.ValueRange" "long"]))}
  (^boolean [^js/JSJoda.ValueRange this ^long value]
   (.isValidValue this value)))

(defn check-valid-int-value
  "Checks that the specified value is valid and fits in an {@code int}.

 This validates that the value is within the valid range of values and that
 all valid values are within the bounds of an {@code int}.
 The field is only used to improve the error message.

 @param value  the value to check
 @param field  the field being checked, may be null
 @return the value that was passed in
 @see #isValidIntValue(long)"
  {:arglists (quote (["java.time.temporal.ValueRange" "long"
                      "java.time.temporal.TemporalField"]))}
  (^int [^js/JSJoda.ValueRange this ^long value ^js/JSJoda.TemporalField field]
   (.checkValidIntValue this value field)))

(defn to-string
  "Outputs this range as a {@code String}.

 The format will be '{min}/{largestMin} - {smallestMax}/{max}',
 where the largestMin or smallestMax sections may be omitted, together
 with associated slash, if they are the same as the min or max.

 @return a string representation of this range, not null"
  {:arglists (quote (["java.time.temporal.ValueRange"]))}
  (^java.lang.String [^js/JSJoda.ValueRange this] (.toString this)))

(defn is-int-value
  "Checks if all values in the range fit in an {@code int}.

 This checks that all valid values are within the bounds of an {@code int}.

 For example, the ISO month-of-year has values from 1 to 12, which fits in an {@code int}.
 By comparison, ISO nano-of-day runs from 1 to 86,400,000,000,000 which does not fit in an {@code int}.

 This implementation uses {@link #getMinimum()} and {@link #getMaximum()}.

 @return true if a valid value always fits in an {@code int}"
  {:arglists (quote (["java.time.temporal.ValueRange"]))}
  (^boolean [^js/JSJoda.ValueRange this] (.isIntValue this)))

(defn get-smallest-maximum
  "Gets the smallest possible maximum value that the field can take.

 For example, the ISO day-of-month runs to between 28 and 31 days.
 The smallest maximum is therefore 28.

 @return the smallest possible maximum value for this field"
  {:arglists (quote (["java.time.temporal.ValueRange"]))}
  (^long [^js/JSJoda.ValueRange this] (.smallestMaximum this)))

(defn is-valid-int-value
  "Checks if the value is within the valid range and that all values
 in the range fit in an {@code int}.

 This method combines {@link #isIntValue()} and {@link #isValidValue(long)}.

 @param value  the value to check
 @return true if the value is valid and fits in an {@code int}"
  {:arglists (quote (["java.time.temporal.ValueRange" "long"]))}
  (^boolean [^js/JSJoda.ValueRange this ^long value]
   (.isValidIntValue this value)))

(defn hash-code
  "A hash code for this range.

 @return a suitable hash code"
  {:arglists (quote (["java.time.temporal.ValueRange"]))}
  (^int [^js/JSJoda.ValueRange this] (.hashCode this)))

(defn is-fixed
  "Is the value range fixed and fully known.

 For example, the ISO day-of-month runs from 1 to between 28 and 31.
 Since there is uncertainty about the maximum value, the range is not fixed.
 However, for the month of January, the range is always 1 to 31, thus it is fixed.

 @return true if the set of values is fixed"
  {:arglists (quote (["java.time.temporal.ValueRange"]))}
  (^boolean [^js/JSJoda.ValueRange this] (.isFixed this)))

(defn get-maximum
  "Gets the maximum value that the field can take.

 For example, the ISO day-of-month runs to between 28 and 31 days.
 The maximum is therefore 31.

 @return the maximum value for this field"
  {:arglists (quote (["java.time.temporal.ValueRange"]))}
  (^long [^js/JSJoda.ValueRange this] (.maximum this)))

(defn equals
  "Checks if this range is equal to another range.

 The comparison is based on the four values, minimum, largest minimum,
 smallest maximum and maximum.
 Only objects of type {@code ValueRange} are compared, other types return false.

 @param obj  the object to check, null returns false
 @return true if this is equal to the other range"
  {:arglists (quote (["java.time.temporal.ValueRange" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.ValueRange this ^java.lang.Object obj]
   (.equals this obj)))

(defn get-largest-minimum
  "Gets the largest possible minimum value that the field can take.

 For example, the ISO day-of-month always starts at 1.
 The largest minimum is therefore 1.

 @return the largest possible minimum value for this field"
  {:arglists (quote (["java.time.temporal.ValueRange"]))}
  (^long [^js/JSJoda.ValueRange this] (.largestMinimum this)))

(defn check-valid-value
  "Checks that the specified value is valid.

 This validates that the value is within the valid range of values.
 The field is only used to improve the error message.

 @param value  the value to check
 @param field  the field being checked, may be null
 @return the value that was passed in
 @see #isValidValue(long)"
  {:arglists (quote (["java.time.temporal.ValueRange" "long"
                      "java.time.temporal.TemporalField"]))}
  (^long [^js/JSJoda.ValueRange this ^long value ^js/JSJoda.TemporalField field]
   (.checkValidValue this value field)))
