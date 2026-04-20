(ns cljc.java-time.temporal.value-range
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time.temporal :refer [ValueRange]]))

(defn get-minimum
  "Gets the minimum value that the field can take.\n <p>\n For example, the ISO day-of-month always starts at 1.\n The minimum is therefore 1.\n\n @return the minimum value for this field"
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
  "Checks if the value is within the valid range.\n <p>\n This checks that the value is within the stored range of values.\n\n @param value  the value to check\n @return true if the value is valid"
  {:arglists (quote (["java.time.temporal.ValueRange" "long"]))}
  (^boolean [^js/JSJoda.ValueRange this ^long value]
   (.isValidValue this value)))

(defn check-valid-int-value
  "Checks that the specified value is valid and fits in an {@code int}.\n <p>\n This validates that the value is within the valid range of values and that\n all valid values are within the bounds of an {@code int}.\n The field is only used to improve the error message.\n\n @param value  the value to check\n @param field  the field being checked, may be null\n @return the value that was passed in\n @see #isValidIntValue(long)"
  {:arglists (quote (["java.time.temporal.ValueRange" "long"
                      "java.time.temporal.TemporalField"]))}
  (^int [^js/JSJoda.ValueRange this ^long value ^js/JSJoda.TemporalField field]
   (.checkValidIntValue this value field)))

(defn to-string
  "Outputs this range as a {@code String}.\n <p>\n The format will be '{min}/{largestMin} - {smallestMax}/{max}',\n where the largestMin or smallestMax sections may be omitted, together\n with associated slash, if they are the same as the min or max.\n\n @return a string representation of this range, not null"
  {:arglists (quote (["java.time.temporal.ValueRange"]))}
  (^java.lang.String [^js/JSJoda.ValueRange this] (.toString this)))

(defn is-int-value
  "Checks if all values in the range fit in an {@code int}.\n <p>\n This checks that all valid values are within the bounds of an {@code int}.\n <p>\n For example, the ISO month-of-year has values from 1 to 12, which fits in an {@code int}.\n By comparison, ISO nano-of-day runs from 1 to 86,400,000,000,000 which does not fit in an {@code int}.\n <p>\n This implementation uses {@link #getMinimum()} and {@link #getMaximum()}.\n\n @return true if a valid value always fits in an {@code int}"
  {:arglists (quote (["java.time.temporal.ValueRange"]))}
  (^boolean [^js/JSJoda.ValueRange this] (.isIntValue this)))

(defn get-smallest-maximum
  "Gets the smallest possible maximum value that the field can take.\n <p>\n For example, the ISO day-of-month runs to between 28 and 31 days.\n The smallest maximum is therefore 28.\n\n @return the smallest possible maximum value for this field"
  {:arglists (quote (["java.time.temporal.ValueRange"]))}
  (^long [^js/JSJoda.ValueRange this] (.smallestMaximum this)))

(defn is-valid-int-value
  "Checks if the value is within the valid range and that all values\n in the range fit in an {@code int}.\n <p>\n This method combines {@link #isIntValue()} and {@link #isValidValue(long)}.\n\n @param value  the value to check\n @return true if the value is valid and fits in an {@code int}"
  {:arglists (quote (["java.time.temporal.ValueRange" "long"]))}
  (^boolean [^js/JSJoda.ValueRange this ^long value]
   (.isValidIntValue this value)))

(defn hash-code
  "A hash code for this range.\n\n @return a suitable hash code"
  {:arglists (quote (["java.time.temporal.ValueRange"]))}
  (^int [^js/JSJoda.ValueRange this] (.hashCode this)))

(defn is-fixed
  "Is the value range fixed and fully known.\n <p>\n For example, the ISO day-of-month runs from 1 to between 28 and 31.\n Since there is uncertainty about the maximum value, the range is not fixed.\n However, for the month of January, the range is always 1 to 31, thus it is fixed.\n\n @return true if the set of values is fixed"
  {:arglists (quote (["java.time.temporal.ValueRange"]))}
  (^boolean [^js/JSJoda.ValueRange this] (.isFixed this)))

(defn get-maximum
  "Gets the maximum value that the field can take.\n <p>\n For example, the ISO day-of-month runs to between 28 and 31 days.\n The maximum is therefore 31.\n\n @return the maximum value for this field"
  {:arglists (quote (["java.time.temporal.ValueRange"]))}
  (^long [^js/JSJoda.ValueRange this] (.maximum this)))

(defn equals
  "Checks if this range is equal to another range.\n <p>\n The comparison is based on the four values, minimum, largest minimum,\n smallest maximum and maximum.\n Only objects of type {@code ValueRange} are compared, other types return false.\n\n @param obj  the object to check, null returns false\n @return true if this is equal to the other range"
  {:arglists (quote (["java.time.temporal.ValueRange" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.ValueRange this ^java.lang.Object obj]
   (.equals this obj)))

(defn get-largest-minimum
  "Gets the largest possible minimum value that the field can take.\n <p>\n For example, the ISO day-of-month always starts at 1.\n The largest minimum is therefore 1.\n\n @return the largest possible minimum value for this field"
  {:arglists (quote (["java.time.temporal.ValueRange"]))}
  (^long [^js/JSJoda.ValueRange this] (.largestMinimum this)))

(defn check-valid-value
  "Checks that the specified value is valid.\n <p>\n This validates that the value is within the valid range of values.\n The field is only used to improve the error message.\n\n @param value  the value to check\n @param field  the field being checked, may be null\n @return the value that was passed in\n @see #isValidValue(long)"
  {:arglists (quote (["java.time.temporal.ValueRange" "long"
                      "java.time.temporal.TemporalField"]))}
  (^long [^js/JSJoda.ValueRange this ^long value ^js/JSJoda.TemporalField field]
   (.checkValidValue this value field)))
