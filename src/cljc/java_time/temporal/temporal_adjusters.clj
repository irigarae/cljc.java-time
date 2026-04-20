(ns cljc.java-time.temporal.temporal-adjusters
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time.temporal TemporalAdjusters]))

(defn next
  "Returns the next day-of-week adjuster, which adjusts the date to the
 first occurrence of the specified day-of-week after the date being adjusted.

 The ISO calendar system behaves as follows:<br>
 The input 2011-01-15 (a Saturday) for parameter (MONDAY) will return 2011-01-17 (two days later).<br>
 The input 2011-01-15 (a Saturday) for parameter (WEDNESDAY) will return 2011-01-19 (four days later).<br>
 The input 2011-01-15 (a Saturday) for parameter (SATURDAY) will return 2011-01-22 (seven days later).

 The behavior is suitable for use with most calendar systems.
 It uses the {@code DAY_OF_WEEK} field and the {@code DAYS} unit,
 and assumes a seven day week.

 @param dayOfWeek  the day-of-week to move the date to, not null
 @return the next day-of-week adjuster, not null"
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^java.time.temporal.TemporalAdjuster [^java.time.DayOfWeek day-of-week]
   (java.time.temporal.TemporalAdjusters/next day-of-week)))

(defn next-or-same
  "Returns the next-or-same day-of-week adjuster, which adjusts the date to the
 first occurrence of the specified day-of-week after the date being adjusted
 unless it is already on that day in which case the same object is returned.

 The ISO calendar system behaves as follows:<br>
 The input 2011-01-15 (a Saturday) for parameter (MONDAY) will return 2011-01-17 (two days later).<br>
 The input 2011-01-15 (a Saturday) for parameter (WEDNESDAY) will return 2011-01-19 (four days later).<br>
 The input 2011-01-15 (a Saturday) for parameter (SATURDAY) will return 2011-01-15 (same as input).

 The behavior is suitable for use with most calendar systems.
 It uses the {@code DAY_OF_WEEK} field and the {@code DAYS} unit,
 and assumes a seven day week.

 @param dayOfWeek  the day-of-week to check for or move the date to, not null
 @return the next-or-same day-of-week adjuster, not null"
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^java.time.temporal.TemporalAdjuster [^java.time.DayOfWeek day-of-week]
   (java.time.temporal.TemporalAdjusters/nextOrSame day-of-week)))

(defn first-day-of-next-month
  "Returns the \"first day of next month\" adjuster, which returns a new date set to
 the first day of the next month.

 The ISO calendar system behaves as follows:<br>
 The input 2011-01-15 will return 2011-02-01.<br>
 The input 2011-02-15 will return 2011-03-01.

 The behavior is suitable for use with most calendar systems.
 It is equivalent to:
 <pre>
  temporal.with(DAY_OF_MONTH, 1).plus(1, MONTHS);
 </pre>

 @return the first day of next month adjuster, not null"
  {:arglists (quote ([]))}
  (^java.time.temporal.TemporalAdjuster []
   (java.time.temporal.TemporalAdjusters/firstDayOfNextMonth)))

(defn first-day-of-month
  "Returns the \"first day of month\" adjuster, which returns a new date set to
 the first day of the current month.

 The ISO calendar system behaves as follows:<br>
 The input 2011-01-15 will return 2011-01-01.<br>
 The input 2011-02-15 will return 2011-02-01.

 The behavior is suitable for use with most calendar systems.
 It is equivalent to:
 <pre>
  temporal.with(DAY_OF_MONTH, 1);
 </pre>

 @return the first day-of-month adjuster, not null"
  {:arglists (quote ([]))}
  (^java.time.temporal.TemporalAdjuster []
   (java.time.temporal.TemporalAdjusters/firstDayOfMonth)))

(defn first-day-of-year
  "Returns the \"first day of year\" adjuster, which returns a new date set to
 the first day of the current year.

 The ISO calendar system behaves as follows:<br>
 The input 2011-01-15 will return 2011-01-01.<br>
 The input 2011-02-15 will return 2011-01-01.<br>

 The behavior is suitable for use with most calendar systems.
 It is equivalent to:
 <pre>
  temporal.with(DAY_OF_YEAR, 1);
 </pre>

 @return the first day-of-year adjuster, not null"
  {:arglists (quote ([]))}
  (^java.time.temporal.TemporalAdjuster []
   (java.time.temporal.TemporalAdjusters/firstDayOfYear)))

