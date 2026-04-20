(ns cljc.java-time.offset-date-time
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time OffsetDateTime]))

(def min java.time.OffsetDateTime/MIN)

(def max java.time.OffsetDateTime/MAX)

(defn minus-minutes
  "Returns a copy of this {@code OffsetDateTime} with the specified number of minutes subtracted.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param minutes  the minutes to subtract, may be negative\n @return an {@code OffsetDateTime} based on this date-time with the minutes subtracted, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^java.time.OffsetDateTime [^java.time.OffsetDateTime this ^long minutes]
   (.minusMinutes this minutes)))

(defn truncated-to
  "Returns a copy of this {@code OffsetDateTime} with the time truncated.\n <p>\n Truncation returns a copy of the original date-time with fields\n smaller than the specified unit set to zero.\n For example, truncating with the {@link ChronoUnit#MINUTES minutes} unit\n will set the second-of-minute and nano-of-second field to zero.\n <p>\n The unit must have a {@linkplain TemporalUnit#getDuration() duration}\n that divides into the length of a standard day without remainder.\n This includes all supplied time units on {@link ChronoUnit} and\n {@link ChronoUnit#DAYS DAYS}. Other units throw an exception.\n <p>\n The offset does not affect the calculation and will be the same in the result.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param unit  the unit to truncate to, not null\n @return an {@code OffsetDateTime} based on this date-time with the time truncated, not null\n @throws DateTimeException if unable to truncate\n @throws UnsupportedTemporalTypeException if the unit is not supported"
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.OffsetDateTime
   [^java.time.OffsetDateTime this ^java.time.temporal.ChronoUnit unit]
   (.truncatedTo this unit)))

(defn minus-weeks
  "Returns a copy of this {@code OffsetDateTime} with the specified number of weeks subtracted.\n <p>\n This method subtracts the specified amount in weeks from the days field decrementing\n the month and year fields as necessary to ensure the result remains valid.\n The result is only invalid if the maximum/minimum year is exceeded.\n <p>\n For example, 2008-12-31 minus one week would result in 2009-01-07.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param weeks  the weeks to subtract, may be negative\n @return an {@code OffsetDateTime} based on this date-time with the weeks subtracted, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^java.time.OffsetDateTime [^java.time.OffsetDateTime this ^long weeks]
   (.minusWeeks this weeks)))

(defn to-instant
  "Converts this date-time to an {@code Instant}.\n <p>\n This returns an {@code Instant} representing the same point on the\n time-line as this date-time.\n\n @return an {@code Instant} representing the same instant, not null"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.time.Instant [^java.time.OffsetDateTime this] (.toInstant this)))

(defn plus-weeks
  "Returns a copy of this OffsetDateTime with the specified number of weeks added.\n <p>\n This method adds the specified amount in weeks to the days field incrementing\n the month and year fields as necessary to ensure the result remains valid.\n The result is only invalid if the maximum/minimum year is exceeded.\n <p>\n For example, 2008-12-31 plus one week would result in 2009-01-07.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param weeks  the weeks to add, may be negative\n @return an {@code OffsetDateTime} based on this date-time with the weeks added, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^java.time.OffsetDateTime [^java.time.OffsetDateTime this ^long weeks]
   (.plusWeeks this weeks)))

(defn range
  "Gets the range of valid values for the specified field.\n <p>\n The range object expresses the minimum and maximum valid values for a field.\n This date-time is used to enhance the accuracy of the returned range.\n If it is not possible to return the range, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return\n appropriate range instances.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)}\n passing {@code this} as the argument.\n Whether the range can be obtained is determined by the field.\n\n @param field  the field to query the range for, not null\n @return the range of valid values for the field, not null\n @throws DateTimeException if the range for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported"
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ValueRange
   [^java.time.OffsetDateTime this ^java.time.temporal.TemporalField field]
   (.range this field)))

(defn get-hour
  "Gets the hour-of-day field.\n\n @return the hour-of-day, from 0 to 23"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.lang.Integer [^java.time.OffsetDateTime this] (.getHour this)))

(defn at-zone-same-instant
  "Combines this date-time with a time-zone to create a {@code ZonedDateTime}\n ensuring that the result has the same instant.\n <p>\n This returns a {@code ZonedDateTime} formed from this date-time and the specified time-zone.\n This conversion will ignore the visible local date-time and use the underlying instant instead.\n This avoids any problems with local time-line gaps or overlaps.\n The result might have different values for fields such as hour, minute an even day.\n <p>\n To attempt to retain the values of the fields, use {@link #atZoneSimilarLocal(ZoneId)}.\n To use the offset as the zone ID, use {@link #toZonedDateTime()}.\n\n @param zone  the time-zone to use, not null\n @return the zoned date-time formed from this date-time, not null"
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.ZoneId"]))}
  (^java.time.ZonedDateTime
   [^java.time.OffsetDateTime this ^java.time.ZoneId zone]
   (.atZoneSameInstant this zone)))

(defn minus-hours
  "Returns a copy of this {@code OffsetDateTime} with the specified number of hours subtracted.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param hours  the hours to subtract, may be negative\n @return an {@code OffsetDateTime} based on this date-time with the hours subtracted, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^java.time.OffsetDateTime [^java.time.OffsetDateTime this ^long hours]
   (.minusHours this hours)))

