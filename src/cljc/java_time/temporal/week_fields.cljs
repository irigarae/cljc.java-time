(ns cljc.java-time.temporal.week-fields
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time.temporal :refer [WeekFields]]))

(def sunday-start
  "The common definition of a week that starts on Sunday and the first week
 has a minimum of 1 day.

 Defined as starting on Sunday and with a minimum of 1 day in the month.
 This week definition is in use in the US and other European countries."
  (goog.object/get java.time.temporal.WeekFields "SUNDAY_START"))

(def iso
  "The ISO-8601 definition, where a week starts on Monday and the first week
 has a minimum of 4 days.

 The ISO-8601 standard defines a calendar system based on weeks.
 It uses the week-based-year and week-of-week-based-year concepts to split
 up the passage of days instead of the standard year/month/day.

 Note that the first week may start in the previous calendar year.
 Note also that the first few days of a calendar year may be in the
 week-based-year corresponding to the previous calendar year."
  (goog.object/get java.time.temporal.WeekFields "ISO"))

(def week-based-years
  "The unit that represents week-based-years for the purpose of addition and subtraction.

 This allows a number of week-based-years to be added to, or subtracted from, a date.
 The unit is equal to either 52 or 53 weeks.
 The estimated duration of a week-based-year is the same as that of a standard ISO
 year at {@code 365.2425 Days}.

 The rules for addition add the number of week-based-years to the existing value
 for the week-based-year field retaining the week-of-week-based-year
 and day-of-week, unless the week number it too large for the target year.
 In that case, the week is set to the last week of the year
 with the same day-of-week.

 This unit is an immutable and thread-safe singleton."
  (goog.object/get java.time.temporal.WeekFields "WEEK_BASED_YEARS"))

