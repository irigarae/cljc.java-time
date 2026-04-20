(ns cljc.java-time.period
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [Period]]))

(def zero (goog.object/get java.time.Period "ZERO"))

(defn get-months
  "Gets the amount of months of this period.\n <p>\n This returns the months unit.\n <p>\n The months unit is not automatically normalized with the years unit.\n This means that a period of \"15 months\" is different to a period\n of \"1 year and 3 months\".\n\n @return the amount of months of this period, may be negative"
  {:arglists (quote (["java.time.Period"]))}
  (^int [^js/JSJoda.Period this] (.months this)))

(defn of-weeks
  "Obtains a {@code Period} representing a number of weeks.\n <p>\n The resulting period will be day-based, with the amount of days\n equal to the number of weeks multiplied by 7.\n The years and months units will be zero.\n\n @param weeks  the number of weeks, positive or negative\n @return the period, with the input weeks converted to days, not null"
  {:arglists (quote (["int"]))}
  (^js/JSJoda.Period [^int weeks] (js-invoke java.time.Period "ofWeeks" weeks)))

(defn of-days
  "Obtains a {@code Period} representing a number of days.\n <p>\n The resulting period will have the specified days.\n The years and months units will be zero.\n\n @param days  the number of days, positive or negative\n @return the period of days, not null"
  {:arglists (quote (["int"]))}
  (^js/JSJoda.Period [^int days] (js-invoke java.time.Period "ofDays" days)))

(defn is-negative
  "Checks if any of the three units of this period are negative.\n <p>\n This checks whether the years, months or days units are less than zero.\n\n @return true if any unit of this period is negative"
  {:arglists (quote (["java.time.Period"]))}
  (^boolean [^js/JSJoda.Period this] (.isNegative this)))

(defn of
  "Obtains a {@code Period} representing a number of years, months and days.\n <p>\n This creates an instance based on years, months and days.\n\n @param years  the amount of years, may be negative\n @param months  the amount of months, may be negative\n @param days  the amount of days, may be negative\n @return the period of years, months and days, not null"
  {:arglists (quote (["int" "int" "int"]))}
  (^js/JSJoda.Period [^int years ^int months ^int days]
   (js-invoke java.time.Period "of" years months days)))

(defn is-zero
  "Checks if all three units of this period are zero.\n <p>\n A zero period has the value zero for the years, months and days units.\n\n @return true if this period is zero-length"
  {:arglists (quote (["java.time.Period"]))}
  (^boolean [^js/JSJoda.Period this] (.isZero this)))

(defn multiplied-by
  "Returns a new instance with each element in this period multiplied\n by the specified scalar.\n <p>\n This returns a period with each of the years, months and days units\n individually multiplied.\n For example, a period of \"2 years, -3 months and 4 days\" multiplied by\n 3 will return \"6 years, -9 months and 12 days\".\n No normalization is performed.\n\n @param scalar  the scalar to multiply by, not null\n @return a {@code Period} based on this period with the amounts multiplied by the scalar, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "int"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^int scalar]
   (.multipliedBy this scalar)))

(defn get-units
  "Gets the set of units supported by this period.\n <p>\n The supported units are {@link ChronoUnit#YEARS YEARS},\n {@link ChronoUnit#MONTHS MONTHS} and {@link ChronoUnit#DAYS DAYS}.\n They are returned in the order years, months, days.\n <p>\n This set can be used in conjunction with {@link #get(TemporalUnit)}\n to access the entire state of the period.\n\n @return a list containing the years, months and days units, not null"
  {:arglists (quote (["java.time.Period"]))}
  (^java.util.List [^js/JSJoda.Period this] (.units this)))