(defn of
  {:arglists (quote (["java.time.LocalDateTime" "java.time.ZoneOffset"]
                     ["java.time.LocalDate" "java.time.LocalTime"
                      "java.time.ZoneOffset"]
                     ["int" "int" "int" "int" "int" "int" "int"
                      "java.time.ZoneOffset"]))}
  (^java.time.OffsetDateTime
   [^java.time.LocalDateTime date-time ^java.time.ZoneOffset offset]
   (java.time.OffsetDateTime/of date-time offset))
  (^java.time.OffsetDateTime
   [^java.time.LocalDate date ^java.time.LocalTime time
    ^java.time.ZoneOffset offset]
   (java.time.OffsetDateTime/of date time offset))
  (^java.time.OffsetDateTime
   [^java.lang.Integer year ^java.lang.Integer month
    ^java.lang.Integer day-of-month ^java.lang.Integer hour
    ^java.lang.Integer minute ^java.lang.Integer second
    ^java.lang.Integer nano-of-second ^java.time.ZoneOffset offset]
   (java.time.OffsetDateTime/of year
                                month
                                day-of-month
                                hour
                                minute
                                second
                                nano-of-second
                                offset)))

(defn with-month
  "Returns a copy of this {@code OffsetDateTime} with the month-of-year altered.\n <p>\n The time and offset do not affect the calculation and will be the same in the result.\n If the day-of-month is invalid for the year, it will be changed to the last valid day of the month.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param month  the month-of-year to set in the result, from 1 (January) to 12 (December)\n @return an {@code OffsetDateTime} based on this date-time with the requested month, not null\n @throws DateTimeException if the month-of-year value is invalid"
  {:arglists (quote (["java.time.OffsetDateTime" "int"]))}
  (^java.time.OffsetDateTime
   [^java.time.OffsetDateTime this ^java.lang.Integer month]
   (.withMonth this month)))

(defn is-equal
  "Checks if the instant of this date-time is equal to that of the specified date-time.\n <p>\n This method differs from the comparison in {@link #compareTo} and {@link #equals}\n in that it only compares the instant of the date-time. This is equivalent to using\n {@code dateTime1.toInstant().equals(dateTime2.toInstant());}.\n\n @param other  the other date-time to compare to, not null\n @return true if the instant equals the instant of the specified date-time"
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.OffsetDateTime"]))}
  (^java.lang.Boolean
   [^java.time.OffsetDateTime this ^java.time.OffsetDateTime other]
   (.isEqual this other)))

(defn get-nano
  "Gets the nano-of-second field.\n\n @return the nano-of-second, from 0 to 999,999,999"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.lang.Integer [^java.time.OffsetDateTime this] (.getNano this)))

(defn to-offset-time
  "Converts this date-time to an {@code OffsetTime}.\n <p>\n This returns an offset time with the same local time and offset.\n\n @return an OffsetTime representing the time and offset, not null"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.time.OffsetTime [^java.time.OffsetDateTime this] (.toOffsetTime this)))

(defn at-zone-similar-local
  "Combines this date-time with a time-zone to create a {@code ZonedDateTime}\n trying to keep the same local date and time.\n <p>\n This returns a {@code ZonedDateTime} formed from this date-time and the specified time-zone.\n Where possible, the result will have the same local date-time as this object.\n <p>\n Time-zone rules, such as daylight savings, mean that not every time on the\n local time-line exists. If the local date-time is in a gap or overlap according to\n the rules then a resolver is used to determine the resultant local time and offset.\n This method uses {@link ZonedDateTime#ofLocal(LocalDateTime, ZoneId, ZoneOffset)}\n to retain the offset from this instance if possible.\n <p>\n Finer control over gaps and overlaps is available in two ways.\n If you simply want to use the later offset at overlaps then call\n {@link ZonedDateTime#withLaterOffsetAtOverlap()} immediately after this method.\n <p>\n To create a zoned date-time at the same instant irrespective of the local time-line,\n use {@link #atZoneSameInstant(ZoneId)}.\n To use the offset as the zone ID, use {@link #toZonedDateTime()}.\n\n @param zone  the time-zone to use, not null\n @return the zoned date-time formed from this date and the earliest valid time for the zone, not null"
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.ZoneId"]))}
  (^java.time.ZonedDateTime
   [^java.time.OffsetDateTime this ^java.time.ZoneId zone]
   (.atZoneSimilarLocal this zone)))

(defn get-year
  "Gets the year field.\n <p>\n This method returns the primitive {@code int} value for the year.\n <p>\n The year returned by this method is proleptic as per {@code get(YEAR)}.\n To obtain the year-of-era, use {@code get(YEAR_OF_ERA)}.\n\n @return the year, from MIN_YEAR to MAX_YEAR"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.lang.Integer [^java.time.OffsetDateTime this] (.getYear this)))

(defn minus-seconds
  "Returns a copy of this {@code OffsetDateTime} with the specified number of seconds subtracted.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param seconds  the seconds to subtract, may be negative\n @return an {@code OffsetDateTime} based on this date-time with the seconds subtracted, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^java.time.OffsetDateTime [^java.time.OffsetDateTime this ^long seconds]
   (.minusSeconds this seconds)))

(defn get-second
  "Gets the second-of-minute field.\n\n @return the second-of-minute, from 0 to 59"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.lang.Integer [^java.time.OffsetDateTime this] (.getSecond this)))

(defn plus-nanos
  "Returns a copy of this {@code OffsetDateTime} with the specified number of nanoseconds added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param nanos  the nanos to add, may be negative\n @return an {@code OffsetDateTime} based on this date-time with the nanoseconds added, not null\n @throws DateTimeException if the unit cannot be added to this type"
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^java.time.OffsetDateTime [^java.time.OffsetDateTime this ^long nanos]
   (.plusNanos this nanos)))