(defn of-date-adjuster
  "Obtains a {@code TemporalAdjuster} that wraps a date adjuster.

 The {@code TemporalAdjuster} is based on the low level {@code Temporal} interface.
 This method allows an adjustment from {@code LocalDate} to {@code LocalDate}
 to be wrapped to match the temporal-based interface.
 This is provided for convenience to make user-written adjusters simpler.

 In general, user-written adjusters should be static constants:
 <pre>{@code
  static TemporalAdjuster TWO_DAYS_LATER =
       TemporalAdjusters.ofDateAdjuster(date -> date.plusDays(2));
 }</pre>

 @param dateBasedAdjuster  the date-based adjuster, not null
 @return the temporal adjuster wrapping on the date adjuster, not null"
  {:arglists (quote (["java.util.function.UnaryOperator"]))}
  (^java.time.temporal.TemporalAdjuster
   [^java.util.function.UnaryOperator date-based-adjuster]
   (java.time.temporal.TemporalAdjusters/ofDateAdjuster date-based-adjuster)))

(defn last-day-of-year
  "Returns the \"last day of year\" adjuster, which returns a new date set to
 the last day of the current year.

 The ISO calendar system behaves as follows:<br>
 The input 2011-01-15 will return 2011-12-31.<br>
 The input 2011-02-15 will return 2011-12-31.<br>

 The behavior is suitable for use with most calendar systems.
 It is equivalent to:
 <pre>
  long lastDay = temporal.range(DAY_OF_YEAR).getMaximum();
  temporal.with(DAY_OF_YEAR, lastDay);
 </pre>

 @return the last day-of-year adjuster, not null"
  {:arglists (quote ([]))}
  (^java.time.temporal.TemporalAdjuster []
   (java.time.temporal.TemporalAdjusters/lastDayOfYear)))

(defn first-in-month
  "Returns the first in month adjuster, which returns a new date
 in the same month with the first matching day-of-week.
 This is used for expressions like 'first Tuesday in March'.

 The ISO calendar system behaves as follows:<br>
 The input 2011-12-15 for (MONDAY) will return 2011-12-05.<br>
 The input 2011-12-15 for (FRIDAY) will return 2011-12-02.<br>

 The behavior is suitable for use with most calendar systems.
 It uses the {@code DAY_OF_WEEK} and {@code DAY_OF_MONTH} fields
 and the {@code DAYS} unit, and assumes a seven day week.

 @param dayOfWeek  the day-of-week, not null
 @return the first in month adjuster, not null"
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^java.time.temporal.TemporalAdjuster [^java.time.DayOfWeek day-of-week]
   (java.time.temporal.TemporalAdjusters/firstInMonth day-of-week)))

(defn previous-or-same
  "Returns the previous-or-same day-of-week adjuster, which adjusts the date to the
 first occurrence of the specified day-of-week before the date being adjusted
 unless it is already on that day in which case the same object is returned.

 The ISO calendar system behaves as follows:<br>
 The input 2011-01-15 (a Saturday) for parameter (MONDAY) will return 2011-01-10 (five days earlier).<br>
 The input 2011-01-15 (a Saturday) for parameter (WEDNESDAY) will return 2011-01-12 (three days earlier).<br>
 The input 2011-01-15 (a Saturday) for parameter (SATURDAY) will return 2011-01-15 (same as input).

 The behavior is suitable for use with most calendar systems.
 It uses the {@code DAY_OF_WEEK} field and the {@code DAYS} unit,
 and assumes a seven day week.

 @param dayOfWeek  the day-of-week to check for or move the date to, not null
 @return the previous-or-same day-of-week adjuster, not null"
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^java.time.temporal.TemporalAdjuster [^java.time.DayOfWeek day-of-week]
   (java.time.temporal.TemporalAdjusters/previousOrSame day-of-week)))

(defn previous
  "Returns the previous day-of-week adjuster, which adjusts the date to the
 first occurrence of the specified day-of-week before the date being adjusted.

 The ISO calendar system behaves as follows:<br>
 The input 2011-01-15 (a Saturday) for parameter (MONDAY) will return 2011-01-10 (five days earlier).<br>
 The input 2011-01-15 (a Saturday) for parameter (WEDNESDAY) will return 2011-01-12 (three days earlier).<br>
 The input 2011-01-15 (a Saturday) for parameter (SATURDAY) will return 2011-01-08 (seven days earlier).

 The behavior is suitable for use with most calendar systems.
 It uses the {@code DAY_OF_WEEK} field and the {@code DAYS} unit,
 and assumes a seven day week.

 @param dayOfWeek  the day-of-week to move the date to, not null
 @return the previous day-of-week adjuster, not null"
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^java.time.temporal.TemporalAdjuster [^java.time.DayOfWeek day-of-week]
   (java.time.temporal.TemporalAdjusters/previous day-of-week)))

