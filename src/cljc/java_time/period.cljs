(ns cljc.java-time.period
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [Period]]))

(def zero (goog.object/get java.time.Period "ZERO"))

(defn get-months
  "Gets the amount of months of this period.

 This returns the months unit.

 The months unit is not automatically normalized with the years unit.
 This means that a period of \"15 months\" is different to a period
 of \"1 year and 3 months\".

 @return the amount of months of this period, may be negative"
  {:arglists (quote (["java.time.Period"]))}
  (^int [^js/JSJoda.Period this] (.months this)))

(defn of-weeks
  "Obtains a {@code Period} representing a number of weeks.

 The resulting period will be day-based, with the amount of days
 equal to the number of weeks multiplied by 7.
 The years and months units will be zero.

 @param weeks  the number of weeks, positive or negative
 @return the period, with the input weeks converted to days, not null"
  {:arglists (quote (["int"]))}
  (^js/JSJoda.Period [^int weeks] (js-invoke java.time.Period "ofWeeks" weeks)))

(defn of-days
  "Obtains a {@code Period} representing a number of days.

 The resulting period will have the specified days.
 The years and months units will be zero.

 @param days  the number of days, positive or negative
 @return the period of days, not null"
  {:arglists (quote (["int"]))}
  (^js/JSJoda.Period [^int days] (js-invoke java.time.Period "ofDays" days)))

(defn is-negative
  "Checks if any of the three units of this period are negative.

 This checks whether the years, months or days units are less than zero.

 @return true if any unit of this period is negative"
  {:arglists (quote (["java.time.Period"]))}
  (^boolean [^js/JSJoda.Period this] (.isNegative this)))

(defn of
  "Obtains a {@code Period} representing a number of years, months and days.

 This creates an instance based on years, months and days.

 @param years  the amount of years, may be negative
 @param months  the amount of months, may be negative
 @param days  the amount of days, may be negative
 @return the period of years, months and days, not null"
  {:arglists (quote (["int" "int" "int"]))}
  (^js/JSJoda.Period [^int years ^int months ^int days]
   (js-invoke java.time.Period "of" years months days)))

(defn is-zero
  "Checks if all three units of this period are zero.

 A zero period has the value zero for the years, months and days units.

 @return true if this period is zero-length"
  {:arglists (quote (["java.time.Period"]))}
  (^boolean [^js/JSJoda.Period this] (.isZero this)))

(defn multiplied-by
  "Returns a new instance with each element in this period multiplied
 by the specified scalar.

 This returns a period with each of the years, months and days units
 individually multiplied.
 For example, a period of \"2 years, -3 months and 4 days\" multiplied by
 3 will return \"6 years, -9 months and 12 days\".
 No normalization is performed.

 @param scalar  the scalar to multiply by, not null
 @return a {@code Period} based on this period with the amounts multiplied by the scalar, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "int"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^int scalar]
   (.multipliedBy this scalar)))

