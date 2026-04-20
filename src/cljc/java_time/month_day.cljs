(ns cljc.java-time.month-day
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [MonthDay]]))

(defn at-year
  "Combines this month-day with a year to create a {@code LocalDate}.\n <p>\n This returns a {@code LocalDate} formed from this month-day and the specified year.\n <p>\n A month-day of February 29th will be adjusted to February 28th in the resulting\n date if the year is not a leap year.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param year  the year to use, from MIN_YEAR to MAX_YEAR\n @return the local date formed from this month-day and the specified year, not null\n @throws DateTimeException if the year is outside the valid range of years"
  {:arglists (quote (["java.time.MonthDay" "int"]))}
  (^js/JSJoda.LocalDate [^js/JSJoda.MonthDay this ^int year]
   (.atYear this year)))

(defn range
  "Gets the range of valid values for the specified field.\n <p>\n The range object expresses the minimum and maximum valid values for a field.\n This month-day is used to enhance the accuracy of the returned range.\n If it is not possible to return the range, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return\n appropriate range instances.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)}\n passing {@code this} as the argument.\n Whether the range can be obtained is determined by the field.\n\n @param field  the field to query the range for, not null\n @return the range of valid values for the field, not null\n @throws DateTimeException if the range for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported"
  {:arglists (quote (["java.time.MonthDay"
                      "java.time.temporal.TemporalField"]))}
  (^js/JSJoda.ValueRange
   [^js/JSJoda.MonthDay this ^js/JSJoda.TemporalField field]
   (.range this field)))

(defn of
  {:arglists (quote (["int" "int"] ["java.time.Month" "int"]))}
  (^js/JSJoda.MonthDay [arg0 arg1]
   (js-invoke java.time.MonthDay "of" arg0 arg1)))

(defn with-month
  "Returns a copy of this {@code MonthDay} with the month-of-year altered.\n <p>\n This returns a month-day with the specified month.\n If the day-of-month is invalid for the specified month, the day will\n be adjusted to the last valid day-of-month.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param month  the month-of-year to set in the returned month-day, from 1 (January) to 12 (December)\n @return a {@code MonthDay} based on this month-day with the requested month, not null\n @throws DateTimeException if the month-of-year value is invalid"
  {:arglists (quote (["java.time.MonthDay" "int"]))}
  (^js/JSJoda.MonthDay [^js/JSJoda.MonthDay this ^int month]
   (.withMonth this month)))

(defn query
  "Queries this month-day using the specified query.\n <p>\n This queries this month-day using the specified query strategy object.\n The {@code TemporalQuery} object defines the logic to be used to\n obtain the result. Read the documentation of the query to understand\n what the result of this method will be.\n <p>\n The result of this method is obtained by invoking the\n {@link TemporalQuery#queryFrom(TemporalAccessor)} method on the\n specified query passing {@code this} as the argument.\n\n @param <R> the type of the result\n @param query  the query to invoke, not null\n @return the query result, null may be returned (defined by the query)\n @throws DateTimeException if unable to query (defined by the query)\n @throws ArithmeticException if numeric overflow occurs (defined by the query)"
  {:arglists (quote (["java.time.MonthDay"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object [^js/JSJoda.MonthDay this ^js/JSJoda.TemporalQuery query]
   (.query this query)))

(defn to-string
  "Outputs this month-day as a {@code String}, such as {@code --12-03}.\n <p>\n The output will be in the format {@code --MM-dd}:\n\n @return a string representation of this month-day, not null"
  {:arglists (quote (["java.time.MonthDay"]))}
  (^java.lang.String [^js/JSJoda.MonthDay this] (.toString this)))

(defn is-before
  "Checks if this month-day is before the specified month-day.\n\n @param other  the other month-day to compare to, not null\n @return true if this point is before the specified month-day"
  {:arglists (quote (["java.time.MonthDay" "java.time.MonthDay"]))}
  (^boolean [^js/JSJoda.MonthDay this ^js/JSJoda.MonthDay other]
   (.isBefore this other)))

(defn get-long
  "Gets the value of the specified field from this month-day as a {@code long}.\n <p>\n This queries this month-day for the value of the specified field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return valid\n values based on this month-day.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.MonthDay"
                      "java.time.temporal.TemporalField"]))}
  (^long [^js/JSJoda.MonthDay this ^js/JSJoda.TemporalField field]
   (.getLong this field)))

