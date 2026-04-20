(ns cljc.java-time.local-date-time
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time LocalDateTime]))

(def max java.time.LocalDateTime/MAX)

(def min java.time.LocalDateTime/MIN)

(defn minus-minutes
  "Returns a copy of this {@code LocalDateTime} with the specified number of minutes subtracted.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param minutes  the minutes to subtract, may be negative\n @return a {@code LocalDateTime} based on this date-time with the minutes subtracted, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDateTime" "long"]))}
  (^java.time.LocalDateTime [^java.time.LocalDateTime this ^long minutes]
   (.minusMinutes this minutes)))

(defn truncated-to
  "Returns a copy of this {@code LocalDateTime} with the time truncated.\n <p>\n Truncation returns a copy of the original date-time with fields\n smaller than the specified unit set to zero.\n For example, truncating with the {@link ChronoUnit#MINUTES minutes} unit\n will set the second-of-minute and nano-of-second field to zero.\n <p>\n The unit must have a {@linkplain TemporalUnit#getDuration() duration}\n that divides into the length of a standard day without remainder.\n This includes all supplied time units on {@link ChronoUnit} and\n {@link ChronoUnit#DAYS DAYS}. Other units throw an exception.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param unit  the unit to truncate to, not null\n @return a {@code LocalDateTime} based on this date-time with the time truncated, not null\n @throws DateTimeException if unable to truncate\n @throws UnsupportedTemporalTypeException if the unit is not supported"
  {:arglists (quote (["java.time.LocalDateTime"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.LocalDateTime
   [^java.time.LocalDateTime this ^java.time.temporal.ChronoUnit unit]
   (.truncatedTo this unit)))

(defn minus-weeks
  "Returns a copy of this {@code LocalDateTime} with the specified number of weeks subtracted.\n <p>\n This method subtracts the specified amount in weeks from the days field decrementing\n the month and year fields as necessary to ensure the result remains valid.\n The result is only invalid if the maximum/minimum year is exceeded.\n <p>\n For example, 2009-01-07 minus one week would result in 2008-12-31.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param weeks  the weeks to subtract, may be negative\n @return a {@code LocalDateTime} based on this date-time with the weeks subtracted, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDateTime" "long"]))}
  (^java.time.LocalDateTime [^java.time.LocalDateTime this ^long weeks]
   (.minusWeeks this weeks)))

(defn to-instant
  "Converts this date-time to an {@code Instant}.\n <p>\n This combines this local date-time and the specified offset to form\n an {@code Instant}.\n <p>\n This default implementation calculates from the epoch-day of the date and the\n second-of-day of the time.\n\n @param offset  the offset to use for the conversion, not null\n @return an {@code Instant} representing the same instant, not null"
  {:arglists (quote (["java.time.LocalDateTime" "java.time.ZoneOffset"]))}
  (^java.time.Instant
   [^java.time.LocalDateTime this ^java.time.ZoneOffset offset]
   (.toInstant this offset)))

(defn plus-weeks
  "Returns a copy of this {@code LocalDateTime} with the specified number of weeks added.\n <p>\n This method adds the specified amount in weeks to the days field incrementing\n the month and year fields as necessary to ensure the result remains valid.\n The result is only invalid if the maximum/minimum year is exceeded.\n <p>\n For example, 2008-12-31 plus one week would result in 2009-01-07.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param weeks  the weeks to add, may be negative\n @return a {@code LocalDateTime} based on this date-time with the weeks added, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDateTime" "long"]))}
  (^java.time.LocalDateTime [^java.time.LocalDateTime this ^long weeks]
   (.plusWeeks this weeks)))

(defn range
  "Gets the range of valid values for the specified field.\n <p>\n The range object expresses the minimum and maximum valid values for a field.\n This date-time is used to enhance the accuracy of the returned range.\n If it is not possible to return the range, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return\n appropriate range instances.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)}\n passing {@code this} as the argument.\n Whether the range can be obtained is determined by the field.\n\n @param field  the field to query the range for, not null\n @return the range of valid values for the field, not null\n @throws DateTimeException if the range for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported"
  {:arglists (quote (["java.time.LocalDateTime"
                      "java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ValueRange
   [^java.time.LocalDateTime this ^java.time.temporal.TemporalField field]
   (.range this field)))

(defn of-epoch-second
  "Obtains an instance of {@code LocalDateTime} using seconds from the\n epoch of 1970-01-01T00:00:00Z.\n <p>\n This allows the {@link ChronoField#INSTANT_SECONDS epoch-second} field\n to be converted to a local date-time. This is primarily intended for\n low-level conversions rather than general application usage.\n\n @param epochSecond  the number of seconds from the epoch of 1970-01-01T00:00:00Z\n @param nanoOfSecond  the nanosecond within the second, from 0 to 999,999,999\n @param offset  the zone offset, not null\n @return the local date-time, not null\n @throws DateTimeException if the result exceeds the supported range,\n  or if the nano-of-second is invalid"
  {:arglists (quote (["long" "int" "java.time.ZoneOffset"]))}
  (^java.time.LocalDateTime
   [^long epoch-second ^java.lang.Integer nano-of-second
    ^java.time.ZoneOffset offset]
   (java.time.LocalDateTime/ofEpochSecond epoch-second nano-of-second offset)))

(defn get-hour
  "Gets the hour-of-day field.\n\n @return the hour-of-day, from 0 to 23"
  {:arglists (quote (["java.time.LocalDateTime"]))}
  (^java.lang.Integer [^java.time.LocalDateTime this] (.getHour this)))

(defn at-offset
  "Combines this date-time with an offset to create an {@code OffsetDateTime}.\n <p>\n This returns an {@code OffsetDateTime} formed from this date-time at the specified offset.\n All possible combinations of date-time and offset are valid.\n\n @param offset  the offset to combine with, not null\n @return the offset date-time formed from this date-time and the specified offset, not null"
  {:arglists (quote (["java.time.LocalDateTime" "java.time.ZoneOffset"]))}
  (^java.time.OffsetDateTime
   [^java.time.LocalDateTime this ^java.time.ZoneOffset offset]
   (.atOffset this offset)))

(defn minus-hours
  "Returns a copy of this {@code LocalDateTime} with the specified number of hours subtracted.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param hours  the hours to subtract, may be negative\n @return a {@code LocalDateTime} based on this date-time with the hours subtracted, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDateTime" "long"]))}
  (^java.time.LocalDateTime [^java.time.LocalDateTime this ^long hours]
   (.minusHours this hours)))

