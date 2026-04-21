(ns cljc.java-time.year-month
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time YearMonth]))

(defn length-of-year
  "Returns the length of the year.

 This returns the length of the year in days, either 365 or 366.

 @return 366 if the year is leap, 365 otherwise"
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.lang.Integer [^java.time.YearMonth this] (.lengthOfYear this)))

(defn range
  "Gets the range of valid values for the specified field.

 The range object expresses the minimum and maximum valid values for a field.
 This year-month is used to enhance the accuracy of the returned range.
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
  {:arglists (quote (["java.time.YearMonth"
                      "java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ValueRange
   [^java.time.YearMonth this ^java.time.temporal.TemporalField field]
   (.range this field)))

(defn is-valid-day
  "Checks if the day-of-month is valid for this year-month.

 This method checks whether this year and month and the input day form
 a valid date.

 @param dayOfMonth  the day-of-month to validate, from 1 to 31, invalid value returns false
 @return true if the day is valid for this year-month"
  {:arglists (quote (["java.time.YearMonth" "int"]))}
  (^java.lang.Boolean
   [^java.time.YearMonth this ^java.lang.Integer day-of-month]
   (.isValidDay this day-of-month)))

(defn of
  {:arglists (quote (["int" "int"] ["int" "java.time.Month"]))}
  (^java.time.YearMonth [arg0 arg1]
   (cond (and (instance? java.lang.Number arg0)
              (instance? java.lang.Number arg1))
           (let [year (int arg0)
                 month (int arg1)]
             (java.time.YearMonth/of year month))
         (and (instance? java.lang.Number arg0)
              (instance? java.time.Month arg1))
           (let [year (int arg0)
                 month ^"java.time.Month" arg1]
             (java.time.YearMonth/of year month))
         :else (throw (java.lang.IllegalArgumentException.
                        "no corresponding java.time method with these args")))))

(defn with-month
  "Returns a copy of this {@code YearMonth} with the month-of-year altered.

 This instance is immutable and unaffected by this method call.

 @param month  the month-of-year to set in the returned year-month, from 1 (January) to 12 (December)
 @return a {@code YearMonth} based on this year-month with the requested month, not null
 @throws DateTimeException if the month-of-year value is invalid"
  {:arglists (quote (["java.time.YearMonth" "int"]))}
  (^java.time.YearMonth [^java.time.YearMonth this ^java.lang.Integer month]
   (.withMonth this month)))

(defn at-day
  "Combines this year-month with a day-of-month to create a {@code LocalDate}.

 This returns a {@code LocalDate} formed from this year-month and the specified day-of-month.

 The day-of-month value must be valid for the year-month.

 This method can be used as part of a chain to produce a date:
 <pre>
  LocalDate date = year.atMonth(month).atDay(day);
 </pre>

 @param dayOfMonth  the day-of-month to use, from 1 to 31
 @return the date formed from this year-month and the specified day, not null
 @throws DateTimeException if the day is invalid for the year-month
 @see #isValidDay(int)"
  {:arglists (quote (["java.time.YearMonth" "int"]))}
  (^java.time.LocalDate
   [^java.time.YearMonth this ^java.lang.Integer day-of-month]
   (.atDay this day-of-month)))

(defn get-year
  "Gets the year field.

 This method returns the primitive {@code int} value for the year.

 The year returned by this method is proleptic as per {@code get(YEAR)}.

 @return the year, from MIN_YEAR to MAX_YEAR"
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.lang.Integer [^java.time.YearMonth this] (.getYear this)))

(defn plus
  {:arglists (quote (["java.time.YearMonth" "java.time.temporal.TemporalAmount"]
                     ["java.time.YearMonth" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.YearMonth
   [^java.time.YearMonth this ^java.time.temporal.TemporalAmount amount-to-add]
   (.plus this amount-to-add))
  (^java.time.YearMonth
   [^java.time.YearMonth this ^long amount-to-add
    ^java.time.temporal.ChronoUnit unit]
   (.plus this amount-to-add unit)))

(defn is-leap-year
  "Checks if the year is a leap year, according to the ISO proleptic
 calendar system rules.

 This method applies the current rules for leap years across the whole time-line.
 In general, a year is a leap year if it is divisible by four without
 remainder. However, years divisible by 100, are not leap years, with
 the exception of years divisible by 400 which are.

 For example, 1904 is a leap year it is divisible by 4.
 1900 was not a leap year as it is divisible by 100, however 2000 was a
 leap year as it is divisible by 400.

 The calculation is proleptic - applying the same rules into the far future and far past.
 This is historically inaccurate, but is correct for the ISO-8601 standard.

 @return true if the year is leap, false otherwise"
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.lang.Boolean [^java.time.YearMonth this] (.isLeapYear this)))

(defn query
  "Queries this year-month using the specified query.

 This queries this year-month using the specified query strategy object.
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
  {:arglists (quote (["java.time.YearMonth"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object
   [^java.time.YearMonth this ^java.time.temporal.TemporalQuery query]
   (.query this query)))

(defn to-string
  "Outputs this year-month as a {@code String}, such as {@code 2007-12}.

 The output will be in the format {@code uuuu-MM}:

 @return a string representation of this year-month, not null"
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.lang.String [^java.time.YearMonth this] (.toString this)))

(defn plus-months
  "Returns a copy of this {@code YearMonth} with the specified number of months added.

 This instance is immutable and unaffected by this method call.

 @param monthsToAdd  the months to add, may be negative
 @return a {@code YearMonth} based on this year-month with the months added, not null
 @throws DateTimeException if the result exceeds the supported range"
  {:arglists (quote (["java.time.YearMonth" "long"]))}
  (^java.time.YearMonth [^java.time.YearMonth this ^long months-to-add]
   (.plusMonths this months-to-add)))

(defn is-before
  "Checks if this year-month is before the specified year-month.

 @param other  the other year-month to compare to, not null
 @return true if this point is before the specified year-month"
  {:arglists (quote (["java.time.YearMonth" "java.time.YearMonth"]))}
  (^java.lang.Boolean [^java.time.YearMonth this ^java.time.YearMonth other]
   (.isBefore this other)))

(defn minus-months
  "Returns a copy of this {@code YearMonth} with the specified number of months subtracted.

 This instance is immutable and unaffected by this method call.

 @param monthsToSubtract  the months to subtract, may be negative
 @return a {@code YearMonth} based on this year-month with the months subtracted, not null
 @throws DateTimeException if the result exceeds the supported range"
  {:arglists (quote (["java.time.YearMonth" "long"]))}
  (^java.time.YearMonth [^java.time.YearMonth this ^long months-to-subtract]
   (.minusMonths this months-to-subtract)))

(defn minus
  {:arglists (quote (["java.time.YearMonth" "java.time.temporal.TemporalAmount"]
                     ["java.time.YearMonth" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.YearMonth
   [^java.time.YearMonth this
    ^java.time.temporal.TemporalAmount amount-to-subtract]
   (.minus this amount-to-subtract))
  (^java.time.YearMonth
   [^java.time.YearMonth this ^long amount-to-subtract
    ^java.time.temporal.ChronoUnit unit]
   (.minus this amount-to-subtract unit)))

(defn get-long
  "Gets the value of the specified field from this year-month as a {@code long}.

 This queries this year-month for the value of the specified field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@link #isSupported(TemporalField) supported fields} will return valid
 values based on this year-month.
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
  {:arglists (quote (["java.time.YearMonth"
                      "java.time.temporal.TemporalField"]))}
  (^long [^java.time.YearMonth this ^java.time.temporal.TemporalField field]
   (.getLong this field)))

(defn with-year
  "Returns a copy of this {@code YearMonth} with the year altered.

 This instance is immutable and unaffected by this method call.

 @param year  the year to set in the returned year-month, from MIN_YEAR to MAX_YEAR
 @return a {@code YearMonth} based on this year-month with the requested year, not null
 @throws DateTimeException if the year value is invalid"
  {:arglists (quote (["java.time.YearMonth" "int"]))}
  (^java.time.YearMonth [^java.time.YearMonth this ^java.lang.Integer year]
   (.withYear this year)))

(defn at-end-of-month
  "Returns a {@code LocalDate} at the end of the month.

 This returns a {@code LocalDate} based on this year-month.
 The day-of-month is set to the last valid day of the month, taking
 into account leap years.

 This method can be used as part of a chain to produce a date:
 <pre>
  LocalDate date = year.atMonth(month).atEndOfMonth();
 </pre>

 @return the last valid date of this year-month, not null"
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.time.LocalDate [^java.time.YearMonth this] (.atEndOfMonth this)))

(defn length-of-month
  "Returns the length of the month, taking account of the year.

 This returns the length of the month in days.
 For example, a date in January would return 31.

 @return the length of the month in days, from 28 to 31"
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.lang.Integer [^java.time.YearMonth this] (.lengthOfMonth this)))

(defn until
  "Calculates the amount of time until another year-month in terms of the specified unit.

 This calculates the amount of time between two {@code YearMonth}
 objects in terms of a single {@code TemporalUnit}.
 The start and end points are {@code this} and the specified year-month.
 The result will be negative if the end is before the start.
 The {@code Temporal} passed to this method is converted to a
 {@code YearMonth} using {@link #from(TemporalAccessor)}.
 For example, the amount in years between two year-months can be calculated
 using {@code startYearMonth.until(endYearMonth, YEARS)}.

 The calculation returns a whole number, representing the number of
 complete units between the two year-months.
 For example, the amount in decades between 2012-06 and 2032-05
 will only be one decade as it is one month short of two decades.

 There are two equivalent ways of using this method.
 The first is to invoke this method.
 The second is to use {@link TemporalUnit#between(Temporal, Temporal)}:
 <pre>
   // these two lines are equivalent
   amount = start.until(end, MONTHS);
   amount = MONTHS.between(start, end);
 </pre>
 The choice should be made based on which makes the code more readable.

 The calculation is implemented in this method for {@link ChronoUnit}.
 The units {@code MONTHS}, {@code YEARS}, {@code DECADES},
 {@code CENTURIES}, {@code MILLENNIA} and {@code ERAS} are supported.
 Other {@code ChronoUnit} values will throw an exception.

 If the unit is not a {@code ChronoUnit}, then the result of this method
 is obtained by invoking {@code TemporalUnit.between(Temporal, Temporal)}
 passing {@code this} as the first argument and the converted input temporal
 as the second argument.

 This instance is immutable and unaffected by this method call.

 @param endExclusive  the end date, exclusive, which is converted to a {@code YearMonth}, not null
 @param unit  the unit to measure the amount in, not null
 @return the amount of time between this year-month and the end year-month
 @throws DateTimeException if the amount cannot be calculated, or the end
  temporal cannot be converted to a {@code YearMonth}
 @throws UnsupportedTemporalTypeException if the unit is not supported
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.YearMonth" "java.time.temporal.Temporal"
                      "java.time.temporal.TemporalUnit"]))}
  (^long
   [^java.time.YearMonth this ^java.time.temporal.Temporal end-exclusive
    ^java.time.temporal.ChronoUnit unit]
   (.until this end-exclusive unit)))

(defn from
  "Obtains an instance of {@code YearMonth} from a temporal object.

 This obtains a year-month based on the specified temporal.
 A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 which this factory converts to an instance of {@code YearMonth}.

 The conversion extracts the {@link ChronoField#YEAR YEAR} and
 {@link ChronoField#MONTH_OF_YEAR MONTH_OF_YEAR} fields.
 The extraction is only permitted if the temporal object has an ISO
 chronology, or can be converted to a {@code LocalDate}.

 This method matches the signature of the functional interface {@link TemporalQuery}
 allowing it to be used as a query via method reference, {@code YearMonth::from}.

 @param temporal  the temporal object to convert, not null
 @return the year-month, not null
 @throws DateTimeException if unable to convert to a {@code YearMonth}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^java.time.YearMonth [^java.time.temporal.TemporalAccessor temporal]
   (java.time.YearMonth/from temporal)))

(defn is-after
  "Checks if this year-month is after the specified year-month.

 @param other  the other year-month to compare to, not null
 @return true if this is after the specified year-month"
  {:arglists (quote (["java.time.YearMonth" "java.time.YearMonth"]))}
  (^java.lang.Boolean [^java.time.YearMonth this ^java.time.YearMonth other]
   (.isAfter this other)))

(defn is-supported
  {:arglists (quote (["java.time.YearMonth" "java.time.temporal.TemporalField"]
                     ["java.time.YearMonth"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.lang.Boolean [this arg0]
   (cond (instance? java.time.temporal.TemporalField arg0)
           (let [field ^"java.time.temporal.TemporalField" arg0]
             (.isSupported ^java.time.YearMonth this field))
         (instance? java.time.temporal.ChronoUnit arg0)
           (let [unit ^"java.time.temporal.ChronoUnit" arg0]
             (.isSupported ^java.time.YearMonth this unit))
         :else (throw (java.lang.IllegalArgumentException.
                        "no corresponding java.time method with these args")))))

(defn minus-years
  "Returns a copy of this {@code YearMonth} with the specified number of years subtracted.

 This instance is immutable and unaffected by this method call.

 @param yearsToSubtract  the years to subtract, may be negative
 @return a {@code YearMonth} based on this year-month with the years subtracted, not null
 @throws DateTimeException if the result exceeds the supported range"
  {:arglists (quote (["java.time.YearMonth" "long"]))}
  (^java.time.YearMonth [^java.time.YearMonth this ^long years-to-subtract]
   (.minusYears this years-to-subtract)))

(defn parse
  {:arglists (quote (["java.lang.CharSequence"]
                     ["java.lang.CharSequence"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.time.YearMonth [^java.lang.CharSequence text]
   (java.time.YearMonth/parse text))
  (^java.time.YearMonth
   [^java.lang.CharSequence text ^java.time.format.DateTimeFormatter formatter]
   (java.time.YearMonth/parse text formatter)))

(defn hash-code
  "A hash code for this year-month.

 @return a suitable hash code"
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.lang.Integer [^java.time.YearMonth this] (.hashCode this)))

(defn adjust-into
  "Adjusts the specified temporal object to have this year-month.

 This returns a temporal object of the same observable type as the input
 with the year and month changed to be the same as this.

 The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}
 passing {@link ChronoField#PROLEPTIC_MONTH} as the field.
 If the specified temporal object does not use the ISO calendar system then
 a {@code DateTimeException} is thrown.

 In most cases, it is clearer to reverse the calling pattern by using
 {@link Temporal#with(TemporalAdjuster)}:
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   temporal = thisYearMonth.adjustInto(temporal);
   temporal = temporal.with(thisYearMonth);
 </pre>

 This instance is immutable and unaffected by this method call.

 @param temporal  the target object to be adjusted, not null
 @return the adjusted object, not null
 @throws DateTimeException if unable to make the adjustment
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.YearMonth" "java.time.temporal.Temporal"]))}
  (^java.time.temporal.Temporal
   [^java.time.YearMonth this ^java.time.temporal.Temporal temporal]
   (.adjustInto this temporal)))

(defn with
  {:arglists (quote (["java.time.YearMonth"
                      "java.time.temporal.TemporalAdjuster"]
                     ["java.time.YearMonth" "java.time.temporal.TemporalField"
                      "long"]))}
  (^java.time.YearMonth
   [^java.time.YearMonth this ^java.time.temporal.TemporalAdjuster adjuster]
   (.with this adjuster))
  (^java.time.YearMonth
   [^java.time.YearMonth this ^java.time.temporal.TemporalField field
    ^long new-value]
   (.with this field new-value)))

(defn now
  {:arglists (quote ([] ["java.time.Clock"] ["java.time.ZoneId"]))}
  (^java.time.YearMonth [] (java.time.YearMonth/now))
  (^java.time.YearMonth [arg0]
   (cond (instance? java.time.Clock arg0) (let [clock ^"java.time.Clock" arg0]
                                            (java.time.YearMonth/now clock))
         (instance? java.time.ZoneId arg0) (let [zone ^"java.time.ZoneId" arg0]
                                             (java.time.YearMonth/now zone))
         :else (throw (java.lang.IllegalArgumentException.
                        "no corresponding java.time method with these args")))))

(defn get-month-value
  "Gets the month-of-year field from 1 to 12.

 This method returns the month as an {@code int} from 1 to 12.
 Application code is frequently clearer if the enum {@link Month}
 is used by calling {@link #getMonth()}.

 @return the month-of-year, from 1 to 12
 @see #getMonth()"
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.lang.Integer [^java.time.YearMonth this] (.getMonthValue this)))

(defn compare-to
  "Compares this year-month to another year-month.

 The comparison is based first on the value of the year, then on the value of the month.
 It is \"consistent with equals\", as defined by {@link Comparable}.

 @param other  the other year-month to compare to, not null
 @return the comparator value, negative if less, positive if greater"
  {:arglists (quote (["java.time.YearMonth" "java.time.YearMonth"]))}
  (^java.lang.Integer [^java.time.YearMonth this ^java.time.YearMonth other]
   (.compareTo this other)))

(defn get-month
  "Gets the month-of-year field using the {@code Month} enum.

 This method returns the enum {@link Month} for the month.
 This avoids confusion as to what {@code int} values mean.
 If you need access to the primitive {@code int} value then the enum
 provides the {@link Month#getValue() int value}.

 @return the month-of-year, not null
 @see #getMonthValue()"
  {:arglists (quote (["java.time.YearMonth"]))}
  (^java.time.Month [^java.time.YearMonth this] (.getMonth this)))

(defn get
  "Gets the value of the specified field from this year-month as an {@code int}.

 This queries this year-month for the value of the specified field.
 The returned value will always be within the valid range of values for the field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@link #isSupported(TemporalField) supported fields} will return valid
 values based on this year-month, except {@code PROLEPTIC_MONTH} which is too
 large to fit in an {@code int} and throw a {@code DateTimeException}.
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
  {:arglists (quote (["java.time.YearMonth"
                      "java.time.temporal.TemporalField"]))}
  (^java.lang.Integer
   [^java.time.YearMonth this ^java.time.temporal.TemporalField field]
   (.get this field)))

(defn equals
  "Checks if this year-month is equal to another year-month.

 The comparison is based on the time-line position of the year-months.

 @param obj  the object to check, null returns false
 @return true if this is equal to the other year-month"
  {:arglists (quote (["java.time.YearMonth" "java.lang.Object"]))}
  (^java.lang.Boolean [^java.time.YearMonth this ^java.lang.Object obj]
   (.equals this obj)))

(defn format
  "Formats this year-month using the specified formatter.

 This year-month will be passed to the formatter to produce a string.

 @param formatter  the formatter to use, not null
 @return the formatted year-month string, not null
 @throws DateTimeException if an error occurs during printing"
  {:arglists (quote (["java.time.YearMonth"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.lang.String
   [^java.time.YearMonth this ^java.time.format.DateTimeFormatter formatter]
   (.format this formatter)))

(defn plus-years
  "Returns a copy of this {@code YearMonth} with the specified number of years added.

 This instance is immutable and unaffected by this method call.

 @param yearsToAdd  the years to add, may be negative
 @return a {@code YearMonth} based on this year-month with the years added, not null
 @throws DateTimeException if the result exceeds the supported range"
  {:arglists (quote (["java.time.YearMonth" "long"]))}
  (^java.time.YearMonth [^java.time.YearMonth this ^long years-to-add]
   (.plusYears this years-to-add)))