(defn get-units
  "Gets the set of units supported by this period.

 The supported units are {@link ChronoUnit#YEARS YEARS},
 {@link ChronoUnit#MONTHS MONTHS} and {@link ChronoUnit#DAYS DAYS}.
 They are returned in the order years, months, days.

 This set can be used in conjunction with {@link #get(TemporalUnit)}
 to access the entire state of the period.

 @return a list containing the years, months and days units, not null"
  {:arglists (quote (["java.time.Period"]))}
  (^java.util.List [^js/JSJoda.Period this] (.units this)))

(defn with-days
  "Returns a copy of this period with the specified amount of days.

 This sets the amount of the days unit in a copy of this period.
 The years and months units are unaffected.

 This instance is immutable and unaffected by this method call.

 @param days  the days to represent, may be negative
 @return a {@code Period} based on this period with the requested days, not null"
  {:arglists (quote (["java.time.Period" "int"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^int days] (.withDays this days)))

(defn plus
  "Returns a copy of this period with the specified period added.

 This operates separately on the years, months and days.
 No normalization is performed.

 For example, \"1 year, 6 months and 3 days\" plus \"2 years, 2 months and 2 days\"
 returns \"3 years, 8 months and 5 days\".

 The specified amount is typically an instance of {@code Period}.
 Other types are interpreted using {@link Period#from(TemporalAmount)}.

 This instance is immutable and unaffected by this method call.

 @param amountToAdd  the amount to add, not null
 @return a {@code Period} based on this period with the requested period added, not null
 @throws DateTimeException if the specified amount has a non-ISO chronology or
  contains an invalid unit
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "java.time.temporal.TemporalAmount"]))}
  (^js/JSJoda.Period
   [^js/JSJoda.Period this ^js/JSJoda.TemporalAmount amount-to-add]
   (.plus this amount-to-add)))

(defn of-months
  "Obtains a {@code Period} representing a number of months.

 The resulting period will have the specified months.
 The years and days units will be zero.

 @param months  the number of months, positive or negative
 @return the period of months, not null"
  {:arglists (quote (["int"]))}
  (^js/JSJoda.Period [^int months]
   (js-invoke java.time.Period "ofMonths" months)))

(defn to-string
  "Outputs this period as a {@code String}, such as {@code P6Y3M1D}.

 The output will be in the ISO-8601 period format.
 A zero period will be represented as zero days, 'P0D'.

 @return a string representation of this period, not null"
  {:arglists (quote (["java.time.Period"]))}
  (^java.lang.String [^js/JSJoda.Period this] (.toString this)))

(defn plus-months
  "Returns a copy of this period with the specified months added.

 This adds the amount to the months unit in a copy of this period.
 The years and days units are unaffected.
 For example, \"1 year, 6 months and 3 days\" plus 2 months returns \"1 year, 8 months and 3 days\".

 This instance is immutable and unaffected by this method call.

 @param monthsToAdd  the months to add, positive or negative
 @return a {@code Period} based on this period with the specified months added, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "long"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^long months-to-add]
   (.plusMonths this months-to-add)))

(defn minus-months
  "Returns a copy of this period with the specified months subtracted.

 This subtracts the amount from the months unit in a copy of this period.
 The years and days units are unaffected.
 For example, \"1 year, 6 months and 3 days\" minus 2 months returns \"1 year, 4 months and 3 days\".

 This instance is immutable and unaffected by this method call.

 @param monthsToSubtract  the years to subtract, positive or negative
 @return a {@code Period} based on this period with the specified months subtracted, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "long"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^long months-to-subtract]
   (.minusMonths this months-to-subtract)))

(defn minus
  "Returns a copy of this period with the specified period subtracted.

 This operates separately on the years, months and days.
 No normalization is performed.

 For example, \"1 year, 6 months and 3 days\" minus \"2 years, 2 months and 2 days\"
 returns \"-1 years, 4 months and 1 day\".

 The specified amount is typically an instance of {@code Period}.
 Other types are interpreted using {@link Period#from(TemporalAmount)}.

 This instance is immutable and unaffected by this method call.

 @param amountToSubtract  the amount to subtract, not null
 @return a {@code Period} based on this period with the requested period subtracted, not null
 @throws DateTimeException if the specified amount has a non-ISO chronology or
  contains an invalid unit
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "java.time.temporal.TemporalAmount"]))}
  (^js/JSJoda.Period
   [^js/JSJoda.Period this ^js/JSJoda.TemporalAmount amount-to-subtract]
   (.minus this amount-to-subtract)))

(defn add-to
  "Adds this period to the specified temporal object.

 This returns a temporal object of the same observable type as the input
 with this period added.
 If the temporal has a chronology, it must be the ISO chronology.

 In most cases, it is clearer to reverse the calling pattern by using
 {@link Temporal#plus(TemporalAmount)}.
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   dateTime = thisPeriod.addTo(dateTime);
   dateTime = dateTime.plus(thisPeriod);
 </pre>

 The calculation operates as follows.
 First, the chronology of the temporal is checked to ensure it is ISO chronology or null.
 Second, if the months are zero, the years are added if non-zero, otherwise
 the combination of years and months is added if non-zero.
 Finally, any days are added.

 This approach ensures that a partial period can be added to a partial date.
 For example, a period of years and/or months can be added to a {@code YearMonth},
 but a period including days cannot.
 The approach also adds years and months together when necessary, which ensures
 correct behaviour at the end of the month.

 This instance is immutable and unaffected by this method call.

 @param temporal  the temporal object to adjust, not null
 @return an object of the same type with the adjustment made, not null
 @throws DateTimeException if unable to add
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Temporal [^js/JSJoda.Period this ^js/JSJoda.Temporal temporal]
   (.addTo this temporal)))