(defn get-day-of-year
  "Gets the day-of-year field.\n <p>\n This method returns the primitive {@code int} value for the day-of-year.\n\n @return the day-of-year, from 1 to 365, or 366 in a leap year"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.lang.Integer [^java.time.OffsetDateTime this] (.getDayOfYear this)))

(defn plus
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalAmount"]
                     ["java.time.OffsetDateTime" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.OffsetDateTime
   [^java.time.OffsetDateTime this
    ^java.time.temporal.TemporalAmount amount-to-add]
   (.plus this amount-to-add))
  (^java.time.OffsetDateTime
   [^java.time.OffsetDateTime this ^long amount-to-add
    ^java.time.temporal.ChronoUnit unit]
   (.plus this amount-to-add unit)))

(defn time-line-order
  "Gets a comparator that compares two {@code OffsetDateTime} instances\n based solely on the instant.\n <p>\n This method differs from the comparison in {@link #compareTo} in that it\n only compares the underlying instant.\n\n @return a comparator that compares in time-line order\n\n @see #isAfter\n @see #isBefore\n @see #isEqual"
  {:arglists (quote ([]))}
  (^java.util.Comparator [] (java.time.OffsetDateTime/timeLineOrder)))

(defn with-hour
  "Returns a copy of this {@code OffsetDateTime} with the hour-of-day altered.\n <p>\n The date and offset do not affect the calculation and will be the same in the result.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param hour  the hour-of-day to set in the result, from 0 to 23\n @return an {@code OffsetDateTime} based on this date-time with the requested hour, not null\n @throws DateTimeException if the hour value is invalid"
  {:arglists (quote (["java.time.OffsetDateTime" "int"]))}
  (^java.time.OffsetDateTime
   [^java.time.OffsetDateTime this ^java.lang.Integer hour]
   (.withHour this hour)))

(defn with-minute
  "Returns a copy of this {@code OffsetDateTime} with the minute-of-hour altered.\n <p>\n The date and offset do not affect the calculation and will be the same in the result.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param minute  the minute-of-hour to set in the result, from 0 to 59\n @return an {@code OffsetDateTime} based on this date-time with the requested minute, not null\n @throws DateTimeException if the minute value is invalid"
  {:arglists (quote (["java.time.OffsetDateTime" "int"]))}
  (^java.time.OffsetDateTime
   [^java.time.OffsetDateTime this ^java.lang.Integer minute]
   (.withMinute this minute)))

(defn plus-minutes
  "Returns a copy of this {@code OffsetDateTime} with the specified number of minutes added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param minutes  the minutes to add, may be negative\n @return an {@code OffsetDateTime} based on this date-time with the minutes added, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^java.time.OffsetDateTime [^java.time.OffsetDateTime this ^long minutes]
   (.plusMinutes this minutes)))

(defn query
  "Queries this date-time using the specified query.\n <p>\n This queries this date-time using the specified query strategy object.\n The {@code TemporalQuery} object defines the logic to be used to\n obtain the result. Read the documentation of the query to understand\n what the result of this method will be.\n <p>\n The result of this method is obtained by invoking the\n {@link TemporalQuery#queryFrom(TemporalAccessor)} method on the\n specified query passing {@code this} as the argument.\n\n @param <R> the type of the result\n @param query  the query to invoke, not null\n @return the query result, null may be returned (defined by the query)\n @throws DateTimeException if unable to query (defined by the query)\n @throws ArithmeticException if numeric overflow occurs (defined by the query)"
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object
   [^java.time.OffsetDateTime this ^java.time.temporal.TemporalQuery query]
   (.query this query)))

(defn with-offset-same-instant
  "Returns a copy of this {@code OffsetDateTime} with the specified offset ensuring\n that the result is at the same instant.\n <p>\n This method returns an object with the specified {@code ZoneOffset} and a {@code LocalDateTime}\n adjusted by the difference between the two offsets.\n This will result in the old and new objects representing the same instant.\n This is useful for finding the local time in a different offset.\n For example, if this time represents {@code 2007-12-03T10:30+02:00} and the offset specified is\n {@code +03:00}, then this method will return {@code 2007-12-03T11:30+03:00}.\n <p>\n To change the offset without adjusting the local time use {@link #withOffsetSameLocal}.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param offset  the zone offset to change to, not null\n @return an {@code OffsetDateTime} based on this date-time with the requested offset, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.ZoneOffset"]))}
  (^java.time.OffsetDateTime
   [^java.time.OffsetDateTime this ^java.time.ZoneOffset offset]
   (.withOffsetSameInstant this offset)))

(defn get-day-of-week
  "Gets the day-of-week field, which is an enum {@code DayOfWeek}.\n <p>\n This method returns the enum {@link DayOfWeek} for the day-of-week.\n This avoids confusion as to what {@code int} values mean.\n If you need access to the primitive {@code int} value then the enum\n provides the {@link DayOfWeek#getValue() int value}.\n <p>\n Additional information can be obtained from the {@code DayOfWeek}.\n This includes textual names of the values.\n\n @return the day-of-week, not null"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.time.DayOfWeek [^java.time.OffsetDateTime this] (.getDayOfWeek this)))

