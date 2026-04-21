(ns cljc.java-time.month-day
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time MonthDay]))

(defn at-year
  "Combines this month-day with a year to create a {@code LocalDate}.

 This returns a {@code LocalDate} formed from this month-day and the specified year.

 A month-day of February 29th will be adjusted to February 28th in the resulting
 date if the year is not a leap year.

 This instance is immutable and unaffected by this method call.

 @param year  the year to use, from MIN_YEAR to MAX_YEAR
 @return the local date formed from this month-day and the specified year, not null
 @throws DateTimeException if the year is outside the valid range of years"
  {:arglists (quote (["java.time.MonthDay" "int"]))}
  (^java.time.LocalDate [^java.time.MonthDay this ^java.lang.Integer year]
   (.atYear this year)))

(defn range
  "Gets the range of valid values for the specified field.

 The range object expresses the minimum and maximum valid values for a field.
 This month-day is used to enhance the accuracy of the returned range.
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
  {:arglists (quote (["java.time.MonthDay"
                      "java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ValueRange
   [^java.time.MonthDay this ^java.time.temporal.TemporalField field]
   (.range this field)))

(defn of
  {:arglists (quote (["int" "int"] ["java.time.Month" "int"]))}
  (^java.time.MonthDay [arg0 arg1]
   (cond (and (instance? java.lang.Number arg0)
              (instance? java.lang.Number arg1))
           (let [month (int arg0)
                 day-of-month (int arg1)]
             (java.time.MonthDay/of month day-of-month))
         (and (instance? java.time.Month arg0)
              (instance? java.lang.Number arg1))
           (let [^java.time.Month month arg0
                 day-of-month (int arg1)]
             (java.time.MonthDay/of month day-of-month))
         :else (throw (java.lang.IllegalArgumentException.
                        "no corresponding java.time method with these args")))))

(defn with-month
  "Returns a copy of this {@code MonthDay} with the month-of-year altered.

 This returns a month-day with the specified month.
 If the day-of-month is invalid for the specified month, the day will
 be adjusted to the last valid day-of-month.

 This instance is immutable and unaffected by this method call.

 @param month  the month-of-year to set in the returned month-day, from 1 (January) to 12 (December)
 @return a {@code MonthDay} based on this month-day with the requested month, not null
 @throws DateTimeException if the month-of-year value is invalid"
  {:arglists (quote (["java.time.MonthDay" "int"]))}
  (^java.time.MonthDay [^java.time.MonthDay this ^java.lang.Integer month]
   (.withMonth this month)))

(defn query
  "Queries this month-day using the specified query.

 This queries this month-day using the specified query strategy object.
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
  {:arglists (quote (["java.time.MonthDay"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object
   [^java.time.MonthDay this ^java.time.temporal.TemporalQuery query]
   (.query this query)))

(defn to-string
  "Outputs this month-day as a {@code String}, such as {@code --12-03}.

 The output will be in the format {@code --MM-dd}:

 @return a string representation of this month-day, not null"
  {:arglists (quote (["java.time.MonthDay"]))}
  (^java.lang.String [^java.time.MonthDay this] (.toString this)))

(defn is-before
  "Checks if this month-day is before the specified month-day.

 @param other  the other month-day to compare to, not null
 @return true if this point is before the specified month-day"
  {:arglists (quote (["java.time.MonthDay" "java.time.MonthDay"]))}
  (^java.lang.Boolean [^java.time.MonthDay this ^java.time.MonthDay other]
   (.isBefore this other)))

(defn get-long
  "Gets the value of the specified field from this month-day as a {@code long}.

 This queries this month-day for the value of the specified field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@link #isSupported(TemporalField) supported fields} will return valid
 values based on this month-day.
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
  {:arglists (quote (["java.time.MonthDay"
                      "java.time.temporal.TemporalField"]))}
  (^long [^java.time.MonthDay this ^java.time.temporal.TemporalField field]
   (.getLong this field)))

(defn with-day-of-month
  "Returns a copy of this {@code MonthDay} with the day-of-month altered.

 This returns a month-day with the specified day-of-month.
 If the day-of-month is invalid for the month, an exception is thrown.

 This instance is immutable and unaffected by this method call.

 @param dayOfMonth  the day-of-month to set in the return month-day, from 1 to 31
 @return a {@code MonthDay} based on this month-day with the requested day, not null
 @throws DateTimeException if the day-of-month value is invalid,
  or if the day-of-month is invalid for the month"
  {:arglists (quote (["java.time.MonthDay" "int"]))}
  (^java.time.MonthDay
   [^java.time.MonthDay this ^java.lang.Integer day-of-month]
   (.withDayOfMonth this day-of-month)))

(defn get-day-of-month
  "Gets the day-of-month field.

 This method returns the primitive {@code int} value for the day-of-month.

 @return the day-of-month, from 1 to 31"
  {:arglists (quote (["java.time.MonthDay"]))}
  (^java.lang.Integer [^java.time.MonthDay this] (.getDayOfMonth this)))

(defn from
  "Obtains an instance of {@code MonthDay} from a temporal object.

 This obtains a month-day based on the specified temporal.
 A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 which this factory converts to an instance of {@code MonthDay}.

 The conversion extracts the {@link ChronoField#MONTH_OF_YEAR MONTH_OF_YEAR} and
 {@link ChronoField#DAY_OF_MONTH DAY_OF_MONTH} fields.
 The extraction is only permitted if the temporal object has an ISO
 chronology, or can be converted to a {@code LocalDate}.

 This method matches the signature of the functional interface {@link TemporalQuery}
 allowing it to be used as a query via method reference, {@code MonthDay::from}.

 @param temporal  the temporal object to convert, not null
 @return the month-day, not null
 @throws DateTimeException if unable to convert to a {@code MonthDay}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^java.time.MonthDay [^java.time.temporal.TemporalAccessor temporal]
   (java.time.MonthDay/from temporal)))

(defn is-after
  "Checks if this month-day is after the specified month-day.

 @param other  the other month-day to compare to, not null
 @return true if this is after the specified month-day"
  {:arglists (quote (["java.time.MonthDay" "java.time.MonthDay"]))}
  (^java.lang.Boolean [^java.time.MonthDay this ^java.time.MonthDay other]
   (.isAfter this other)))

(defn is-supported
  "Checks if the specified field is supported.

 This checks if this month-day can be queried for the specified field.
 If false, then calling the {@link #range(TemporalField) range} and
 {@link #get(TemporalField) get} methods will throw an exception.

 If the field is a {@link ChronoField} then the query is implemented here.
 The supported fields are:
 <ul>
 <li>{@code MONTH_OF_YEAR}
 <li>{@code YEAR}
 </ul>
 All other {@code ChronoField} instances will return false.

 If the field is not a {@code ChronoField}, then the result of this method
 is obtained by invoking {@code TemporalField.isSupportedBy(TemporalAccessor)}
 passing {@code this} as the argument.
 Whether the field is supported is determined by the field.

 @param field  the field to check, null returns false
 @return true if the field is supported on this month-day, false if not"
  {:arglists (quote (["java.time.MonthDay"
                      "java.time.temporal.TemporalField"]))}
  (^java.lang.Boolean
   [^java.time.MonthDay this ^java.time.temporal.TemporalField field]
   (.isSupported this field)))

(defn parse
  {:arglists (quote (["java.lang.CharSequence"]
                     ["java.lang.CharSequence"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.time.MonthDay [^java.lang.CharSequence text]
   (java.time.MonthDay/parse text))
  (^java.time.MonthDay
   [^java.lang.CharSequence text ^java.time.format.DateTimeFormatter formatter]
   (java.time.MonthDay/parse text formatter)))

(defn is-valid-year
  "Checks if the year is valid for this month-day.

 This method checks whether this month and day and the input year form
 a valid date. This can only return false for February 29th.

 @param year  the year to validate
 @return true if the year is valid for this month-day
 @see Year#isValidMonthDay(MonthDay)"
  {:arglists (quote (["java.time.MonthDay" "int"]))}
  (^java.lang.Boolean [^java.time.MonthDay this ^java.lang.Integer year]
   (.isValidYear this year)))

(defn hash-code
  "A hash code for this month-day.

 @return a suitable hash code"
  {:arglists (quote (["java.time.MonthDay"]))}
  (^java.lang.Integer [^java.time.MonthDay this] (.hashCode this)))

(defn adjust-into
  "Adjusts the specified temporal object to have this month-day.

 This returns a temporal object of the same observable type as the input
 with the month and day-of-month changed to be the same as this.

 The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}
 twice, passing {@link ChronoField#MONTH_OF_YEAR} and
 {@link ChronoField#DAY_OF_MONTH} as the fields.
 If the specified temporal object does not use the ISO calendar system then
 a {@code DateTimeException} is thrown.

 In most cases, it is clearer to reverse the calling pattern by using
 {@link Temporal#with(TemporalAdjuster)}:
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   temporal = thisMonthDay.adjustInto(temporal);
   temporal = temporal.with(thisMonthDay);
 </pre>

 This instance is immutable and unaffected by this method call.

 @param temporal  the target object to be adjusted, not null
 @return the adjusted object, not null
 @throws DateTimeException if unable to make the adjustment
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.MonthDay" "java.time.temporal.Temporal"]))}
  (^java.time.temporal.Temporal
   [^java.time.MonthDay this ^java.time.temporal.Temporal temporal]
   (.adjustInto this temporal)))

(defn with
  "Returns a copy of this {@code MonthDay} with the month-of-year altered.

 This returns a month-day with the specified month.
 If the day-of-month is invalid for the specified month, the day will
 be adjusted to the last valid day-of-month.

 This instance is immutable and unaffected by this method call.

 @param month  the month-of-year to set in the returned month-day, not null
 @return a {@code MonthDay} based on this month-day with the requested month, not null"
  {:arglists (quote (["java.time.MonthDay" "java.time.Month"]))}
  (^java.time.MonthDay [^java.time.MonthDay this ^java.time.Month month]
   (.with this month)))

(defn now
  {:arglists (quote ([] ["java.time.Clock"] ["java.time.ZoneId"]))}
  (^java.time.MonthDay [] (java.time.MonthDay/now))
  (^java.time.MonthDay [arg0]
   (cond (instance? java.time.Clock arg0) (let [^java.time.Clock clock arg0]
                                            (java.time.MonthDay/now clock))
         (instance? java.time.ZoneId arg0) (let [^java.time.ZoneId zone arg0]
                                             (java.time.MonthDay/now zone))
         :else (throw (java.lang.IllegalArgumentException.
                        "no corresponding java.time method with these args")))))

(defn get-month-value
  "Gets the month-of-year field from 1 to 12.

 This method returns the month as an {@code int} from 1 to 12.
 Application code is frequently clearer if the enum {@link Month}
 is used by calling {@link #getMonth()}.

 @return the month-of-year, from 1 to 12
 @see #getMonth()"
  {:arglists (quote (["java.time.MonthDay"]))}
  (^java.lang.Integer [^java.time.MonthDay this] (.getMonthValue this)))

(defn compare-to
  "Compares this month-day to another month-day.

 The comparison is based first on value of the month, then on the value of the day.
 It is \"consistent with equals\", as defined by {@link Comparable}.

 @param other  the other month-day to compare to, not null
 @return the comparator value, negative if less, positive if greater"
  {:arglists (quote (["java.time.MonthDay" "java.time.MonthDay"]))}
  (^java.lang.Integer [^java.time.MonthDay this ^java.time.MonthDay other]
   (.compareTo this other)))

(defn get-month
  "Gets the month-of-year field using the {@code Month} enum.

 This method returns the enum {@link Month} for the month.
 This avoids confusion as to what {@code int} values mean.
 If you need access to the primitive {@code int} value then the enum
 provides the {@link Month#getValue() int value}.

 @return the month-of-year, not null
 @see #getMonthValue()"
  {:arglists (quote (["java.time.MonthDay"]))}
  (^java.time.Month [^java.time.MonthDay this] (.getMonth this)))

(defn get
  "Gets the value of the specified field from this month-day as an {@code int}.

 This queries this month-day for the value of the specified field.
 The returned value will always be within the valid range of values for the field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@link #isSupported(TemporalField) supported fields} will return valid
 values based on this month-day.
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
  {:arglists (quote (["java.time.MonthDay"
                      "java.time.temporal.TemporalField"]))}
  (^java.lang.Integer
   [^java.time.MonthDay this ^java.time.temporal.TemporalField field]
   (.get this field)))

(defn equals
  "Checks if this month-day is equal to another month-day.

 The comparison is based on the time-line position of the month-day within a year.

 @param obj  the object to check, null returns false
 @return true if this is equal to the other month-day"
  {:arglists (quote (["java.time.MonthDay" "java.lang.Object"]))}
  (^java.lang.Boolean [^java.time.MonthDay this ^java.lang.Object obj]
   (.equals this obj)))

(defn format
  "Formats this month-day using the specified formatter.

 This month-day will be passed to the formatter to produce a string.

 @param formatter  the formatter to use, not null
 @return the formatted month-day string, not null
 @throws DateTimeException if an error occurs during printing"
  {:arglists (quote (["java.time.MonthDay"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.lang.String
   [^java.time.MonthDay this ^java.time.format.DateTimeFormatter formatter]
   (.format this formatter)))