(defn of
  {:arglists (quote (["java.time.LocalDate" "java.time.LocalTime"]
                     ["int" "int" "int" "int" "int"]
                     ["int" "java.time.Month" "int" "int" "int"]
                     ["int" "int" "int" "int" "int" "int"]
                     ["int" "java.time.Month" "int" "int" "int" "int"]
                     ["int" "int" "int" "int" "int" "int" "int"]
                     ["int" "java.time.Month" "int" "int" "int" "int" "int"]))}
  (^java.time.LocalDateTime
   [^java.time.LocalDate date ^java.time.LocalTime time]
   (java.time.LocalDateTime/of date time))
  (^java.time.LocalDateTime [arg0 arg1 arg2 arg3 arg4]
   (clojure.core/cond
     (clojure.core/and (clojure.core/instance? java.lang.Number arg0)
                       (clojure.core/instance? java.lang.Number arg1)
                       (clojure.core/instance? java.lang.Number arg2)
                       (clojure.core/instance? java.lang.Number arg3)
                       (clojure.core/instance? java.lang.Number arg4))
       (clojure.core/let [year (clojure.core/int arg0)
                          month (clojure.core/int arg1)
                          day-of-month (clojure.core/int arg2)
                          hour (clojure.core/int arg3)
                          minute (clojure.core/int arg4)]
         (java.time.LocalDateTime/of year month day-of-month hour minute))
     (clojure.core/and (clojure.core/instance? java.lang.Number arg0)
                       (clojure.core/instance? java.time.Month arg1)
                       (clojure.core/instance? java.lang.Number arg2)
                       (clojure.core/instance? java.lang.Number arg3)
                       (clojure.core/instance? java.lang.Number arg4))
       (clojure.core/let [year (clojure.core/int arg0)
                          month ^"java.time.Month" arg1
                          day-of-month (clojure.core/int arg2)
                          hour (clojure.core/int arg3)
                          minute (clojure.core/int arg4)]
         (java.time.LocalDateTime/of year month day-of-month hour minute))
     :else (throw (java.lang.IllegalArgumentException.
                    "no corresponding java.time method with these args"))))
  (^java.time.LocalDateTime [arg0 arg1 arg2 arg3 arg4 arg5]
   (clojure.core/cond
     (clojure.core/and (clojure.core/instance? java.lang.Number arg0)
                       (clojure.core/instance? java.lang.Number arg1)
                       (clojure.core/instance? java.lang.Number arg2)
                       (clojure.core/instance? java.lang.Number arg3)
                       (clojure.core/instance? java.lang.Number arg4)
                       (clojure.core/instance? java.lang.Number arg5))
       (clojure.core/let [year (clojure.core/int arg0)
                          month (clojure.core/int arg1)
                          day-of-month (clojure.core/int arg2)
                          hour (clojure.core/int arg3)
                          minute (clojure.core/int arg4)
                          second (clojure.core/int arg5)]
         (java.time.LocalDateTime/of year
                                     month
                                     day-of-month
                                     hour
                                     minute
                                     second))
     (clojure.core/and (clojure.core/instance? java.lang.Number arg0)
                       (clojure.core/instance? java.time.Month arg1)
                       (clojure.core/instance? java.lang.Number arg2)
                       (clojure.core/instance? java.lang.Number arg3)
                       (clojure.core/instance? java.lang.Number arg4)
                       (clojure.core/instance? java.lang.Number arg5))
       (clojure.core/let [year (clojure.core/int arg0)
                          month ^"java.time.Month" arg1
                          day-of-month (clojure.core/int arg2)
                          hour (clojure.core/int arg3)
                          minute (clojure.core/int arg4)
                          second (clojure.core/int arg5)]
         (java.time.LocalDateTime/of year
                                     month
                                     day-of-month
                                     hour
                                     minute
                                     second))
     :else (throw (java.lang.IllegalArgumentException.
                    "no corresponding java.time method with these args"))))
  (^java.time.LocalDateTime [arg0 arg1 arg2 arg3 arg4 arg5 arg6]
   (clojure.core/cond
     (clojure.core/and (clojure.core/instance? java.lang.Number arg0)
                       (clojure.core/instance? java.lang.Number arg1)
                       (clojure.core/instance? java.lang.Number arg2)
                       (clojure.core/instance? java.lang.Number arg3)
                       (clojure.core/instance? java.lang.Number arg4)
                       (clojure.core/instance? java.lang.Number arg5)
                       (clojure.core/instance? java.lang.Number arg6))
       (clojure.core/let [year (clojure.core/int arg0)
                          month (clojure.core/int arg1)
                          day-of-month (clojure.core/int arg2)
                          hour (clojure.core/int arg3)
                          minute (clojure.core/int arg4)
                          second (clojure.core/int arg5)
                          nano-of-second (clojure.core/int arg6)]
         (java.time.LocalDateTime/of year
                                     month
                                     day-of-month
                                     hour
                                     minute
                                     second
                                     nano-of-second))
     (clojure.core/and (clojure.core/instance? java.lang.Number arg0)
                       (clojure.core/instance? java.time.Month arg1)
                       (clojure.core/instance? java.lang.Number arg2)
                       (clojure.core/instance? java.lang.Number arg3)
                       (clojure.core/instance? java.lang.Number arg4)
                       (clojure.core/instance? java.lang.Number arg5)
                       (clojure.core/instance? java.lang.Number arg6))
       (clojure.core/let [year (clojure.core/int arg0)
                          month ^"java.time.Month" arg1
                          day-of-month (clojure.core/int arg2)
                          hour (clojure.core/int arg3)
                          minute (clojure.core/int arg4)
                          second (clojure.core/int arg5)
                          nano-of-second (clojure.core/int arg6)]
         (java.time.LocalDateTime/of year
                                     month
                                     day-of-month
                                     hour
                                     minute
                                     second
                                     nano-of-second))
     :else (throw (java.lang.IllegalArgumentException.
                    "no corresponding java.time method with these args")))))