(defn to-string
  "Outputs this date-time as a {@code String}, such as {@code 2007-12-03T10:15:30+01:00}.\n <p>\n The output will be one of the following ISO-8601 formats:\n <ul>\n <li>{@code uuuu-MM-dd'T'HH:mmXXXXX}</li>\n <li>{@code uuuu-MM-dd'T'HH:mm:ssXXXXX}</li>\n <li>{@code uuuu-MM-dd'T'HH:mm:ss.SSSXXXXX}</li>\n <li>{@code uuuu-MM-dd'T'HH:mm:ss.SSSSSSXXXXX}</li>\n <li>{@code uuuu-MM-dd'T'HH:mm:ss.SSSSSSSSSXXXXX}</li>\n </ul>\n The format used will be the shortest that outputs the full value of\n the time where the omitted parts are implied to be zero.\n\n @return a string representation of this date-time, not null"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.lang.String [^java.time.OffsetDateTime this] (.toString this)))

(defn plus-months
  "Returns a copy of this {@code OffsetDateTime} with the specified number of months added.\n <p>\n This method adds the specified amount to the months field in three steps:\n <ol>\n <li>Add the input months to the month-of-year field</li>\n <li>Check if the resulting date would be invalid</li>\n <li>Adjust the day-of-month to the last valid day if necessary</li>\n </ol>\n <p>\n For example, 2007-03-31 plus one month would result in the invalid date\n 2007-04-31. Instead of returning an invalid result, the last valid day\n of the month, 2007-04-30, is selected instead.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param months  the months to add, may be negative\n @return an {@code OffsetDateTime} based on this date-time with the months added, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^java.time.OffsetDateTime [^java.time.OffsetDateTime this ^long months]
   (.plusMonths this months)))

(defn is-before
  "Checks if the instant of this date-time is before that of the specified date-time.\n <p>\n This method differs from the comparison in {@link #compareTo} in that it\n only compares the instant of the date-time. This is equivalent to using\n {@code dateTime1.toInstant().isBefore(dateTime2.toInstant());}.\n\n @param other  the other date-time to compare to, not null\n @return true if this is before the instant of the specified date-time"
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.OffsetDateTime"]))}
  (^java.lang.Boolean
   [^java.time.OffsetDateTime this ^java.time.OffsetDateTime other]
   (.isBefore this other)))

(defn minus-months
  "Returns a copy of this {@code OffsetDateTime} with the specified number of months subtracted.\n <p>\n This method subtracts the specified amount from the months field in three steps:\n <ol>\n <li>Subtract the input months from the month-of-year field</li>\n <li>Check if the resulting date would be invalid</li>\n <li>Adjust the day-of-month to the last valid day if necessary</li>\n </ol>\n <p>\n For example, 2007-03-31 minus one month would result in the invalid date\n 2007-04-31. Instead of returning an invalid result, the last valid day\n of the month, 2007-04-30, is selected instead.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param months  the months to subtract, may be negative\n @return an {@code OffsetDateTime} based on this date-time with the months subtracted, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^java.time.OffsetDateTime [^java.time.OffsetDateTime this ^long months]
   (.minusMonths this months)))

(defn minus
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalAmount"]
                     ["java.time.OffsetDateTime" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.OffsetDateTime
   [^java.time.OffsetDateTime this
    ^java.time.temporal.TemporalAmount amount-to-subtract]
   (.minus this amount-to-subtract))
  (^java.time.OffsetDateTime
   [^java.time.OffsetDateTime this ^long amount-to-subtract
    ^java.time.temporal.ChronoUnit unit]
   (.minus this amount-to-subtract unit)))

(defn plus-hours
  "Returns a copy of this {@code OffsetDateTime} with the specified number of hours added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param hours  the hours to add, may be negative\n @return an {@code OffsetDateTime} based on this date-time with the hours added, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^java.time.OffsetDateTime [^java.time.OffsetDateTime this ^long hours]
   (.plusHours this hours)))

(defn plus-days
  "Returns a copy of this OffsetDateTime with the specified number of days added.\n <p>\n This method adds the specified amount to the days field incrementing the\n month and year fields as necessary to ensure the result remains valid.\n The result is only invalid if the maximum/minimum year is exceeded.\n <p>\n For example, 2008-12-31 plus one day would result in 2009-01-01.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param days  the days to add, may be negative\n @return an {@code OffsetDateTime} based on this date-time with the days added, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^java.time.OffsetDateTime [^java.time.OffsetDateTime this ^long days]
   (.plusDays this days)))

(defn to-local-time
  "Gets the {@code LocalTime} part of this date-time.\n <p>\n This returns a {@code LocalTime} with the same hour, minute, second and\n nanosecond as this date-time.\n\n @return the time part of this date-time, not null"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.time.LocalTime [^java.time.OffsetDateTime this] (.toLocalTime this)))

(defn get-long
  "Gets the value of the specified field from this date-time as a {@code long}.\n <p>\n This queries this date-time for the value of the specified field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return valid\n values based on this date-time.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalField"]))}
  (^long
   [^java.time.OffsetDateTime this ^java.time.temporal.TemporalField field]
   (.getLong this field)))

(defn get-offset
  "Gets the zone offset, such as '+01:00'.\n <p>\n This is the offset of the local date-time from UTC/Greenwich.\n\n @return the zone offset, not null"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.time.ZoneOffset [^java.time.OffsetDateTime this] (.getOffset this)))

(defn to-zoned-date-time
  "Converts this date-time to a {@code ZonedDateTime} using the offset as the zone ID.\n <p>\n This creates the simplest possible {@code ZonedDateTime} using the offset\n as the zone ID.\n <p>\n To control the time-zone used, see {@link #atZoneSameInstant(ZoneId)} and\n {@link #atZoneSimilarLocal(ZoneId)}.\n\n @return a zoned date-time representing the same local date-time and offset, not null"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.time.ZonedDateTime [^java.time.OffsetDateTime this]
   (.toZonedDateTime this)))