(defn last-day-of-month
  "Returns the \"last day of month\" adjuster, which returns a new date set to
 the last day of the current month.

 The ISO calendar system behaves as follows:<br>
 The input 2011-01-15 will return 2011-01-31.<br>
 The input 2011-02-15 will return 2011-02-28.<br>
 The input 2012-02-15 will return 2012-02-29 (leap year).<br>
 The input 2011-04-15 will return 2011-04-30.

 The behavior is suitable for use with most calendar systems.
 It is equivalent to:
 <pre>
  long lastDay = temporal.range(DAY_OF_MONTH).getMaximum();
  temporal.with(DAY_OF_MONTH, lastDay);
 </pre>

 @return the last day-of-month adjuster, not null"
  {:arglists (quote ([]))}
  (^java.time.temporal.TemporalAdjuster []
   (java.time.temporal.TemporalAdjusters/lastDayOfMonth)))

(defn last-in-month
  "Returns the last in month adjuster, which returns a new date
 in the same month with the last matching day-of-week.
 This is used for expressions like 'last Tuesday in March'.

 The ISO calendar system behaves as follows:<br>
 The input 2011-12-15 for (MONDAY) will return 2011-12-26.<br>
 The input 2011-12-15 for (FRIDAY) will return 2011-12-30.<br>

 The behavior is suitable for use with most calendar systems.
 It uses the {@code DAY_OF_WEEK} and {@code DAY_OF_MONTH} fields
 and the {@code DAYS} unit, and assumes a seven day week.

 @param dayOfWeek  the day-of-week, not null
 @return the first in month adjuster, not null"
  {:arglists (quote (["java.time.DayOfWeek"]))}
  (^java.time.temporal.TemporalAdjuster [^java.time.DayOfWeek day-of-week]
   (java.time.temporal.TemporalAdjusters/lastInMonth day-of-week)))

(defn first-day-of-next-year
  "Returns the \"first day of next year\" adjuster, which returns a new date set to
 the first day of the next year.

 The ISO calendar system behaves as follows:<br>
 The input 2011-01-15 will return 2012-01-01.

 The behavior is suitable for use with most calendar systems.
 It is equivalent to:
 <pre>
  temporal.with(DAY_OF_YEAR, 1).plus(1, YEARS);
 </pre>

 @return the first day of next month adjuster, not null"
  {:arglists (quote ([]))}
  (^java.time.temporal.TemporalAdjuster []
   (java.time.temporal.TemporalAdjusters/firstDayOfNextYear)))

(defn day-of-week-in-month
  "Returns the day-of-week in month adjuster, which returns a new date
 in the same month with the ordinal day-of-week.
 This is used for expressions like the 'second Tuesday in March'.

 The ISO calendar system behaves as follows:<br>
 The input 2011-12-15 for (1,TUESDAY) will return 2011-12-06.<br>
 The input 2011-12-15 for (2,TUESDAY) will return 2011-12-13.<br>
 The input 2011-12-15 for (3,TUESDAY) will return 2011-12-20.<br>
 The input 2011-12-15 for (4,TUESDAY) will return 2011-12-27.<br>
 The input 2011-12-15 for (5,TUESDAY) will return 2012-01-03.<br>
 The input 2011-12-15 for (-1,TUESDAY) will return 2011-12-27 (last in month).<br>
 The input 2011-12-15 for (-4,TUESDAY) will return 2011-12-06 (3 weeks before last in month).<br>
 The input 2011-12-15 for (-5,TUESDAY) will return 2011-11-29 (4 weeks before last in month).<br>
 The input 2011-12-15 for (0,TUESDAY) will return 2011-11-29 (last in previous month).<br>

 For a positive or zero ordinal, the algorithm is equivalent to finding the first
 day-of-week that matches within the month and then adding a number of weeks to it.
 For a negative ordinal, the algorithm is equivalent to finding the last
 day-of-week that matches within the month and then subtracting a number of weeks to it.
 The ordinal number of weeks is not validated and is interpreted leniently
 according to this algorithm. This definition means that an ordinal of zero finds
 the last matching day-of-week in the previous month.

 The behavior is suitable for use with most calendar systems.
 It uses the {@code DAY_OF_WEEK} and {@code DAY_OF_MONTH} fields
 and the {@code DAYS} unit, and assumes a seven day week.

 @param ordinal  the week within the month, unbounded but typically from -5 to 5
 @param dayOfWeek  the day-of-week, not null
 @return the day-of-week in month adjuster, not null"
  {:arglists (quote (["int" "java.time.DayOfWeek"]))}
  (^java.time.temporal.TemporalAdjuster
   [^java.lang.Integer ordinal ^java.time.DayOfWeek day-of-week]
   (java.time.temporal.TemporalAdjusters/dayOfWeekInMonth ordinal day-of-week)))
