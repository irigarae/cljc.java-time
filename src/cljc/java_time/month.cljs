(ns cljc.java-time.month
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [Month]]))

(def may (goog.object/get java.time.Month "MAY"))

(def december (goog.object/get java.time.Month "DECEMBER"))

(def june (goog.object/get java.time.Month "JUNE"))

(def september (goog.object/get java.time.Month "SEPTEMBER"))

(def february (goog.object/get java.time.Month "FEBRUARY"))

(def january (goog.object/get java.time.Month "JANUARY"))

(def november (goog.object/get java.time.Month "NOVEMBER"))

(def august (goog.object/get java.time.Month "AUGUST"))

(def july (goog.object/get java.time.Month "JULY"))

(def march (goog.object/get java.time.Month "MARCH"))

(def october (goog.object/get java.time.Month "OCTOBER"))

(def april (goog.object/get java.time.Month "APRIL"))

(defn range
  "Gets the range of valid values for the specified field.\n <p>\n The range object expresses the minimum and maximum valid values for a field.\n This month is used to enhance the accuracy of the returned range.\n If it is not possible to return the range, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is {@link ChronoField#MONTH_OF_YEAR MONTH_OF_YEAR} then the\n range of the month-of-year, from 1 to 12, will be returned.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)}\n passing {@code this} as the argument.\n Whether the range can be obtained is determined by the field.\n\n @param field  the field to query the range for, not null\n @return the range of valid values for the field, not null\n @throws DateTimeException if the range for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported"
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
  "Obtains an instance of {@code Month} from an {@code int} value.\n <p>\n {@code Month} is an enum representing the 12 months of the year.\n This factory allows the enum to be obtained from the {@code int} value.\n The {@code int} value follows the ISO-8601 standard, from 1 (January) to 12 (December).\n\n @param month  the month-of-year to represent, from 1 (January) to 12 (December)\n @return the month-of-year, not null\n @throws DateTimeException if the month-of-year is invalid"
  {:arglists (quote (["int"]))}
  (^js/JSJoda.Month [^int month] (js-invoke java.time.Month "of" month)))

(defn ordinal
  "Returns the ordinal of this enumeration constant (its position\n in its enum declaration, where the initial constant is assigned\n an ordinal of zero).\n\n Most programmers will have no use for this method.  It is\n designed for use by sophisticated enum-based data structures, such\n as {@link java.util.EnumSet} and {@link java.util.EnumMap}.\n\n @return the ordinal of this enumeration constant"
  {:arglists (quote (["java.time.Month"]))}
  (^int [^js/JSJoda.Month this] (.ordinal this)))

(defn first-month-of-quarter
  "Gets the month corresponding to the first month of this quarter.\n <p>\n The year can be divided into four quarters.\n This method returns the first month of the quarter for the base month.\n January, February and March return January.\n April, May and June return April.\n July, August and September return July.\n October, November and December return October.\n\n @return the first month of the quarter corresponding to this month, not null"
  {:arglists (quote (["java.time.Month"]))}
  (^js/JSJoda.Month [^js/JSJoda.Month this] (.firstMonthOfQuarter this)))

(defn min-length
  "Gets the minimum length of this month in days.\n <p>\n February has a minimum length of 28 days.\n April, June, September and November have 30 days.\n All other months have 31 days.\n\n @return the minimum length of this month in days, from 28 to 31"
  {:arglists (quote (["java.time.Month"]))}
  (^int [^js/JSJoda.Month this] (.minLength this)))

(defn plus
  "Returns the month-of-year that is the specified number of quarters after this one.\n <p>\n The calculation rolls around the end of the year from December to January.\n The specified period may be negative.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param months  the months to add, positive or negative\n @return the resulting month, not null"
  {:arglists (quote (["java.time.Month" "long"]))}
  (^js/JSJoda.Month [^js/JSJoda.Month this ^long months] (.plus this months)))