(defn to-total-months
  "Gets the total number of months in this period.

 This returns the total number of months in the period by multiplying the
 number of years by 12 and adding the number of months.

 This instance is immutable and unaffected by this method call.

 @return the total number of months in the period, may be negative"
  {:arglists (quote (["java.time.Period"]))}
  (^long [^js/JSJoda.Period this] (.toTotalMonths this)))

(defn plus-days
  "Returns a copy of this period with the specified days added.

 This adds the amount to the days unit in a copy of this period.
 The years and months units are unaffected.
 For example, \"1 year, 6 months and 3 days\" plus 2 days returns \"1 year, 6 months and 5 days\".

 This instance is immutable and unaffected by this method call.

 @param daysToAdd  the days to add, positive or negative
 @return a {@code Period} based on this period with the specified days added, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "long"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^long days-to-add]
   (.plusDays this days-to-add)))

(defn of-years
  "Obtains a {@code Period} representing a number of years.

 The resulting period will have the specified years.
 The months and days units will be zero.

 @param years  the number of years, positive or negative
 @return the period of years, not null"
  {:arglists (quote (["int"]))}
  (^js/JSJoda.Period [^int years] (js-invoke java.time.Period "ofYears" years)))

(defn get-days
  "Gets the amount of days of this period.

 This returns the days unit.

 @return the amount of days of this period, may be negative"
  {:arglists (quote (["java.time.Period"]))}
  (^int [^js/JSJoda.Period this] (.days this)))