(defn with-month
  "Returns a copy of this {@code LocalDateTime} with the month-of-year altered.\n <p>\n The time does not affect the calculation and will be the same in the result.\n If the day-of-month is invalid for the year, it will be changed to the last valid day of the month.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param month  the month-of-year to set in the result, from 1 (January) to 12 (December)\n @return a {@code LocalDateTime} based on this date-time with the requested month, not null\n @throws DateTimeException if the month-of-year value is invalid"
  {:arglists (quote (["java.time.LocalDateTime" "int"]))}
  (^java.time.LocalDateTime
   [^java.time.LocalDateTime this ^java.lang.Integer month]
   (.withMonth this month)))

(defn is-equal
  "Checks if this date-time is equal to the specified date-time.\n <p>\n This checks to see if this date-time represents the same point on the\n local time-line as the other date-time.\n <pre>\n   LocalDate a = LocalDateTime.of(2012, 6, 30, 12, 00);\n   LocalDate b = LocalDateTime.of(2012, 7, 1, 12, 00);\n   a.isEqual(b) == false\n   a.isEqual(a) == true\n   b.isEqual(a) == false\n </pre>\n <p>\n This method only considers the position of the two date-times on the local time-line.\n It does not take into account the chronology, or calendar system.\n This is different from the comparison in {@link #compareTo(ChronoLocalDateTime)},\n but is the same approach as {@link ChronoLocalDateTime#timeLineOrder()}.\n\n @param other  the other date-time to compare to, not null\n @return true if this date-time is equal to the specified date-time"
  {:arglists (quote (["java.time.LocalDateTime"
                      "java.time.chrono.ChronoLocalDateTime"]))}
  (^java.lang.Boolean
   [^java.time.LocalDateTime this ^java.time.chrono.ChronoLocalDateTime other]
   (.isEqual this other)))

(defn get-nano
  "Gets the nano-of-second field.\n\n @return the nano-of-second, from 0 to 999,999,999"
  {:arglists (quote (["java.time.LocalDateTime"]))}
  (^java.lang.Integer [^java.time.LocalDateTime this] (.getNano this)))

(defn get-year
  "Gets the year field.\n <p>\n This method returns the primitive {@code int} value for the year.\n <p>\n The year returned by this method is proleptic as per {@code get(YEAR)}.\n To obtain the year-of-era, use {@code get(YEAR_OF_ERA)}.\n\n @return the year, from MIN_YEAR to MAX_YEAR"
  {:arglists (quote (["java.time.LocalDateTime"]))}
  (^java.lang.Integer [^java.time.LocalDateTime this] (.getYear this)))

(defn minus-seconds
  "Returns a copy of this {@code LocalDateTime} with the specified number of seconds subtracted.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param seconds  the seconds to subtract, may be negative\n @return a {@code LocalDateTime} based on this date-time with the seconds subtracted, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDateTime" "long"]))}
  (^java.time.LocalDateTime [^java.time.LocalDateTime this ^long seconds]
   (.minusSeconds this seconds)))

(defn get-second
  "Gets the second-of-minute field.\n\n @return the second-of-minute, from 0 to 59"
  {:arglists (quote (["java.time.LocalDateTime"]))}
  (^java.lang.Integer [^java.time.LocalDateTime this] (.getSecond this)))

(defn plus-nanos
  "Returns a copy of this {@code LocalDateTime} with the specified number of nanoseconds added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param nanos  the nanos to add, may be negative\n @return a {@code LocalDateTime} based on this date-time with the nanoseconds added, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDateTime" "long"]))}
  (^java.time.LocalDateTime [^java.time.LocalDateTime this ^long nanos]
   (.plusNanos this nanos)))

(defn get-day-of-year
  "Gets the day-of-year field.\n <p>\n This method returns the primitive {@code int} value for the day-of-year.\n\n @return the day-of-year, from 1 to 365, or 366 in a leap year"
  {:arglists (quote (["java.time.LocalDateTime"]))}
  (^java.lang.Integer [^java.time.LocalDateTime this] (.getDayOfYear this)))

(defn plus
  {:arglists (quote (["java.time.LocalDateTime"
                      "java.time.temporal.TemporalAmount"]
                     ["java.time.LocalDateTime" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.LocalDateTime
   [^java.time.LocalDateTime this
    ^java.time.temporal.TemporalAmount amount-to-add]
   (.plus this amount-to-add))
  (^java.time.LocalDateTime
   [^java.time.LocalDateTime this ^long amount-to-add
    ^java.time.temporal.ChronoUnit unit]
   (.plus this amount-to-add unit)))

(defn with-hour
  "Returns a copy of this {@code LocalDateTime} with the hour-of-day altered.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param hour  the hour-of-day to set in the result, from 0 to 23\n @return a {@code LocalDateTime} based on this date-time with the requested hour, not null\n @throws DateTimeException if the hour value is invalid"
  {:arglists (quote (["java.time.LocalDateTime" "int"]))}
  (^java.time.LocalDateTime
   [^java.time.LocalDateTime this ^java.lang.Integer hour]
   (.withHour this hour)))

(defn with-minute
  "Returns a copy of this {@code LocalDateTime} with the minute-of-hour altered.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param minute  the minute-of-hour to set in the result, from 0 to 59\n @return a {@code LocalDateTime} based on this date-time with the requested minute, not null\n @throws DateTimeException if the minute value is invalid"
  {:arglists (quote (["java.time.LocalDateTime" "int"]))}
  (^java.time.LocalDateTime
   [^java.time.LocalDateTime this ^java.lang.Integer minute]
   (.withMinute this minute)))

(defn plus-minutes
  "Returns a copy of this {@code LocalDateTime} with the specified number of minutes added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param minutes  the minutes to add, may be negative\n @return a {@code LocalDateTime} based on this date-time with the minutes added, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDateTime" "long"]))}
  (^java.time.LocalDateTime [^java.time.LocalDateTime this ^long minutes]
   (.plusMinutes this minutes)))

