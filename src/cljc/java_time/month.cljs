(ns cljc.java-time.month
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [Month]]))

(def may
  "The singleton instance for the month of May with 31 days.
 This has the numeric value of {@code 5}."
  (goog.object/get java.time.Month "MAY"))

(def december
  "The singleton instance for the month of December with 31 days.
 This has the numeric value of {@code 12}."
  (goog.object/get java.time.Month "DECEMBER"))

(def june
  "The singleton instance for the month of June with 30 days.
 This has the numeric value of {@code 6}."
  (goog.object/get java.time.Month "JUNE"))

(def september
  "The singleton instance for the month of September with 30 days.
 This has the numeric value of {@code 9}."
  (goog.object/get java.time.Month "SEPTEMBER"))

(def february
  "The singleton instance for the month of February with 28 days, or 29 in a leap year.
 This has the numeric value of {@code 2}."
  (goog.object/get java.time.Month "FEBRUARY"))

(def january
  "The singleton instance for the month of January with 31 days.
 This has the numeric value of {@code 1}."
  (goog.object/get java.time.Month "JANUARY"))

(def november
  "The singleton instance for the month of November with 30 days.
 This has the numeric value of {@code 11}."
  (goog.object/get java.time.Month "NOVEMBER"))

(def august
  "The singleton instance for the month of August with 31 days.
 This has the numeric value of {@code 8}."
  (goog.object/get java.time.Month "AUGUST"))

(def july
  "The singleton instance for the month of July with 31 days.
 This has the numeric value of {@code 7}."
  (goog.object/get java.time.Month "JULY"))

(def march
  "The singleton instance for the month of March with 31 days.
 This has the numeric value of {@code 3}."
  (goog.object/get java.time.Month "MARCH"))

(def october
  "The singleton instance for the month of October with 31 days.
 This has the numeric value of {@code 10}."
  (goog.object/get java.time.Month "OCTOBER"))

(def april
  "The singleton instance for the month of April with 30 days.
 This has the numeric value of {@code 4}."
  (goog.object/get java.time.Month "APRIL"))

(defn range
  "Gets the range of valid values for the specified field.

 The range object expresses the minimum and maximum valid values for a field.
 This month is used to enhance the accuracy of the returned range.
 If it is not possible to return the range, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is {@link ChronoField#MONTH_OF_YEAR MONTH_OF_YEAR} then the
 range of the month-of-year, from 1 to 12, will be returned.
 All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.

 If the field is not a {@code ChronoField}, then the result of this method
 is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)}
 passing {@code this} as the argument.
 Whether the range can be obtained is determined by the field.

 @param field  the field to query the range for, not null
 @return the range of valid values for the field, not null
 @throws DateTimeException if the range for the field cannot be obtained
 @throws UnsupportedTemporalTypeException if the field is not supported"
  {:arglists (quote (["java.time.Month" "java.time.temporal.TemporalField"]))}
  (^js/JSJoda.ValueRange [^js/JSJoda.Month this ^js/JSJoda.TemporalField field]
   (.range this field)))

(defn values
  {:arglists (quote ([]))}
  (^"java.lang.Class" [] (js-invoke java.time.Month "values")))

(defn value-of
  {:arglists (quote (["java.lang.String"]
                     ["java.lang.Class" "java.lang.String"]))}
  (^js/JSJoda.Month [^java.lang.String name]
   (js-invoke java.time.Month "valueOf" name))
  (^java.lang.Enum [^java.lang.Class enum-type ^java.lang.String name]
   (js-invoke java.time.Month "valueOf" enum-type name)))

(defn of
  "Obtains an instance of {@code Month} from an {@code int} value.

 {@code Month} is an enum representing the 12 months of the year.
 This factory allows the enum to be obtained from the {@code int} value.
 The {@code int} value follows the ISO-8601 standard, from 1 (January) to 12 (December).

 @param month  the month-of-year to represent, from 1 (January) to 12 (December)
 @return the month-of-year, not null
 @throws DateTimeException if the month-of-year is invalid"
  {:arglists (quote (["int"]))}
  (^js/JSJoda.Month [^int month] (js-invoke java.time.Month "of" month)))

(defn ordinal
  "Returns the ordinal of this enumeration constant (its position
 in its enum declaration, where the initial constant is assigned
 an ordinal of zero).

 Most programmers will have no use for this method.  It is
 designed for use by sophisticated enum-based data structures, such
 as {@link java.util.EnumSet} and {@link java.util.EnumMap}.

 @return the ordinal of this enumeration constant"
  {:arglists (quote (["java.time.Month"]))}
  (^int [^js/JSJoda.Month this] (.ordinal this)))

(defn first-month-of-quarter
  "Gets the month corresponding to the first month of this quarter.

 The year can be divided into four quarters.
 This method returns the first month of the quarter for the base month.
 January, February and March return January.
 April, May and June return April.
 July, August and September return July.
 October, November and December return October.

 @return the first month of the quarter corresponding to this month, not null"
  {:arglists (quote (["java.time.Month"]))}
  (^js/JSJoda.Month [^js/JSJoda.Month this] (.firstMonthOfQuarter this)))

