(ns cljc.java-time.zone-offset
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [ZoneOffset]]))

(def max (goog.object/get java.time.ZoneOffset "MAX"))

(def min (goog.object/get java.time.ZoneOffset "MIN"))

(def utc (goog.object/get java.time.ZoneOffset "UTC"))

(defn get-available-zone-ids
  "Gets the set of available zone IDs.\n <p>\n This set includes the string form of all available region-based IDs.\n Offset-based zone IDs are not included in the returned set.\n The ID can be passed to {@link #of(String)} to create a {@code ZoneId}.\n <p>\n The set of zone IDs can increase over time, although in a typical application\n the set of IDs is fixed. Each call to this method is thread-safe.\n\n @return a modifiable copy of the set of zone IDs, not null"
  {:arglists (quote ([]))}
  (^java.util.Set [] (js-invoke java.time.ZoneOffset "getAvailableZoneIds")))

(defn range
  "Gets the range of valid values for the specified field.\n <p>\n The range object expresses the minimum and maximum valid values for a field.\n This offset is used to enhance the accuracy of the returned range.\n If it is not possible to return the range, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return\n appropriate range instances.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)}\n passing {@code this} as the argument.\n Whether the range can be obtained is determined by the field.\n\n @param field  the field to query the range for, not null\n @return the range of valid values for the field, not null\n @throws DateTimeException if the range for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported"
  {:arglists (quote (["java.time.ZoneOffset"
                      "java.time.temporal.TemporalField"]))}
  (^js/JSJoda.ValueRange
   [^js/JSJoda.ZoneOffset this ^js/JSJoda.TemporalField field]
   (.range this field)))

(defn of-total-seconds
  "Obtains an instance of {@code ZoneOffset} specifying the total offset in seconds\n <p>\n The offset must be in the range {@code -18:00} to {@code +18:00}, which corresponds to -64800 to +64800.\n\n @param totalSeconds  the total time-zone offset in seconds, from -64800 to +64800\n @return the ZoneOffset, not null\n @throws DateTimeException if the offset is not in the required range"
  {:arglists (quote (["int"]))}
  (^js/JSJoda.ZoneOffset [^int total-seconds]
   (js-invoke java.time.ZoneOffset "ofTotalSeconds" total-seconds)))

(defn of
  {:arglists (quote (["java.lang.String"]
                     ["java.lang.String"]
                     ["java.lang.String" "java.util.Map"]))}
  (^java.lang.Object [arg0] (js-invoke java.time.ZoneOffset "of" arg0))
  (^js/JSJoda.ZoneId [^java.lang.String zone-id ^java.util.Map alias-map]
   (js-invoke java.time.ZoneOffset "of" zone-id alias-map)))

(defn of-offset
  "Obtains an instance of {@code ZoneId} wrapping an offset.\n <p>\n If the prefix is \"GMT\", \"UTC\", or \"UT\" a {@code ZoneId}\n with the prefix and the non-zero offset is returned.\n If the prefix is empty {@code \"\"} the {@code ZoneOffset} is returned.\n\n @param prefix  the time-zone ID, not null\n @param offset  the offset, not null\n @return the zone ID, not null\n @throws IllegalArgumentException if the prefix is not one of\n     \"GMT\", \"UTC\", or \"UT\", or \"\""
  {:arglists (quote (["java.lang.String" "java.time.ZoneOffset"]))}
  (^js/JSJoda.ZoneId [^java.lang.String prefix ^js/JSJoda.ZoneOffset offset]
   (js-invoke java.time.ZoneOffset "ofOffset" prefix offset)))

(defn query
  "Queries this offset using the specified query.\n <p>\n This queries this offset using the specified query strategy object.\n The {@code TemporalQuery} object defines the logic to be used to\n obtain the result. Read the documentation of the query to understand\n what the result of this method will be.\n <p>\n The result of this method is obtained by invoking the\n {@link TemporalQuery#queryFrom(TemporalAccessor)} method on the\n specified query passing {@code this} as the argument.\n\n @param <R> the type of the result\n @param query  the query to invoke, not null\n @return the query result, null may be returned (defined by the query)\n @throws DateTimeException if unable to query (defined by the query)\n @throws ArithmeticException if numeric overflow occurs (defined by the query)"
  {:arglists (quote (["java.time.ZoneOffset"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object [^js/JSJoda.ZoneOffset this ^js/JSJoda.TemporalQuery query]
   (.query this query)))

(defn to-string
  "Outputs this offset as a {@code String}, using the normalized ID.\n\n @return a string representation of this offset, not null"
  {:arglists (quote (["java.time.ZoneOffset"]))}
  (^java.lang.String [^js/JSJoda.ZoneOffset this] (.toString this)))

(defn get-display-name
  "Gets the textual representation of the zone, such as 'British Time' or\n '+02:00'.\n <p>\n This returns the textual name used to identify the time-zone ID,\n suitable for presentation to the user.\n The parameters control the style of the returned text and the locale.\n <p>\n If no textual mapping is found then the {@link #getId() full ID} is returned.\n\n @param style  the length of the text required, not null\n @param locale  the locale to use, not null\n @return the text value of the zone, not null"
  {:arglists (quote (["java.time.ZoneOffset" "java.time.format.TextStyle"
                      "java.util.Locale"]))}
  (^java.lang.String
   [^js/JSJoda.ZoneOffset this ^js/JSJoda.TextStyle style
    ^java.util.Locale locale]
   (.displayName this style locale)))

(defn get-long
  "Gets the value of the specified field from this offset as a {@code long}.\n <p>\n This queries this offset for the value of the specified field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@code OFFSET_SECONDS} field returns the value of the offset.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.ZoneOffset"
                      "java.time.temporal.TemporalField"]))}
  (^long [^js/JSJoda.ZoneOffset this ^js/JSJoda.TemporalField field]
   (.getLong this field)))

