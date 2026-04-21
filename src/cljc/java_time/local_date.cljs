(ns cljc.java-time.local-date
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [LocalDate]]))

(def max (goog.object/get java.time.LocalDate "MAX"))

(def min (goog.object/get java.time.LocalDate "MIN"))

(defn minus-weeks
  "Returns a copy of this {@code LocalDate} with the specified number of weeks subtracted.

 This method subtracts the specified amount in weeks from the days field decrementing
 the month and year fields as necessary to ensure the result remains valid.
 The result is only invalid if the maximum/minimum year is exceeded.

 For example, 2009-01-07 minus one week would result in 2008-12-31.

 This instance is immutable and unaffected by this method call.

 @param weeksToSubtract  the weeks to subtract, may be negative
 @return a {@code LocalDate} based on this date with the weeks subtracted, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDate" "long"]))}
  (^js/JSJoda.LocalDate [^js/JSJoda.LocalDate this ^long weeks-to-subtract]
   (.minusWeeks this weeks-to-subtract)))

(defn plus-weeks
  "Returns a copy of this {@code LocalDate} with the specified number of weeks added.

 This method adds the specified amount in weeks to the days field incrementing
 the month and year fields as necessary to ensure the result remains valid.
 The result is only invalid if the maximum/minimum year is exceeded.

 For example, 2008-12-31 plus one week would result in 2009-01-07.

 This instance is immutable and unaffected by this method call.

 @param weeksToAdd  the weeks to add, may be negative
 @return a {@code LocalDate} based on this date with the weeks added, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDate" "long"]))}
  (^js/JSJoda.LocalDate [^js/JSJoda.LocalDate this ^long weeks-to-add]
   (.plusWeeks this weeks-to-add)))

(defn length-of-year
  "Returns the length of the year represented by this date.

 This returns the length of the year in days, either 365 or 366.

 @return 366 if the year is leap, 365 otherwise"
  {:arglists (quote (["java.time.LocalDate"]))}
  (^int [^js/JSJoda.LocalDate this] (.lengthOfYear this)))

(defn range
  "Gets the range of valid values for the specified field.

 The range object expresses the minimum and maximum valid values for a field.
 This date is used to enhance the accuracy of the returned range.
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
  {:arglists (quote (["java.time.LocalDate"
                      "java.time.temporal.TemporalField"]))}
  (^js/JSJoda.ValueRange
   [^js/JSJoda.LocalDate this ^js/JSJoda.TemporalField field]
   (.range this field)))

(defn get-era
  "Gets the era applicable at this date.

 The official ISO-8601 standard does not define eras, however {@code IsoChronology} does.
 It defines two eras, 'CE' from year one onwards and 'BCE' from year zero backwards.
 Since dates before the Julian-Gregorian cutover are not in line with history,
 the cutover between 'BCE' and 'CE' is also not aligned with the commonly used
 eras, often referred to using 'BC' and 'AD'.

 Users of this class should typically ignore this method as it exists primarily
 to fulfill the {@link ChronoLocalDate} contract where it is necessary to support
 the Japanese calendar system.

 The returned era will be a singleton capable of being compared with the constants
 in {@link IsoChronology} using the {@code ==} operator.

 @return the {@code IsoChronology} era constant applicable at this date, not null"
  {:arglists (quote (["java.time.LocalDate"]))}
  (^js/JSJoda.Era [^js/JSJoda.LocalDate this] (.era this)))

(defn of
  {:arglists (quote (["int" "int" "int"] ["int" "java.time.Month" "int"]))}
  (^js/JSJoda.LocalDate [arg0 arg1 arg2]
   (js-invoke java.time.LocalDate "of" arg0 arg1 arg2)))

(defn with-month
  "Returns a copy of this {@code LocalDate} with the month-of-year altered.

 If the day-of-month is invalid for the year, it will be changed to the last valid day of the month.

 This instance is immutable and unaffected by this method call.

 @param month  the month-of-year to set in the result, from 1 (January) to 12 (December)
 @return a {@code LocalDate} based on this date with the requested month, not null
 @throws DateTimeException if the month-of-year value is invalid"
  {:arglists (quote (["java.time.LocalDate" "int"]))}
  (^js/JSJoda.LocalDate [^js/JSJoda.LocalDate this ^int month]
   (.withMonth this month)))