(defn min-length
  "Gets the minimum length of this month in days.

 February has a minimum length of 28 days.
 April, June, September and November have 30 days.
 All other months have 31 days.

 @return the minimum length of this month in days, from 28 to 31"
  {:arglists (quote (["java.time.Month"]))}
  (^int [^js/JSJoda.Month this] (.minLength this)))

(defn plus
  "Returns the month-of-year that is the specified number of quarters after this one.

 The calculation rolls around the end of the year from December to January.
 The specified period may be negative.

 This instance is immutable and unaffected by this method call.

 @param months  the months to add, positive or negative
 @return the resulting month, not null"
  {:arglists (quote (["java.time.Month" "long"]))}
  (^js/JSJoda.Month [^js/JSJoda.Month this ^long months] (.plus this months)))

(defn query
  "Queries this month-of-year using the specified query.

 This queries this month-of-year using the specified query strategy object.
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
  {:arglists (quote (["java.time.Month" "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object [^js/JSJoda.Month this ^js/JSJoda.TemporalQuery query]
   (.query this query)))

(defn to-string
  "Returns the name of this enum constant, as contained in the
 declaration.  This method may be overridden, though it typically
 isn't necessary or desirable.  An enum type should override this
 method when a more \"programmer-friendly\" string form exists.

 @return the name of this enum constant"
  {:arglists (quote (["java.time.Month"]))}
  (^java.lang.String [^js/JSJoda.Month this] (.toString this)))

(defn first-day-of-year
  "Gets the day-of-year corresponding to the first day of this month.

 This returns the day-of-year that this month begins on, using the leap
 year flag to determine the length of February.

 @param leapYear  true if the length is required for a leap year
 @return the day of year corresponding to the first day of this month, from 1 to 336"
  {:arglists (quote (["java.time.Month" "boolean"]))}
  (^int [^js/JSJoda.Month this ^boolean leap-year]
   (.firstDayOfYear this leap-year)))

(defn minus
  "Returns the month-of-year that is the specified number of months before this one.

 The calculation rolls around the start of the year from January to December.
 The specified period may be negative.

 This instance is immutable and unaffected by this method call.

 @param months  the months to subtract, positive or negative
 @return the resulting month, not null"
  {:arglists (quote (["java.time.Month" "long"]))}
  (^js/JSJoda.Month [^js/JSJoda.Month this ^long months] (.minus this months)))

(defn get-display-name
  "Gets the textual representation, such as 'Jan' or 'December'.

 This returns the textual name used to identify the month-of-year,
 suitable for presentation to the user.
 The parameters control the style of the returned text and the locale.

 If no textual mapping is found then the {@link #getValue() numeric value} is returned.

 @param style  the length of the text required, not null
 @param locale  the locale to use, not null
 @return the text value of the month-of-year, not null"
  {:arglists (quote (["java.time.Month" "java.time.format.TextStyle"
                      "java.util.Locale"]))}
  (^java.lang.String
   [^js/JSJoda.Month this ^js/JSJoda.TextStyle style ^java.util.Locale locale]
   (.displayName this style locale)))

(defn get-value
  "Gets the month-of-year {@code int} value.

 The values are numbered following the ISO-8601 standard,
 from 1 (January) to 12 (December).

 @return the month-of-year, from 1 (January) to 12 (December)"
  {:arglists (quote (["java.time.Month"]))}
  (^int [^js/JSJoda.Month this] (.value this)))

(defn max-length
  "Gets the maximum length of this month in days.

 February has a maximum length of 29 days.
 April, June, September and November have 30 days.
 All other months have 31 days.

 @return the maximum length of this month in days, from 29 to 31"
  {:arglists (quote (["java.time.Month"]))}
  (^int [^js/JSJoda.Month this] (.maxLength this)))

(defn name
  "Returns the name of this enum constant, exactly as declared in its
 enum declaration.

 <b>Most programmers should use the {@link #toString} method in
 preference to this one, as the toString method may return
 a more user-friendly name.</b>  This method is designed primarily for
 use in specialized situations where correctness depends on getting the
 exact name, which will not vary from release to release.

 @return the name of this enum constant"
  {:arglists (quote (["java.time.Month"]))}
  (^java.lang.String [^js/JSJoda.Month this] (.name this)))

(defn get-long
  "Gets the value of the specified field from this month-of-year as a {@code long}.

 This queries this month for the value of the specified field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is {@link ChronoField#MONTH_OF_YEAR MONTH_OF_YEAR} then the
 value of the month-of-year, from 1 to 12, will be returned.
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
  {:arglists (quote (["java.time.Month" "java.time.temporal.TemporalField"]))}
  (^long [^js/JSJoda.Month this ^js/JSJoda.TemporalField field]
   (.getLong this field)))

(defn length
  "Gets the length of this month in days.

 This takes a flag to determine whether to return the length for a leap year or not.

 February has 28 days in a standard year and 29 days in a leap year.
 April, June, September and November have 30 days.
 All other months have 31 days.

 @param leapYear  true if the length is required for a leap year
 @return the length of this month in days, from 28 to 31"
  {:arglists (quote (["java.time.Month" "boolean"]))}
  (^int [^js/JSJoda.Month this ^boolean leap-year] (.length this leap-year)))

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
  {:arglists (quote (["java.time.Month"]))}
  (^java.lang.Class [^js/JSJoda.Month this] (.declaringClass this)))

(defn from
  "Obtains an instance of {@code Month} from a temporal object.

 This obtains a month based on the specified temporal.
 A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 which this factory converts to an instance of {@code Month}.

 The conversion extracts the {@link ChronoField#MONTH_OF_YEAR MONTH_OF_YEAR} field.
 The extraction is only permitted if the temporal object has an ISO
 chronology, or can be converted to a {@code LocalDate}.

 This method matches the signature of the functional interface {@link TemporalQuery}
 allowing it to be used as a query via method reference, {@code Month::from}.

 @param temporal  the temporal object to convert, not null
 @return the month-of-year, not null
 @throws DateTimeException if unable to convert to a {@code Month}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^js/JSJoda.Month [^js/JSJoda.TemporalAccessor temporal]
   (js-invoke java.time.Month "from" temporal)))

(defn is-supported
  "Checks if the specified field is supported.

 This checks if this month-of-year can be queried for the specified field.
 If false, then calling the {@link #range(TemporalField) range} and
 {@link #get(TemporalField) get} methods will throw an exception.

 If the field is {@link ChronoField#MONTH_OF_YEAR MONTH_OF_YEAR} then
 this method returns true.
 All other {@code ChronoField} instances will return false.

 If the field is not a {@code ChronoField}, then the result of this method
 is obtained by invoking {@code TemporalField.isSupportedBy(TemporalAccessor)}
 passing {@code this} as the argument.
 Whether the field is supported is determined by the field.

 @param field  the field to check, null returns false
 @return true if the field is supported on this month-of-year, false if not"
  {:arglists (quote (["java.time.Month" "java.time.temporal.TemporalField"]))}
  (^boolean [^js/JSJoda.Month this ^js/JSJoda.TemporalField field]
   (.isSupported this field)))

(defn hash-code
  "Returns a hash code for this enum constant.

 @return a hash code for this enum constant."
  {:arglists (quote (["java.time.Month"]))}
  (^int [^js/JSJoda.Month this] (.hashCode this)))

(defn adjust-into
  "Adjusts the specified temporal object to have this month-of-year.

 This returns a temporal object of the same observable type as the input
 with the month-of-year changed to be the same as this.

 The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}
 passing {@link ChronoField#MONTH_OF_YEAR} as the field.
 If the specified temporal object does not use the ISO calendar system then
 a {@code DateTimeException} is thrown.

 In most cases, it is clearer to reverse the calling pattern by using
 {@link Temporal#with(TemporalAdjuster)}:
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   temporal = thisMonth.adjustInto(temporal);
   temporal = temporal.with(thisMonth);
 </pre>

 For example, given a date in May, the following are output:
 <pre>
   dateInMay.with(JANUARY);    // four months earlier
   dateInMay.with(APRIL);      // one months earlier
   dateInMay.with(MAY);        // same date
   dateInMay.with(JUNE);       // one month later
   dateInMay.with(DECEMBER);   // seven months later
 </pre>

 This instance is immutable and unaffected by this method call.

 @param temporal  the target object to be adjusted, not null
 @return the adjusted object, not null
 @throws DateTimeException if unable to make the adjustment
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Month" "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Temporal [^js/JSJoda.Month this ^js/JSJoda.Temporal temporal]
   (.adjustInto this temporal)))

(defn compare-to
  "Compares this enum with the specified object for order.  Returns a
 negative integer, zero, or a positive integer as this object is less
 than, equal to, or greater than the specified object.

 Enum constants are only comparable to other enum constants of the
 same enum type.  The natural order implemented by this
 method is the order in which the constants are declared."
  {:arglists (quote (["java.time.Month" "java.lang.Enum"]))}
  (^int [^js/JSJoda.Month this ^java.lang.Enum o] (.compareTo this o)))

(defn get
  "Gets the value of the specified field from this month-of-year as an {@code int}.

 This queries this month for the value of the specified field.
 The returned value will always be within the valid range of values for the field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is {@link ChronoField#MONTH_OF_YEAR MONTH_OF_YEAR} then the
 value of the month-of-year, from 1 to 12, will be returned.
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
  {:arglists (quote (["java.time.Month" "java.time.temporal.TemporalField"]))}
  (^int [^js/JSJoda.Month this ^js/JSJoda.TemporalField field]
   (.get this field)))

(defn equals
  "Returns true if the specified object is equal to this
 enum constant.

 @param other the object to be compared for equality with this object.
 @return  true if the specified object is equal to this
          enum constant."
  {:arglists (quote (["java.time.Month" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.Month this ^java.lang.Object other]
   (.equals this other)))