(defn query
  "Queries this date-time using the specified query.\n <p>\n This queries this date-time using the specified query strategy object.\n The {@code TemporalQuery} object defines the logic to be used to\n obtain the result. Read the documentation of the query to understand\n what the result of this method will be.\n <p>\n The result of this method is obtained by invoking the\n {@link TemporalQuery#queryFrom(TemporalAccessor)} method on the\n specified query passing {@code this} as the argument.\n\n @param <R> the type of the result\n @param query  the query to invoke, not null\n @return the query result, null may be returned (defined by the query)\n @throws DateTimeException if unable to query (defined by the query)\n @throws ArithmeticException if numeric overflow occurs (defined by the query)"
  {:arglists (quote (["java.time.LocalDateTime"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object
   [^java.time.LocalDateTime this ^java.time.temporal.TemporalQuery query]
   (.query this query)))

(defn get-day-of-week
  "Gets the day-of-week field, which is an enum {@code DayOfWeek}.\n <p>\n This method returns the enum {@link DayOfWeek} for the day-of-week.\n This avoids confusion as to what {@code int} values mean.\n If you need access to the primitive {@code int} value then the enum\n provides the {@link DayOfWeek#getValue() int value}.\n <p>\n Additional information can be obtained from the {@code DayOfWeek}.\n This includes textual names of the values.\n\n @return the day-of-week, not null"
  {:arglists (quote (["java.time.LocalDateTime"]))}
  (^java.time.DayOfWeek [^java.time.LocalDateTime this] (.getDayOfWeek this)))

(defn to-string
  "Outputs this date-time as a {@code String}, such as {@code 2007-12-03T10:15:30}.\n <p>\n The output will be one of the following ISO-8601 formats:\n <ul>\n <li>{@code uuuu-MM-dd'T'HH:mm}</li>\n <li>{@code uuuu-MM-dd'T'HH:mm:ss}</li>\n <li>{@code uuuu-MM-dd'T'HH:mm:ss.SSS}</li>\n <li>{@code uuuu-MM-dd'T'HH:mm:ss.SSSSSS}</li>\n <li>{@code uuuu-MM-dd'T'HH:mm:ss.SSSSSSSSS}</li>\n </ul>\n The format used will be the shortest that outputs the full value of\n the time where the omitted parts are implied to be zero.\n\n @return a string representation of this date-time, not null"
  {:arglists (quote (["java.time.LocalDateTime"]))}
  (^java.lang.String [^java.time.LocalDateTime this] (.toString this)))

(defn plus-months
  "Returns a copy of this {@code LocalDateTime} with the specified number of months added.\n <p>\n This method adds the specified amount to the months field in three steps:\n <ol>\n <li>Add the input months to the month-of-year field</li>\n <li>Check if the resulting date would be invalid</li>\n <li>Adjust the day-of-month to the last valid day if necessary</li>\n </ol>\n <p>\n For example, 2007-03-31 plus one month would result in the invalid date\n 2007-04-31. Instead of returning an invalid result, the last valid day\n of the month, 2007-04-30, is selected instead.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param months  the months to add, may be negative\n @return a {@code LocalDateTime} based on this date-time with the months added, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDateTime" "long"]))}
  (^java.time.LocalDateTime [^java.time.LocalDateTime this ^long months]
   (.plusMonths this months)))

(defn is-before
  "Checks if this date-time is before the specified date-time.\n <p>\n This checks to see if this date-time represents a point on the\n local time-line before the other date-time.\n <pre>\n   LocalDate a = LocalDateTime.of(2012, 6, 30, 12, 00);\n   LocalDate b = LocalDateTime.of(2012, 7, 1, 12, 00);\n   a.isBefore(b) == true\n   a.isBefore(a) == false\n   b.isBefore(a) == false\n </pre>\n <p>\n This method only considers the position of the two date-times on the local time-line.\n It does not take into account the chronology, or calendar system.\n This is different from the comparison in {@link #compareTo(ChronoLocalDateTime)},\n but is the same approach as {@link ChronoLocalDateTime#timeLineOrder()}.\n\n @param other  the other date-time to compare to, not null\n @return true if this date-time is before the specified date-time"
  {:arglists (quote (["java.time.LocalDateTime"
                      "java.time.chrono.ChronoLocalDateTime"]))}
  (^java.lang.Boolean
   [^java.time.LocalDateTime this ^java.time.chrono.ChronoLocalDateTime other]
   (.isBefore this other)))

(defn minus-months
  "Returns a copy of this {@code LocalDateTime} with the specified number of months subtracted.\n <p>\n This method subtracts the specified amount from the months field in three steps:\n <ol>\n <li>Subtract the input months from the month-of-year field</li>\n <li>Check if the resulting date would be invalid</li>\n <li>Adjust the day-of-month to the last valid day if necessary</li>\n </ol>\n <p>\n For example, 2007-03-31 minus one month would result in the invalid date\n 2007-04-31. Instead of returning an invalid result, the last valid day\n of the month, 2007-04-30, is selected instead.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param months  the months to subtract, may be negative\n @return a {@code LocalDateTime} based on this date-time with the months subtracted, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDateTime" "long"]))}
  (^java.time.LocalDateTime [^java.time.LocalDateTime this ^long months]
   (.minusMonths this months)))