(defn is-equal
  "Checks if this date is equal to the specified date.

 This checks to see if this date represents the same point on the
 local time-line as the other date.
 <pre>
   LocalDate a = LocalDate.of(2012, 6, 30);
   LocalDate b = LocalDate.of(2012, 7, 1);
   a.isEqual(b) == false
   a.isEqual(a) == true
   b.isEqual(a) == false
 </pre>

 This method only considers the position of the two dates on the local time-line.
 It does not take into account the chronology, or calendar system.
 This is different from the comparison in {@link #compareTo(ChronoLocalDate)}
 but is the same approach as {@link ChronoLocalDate#timeLineOrder()}.

 @param other  the other date to compare to, not null
 @return true if this date is equal to the specified date"
  {:arglists (quote (["java.time.LocalDate"
                      "java.time.chrono.ChronoLocalDate"]))}
  (^boolean [^js/JSJoda.LocalDate this ^js/JSJoda.ChronoLocalDate other]
   (.isEqual this other)))

(defn get-year
  "Gets the year field.

 This method returns the primitive {@code int} value for the year.

 The year returned by this method is proleptic as per {@code get(YEAR)}.
 To obtain the year-of-era, use {@code get(YEAR_OF_ERA)}.

 @return the year, from MIN_YEAR to MAX_YEAR"
  {:arglists (quote (["java.time.LocalDate"]))}
  (^int [^js/JSJoda.LocalDate this] (.year this)))

(defn to-epoch-day
  {:arglists (quote (["java.time.LocalDate"]))}
  (^long [^js/JSJoda.LocalDate this] (.toEpochDay this)))

(defn get-day-of-year
  "Gets the day-of-year field.

 This method returns the primitive {@code int} value for the day-of-year.

 @return the day-of-year, from 1 to 365, or 366 in a leap year"
  {:arglists (quote (["java.time.LocalDate"]))}
  (^int [^js/JSJoda.LocalDate this] (.dayOfYear this)))

(defn plus
  {:arglists (quote (["java.time.LocalDate" "java.time.temporal.TemporalAmount"]
                     ["java.time.LocalDate" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.LocalDate
   [^js/JSJoda.LocalDate this ^js/JSJoda.TemporalAmount amount-to-add]
   (.plus this amount-to-add))
  (^js/JSJoda.LocalDate
   [^js/JSJoda.LocalDate this ^long amount-to-add ^js/JSJoda.TemporalUnit unit]
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
  {:arglists (quote (["java.time.LocalDate"]))}
  (^boolean [^js/JSJoda.LocalDate this] (.isLeapYear this)))

(defn query
  "Queries this date using the specified query.

 This queries this date using the specified query strategy object.
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
  {:arglists (quote (["java.time.LocalDate"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object [^js/JSJoda.LocalDate this ^js/JSJoda.TemporalQuery query]
   (.query this query)))

(defn get-day-of-week
  "Gets the day-of-week field, which is an enum {@code DayOfWeek}.

 This method returns the enum {@link DayOfWeek} for the day-of-week.
 This avoids confusion as to what {@code int} values mean.
 If you need access to the primitive {@code int} value then the enum
 provides the {@link DayOfWeek#getValue() int value}.

 Additional information can be obtained from the {@code DayOfWeek}.
 This includes textual names of the values.

 @return the day-of-week, not null"
  {:arglists (quote (["java.time.LocalDate"]))}
  (^js/JSJoda.DayOfWeek [^js/JSJoda.LocalDate this] (.dayOfWeek this)))

(defn to-string
  "Outputs this date as a {@code String}, such as {@code 2007-12-03}.

 The output will be in the ISO-8601 format {@code uuuu-MM-dd}.

 @return a string representation of this date, not null"
  {:arglists (quote (["java.time.LocalDate"]))}
  (^java.lang.String [^js/JSJoda.LocalDate this] (.toString this)))

(defn plus-months
  "Returns a copy of this {@code LocalDate} with the specified number of months added.

 This method adds the specified amount to the months field in three steps:
 <ol>
 <li>Add the input months to the month-of-year field</li>
 <li>Check if the resulting date would be invalid</li>
 <li>Adjust the day-of-month to the last valid day if necessary</li>
 </ol>

 For example, 2007-03-31 plus one month would result in the invalid date
 2007-04-31. Instead of returning an invalid result, the last valid day
 of the month, 2007-04-30, is selected instead.

 This instance is immutable and unaffected by this method call.

 @param monthsToAdd  the months to add, may be negative
 @return a {@code LocalDate} based on this date with the months added, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDate" "long"]))}
  (^js/JSJoda.LocalDate [^js/JSJoda.LocalDate this ^long months-to-add]
   (.plusMonths this months-to-add)))

(defn is-before
  "Checks if this date is before the specified date.

 This checks to see if this date represents a point on the
 local time-line before the other date.
 <pre>
   LocalDate a = LocalDate.of(2012, 6, 30);
   LocalDate b = LocalDate.of(2012, 7, 1);
   a.isBefore(b) == true
   a.isBefore(a) == false
   b.isBefore(a) == false
 </pre>

 This method only considers the position of the two dates on the local time-line.
 It does not take into account the chronology, or calendar system.
 This is different from the comparison in {@link #compareTo(ChronoLocalDate)},
 but is the same approach as {@link ChronoLocalDate#timeLineOrder()}.

 @param other  the other date to compare to, not null
 @return true if this date is before the specified date"
  {:arglists (quote (["java.time.LocalDate"
                      "java.time.chrono.ChronoLocalDate"]))}
  (^boolean [^js/JSJoda.LocalDate this ^js/JSJoda.ChronoLocalDate other]
   (.isBefore this other)))

(defn minus-months
  "Returns a copy of this {@code LocalDate} with the specified number of months subtracted.

 This method subtracts the specified amount from the months field in three steps:
 <ol>
 <li>Subtract the input months from the month-of-year field</li>
 <li>Check if the resulting date would be invalid</li>
 <li>Adjust the day-of-month to the last valid day if necessary</li>
 </ol>

 For example, 2007-03-31 minus one month would result in the invalid date
 2007-02-31. Instead of returning an invalid result, the last valid day
 of the month, 2007-02-28, is selected instead.

 This instance is immutable and unaffected by this method call.

 @param monthsToSubtract  the months to subtract, may be negative
 @return a {@code LocalDate} based on this date with the months subtracted, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDate" "long"]))}
  (^js/JSJoda.LocalDate [^js/JSJoda.LocalDate this ^long months-to-subtract]
   (.minusMonths this months-to-subtract)))

(defn minus
  {:arglists (quote (["java.time.LocalDate" "java.time.temporal.TemporalAmount"]
                     ["java.time.LocalDate" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.LocalDate
   [^js/JSJoda.LocalDate this ^js/JSJoda.TemporalAmount amount-to-subtract]
   (.minus this amount-to-subtract))
  (^js/JSJoda.LocalDate
   [^js/JSJoda.LocalDate this ^long amount-to-subtract
    ^js/JSJoda.TemporalUnit unit]
   (.minus this amount-to-subtract unit)))

(defn plus-days
  "Returns a copy of this {@code LocalDate} with the specified number of days added.

 This method adds the specified amount to the days field incrementing the
 month and year fields as necessary to ensure the result remains valid.
 The result is only invalid if the maximum/minimum year is exceeded.

 For example, 2008-12-31 plus one day would result in 2009-01-01.

 This instance is immutable and unaffected by this method call.

 @param daysToAdd  the days to add, may be negative
 @return a {@code LocalDate} based on this date with the days added, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDate" "long"]))}
  (^js/JSJoda.LocalDate [^js/JSJoda.LocalDate this ^long days-to-add]
   (.plusDays this days-to-add)))

(defn get-long
  "Gets the value of the specified field from this date as a {@code long}.

 This queries this date for the value of the specified field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@link #isSupported(TemporalField) supported fields} will return valid
 values based on this date.
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
  {:arglists (quote (["java.time.LocalDate"
                      "java.time.temporal.TemporalField"]))}
  (^long [^js/JSJoda.LocalDate this ^js/JSJoda.TemporalField field]
   (.getLong this field)))

(defn with-year
  "Returns a copy of this {@code LocalDate} with the year altered.

 If the day-of-month is invalid for the year, it will be changed to the last valid day of the month.

 This instance is immutable and unaffected by this method call.

 @param year  the year to set in the result, from MIN_YEAR to MAX_YEAR
 @return a {@code LocalDate} based on this date with the requested year, not null
 @throws DateTimeException if the year value is invalid"
  {:arglists (quote (["java.time.LocalDate" "int"]))}
  (^js/JSJoda.LocalDate [^js/JSJoda.LocalDate this ^int year]
   (.withYear this year)))

(defn length-of-month
  "Returns the length of the month represented by this date.

 This returns the length of the month in days.
 For example, a date in January would return 31.

 @return the length of the month in days"
  {:arglists (quote (["java.time.LocalDate"]))}
  (^int [^js/JSJoda.LocalDate this] (.lengthOfMonth this)))

(defn until
  {:arglists (quote (["java.time.LocalDate" "java.time.chrono.ChronoLocalDate"]
                     ["java.time.LocalDate" "java.time.temporal.Temporal"
                      "java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.Period
   [^js/JSJoda.LocalDate this ^js/JSJoda.ChronoLocalDate end-date-exclusive]
   (.until this end-date-exclusive))
  (^long
   [^js/JSJoda.LocalDate this ^js/JSJoda.Temporal end-exclusive
    ^js/JSJoda.TemporalUnit unit]
   (.until this end-exclusive unit)))

(defn of-epoch-day
  "Obtains an instance of {@code LocalDate} from the epoch day count.

 This returns a {@code LocalDate} with the specified epoch-day.
 The {@link ChronoField#EPOCH_DAY EPOCH_DAY} is a simple incrementing count
 of days where day 0 is 1970-01-01. Negative numbers represent earlier days.

 @param epochDay  the Epoch Day to convert, based on the epoch 1970-01-01
 @return the local date, not null
 @throws DateTimeException if the epoch day exceeds the supported date range"
  {:arglists (quote (["long"]))}
  (^js/JSJoda.LocalDate [^long epoch-day]
   (js-invoke java.time.LocalDate "ofEpochDay" epoch-day)))

(defn with-day-of-month
  "Returns a copy of this {@code LocalDate} with the day-of-month altered.

 If the resulting date is invalid, an exception is thrown.

 This instance is immutable and unaffected by this method call.

 @param dayOfMonth  the day-of-month to set in the result, from 1 to 28-31
 @return a {@code LocalDate} based on this date with the requested day, not null
 @throws DateTimeException if the day-of-month value is invalid,
  or if the day-of-month is invalid for the month-year"
  {:arglists (quote (["java.time.LocalDate" "int"]))}
  (^js/JSJoda.LocalDate [^js/JSJoda.LocalDate this ^int day-of-month]
   (.withDayOfMonth this day-of-month)))

(defn get-day-of-month
  "Gets the day-of-month field.

 This method returns the primitive {@code int} value for the day-of-month.

 @return the day-of-month, from 1 to 31"
  {:arglists (quote (["java.time.LocalDate"]))}
  (^int [^js/JSJoda.LocalDate this] (.dayOfMonth this)))

(defn from
  "Obtains an instance of {@code LocalDate} from a temporal object.

 This obtains a local date based on the specified temporal.
 A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 which this factory converts to an instance of {@code LocalDate}.

 The conversion uses the {@link TemporalQueries#localDate()} query, which relies
 on extracting the {@link ChronoField#EPOCH_DAY EPOCH_DAY} field.

 This method matches the signature of the functional interface {@link TemporalQuery}
 allowing it to be used as a query via method reference, {@code LocalDate::from}.

 @param temporal  the temporal object to convert, not null
 @return the local date, not null
 @throws DateTimeException if unable to convert to a {@code LocalDate}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^js/JSJoda.LocalDate [^js/JSJoda.TemporalAccessor temporal]
   (js-invoke java.time.LocalDate "from" temporal)))

(defn is-after
  "Checks if this date is after the specified date.

 This checks to see if this date represents a point on the
 local time-line after the other date.
 <pre>
   LocalDate a = LocalDate.of(2012, 6, 30);
   LocalDate b = LocalDate.of(2012, 7, 1);
   a.isAfter(b) == false
   a.isAfter(a) == false
   b.isAfter(a) == true
 </pre>

 This method only considers the position of the two dates on the local time-line.
 It does not take into account the chronology, or calendar system.
 This is different from the comparison in {@link #compareTo(ChronoLocalDate)},
 but is the same approach as {@link ChronoLocalDate#timeLineOrder()}.

 @param other  the other date to compare to, not null
 @return true if this date is after the specified date"
  {:arglists (quote (["java.time.LocalDate"
                      "java.time.chrono.ChronoLocalDate"]))}
  (^boolean [^js/JSJoda.LocalDate this ^js/JSJoda.ChronoLocalDate other]
   (.isAfter this other)))

(defn is-supported
  {:arglists (quote (["java.time.LocalDate" "java.time.temporal.TemporalField"]
                     ["java.time.LocalDate"
                      "java.time.temporal.TemporalUnit"]))}
  (^boolean [^js/JSJoda.LocalDate this arg0]
   (.isSupported ^js/JSJoda.LocalDate this arg0)))

(defn minus-years
  "Returns a copy of this {@code LocalDate} with the specified number of years subtracted.

 This method subtracts the specified amount from the years field in three steps:
 <ol>
 <li>Subtract the input years from the year field</li>
 <li>Check if the resulting date would be invalid</li>
 <li>Adjust the day-of-month to the last valid day if necessary</li>
 </ol>

 For example, 2008-02-29 (leap year) minus one year would result in the
 invalid date 2007-02-29 (standard year). Instead of returning an invalid
 result, the last valid day of the month, 2007-02-28, is selected instead.

 This instance is immutable and unaffected by this method call.

 @param yearsToSubtract  the years to subtract, may be negative
 @return a {@code LocalDate} based on this date with the years subtracted, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDate" "long"]))}
  (^js/JSJoda.LocalDate [^js/JSJoda.LocalDate this ^long years-to-subtract]
   (.minusYears this years-to-subtract)))

(defn get-chronology
  "Gets the chronology of this date, which is the ISO calendar system.

 The {@code Chronology} represents the calendar system in use.
 The ISO-8601 calendar system is the modern civil calendar system used today
 in most of the world. It is equivalent to the proleptic Gregorian calendar
 system, in which today's rules for leap years are applied for all time.

 @return the ISO chronology, not null"
  {:arglists (quote (["java.time.LocalDate"]))}
  (^js/JSJoda.IsoChronology [^js/JSJoda.LocalDate this] (.chronology this)))

(defn parse
  {:arglists (quote (["java.lang.CharSequence"]
                     ["java.lang.CharSequence"
                      "java.time.format.DateTimeFormatter"]))}
  (^js/JSJoda.LocalDate [^java.lang.CharSequence text]
   (js-invoke java.time.LocalDate "parse" text))
  (^js/JSJoda.LocalDate
   [^java.lang.CharSequence text ^js/JSJoda.DateTimeFormatter formatter]
   (js-invoke java.time.LocalDate "parse" text formatter)))

(defn hash-code
  "A hash code for this date.

 @return a suitable hash code"
  {:arglists (quote (["java.time.LocalDate"]))}
  (^int [^js/JSJoda.LocalDate this] (.hashCode this)))

(defn adjust-into
  "Adjusts the specified temporal object to have the same date as this object.

 This returns a temporal object of the same observable type as the input
 with the date changed to be the same as this.

 The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}
 passing {@link ChronoField#EPOCH_DAY} as the field.

 In most cases, it is clearer to reverse the calling pattern by using
 {@link Temporal#with(TemporalAdjuster)}:
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   temporal = thisLocalDate.adjustInto(temporal);
   temporal = temporal.with(thisLocalDate);
 </pre>

 This instance is immutable and unaffected by this method call.

 @param temporal  the target object to be adjusted, not null
 @return the adjusted object, not null
 @throws DateTimeException if unable to make the adjustment
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.LocalDate" "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Temporal [^js/JSJoda.LocalDate this ^js/JSJoda.Temporal temporal]
   (.adjustInto this temporal)))

(defn with
  {:arglists (quote (["java.time.LocalDate"
                      "java.time.temporal.TemporalAdjuster"]
                     ["java.time.LocalDate" "java.time.temporal.TemporalField"
                      "long"]))}
  (^js/JSJoda.LocalDate
   [^js/JSJoda.LocalDate this ^js/JSJoda.TemporalAdjuster adjuster]
   (.with this adjuster))
  (^js/JSJoda.LocalDate
   [^js/JSJoda.LocalDate this ^js/JSJoda.TemporalField field ^long new-value]
   (.with this field new-value)))

(defn now
  {:arglists (quote ([] ["java.time.Clock"] ["java.time.ZoneId"]))}
  (^js/JSJoda.LocalDate [] (js-invoke java.time.LocalDate "now"))
  (^js/JSJoda.LocalDate [arg0] (js-invoke java.time.LocalDate "now" arg0)))

(defn at-start-of-day
  {:arglists (quote (["java.time.LocalDate"]
                     ["java.time.LocalDate" "java.time.ZoneId"]))}
  (^js/JSJoda.LocalDateTime [^js/JSJoda.LocalDate this] (.atStartOfDay this))
  (^js/JSJoda.ZonedDateTime [^js/JSJoda.LocalDate this ^js/JSJoda.ZoneId zone]
   (.atStartOfDay this zone)))

(defn get-month-value
  "Gets the month-of-year field from 1 to 12.

 This method returns the month as an {@code int} from 1 to 12.
 Application code is frequently clearer if the enum {@link Month}
 is used by calling {@link #getMonth()}.

 @return the month-of-year, from 1 to 12
 @see #getMonth()"
  {:arglists (quote (["java.time.LocalDate"]))}
  (^int [^js/JSJoda.LocalDate this] (.monthValue this)))

(defn with-day-of-year
  "Returns a copy of this {@code LocalDate} with the day-of-year altered.

 If the resulting date is invalid, an exception is thrown.

 This instance is immutable and unaffected by this method call.

 @param dayOfYear  the day-of-year to set in the result, from 1 to 365-366
 @return a {@code LocalDate} based on this date with the requested day, not null
 @throws DateTimeException if the day-of-year value is invalid,
  or if the day-of-year is invalid for the year"
  {:arglists (quote (["java.time.LocalDate" "int"]))}
  (^js/JSJoda.LocalDate [^js/JSJoda.LocalDate this ^int day-of-year]
   (.withDayOfYear this day-of-year)))

(defn compare-to
  "Compares this date to another date.

 The comparison is primarily based on the date, from earliest to latest.
 It is \"consistent with equals\", as defined by {@link Comparable}.

 If all the dates being compared are instances of {@code LocalDate},
 then the comparison will be entirely based on the date.
 If some dates being compared are in different chronologies, then the
 chronology is also considered, see {@link java.time.chrono.ChronoLocalDate#compareTo}.

 @param other  the other date to compare to, not null
 @return the comparator value, negative if less, positive if greater"
  {:arglists (quote (["java.time.LocalDate"
                      "java.time.chrono.ChronoLocalDate"]))}
  (^int [^js/JSJoda.LocalDate this ^js/JSJoda.ChronoLocalDate other]
   (.compareTo this other)))

(defn get-month
  "Gets the month-of-year field using the {@code Month} enum.

 This method returns the enum {@link Month} for the month.
 This avoids confusion as to what {@code int} values mean.
 If you need access to the primitive {@code int} value then the enum
 provides the {@link Month#getValue() int value}.

 @return the month-of-year, not null
 @see #getMonthValue()"
  {:arglists (quote (["java.time.LocalDate"]))}
  (^js/JSJoda.Month [^js/JSJoda.LocalDate this] (.month this)))

(defn of-year-day
  "Obtains an instance of {@code LocalDate} from a year and day-of-year.

 This returns a {@code LocalDate} with the specified year and day-of-year.
 The day-of-year must be valid for the year, otherwise an exception will be thrown.

 @param year  the year to represent, from MIN_YEAR to MAX_YEAR
 @param dayOfYear  the day-of-year to represent, from 1 to 366
 @return the local date, not null
 @throws DateTimeException if the value of any field is out of range,
  or if the day-of-year is invalid for the year"
  {:arglists (quote (["int" "int"]))}
  (^js/JSJoda.LocalDate [^int year ^int day-of-year]
   (js-invoke java.time.LocalDate "ofYearDay" year day-of-year)))

(defn get
  "Gets the value of the specified field from this date as an {@code int}.

 This queries this date for the value of the specified field.
 The returned value will always be within the valid range of values for the field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@link #isSupported(TemporalField) supported fields} will return valid
 values based on this date, except {@code EPOCH_DAY} and {@code PROLEPTIC_MONTH}
 which are too large to fit in an {@code int} and throw a {@code DateTimeException}.
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
  {:arglists (quote (["java.time.LocalDate"
                      "java.time.temporal.TemporalField"]))}
  (^int [^js/JSJoda.LocalDate this ^js/JSJoda.TemporalField field]
   (.get this field)))

(defn equals
  "Checks if this date is equal to another date.

 Compares this {@code LocalDate} with another ensuring that the date is the same.

 Only objects of type {@code LocalDate} are compared, other types return false.
 To compare the dates of two {@code TemporalAccessor} instances, including dates
 in two different chronologies, use {@link ChronoField#EPOCH_DAY} as a comparator.

 @param obj  the object to check, null returns false
 @return true if this is equal to the other date"
  {:arglists (quote (["java.time.LocalDate" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.LocalDate this ^java.lang.Object obj]
   (.equals this obj)))

(defn at-time
  {:arglists (quote (["java.time.LocalDate" "java.time.LocalTime"]
                     ["java.time.LocalDate" "java.time.OffsetTime"]
                     ["java.time.LocalDate" "int" "int"]
                     ["java.time.LocalDate" "int" "int" "int"]
                     ["java.time.LocalDate" "int" "int" "int" "int"]))}
  (^java.lang.Object [^js/JSJoda.LocalDate this arg0]
   (.atTime ^js/JSJoda.LocalDate this arg0))
  (^js/JSJoda.LocalDateTime [^js/JSJoda.LocalDate this ^int hour ^int minute]
   (.atTime this hour minute))
  (^js/JSJoda.LocalDateTime
   [^js/JSJoda.LocalDate this ^int hour ^int minute ^int second]
   (.atTime this hour minute second))
  (^js/JSJoda.LocalDateTime
   [^js/JSJoda.LocalDate this ^int hour ^int minute ^int second
    ^int nano-of-second]
   (.atTime this hour minute second nano-of-second)))

(defn format
  "Formats this date using the specified formatter.

 This date will be passed to the formatter to produce a string.

 @param formatter  the formatter to use, not null
 @return the formatted date string, not null
 @throws DateTimeException if an error occurs during printing"
  {:arglists (quote (["java.time.LocalDate"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.lang.String
   [^js/JSJoda.LocalDate this ^js/JSJoda.DateTimeFormatter formatter]
   (.format this formatter)))

(defn plus-years
  "Returns a copy of this {@code LocalDate} with the specified number of years added.

 This method adds the specified amount to the years field in three steps:
 <ol>
 <li>Add the input years to the year field</li>
 <li>Check if the resulting date would be invalid</li>
 <li>Adjust the day-of-month to the last valid day if necessary</li>
 </ol>

 For example, 2008-02-29 (leap year) plus one year would result in the
 invalid date 2009-02-29 (standard year). Instead of returning an invalid
 result, the last valid day of the month, 2009-02-28, is selected instead.

 This instance is immutable and unaffected by this method call.

 @param yearsToAdd  the years to add, may be negative
 @return a {@code LocalDate} based on this date with the years added, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDate" "long"]))}
  (^js/JSJoda.LocalDate [^js/JSJoda.LocalDate this ^long years-to-add]
   (.plusYears this years-to-add)))

(defn minus-days
  "Returns a copy of this {@code LocalDate} with the specified number of days subtracted.

 This method subtracts the specified amount from the days field decrementing the
 month and year fields as necessary to ensure the result remains valid.
 The result is only invalid if the maximum/minimum year is exceeded.

 For example, 2009-01-01 minus one day would result in 2008-12-31.

 This instance is immutable and unaffected by this method call.

 @param daysToSubtract  the days to subtract, may be negative
 @return a {@code LocalDate} based on this date with the days subtracted, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDate" "long"]))}
  (^js/JSJoda.LocalDate [^js/JSJoda.LocalDate this ^long days-to-subtract]
   (.minusDays this days-to-subtract)))
