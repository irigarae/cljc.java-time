(ns cljc.java-time.zone-offset
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [ZoneOffset]]))

(def max
  "Constant for the maximum supported offset."
  (goog.object/get java.time.ZoneOffset "MAX"))

(def min
  "Constant for the maximum supported offset."
  (goog.object/get java.time.ZoneOffset "MIN"))

(def utc
  "The time-zone offset for UTC, with an ID of 'Z'."
  (goog.object/get java.time.ZoneOffset "UTC"))

(defn get-available-zone-ids
  "Gets the set of available zone IDs.

 This set includes the string form of all available region-based IDs.
 Offset-based zone IDs are not included in the returned set.
 The ID can be passed to {@link #of(String)} to create a {@code ZoneId}.

 The set of zone IDs can increase over time, although in a typical application
 the set of IDs is fixed. Each call to this method is thread-safe.

 @return a modifiable copy of the set of zone IDs, not null"
  {:arglists (quote ([]))}
  (^java.util.Set [] (js-invoke java.time.ZoneOffset "getAvailableZoneIds")))

(defn range
  "Gets the range of valid values for the specified field.

 The range object expresses the minimum and maximum valid values for a field.
 This offset is used to enhance the accuracy of the returned range.
 If it is not possible to return the range, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@link #isSupported(TemporalField) supported fields} will return
 appropriate range instances.
 All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.

 If the field is not a {@code ChronoField}, then the result of this method
 is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)}
 passing {@code this} as the argument.
 Whether the range can be obtained is determined by the field.

 @param field  the field to query the range for, not null
 @return the range of valid values for the field, not null
 @throws DateTimeException if the range for the field cannot be obtained
 @throws UnsupportedTemporalTypeException if the field is not supported"
  {:arglists (quote (["java.time.ZoneOffset"
                      "java.time.temporal.TemporalField"]))}
  (^js/JSJoda.ValueRange
   [^js/JSJoda.ZoneOffset this ^js/JSJoda.TemporalField field]
   (.range this field)))

(defn of-total-seconds
  "Obtains an instance of {@code ZoneOffset} specifying the total offset in seconds

 The offset must be in the range {@code -18:00} to {@code +18:00}, which corresponds to -64800 to +64800.

 @param totalSeconds  the total time-zone offset in seconds, from -64800 to +64800
 @return the ZoneOffset, not null
 @throws DateTimeException if the offset is not in the required range"
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
  "Obtains an instance of {@code ZoneId} wrapping an offset.

 If the prefix is \"GMT\", \"UTC\", or \"UT\" a {@code ZoneId}
 with the prefix and the non-zero offset is returned.
 If the prefix is empty {@code \"\"} the {@code ZoneOffset} is returned.

 @param prefix  the time-zone ID, not null
 @param offset  the offset, not null
 @return the zone ID, not null
 @throws IllegalArgumentException if the prefix is not one of
     \"GMT\", \"UTC\", or \"UT\", or \"\""
  {:arglists (quote (["java.lang.String" "java.time.ZoneOffset"]))}
  (^js/JSJoda.ZoneId [^java.lang.String prefix ^js/JSJoda.ZoneOffset offset]
   (js-invoke java.time.ZoneOffset "ofOffset" prefix offset)))

(defn query
  "Queries this offset using the specified query.

 This queries this offset using the specified query strategy object.
 The {@code TemporalQuery} object defines the logic to be used to
 obtain the result. Read the documentation of the query to understand
 what the result of this method will be.

 The result of this method is obtained by invoking the
 {@link TemporalQuery#queryFrom(TemporalAccessor)} method on the
 specified query passing {@code this} as the argument.

 @param <R> the type of the result
 @param query  the query to invoke, not null
 @return the query result, null may be returned (defined by the query)
 @throws DateTimeException if unable to query (defined by the query)
 @throws ArithmeticException if numeric overflow occurs (defined by the query)"
  {:arglists (quote (["java.time.ZoneOffset"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object [^js/JSJoda.ZoneOffset this ^js/JSJoda.TemporalQuery query]
   (.query this query)))

(defn to-string
  "Outputs this offset as a {@code String}, using the normalized ID.

 @return a string representation of this offset, not null"
  {:arglists (quote (["java.time.ZoneOffset"]))}
  (^java.lang.String [^js/JSJoda.ZoneOffset this] (.toString this)))

(defn get-display-name
  "Gets the textual representation of the zone, such as 'British Time' or
 '+02:00'.

 This returns the textual name used to identify the time-zone ID,
 suitable for presentation to the user.
 The parameters control the style of the returned text and the locale.

 If no textual mapping is found then the {@link #getId() full ID} is returned.

 @param style  the length of the text required, not null
 @param locale  the locale to use, not null
 @return the text value of the zone, not null"
  {:arglists (quote (["java.time.ZoneOffset" "java.time.format.TextStyle"
                      "java.util.Locale"]))}
  (^java.lang.String
   [^js/JSJoda.ZoneOffset this ^js/JSJoda.TextStyle style
    ^java.util.Locale locale]
   (.displayName this style locale)))

(defn get-long
  "Gets the value of the specified field from this offset as a {@code long}.

 This queries this offset for the value of the specified field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@code OFFSET_SECONDS} field returns the value of the offset.
 All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.

 If the field is not a {@code ChronoField}, then the result of this method
 is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}
 passing {@code this} as the argument. Whether the value can be obtained,
 and what the value represents, is determined by the field.

 @param field  the field to get, not null
 @return the value for the field
 @throws DateTimeException if a value for the field cannot be obtained
 @throws UnsupportedTemporalTypeException if the field is not supported
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.ZoneOffset"
                      "java.time.temporal.TemporalField"]))}
  (^long [^js/JSJoda.ZoneOffset this ^js/JSJoda.TemporalField field]
   (.getLong this field)))

