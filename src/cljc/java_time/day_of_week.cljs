(ns cljc.java-time.day-of-week
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [DayOfWeek]]))

(def saturday (goog.object/get java.time.DayOfWeek "SATURDAY"))

(def thursday (goog.object/get java.time.DayOfWeek "THURSDAY"))

(def friday (goog.object/get java.time.DayOfWeek "FRIDAY"))

(def wednesday (goog.object/get java.time.DayOfWeek "WEDNESDAY"))

(def sunday (goog.object/get java.time.DayOfWeek "SUNDAY"))

(def monday (goog.object/get java.time.DayOfWeek "MONDAY"))

(def tuesday (goog.object/get java.time.DayOfWeek "TUESDAY"))

(defn range
  "Gets the range of valid values for the specified field.

 The range object expresses the minimum and maximum valid values for a field.
 This day-of-week is used to enhance the accuracy of the returned range.
 If it is not possible to return the range, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is {@link ChronoField#DAY_OF_WEEK DAY_OF_WEEK} then the
 range of the day-of-week, from 1 to 7, will be returned.
 All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.

 If the field is not a {@code ChronoField}, then the result of this method
 is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)}
 passing {@code this} as the argument.
 Whether the range can be obtained is determined by the field.

 @param field  the field to query the range for, not null
 @return the range of valid values for the field, not null
 @throws DateTimeException if the range for the field cannot be obtained
 @throws UnsupportedTemporalTypeException if the field is not supported"
  {:arglists (quote (["java.time.DayOfWeek"
                      "java.time.temporal.TemporalField"]))}
  (^js/JSJoda.ValueRange
   [^js/JSJoda.DayOfWeek this ^js/JSJoda.TemporalField field]
   (.range this field)))

(defn values
  {:arglists (quote ([]))}
  (^"java.lang.Class" [] (js-invoke java.time.DayOfWeek "values")))

(defn value-of
  {:arglists (quote (["java.lang.String"]
                     ["java.lang.Class" "java.lang.String"]))}
  (^js/JSJoda.DayOfWeek [^java.lang.String name]
   (js-invoke java.time.DayOfWeek "valueOf" name))
  (^java.lang.Enum [^java.lang.Class enum-type ^java.lang.String name]
   (js-invoke java.time.DayOfWeek "valueOf" enum-type name)))

(defn of
  "Obtains an instance of {@code DayOfWeek} from an {@code int} value.

 {@code DayOfWeek} is an enum representing the 7 days of the week.
 This factory allows the enum to be obtained from the {@code int} value.
 The {@code int} value follows the ISO-8601 standard, from 1 (Monday) to 7 (Sunday).

 @param dayOfWeek  the day-of-week to represent, from 1 (Monday) to 7 (Sunday)
 @return the day-of-week singleton, not null
 @throws DateTimeException if the day-of-week is invalid"
  {:arglists (quote (["int"]))}
  (^js/JSJoda.DayOfWeek [^int day-of-week]
   (js-invoke java.time.DayOfWeek "of" day-of-week)))

(defn ordinal
  "Returns the ordinal of this enumeration constant (its position
 in its enum declaration, where the initial constant is assigned
 an ordinal of zero).

 Most programmers will have no use for this method.  It is
 designed for use by sophisticated enum-based data structures, such
 as {@link java.util.EnumSet} and {@link java.util.EnumMap}.

 @return the ordinal of this enumeration constant"
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^int [^js/JSJoda.DayOfWeek this] (.ordinal this)))

(defn plus
  "Returns the day-of-week that is the specified number of days after this one.

 The calculation rolls around the end of the week from Sunday to Monday.
 The specified period may be negative.

 This instance is immutable and unaffected by this method call.

 @param days  the days to add, positive or negative
 @return the resulting day-of-week, not null"
  {:arglists (quote (["java.time.DayOfWeek" "long"]))}
  (^js/JSJoda.DayOfWeek [^js/JSJoda.DayOfWeek this ^long days]
   (.plus this days)))