(defn with-days
  "Returns a copy of this period with the specified amount of days.\n <p>\n This sets the amount of the days unit in a copy of this period.\n The years and months units are unaffected.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param days  the days to represent, may be negative\n @return a {@code Period} based on this period with the requested days, not null"
  {:arglists (quote (["java.time.Period" "int"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^int days] (.withDays this days)))

(defn plus
  "Returns a copy of this period with the specified period added.\n <p>\n This operates separately on the years, months and days.\n No normalization is performed.\n <p>\n For example, \"1 year, 6 months and 3 days\" plus \"2 years, 2 months and 2 days\"\n returns \"3 years, 8 months and 5 days\".\n <p>\n The specified amount is typically an instance of {@code Period}.\n Other types are interpreted using {@link Period#from(TemporalAmount)}.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param amountToAdd  the amount to add, not null\n @return a {@code Period} based on this period with the requested period added, not null\n @throws DateTimeException if the specified amount has a non-ISO chronology or\n  contains an invalid unit\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "java.time.temporal.TemporalAmount"]))}
  (^js/JSJoda.Period
   [^js/JSJoda.Period this ^js/JSJoda.TemporalAmount amount-to-add]
   (.plus this amount-to-add)))

(defn of-months
  "Obtains a {@code Period} representing a number of months.\n <p>\n The resulting period will have the specified months.\n The years and days units will be zero.\n\n @param months  the number of months, positive or negative\n @return the period of months, not null"
  {:arglists (quote (["int"]))}
  (^js/JSJoda.Period [^int months]
   (js-invoke java.time.Period "ofMonths" months)))

(defn to-string
  "Outputs this period as a {@code String}, such as {@code P6Y3M1D}.\n <p>\n The output will be in the ISO-8601 period format.\n A zero period will be represented as zero days, 'P0D'.\n\n @return a string representation of this period, not null"
  {:arglists (quote (["java.time.Period"]))}
  (^java.lang.String [^js/JSJoda.Period this] (.toString this)))

(defn plus-months
  "Returns a copy of this period with the specified months added.\n <p>\n This adds the amount to the months unit in a copy of this period.\n The years and days units are unaffected.\n For example, \"1 year, 6 months and 3 days\" plus 2 months returns \"1 year, 8 months and 3 days\".\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param monthsToAdd  the months to add, positive or negative\n @return a {@code Period} based on this period with the specified months added, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "long"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^long months-to-add]
   (.plusMonths this months-to-add)))

(defn minus-months
  "Returns a copy of this period with the specified months subtracted.\n <p>\n This subtracts the amount from the months unit in a copy of this period.\n The years and days units are unaffected.\n For example, \"1 year, 6 months and 3 days\" minus 2 months returns \"1 year, 4 months and 3 days\".\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param monthsToSubtract  the years to subtract, positive or negative\n @return a {@code Period} based on this period with the specified months subtracted, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "long"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^long months-to-subtract]
   (.minusMonths this months-to-subtract)))

(defn minus
  "Returns a copy of this period with the specified period subtracted.\n <p>\n This operates separately on the years, months and days.\n No normalization is performed.\n <p>\n For example, \"1 year, 6 months and 3 days\" minus \"2 years, 2 months and 2 days\"\n returns \"-1 years, 4 months and 1 day\".\n <p>\n The specified amount is typically an instance of {@code Period}.\n Other types are interpreted using {@link Period#from(TemporalAmount)}.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param amountToSubtract  the amount to subtract, not null\n @return a {@code Period} based on this period with the requested period subtracted, not null\n @throws DateTimeException if the specified amount has a non-ISO chronology or\n  contains an invalid unit\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "java.time.temporal.TemporalAmount"]))}
  (^js/JSJoda.Period
   [^js/JSJoda.Period this ^js/JSJoda.TemporalAmount amount-to-subtract]
   (.minus this amount-to-subtract)))

(defn add-to
  "Adds this period to the specified temporal object.\n <p>\n This returns a temporal object of the same observable type as the input\n with this period added.\n If the temporal has a chronology, it must be the ISO chronology.\n <p>\n In most cases, it is clearer to reverse the calling pattern by using\n {@link Temporal#plus(TemporalAmount)}.\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   dateTime = thisPeriod.addTo(dateTime);\n   dateTime = dateTime.plus(thisPeriod);\n </pre>\n <p>\n The calculation operates as follows.\n First, the chronology of the temporal is checked to ensure it is ISO chronology or null.\n Second, if the months are zero, the years are added if non-zero, otherwise\n the combination of years and months is added if non-zero.\n Finally, any days are added.\n <p>\n This approach ensures that a partial period can be added to a partial date.\n For example, a period of years and/or months can be added to a {@code YearMonth},\n but a period including days cannot.\n The approach also adds years and months together when necessary, which ensures\n correct behaviour at the end of the month.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param temporal  the temporal object to adjust, not null\n @return an object of the same type with the adjustment made, not null\n @throws DateTimeException if unable to add\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Temporal [^js/JSJoda.Period this ^js/JSJoda.Temporal temporal]
   (.addTo this temporal)))