(defn get-rules
  "Gets the associated time-zone rules.

 The rules will always return this offset when queried.
 The implementation class is immutable, thread-safe and serializable.

 @return the rules, not null"
  {:arglists (quote (["java.time.ZoneOffset"]))}
  (^js/JSJoda.ZoneRules [^js/JSJoda.ZoneOffset this] (.rules this)))

(defn of-hours
  "Obtains an instance of {@code ZoneOffset} using an offset in hours.

 @param hours  the time-zone offset in hours, from -18 to +18
 @return the zone-offset, not null
 @throws DateTimeException if the offset is not in the required range"
  {:arglists (quote (["int"]))}
  (^js/JSJoda.ZoneOffset [^int hours]
   (js-invoke java.time.ZoneOffset "ofHours" hours)))

(defn get-id
  "Gets the normalized zone offset ID.

 The ID is minor variation to the standard ISO-8601 formatted string
 for the offset. There are three formats:
 <ul>
 <li>{@code Z} - for UTC (ISO-8601)
 <li>{@code +hh:mm} or {@code -hh:mm} - if the seconds are zero (ISO-8601)
 <li>{@code +hh:mm:ss} or {@code -hh:mm:ss} - if the seconds are non-zero (not ISO-8601)
 </ul>

 @return the zone offset ID, not null"
  {:arglists (quote (["java.time.ZoneOffset"]))}
  (^java.lang.String [^js/JSJoda.ZoneOffset this] (.id this)))

(defn normalized
  "Normalizes the time-zone ID, returning a {@code ZoneOffset} where possible.

 The returns a normalized {@code ZoneId} that can be used in place of this ID.
 The result will have {@code ZoneRules} equivalent to those returned by this object,
 however the ID returned by {@code getId()} may be different.

 The normalization checks if the rules of this {@code ZoneId} have a fixed offset.
 If they do, then the {@code ZoneOffset} equal to that offset is returned.
 Otherwise {@code this} is returned.

 @return the time-zone unique ID, not null"
  {:arglists (quote (["java.time.ZoneOffset"]))}
  (^js/JSJoda.ZoneId [^js/JSJoda.ZoneOffset this] (.normalized this)))

(defn system-default
  "Gets the system default time-zone.

 This queries {@link TimeZone#getDefault()} to find the default time-zone
 and converts it to a {@code ZoneId}. If the system default time-zone is changed,
 then the result of this method will also change.

 @return the zone ID, not null
 @throws DateTimeException if the converted zone ID has an invalid format
 @throws ZoneRulesException if the converted zone region ID cannot be found"
  {:arglists (quote ([]))}
  (^js/JSJoda.ZoneId [] (js-invoke java.time.ZoneOffset "systemDefault")))

(defn from
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]
                     ["java.time.temporal.TemporalAccessor"]))}
  (^java.lang.Object [arg0] (js-invoke java.time.ZoneOffset "from" arg0)))

(defn of-hours-minutes-seconds
  "Obtains an instance of {@code ZoneOffset} using an offset in
 hours, minutes and seconds.

 The sign of the hours, minutes and seconds components must match.
 Thus, if the hours is negative, the minutes and seconds must be negative or zero.

 @param hours  the time-zone offset in hours, from -18 to +18
 @param minutes  the time-zone offset in minutes, from 0 to &plusmn;59, sign matches hours and seconds
 @param seconds  the time-zone offset in seconds, from 0 to &plusmn;59, sign matches hours and minutes
 @return the zone-offset, not null
 @throws DateTimeException if the offset is not in the required range"
  {:arglists (quote (["int" "int" "int"]))}
  (^js/JSJoda.ZoneOffset [^int hours ^int minutes ^int seconds]
   (js-invoke java.time.ZoneOffset
              "ofHoursMinutesSeconds"
              hours
              minutes
              seconds)))