(defn day-of-week
  "Returns a field to access the day of week based on this {@code WeekFields}.

 This is similar to {@link ChronoField#DAY_OF_WEEK} but uses values for
 the day-of-week based on this {@code WeekFields}.
 The days are numbered from 1 to 7 where the
 {@link #getFirstDayOfWeek() first day-of-week} is assigned the value 1.

 For example, if the first day-of-week is Sunday, then that will have the
 value 1, with other days ranging from Monday as 2 to Saturday as 7.

 In the resolving phase of parsing, a localized day-of-week will be converted
 to a standardized {@code ChronoField} day-of-week.
 The day-of-week must be in the valid range 1 to 7.
 Other fields in this class build dates using the standardized day-of-week.

 @return a field providing access to the day-of-week with localized numbering, not null"
  {:arglists (quote (["java.time.temporal.WeekFields"]))}
  (^js/JSJoda.TemporalField [^js/JSJoda.WeekFields this] (.dayOfWeek this)))

(defn of
  {:arglists (quote (["java.util.Locale"] ["java.time.DayOfWeek" "int"]))}
  (^js/JSJoda.WeekFields [^java.util.Locale locale]
   (js-invoke java.time.temporal.WeekFields "of" locale))
  (^js/JSJoda.WeekFields
   [^js/JSJoda.DayOfWeek first-day-of-week ^int minimal-days-in-first-week]
   (js-invoke java.time.temporal.WeekFields
              "of"
              first-day-of-week
              minimal-days-in-first-week)))

(defn get-first-day-of-week
  "Gets the first day-of-week.

 The first day-of-week varies by culture.
 For example, the US uses Sunday, while France and the ISO-8601 standard use Monday.
 This method returns the first day using the standard {@code DayOfWeek} enum.

 @return the first day-of-week, not null"
  {:arglists (quote (["java.time.temporal.WeekFields"]))}
  (^js/JSJoda.DayOfWeek [^js/JSJoda.WeekFields this] (.firstDayOfWeek this)))

(defn to-string
  {:arglists (quote (["java.time.temporal.WeekFields"]))}
  (^java.lang.String [^js/JSJoda.WeekFields this] (.toString this)))

(defn week-based-year
  "Returns a field to access the year of a week-based-year based on this {@code WeekFields}.

 This represents the concept of the year where weeks start on a fixed day-of-week,
 such as Monday and each week belongs to exactly one year.
 This field is typically used with {@link WeekFields#dayOfWeek()} and
 {@link WeekFields#weekOfWeekBasedYear()}.

 Week one(1) is the week starting on the {@link WeekFields#getFirstDayOfWeek}
 where there are at least {@link WeekFields#getMinimalDaysInFirstWeek()} days in the year.
 Thus, week one may start before the start of the year.
 If the first week starts after the start of the year then the period before
 is in the last week of the previous year.

 This field can be used with any calendar system.

 In the resolving phase of parsing, a date can be created from a week-based-year,
 week-of-year and day-of-week.

 In {@linkplain ResolverStyle#STRICT strict mode}, all three fields are
 validated against their range of valid values. The week-of-year field
 is validated to ensure that the resulting week-based-year is the
 week-based-year requested.

 In {@linkplain ResolverStyle#SMART smart mode}, all three fields are
 validated against their range of valid values. The week-of-week-based-year field
 is validated from 1 to 53, meaning that the resulting date can be in the
 following week-based-year to that specified.

 In {@linkplain ResolverStyle#LENIENT lenient mode}, the year and day-of-week
 are validated against the range of valid values. The resulting date is calculated
 equivalent to the following three stage approach.
 First, create a date on the first day of the first week in the requested week-based-year.
 Then take the week-of-week-based-year, subtract one, and add the amount in weeks to the date.
 Finally, adjust to the correct day-of-week within the localized week.

 @return a field providing access to the week-based-year, not null"
  {:arglists (quote (["java.time.temporal.WeekFields"]))}
  (^js/JSJoda.TemporalField [^js/JSJoda.WeekFields this] (.weekBasedYear this)))

(defn week-of-year
  "Returns a field to access the week of year based on this {@code WeekFields}.

 This represents the concept of the count of weeks within the year where weeks
 start on a fixed day-of-week, such as Monday.
 This field is typically used with {@link WeekFields#dayOfWeek()}.

 Week one(1) is the week starting on the {@link WeekFields#getFirstDayOfWeek}
 where there are at least {@link WeekFields#getMinimalDaysInFirstWeek()} days in the year.
 Thus, week one may start up to {@code minDays} days before the start of the year.
 If the first week starts after the start of the year then the period before is week zero (0).

 For example:<br>
 - if the 1st day of the year is a Monday, week one starts on the 1st and there is no week zero<br>
 - if the 2nd day of the year is a Monday, week one starts on the 2nd and the 1st is in week zero<br>
 - if the 4th day of the year is a Monday, week one starts on the 4th and the 1st to 3rd is in week zero<br>
 - if the 5th day of the year is a Monday, week two starts on the 5th and the 1st to 4th is in week one<br>

 This field can be used with any calendar system.

 In the resolving phase of parsing, a date can be created from a year,
 week-of-year and day-of-week.

 In {@linkplain ResolverStyle#STRICT strict mode}, all three fields are
 validated against their range of valid values. The week-of-year field
 is validated to ensure that the resulting year is the year requested.

 In {@linkplain ResolverStyle#SMART smart mode}, all three fields are
 validated against their range of valid values. The week-of-year field
 is validated from 0 to 54, meaning that the resulting date can be in a
 different year to that specified.

 In {@linkplain ResolverStyle#LENIENT lenient mode}, the year and day-of-week
 are validated against the range of valid values. The resulting date is calculated
 equivalent to the following three stage approach.
 First, create a date on the first day of the first week in the requested year.
 Then take the week-of-year, subtract one, and add the amount in weeks to the date.
 Finally, adjust to the correct day-of-week within the localized week.

 @return a field providing access to the week-of-year, not null"
  {:arglists (quote (["java.time.temporal.WeekFields"]))}
  (^js/JSJoda.TemporalField [^js/JSJoda.WeekFields this] (.weekOfYear this)))

(defn week-of-week-based-year
  "Returns a field to access the week of a week-based-year based on this {@code WeekFields}.

 This represents the concept of the count of weeks within the year where weeks
 start on a fixed day-of-week, such as Monday and each week belongs to exactly one year.
 This field is typically used with {@link WeekFields#dayOfWeek()} and
 {@link WeekFields#weekBasedYear()}.

 Week one(1) is the week starting on the {@link WeekFields#getFirstDayOfWeek}
 where there are at least {@link WeekFields#getMinimalDaysInFirstWeek()} days in the year.
 If the first week starts after the start of the year then the period before
 is in the last week of the previous year.

 For example:<br>
 - if the 1st day of the year is a Monday, week one starts on the 1st<br>
 - if the 2nd day of the year is a Monday, week one starts on the 2nd and
   the 1st is in the last week of the previous year<br>
 - if the 4th day of the year is a Monday, week one starts on the 4th and
   the 1st to 3rd is in the last week of the previous year<br>
 - if the 5th day of the year is a Monday, week two starts on the 5th and
   the 1st to 4th is in week one<br>

 This field can be used with any calendar system.

 In the resolving phase of parsing, a date can be created from a week-based-year,
 week-of-year and day-of-week.

 In {@linkplain ResolverStyle#STRICT strict mode}, all three fields are
 validated against their range of valid values. The week-of-year field
 is validated to ensure that the resulting week-based-year is the
 week-based-year requested.

 In {@linkplain ResolverStyle#SMART smart mode}, all three fields are
 validated against their range of valid values. The week-of-week-based-year field
 is validated from 1 to 53, meaning that the resulting date can be in the
 following week-based-year to that specified.

 In {@linkplain ResolverStyle#LENIENT lenient mode}, the year and day-of-week
 are validated against the range of valid values. The resulting date is calculated
 equivalent to the following three stage approach.
 First, create a date on the first day of the first week in the requested week-based-year.
 Then take the week-of-week-based-year, subtract one, and add the amount in weeks to the date.
 Finally, adjust to the correct day-of-week within the localized week.

 @return a field providing access to the week-of-week-based-year, not null"
  {:arglists (quote (["java.time.temporal.WeekFields"]))}
  (^js/JSJoda.TemporalField [^js/JSJoda.WeekFields this]
   (.weekOfWeekBasedYear this)))

(defn week-of-month
  "Returns a field to access the week of month based on this {@code WeekFields}.

 This represents the concept of the count of weeks within the month where weeks
 start on a fixed day-of-week, such as Monday.
 This field is typically used with {@link WeekFields#dayOfWeek()}.

 Week one (1) is the week starting on the {@link WeekFields#getFirstDayOfWeek}
 where there are at least {@link WeekFields#getMinimalDaysInFirstWeek()} days in the month.
 Thus, week one may start up to {@code minDays} days before the start of the month.
 If the first week starts after the start of the month then the period before is week zero (0).

 For example:<br>
 - if the 1st day of the month is a Monday, week one starts on the 1st and there is no week zero<br>
 - if the 2nd day of the month is a Monday, week one starts on the 2nd and the 1st is in week zero<br>
 - if the 4th day of the month is a Monday, week one starts on the 4th and the 1st to 3rd is in week zero<br>
 - if the 5th day of the month is a Monday, week two starts on the 5th and the 1st to 4th is in week one<br>

 This field can be used with any calendar system.

 In the resolving phase of parsing, a date can be created from a year,
 week-of-month, month-of-year and day-of-week.

 In {@linkplain ResolverStyle#STRICT strict mode}, all four fields are
 validated against their range of valid values. The week-of-month field
 is validated to ensure that the resulting month is the month requested.

 In {@linkplain ResolverStyle#SMART smart mode}, all four fields are
 validated against their range of valid values. The week-of-month field
 is validated from 0 to 6, meaning that the resulting date can be in a
 different month to that specified.

 In {@linkplain ResolverStyle#LENIENT lenient mode}, the year and day-of-week
 are validated against the range of valid values. The resulting date is calculated
 equivalent to the following four stage approach.
 First, create a date on the first day of the first week of January in the requested year.
 Then take the month-of-year, subtract one, and add the amount in months to the date.
 Then take the week-of-month, subtract one, and add the amount in weeks to the date.
 Finally, adjust to the correct day-of-week within the localized week.

 @return a field providing access to the week-of-month, not null"
  {:arglists (quote (["java.time.temporal.WeekFields"]))}
  (^js/JSJoda.TemporalField [^js/JSJoda.WeekFields this] (.weekOfMonth this)))

(defn hash-code
  "A hash code for this {@code WeekFields}.

 @return a suitable hash code"
  {:arglists (quote (["java.time.temporal.WeekFields"]))}
  (^int [^js/JSJoda.WeekFields this] (.hashCode this)))

(defn get-minimal-days-in-first-week
  "Gets the minimal number of days in the first week.

 The number of days considered to define the first week of a month or year
 varies by culture.
 For example, the ISO-8601 requires 4 days (more than half a week) to
 be present before counting the first week.

 @return the minimal number of days in the first week of a month or year, from 1 to 7"
  {:arglists (quote (["java.time.temporal.WeekFields"]))}
  (^int [^js/JSJoda.WeekFields this] (.minimalDaysInFirstWeek this)))

(defn equals
  "Checks if this {@code WeekFields} is equal to the specified object.

 The comparison is based on the entire state of the rules, which is
 the first day-of-week and minimal days.

 @param object  the other rules to compare to, null returns false
 @return true if this is equal to the specified rules"
  {:arglists (quote (["java.time.temporal.WeekFields" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.WeekFields this ^java.lang.Object object]
   (.equals this object)))