(defn negated
  "Returns a new instance with each amount in this period negated.

 This returns a period with each of the years, months and days units
 individually negated.
 For example, a period of \"2 years, -3 months and 4 days\" will be
 negated to \"-2 years, 3 months and -4 days\".
 No normalization is performed.

 @return a {@code Period} based on this period with the amounts negated, not null
 @throws ArithmeticException if numeric overflow occurs, which only happens if
  one of the units has the value {@code Long.MIN_VALUE}"
  {:arglists (quote (["java.time.Period"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this] (.negated this)))

(defn get-years
  "Gets the amount of years of this period.

 This returns the years unit.

 The months unit is not automatically normalized with the years unit.
 This means that a period of \"15 months\" is different to a period
 of \"1 year and 3 months\".

 @return the amount of years of this period, may be negative"
  {:arglists (quote (["java.time.Period"]))}
  (^int [^js/JSJoda.Period this] (.years this)))

(defn with-years
  "Returns a copy of this period with the specified amount of years.

 This sets the amount of the years unit in a copy of this period.
 The months and days units are unaffected.

 The months unit is not automatically normalized with the years unit.
 This means that a period of \"15 months\" is different to a period
 of \"1 year and 3 months\".

 This instance is immutable and unaffected by this method call.

 @param years  the years to represent, may be negative
 @return a {@code Period} based on this period with the requested years, not null"
  {:arglists (quote (["java.time.Period" "int"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^int years]
   (.withYears this years)))

(defn normalized
  "Returns a copy of this period with the years and months normalized.

 This normalizes the years and months units, leaving the days unit unchanged.
 The months unit is adjusted to have an absolute value less than 11,
 with the years unit being adjusted to compensate. For example, a period of
 \"1 Year and 15 months\" will be normalized to \"2 years and 3 months\".

 The sign of the years and months units will be the same after normalization.
 For example, a period of \"1 year and -25 months\" will be normalized to
 \"-1 year and -1 month\".

 This instance is immutable and unaffected by this method call.

 @return a {@code Period} based on this period with excess months normalized to years, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this] (.normalized this)))

(defn with-months
  "Returns a copy of this period with the specified amount of months.

 This sets the amount of the months unit in a copy of this period.
 The years and days units are unaffected.

 The months unit is not automatically normalized with the years unit.
 This means that a period of \"15 months\" is different to a period
 of \"1 year and 3 months\".

 This instance is immutable and unaffected by this method call.

 @param months  the months to represent, may be negative
 @return a {@code Period} based on this period with the requested months, not null"
  {:arglists (quote (["java.time.Period" "int"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^int months]
   (.withMonths this months)))

(defn between
  "Obtains a {@code Period} consisting of the number of years, months,
 and days between two dates.

 The start date is included, but the end date is not.
 The period is calculated by removing complete months, then calculating
 the remaining number of days, adjusting to ensure that both have the same sign.
 The number of months is then split into years and months based on a 12 month year.
 A month is considered if the end day-of-month is greater than or equal to the start day-of-month.
 For example, from {@code 2010-01-15} to {@code 2011-03-18} is one year, two months and three days.

 The result of this method can be a negative period if the end is before the start.
 The negative sign will be the same in each of year, month and day.

 @param startDateInclusive  the start date, inclusive, not null
 @param endDateExclusive  the end date, exclusive, not null
 @return the period between this date and the end date, not null
 @see ChronoLocalDate#until(ChronoLocalDate)"
  {:arglists (quote (["java.time.LocalDate" "java.time.LocalDate"]))}
  (^js/JSJoda.Period
   [^js/JSJoda.LocalDate start-date-inclusive
    ^js/JSJoda.LocalDate end-date-exclusive]
   (js-invoke java.time.Period
              "between"
              start-date-inclusive
              end-date-exclusive)))

(defn from
  "Obtains an instance of {@code Period} from a temporal amount.

 This obtains a period based on the specified amount.
 A {@code TemporalAmount} represents an  amount of time, which may be
 date-based or time-based, which this factory extracts to a {@code Period}.

 The conversion loops around the set of units from the amount and uses
 the {@link ChronoUnit#YEARS YEARS}, {@link ChronoUnit#MONTHS MONTHS}
 and {@link ChronoUnit#DAYS DAYS} units to create a period.
 If any other units are found then an exception is thrown.

 If the amount is a {@code ChronoPeriod} then it must use the ISO chronology.

 @param amount  the temporal amount to convert, not null
 @return the equivalent period, not null
 @throws DateTimeException if unable to convert to a {@code Period}
 @throws ArithmeticException if the amount of years, months or days exceeds an int"
  {:arglists (quote (["java.time.temporal.TemporalAmount"]))}
  (^js/JSJoda.Period [^js/JSJoda.TemporalAmount amount]
   (js-invoke java.time.Period "from" amount)))

(defn minus-years
  "Returns a copy of this period with the specified years subtracted.

 This subtracts the amount from the years unit in a copy of this period.
 The months and days units are unaffected.
 For example, \"1 year, 6 months and 3 days\" minus 2 years returns \"-1 years, 6 months and 3 days\".

 This instance is immutable and unaffected by this method call.

 @param yearsToSubtract  the years to subtract, positive or negative
 @return a {@code Period} based on this period with the specified years subtracted, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "long"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^long years-to-subtract]
   (.minusYears this years-to-subtract)))

(defn get-chronology
  "Gets the chronology of this period, which is the ISO calendar system.

 The {@code Chronology} represents the calendar system in use.
 The ISO-8601 calendar system is the modern civil calendar system used today
 in most of the world. It is equivalent to the proleptic Gregorian calendar
 system, in which today's rules for leap years are applied for all time.

 @return the ISO chronology, not null"
  {:arglists (quote (["java.time.Period"]))}
  (^js/JSJoda.IsoChronology [^js/JSJoda.Period this] (.chronology this)))

(defn parse
  "Obtains a {@code Period} from a text string such as {@code PnYnMnD}.

 This will parse the string produced by {@code toString()} which is
 based on the ISO-8601 period formats {@code PnYnMnD} and {@code PnW}.

 The string starts with an optional sign, denoted by the ASCII negative
 or positive symbol. If negative, the whole period is negated.
 The ASCII letter \"P\" is next in upper or lower case.
 There are then four sections, each consisting of a number and a suffix.
 At least one of the four sections must be present.
 The sections have suffixes in ASCII of \"Y\", \"M\", \"W\" and \"D\" for
 years, months, weeks and days, accepted in upper or lower case.
 The suffixes must occur in order.
 The number part of each section must consist of ASCII digits.
 The number may be prefixed by the ASCII negative or positive symbol.
 The number must parse to an {@code int}.

 The leading plus/minus sign, and negative values for other units are
 not part of the ISO-8601 standard. In addition, ISO-8601 does not
 permit mixing between the {@code PnYnMnD} and {@code PnW} formats.
 Any week-based input is multiplied by 7 and treated as a number of days.

 For example, the following are valid inputs:
 <pre>
   \"P2Y\"             -- Period.ofYears(2)
   \"P3M\"             -- Period.ofMonths(3)
   \"P4W\"             -- Period.ofWeeks(4)
   \"P5D\"             -- Period.ofDays(5)
   \"P1Y2M3D\"         -- Period.of(1, 2, 3)
   \"P1Y2M3W4D\"       -- Period.of(1, 2, 25)
   \"P-1Y2M\"          -- Period.of(-1, 2, 0)
   \"-P1Y2M\"          -- Period.of(-1, -2, 0)
 </pre>

 @param text  the text to parse, not null
 @return the parsed period, not null
 @throws DateTimeParseException if the text cannot be parsed to a period"
  {:arglists (quote (["java.lang.CharSequence"]))}
  (^js/JSJoda.Period [^java.lang.CharSequence text]
   (js-invoke java.time.Period "parse" text)))

(defn hash-code
  "A hash code for this period.

 @return a suitable hash code"
  {:arglists (quote (["java.time.Period"]))}
  (^int [^js/JSJoda.Period this] (.hashCode this)))

(defn subtract-from
  "Subtracts this period from the specified temporal object.

 This returns a temporal object of the same observable type as the input
 with this period subtracted.
 If the temporal has a chronology, it must be the ISO chronology.

 In most cases, it is clearer to reverse the calling pattern by using
 {@link Temporal#minus(TemporalAmount)}.
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   dateTime = thisPeriod.subtractFrom(dateTime);
   dateTime = dateTime.minus(thisPeriod);
 </pre>

 The calculation operates as follows.
 First, the chronology of the temporal is checked to ensure it is ISO chronology or null.
 Second, if the months are zero, the years are subtracted if non-zero, otherwise
 the combination of years and months is subtracted if non-zero.
 Finally, any days are subtracted.

 This approach ensures that a partial period can be subtracted from a partial date.
 For example, a period of years and/or months can be subtracted from a {@code YearMonth},
 but a period including days cannot.
 The approach also subtracts years and months together when necessary, which ensures
 correct behaviour at the end of the month.

 This instance is immutable and unaffected by this method call.

 @param temporal  the temporal object to adjust, not null
 @return an object of the same type with the adjustment made, not null
 @throws DateTimeException if unable to subtract
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Temporal [^js/JSJoda.Period this ^js/JSJoda.Temporal temporal]
   (.subtractFrom this temporal)))

(defn get
  "Gets the value of the requested unit.

 This returns a value for each of the three supported units,
 {@link ChronoUnit#YEARS YEARS}, {@link ChronoUnit#MONTHS MONTHS} and
 {@link ChronoUnit#DAYS DAYS}.
 All other units throw an exception.

 @param unit the {@code TemporalUnit} for which to return the value
 @return the long value of the unit
 @throws DateTimeException if the unit is not supported
 @throws UnsupportedTemporalTypeException if the unit is not supported"
  {:arglists (quote (["java.time.Period" "java.time.temporal.TemporalUnit"]))}
  (^long [^js/JSJoda.Period this ^js/JSJoda.TemporalUnit unit]
   (.get this unit)))

(defn equals
  "Checks if this period is equal to another period.

 The comparison is based on the type {@code Period} and each of the three amounts.
 To be equal, the years, months and days units must be individually equal.
 Note that this means that a period of \"15 Months\" is not equal to a period
 of \"1 Year and 3 Months\".

 @param obj  the object to check, null returns false
 @return true if this is equal to the other period"
  {:arglists (quote (["java.time.Period" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.Period this ^java.lang.Object obj] (.equals this obj)))

(defn plus-years
  "Returns a copy of this period with the specified years added.

 This adds the amount to the years unit in a copy of this period.
 The months and days units are unaffected.
 For example, \"1 year, 6 months and 3 days\" plus 2 years returns \"3 years, 6 months and 3 days\".

 This instance is immutable and unaffected by this method call.

 @param yearsToAdd  the years to add, positive or negative
 @return a {@code Period} based on this period with the specified years added, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "long"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^long years-to-add]
   (.plusYears this years-to-add)))

(defn minus-days
  "Returns a copy of this period with the specified days subtracted.

 This subtracts the amount from the days unit in a copy of this period.
 The years and months units are unaffected.
 For example, \"1 year, 6 months and 3 days\" minus 2 days returns \"1 year, 6 months and 1 day\".

 This instance is immutable and unaffected by this method call.

 @param daysToSubtract  the months to subtract, positive or negative
 @return a {@code Period} based on this period with the specified days subtracted, not null
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "long"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^long days-to-subtract]
   (.minusDays this days-to-subtract)))