(defn minus
  {:arglists (quote (["java.time.LocalDateTime"
                      "java.time.temporal.TemporalAmount"]
                     ["java.time.LocalDateTime" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.LocalDateTime
   [^java.time.LocalDateTime this
    ^java.time.temporal.TemporalAmount amount-to-subtract]
   (.minus this amount-to-subtract))
  (^java.time.LocalDateTime
   [^java.time.LocalDateTime this ^long amount-to-subtract
    ^java.time.temporal.ChronoUnit unit]
   (.minus this amount-to-subtract unit)))

(defn at-zone
  "Combines this date-time with a time-zone to create a {@code ZonedDateTime}.\n <p>\n This returns a {@code ZonedDateTime} formed from this date-time at the\n specified time-zone. The result will match this date-time as closely as possible.\n Time-zone rules, such as daylight savings, mean that not every local date-time\n is valid for the specified zone, thus the local date-time may be adjusted.\n <p>\n The local date-time is resolved to a single instant on the time-line.\n This is achieved by finding a valid offset from UTC/Greenwich for the local\n date-time as defined by the {@link ZoneRules rules} of the zone ID.\n<p>\n In most cases, there is only one valid offset for a local date-time.\n In the case of an overlap, where clocks are set back, there are two valid offsets.\n This method uses the earlier offset typically corresponding to \"summer\".\n <p>\n In the case of a gap, where clocks jump forward, there is no valid offset.\n Instead, the local date-time is adjusted to be later by the length of the gap.\n For a typical one hour daylight savings change, the local date-time will be\n moved one hour later into the offset typically corresponding to \"summer\".\n <p>\n To obtain the later offset during an overlap, call\n {@link ZonedDateTime#withLaterOffsetAtOverlap()} on the result of this method.\n To throw an exception when there is a gap or overlap, use\n {@link ZonedDateTime#ofStrict(LocalDateTime, ZoneOffset, ZoneId)}.\n\n @param zone  the time-zone to use, not null\n @return the zoned date-time formed from this date-time, not null"
  {:arglists (quote (["java.time.LocalDateTime" "java.time.ZoneId"]))}
  (^java.time.ZonedDateTime
   [^java.time.LocalDateTime this ^java.time.ZoneId zone]
   (.atZone this zone)))

(defn plus-hours
  "Returns a copy of this {@code LocalDateTime} with the specified number of hours added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param hours  the hours to add, may be negative\n @return a {@code LocalDateTime} based on this date-time with the hours added, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDateTime" "long"]))}
  (^java.time.LocalDateTime [^java.time.LocalDateTime this ^long hours]
   (.plusHours this hours)))

(defn plus-days
  "Returns a copy of this {@code LocalDateTime} with the specified number of days added.\n <p>\n This method adds the specified amount to the days field incrementing the\n month and year fields as necessary to ensure the result remains valid.\n The result is only invalid if the maximum/minimum year is exceeded.\n <p>\n For example, 2008-12-31 plus one day would result in 2009-01-01.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param days  the days to add, may be negative\n @return a {@code LocalDateTime} based on this date-time with the days added, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDateTime" "long"]))}
  (^java.time.LocalDateTime [^java.time.LocalDateTime this ^long days]
   (.plusDays this days)))

(defn to-local-time
  "Gets the {@code LocalTime} part of this date-time.\n <p>\n This returns a {@code LocalTime} with the same hour, minute, second and\n nanosecond as this date-time.\n\n @return the time part of this date-time, not null"
  {:arglists (quote (["java.time.LocalDateTime"]))}
  (^java.time.LocalTime [^java.time.LocalDateTime this] (.toLocalTime this)))

(defn get-long
  "Gets the value of the specified field from this date-time as a {@code long}.\n <p>\n This queries this date-time for the value of the specified field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return valid\n values based on this date-time.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.LocalDateTime"
                      "java.time.temporal.TemporalField"]))}
  (^long [^java.time.LocalDateTime this ^java.time.temporal.TemporalField field]
   (.getLong this field)))

(defn with-year
  "Returns a copy of this {@code LocalDateTime} with the year altered.\n <p>\n The time does not affect the calculation and will be the same in the result.\n If the day-of-month is invalid for the year, it will be changed to the last valid day of the month.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param year  the year to set in the result, from MIN_YEAR to MAX_YEAR\n @return a {@code LocalDateTime} based on this date-time with the requested year, not null\n @throws DateTimeException if the year value is invalid"
  {:arglists (quote (["java.time.LocalDateTime" "int"]))}
  (^java.time.LocalDateTime
   [^java.time.LocalDateTime this ^java.lang.Integer year]
   (.withYear this year)))

(defn with-nano
  "Returns a copy of this {@code LocalDateTime} with the nano-of-second altered.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param nanoOfSecond  the nano-of-second to set in the result, from 0 to 999,999,999\n @return a {@code LocalDateTime} based on this date-time with the requested nanosecond, not null\n @throws DateTimeException if the nano value is invalid"
  {:arglists (quote (["java.time.LocalDateTime" "int"]))}
  (^java.time.LocalDateTime
   [^java.time.LocalDateTime this ^java.lang.Integer nano-of-second]
   (.withNano this nano-of-second)))

(defn to-epoch-second
  "Converts this date-time to the number of seconds from the epoch\n of 1970-01-01T00:00:00Z.\n <p>\n This combines this local date-time and the specified offset to calculate the\n epoch-second value, which is the number of elapsed seconds from 1970-01-01T00:00:00Z.\n Instants on the time-line after the epoch are positive, earlier are negative.\n <p>\n This default implementation calculates from the epoch-day of the date and the\n second-of-day of the time.\n\n @param offset  the offset to use for the conversion, not null\n @return the number of seconds from the epoch of 1970-01-01T00:00:00Z"
  {:arglists (quote (["java.time.LocalDateTime" "java.time.ZoneOffset"]))}
  (^long [^java.time.LocalDateTime this ^java.time.ZoneOffset offset]
   (.toEpochSecond this offset)))

