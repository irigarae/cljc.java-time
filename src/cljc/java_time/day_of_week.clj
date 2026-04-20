(ns cljc.java-time.day-of-week
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time DayOfWeek]))

(def saturday java.time.DayOfWeek/SATURDAY)

(def thursday java.time.DayOfWeek/THURSDAY)

(def friday java.time.DayOfWeek/FRIDAY)

(def wednesday java.time.DayOfWeek/WEDNESDAY)

(def sunday java.time.DayOfWeek/SUNDAY)

(def monday java.time.DayOfWeek/MONDAY)

(def tuesday java.time.DayOfWeek/TUESDAY)

(defn range
  "Gets the range of valid values for the specified field.\n <p>\n The range object expresses the minimum and maximum valid values for a field.\n This day-of-week is used to enhance the accuracy of the returned range.\n If it is not possible to return the range, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is {@link ChronoField#DAY_OF_WEEK DAY_OF_WEEK} then the\n range of the day-of-week, from 1 to 7, will be returned.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)}\n passing {@code this} as the argument.\n Whether the range can be obtained is determined by the field.\n\n @param field  the field to query the range for, not null\n @return the range of valid values for the field, not null\n @throws DateTimeException if the range for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported"
  {:arglists (quote (["java.time.DayOfWeek"
                      "java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ValueRange
   [^java.time.DayOfWeek this ^java.time.temporal.TemporalField field]
   (.range this field)))

(defn values
  {:arglists (quote ([]))}
  (^"java.lang.Class" [] (java.time.DayOfWeek/values)))

(defn value-of
  {:arglists (quote (["java.lang.String"]
                     ["java.lang.Class" "java.lang.String"]))}
  (^java.time.DayOfWeek [^java.lang.String name]
   (java.time.DayOfWeek/valueOf name))
  (^java.lang.Enum [^java.lang.Class enum-type ^java.lang.String name]
   (java.time.DayOfWeek/valueOf enum-type name)))

(defn of
  "Obtains an instance of {@code DayOfWeek} from an {@code int} value.\n <p>\n {@code DayOfWeek} is an enum representing the 7 days of the week.\n This factory allows the enum to be obtained from the {@code int} value.\n The {@code int} value follows the ISO-8601 standard, from 1 (Monday) to 7 (Sunday).\n\n @param dayOfWeek  the day-of-week to represent, from 1 (Monday) to 7 (Sunday)\n @return the day-of-week singleton, not null\n @throws DateTimeException if the day-of-week is invalid"
  {:arglists (quote (["int"]))}
  (^java.time.DayOfWeek [^java.lang.Integer day-of-week]
   (java.time.DayOfWeek/of day-of-week)))

(defn ordinal
  "Returns the ordinal of this enumeration constant (its position\n in its enum declaration, where the initial constant is assigned\n an ordinal of zero).\n\n Most programmers will have no use for this method.  It is\n designed for use by sophisticated enum-based data structures, such\n as {@link java.util.EnumSet} and {@link java.util.EnumMap}.\n\n @return the ordinal of this enumeration constant"
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^java.lang.Integer [^java.time.DayOfWeek this] (.ordinal this)))

(defn plus
  "Returns the day-of-week that is the specified number of days after this one.\n <p>\n The calculation rolls around the end of the week from Sunday to Monday.\n The specified period may be negative.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param days  the days to add, positive or negative\n @return the resulting day-of-week, not null"
  {:arglists (quote (["java.time.DayOfWeek" "long"]))}
  (^java.time.DayOfWeek [^java.time.DayOfWeek this ^long days]
   (.plus this days)))

(defn query
  "Queries this day-of-week using the specified query.\n <p>\n This queries this day-of-week using the specified query strategy object.\n The {@code TemporalQuery} object defines the logic to be used to\n obtain the result. Read the documentation of the query to understand\n what the result of this method will be.\n <p>\n The result of this method is obtained by invoking the\n {@link TemporalQuery#queryFrom(TemporalAccessor)} method on the\n specified query passing {@code this} as the argument.\n\n @param <R> the type of the result\n @param query  the query to invoke, not null\n @return the query result, null may be returned (defined by the query)\n @throws DateTimeException if unable to query (defined by the query)\n @throws ArithmeticException if numeric overflow occurs (defined by the query)"
  {:arglists (quote (["java.time.DayOfWeek"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object
   [^java.time.DayOfWeek this ^java.time.temporal.TemporalQuery query]
   (.query this query)))

(defn to-string
  "Returns the name of this enum constant, as contained in the\n declaration.  This method may be overridden, though it typically\n isn't necessary or desirable.  An enum type should override this\n method when a more \"programmer-friendly\" string form exists.\n\n @return the name of this enum constant"
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^java.lang.String [^java.time.DayOfWeek this] (.toString this)))

(defn minus
  "Returns the day-of-week that is the specified number of days before this one.\n <p>\n The calculation rolls around the start of the year from Monday to Sunday.\n The specified period may be negative.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param days  the days to subtract, positive or negative\n @return the resulting day-of-week, not null"
  {:arglists (quote (["java.time.DayOfWeek" "long"]))}
  (^java.time.DayOfWeek [^java.time.DayOfWeek this ^long days]
   (.minus this days)))

(defn get-display-name
  "Gets the textual representation, such as 'Mon' or 'Friday'.\n <p>\n This returns the textual name used to identify the day-of-week,\n suitable for presentation to the user.\n The parameters control the style of the returned text and the locale.\n <p>\n If no textual mapping is found then the {@link #getValue() numeric value} is returned.\n\n @param style  the length of the text required, not null\n @param locale  the locale to use, not null\n @return the text value of the day-of-week, not null"
  {:arglists (quote (["java.time.DayOfWeek" "java.time.format.TextStyle"
                      "java.util.Locale"]))}
  (^java.lang.String
   [^java.time.DayOfWeek this ^java.time.format.TextStyle style
    ^java.util.Locale locale]
   (.getDisplayName this style locale)))

(defn get-value
  "Gets the day-of-week {@code int} value.\n <p>\n The values are numbered following the ISO-8601 standard, from 1 (Monday) to 7 (Sunday).\n See {@link java.time.temporal.WeekFields#dayOfWeek()} for localized week-numbering.\n\n @return the day-of-week, from 1 (Monday) to 7 (Sunday)"
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^java.lang.Integer [^java.time.DayOfWeek this] (.getValue this)))

(defn name
  "Returns the name of this enum constant, exactly as declared in its\n enum declaration.\n\n <b>Most programmers should use the {@link #toString} method in\n preference to this one, as the toString method may return\n a more user-friendly name.</b>  This method is designed primarily for\n use in specialized situations where correctness depends on getting the\n exact name, which will not vary from release to release.\n\n @return the name of this enum constant"
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^java.lang.String [^java.time.DayOfWeek this] (.name this)))

(defn get-long
  "Gets the value of the specified field from this day-of-week as a {@code long}.\n <p>\n This queries this day-of-week for the value of the specified field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is {@link ChronoField#DAY_OF_WEEK DAY_OF_WEEK} then the\n value of the day-of-week, from 1 to 7, will be returned.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.DayOfWeek"
                      "java.time.temporal.TemporalField"]))}
  (^long [^java.time.DayOfWeek this ^java.time.temporal.TemporalField field]
   (.getLong this field)))

