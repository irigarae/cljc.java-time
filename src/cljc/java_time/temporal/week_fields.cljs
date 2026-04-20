(ns cljc.java-time.temporal.week-fields
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time.temporal :refer [WeekFields]]))

(def sunday-start
  (goog.object/get java.time.temporal.WeekFields "SUNDAY_START"))

(def iso (goog.object/get java.time.temporal.WeekFields "ISO"))

(def week-based-years
  (goog.object/get java.time.temporal.WeekFields "WEEK_BASED_YEARS"))

(defn day-of-week
  "Returns a field to access the day of week based on this {@code WeekFields}.\n <p>\n This is similar to {@link ChronoField#DAY_OF_WEEK} but uses values for\n the day-of-week based on this {@code WeekFields}.\n The days are numbered from 1 to 7 where the\n {@link #getFirstDayOfWeek() first day-of-week} is assigned the value 1.\n <p>\n For example, if the first day-of-week is Sunday, then that will have the\n value 1, with other days ranging from Monday as 2 to Saturday as 7.\n <p>\n In the resolving phase of parsing, a localized day-of-week will be converted\n to a standardized {@code ChronoField} day-of-week.\n The day-of-week must be in the valid range 1 to 7.\n Other fields in this class build dates using the standardized day-of-week.\n\n @return a field providing access to the day-of-week with localized numbering, not null"
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
  "Gets the first day-of-week.\n <p>\n The first day-of-week varies by culture.\n For example, the US uses Sunday, while France and the ISO-8601 standard use Monday.\n This method returns the first day using the standard {@code DayOfWeek} enum.\n\n @return the first day-of-week, not null"
  {:arglists (quote (["java.time.temporal.WeekFields"]))}
  (^js/JSJoda.DayOfWeek [^js/JSJoda.WeekFields this] (.firstDayOfWeek this)))

(defn to-string
  {:arglists (quote (["java.time.temporal.WeekFields"]))}
  (^java.lang.String [^js/JSJoda.WeekFields this] (.toString this)))

(defn week-based-year
  "Returns a field to access the year of a week-based-year based on this {@code WeekFields}.\n <p>\n This represents the concept of the year where weeks start on a fixed day-of-week,\n such as Monday and each week belongs to exactly one year.\n This field is typically used with {@link WeekFields#dayOfWeek()} and\n {@link WeekFields#weekOfWeekBasedYear()}.\n <p>\n Week one(1) is the week starting on the {@link WeekFields#getFirstDayOfWeek}\n where there are at least {@link WeekFields#getMinimalDaysInFirstWeek()} days in the year.\n Thus, week one may start before the start of the year.\n If the first week starts after the start of the year then the period before\n is in the last week of the previous year.\n <p>\n This field can be used with any calendar system.\n <p>\n In the resolving phase of parsing, a date can be created from a week-based-year,\n week-of-year and day-of-week.\n <p>\n In {@linkplain ResolverStyle#STRICT strict mode}, all three fields are\n validated against their range of valid values. The week-of-year field\n is validated to ensure that the resulting week-based-year is the\n week-based-year requested.\n <p>\n In {@linkplain ResolverStyle#SMART smart mode}, all three fields are\n validated against their range of valid values. The week-of-week-based-year field\n is validated from 1 to 53, meaning that the resulting date can be in the\n following week-based-year to that specified.\n <p>\n In {@linkplain ResolverStyle#LENIENT lenient mode}, the year and day-of-week\n are validated against the range of valid values. The resulting date is calculated\n equivalent to the following three stage approach.\n First, create a date on the first day of the first week in the requested week-based-year.\n Then take the week-of-week-based-year, subtract one, and add the amount in weeks to the date.\n Finally, adjust to the correct day-of-week within the localized week.\n\n @return a field providing access to the week-based-year, not null"
  {:arglists (quote (["java.time.temporal.WeekFields"]))}
  (^js/JSJoda.TemporalField [^js/JSJoda.WeekFields this] (.weekBasedYear this)))