(defn until
  "Calculates the amount of time until another date-time in terms of the specified unit.\n <p>\n This calculates the amount of time between two {@code LocalDateTime}\n objects in terms of a single {@code TemporalUnit}.\n The start and end points are {@code this} and the specified date-time.\n The result will be negative if the end is before the start.\n The {@code Temporal} passed to this method is converted to a\n {@code LocalDateTime} using {@link #from(TemporalAccessor)}.\n For example, the amount in days between two date-times can be calculated\n using {@code startDateTime.until(endDateTime, DAYS)}.\n <p>\n The calculation returns a whole number, representing the number of\n complete units between the two date-times.\n For example, the amount in months between 2012-06-15T00:00 and 2012-08-14T23:59\n will only be one month as it is one minute short of two months.\n <p>\n There are two equivalent ways of using this method.\n The first is to invoke this method.\n The second is to use {@link TemporalUnit#between(Temporal, Temporal)}:\n <pre>\n   // these two lines are equivalent\n   amount = start.until(end, MONTHS);\n   amount = MONTHS.between(start, end);\n </pre>\n The choice should be made based on which makes the code more readable.\n <p>\n The calculation is implemented in this method for {@link ChronoUnit}.\n The units {@code NANOS}, {@code MICROS}, {@code MILLIS}, {@code SECONDS},\n {@code MINUTES}, {@code HOURS} and {@code HALF_DAYS}, {@code DAYS},\n {@code WEEKS}, {@code MONTHS}, {@code YEARS}, {@code DECADES},\n {@code CENTURIES}, {@code MILLENNIA} and {@code ERAS} are supported.\n Other {@code ChronoUnit} values will throw an exception.\n <p>\n If the unit is not a {@code ChronoUnit}, then the result of this method\n is obtained by invoking {@code TemporalUnit.between(Temporal, Temporal)}\n passing {@code this} as the first argument and the converted input temporal\n as the second argument.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param endExclusive  the end date, exclusive, which is converted to a {@code LocalDateTime}, not null\n @param unit  the unit to measure the amount in, not null\n @return the amount of time between this date-time and the end date-time\n @throws DateTimeException if the amount cannot be calculated, or the end\n  temporal cannot be converted to a {@code LocalDateTime}\n @throws UnsupportedTemporalTypeException if the unit is not supported\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.LocalDateTime" "java.time.temporal.Temporal"
                      "java.time.temporal.TemporalUnit"]))}
  (^long
   [^java.time.LocalDateTime this ^java.time.temporal.Temporal end-exclusive
    ^java.time.temporal.ChronoUnit unit]
   (.until this end-exclusive unit)))

(defn with-day-of-month
  "Returns a copy of this {@code LocalDateTime} with the day-of-month altered.\n <p>\n If the resulting date-time is invalid, an exception is thrown.\n The time does not affect the calculation and will be the same in the result.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param dayOfMonth  the day-of-month to set in the result, from 1 to 28-31\n @return a {@code LocalDateTime} based on this date-time with the requested day, not null\n @throws DateTimeException if the day-of-month value is invalid,\n  or if the day-of-month is invalid for the month-year"
  {:arglists (quote (["java.time.LocalDateTime" "int"]))}
  (^java.time.LocalDateTime
   [^java.time.LocalDateTime this ^java.lang.Integer day-of-month]
   (.withDayOfMonth this day-of-month)))

(defn get-day-of-month
  "Gets the day-of-month field.\n <p>\n This method returns the primitive {@code int} value for the day-of-month.\n\n @return the day-of-month, from 1 to 31"
  {:arglists (quote (["java.time.LocalDateTime"]))}
  (^java.lang.Integer [^java.time.LocalDateTime this] (.getDayOfMonth this)))

(defn from
  "Obtains an instance of {@code LocalDateTime} from a temporal object.\n <p>\n This obtains a local date-time based on the specified temporal.\n A {@code TemporalAccessor} represents an arbitrary set of date and time information,\n which this factory converts to an instance of {@code LocalDateTime}.\n <p>\n The conversion extracts and combines the {@code LocalDate} and the\n {@code LocalTime} from the temporal object.\n Implementations are permitted to perform optimizations such as accessing\n those fields that are equivalent to the relevant objects.\n <p>\n This method matches the signature of the functional interface {@link TemporalQuery}\n allowing it to be used as a query via method reference, {@code LocalDateTime::from}.\n\n @param temporal  the temporal object to convert, not null\n @return the local date-time, not null\n @throws DateTimeException if unable to convert to a {@code LocalDateTime}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^java.time.LocalDateTime [^java.time.temporal.TemporalAccessor temporal]
   (java.time.LocalDateTime/from temporal)))

(defn is-after
  "Checks if this date-time is after the specified date-time.\n <p>\n This checks to see if this date-time represents a point on the\n local time-line after the other date-time.\n <pre>\n   LocalDate a = LocalDateTime.of(2012, 6, 30, 12, 00);\n   LocalDate b = LocalDateTime.of(2012, 7, 1, 12, 00);\n   a.isAfter(b) == false\n   a.isAfter(a) == false\n   b.isAfter(a) == true\n </pre>\n <p>\n This method only considers the position of the two date-times on the local time-line.\n It does not take into account the chronology, or calendar system.\n This is different from the comparison in {@link #compareTo(ChronoLocalDateTime)},\n but is the same approach as {@link ChronoLocalDateTime#timeLineOrder()}.\n\n @param other  the other date-time to compare to, not null\n @return true if this date-time is after the specified date-time"
  {:arglists (quote (["java.time.LocalDateTime"
                      "java.time.chrono.ChronoLocalDateTime"]))}
  (^java.lang.Boolean
   [^java.time.LocalDateTime this ^java.time.chrono.ChronoLocalDateTime other]
   (.isAfter this other)))

(defn minus-nanos
  "Returns a copy of this {@code LocalDateTime} with the specified number of nanoseconds subtracted.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param nanos  the nanos to subtract, may be negative\n @return a {@code LocalDateTime} based on this date-time with the nanoseconds subtracted, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDateTime" "long"]))}
  (^java.time.LocalDateTime [^java.time.LocalDateTime this ^long nanos]
   (.minusNanos this nanos)))

(defn is-supported
  {:arglists (quote
               (["java.time.LocalDateTime" "java.time.temporal.TemporalField"]
                ["java.time.LocalDateTime" "java.time.temporal.TemporalUnit"]))}
  (^java.lang.Boolean [this arg0]
   (clojure.core/cond
     (clojure.core/and (clojure.core/instance? java.time.temporal.TemporalField
                                               arg0))
       (clojure.core/let [field ^"java.time.temporal.TemporalField" arg0]
         (.isSupported ^java.time.LocalDateTime this field))
     (clojure.core/and (clojure.core/instance? java.time.temporal.ChronoUnit
                                               arg0))
       (clojure.core/let [unit ^"java.time.temporal.ChronoUnit" arg0]
         (.isSupported ^java.time.LocalDateTime this unit))
     :else (throw (java.lang.IllegalArgumentException.
                    "no corresponding java.time method with these args")))))