(defn with-year
  "Returns a copy of this {@code OffsetDateTime} with the year altered.\n <p>\n The time and offset do not affect the calculation and will be the same in the result.\n If the day-of-month is invalid for the year, it will be changed to the last valid day of the month.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param year  the year to set in the result, from MIN_YEAR to MAX_YEAR\n @return an {@code OffsetDateTime} based on this date-time with the requested year, not null\n @throws DateTimeException if the year value is invalid"
  {:arglists (quote (["java.time.OffsetDateTime" "int"]))}
  (^java.time.OffsetDateTime
   [^java.time.OffsetDateTime this ^java.lang.Integer year]
   (.withYear this year)))

(defn with-nano
  "Returns a copy of this {@code OffsetDateTime} with the nano-of-second altered.\n <p>\n The date and offset do not affect the calculation and will be the same in the result.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param nanoOfSecond  the nano-of-second to set in the result, from 0 to 999,999,999\n @return an {@code OffsetDateTime} based on this date-time with the requested nanosecond, not null\n @throws DateTimeException if the nano value is invalid"
  {:arglists (quote (["java.time.OffsetDateTime" "int"]))}
  (^java.time.OffsetDateTime
   [^java.time.OffsetDateTime this ^java.lang.Integer nano-of-second]
   (.withNano this nano-of-second)))

(defn to-epoch-second
  "Converts this date-time to the number of seconds from the epoch of 1970-01-01T00:00:00Z.\n <p>\n This allows this date-time to be converted to a value of the\n {@link ChronoField#INSTANT_SECONDS epoch-seconds} field. This is primarily\n intended for low-level conversions rather than general application usage.\n\n @return the number of seconds from the epoch of 1970-01-01T00:00:00Z"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^long [^java.time.OffsetDateTime this] (.toEpochSecond this)))

(defn until
  "Calculates the amount of time until another date-time in terms of the specified unit.\n <p>\n This calculates the amount of time between two {@code OffsetDateTime}\n objects in terms of a single {@code TemporalUnit}.\n The start and end points are {@code this} and the specified date-time.\n The result will be negative if the end is before the start.\n For example, the amount in days between two date-times can be calculated\n using {@code startDateTime.until(endDateTime, DAYS)}.\n <p>\n The {@code Temporal} passed to this method is converted to a\n {@code OffsetDateTime} using {@link #from(TemporalAccessor)}.\n If the offset differs between the two date-times, the specified\n end date-time is normalized to have the same offset as this date-time.\n <p>\n The calculation returns a whole number, representing the number of\n complete units between the two date-times.\n For example, the amount in months between 2012-06-15T00:00Z and 2012-08-14T23:59Z\n will only be one month as it is one minute short of two months.\n <p>\n There are two equivalent ways of using this method.\n The first is to invoke this method.\n The second is to use {@link TemporalUnit#between(Temporal, Temporal)}:\n <pre>\n   // these two lines are equivalent\n   amount = start.until(end, MONTHS);\n   amount = MONTHS.between(start, end);\n </pre>\n The choice should be made based on which makes the code more readable.\n <p>\n The calculation is implemented in this method for {@link ChronoUnit}.\n The units {@code NANOS}, {@code MICROS}, {@code MILLIS}, {@code SECONDS},\n {@code MINUTES}, {@code HOURS} and {@code HALF_DAYS}, {@code DAYS},\n {@code WEEKS}, {@code MONTHS}, {@code YEARS}, {@code DECADES},\n {@code CENTURIES}, {@code MILLENNIA} and {@code ERAS} are supported.\n Other {@code ChronoUnit} values will throw an exception.\n <p>\n If the unit is not a {@code ChronoUnit}, then the result of this method\n is obtained by invoking {@code TemporalUnit.between(Temporal, Temporal)}\n passing {@code this} as the first argument and the converted input temporal\n as the second argument.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param endExclusive  the end date, exclusive, which is converted to an {@code OffsetDateTime}, not null\n @param unit  the unit to measure the amount in, not null\n @return the amount of time between this date-time and the end date-time\n @throws DateTimeException if the amount cannot be calculated, or the end\n  temporal cannot be converted to an {@code OffsetDateTime}\n @throws UnsupportedTemporalTypeException if the unit is not supported\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.temporal.Temporal"
                      "java.time.temporal.TemporalUnit"]))}
  (^long
   [^java.time.OffsetDateTime this ^java.time.temporal.Temporal end-exclusive
    ^java.time.temporal.ChronoUnit unit]
   (.until this end-exclusive unit)))

(defn with-offset-same-local
  "Returns a copy of this {@code OffsetDateTime} with the specified offset ensuring\n that the result has the same local date-time.\n <p>\n This method returns an object with the same {@code LocalDateTime} and the specified {@code ZoneOffset}.\n No calculation is needed or performed.\n For example, if this time represents {@code 2007-12-03T10:30+02:00} and the offset specified is\n {@code +03:00}, then this method will return {@code 2007-12-03T10:30+03:00}.\n <p>\n To take into account the difference between the offsets, and adjust the time fields,\n use {@link #withOffsetSameInstant}.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param offset  the zone offset to change to, not null\n @return an {@code OffsetDateTime} based on this date-time with the requested offset, not null"
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.ZoneOffset"]))}
  (^java.time.OffsetDateTime
   [^java.time.OffsetDateTime this ^java.time.ZoneOffset offset]
   (.withOffsetSameLocal this offset)))