(defn query
  "Queries this month-of-year using the specified query.\n <p>\n This queries this month-of-year using the specified query strategy object.\n The {@code TemporalQuery} object defines the logic to be used to\n obtain the result. Read the documentation of the query to understand\n what the result of this method will be.\n <p>\n The result of this method is obtained by invoking the\n {@link TemporalQuery#queryFrom(TemporalAccessor)} method on the\n specified query passing {@code this} as the argument.\n\n @param <R> the type of the result\n @param query  the query to invoke, not null\n @return the query result, null may be returned (defined by the query)\n @throws DateTimeException if unable to query (defined by the query)\n @throws ArithmeticException if numeric overflow occurs (defined by the query)"
  {:arglists (quote (["java.time.Month" "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object [^js/JSJoda.Month this ^js/JSJoda.TemporalQuery query]
   (.query this query)))

(defn to-string
  "Returns the name of this enum constant, as contained in the\n declaration.  This method may be overridden, though it typically\n isn't necessary or desirable.  An enum type should override this\n method when a more \"programmer-friendly\" string form exists.\n\n @return the name of this enum constant"
  {:arglists (quote (["java.time.Month"]))}
  (^java.lang.String [^js/JSJoda.Month this] (.toString this)))

(defn first-day-of-year
  "Gets the day-of-year corresponding to the first day of this month.\n <p>\n This returns the day-of-year that this month begins on, using the leap\n year flag to determine the length of February.\n\n @param leapYear  true if the length is required for a leap year\n @return the day of year corresponding to the first day of this month, from 1 to 336"
  {:arglists (quote (["java.time.Month" "boolean"]))}
  (^int [^js/JSJoda.Month this ^boolean leap-year]
   (.firstDayOfYear this leap-year)))

(defn minus
  "Returns the month-of-year that is the specified number of months before this one.\n <p>\n The calculation rolls around the start of the year from January to December.\n The specified period may be negative.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param months  the months to subtract, positive or negative\n @return the resulting month, not null"
  {:arglists (quote (["java.time.Month" "long"]))}
  (^js/JSJoda.Month [^js/JSJoda.Month this ^long months] (.minus this months)))

(defn get-display-name
  "Gets the textual representation, such as 'Jan' or 'December'.\n <p>\n This returns the textual name used to identify the month-of-year,\n suitable for presentation to the user.\n The parameters control the style of the returned text and the locale.\n <p>\n If no textual mapping is found then the {@link #getValue() numeric value} is returned.\n\n @param style  the length of the text required, not null\n @param locale  the locale to use, not null\n @return the text value of the month-of-year, not null"
  {:arglists (quote (["java.time.Month" "java.time.format.TextStyle"
                      "java.util.Locale"]))}
  (^java.lang.String
   [^js/JSJoda.Month this ^js/JSJoda.TextStyle style ^java.util.Locale locale]
   (.displayName this style locale)))

(defn get-value
  "Gets the month-of-year {@code int} value.\n <p>\n The values are numbered following the ISO-8601 standard,\n from 1 (January) to 12 (December).\n\n @return the month-of-year, from 1 (January) to 12 (December)"
  {:arglists (quote (["java.time.Month"]))}
  (^int [^js/JSJoda.Month this] (.value this)))

(defn max-length
  "Gets the maximum length of this month in days.\n <p>\n February has a maximum length of 29 days.\n April, June, September and November have 30 days.\n All other months have 31 days.\n\n @return the maximum length of this month in days, from 29 to 31"
  {:arglists (quote (["java.time.Month"]))}
  (^int [^js/JSJoda.Month this] (.maxLength this)))

(defn name
  "Returns the name of this enum constant, exactly as declared in its\n enum declaration.\n\n <b>Most programmers should use the {@link #toString} method in\n preference to this one, as the toString method may return\n a more user-friendly name.</b>  This method is designed primarily for\n use in specialized situations where correctness depends on getting the\n exact name, which will not vary from release to release.\n\n @return the name of this enum constant"
  {:arglists (quote (["java.time.Month"]))}
  (^java.lang.String [^js/JSJoda.Month this] (.name this)))

(defn get-long
  "Gets the value of the specified field from this month-of-year as a {@code long}.\n <p>\n This queries this month for the value of the specified field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is {@link ChronoField#MONTH_OF_YEAR MONTH_OF_YEAR} then the\n value of the month-of-year, from 1 to 12, will be returned.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Month" "java.time.temporal.TemporalField"]))}
  (^long [^js/JSJoda.Month this ^js/JSJoda.TemporalField field]
   (.getLong this field)))

(defn length
  "Gets the length of this month in days.\n <p>\n This takes a flag to determine whether to return the length for a leap year or not.\n <p>\n February has 28 days in a standard year and 29 days in a leap year.\n April, June, September and November have 30 days.\n All other months have 31 days.\n\n @param leapYear  true if the length is required for a leap year\n @return the length of this month in days, from 28 to 31"
  {:arglists (quote (["java.time.Month" "boolean"]))}
  (^int [^js/JSJoda.Month this ^boolean leap-year] (.length this leap-year)))

(defn get-declaring-class
  "Returns the Class object corresponding to this enum constant's\n enum type.  Two enum constants e1 and  e2 are of the\n same enum type if and only if\n   e1.getDeclaringClass() == e2.getDeclaringClass().\n (The value returned by this method may differ from the one returned\n by the {@link Object#getClass} method for enum constants with\n constant-specific class bodies.)\n\n @return the Class object corresponding to this enum constant's\n     enum type"
  {:arglists (quote (["java.time.Month"]))}
  (^java.lang.Class [^js/JSJoda.Month this] (.declaringClass this)))