(defn get-rules
  "Gets the associated time-zone rules.\n <p>\n The rules will always return this offset when queried.\n The implementation class is immutable, thread-safe and serializable.\n\n @return the rules, not null"
  {:arglists (quote (["java.time.ZoneOffset"]))}
  (^js/JSJoda.ZoneRules [^js/JSJoda.ZoneOffset this] (.rules this)))

(defn of-hours
  "Obtains an instance of {@code ZoneOffset} using an offset in hours.\n\n @param hours  the time-zone offset in hours, from -18 to +18\n @return the zone-offset, not null\n @throws DateTimeException if the offset is not in the required range"
  {:arglists (quote (["int"]))}
  (^js/JSJoda.ZoneOffset [^int hours]
   (js-invoke java.time.ZoneOffset "ofHours" hours)))

(defn get-id
  "Gets the normalized zone offset ID.\n <p>\n The ID is minor variation to the standard ISO-8601 formatted string\n for the offset. There are three formats:\n <ul>\n <li>{@code Z} - for UTC (ISO-8601)\n <li>{@code +hh:mm} or {@code -hh:mm} - if the seconds are zero (ISO-8601)\n <li>{@code +hh:mm:ss} or {@code -hh:mm:ss} - if the seconds are non-zero (not ISO-8601)\n </ul>\n\n @return the zone offset ID, not null"
  {:arglists (quote (["java.time.ZoneOffset"]))}
  (^java.lang.String [^js/JSJoda.ZoneOffset this] (.id this)))

(defn normalized
  "Normalizes the time-zone ID, returning a {@code ZoneOffset} where possible.\n <p>\n The returns a normalized {@code ZoneId} that can be used in place of this ID.\n The result will have {@code ZoneRules} equivalent to those returned by this object,\n however the ID returned by {@code getId()} may be different.\n <p>\n The normalization checks if the rules of this {@code ZoneId} have a fixed offset.\n If they do, then the {@code ZoneOffset} equal to that offset is returned.\n Otherwise {@code this} is returned.\n\n @return the time-zone unique ID, not null"
  {:arglists (quote (["java.time.ZoneOffset"]))}
  (^js/JSJoda.ZoneId [^js/JSJoda.ZoneOffset this] (.normalized this)))

(defn system-default
  "Gets the system default time-zone.\n <p>\n This queries {@link TimeZone#getDefault()} to find the default time-zone\n and converts it to a {@code ZoneId}. If the system default time-zone is changed,\n then the result of this method will also change.\n\n @return the zone ID, not null\n @throws DateTimeException if the converted zone ID has an invalid format\n @throws ZoneRulesException if the converted zone region ID cannot be found"
  {:arglists (quote ([]))}
  (^js/JSJoda.ZoneId [] (js-invoke java.time.ZoneOffset "systemDefault")))

(defn from
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]
                     ["java.time.temporal.TemporalAccessor"]))}
  (^java.lang.Object [arg0] (js-invoke java.time.ZoneOffset "from" arg0)))

(defn of-hours-minutes-seconds
  "Obtains an instance of {@code ZoneOffset} using an offset in\n hours, minutes and seconds.\n <p>\n The sign of the hours, minutes and seconds components must match.\n Thus, if the hours is negative, the minutes and seconds must be negative or zero.\n\n @param hours  the time-zone offset in hours, from -18 to +18\n @param minutes  the time-zone offset in minutes, from 0 to &plusmn;59, sign matches hours and seconds\n @param seconds  the time-zone offset in seconds, from 0 to &plusmn;59, sign matches hours and minutes\n @return the zone-offset, not null\n @throws DateTimeException if the offset is not in the required range"
  {:arglists (quote (["int" "int" "int"]))}
  (^js/JSJoda.ZoneOffset [^int hours ^int minutes ^int seconds]
   (js-invoke java.time.ZoneOffset
              "ofHoursMinutesSeconds"
              hours
              minutes
              seconds)))