(defn is-supported
  "Checks if the specified field is supported.

 This checks if this offset can be queried for the specified field.
 If false, then calling the {@link #range(TemporalField) range} and
 {@link #get(TemporalField) get} methods will throw an exception.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@code OFFSET_SECONDS} field returns true.
 All other {@code ChronoField} instances will return false.

 If the field is not a {@code ChronoField}, then the result of this method
 is obtained by invoking {@code TemporalField.isSupportedBy(TemporalAccessor)}
 passing {@code this} as the argument.
 Whether the field is supported is determined by the field.

 @param field  the field to check, null returns false
 @return true if the field is supported on this offset, false if not"
  {:arglists (quote (["java.time.ZoneOffset"
                      "java.time.temporal.TemporalField"]))}
  (^boolean [^js/JSJoda.ZoneOffset this ^js/JSJoda.TemporalField field]
   (.isSupported this field)))

(defn hash-code
  "A hash code for this offset.

 @return a suitable hash code"
  {:arglists (quote (["java.time.ZoneOffset"]))}
  (^int [^js/JSJoda.ZoneOffset this] (.hashCode this)))

(defn get-total-seconds
  "Gets the total zone offset in seconds.

 This is the primary way to access the offset amount.
 It returns the total of the hours, minutes and seconds fields as a
 single offset that can be added to a time.

 @return the total zone offset amount in seconds"
  {:arglists (quote (["java.time.ZoneOffset"]))}
  (^int [^js/JSJoda.ZoneOffset this] (.totalSeconds this)))

(defn adjust-into
  "Adjusts the specified temporal object to have the same offset as this object.

 This returns a temporal object of the same observable type as the input
 with the offset changed to be the same as this.

 The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}
 passing {@link ChronoField#OFFSET_SECONDS} as the field.

 In most cases, it is clearer to reverse the calling pattern by using
 {@link Temporal#with(TemporalAdjuster)}:
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   temporal = thisOffset.adjustInto(temporal);
   temporal = temporal.with(thisOffset);
 </pre>

 This instance is immutable and unaffected by this method call.

 @param temporal  the target object to be adjusted, not null
 @return the adjusted object, not null
 @throws DateTimeException if unable to make the adjustment
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.ZoneOffset" "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Temporal [^js/JSJoda.ZoneOffset this ^js/JSJoda.Temporal temporal]
   (.adjustInto this temporal)))

(defn of-hours-minutes
  "Obtains an instance of {@code ZoneOffset} using an offset in
 hours and minutes.

 The sign of the hours and minutes components must match.
 Thus, if the hours is negative, the minutes must be negative or zero.
 If the hours is zero, the minutes may be positive, negative or zero.

 @param hours  the time-zone offset in hours, from -18 to +18
 @param minutes  the time-zone offset in minutes, from 0 to &plusmn;59, sign matches hours
 @return the zone-offset, not null
 @throws DateTimeException if the offset is not in the required range"
  {:arglists (quote (["int" "int"]))}
  (^js/JSJoda.ZoneOffset [^int hours ^int minutes]
   (js-invoke java.time.ZoneOffset "ofHoursMinutes" hours minutes)))

(defn compare-to
  "Compares this offset to another offset in descending order.

 The offsets are compared in the order that they occur for the same time
 of day around the world. Thus, an offset of {@code +10:00} comes before an
 offset of {@code +09:00} and so on down to {@code -18:00}.

 The comparison is \"consistent with equals\", as defined by {@link Comparable}.

 @param other  the other date to compare to, not null
 @return the comparator value, negative if less, positive if greater
 @throws NullPointerException if {@code other} is null"
  {:arglists (quote (["java.time.ZoneOffset" "java.time.ZoneOffset"]))}
  (^int [^js/JSJoda.ZoneOffset this ^js/JSJoda.ZoneOffset other]
   (.compareTo this other)))

(defn get
  "Gets the value of the specified field from this offset as an {@code int}.

 This queries this offset for the value of the specified field.
 The returned value will always be within the valid range of values for the field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@code OFFSET_SECONDS} field returns the value of the offset.
 All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.

 If the field is not a {@code ChronoField}, then the result of this method
 is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}
 passing {@code this} as the argument. Whether the value can be obtained,
 and what the value represents, is determined by the field.

 @param field  the field to get, not null
 @return the value for the field
 @throws DateTimeException if a value for the field cannot be obtained or
         the value is outside the range of valid values for the field
 @throws UnsupportedTemporalTypeException if the field is not supported or
         the range of values exceeds an {@code int}
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.ZoneOffset"
                      "java.time.temporal.TemporalField"]))}
  (^int [^js/JSJoda.ZoneOffset this ^js/JSJoda.TemporalField field]
   (.get this field)))

(defn equals
  "Checks if this offset is equal to another offset.

 The comparison is based on the amount of the offset in seconds.
 This is equivalent to a comparison by ID.

 @param obj  the object to check, null returns false
 @return true if this is equal to the other offset"
  {:arglists (quote (["java.time.ZoneOffset" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.ZoneOffset this ^java.lang.Object obj]
   (.equals this obj)))