(defn minus-years
  "Returns a copy of this {@code LocalDateTime} with the specified number of years subtracted.\n <p>\n This method subtracts the specified amount from the years field in three steps:\n <ol>\n <li>Subtract the input years from the year field</li>\n <li>Check if the resulting date would be invalid</li>\n <li>Adjust the day-of-month to the last valid day if necessary</li>\n </ol>\n <p>\n For example, 2008-02-29 (leap year) minus one year would result in the\n invalid date 2009-02-29 (standard year). Instead of returning an invalid\n result, the last valid day of the month, 2009-02-28, is selected instead.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param years  the years to subtract, may be negative\n @return a {@code LocalDateTime} based on this date-time with the years subtracted, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDateTime" "long"]))}
  (^java.time.LocalDateTime [^java.time.LocalDateTime this ^long years]
   (.minusYears this years)))

(defn get-chronology
  "Gets the chronology of this date-time.\n <p>\n The {@code Chronology} represents the calendar system in use.\n The era and other fields in {@link ChronoField} are defined by the chronology.\n\n @return the chronology, not null"
  {:arglists (quote (["java.time.LocalDateTime"]))}
  (^java.time.chrono.Chronology [^java.time.LocalDateTime this]
   (.getChronology this)))

(defn parse
  {:arglists (quote (["java.lang.CharSequence"]
                     ["java.lang.CharSequence"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.time.LocalDateTime [^java.lang.CharSequence text]
   (java.time.LocalDateTime/parse text))
  (^java.time.LocalDateTime
   [^java.lang.CharSequence text ^java.time.format.DateTimeFormatter formatter]
   (java.time.LocalDateTime/parse text formatter)))

(defn with-second
  "Returns a copy of this {@code LocalDateTime} with the second-of-minute altered.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param second  the second-of-minute to set in the result, from 0 to 59\n @return a {@code LocalDateTime} based on this date-time with the requested second, not null\n @throws DateTimeException if the second value is invalid"
  {:arglists (quote (["java.time.LocalDateTime" "int"]))}
  (^java.time.LocalDateTime
   [^java.time.LocalDateTime this ^java.lang.Integer second]
   (.withSecond this second)))

(defn to-local-date
  "Gets the {@code LocalDate} part of this date-time.\n <p>\n This returns a {@code LocalDate} with the same year, month and day\n as this date-time.\n\n @return the date part of this date-time, not null"
  {:arglists (quote (["java.time.LocalDateTime"]))}
  (^java.time.LocalDate [^java.time.LocalDateTime this] (.toLocalDate this)))

(defn get-minute
  "Gets the minute-of-hour field.\n\n @return the minute-of-hour, from 0 to 59"
  {:arglists (quote (["java.time.LocalDateTime"]))}
  (^java.lang.Integer [^java.time.LocalDateTime this] (.getMinute this)))

(defn hash-code
  "A hash code for this date-time.\n\n @return a suitable hash code"
  {:arglists (quote (["java.time.LocalDateTime"]))}
  (^java.lang.Integer [^java.time.LocalDateTime this] (.hashCode this)))

(defn adjust-into
  "Adjusts the specified temporal object to have the same date and time as this object.\n <p>\n This returns a temporal object of the same observable type as the input\n with the date and time changed to be the same as this.\n <p>\n The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}\n twice, passing {@link ChronoField#EPOCH_DAY} and\n {@link ChronoField#NANO_OF_DAY} as the fields.\n <p>\n In most cases, it is clearer to reverse the calling pattern by using\n {@link Temporal#with(TemporalAdjuster)}:\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   temporal = thisLocalDateTime.adjustInto(temporal);\n   temporal = temporal.with(thisLocalDateTime);\n </pre>\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param temporal  the target object to be adjusted, not null\n @return the adjusted object, not null\n @throws DateTimeException if unable to make the adjustment\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.LocalDateTime"
                      "java.time.temporal.Temporal"]))}
  (^java.time.temporal.Temporal
   [^java.time.LocalDateTime this ^java.time.temporal.Temporal temporal]
   (.adjustInto this temporal)))

(defn with
  {:arglists (quote (["java.time.LocalDateTime"
                      "java.time.temporal.TemporalAdjuster"]
                     ["java.time.LocalDateTime"
                      "java.time.temporal.TemporalField" "long"]))}
  (^java.time.LocalDateTime
   [^java.time.LocalDateTime this ^java.time.temporal.TemporalAdjuster adjuster]
   (.with this adjuster))
  (^java.time.LocalDateTime
   [^java.time.LocalDateTime this ^java.time.temporal.TemporalField field
    ^long new-value]
   (.with this field new-value)))

(defn now
  {:arglists (quote ([] ["java.time.Clock"] ["java.time.ZoneId"]))}
  (^java.time.LocalDateTime [] (java.time.LocalDateTime/now))
  (^java.time.LocalDateTime [arg0]
   (clojure.core/cond
     (clojure.core/and (clojure.core/instance? java.time.Clock arg0))
       (clojure.core/let [clock ^"java.time.Clock" arg0]
         (java.time.LocalDateTime/now clock))
     (clojure.core/and (clojure.core/instance? java.time.ZoneId arg0))
       (clojure.core/let [zone ^"java.time.ZoneId" arg0]
         (java.time.LocalDateTime/now zone))
     :else (throw (java.lang.IllegalArgumentException.
                    "no corresponding java.time method with these args")))))

(defn get-month-value
  "Gets the month-of-year field from 1 to 12.\n <p>\n This method returns the month as an {@code int} from 1 to 12.\n Application code is frequently clearer if the enum {@link Month}\n is used by calling {@link #getMonth()}.\n\n @return the month-of-year, from 1 to 12\n @see #getMonth()"
  {:arglists (quote (["java.time.LocalDateTime"]))}
  (^java.lang.Integer [^java.time.LocalDateTime this] (.getMonthValue this)))

(defn with-day-of-year
  "Returns a copy of this {@code LocalDateTime} with the day-of-year altered.\n <p>\n If the resulting date-time is invalid, an exception is thrown.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param dayOfYear  the day-of-year to set in the result, from 1 to 365-366\n @return a {@code LocalDateTime} based on this date with the requested day, not null\n @throws DateTimeException if the day-of-year value is invalid,\n  or if the day-of-year is invalid for the year"
  {:arglists (quote (["java.time.LocalDateTime" "int"]))}
  (^java.time.LocalDateTime
   [^java.time.LocalDateTime this ^java.lang.Integer day-of-year]
   (.withDayOfYear this day-of-year)))