(defn with-day-of-month
  "Returns a copy of this {@code MonthDay} with the day-of-month altered.\n <p>\n This returns a month-day with the specified day-of-month.\n If the day-of-month is invalid for the month, an exception is thrown.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param dayOfMonth  the day-of-month to set in the return month-day, from 1 to 31\n @return a {@code MonthDay} based on this month-day with the requested day, not null\n @throws DateTimeException if the day-of-month value is invalid,\n  or if the day-of-month is invalid for the month"
  {:arglists (quote (["java.time.MonthDay" "int"]))}
  (^js/JSJoda.MonthDay [^js/JSJoda.MonthDay this ^int day-of-month]
   (.withDayOfMonth this day-of-month)))

(defn get-day-of-month
  "Gets the day-of-month field.\n <p>\n This method returns the primitive {@code int} value for the day-of-month.\n\n @return the day-of-month, from 1 to 31"
  {:arglists (quote (["java.time.MonthDay"]))}
  (^int [^js/JSJoda.MonthDay this] (.dayOfMonth this)))

(defn from
  "Obtains an instance of {@code MonthDay} from a temporal object.\n <p>\n This obtains a month-day based on the specified temporal.\n A {@code TemporalAccessor} represents an arbitrary set of date and time information,\n which this factory converts to an instance of {@code MonthDay}.\n <p>\n The conversion extracts the {@link ChronoField#MONTH_OF_YEAR MONTH_OF_YEAR} and\n {@link ChronoField#DAY_OF_MONTH DAY_OF_MONTH} fields.\n The extraction is only permitted if the temporal object has an ISO\n chronology, or can be converted to a {@code LocalDate}.\n <p>\n This method matches the signature of the functional interface {@link TemporalQuery}\n allowing it to be used as a query via method reference, {@code MonthDay::from}.\n\n @param temporal  the temporal object to convert, not null\n @return the month-day, not null\n @throws DateTimeException if unable to convert to a {@code MonthDay}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^js/JSJoda.MonthDay [^js/JSJoda.TemporalAccessor temporal]
   (js-invoke java.time.MonthDay "from" temporal)))

(defn is-after
  "Checks if this month-day is after the specified month-day.\n\n @param other  the other month-day to compare to, not null\n @return true if this is after the specified month-day"
  {:arglists (quote (["java.time.MonthDay" "java.time.MonthDay"]))}
  (^boolean [^js/JSJoda.MonthDay this ^js/JSJoda.MonthDay other]
   (.isAfter this other)))

(defn is-supported
  "Checks if the specified field is supported.\n <p>\n This checks if this month-day can be queried for the specified field.\n If false, then calling the {@link #range(TemporalField) range} and\n {@link #get(TemporalField) get} methods will throw an exception.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The supported fields are:\n <ul>\n <li>{@code MONTH_OF_YEAR}\n <li>{@code YEAR}\n </ul>\n All other {@code ChronoField} instances will return false.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.isSupportedBy(TemporalAccessor)}\n passing {@code this} as the argument.\n Whether the field is supported is determined by the field.\n\n @param field  the field to check, null returns false\n @return true if the field is supported on this month-day, false if not"
  {:arglists (quote (["java.time.MonthDay"
                      "java.time.temporal.TemporalField"]))}
  (^boolean [^js/JSJoda.MonthDay this ^js/JSJoda.TemporalField field]
   (.isSupported this field)))

(defn parse
  {:arglists (quote (["java.lang.CharSequence"]
                     ["java.lang.CharSequence"
                      "java.time.format.DateTimeFormatter"]))}
  (^js/JSJoda.MonthDay [^java.lang.CharSequence text]
   (js-invoke java.time.MonthDay "parse" text))
  (^js/JSJoda.MonthDay
   [^java.lang.CharSequence text ^js/JSJoda.DateTimeFormatter formatter]
   (js-invoke java.time.MonthDay "parse" text formatter)))

(defn is-valid-year
  "Checks if the year is valid for this month-day.\n <p>\n This method checks whether this month and day and the input year form\n a valid date. This can only return false for February 29th.\n\n @param year  the year to validate\n @return true if the year is valid for this month-day\n @see Year#isValidMonthDay(MonthDay)"
  {:arglists (quote (["java.time.MonthDay" "int"]))}
  (^boolean [^js/JSJoda.MonthDay this ^int year] (.isValidYear this year)))

(defn hash-code
  "A hash code for this month-day.\n\n @return a suitable hash code"
  {:arglists (quote (["java.time.MonthDay"]))}
  (^int [^js/JSJoda.MonthDay this] (.hashCode this)))