(defn get-declaring-class
  "Returns the Class object corresponding to this enum constant's\n enum type.  Two enum constants e1 and  e2 are of the\n same enum type if and only if\n   e1.getDeclaringClass() == e2.getDeclaringClass().\n (The value returned by this method may differ from the one returned\n by the {@link Object#getClass} method for enum constants with\n constant-specific class bodies.)\n\n @return the Class object corresponding to this enum constant's\n     enum type"
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^java.lang.Class [^java.time.DayOfWeek this] (.getDeclaringClass this)))

(defn from
  "Obtains an instance of {@code DayOfWeek} from a temporal object.\n <p>\n This obtains a day-of-week based on the specified temporal.\n A {@code TemporalAccessor} represents an arbitrary set of date and time information,\n which this factory converts to an instance of {@code DayOfWeek}.\n <p>\n The conversion extracts the {@link ChronoField#DAY_OF_WEEK DAY_OF_WEEK} field.\n <p>\n This method matches the signature of the functional interface {@link TemporalQuery}\n allowing it to be used as a query via method reference, {@code DayOfWeek::from}.\n\n @param temporal  the temporal object to convert, not null\n @return the day-of-week, not null\n @throws DateTimeException if unable to convert to a {@code DayOfWeek}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^java.time.DayOfWeek [^java.time.temporal.TemporalAccessor temporal]
   (java.time.DayOfWeek/from temporal)))

