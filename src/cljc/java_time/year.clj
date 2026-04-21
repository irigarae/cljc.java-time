(ns cljc.java-time.year
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time Year]))

(def min-value java.time.Year/MIN_VALUE)

(def max-value java.time.Year/MAX_VALUE)

(defn range
  "Gets the range of valid values for the specified field.

 The range object expresses the minimum and maximum valid values for a field.
 This year is used to enhance the accuracy of the returned range.
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
  {:arglists (quote (["java.time.Year" "java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ValueRange
   [^java.time.Year this ^java.time.temporal.TemporalField field]
   (.range this field)))

(defn of
  "Obtains an instance of {@code Year}.

 This method accepts a year value from the proleptic ISO calendar system.

 The year 2AD/CE is represented by 2.<br>
 The year 1AD/CE is represented by 1.<br>
 The year 1BC/BCE is represented by 0.<br>
 The year 2BC/BCE is represented by -1.<br>

 @param isoYear  the ISO proleptic year to represent, from {@code MIN_VALUE} to {@code MAX_VALUE}
 @return the year, not null
 @throws DateTimeException if the field is invalid"
  {:arglists (quote (["int"]))}
  (^java.time.Year [^java.lang.Integer iso-year] (java.time.Year/of iso-year)))

(defn at-day
  "Combines this year with a day-of-year to create a {@code LocalDate}.

 This returns a {@code LocalDate} formed from this year and the specified day-of-year.

 The day-of-year value 366 is only valid in a leap year.

 @param dayOfYear  the day-of-year to use, from 1 to 365-366
 @return the local date formed from this year and the specified date of year, not null
 @throws DateTimeException if the day of year is zero or less, 366 or greater or equal
  to 366 and this is not a leap year"
  {:arglists (quote (["java.time.Year" "int"]))}
  (^java.time.LocalDate [^java.time.Year this ^java.lang.Integer day-of-year]
   (.atDay this day-of-year)))

(defn plus
  {:arglists (quote (["java.time.Year" "java.time.temporal.TemporalAmount"]
                     ["java.time.Year" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.Year
   [^java.time.Year this ^java.time.temporal.TemporalAmount amount-to-add]
   (.plus this amount-to-add))
  (^java.time.Year
   [^java.time.Year this ^long amount-to-add
    ^java.time.temporal.ChronoUnit unit]
   (.plus this amount-to-add unit)))

(defn is-valid-month-day
  "Checks if the month-day is valid for this year.

 This method checks whether this year and the input month and day form
 a valid date.

 @param monthDay  the month-day to validate, null returns false
 @return true if the month and day are valid for this year"
  {:arglists (quote (["java.time.Year" "java.time.MonthDay"]))}
  (^java.lang.Boolean [^java.time.Year this ^java.time.MonthDay month-day]
   (.isValidMonthDay this month-day)))

(defn query
  "Queries this year using the specified query.

 This queries this year using the specified query strategy object.
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
  {:arglists (quote (["java.time.Year" "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object
   [^java.time.Year this ^java.time.temporal.TemporalQuery query]
   (.query this query)))

(defn is-leap
  {:arglists (quote (["long"]))}
  (^java.lang.Boolean [^long year] (. java.time.Year isLeap year)))

(defn to-string
  "Outputs this year as a {@code String}.

 @return a string representation of this year, not null"
  {:arglists (quote (["java.time.Year"]))}
  (^java.lang.String [^java.time.Year this] (.toString this)))

(defn is-before
  "Checks if this year is before the specified year.

 @param other  the other year to compare to, not null
 @return true if this point is before the specified year"
  {:arglists (quote (["java.time.Year" "java.time.Year"]))}
  (^java.lang.Boolean [^java.time.Year this ^java.time.Year other]
   (.isBefore this other)))

(defn minus
  {:arglists (quote (["java.time.Year" "java.time.temporal.TemporalAmount"]
                     ["java.time.Year" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.Year
   [^java.time.Year this ^java.time.temporal.TemporalAmount amount-to-subtract]
   (.minus this amount-to-subtract))
  (^java.time.Year
   [^java.time.Year this ^long amount-to-subtract
    ^java.time.temporal.ChronoUnit unit]
   (.minus this amount-to-subtract unit)))

(defn at-month-day
  "Combines this year with a month-day to create a {@code LocalDate}.

 This returns a {@code LocalDate} formed from this year and the specified month-day.

 A month-day of February 29th will be adjusted to February 28th in the resulting
 date if the year is not a leap year.

 @param monthDay  the month-day to use, not null
 @return the local date formed from this year and the specified month-day, not null"
  {:arglists (quote (["java.time.Year" "java.time.MonthDay"]))}
  (^java.time.LocalDate [^java.time.Year this ^java.time.MonthDay month-day]
   (.atMonthDay this month-day)))

(defn get-value
  "Gets the year value.

 The year returned by this method is proleptic as per {@code get(YEAR)}.

 @return the year, {@code MIN_VALUE} to {@code MAX_VALUE}"
  {:arglists (quote (["java.time.Year"]))}
  (^java.lang.Integer [^java.time.Year this] (.getValue this)))

(defn get-long
  "Gets the value of the specified field from this year as a {@code long}.

 This queries this year for the value of the specified field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@link #isSupported(TemporalField) supported fields} will return valid
 values based on this year.
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
  {:arglists (quote (["java.time.Year" "java.time.temporal.TemporalField"]))}
  (^long [^java.time.Year this ^java.time.temporal.TemporalField field]
   (.getLong this field)))

(defn at-month
  {:arglists (quote (["java.time.Year" "int"]
                     ["java.time.Year" "java.time.Month"]))}
  (^java.time.YearMonth [this arg0]
   (cond (instance? java.lang.Number arg0)
           (let [month (int arg0)] (.atMonth ^java.time.Year this month))
         (instance? java.time.Month arg0) (let [month ^"java.time.Month" arg0]
                                            (.atMonth ^java.time.Year this
                                                      month))
         :else (throw (java.lang.IllegalArgumentException.
                        "no corresponding java.time method with these args")))))

(defn until
  "Calculates the amount of time until another year in terms of the specified unit.

 This calculates the amount of time between two {@code Year}
 objects in terms of a single {@code TemporalUnit}.
 The start and end points are {@code this} and the specified year.
 The result will be negative if the end is before the start.
 The {@code Temporal} passed to this method is converted to a
 {@code Year} using {@link #from(TemporalAccessor)}.
 For example, the amount in decades between two year can be calculated
 using {@code startYear.until(endYear, DECADES)}.

 The calculation returns a whole number, representing the number of
 complete units between the two years.
 For example, the amount in decades between 2012 and 2031
 will only be one decade as it is one year short of two decades.

 There are two equivalent ways of using this method.
 The first is to invoke this method.
 The second is to use {@link TemporalUnit#between(Temporal, Temporal)}:
 <pre>
   // these two lines are equivalent
   amount = start.until(end, YEARS);
   amount = YEARS.between(start, end);
 </pre>
 The choice should be made based on which makes the code more readable.

 The calculation is implemented in this method for {@link ChronoUnit}.
 The units {@code YEARS}, {@code DECADES}, {@code CENTURIES},
 {@code MILLENNIA} and {@code ERAS} are supported.
 Other {@code ChronoUnit} values will throw an exception.

 If the unit is not a {@code ChronoUnit}, then the result of this method
 is obtained by invoking {@code TemporalUnit.between(Temporal, Temporal)}
 passing {@code this} as the first argument and the converted input temporal
 as the second argument.

 This instance is immutable and unaffected by this method call.

 @param endExclusive  the end date, exclusive, which is converted to a {@code Year}, not null
 @param unit  the unit to measure the amount in, not null
 @return the amount of time between this year and the end year
 @throws DateTimeException if the amount cannot be calculated, or the end
  temporal cannot be converted to a {@code Year}
 @throws UnsupportedTemporalTypeException if the unit is not supported
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Year" "java.time.temporal.Temporal"
                      "java.time.temporal.TemporalUnit"]))}
  (^long
   [^java.time.Year this ^java.time.temporal.Temporal end-exclusive
    ^java.time.temporal.ChronoUnit unit]
   (.until this end-exclusive unit)))

(defn length
  "Gets the length of this year in days.

 @return the length of this year in days, 365 or 366"
  {:arglists (quote (["java.time.Year"]))}
  (^java.lang.Integer [^java.time.Year this] (.length this)))

(defn from
  "Obtains an instance of {@code Year} from a temporal object.

 This obtains a year based on the specified temporal.
 A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 which this factory converts to an instance of {@code Year}.

 The conversion extracts the {@link ChronoField#YEAR year} field.
 The extraction is only permitted if the temporal object has an ISO
 chronology, or can be converted to a {@code LocalDate}.

 This method matches the signature of the functional interface {@link TemporalQuery}
 allowing it to be used as a query via method reference, {@code Year::from}.

 @param temporal  the temporal object to convert, not null
 @return the year, not null
 @throws DateTimeException if unable to convert to a {@code Year}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^java.time.Year [^java.time.temporal.TemporalAccessor temporal]
   (java.time.Year/from temporal)))

(defn is-after
  "Checks if this year is after the specified year.

 @param other  the other year to compare to, not null
 @return true if this is after the specified year"
  {:arglists (quote (["java.time.Year" "java.time.Year"]))}
  (^java.lang.Boolean [^java.time.Year this ^java.time.Year other]
   (.isAfter this other)))

(defn is-supported
  {:arglists (quote (["java.time.Year" "java.time.temporal.TemporalField"]
                     ["java.time.Year" "java.time.temporal.TemporalUnit"]))}
  (^java.lang.Boolean [this arg0]
   (cond (instance? java.time.temporal.TemporalField arg0)
           (let [field ^"java.time.temporal.TemporalField" arg0]
             (.isSupported ^java.time.Year this field))
         (instance? java.time.temporal.ChronoUnit arg0)
           (let [unit ^"java.time.temporal.ChronoUnit" arg0]
             (.isSupported ^java.time.Year this unit))
         :else (throw (java.lang.IllegalArgumentException.
                        "no corresponding java.time method with these args")))))

(defn minus-years
  "Returns a copy of this {@code Year} with the specified number of years subtracted.

 This instance is immutable and unaffected by this method call.

 @param yearsToSubtract  the years to subtract, may be negative
 @return a {@code Year} based on this year with the year subtracted, not null
 @throws DateTimeException if the result exceeds the supported range"
  {:arglists (quote (["java.time.Year" "long"]))}
  (^java.time.Year [^java.time.Year this ^long years-to-subtract]
   (.minusYears this years-to-subtract)))

(defn parse
  {:arglists (quote (["java.lang.CharSequence"]
                     ["java.lang.CharSequence"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.time.Year [^java.lang.CharSequence text] (java.time.Year/parse text))
  (^java.time.Year
   [^java.lang.CharSequence text ^java.time.format.DateTimeFormatter formatter]
   (java.time.Year/parse text formatter)))

(defn hash-code
  "A hash code for this year.

 @return a suitable hash code"
  {:arglists (quote (["java.time.Year"]))}
  (^java.lang.Integer [^java.time.Year this] (.hashCode this)))

(defn adjust-into
  "Adjusts the specified temporal object to have this year.

 This returns a temporal object of the same observable type as the input
 with the year changed to be the same as this.

 The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}
 passing {@link ChronoField#YEAR} as the field.
 If the specified temporal object does not use the ISO calendar system then
 a {@code DateTimeException} is thrown.

 In most cases, it is clearer to reverse the calling pattern by using
 {@link Temporal#with(TemporalAdjuster)}:
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   temporal = thisYear.adjustInto(temporal);
   temporal = temporal.with(thisYear);
 </pre>

 This instance is immutable and unaffected by this method call.

 @param temporal  the target object to be adjusted, not null
 @return the adjusted object, not null
 @throws DateTimeException if unable to make the adjustment
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Year" "java.time.temporal.Temporal"]))}
  (^java.time.temporal.Temporal
   [^java.time.Year this ^java.time.temporal.Temporal temporal]
   (.adjustInto this temporal)))

(defn with
  {:arglists (quote (["java.time.Year" "java.time.temporal.TemporalAdjuster"]
                     ["java.time.Year" "java.time.temporal.TemporalField"
                      "long"]))}
  (^java.time.Year
   [^java.time.Year this ^java.time.temporal.TemporalAdjuster adjuster]
   (.with this adjuster))
  (^java.time.Year
   [^java.time.Year this ^java.time.temporal.TemporalField field
    ^long new-value]
   (.with this field new-value)))

(defn now
  {:arglists (quote ([] ["java.time.Clock"] ["java.time.ZoneId"]))}
  (^java.time.Year [] (java.time.Year/now))
  (^java.time.Year [arg0]
   (cond (instance? java.time.Clock arg0) (let [clock ^"java.time.Clock" arg0]
                                            (java.time.Year/now clock))
         (instance? java.time.ZoneId arg0) (let [zone ^"java.time.ZoneId" arg0]
                                             (java.time.Year/now zone))
         :else (throw (java.lang.IllegalArgumentException.
                        "no corresponding java.time method with these args")))))

(defn compare-to
  "Compares this year to another year.

 The comparison is based on the value of the year.
 It is \"consistent with equals\", as defined by {@link Comparable}.

 @param other  the other year to compare to, not null
 @return the comparator value, negative if less, positive if greater"
  {:arglists (quote (["java.time.Year" "java.time.Year"]))}
  (^java.lang.Integer [^java.time.Year this ^java.time.Year other]
   (.compareTo this other)))

(defn get
  "Gets the value of the specified field from this year as an {@code int}.

 This queries this year for the value of the specified field.
 The returned value will always be within the valid range of values for the field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@link #isSupported(TemporalField) supported fields} will return valid
 values based on this year.
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
  {:arglists (quote (["java.time.Year" "java.time.temporal.TemporalField"]))}
  (^java.lang.Integer
   [^java.time.Year this ^java.time.temporal.TemporalField field]
   (.get this field)))

(defn equals
  "Checks if this year is equal to another year.

 The comparison is based on the time-line position of the years.

 @param obj  the object to check, null returns false
 @return true if this is equal to the other year"
  {:arglists (quote (["java.time.Year" "java.lang.Object"]))}
  (^java.lang.Boolean [^java.time.Year this ^java.lang.Object obj]
   (.equals this obj)))

(defn format
  "Formats this year using the specified formatter.

 This year will be passed to the formatter to produce a string.

 @param formatter  the formatter to use, not null
 @return the formatted year string, not null
 @throws DateTimeException if an error occurs during printing"
  {:arglists (quote (["java.time.Year" "java.time.format.DateTimeFormatter"]))}
  (^java.lang.String
   [^java.time.Year this ^java.time.format.DateTimeFormatter formatter]
   (.format this formatter)))

(defn plus-years
  "Returns a copy of this {@code Year} with the specified number of years added.

 This instance is immutable and unaffected by this method call.

 @param yearsToAdd  the years to add, may be negative
 @return a {@code Year} based on this year with the years added, not null
 @throws DateTimeException if the result exceeds the supported range"
  {:arglists (quote (["java.time.Year" "long"]))}
  (^java.time.Year [^java.time.Year this ^long years-to-add]
   (.plusYears this years-to-add)))