(defn with-day-of-month
  "Returns a copy of this {@code OffsetDateTime} with the day-of-month altered.\n <p>\n If the resulting {@code OffsetDateTime} is invalid, an exception is thrown.\n The time and offset do not affect the calculation and will be the same in the result.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param dayOfMonth  the day-of-month to set in the result, from 1 to 28-31\n @return an {@code OffsetDateTime} based on this date-time with the requested day, not null\n @throws DateTimeException if the day-of-month value is invalid,\n  or if the day-of-month is invalid for the month-year"
  {:arglists (quote (["java.time.OffsetDateTime" "int"]))}
  (^java.time.OffsetDateTime
   [^java.time.OffsetDateTime this ^java.lang.Integer day-of-month]
   (.withDayOfMonth this day-of-month)))

(defn get-day-of-month
  "Gets the day-of-month field.\n <p>\n This method returns the primitive {@code int} value for the day-of-month.\n\n @return the day-of-month, from 1 to 31"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.lang.Integer [^java.time.OffsetDateTime this] (.getDayOfMonth this)))

(defn from
  "Obtains an instance of {@code OffsetDateTime} from a temporal object.\n <p>\n This obtains an offset date-time based on the specified temporal.\n A {@code TemporalAccessor} represents an arbitrary set of date and time information,\n which this factory converts to an instance of {@code OffsetDateTime}.\n <p>\n The conversion will first obtain a {@code ZoneOffset} from the temporal object.\n It will then try to obtain a {@code LocalDateTime}, falling back to an {@code Instant} if necessary.\n The result will be the combination of {@code ZoneOffset} with either\n with {@code LocalDateTime} or {@code Instant}.\n Implementations are permitted to perform optimizations such as accessing\n those fields that are equivalent to the relevant objects.\n <p>\n This method matches the signature of the functional interface {@link TemporalQuery}\n allowing it to be used as a query via method reference, {@code OffsetDateTime::from}.\n\n @param temporal  the temporal object to convert, not null\n @return the offset date-time, not null\n @throws DateTimeException if unable to convert to an {@code OffsetDateTime}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^java.time.OffsetDateTime [^java.time.temporal.TemporalAccessor temporal]
   (java.time.OffsetDateTime/from temporal)))

(defn is-after
  "Checks if the instant of this date-time is after that of the specified date-time.\n <p>\n This method differs from the comparison in {@link #compareTo} and {@link #equals} in that it\n only compares the instant of the date-time. This is equivalent to using\n {@code dateTime1.toInstant().isAfter(dateTime2.toInstant());}.\n\n @param other  the other date-time to compare to, not null\n @return true if this is after the instant of the specified date-time"
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.OffsetDateTime"]))}
  (^java.lang.Boolean
   [^java.time.OffsetDateTime this ^java.time.OffsetDateTime other]
   (.isAfter this other)))

(defn minus-nanos
  "Returns a copy of this {@code OffsetDateTime} with the specified number of nanoseconds subtracted.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param nanos  the nanos to subtract, may be negative\n @return an {@code OffsetDateTime} based on this date-time with the nanoseconds subtracted, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^java.time.OffsetDateTime [^java.time.OffsetDateTime this ^long nanos]
   (.minusNanos this nanos)))

(defn is-supported
  {:arglists
     (quote (["java.time.OffsetDateTime" "java.time.temporal.TemporalField"]
             ["java.time.OffsetDateTime" "java.time.temporal.TemporalUnit"]))}
  (^java.lang.Boolean [this arg0]
   (clojure.core/cond
     (clojure.core/and (clojure.core/instance? java.time.temporal.TemporalField
                                               arg0))
       (clojure.core/let [field ^"java.time.temporal.TemporalField" arg0]
         (.isSupported ^java.time.OffsetDateTime this field))
     (clojure.core/and (clojure.core/instance? java.time.temporal.ChronoUnit
                                               arg0))
       (clojure.core/let [unit ^"java.time.temporal.ChronoUnit" arg0]
         (.isSupported ^java.time.OffsetDateTime this unit))
     :else (throw (java.lang.IllegalArgumentException.
                    "no corresponding java.time method with these args")))))

(defn minus-years
  "Returns a copy of this {@code OffsetDateTime} with the specified number of years subtracted.\n <p>\n This method subtracts the specified amount from the years field in three steps:\n <ol>\n <li>Subtract the input years from the year field</li>\n <li>Check if the resulting date would be invalid</li>\n <li>Adjust the day-of-month to the last valid day if necessary</li>\n </ol>\n <p>\n For example, 2008-02-29 (leap year) minus one year would result in the\n invalid date 2009-02-29 (standard year). Instead of returning an invalid\n result, the last valid day of the month, 2009-02-28, is selected instead.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param years  the years to subtract, may be negative\n @return an {@code OffsetDateTime} based on this date-time with the years subtracted, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^java.time.OffsetDateTime [^java.time.OffsetDateTime this ^long years]
   (.minusYears this years)))