(defn is-supported
  "Checks if the specified field is supported.\n <p>\n This checks if this day-of-week can be queried for the specified field.\n If false, then calling the {@link #range(TemporalField) range} and\n {@link #get(TemporalField) get} methods will throw an exception.\n <p>\n If the field is {@link ChronoField#DAY_OF_WEEK DAY_OF_WEEK} then\n this method returns true.\n All other {@code ChronoField} instances will return false.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.isSupportedBy(TemporalAccessor)}\n passing {@code this} as the argument.\n Whether the field is supported is determined by the field.\n\n @param field  the field to check, null returns false\n @return true if the field is supported on this day-of-week, false if not"
  {:arglists (quote (["java.time.DayOfWeek"
                      "java.time.temporal.TemporalField"]))}
  (^java.lang.Boolean
   [^java.time.DayOfWeek this ^java.time.temporal.TemporalField field]
   (.isSupported this field)))

(defn hash-code
  "Returns a hash code for this enum constant.\n\n @return a hash code for this enum constant."
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^java.lang.Integer [^java.time.DayOfWeek this] (.hashCode this)))

(defn adjust-into
  "Adjusts the specified temporal object to have this day-of-week.\n <p>\n This returns a temporal object of the same observable type as the input\n with the day-of-week changed to be the same as this.\n <p>\n The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}\n passing {@link ChronoField#DAY_OF_WEEK} as the field.\n Note that this adjusts forwards or backwards within a Monday to Sunday week.\n See {@link java.time.temporal.WeekFields#dayOfWeek()} for localized week start days.\n See {@code TemporalAdjuster} for other adjusters with more control,\n such as {@code next(MONDAY)}.\n <p>\n In most cases, it is clearer to reverse the calling pattern by using\n {@link Temporal#with(TemporalAdjuster)}:\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   temporal = thisDayOfWeek.adjustInto(temporal);\n   temporal = temporal.with(thisDayOfWeek);\n </pre>\n <p>\n For example, given a date that is a Wednesday, the following are output:\n <pre>\n   dateOnWed.with(MONDAY);     // two days earlier\n   dateOnWed.with(TUESDAY);    // one day earlier\n   dateOnWed.with(WEDNESDAY);  // same date\n   dateOnWed.with(THURSDAY);   // one day later\n   dateOnWed.with(FRIDAY);     // two days later\n   dateOnWed.with(SATURDAY);   // three days later\n   dateOnWed.with(SUNDAY);     // four days later\n </pre>\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param temporal  the target object to be adjusted, not null\n @return the adjusted object, not null\n @throws DateTimeException if unable to make the adjustment\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.DayOfWeek" "java.time.temporal.Temporal"]))}
  (^java.time.temporal.Temporal
   [^java.time.DayOfWeek this ^java.time.temporal.Temporal temporal]
   (.adjustInto this temporal)))

(defn compare-to
  "Compares this enum with the specified object for order.  Returns a\n negative integer, zero, or a positive integer as this object is less\n than, equal to, or greater than the specified object.\n\n Enum constants are only comparable to other enum constants of the\n same enum type.  The natural order implemented by this\n method is the order in which the constants are declared."
  {:arglists (quote (["java.time.DayOfWeek" "java.lang.Enum"]))}
  (^java.lang.Integer [^java.time.DayOfWeek this ^java.lang.Enum o]
   (.compareTo this o)))

(defn get
  "Gets the value of the specified field from this day-of-week as an {@code int}.\n <p>\n This queries this day-of-week for the value of the specified field.\n The returned value will always be within the valid range of values for the field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is {@link ChronoField#DAY_OF_WEEK DAY_OF_WEEK} then the\n value of the day-of-week, from 1 to 7, will be returned.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field, within the valid range of values\n @throws DateTimeException if a value for the field cannot be obtained or\n         the value is outside the range of valid values for the field\n @throws UnsupportedTemporalTypeException if the field is not supported or\n         the range of values exceeds an {@code int}\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.DayOfWeek"
                      "java.time.temporal.TemporalField"]))}
  (^java.lang.Integer
   [^java.time.DayOfWeek this ^java.time.temporal.TemporalField field]
   (.get this field)))

(defn equals
  "Returns true if the specified object is equal to this\n enum constant.\n\n @param other the object to be compared for equality with this object.\n @return  true if the specified object is equal to this\n          enum constant."
  {:arglists (quote (["java.time.DayOfWeek" "java.lang.Object"]))}
  (^java.lang.Boolean [^java.time.DayOfWeek this ^java.lang.Object other]
   (.equals this other)))