(defn query
  "Queries this day-of-week using the specified query.

 This queries this day-of-week using the specified query strategy object.
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
  {:arglists (quote (["java.time.DayOfWeek"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object [^js/JSJoda.DayOfWeek this ^js/JSJoda.TemporalQuery query]
   (.query this query)))

(defn to-string
  "Returns the name of this enum constant, as contained in the
 declaration.  This method may be overridden, though it typically
 isn't necessary or desirable.  An enum type should override this
 method when a more \"programmer-friendly\" string form exists.

 @return the name of this enum constant"
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^java.lang.String [^js/JSJoda.DayOfWeek this] (.toString this)))

(defn minus
  "Returns the day-of-week that is the specified number of days before this one.

 The calculation rolls around the start of the year from Monday to Sunday.
 The specified period may be negative.

 This instance is immutable and unaffected by this method call.

 @param days  the days to subtract, positive or negative
 @return the resulting day-of-week, not null"
  {:arglists (quote (["java.time.DayOfWeek" "long"]))}
  (^js/JSJoda.DayOfWeek [^js/JSJoda.DayOfWeek this ^long days]
   (.minus this days)))

(defn get-display-name
  "Gets the textual representation, such as 'Mon' or 'Friday'.

 This returns the textual name used to identify the day-of-week,
 suitable for presentation to the user.
 The parameters control the style of the returned text and the locale.

 If no textual mapping is found then the {@link #getValue() numeric value} is returned.

 @param style  the length of the text required, not null
 @param locale  the locale to use, not null
 @return the text value of the day-of-week, not null"
  {:arglists (quote (["java.time.DayOfWeek" "java.time.format.TextStyle"
                      "java.util.Locale"]))}
  (^java.lang.String
   [^js/JSJoda.DayOfWeek this ^js/JSJoda.TextStyle style
    ^java.util.Locale locale]
   (.displayName this style locale)))

(defn get-value
  "Gets the day-of-week {@code int} value.

 The values are numbered following the ISO-8601 standard, from 1 (Monday) to 7 (Sunday).
 See {@link java.time.temporal.WeekFields#dayOfWeek()} for localized week-numbering.

 @return the day-of-week, from 1 (Monday) to 7 (Sunday)"
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^int [^js/JSJoda.DayOfWeek this] (.value this)))

(defn name
  "Returns the name of this enum constant, exactly as declared in its
 enum declaration.

 <b>Most programmers should use the {@link #toString} method in
 preference to this one, as the toString method may return
 a more user-friendly name.</b>  This method is designed primarily for
 use in specialized situations where correctness depends on getting the
 exact name, which will not vary from release to release.

 @return the name of this enum constant"
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^java.lang.String [^js/JSJoda.DayOfWeek this] (.name this)))

(defn get-long
  "Gets the value of the specified field from this day-of-week as a {@code long}.

 This queries this day-of-week for the value of the specified field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is {@link ChronoField#DAY_OF_WEEK DAY_OF_WEEK} then the
 value of the day-of-week, from 1 to 7, will be returned.
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
  {:arglists (quote (["java.time.DayOfWeek"
                      "java.time.temporal.TemporalField"]))}
  (^long [^js/JSJoda.DayOfWeek this ^js/JSJoda.TemporalField field]
   (.getLong this field)))

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
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^java.lang.Class [^js/JSJoda.DayOfWeek this] (.declaringClass this)))

(defn from
  "Obtains an instance of {@code DayOfWeek} from a temporal object.

 This obtains a day-of-week based on the specified temporal.
 A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 which this factory converts to an instance of {@code DayOfWeek}.

 The conversion extracts the {@link ChronoField#DAY_OF_WEEK DAY_OF_WEEK} field.

 This method matches the signature of the functional interface {@link TemporalQuery}
 allowing it to be used as a query via method reference, {@code DayOfWeek::from}.

 @param temporal  the temporal object to convert, not null
 @return the day-of-week, not null
 @throws DateTimeException if unable to convert to a {@code DayOfWeek}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^js/JSJoda.DayOfWeek [^js/JSJoda.TemporalAccessor temporal]
   (js-invoke java.time.DayOfWeek "from" temporal)))

(defn is-supported
  "Checks if the specified field is supported.

 This checks if this day-of-week can be queried for the specified field.
 If false, then calling the {@link #range(TemporalField) range} and
 {@link #get(TemporalField) get} methods will throw an exception.

 If the field is {@link ChronoField#DAY_OF_WEEK DAY_OF_WEEK} then
 this method returns true.
 All other {@code ChronoField} instances will return false.

 If the field is not a {@code ChronoField}, then the result of this method
 is obtained by invoking {@code TemporalField.isSupportedBy(TemporalAccessor)}
 passing {@code this} as the argument.
 Whether the field is supported is determined by the field.

 @param field  the field to check, null returns false
 @return true if the field is supported on this day-of-week, false if not"
  {:arglists (quote (["java.time.DayOfWeek"
                      "java.time.temporal.TemporalField"]))}
  (^boolean [^js/JSJoda.DayOfWeek this ^js/JSJoda.TemporalField field]
   (.isSupported this field)))

(defn hash-code
  "Returns a hash code for this enum constant.

 @return a hash code for this enum constant."
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^int [^js/JSJoda.DayOfWeek this] (.hashCode this)))

(defn adjust-into
  "Adjusts the specified temporal object to have this day-of-week.

 This returns a temporal object of the same observable type as the input
 with the day-of-week changed to be the same as this.

 The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}
 passing {@link ChronoField#DAY_OF_WEEK} as the field.
 Note that this adjusts forwards or backwards within a Monday to Sunday week.
 See {@link java.time.temporal.WeekFields#dayOfWeek()} for localized week start days.
 See {@code TemporalAdjuster} for other adjusters with more control,
 such as {@code next(MONDAY)}.

 In most cases, it is clearer to reverse the calling pattern by using
 {@link Temporal#with(TemporalAdjuster)}:
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   temporal = thisDayOfWeek.adjustInto(temporal);
   temporal = temporal.with(thisDayOfWeek);
 </pre>

 For example, given a date that is a Wednesday, the following are output:
 <pre>
   dateOnWed.with(MONDAY);     // two days earlier
   dateOnWed.with(TUESDAY);    // one day earlier
   dateOnWed.with(WEDNESDAY);  // same date
   dateOnWed.with(THURSDAY);   // one day later
   dateOnWed.with(FRIDAY);     // two days later
   dateOnWed.with(SATURDAY);   // three days later
   dateOnWed.with(SUNDAY);     // four days later
 </pre>

 This instance is immutable and unaffected by this method call.

 @param temporal  the target object to be adjusted, not null
 @return the adjusted object, not null
 @throws DateTimeException if unable to make the adjustment
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.DayOfWeek" "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Temporal [^js/JSJoda.DayOfWeek this ^js/JSJoda.Temporal temporal]
   (.adjustInto this temporal)))

(defn compare-to
  "Compares this enum with the specified object for order.  Returns a
 negative integer, zero, or a positive integer as this object is less
 than, equal to, or greater than the specified object.

 Enum constants are only comparable to other enum constants of the
 same enum type.  The natural order implemented by this
 method is the order in which the constants are declared."
  {:arglists (quote (["java.time.DayOfWeek" "java.lang.Enum"]))}
  (^int [^js/JSJoda.DayOfWeek this ^java.lang.Enum o] (.compareTo this o)))

(defn get
  "Gets the value of the specified field from this day-of-week as an {@code int}.

 This queries this day-of-week for the value of the specified field.
 The returned value will always be within the valid range of values for the field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is {@link ChronoField#DAY_OF_WEEK DAY_OF_WEEK} then the
 value of the day-of-week, from 1 to 7, will be returned.
 All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.

 If the field is not a {@code ChronoField}, then the result of this method
 is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}
 passing {@code this} as the argument. Whether the value can be obtained,
 and what the value represents, is determined by the field.

 @param field  the field to get, not null
 @return the value for the field, within the valid range of values
 @throws DateTimeException if a value for the field cannot be obtained or
         the value is outside the range of valid values for the field
 @throws UnsupportedTemporalTypeException if the field is not supported or
         the range of values exceeds an {@code int}
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.DayOfWeek"
                      "java.time.temporal.TemporalField"]))}
  (^int [^js/JSJoda.DayOfWeek this ^js/JSJoda.TemporalField field]
   (.get this field)))

(defn equals
  "Returns true if the specified object is equal to this
 enum constant.

 @param other the object to be compared for equality with this object.
 @return  true if the specified object is equal to this
          enum constant."
  {:arglists (quote (["java.time.DayOfWeek" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.DayOfWeek this ^java.lang.Object other]
   (.equals this other)))