(defn week-of-year
  "Returns a field to access the week of year based on this {@code WeekFields}.\n <p>\n This represents the concept of the count of weeks within the year where weeks\n start on a fixed day-of-week, such as Monday.\n This field is typically used with {@link WeekFields#dayOfWeek()}.\n <p>\n Week one(1) is the week starting on the {@link WeekFields#getFirstDayOfWeek}\n where there are at least {@link WeekFields#getMinimalDaysInFirstWeek()} days in the year.\n Thus, week one may start up to {@code minDays} days before the start of the year.\n If the first week starts after the start of the year then the period before is week zero (0).\n <p>\n For example:<br>\n - if the 1st day of the year is a Monday, week one starts on the 1st and there is no week zero<br>\n - if the 2nd day of the year is a Monday, week one starts on the 2nd and the 1st is in week zero<br>\n - if the 4th day of the year is a Monday, week one starts on the 4th and the 1st to 3rd is in week zero<br>\n - if the 5th day of the year is a Monday, week two starts on the 5th and the 1st to 4th is in week one<br>\n <p>\n This field can be used with any calendar system.\n <p>\n In the resolving phase of parsing, a date can be created from a year,\n week-of-year and day-of-week.\n <p>\n In {@linkplain ResolverStyle#STRICT strict mode}, all three fields are\n validated against their range of valid values. The week-of-year field\n is validated to ensure that the resulting year is the year requested.\n <p>\n In {@linkplain ResolverStyle#SMART smart mode}, all three fields are\n validated against their range of valid values. The week-of-year field\n is validated from 0 to 54, meaning that the resulting date can be in a\n different year to that specified.\n <p>\n In {@linkplain ResolverStyle#LENIENT lenient mode}, the year and day-of-week\n are validated against the range of valid values. The resulting date is calculated\n equivalent to the following three stage approach.\n First, create a date on the first day of the first week in the requested year.\n Then take the week-of-year, subtract one, and add the amount in weeks to the date.\n Finally, adjust to the correct day-of-week within the localized week.\n\n @return a field providing access to the week-of-year, not null"
  {:arglists (quote (["java.time.temporal.WeekFields"]))}
  (^js/JSJoda.TemporalField [^js/JSJoda.WeekFields this] (.weekOfYear this)))

(defn week-of-week-based-year
  "Returns a field to access the week of a week-based-year based on this {@code WeekFields}.\n <p>\n This represents the concept of the count of weeks within the year where weeks\n start on a fixed day-of-week, such as Monday and each week belongs to exactly one year.\n This field is typically used with {@link WeekFields#dayOfWeek()} and\n {@link WeekFields#weekBasedYear()}.\n <p>\n Week one(1) is the week starting on the {@link WeekFields#getFirstDayOfWeek}\n where there are at least {@link WeekFields#getMinimalDaysInFirstWeek()} days in the year.\n If the first week starts after the start of the year then the period before\n is in the last week of the previous year.\n <p>\n For example:<br>\n - if the 1st day of the year is a Monday, week one starts on the 1st<br>\n - if the 2nd day of the year is a Monday, week one starts on the 2nd and\n   the 1st is in the last week of the previous year<br>\n - if the 4th day of the year is a Monday, week one starts on the 4th and\n   the 1st to 3rd is in the last week of the previous year<br>\n - if the 5th day of the year is a Monday, week two starts on the 5th and\n   the 1st to 4th is in week one<br>\n <p>\n This field can be used with any calendar system.\n <p>\n In the resolving phase of parsing, a date can be created from a week-based-year,\n week-of-year and day-of-week.\n <p>\n In {@linkplain ResolverStyle#STRICT strict mode}, all three fields are\n validated against their range of valid values. The week-of-year field\n is validated to ensure that the resulting week-based-year is the\n week-based-year requested.\n <p>\n In {@linkplain ResolverStyle#SMART smart mode}, all three fields are\n validated against their range of valid values. The week-of-week-based-year field\n is validated from 1 to 53, meaning that the resulting date can be in the\n following week-based-year to that specified.\n <p>\n In {@linkplain ResolverStyle#LENIENT lenient mode}, the year and day-of-week\n are validated against the range of valid values. The resulting date is calculated\n equivalent to the following three stage approach.\n First, create a date on the first day of the first week in the requested week-based-year.\n Then take the week-of-week-based-year, subtract one, and add the amount in weeks to the date.\n Finally, adjust to the correct day-of-week within the localized week.\n\n @return a field providing access to the week-of-week-based-year, not null"
  {:arglists (quote (["java.time.temporal.WeekFields"]))}
  (^js/JSJoda.TemporalField [^js/JSJoda.WeekFields this]
   (.weekOfWeekBasedYear this)))