(defn parse
  {:arglists (quote (["java.lang.CharSequence"]
                     ["java.lang.CharSequence"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.time.OffsetDateTime [^java.lang.CharSequence text]
   (java.time.OffsetDateTime/parse text))
  (^java.time.OffsetDateTime
   [^java.lang.CharSequence text ^java.time.format.DateTimeFormatter formatter]
   (java.time.OffsetDateTime/parse text formatter)))

(defn with-second
  "Returns a copy of this {@code OffsetDateTime} with the second-of-minute altered.\n <p>\n The date and offset do not affect the calculation and will be the same in the result.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param second  the second-of-minute to set in the result, from 0 to 59\n @return an {@code OffsetDateTime} based on this date-time with the requested second, not null\n @throws DateTimeException if the second value is invalid"
  {:arglists (quote (["java.time.OffsetDateTime" "int"]))}
  (^java.time.OffsetDateTime
   [^java.time.OffsetDateTime this ^java.lang.Integer second]
   (.withSecond this second)))

(defn to-local-date
  "Gets the {@code LocalDate} part of this date-time.\n <p>\n This returns a {@code LocalDate} with the same year, month and day\n as this date-time.\n\n @return the date part of this date-time, not null"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.time.LocalDate [^java.time.OffsetDateTime this] (.toLocalDate this)))

(defn get-minute
  "Gets the minute-of-hour field.\n\n @return the minute-of-hour, from 0 to 59"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.lang.Integer [^java.time.OffsetDateTime this] (.getMinute this)))

(defn hash-code
  "A hash code for this date-time.\n\n @return a suitable hash code"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.lang.Integer [^java.time.OffsetDateTime this] (.hashCode this)))

(defn adjust-into
  "Adjusts the specified temporal object to have the same offset, date\n and time as this object.\n <p>\n This returns a temporal object of the same observable type as the input\n with the offset, date and time changed to be the same as this.\n <p>\n The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}\n three times, passing {@link ChronoField#EPOCH_DAY},\n {@link ChronoField#NANO_OF_DAY} and {@link ChronoField#OFFSET_SECONDS} as the fields.\n <p>\n In most cases, it is clearer to reverse the calling pattern by using\n {@link Temporal#with(TemporalAdjuster)}:\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   temporal = thisOffsetDateTime.adjustInto(temporal);\n   temporal = temporal.with(thisOffsetDateTime);\n </pre>\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param temporal  the target object to be adjusted, not null\n @return the adjusted object, not null\n @throws DateTimeException if unable to make the adjustment\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.Temporal"]))}
  (^java.time.temporal.Temporal
   [^java.time.OffsetDateTime this ^java.time.temporal.Temporal temporal]
   (.adjustInto this temporal)))

(defn with
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalAdjuster"]
                     ["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalField" "long"]))}
  (^java.time.OffsetDateTime
   [^java.time.OffsetDateTime this
    ^java.time.temporal.TemporalAdjuster adjuster]
   (.with this adjuster))
  (^java.time.OffsetDateTime
   [^java.time.OffsetDateTime this ^java.time.temporal.TemporalField field
    ^long new-value]
   (.with this field new-value)))

(defn now
  {:arglists (quote ([] ["java.time.Clock"] ["java.time.ZoneId"]))}
  (^java.time.OffsetDateTime [] (java.time.OffsetDateTime/now))
  (^java.time.OffsetDateTime [arg0]
   (clojure.core/cond
     (clojure.core/and (clojure.core/instance? java.time.Clock arg0))
       (clojure.core/let [clock ^"java.time.Clock" arg0]
         (java.time.OffsetDateTime/now clock))
     (clojure.core/and (clojure.core/instance? java.time.ZoneId arg0))
       (clojure.core/let [zone ^"java.time.ZoneId" arg0]
         (java.time.OffsetDateTime/now zone))
     :else (throw (java.lang.IllegalArgumentException.
                    "no corresponding java.time method with these args")))))

(defn to-local-date-time
  "Gets the {@code LocalDateTime} part of this date-time.\n <p>\n This returns a {@code LocalDateTime} with the same year, month, day and time\n as this date-time.\n\n @return the local date-time part of this date-time, not null"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.time.LocalDateTime [^java.time.OffsetDateTime this]
   (.toLocalDateTime this)))

(defn get-month-value
  "Gets the month-of-year field from 1 to 12.\n <p>\n This method returns the month as an {@code int} from 1 to 12.\n Application code is frequently clearer if the enum {@link Month}\n is used by calling {@link #getMonth()}.\n\n @return the month-of-year, from 1 to 12\n @see #getMonth()"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.lang.Integer [^java.time.OffsetDateTime this] (.getMonthValue this)))

(defn with-day-of-year
  "Returns a copy of this {@code OffsetDateTime} with the day-of-year altered.\n <p>\n The time and offset do not affect the calculation and will be the same in the result.\n If the resulting {@code OffsetDateTime} is invalid, an exception is thrown.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param dayOfYear  the day-of-year to set in the result, from 1 to 365-366\n @return an {@code OffsetDateTime} based on this date with the requested day, not null\n @throws DateTimeException if the day-of-year value is invalid,\n  or if the day-of-year is invalid for the year"
  {:arglists (quote (["java.time.OffsetDateTime" "int"]))}
  (^java.time.OffsetDateTime
   [^java.time.OffsetDateTime this ^java.lang.Integer day-of-year]
   (.withDayOfYear this day-of-year)))

(defn compare-to
  "Compares this date-time to another date-time.\n <p>\n The comparison is based on the instant then on the local date-time.\n It is \"consistent with equals\", as defined by {@link Comparable}.\n <p>\n For example, the following is the comparator order:\n <ol>\n <li>{@code 2008-12-03T10:30+01:00}</li>\n <li>{@code 2008-12-03T11:00+01:00}</li>\n <li>{@code 2008-12-03T12:00+02:00}</li>\n <li>{@code 2008-12-03T11:30+01:00}</li>\n <li>{@code 2008-12-03T12:00+01:00}</li>\n <li>{@code 2008-12-03T12:30+01:00}</li>\n </ol>\n Values #2 and #3 represent the same instant on the time-line.\n When two values represent the same instant, the local date-time is compared\n to distinguish them. This step is needed to make the ordering\n consistent with {@code equals()}.\n\n @param other  the other date-time to compare to, not null\n @return the comparator value, negative if less, positive if greater"
  {:arglists (quote (["java.time.OffsetDateTime" "java.time.OffsetDateTime"]))}
  (^java.lang.Integer
   [^java.time.OffsetDateTime this ^java.time.OffsetDateTime other]
   (.compareTo this other)))