(defn adjust-into
  "Adjusts the specified temporal object to have this month-day.\n <p>\n This returns a temporal object of the same observable type as the input\n with the month and day-of-month changed to be the same as this.\n <p>\n The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}\n twice, passing {@link ChronoField#MONTH_OF_YEAR} and\n {@link ChronoField#DAY_OF_MONTH} as the fields.\n If the specified temporal object does not use the ISO calendar system then\n a {@code DateTimeException} is thrown.\n <p>\n In most cases, it is clearer to reverse the calling pattern by using\n {@link Temporal#with(TemporalAdjuster)}:\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   temporal = thisMonthDay.adjustInto(temporal);\n   temporal = temporal.with(thisMonthDay);\n </pre>\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param temporal  the target object to be adjusted, not null\n @return the adjusted object, not null\n @throws DateTimeException if unable to make the adjustment\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.MonthDay" "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Temporal [^js/JSJoda.MonthDay this ^js/JSJoda.Temporal temporal]
   (.adjustInto this temporal)))

(defn with
  "Returns a copy of this {@code MonthDay} with the month-of-year altered.\n <p>\n This returns a month-day with the specified month.\n If the day-of-month is invalid for the specified month, the day will\n be adjusted to the last valid day-of-month.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param month  the month-of-year to set in the returned month-day, not null\n @return a {@code MonthDay} based on this month-day with the requested month, not null"
  {:arglists (quote (["java.time.MonthDay" "java.time.Month"]))}
  (^js/JSJoda.MonthDay [^js/JSJoda.MonthDay this ^js/JSJoda.Month month]
   (.with this month)))

(defn now
  {:arglists (quote ([] ["java.time.Clock"] ["java.time.ZoneId"]))}
  (^js/JSJoda.MonthDay [] (js-invoke java.time.MonthDay "now"))
  (^js/JSJoda.MonthDay [arg0] (js-invoke java.time.MonthDay "now" arg0)))

(defn get-month-value
  "Gets the month-of-year field from 1 to 12.\n <p>\n This method returns the month as an {@code int} from 1 to 12.\n Application code is frequently clearer if the enum {@link Month}\n is used by calling {@link #getMonth()}.\n\n @return the month-of-year, from 1 to 12\n @see #getMonth()"
  {:arglists (quote (["java.time.MonthDay"]))}
  (^int [^js/JSJoda.MonthDay this] (.monthValue this)))

(defn compare-to
  "Compares this month-day to another month-day.\n <p>\n The comparison is based first on value of the month, then on the value of the day.\n It is \"consistent with equals\", as defined by {@link Comparable}.\n\n @param other  the other month-day to compare to, not null\n @return the comparator value, negative if less, positive if greater"
  {:arglists (quote (["java.time.MonthDay" "java.time.MonthDay"]))}
  (^int [^js/JSJoda.MonthDay this ^js/JSJoda.MonthDay other]
   (.compareTo this other)))

(defn get-month
  "Gets the month-of-year field using the {@code Month} enum.\n <p>\n This method returns the enum {@link Month} for the month.\n This avoids confusion as to what {@code int} values mean.\n If you need access to the primitive {@code int} value then the enum\n provides the {@link Month#getValue() int value}.\n\n @return the month-of-year, not null\n @see #getMonthValue()"
  {:arglists (quote (["java.time.MonthDay"]))}
  (^js/JSJoda.Month [^js/JSJoda.MonthDay this] (.month this)))

(defn get
  "Gets the value of the specified field from this month-day as an {@code int}.\n <p>\n This queries this month-day for the value of the specified field.\n The returned value will always be within the valid range of values for the field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return valid\n values based on this month-day.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained or\n         the value is outside the range of valid values for the field\n @throws UnsupportedTemporalTypeException if the field is not supported or\n         the range of values exceeds an {@code int}\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.MonthDay"
                      "java.time.temporal.TemporalField"]))}
  (^int [^js/JSJoda.MonthDay this ^js/JSJoda.TemporalField field]
   (.get this field)))

(defn equals
  "Checks if this month-day is equal to another month-day.\n <p>\n The comparison is based on the time-line position of the month-day within a year.\n\n @param obj  the object to check, null returns false\n @return true if this is equal to the other month-day"
  {:arglists (quote (["java.time.MonthDay" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.MonthDay this ^java.lang.Object obj]
   (.equals this obj)))

(defn format
  "Formats this month-day using the specified formatter.\n <p>\n This month-day will be passed to the formatter to produce a string.\n\n @param formatter  the formatter to use, not null\n @return the formatted month-day string, not null\n @throws DateTimeException if an error occurs during printing"
  {:arglists (quote (["java.time.MonthDay"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.lang.String
   [^js/JSJoda.MonthDay this ^js/JSJoda.DateTimeFormatter formatter]
   (.format this formatter)))