(defn from
  "Obtains an instance of {@code Month} from a temporal object.\n <p>\n This obtains a month based on the specified temporal.\n A {@code TemporalAccessor} represents an arbitrary set of date and time information,\n which this factory converts to an instance of {@code Month}.\n <p>\n The conversion extracts the {@link ChronoField#MONTH_OF_YEAR MONTH_OF_YEAR} field.\n The extraction is only permitted if the temporal object has an ISO\n chronology, or can be converted to a {@code LocalDate}.\n <p>\n This method matches the signature of the functional interface {@link TemporalQuery}\n allowing it to be used as a query via method reference, {@code Month::from}.\n\n @param temporal  the temporal object to convert, not null\n @return the month-of-year, not null\n @throws DateTimeException if unable to convert to a {@code Month}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^js/JSJoda.Month [^js/JSJoda.TemporalAccessor temporal]
   (js-invoke java.time.Month "from" temporal)))

(defn is-supported
  "Checks if the specified field is supported.\n <p>\n This checks if this month-of-year can be queried for the specified field.\n If false, then calling the {@link #range(TemporalField) range} and\n {@link #get(TemporalField) get} methods will throw an exception.\n <p>\n If the field is {@link ChronoField#MONTH_OF_YEAR MONTH_OF_YEAR} then\n this method returns true.\n All other {@code ChronoField} instances will return false.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.isSupportedBy(TemporalAccessor)}\n passing {@code this} as the argument.\n Whether the field is supported is determined by the field.\n\n @param field  the field to check, null returns false\n @return true if the field is supported on this month-of-year, false if not"
  {:arglists (quote (["java.time.Month" "java.time.temporal.TemporalField"]))}
  (^boolean [^js/JSJoda.Month this ^js/JSJoda.TemporalField field]
   (.isSupported this field)))

(defn hash-code
  "Returns a hash code for this enum constant.\n\n @return a hash code for this enum constant."
  {:arglists (quote (["java.time.Month"]))}
  (^int [^js/JSJoda.Month this] (.hashCode this)))

(defn adjust-into
  "Adjusts the specified temporal object to have this month-of-year.\n <p>\n This returns a temporal object of the same observable type as the input\n with the month-of-year changed to be the same as this.\n <p>\n The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}\n passing {@link ChronoField#MONTH_OF_YEAR} as the field.\n If the specified temporal object does not use the ISO calendar system then\n a {@code DateTimeException} is thrown.\n <p>\n In most cases, it is clearer to reverse the calling pattern by using\n {@link Temporal#with(TemporalAdjuster)}:\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   temporal = thisMonth.adjustInto(temporal);\n   temporal = temporal.with(thisMonth);\n </pre>\n <p>\n For example, given a date in May, the following are output:\n <pre>\n   dateInMay.with(JANUARY);    // four months earlier\n   dateInMay.with(APRIL);      // one months earlier\n   dateInMay.with(MAY);        // same date\n   dateInMay.with(JUNE);       // one month later\n   dateInMay.with(DECEMBER);   // seven months later\n </pre>\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param temporal  the target object to be adjusted, not null\n @return the adjusted object, not null\n @throws DateTimeException if unable to make the adjustment\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Month" "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Temporal [^js/JSJoda.Month this ^js/JSJoda.Temporal temporal]
   (.adjustInto this temporal)))

(defn compare-to
  "Compares this enum with the specified object for order.  Returns a\n negative integer, zero, or a positive integer as this object is less\n than, equal to, or greater than the specified object.\n\n Enum constants are only comparable to other enum constants of the\n same enum type.  The natural order implemented by this\n method is the order in which the constants are declared."
  {:arglists (quote (["java.time.Month" "java.lang.Enum"]))}
  (^int [^js/JSJoda.Month this ^java.lang.Enum o] (.compareTo this o)))

(defn get
  "Gets the value of the specified field from this month-of-year as an {@code int}.\n <p>\n This queries this month for the value of the specified field.\n The returned value will always be within the valid range of values for the field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is {@link ChronoField#MONTH_OF_YEAR MONTH_OF_YEAR} then the\n value of the month-of-year, from 1 to 12, will be returned.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field, within the valid range of values\n @throws DateTimeException if a value for the field cannot be obtained or\n         the value is outside the range of valid values for the field\n @throws UnsupportedTemporalTypeException if the field is not supported or\n         the range of values exceeds an {@code int}\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Month" "java.time.temporal.TemporalField"]))}
  (^int [^js/JSJoda.Month this ^js/JSJoda.TemporalField field]
   (.get this field)))

(defn equals
  "Returns true if the specified object is equal to this\n enum constant.\n\n @param other the object to be compared for equality with this object.\n @return  true if the specified object is equal to this\n          enum constant."
  {:arglists (quote (["java.time.Month" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.Month this ^java.lang.Object other]
   (.equals this other)))