(defn week-of-month
  "Returns a field to access the week of month based on this {@code WeekFields}.\n <p>\n This represents the concept of the count of weeks within the month where weeks\n start on a fixed day-of-week, such as Monday.\n This field is typically used with {@link WeekFields#dayOfWeek()}.\n <p>\n Week one (1) is the week starting on the {@link WeekFields#getFirstDayOfWeek}\n where there are at least {@link WeekFields#getMinimalDaysInFirstWeek()} days in the month.\n Thus, week one may start up to {@code minDays} days before the start of the month.\n If the first week starts after the start of the month then the period before is week zero (0).\n <p>\n For example:<br>\n - if the 1st day of the month is a Monday, week one starts on the 1st and there is no week zero<br>\n - if the 2nd day of the month is a Monday, week one starts on the 2nd and the 1st is in week zero<br>\n - if the 4th day of the month is a Monday, week one starts on the 4th and the 1st to 3rd is in week zero<br>\n - if the 5th day of the month is a Monday, week two starts on the 5th and the 1st to 4th is in week one<br>\n <p>\n This field can be used with any calendar system.\n <p>\n In the resolving phase of parsing, a date can be created from a year,\n week-of-month, month-of-year and day-of-week.\n <p>\n In {@linkplain ResolverStyle#STRICT strict mode}, all four fields are\n validated against their range of valid values. The week-of-month field\n is validated to ensure that the resulting month is the month requested.\n <p>\n In {@linkplain ResolverStyle#SMART smart mode}, all four fields are\n validated against their range of valid values. The week-of-month field\n is validated from 0 to 6, meaning that the resulting date can be in a\n different month to that specified.\n <p>\n In {@linkplain ResolverStyle#LENIENT lenient mode}, the year and day-of-week\n are validated against the range of valid values. The resulting date is calculated\n equivalent to the following four stage approach.\n First, create a date on the first day of the first week of January in the requested year.\n Then take the month-of-year, subtract one, and add the amount in months to the date.\n Then take the week-of-month, subtract one, and add the amount in weeks to the date.\n Finally, adjust to the correct day-of-week within the localized week.\n\n @return a field providing access to the week-of-month, not null"
  {:arglists (quote (["java.time.temporal.WeekFields"]))}
  (^js/JSJoda.TemporalField [^js/JSJoda.WeekFields this] (.weekOfMonth this)))

(defn hash-code
  "A hash code for this {@code WeekFields}.\n\n @return a suitable hash code"
  {:arglists (quote (["java.time.temporal.WeekFields"]))}
  (^int [^js/JSJoda.WeekFields this] (.hashCode this)))

(defn get-minimal-days-in-first-week
  "Gets the minimal number of days in the first week.\n <p>\n The number of days considered to define the first week of a month or year\n varies by culture.\n For example, the ISO-8601 requires 4 days (more than half a week) to\n be present before counting the first week.\n\n @return the minimal number of days in the first week of a month or year, from 1 to 7"
  {:arglists (quote (["java.time.temporal.WeekFields"]))}
  (^int [^js/JSJoda.WeekFields this] (.minimalDaysInFirstWeek this)))

(defn equals
  "Checks if this {@code WeekFields} is equal to the specified object.\n <p>\n The comparison is based on the entire state of the rules, which is\n the first day-of-week and minimal days.\n\n @param object  the other rules to compare to, null returns false\n @return true if this is equal to the specified rules"
  {:arglists (quote (["java.time.temporal.WeekFields" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.WeekFields this ^java.lang.Object object]
   (.equals this object)))