(defn to-total-months
  "Gets the total number of months in this period.\n <p>\n This returns the total number of months in the period by multiplying the\n number of years by 12 and adding the number of months.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @return the total number of months in the period, may be negative"
  {:arglists (quote (["java.time.Period"]))}
  (^long [^js/JSJoda.Period this] (.toTotalMonths this)))

(defn plus-days
  "Returns a copy of this period with the specified days added.\n <p>\n This adds the amount to the days unit in a copy of this period.\n The years and months units are unaffected.\n For example, \"1 year, 6 months and 3 days\" plus 2 days returns \"1 year, 6 months and 5 days\".\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param daysToAdd  the days to add, positive or negative\n @return a {@code Period} based on this period with the specified days added, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "long"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^long days-to-add]
   (.plusDays this days-to-add)))

(defn of-years
  "Obtains a {@code Period} representing a number of years.\n <p>\n The resulting period will have the specified years.\n The months and days units will be zero.\n\n @param years  the number of years, positive or negative\n @return the period of years, not null"
  {:arglists (quote (["int"]))}
  (^js/JSJoda.Period [^int years] (js-invoke java.time.Period "ofYears" years)))

(defn get-days
  "Gets the amount of days of this period.\n <p>\n This returns the days unit.\n\n @return the amount of days of this period, may be negative"
  {:arglists (quote (["java.time.Period"]))}
  (^int [^js/JSJoda.Period this] (.days this)))