(defn is-supported
  "Checks if the specified field is supported.\n <p>\n This checks if this offset can be queried for the specified field.\n If false, then calling the {@link #range(TemporalField) range} and\n {@link #get(TemporalField) get} methods will throw an exception.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@code OFFSET_SECONDS} field returns true.\n All other {@code ChronoField} instances will return false.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.isSupportedBy(TemporalAccessor)}\n passing {@code this} as the argument.\n Whether the field is supported is determined by the field.\n\n @param field  the field to check, null returns false\n @return true if the field is supported on this offset, false if not"
  {:arglists (quote (["java.time.ZoneOffset"
                      "java.time.temporal.TemporalField"]))}
  (^boolean [^js/JSJoda.ZoneOffset this ^js/JSJoda.TemporalField field]
   (.isSupported this field)))

(defn hash-code
  "A hash code for this offset.\n\n @return a suitable hash code"
  {:arglists (quote (["java.time.ZoneOffset"]))}
  (^int [^js/JSJoda.ZoneOffset this] (.hashCode this)))

(defn get-total-seconds
  "Gets the total zone offset in seconds.\n <p>\n This is the primary way to access the offset amount.\n It returns the total of the hours, minutes and seconds fields as a\n single offset that can be added to a time.\n\n @return the total zone offset amount in seconds"
  {:arglists (quote (["java.time.ZoneOffset"]))}
  (^int [^js/JSJoda.ZoneOffset this] (.totalSeconds this)))

(defn adjust-into
  "Adjusts the specified temporal object to have the same offset as this object.\n <p>\n This returns a temporal object of the same observable type as the input\n with the offset changed to be the same as this.\n <p>\n The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}\n passing {@link ChronoField#OFFSET_SECONDS} as the field.\n <p>\n In most cases, it is clearer to reverse the calling pattern by using\n {@link Temporal#with(TemporalAdjuster)}:\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   temporal = thisOffset.adjustInto(temporal);\n   temporal = temporal.with(thisOffset);\n </pre>\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param temporal  the target object to be adjusted, not null\n @return the adjusted object, not null\n @throws DateTimeException if unable to make the adjustment\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.ZoneOffset" "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Temporal [^js/JSJoda.ZoneOffset this ^js/JSJoda.Temporal temporal]
   (.adjustInto this temporal)))

(defn of-hours-minutes
  "Obtains an instance of {@code ZoneOffset} using an offset in\n hours and minutes.\n <p>\n The sign of the hours and minutes components must match.\n Thus, if the hours is negative, the minutes must be negative or zero.\n If the hours is zero, the minutes may be positive, negative or zero.\n\n @param hours  the time-zone offset in hours, from -18 to +18\n @param minutes  the time-zone offset in minutes, from 0 to &plusmn;59, sign matches hours\n @return the zone-offset, not null\n @throws DateTimeException if the offset is not in the required range"
  {:arglists (quote (["int" "int"]))}
  (^js/JSJoda.ZoneOffset [^int hours ^int minutes]
   (js-invoke java.time.ZoneOffset "ofHoursMinutes" hours minutes)))

(defn compare-to
  "Compares this offset to another offset in descending order.\n <p>\n The offsets are compared in the order that they occur for the same time\n of day around the world. Thus, an offset of {@code +10:00} comes before an\n offset of {@code +09:00} and so on down to {@code -18:00}.\n <p>\n The comparison is \"consistent with equals\", as defined by {@link Comparable}.\n\n @param other  the other date to compare to, not null\n @return the comparator value, negative if less, positive if greater\n @throws NullPointerException if {@code other} is null"
  {:arglists (quote (["java.time.ZoneOffset" "java.time.ZoneOffset"]))}
  (^int [^js/JSJoda.ZoneOffset this ^js/JSJoda.ZoneOffset other]
   (.compareTo this other)))

(defn get
  "Gets the value of the specified field from this offset as an {@code int}.\n <p>\n This queries this offset for the value of the specified field.\n The returned value will always be within the valid range of values for the field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@code OFFSET_SECONDS} field returns the value of the offset.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained or\n         the value is outside the range of valid values for the field\n @throws UnsupportedTemporalTypeException if the field is not supported or\n         the range of values exceeds an {@code int}\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.ZoneOffset"
                      "java.time.temporal.TemporalField"]))}
  (^int [^js/JSJoda.ZoneOffset this ^js/JSJoda.TemporalField field]
   (.get this field)))

(defn equals
  "Checks if this offset is equal to another offset.\n <p>\n The comparison is based on the amount of the offset in seconds.\n This is equivalent to a comparison by ID.\n\n @param obj  the object to check, null returns false\n @return true if this is equal to the other offset"
  {:arglists (quote (["java.time.ZoneOffset" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.ZoneOffset this ^java.lang.Object obj]
   (.equals this obj)))