(defn get-month
  "Gets the month-of-year field using the {@code Month} enum.\n <p>\n This method returns the enum {@link Month} for the month.\n This avoids confusion as to what {@code int} values mean.\n If you need access to the primitive {@code int} value then the enum\n provides the {@link Month#getValue() int value}.\n\n @return the month-of-year, not null\n @see #getMonthValue()"
  {:arglists (quote (["java.time.OffsetDateTime"]))}
  (^java.time.Month [^java.time.OffsetDateTime this] (.getMonth this)))

(defn of-instant
  "Obtains an instance of {@code OffsetDateTime} from an {@code Instant} and zone ID.\n <p>\n This creates an offset date-time with the same instant as that specified.\n Finding the offset from UTC/Greenwich is simple as there is only one valid\n offset for each instant.\n\n @param instant  the instant to create the date-time from, not null\n @param zone  the time-zone, which may be an offset, not null\n @return the offset date-time, not null\n @throws DateTimeException if the result exceeds the supported range"
  {:arglists (quote (["java.time.Instant" "java.time.ZoneId"]))}
  (^java.time.OffsetDateTime [^java.time.Instant instant ^java.time.ZoneId zone]
   (java.time.OffsetDateTime/ofInstant instant zone)))

(defn plus-seconds
  "Returns a copy of this {@code OffsetDateTime} with the specified number of seconds added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param seconds  the seconds to add, may be negative\n @return an {@code OffsetDateTime} based on this date-time with the seconds added, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^java.time.OffsetDateTime [^java.time.OffsetDateTime this ^long seconds]
   (.plusSeconds this seconds)))

(defn get
  "Gets the value of the specified field from this date-time as an {@code int}.\n <p>\n This queries this date-time for the value of the specified field.\n The returned value will always be within the valid range of values for the field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return valid\n values based on this date-time, except {@code NANO_OF_DAY}, {@code MICRO_OF_DAY},\n {@code EPOCH_DAY}, {@code PROLEPTIC_MONTH} and {@code INSTANT_SECONDS} which are too\n large to fit in an {@code int} and throw a {@code DateTimeException}.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained or\n         the value is outside the range of valid values for the field\n @throws UnsupportedTemporalTypeException if the field is not supported or\n         the range of values exceeds an {@code int}\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.temporal.TemporalField"]))}
  (^java.lang.Integer
   [^java.time.OffsetDateTime this ^java.time.temporal.TemporalField field]
   (.get this field)))

(defn equals
  "Checks if this date-time is equal to another date-time.\n <p>\n The comparison is based on the local date-time and the offset.\n To compare for the same instant on the time-line, use {@link #isEqual}.\n Only objects of type {@code OffsetDateTime} are compared, other types return false.\n\n @param obj  the object to check, null returns false\n @return true if this is equal to the other date-time"
  {:arglists (quote (["java.time.OffsetDateTime" "java.lang.Object"]))}
  (^java.lang.Boolean [^java.time.OffsetDateTime this ^java.lang.Object obj]
   (.equals this obj)))

(defn format
  "Formats this date-time using the specified formatter.\n <p>\n This date-time will be passed to the formatter to produce a string.\n\n @param formatter  the formatter to use, not null\n @return the formatted date-time string, not null\n @throws DateTimeException if an error occurs during printing"
  {:arglists (quote (["java.time.OffsetDateTime"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.lang.String
   [^java.time.OffsetDateTime this
    ^java.time.format.DateTimeFormatter formatter]
   (.format this formatter)))

(defn plus-years
  "Returns a copy of this {@code OffsetDateTime} with the specified number of years added.\n <p>\n This method adds the specified amount to the years field in three steps:\n <ol>\n <li>Add the input years to the year field</li>\n <li>Check if the resulting date would be invalid</li>\n <li>Adjust the day-of-month to the last valid day if necessary</li>\n </ol>\n <p>\n For example, 2008-02-29 (leap year) plus one year would result in the\n invalid date 2009-02-29 (standard year). Instead of returning an invalid\n result, the last valid day of the month, 2009-02-28, is selected instead.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param years  the years to add, may be negative\n @return an {@code OffsetDateTime} based on this date-time with the years added, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^java.time.OffsetDateTime [^java.time.OffsetDateTime this ^long years]
   (.plusYears this years)))

(defn minus-days
  "Returns a copy of this {@code OffsetDateTime} with the specified number of days subtracted.\n <p>\n This method subtracts the specified amount from the days field decrementing the\n month and year fields as necessary to ensure the result remains valid.\n The result is only invalid if the maximum/minimum year is exceeded.\n <p>\n For example, 2008-12-31 minus one day would result in 2009-01-01.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param days  the days to subtract, may be negative\n @return an {@code OffsetDateTime} based on this date-time with the days subtracted, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.OffsetDateTime" "long"]))}
  (^java.time.OffsetDateTime [^java.time.OffsetDateTime this ^long days]
   (.minusDays this days)))