(defn compare-to
  "Compares this date-time to another date-time.\n <p>\n The comparison is primarily based on the date-time, from earliest to latest.\n It is \"consistent with equals\", as defined by {@link Comparable}.\n <p>\n If all the date-times being compared are instances of {@code LocalDateTime},\n then the comparison will be entirely based on the date-time.\n If some dates being compared are in different chronologies, then the\n chronology is also considered, see {@link ChronoLocalDateTime#compareTo}.\n\n @param other  the other date-time to compare to, not null\n @return the comparator value, negative if less, positive if greater"
  {:arglists (quote (["java.time.LocalDateTime"
                      "java.time.chrono.ChronoLocalDateTime"]))}
  (^java.lang.Integer
   [^java.time.LocalDateTime this ^java.time.chrono.ChronoLocalDateTime other]
   (.compareTo this other)))

(defn get-month
  "Gets the month-of-year field using the {@code Month} enum.\n <p>\n This method returns the enum {@link Month} for the month.\n This avoids confusion as to what {@code int} values mean.\n If you need access to the primitive {@code int} value then the enum\n provides the {@link Month#getValue() int value}.\n\n @return the month-of-year, not null\n @see #getMonthValue()"
  {:arglists (quote (["java.time.LocalDateTime"]))}
  (^java.time.Month [^java.time.LocalDateTime this] (.getMonth this)))

(defn of-instant
  "Obtains an instance of {@code LocalDateTime} from an {@code Instant} and zone ID.\n <p>\n This creates a local date-time based on the specified instant.\n First, the offset from UTC/Greenwich is obtained using the zone ID and instant,\n which is simple as there is only one valid offset for each instant.\n Then, the instant and offset are used to calculate the local date-time.\n\n @param instant  the instant to create the date-time from, not null\n @param zone  the time-zone, which may be an offset, not null\n @return the local date-time, not null\n @throws DateTimeException if the result exceeds the supported range"
  {:arglists (quote (["java.time.Instant" "java.time.ZoneId"]))}
  (^java.time.LocalDateTime [^java.time.Instant instant ^java.time.ZoneId zone]
   (java.time.LocalDateTime/ofInstant instant zone)))

(defn plus-seconds
  "Returns a copy of this {@code LocalDateTime} with the specified number of seconds added.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param seconds  the seconds to add, may be negative\n @return a {@code LocalDateTime} based on this date-time with the seconds added, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDateTime" "long"]))}
  (^java.time.LocalDateTime [^java.time.LocalDateTime this ^long seconds]
   (.plusSeconds this seconds)))

(defn get
  "Gets the value of the specified field from this date-time as an {@code int}.\n <p>\n This queries this date-time for the value of the specified field.\n The returned value will always be within the valid range of values for the field.\n If it is not possible to return the value, because the field is not supported\n or for some other reason, an exception is thrown.\n <p>\n If the field is a {@link ChronoField} then the query is implemented here.\n The {@link #isSupported(TemporalField) supported fields} will return valid\n values based on this date-time, except {@code NANO_OF_DAY}, {@code MICRO_OF_DAY},\n {@code EPOCH_DAY} and {@code PROLEPTIC_MONTH} which are too large to fit in\n an {@code int} and throw a {@code DateTimeException}.\n All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument. Whether the value can be obtained,\n and what the value represents, is determined by the field.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained or\n         the value is outside the range of valid values for the field\n @throws UnsupportedTemporalTypeException if the field is not supported or\n         the range of values exceeds an {@code int}\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.LocalDateTime"
                      "java.time.temporal.TemporalField"]))}
  (^java.lang.Integer
   [^java.time.LocalDateTime this ^java.time.temporal.TemporalField field]
   (.get this field)))

(defn equals
  "Checks if this date-time is equal to another date-time.\n <p>\n Compares this {@code LocalDateTime} with another ensuring that the date-time is the same.\n Only objects of type {@code LocalDateTime} are compared, other types return false.\n\n @param obj  the object to check, null returns false\n @return true if this is equal to the other date-time"
  {:arglists (quote (["java.time.LocalDateTime" "java.lang.Object"]))}
  (^java.lang.Boolean [^java.time.LocalDateTime this ^java.lang.Object obj]
   (.equals this obj)))

(defn format
  "Formats this date-time using the specified formatter.\n <p>\n This date-time will be passed to the formatter to produce a string.\n\n @param formatter  the formatter to use, not null\n @return the formatted date-time string, not null\n @throws DateTimeException if an error occurs during printing"
  {:arglists (quote (["java.time.LocalDateTime"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.lang.String
   [^java.time.LocalDateTime this ^java.time.format.DateTimeFormatter formatter]
   (.format this formatter)))

(defn plus-years
  "Returns a copy of this {@code LocalDateTime} with the specified number of years added.\n <p>\n This method adds the specified amount to the years field in three steps:\n <ol>\n <li>Add the input years to the year field</li>\n <li>Check if the resulting date would be invalid</li>\n <li>Adjust the day-of-month to the last valid day if necessary</li>\n </ol>\n <p>\n For example, 2008-02-29 (leap year) plus one year would result in the\n invalid date 2009-02-29 (standard year). Instead of returning an invalid\n result, the last valid day of the month, 2009-02-28, is selected instead.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param years  the years to add, may be negative\n @return a {@code LocalDateTime} based on this date-time with the years added, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDateTime" "long"]))}
  (^java.time.LocalDateTime [^java.time.LocalDateTime this ^long years]
   (.plusYears this years)))

(defn minus-days
  "Returns a copy of this {@code LocalDateTime} with the specified number of days subtracted.\n <p>\n This method subtracts the specified amount from the days field decrementing the\n month and year fields as necessary to ensure the result remains valid.\n The result is only invalid if the maximum/minimum year is exceeded.\n <p>\n For example, 2009-01-01 minus one day would result in 2008-12-31.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param days  the days to subtract, may be negative\n @return a {@code LocalDateTime} based on this date-time with the days subtracted, not null\n @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.LocalDateTime" "long"]))}
  (^java.time.LocalDateTime [^java.time.LocalDateTime this ^long days]
   (.minusDays this days)))