(defn negated
  "Returns a new instance with each amount in this period negated.\n <p>\n This returns a period with each of the years, months and days units\n individually negated.\n For example, a period of \"2 years, -3 months and 4 days\" will be\n negated to \"-2 years, 3 months and -4 days\".\n No normalization is performed.\n\n @return a {@code Period} based on this period with the amounts negated, not null\n @throws ArithmeticException if numeric overflow occurs, which only happens if\n  one of the units has the value {@code Long.MIN_VALUE}"
  {:arglists (quote (["java.time.Period"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this] (.negated this)))

(defn get-years
  "Gets the amount of years of this period.\n <p>\n This returns the years unit.\n <p>\n The months unit is not automatically normalized with the years unit.\n This means that a period of \"15 months\" is different to a period\n of \"1 year and 3 months\".\n\n @return the amount of years of this period, may be negative"
  {:arglists (quote (["java.time.Period"]))}
  (^int [^js/JSJoda.Period this] (.years this)))

(defn with-years
  "Returns a copy of this period with the specified amount of years.\n <p>\n This sets the amount of the years unit in a copy of this period.\n The months and days units are unaffected.\n <p>\n The months unit is not automatically normalized with the years unit.\n This means that a period of \"15 months\" is different to a period\n of \"1 year and 3 months\".\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param years  the years to represent, may be negative\n @return a {@code Period} based on this period with the requested years, not null"
  {:arglists (quote (["java.time.Period" "int"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^int years]
   (.withYears this years)))

(defn normalized
  "Returns a copy of this period with the years and months normalized.\n <p>\n This normalizes the years and months units, leaving the days unit unchanged.\n The months unit is adjusted to have an absolute value less than 11,\n with the years unit being adjusted to compensate. For example, a period of\n \"1 Year and 15 months\" will be normalized to \"2 years and 3 months\".\n <p>\n The sign of the years and months units will be the same after normalization.\n For example, a period of \"1 year and -25 months\" will be normalized to\n \"-1 year and -1 month\".\n <p>\n This instance is immutable and unaffected by this method call.\n\n @return a {@code Period} based on this period with excess months normalized to years, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this] (.normalized this)))

(defn with-months
  "Returns a copy of this period with the specified amount of months.\n <p>\n This sets the amount of the months unit in a copy of this period.\n The years and days units are unaffected.\n <p>\n The months unit is not automatically normalized with the years unit.\n This means that a period of \"15 months\" is different to a period\n of \"1 year and 3 months\".\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param months  the months to represent, may be negative\n @return a {@code Period} based on this period with the requested months, not null"
  {:arglists (quote (["java.time.Period" "int"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^int months]
   (.withMonths this months)))

(defn between
  "Obtains a {@code Period} consisting of the number of years, months,\n and days between two dates.\n <p>\n The start date is included, but the end date is not.\n The period is calculated by removing complete months, then calculating\n the remaining number of days, adjusting to ensure that both have the same sign.\n The number of months is then split into years and months based on a 12 month year.\n A month is considered if the end day-of-month is greater than or equal to the start day-of-month.\n For example, from {@code 2010-01-15} to {@code 2011-03-18} is one year, two months and three days.\n <p>\n The result of this method can be a negative period if the end is before the start.\n The negative sign will be the same in each of year, month and day.\n\n @param startDateInclusive  the start date, inclusive, not null\n @param endDateExclusive  the end date, exclusive, not null\n @return the period between this date and the end date, not null\n @see ChronoLocalDate#until(ChronoLocalDate)"
  {:arglists (quote (["java.time.LocalDate" "java.time.LocalDate"]))}
  (^js/JSJoda.Period
   [^js/JSJoda.LocalDate start-date-inclusive
    ^js/JSJoda.LocalDate end-date-exclusive]
   (js-invoke java.time.Period
              "between"
              start-date-inclusive
              end-date-exclusive)))

(defn from
  "Obtains an instance of {@code Period} from a temporal amount.\n <p>\n This obtains a period based on the specified amount.\n A {@code TemporalAmount} represents an  amount of time, which may be\n date-based or time-based, which this factory extracts to a {@code Period}.\n <p>\n The conversion loops around the set of units from the amount and uses\n the {@link ChronoUnit#YEARS YEARS}, {@link ChronoUnit#MONTHS MONTHS}\n and {@link ChronoUnit#DAYS DAYS} units to create a period.\n If any other units are found then an exception is thrown.\n <p>\n If the amount is a {@code ChronoPeriod} then it must use the ISO chronology.\n\n @param amount  the temporal amount to convert, not null\n @return the equivalent period, not null\n @throws DateTimeException if unable to convert to a {@code Period}\n @throws ArithmeticException if the amount of years, months or days exceeds an int"
  {:arglists (quote (["java.time.temporal.TemporalAmount"]))}
  (^js/JSJoda.Period [^js/JSJoda.TemporalAmount amount]
   (js-invoke java.time.Period "from" amount)))

(defn minus-years
  "Returns a copy of this period with the specified years subtracted.\n <p>\n This subtracts the amount from the years unit in a copy of this period.\n The months and days units are unaffected.\n For example, \"1 year, 6 months and 3 days\" minus 2 years returns \"-1 years, 6 months and 3 days\".\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param yearsToSubtract  the years to subtract, positive or negative\n @return a {@code Period} based on this period with the specified years subtracted, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "long"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^long years-to-subtract]
   (.minusYears this years-to-subtract)))

(defn get-chronology
  "Gets the chronology of this period, which is the ISO calendar system.\n <p>\n The {@code Chronology} represents the calendar system in use.\n The ISO-8601 calendar system is the modern civil calendar system used today\n in most of the world. It is equivalent to the proleptic Gregorian calendar\n system, in which today's rules for leap years are applied for all time.\n\n @return the ISO chronology, not null"
  {:arglists (quote (["java.time.Period"]))}
  (^js/JSJoda.IsoChronology [^js/JSJoda.Period this] (.chronology this)))

(defn parse
  "Obtains a {@code Period} from a text string such as {@code PnYnMnD}.\n <p>\n This will parse the string produced by {@code toString()} which is\n based on the ISO-8601 period formats {@code PnYnMnD} and {@code PnW}.\n <p>\n The string starts with an optional sign, denoted by the ASCII negative\n or positive symbol. If negative, the whole period is negated.\n The ASCII letter \"P\" is next in upper or lower case.\n There are then four sections, each consisting of a number and a suffix.\n At least one of the four sections must be present.\n The sections have suffixes in ASCII of \"Y\", \"M\", \"W\" and \"D\" for\n years, months, weeks and days, accepted in upper or lower case.\n The suffixes must occur in order.\n The number part of each section must consist of ASCII digits.\n The number may be prefixed by the ASCII negative or positive symbol.\n The number must parse to an {@code int}.\n <p>\n The leading plus/minus sign, and negative values for other units are\n not part of the ISO-8601 standard. In addition, ISO-8601 does not\n permit mixing between the {@code PnYnMnD} and {@code PnW} formats.\n Any week-based input is multiplied by 7 and treated as a number of days.\n <p>\n For example, the following are valid inputs:\n <pre>\n   \"P2Y\"             -- Period.ofYears(2)\n   \"P3M\"             -- Period.ofMonths(3)\n   \"P4W\"             -- Period.ofWeeks(4)\n   \"P5D\"             -- Period.ofDays(5)\n   \"P1Y2M3D\"         -- Period.of(1, 2, 3)\n   \"P1Y2M3W4D\"       -- Period.of(1, 2, 25)\n   \"P-1Y2M\"          -- Period.of(-1, 2, 0)\n   \"-P1Y2M\"          -- Period.of(-1, -2, 0)\n </pre>\n\n @param text  the text to parse, not null\n @return the parsed period, not null\n @throws DateTimeParseException if the text cannot be parsed to a period"
  {:arglists (quote (["java.lang.CharSequence"]))}
  (^js/JSJoda.Period [^java.lang.CharSequence text]
   (js-invoke java.time.Period "parse" text)))

(defn hash-code
  "A hash code for this period.\n\n @return a suitable hash code"
  {:arglists (quote (["java.time.Period"]))}
  (^int [^js/JSJoda.Period this] (.hashCode this)))

(defn subtract-from
  "Subtracts this period from the specified temporal object.\n <p>\n This returns a temporal object of the same observable type as the input\n with this period subtracted.\n If the temporal has a chronology, it must be the ISO chronology.\n <p>\n In most cases, it is clearer to reverse the calling pattern by using\n {@link Temporal#minus(TemporalAmount)}.\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   dateTime = thisPeriod.subtractFrom(dateTime);\n   dateTime = dateTime.minus(thisPeriod);\n </pre>\n <p>\n The calculation operates as follows.\n First, the chronology of the temporal is checked to ensure it is ISO chronology or null.\n Second, if the months are zero, the years are subtracted if non-zero, otherwise\n the combination of years and months is subtracted if non-zero.\n Finally, any days are subtracted.\n <p>\n This approach ensures that a partial period can be subtracted from a partial date.\n For example, a period of years and/or months can be subtracted from a {@code YearMonth},\n but a period including days cannot.\n The approach also subtracts years and months together when necessary, which ensures\n correct behaviour at the end of the month.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param temporal  the temporal object to adjust, not null\n @return an object of the same type with the adjustment made, not null\n @throws DateTimeException if unable to subtract\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Temporal [^js/JSJoda.Period this ^js/JSJoda.Temporal temporal]
   (.subtractFrom this temporal)))

(defn get
  "Gets the value of the requested unit.\n <p>\n This returns a value for each of the three supported units,\n {@link ChronoUnit#YEARS YEARS}, {@link ChronoUnit#MONTHS MONTHS} and\n {@link ChronoUnit#DAYS DAYS}.\n All other units throw an exception.\n\n @param unit the {@code TemporalUnit} for which to return the value\n @return the long value of the unit\n @throws DateTimeException if the unit is not supported\n @throws UnsupportedTemporalTypeException if the unit is not supported"
  {:arglists (quote (["java.time.Period" "java.time.temporal.TemporalUnit"]))}
  (^long [^js/JSJoda.Period this ^js/JSJoda.TemporalUnit unit]
   (.get this unit)))

(defn equals
  "Checks if this period is equal to another period.\n <p>\n The comparison is based on the type {@code Period} and each of the three amounts.\n To be equal, the years, months and days units must be individually equal.\n Note that this means that a period of \"15 Months\" is not equal to a period\n of \"1 Year and 3 Months\".\n\n @param obj  the object to check, null returns false\n @return true if this is equal to the other period"
  {:arglists (quote (["java.time.Period" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.Period this ^java.lang.Object obj] (.equals this obj)))

(defn plus-years
  "Returns a copy of this period with the specified years added.\n <p>\n This adds the amount to the years unit in a copy of this period.\n The months and days units are unaffected.\n For example, \"1 year, 6 months and 3 days\" plus 2 years returns \"3 years, 6 months and 3 days\".\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param yearsToAdd  the years to add, positive or negative\n @return a {@code Period} based on this period with the specified years added, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "long"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^long years-to-add]
   (.plusYears this years-to-add)))

(defn minus-days
  "Returns a copy of this period with the specified days subtracted.\n <p>\n This subtracts the amount from the days unit in a copy of this period.\n The years and months units are unaffected.\n For example, \"1 year, 6 months and 3 days\" minus 2 days returns \"1 year, 6 months and 1 day\".\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param daysToSubtract  the months to subtract, positive or negative\n @return a {@code Period} based on this period with the specified days subtracted, not null\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.Period" "long"]))}
  (^js/JSJoda.Period [^js/JSJoda.Period this ^long days-to-subtract]
   (.minusDays this days-to-subtract)))
