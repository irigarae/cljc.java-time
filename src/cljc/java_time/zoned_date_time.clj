(ns cljc.java-time.zoned-date-time
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time ZonedDateTime]))

(defn minus-minutes
  "Returns a copy of this {@code ZonedDateTime} with the specified number of minutes subtracted.

 This operates on the instant time-line, such that subtracting one minute will
 always be a duration of one minute earlier.
 This may cause the local date-time to change by an amount other than one minute.
 Note that this is a different approach to that used by days, months and years.

 This instance is immutable and unaffected by this method call.

 @param minutes  the minutes to subtract, may be negative
 @return a {@code ZonedDateTime} based on this date-time with the minutes subtracted, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.ZonedDateTime" "long"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this ^long minutes]
   (.minusMinutes this minutes)))

(defn truncated-to
  "Returns a copy of this {@code ZonedDateTime} with the time truncated.

 Truncation returns a copy of the original date-time with fields
 smaller than the specified unit set to zero.
 For example, truncating with the {@link ChronoUnit#MINUTES minutes} unit
 will set the second-of-minute and nano-of-second field to zero.

 The unit must have a {@linkplain TemporalUnit#getDuration() duration}
 that divides into the length of a standard day without remainder.
 This includes all supplied time units on {@link ChronoUnit} and
 {@link ChronoUnit#DAYS DAYS}. Other units throw an exception.

 This operates on the local time-line,
 {@link LocalDateTime#truncatedTo(TemporalUnit) truncating}
 the underlying local date-time. This is then converted back to a
 {@code ZonedDateTime}, using the zone ID to obtain the offset.

 When converting back to {@code ZonedDateTime}, if the local date-time is in an overlap,
 then the offset will be retained if possible, otherwise the earlier offset will be used.
 If in a gap, the local date-time will be adjusted forward by the length of the gap.

 This instance is immutable and unaffected by this method call.

 @param unit  the unit to truncate to, not null
 @return a {@code ZonedDateTime} based on this date-time with the time truncated, not null
 @throws DateTimeException if unable to truncate
 @throws UnsupportedTemporalTypeException if the unit is not supported"
  {:arglists (quote (["java.time.ZonedDateTime"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.ZonedDateTime
   [^java.time.ZonedDateTime this ^java.time.temporal.ChronoUnit unit]
   (.truncatedTo this unit)))

(defn minus-weeks
  "Returns a copy of this {@code ZonedDateTime} with the specified number of weeks subtracted.

 This operates on the local time-line,
 {@link LocalDateTime#minusWeeks(long) subtracting weeks} to the local date-time.
 This is then converted back to a {@code ZonedDateTime}, using the zone ID
 to obtain the offset.

 When converting back to {@code ZonedDateTime}, if the local date-time is in an overlap,
 then the offset will be retained if possible, otherwise the earlier offset will be used.
 If in a gap, the local date-time will be adjusted forward by the length of the gap.

 This instance is immutable and unaffected by this method call.

 @param weeks  the weeks to subtract, may be negative
 @return a {@code ZonedDateTime} based on this date-time with the weeks subtracted, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.ZonedDateTime" "long"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this ^long weeks]
   (.minusWeeks this weeks)))

(defn to-instant
  "Converts this date-time to an {@code Instant}.

 This returns an {@code Instant} representing the same point on the
 time-line as this date-time. The calculation combines the
 {@linkplain #toLocalDateTime() local date-time} and
 {@linkplain #getOffset() offset}.

 @return an {@code Instant} representing the same instant, not null"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.time.Instant [^java.time.ZonedDateTime this] (.toInstant this)))

(defn plus-weeks
  "Returns a copy of this {@code ZonedDateTime} with the specified number of weeks added.

 This operates on the local time-line,
 {@link LocalDateTime#plusWeeks(long) adding weeks} to the local date-time.
 This is then converted back to a {@code ZonedDateTime}, using the zone ID
 to obtain the offset.

 When converting back to {@code ZonedDateTime}, if the local date-time is in an overlap,
 then the offset will be retained if possible, otherwise the earlier offset will be used.
 If in a gap, the local date-time will be adjusted forward by the length of the gap.

 This instance is immutable and unaffected by this method call.

 @param weeks  the weeks to add, may be negative
 @return a {@code ZonedDateTime} based on this date-time with the weeks added, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.ZonedDateTime" "long"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this ^long weeks]
   (.plusWeeks this weeks)))

(defn range
  "Gets the range of valid values for the specified field.

 The range object expresses the minimum and maximum valid values for a field.
 This date-time is used to enhance the accuracy of the returned range.
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
  {:arglists (quote (["java.time.ZonedDateTime"
                      "java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ValueRange
   [^java.time.ZonedDateTime this ^java.time.temporal.TemporalField field]
   (.range this field)))

(defn with-earlier-offset-at-overlap
  "Returns a copy of this date-time changing the zone offset to the
 earlier of the two valid offsets at a local time-line overlap.

 This method only has any effect when the local time-line overlaps, such as
 at an autumn daylight savings cutover. In this scenario, there are two
 valid offsets for the local date-time. Calling this method will return
 a zoned date-time with the earlier of the two selected.

 If this method is called when it is not an overlap, {@code this}
 is returned.

 This instance is immutable and unaffected by this method call.

 @return a {@code ZonedDateTime} based on this date-time with the earlier offset, not null"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this]
   (.withEarlierOffsetAtOverlap this)))

(defn get-hour
  "Gets the hour-of-day field.

 @return the hour-of-day, from 0 to 23"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.lang.Integer [^java.time.ZonedDateTime this] (.getHour this)))

(defn minus-hours
  "Returns a copy of this {@code ZonedDateTime} with the specified number of hours subtracted.

 This operates on the instant time-line, such that subtracting one hour will
 always be a duration of one hour earlier.
 This may cause the local date-time to change by an amount other than one hour.
 Note that this is a different approach to that used by days, months and years,
 thus subtracting one day is not the same as adding 24 hours.

 For example, consider a time-zone where the spring DST cutover means that the
 local times 01:00 to 01:59 occur twice changing from offset +02:00 to +01:00.
 <ul>
 <li>Subtracting one hour from 02:30+01:00 will result in 01:30+02:00
 <li>Subtracting one hour from 01:30+01:00 will result in 01:30+02:00
 <li>Subtracting one hour from 01:30+02:00 will result in 00:30+01:00
 <li>Subtracting three hours from 02:30+01:00 will result in 00:30+02:00
 </ul>

 This instance is immutable and unaffected by this method call.

 @param hours  the hours to subtract, may be negative
 @return a {@code ZonedDateTime} based on this date-time with the hours subtracted, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.ZonedDateTime" "long"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this ^long hours]
   (.minusHours this hours)))

(defn of
  {:arglists
     (quote (["java.time.LocalDateTime" "java.time.ZoneId"]
             ["java.time.LocalDate" "java.time.LocalTime" "java.time.ZoneId"]
             ["int" "int" "int" "int" "int" "int" "int" "java.time.ZoneId"]))}
  (^java.time.ZonedDateTime
   [^java.time.LocalDateTime local-date-time ^java.time.ZoneId zone]
   (java.time.ZonedDateTime/of local-date-time zone))
  (^java.time.ZonedDateTime
   [^java.time.LocalDate date ^java.time.LocalTime time ^java.time.ZoneId zone]
   (java.time.ZonedDateTime/of date time zone))
  (^java.time.ZonedDateTime
   [^java.lang.Integer year ^java.lang.Integer month
    ^java.lang.Integer day-of-month ^java.lang.Integer hour
    ^java.lang.Integer minute ^java.lang.Integer second
    ^java.lang.Integer nano-of-second ^java.time.ZoneId zone]
   (java.time.ZonedDateTime/of year
                               month
                               day-of-month
                               hour
                               minute
                               second
                               nano-of-second
                               zone)))

(defn with-month
  "Returns a copy of this {@code ZonedDateTime} with the month-of-year altered.

 This operates on the local time-line,
 {@link LocalDateTime#withMonth(int) changing the month} of the local date-time.
 This is then converted back to a {@code ZonedDateTime}, using the zone ID
 to obtain the offset.

 When converting back to {@code ZonedDateTime}, if the local date-time is in an overlap,
 then the offset will be retained if possible, otherwise the earlier offset will be used.
 If in a gap, the local date-time will be adjusted forward by the length of the gap.

 This instance is immutable and unaffected by this method call.

 @param month  the month-of-year to set in the result, from 1 (January) to 12 (December)
 @return a {@code ZonedDateTime} based on this date-time with the requested month, not null
 @throws DateTimeException if the month-of-year value is invalid"
  {:arglists (quote (["java.time.ZonedDateTime" "int"]))}
  (^java.time.ZonedDateTime
   [^java.time.ZonedDateTime this ^java.lang.Integer month]
   (.withMonth this month)))

(defn is-equal
  "Checks if the instant of this date-time is equal to that of the specified date-time.

 This method differs from the comparison in {@link #compareTo} and {@link #equals}
 in that it only compares the instant of the date-time. This is equivalent to using
 {@code dateTime1.toInstant().equals(dateTime2.toInstant());}.

 This default implementation performs the comparison based on the epoch-second
 and nano-of-second.

 @param other  the other date-time to compare to, not null
 @return true if the instant equals the instant of the specified date-time"
  {:arglists (quote (["java.time.ZonedDateTime"
                      "java.time.chrono.ChronoZonedDateTime"]))}
  (^java.lang.Boolean
   [^java.time.ZonedDateTime this ^java.time.chrono.ChronoZonedDateTime other]
   (.isEqual this other)))

(defn get-nano
  "Gets the nano-of-second field.

 @return the nano-of-second, from 0 to 999,999,999"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.lang.Integer [^java.time.ZonedDateTime this] (.getNano this)))

(defn of-local
  "Obtains an instance of {@code ZonedDateTime} from a local date-time
 using the preferred offset if possible.

 The local date-time is resolved to a single instant on the time-line.
 This is achieved by finding a valid offset from UTC/Greenwich for the local
 date-time as defined by the {@link ZoneRules rules} of the zone ID.

 In most cases, there is only one valid offset for a local date-time.
 In the case of an overlap, where clocks are set back, there are two valid offsets.
 If the preferred offset is one of the valid offsets then it is used.
 Otherwise the earlier valid offset is used, typically corresponding to \"summer\".

 In the case of a gap, where clocks jump forward, there is no valid offset.
 Instead, the local date-time is adjusted to be later by the length of the gap.
 For a typical one hour daylight savings change, the local date-time will be
 moved one hour later into the offset typically corresponding to \"summer\".

 @param localDateTime  the local date-time, not null
 @param zone  the time-zone, not null
 @param preferredOffset  the zone offset, null if no preference
 @return the zoned date-time, not null"
  {:arglists (quote (["java.time.LocalDateTime" "java.time.ZoneId"
                      "java.time.ZoneOffset"]))}
  (^java.time.ZonedDateTime
   [^java.time.LocalDateTime local-date-time ^java.time.ZoneId zone
    ^java.time.ZoneOffset preferred-offset]
   (java.time.ZonedDateTime/ofLocal local-date-time zone preferred-offset)))

(defn get-year
  "Gets the year field.

 This method returns the primitive {@code int} value for the year.

 The year returned by this method is proleptic as per {@code get(YEAR)}.
 To obtain the year-of-era, use {@code get(YEAR_OF_ERA)}.

 @return the year, from MIN_YEAR to MAX_YEAR"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.lang.Integer [^java.time.ZonedDateTime this] (.getYear this)))

(defn minus-seconds
  "Returns a copy of this {@code ZonedDateTime} with the specified number of seconds subtracted.

 This operates on the instant time-line, such that subtracting one second will
 always be a duration of one second earlier.
 This may cause the local date-time to change by an amount other than one second.
 Note that this is a different approach to that used by days, months and years.

 This instance is immutable and unaffected by this method call.

 @param seconds  the seconds to subtract, may be negative
 @return a {@code ZonedDateTime} based on this date-time with the seconds subtracted, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.ZonedDateTime" "long"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this ^long seconds]
   (.minusSeconds this seconds)))

(defn get-second
  "Gets the second-of-minute field.

 @return the second-of-minute, from 0 to 59"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.lang.Integer [^java.time.ZonedDateTime this] (.getSecond this)))

(defn plus-nanos
  "Returns a copy of this {@code ZonedDateTime} with the specified number of nanoseconds added.

 This operates on the instant time-line, such that adding one nano will
 always be a duration of one nano later.
 This may cause the local date-time to change by an amount other than one nano.
 Note that this is a different approach to that used by days, months and years.

 This instance is immutable and unaffected by this method call.

 @param nanos  the nanos to add, may be negative
 @return a {@code ZonedDateTime} based on this date-time with the nanoseconds added, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.ZonedDateTime" "long"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this ^long nanos]
   (.plusNanos this nanos)))

(defn get-day-of-year
  "Gets the day-of-year field.

 This method returns the primitive {@code int} value for the day-of-year.

 @return the day-of-year, from 1 to 365, or 366 in a leap year"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.lang.Integer [^java.time.ZonedDateTime this] (.getDayOfYear this)))

(defn plus
  {:arglists (quote (["java.time.ZonedDateTime"
                      "java.time.temporal.TemporalAmount"]
                     ["java.time.ZonedDateTime" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.ZonedDateTime
   [^java.time.ZonedDateTime this
    ^java.time.temporal.TemporalAmount amount-to-add]
   (.plus this amount-to-add))
  (^java.time.ZonedDateTime
   [^java.time.ZonedDateTime this ^long amount-to-add
    ^java.time.temporal.ChronoUnit unit]
   (.plus this amount-to-add unit)))

(defn with-hour
  "Returns a copy of this {@code ZonedDateTime} with the hour-of-day altered.

 This operates on the local time-line,
 {@linkplain LocalDateTime#withHour(int) changing the time} of the local date-time.
 This is then converted back to a {@code ZonedDateTime}, using the zone ID
 to obtain the offset.

 When converting back to {@code ZonedDateTime}, if the local date-time is in an overlap,
 then the offset will be retained if possible, otherwise the earlier offset will be used.
 If in a gap, the local date-time will be adjusted forward by the length of the gap.

 This instance is immutable and unaffected by this method call.

 @param hour  the hour-of-day to set in the result, from 0 to 23
 @return a {@code ZonedDateTime} based on this date-time with the requested hour, not null
 @throws DateTimeException if the hour value is invalid"
  {:arglists (quote (["java.time.ZonedDateTime" "int"]))}
  (^java.time.ZonedDateTime
   [^java.time.ZonedDateTime this ^java.lang.Integer hour]
   (.withHour this hour)))

(defn with-minute
  "Returns a copy of this {@code ZonedDateTime} with the minute-of-hour altered.

 This operates on the local time-line,
 {@linkplain LocalDateTime#withMinute(int) changing the time} of the local date-time.
 This is then converted back to a {@code ZonedDateTime}, using the zone ID
 to obtain the offset.

 When converting back to {@code ZonedDateTime}, if the local date-time is in an overlap,
 then the offset will be retained if possible, otherwise the earlier offset will be used.
 If in a gap, the local date-time will be adjusted forward by the length of the gap.

 This instance is immutable and unaffected by this method call.

 @param minute  the minute-of-hour to set in the result, from 0 to 59
 @return a {@code ZonedDateTime} based on this date-time with the requested minute, not null
 @throws DateTimeException if the minute value is invalid"
  {:arglists (quote (["java.time.ZonedDateTime" "int"]))}
  (^java.time.ZonedDateTime
   [^java.time.ZonedDateTime this ^java.lang.Integer minute]
   (.withMinute this minute)))

(defn plus-minutes
  "Returns a copy of this {@code ZonedDateTime} with the specified number of minutes added.

 This operates on the instant time-line, such that adding one minute will
 always be a duration of one minute later.
 This may cause the local date-time to change by an amount other than one minute.
 Note that this is a different approach to that used by days, months and years.

 This instance is immutable and unaffected by this method call.

 @param minutes  the minutes to add, may be negative
 @return a {@code ZonedDateTime} based on this date-time with the minutes added, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.ZonedDateTime" "long"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this ^long minutes]
   (.plusMinutes this minutes)))

(defn query
  "Queries this date-time using the specified query.

 This queries this date-time using the specified query strategy object.
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
  {:arglists (quote (["java.time.ZonedDateTime"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object
   [^java.time.ZonedDateTime this ^java.time.temporal.TemporalQuery query]
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
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.time.DayOfWeek [^java.time.ZonedDateTime this] (.getDayOfWeek this)))

(defn to-string
  "Outputs this date-time as a {@code String}, such as
 {@code 2007-12-03T10:15:30+01:00[Europe/Paris]}.

 The format consists of the {@code LocalDateTime} followed by the {@code ZoneOffset}.
 If the {@code ZoneId} is not the same as the offset, then the ID is output.
 The output is compatible with ISO-8601 if the offset and ID are the same.

 @return a string representation of this date-time, not null"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.lang.String [^java.time.ZonedDateTime this] (.toString this)))

(defn plus-months
  "Returns a copy of this {@code ZonedDateTime} with the specified number of months added.

 This operates on the local time-line,
 {@link LocalDateTime#plusMonths(long) adding months} to the local date-time.
 This is then converted back to a {@code ZonedDateTime}, using the zone ID
 to obtain the offset.

 When converting back to {@code ZonedDateTime}, if the local date-time is in an overlap,
 then the offset will be retained if possible, otherwise the earlier offset will be used.
 If in a gap, the local date-time will be adjusted forward by the length of the gap.

 This instance is immutable and unaffected by this method call.

 @param months  the months to add, may be negative
 @return a {@code ZonedDateTime} based on this date-time with the months added, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.ZonedDateTime" "long"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this ^long months]
   (.plusMonths this months)))

(defn is-before
  "Checks if the instant of this date-time is before that of the specified date-time.

 This method differs from the comparison in {@link #compareTo} in that it
 only compares the instant of the date-time. This is equivalent to using
 {@code dateTime1.toInstant().isBefore(dateTime2.toInstant());}.

 This default implementation performs the comparison based on the epoch-second
 and nano-of-second.

 @param other  the other date-time to compare to, not null
 @return true if this point is before the specified date-time"
  {:arglists (quote (["java.time.ZonedDateTime"
                      "java.time.chrono.ChronoZonedDateTime"]))}
  (^java.lang.Boolean
   [^java.time.ZonedDateTime this ^java.time.chrono.ChronoZonedDateTime other]
   (.isBefore this other)))

(defn minus-months
  "Returns a copy of this {@code ZonedDateTime} with the specified number of months subtracted.

 This operates on the local time-line,
 {@link LocalDateTime#minusMonths(long) subtracting months} to the local date-time.
 This is then converted back to a {@code ZonedDateTime}, using the zone ID
 to obtain the offset.

 When converting back to {@code ZonedDateTime}, if the local date-time is in an overlap,
 then the offset will be retained if possible, otherwise the earlier offset will be used.
 If in a gap, the local date-time will be adjusted forward by the length of the gap.

 This instance is immutable and unaffected by this method call.

 @param months  the months to subtract, may be negative
 @return a {@code ZonedDateTime} based on this date-time with the months subtracted, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.ZonedDateTime" "long"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this ^long months]
   (.minusMonths this months)))

(defn minus
  {:arglists (quote (["java.time.ZonedDateTime"
                      "java.time.temporal.TemporalAmount"]
                     ["java.time.ZonedDateTime" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.ZonedDateTime
   [^java.time.ZonedDateTime this
    ^java.time.temporal.TemporalAmount amount-to-subtract]
   (.minus this amount-to-subtract))
  (^java.time.ZonedDateTime
   [^java.time.ZonedDateTime this ^long amount-to-subtract
    ^java.time.temporal.ChronoUnit unit]
   (.minus this amount-to-subtract unit)))

(defn with-fixed-offset-zone
  "Returns a copy of this date-time with the zone ID set to the offset.

 This returns a zoned date-time where the zone ID is the same as {@link #getOffset()}.
 The local date-time, offset and instant of the result will be the same as in this date-time.

 Setting the date-time to a fixed single offset means that any future
 calculations, such as addition or subtraction, have no complex edge cases
 due to time-zone rules.
 This might also be useful when sending a zoned date-time across a network,
 as most protocols, such as ISO-8601, only handle offsets,
 and not region-based zone IDs.

 This is equivalent to {@code ZonedDateTime.of(zdt.toLocalDateTime(), zdt.getOffset())}.

 @return a {@code ZonedDateTime} with the zone ID set to the offset, not null"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this]
   (.withFixedOffsetZone this)))

(defn plus-hours
  "Returns a copy of this {@code ZonedDateTime} with the specified number of hours added.

 This operates on the instant time-line, such that adding one hour will
 always be a duration of one hour later.
 This may cause the local date-time to change by an amount other than one hour.
 Note that this is a different approach to that used by days, months and years,
 thus adding one day is not the same as adding 24 hours.

 For example, consider a time-zone where the spring DST cutover means that the
 local times 01:00 to 01:59 occur twice changing from offset +02:00 to +01:00.
 <ul>
 <li>Adding one hour to 00:30+02:00 will result in 01:30+02:00
 <li>Adding one hour to 01:30+02:00 will result in 01:30+01:00
 <li>Adding one hour to 01:30+01:00 will result in 02:30+01:00
 <li>Adding three hours to 00:30+02:00 will result in 02:30+01:00
 </ul>

 This instance is immutable and unaffected by this method call.

 @param hours  the hours to add, may be negative
 @return a {@code ZonedDateTime} based on this date-time with the hours added, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.ZonedDateTime" "long"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this ^long hours]
   (.plusHours this hours)))

(defn with-zone-same-local
  "Returns a copy of this date-time with a different time-zone,
 retaining the local date-time if possible.

 This method changes the time-zone and retains the local date-time.
 The local date-time is only changed if it is invalid for the new zone,
 determined using the same approach as
 {@link #ofLocal(LocalDateTime, ZoneId, ZoneOffset)}.

 To change the zone and adjust the local date-time,
 use {@link #withZoneSameInstant(ZoneId)}.

 This instance is immutable and unaffected by this method call.

 @param zone  the time-zone to change to, not null
 @return a {@code ZonedDateTime} based on this date-time with the requested zone, not null"
  {:arglists (quote (["java.time.ZonedDateTime" "java.time.ZoneId"]))}
  (^java.time.ZonedDateTime
   [^java.time.ZonedDateTime this ^java.time.ZoneId zone]
   (.withZoneSameLocal this zone)))

(defn with-zone-same-instant
  "Returns a copy of this date-time with a different time-zone,
 retaining the instant.

 This method changes the time-zone and retains the instant.
 This normally results in a change to the local date-time.

 This method is based on retaining the same instant, thus gaps and overlaps
 in the local time-line have no effect on the result.

 To change the offset while keeping the local time,
 use {@link #withZoneSameLocal(ZoneId)}.

 @param zone  the time-zone to change to, not null
 @return a {@code ZonedDateTime} based on this date-time with the requested zone, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.ZonedDateTime" "java.time.ZoneId"]))}
  (^java.time.ZonedDateTime
   [^java.time.ZonedDateTime this ^java.time.ZoneId zone]
   (.withZoneSameInstant this zone)))

(defn plus-days
  "Returns a copy of this {@code ZonedDateTime} with the specified number of days added.

 This operates on the local time-line,
 {@link LocalDateTime#plusDays(long) adding days} to the local date-time.
 This is then converted back to a {@code ZonedDateTime}, using the zone ID
 to obtain the offset.

 When converting back to {@code ZonedDateTime}, if the local date-time is in an overlap,
 then the offset will be retained if possible, otherwise the earlier offset will be used.
 If in a gap, the local date-time will be adjusted forward by the length of the gap.

 This instance is immutable and unaffected by this method call.

 @param days  the days to add, may be negative
 @return a {@code ZonedDateTime} based on this date-time with the days added, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.ZonedDateTime" "long"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this ^long days]
   (.plusDays this days)))

(defn to-local-time
  "Gets the {@code LocalTime} part of this date-time.

 This returns a {@code LocalTime} with the same hour, minute, second and
 nanosecond as this date-time.

 @return the time part of this date-time, not null"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.time.LocalTime [^java.time.ZonedDateTime this] (.toLocalTime this)))

(defn get-long
  "Gets the value of the specified field from this date-time as a {@code long}.

 This queries this date-time for the value of the specified field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@link #isSupported(TemporalField) supported fields} will return valid
 values based on this date-time.
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
  {:arglists (quote (["java.time.ZonedDateTime"
                      "java.time.temporal.TemporalField"]))}
  (^long [^java.time.ZonedDateTime this ^java.time.temporal.TemporalField field]
   (.getLong this field)))

(defn get-offset
  "Gets the zone offset, such as '+01:00'.

 This is the offset of the local date-time from UTC/Greenwich.

 @return the zone offset, not null"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.time.ZoneOffset [^java.time.ZonedDateTime this] (.getOffset this)))

(defn with-year
  "Returns a copy of this {@code ZonedDateTime} with the year altered.

 This operates on the local time-line,
 {@link LocalDateTime#withYear(int) changing the year} of the local date-time.
 This is then converted back to a {@code ZonedDateTime}, using the zone ID
 to obtain the offset.

 When converting back to {@code ZonedDateTime}, if the local date-time is in an overlap,
 then the offset will be retained if possible, otherwise the earlier offset will be used.
 If in a gap, the local date-time will be adjusted forward by the length of the gap.

 This instance is immutable and unaffected by this method call.

 @param year  the year to set in the result, from MIN_YEAR to MAX_YEAR
 @return a {@code ZonedDateTime} based on this date-time with the requested year, not null
 @throws DateTimeException if the year value is invalid"
  {:arglists (quote (["java.time.ZonedDateTime" "int"]))}
  (^java.time.ZonedDateTime
   [^java.time.ZonedDateTime this ^java.lang.Integer year]
   (.withYear this year)))

(defn with-nano
  "Returns a copy of this {@code ZonedDateTime} with the nano-of-second altered.

 This operates on the local time-line,
 {@linkplain LocalDateTime#withNano(int) changing the time} of the local date-time.
 This is then converted back to a {@code ZonedDateTime}, using the zone ID
 to obtain the offset.

 When converting back to {@code ZonedDateTime}, if the local date-time is in an overlap,
 then the offset will be retained if possible, otherwise the earlier offset will be used.
 If in a gap, the local date-time will be adjusted forward by the length of the gap.

 This instance is immutable and unaffected by this method call.

 @param nanoOfSecond  the nano-of-second to set in the result, from 0 to 999,999,999
 @return a {@code ZonedDateTime} based on this date-time with the requested nanosecond, not null
 @throws DateTimeException if the nano value is invalid"
  {:arglists (quote (["java.time.ZonedDateTime" "int"]))}
  (^java.time.ZonedDateTime
   [^java.time.ZonedDateTime this ^java.lang.Integer nano-of-second]
   (.withNano this nano-of-second)))

(defn to-epoch-second
  "Converts this date-time to the number of seconds from the epoch
 of 1970-01-01T00:00:00Z.

 This uses the {@linkplain #toLocalDateTime() local date-time} and
 {@linkplain #getOffset() offset} to calculate the epoch-second value,
 which is the number of elapsed seconds from 1970-01-01T00:00:00Z.
 Instants on the time-line after the epoch are positive, earlier are negative.

 @return the number of seconds from the epoch of 1970-01-01T00:00:00Z"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^long [^java.time.ZonedDateTime this] (.toEpochSecond this)))

(defn to-offset-date-time
  "Converts this date-time to an {@code OffsetDateTime}.

 This creates an offset date-time using the local date-time and offset.
 The zone ID is ignored.

 @return an offset date-time representing the same local date-time and offset, not null"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.time.OffsetDateTime [^java.time.ZonedDateTime this]
   (.toOffsetDateTime this)))

(defn with-later-offset-at-overlap
  "Returns a copy of this date-time changing the zone offset to the
 later of the two valid offsets at a local time-line overlap.

 This method only has any effect when the local time-line overlaps, such as
 at an autumn daylight savings cutover. In this scenario, there are two
 valid offsets for the local date-time. Calling this method will return
 a zoned date-time with the later of the two selected.

 If this method is called when it is not an overlap, {@code this}
 is returned.

 This instance is immutable and unaffected by this method call.

 @return a {@code ZonedDateTime} based on this date-time with the later offset, not null"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this]
   (.withLaterOffsetAtOverlap this)))

(defn until
  "Calculates the amount of time until another date-time in terms of the specified unit.

 This calculates the amount of time between two {@code ZonedDateTime}
 objects in terms of a single {@code TemporalUnit}.
 The start and end points are {@code this} and the specified date-time.
 The result will be negative if the end is before the start.
 For example, the amount in days between two date-times can be calculated
 using {@code startDateTime.until(endDateTime, DAYS)}.

 The {@code Temporal} passed to this method is converted to a
 {@code ZonedDateTime} using {@link #from(TemporalAccessor)}.
 If the time-zone differs between the two zoned date-times, the specified
 end date-time is normalized to have the same zone as this date-time.

 The calculation returns a whole number, representing the number of
 complete units between the two date-times.
 For example, the amount in months between 2012-06-15T00:00Z and 2012-08-14T23:59Z
 will only be one month as it is one minute short of two months.

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
 The units {@code NANOS}, {@code MICROS}, {@code MILLIS}, {@code SECONDS},
 {@code MINUTES}, {@code HOURS} and {@code HALF_DAYS}, {@code DAYS},
 {@code WEEKS}, {@code MONTHS}, {@code YEARS}, {@code DECADES},
 {@code CENTURIES}, {@code MILLENNIA} and {@code ERAS} are supported.
 Other {@code ChronoUnit} values will throw an exception.

 The calculation for date and time units differ.

 Date units operate on the local time-line, using the local date-time.
 For example, the period from noon on day 1 to noon the following day
 in days will always be counted as exactly one day, irrespective of whether
 there was a daylight savings change or not.

 Time units operate on the instant time-line.
 The calculation effectively converts both zoned date-times to instants
 and then calculates the period between the instants.
 For example, the period from noon on day 1 to noon the following day
 in hours may be 23, 24 or 25 hours (or some other amount) depending on
 whether there was a daylight savings change or not.

 If the unit is not a {@code ChronoUnit}, then the result of this method
 is obtained by invoking {@code TemporalUnit.between(Temporal, Temporal)}
 passing {@code this} as the first argument and the converted input temporal
 as the second argument.

 This instance is immutable and unaffected by this method call.

 @param endExclusive  the end date, exclusive, which is converted to a {@code ZonedDateTime}, not null
 @param unit  the unit to measure the amount in, not null
 @return the amount of time between this date-time and the end date-time
 @throws DateTimeException if the amount cannot be calculated, or the end
  temporal cannot be converted to a {@code ZonedDateTime}
 @throws UnsupportedTemporalTypeException if the unit is not supported
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.ZonedDateTime" "java.time.temporal.Temporal"
                      "java.time.temporal.TemporalUnit"]))}
  (^long
   [^java.time.ZonedDateTime this ^java.time.temporal.Temporal end-exclusive
    ^java.time.temporal.ChronoUnit unit]
   (.until this end-exclusive unit)))

(defn get-zone
  "Gets the time-zone, such as 'Europe/Paris'.

 This returns the zone ID. This identifies the time-zone {@link ZoneRules rules}
 that determine when and how the offset from UTC/Greenwich changes.

 The zone ID may be same as the {@linkplain #getOffset() offset}.
 If this is true, then any future calculations, such as addition or subtraction,
 have no complex edge cases due to time-zone rules.
 See also {@link #withFixedOffsetZone()}.

 @return the time-zone, not null"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.time.ZoneId [^java.time.ZonedDateTime this] (.getZone this)))

(defn with-day-of-month
  "Returns a copy of this {@code ZonedDateTime} with the day-of-month altered.

 This operates on the local time-line,
 {@link LocalDateTime#withDayOfMonth(int) changing the day-of-month} of the local date-time.
 This is then converted back to a {@code ZonedDateTime}, using the zone ID
 to obtain the offset.

 When converting back to {@code ZonedDateTime}, if the local date-time is in an overlap,
 then the offset will be retained if possible, otherwise the earlier offset will be used.
 If in a gap, the local date-time will be adjusted forward by the length of the gap.

 This instance is immutable and unaffected by this method call.

 @param dayOfMonth  the day-of-month to set in the result, from 1 to 28-31
 @return a {@code ZonedDateTime} based on this date-time with the requested day, not null
 @throws DateTimeException if the day-of-month value is invalid,
  or if the day-of-month is invalid for the month-year"
  {:arglists (quote (["java.time.ZonedDateTime" "int"]))}
  (^java.time.ZonedDateTime
   [^java.time.ZonedDateTime this ^java.lang.Integer day-of-month]
   (.withDayOfMonth this day-of-month)))

(defn get-day-of-month
  "Gets the day-of-month field.

 This method returns the primitive {@code int} value for the day-of-month.

 @return the day-of-month, from 1 to 31"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.lang.Integer [^java.time.ZonedDateTime this] (.getDayOfMonth this)))

(defn from
  "Obtains an instance of {@code ZonedDateTime} from a temporal object.

 This obtains a zoned date-time based on the specified temporal.
 A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 which this factory converts to an instance of {@code ZonedDateTime}.

 The conversion will first obtain a {@code ZoneId} from the temporal object,
 falling back to a {@code ZoneOffset} if necessary. It will then try to obtain
 an {@code Instant}, falling back to a {@code LocalDateTime} if necessary.
 The result will be either the combination of {@code ZoneId} or {@code ZoneOffset}
 with {@code Instant} or {@code LocalDateTime}.
 Implementations are permitted to perform optimizations such as accessing
 those fields that are equivalent to the relevant objects.

 This method matches the signature of the functional interface {@link TemporalQuery}
 allowing it to be used as a query via method reference, {@code ZonedDateTime::from}.

 @param temporal  the temporal object to convert, not null
 @return the zoned date-time, not null
 @throws DateTimeException if unable to convert to an {@code ZonedDateTime}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^java.time.ZonedDateTime [^java.time.temporal.TemporalAccessor temporal]
   (java.time.ZonedDateTime/from temporal)))

(defn is-after
  "Checks if the instant of this date-time is after that of the specified date-time.

 This method differs from the comparison in {@link #compareTo} in that it
 only compares the instant of the date-time. This is equivalent to using
 {@code dateTime1.toInstant().isAfter(dateTime2.toInstant());}.

 This default implementation performs the comparison based on the epoch-second
 and nano-of-second.

 @param other  the other date-time to compare to, not null
 @return true if this is after the specified date-time"
  {:arglists (quote (["java.time.ZonedDateTime"
                      "java.time.chrono.ChronoZonedDateTime"]))}
  (^java.lang.Boolean
   [^java.time.ZonedDateTime this ^java.time.chrono.ChronoZonedDateTime other]
   (.isAfter this other)))

(defn minus-nanos
  "Returns a copy of this {@code ZonedDateTime} with the specified number of nanoseconds subtracted.

 This operates on the instant time-line, such that subtracting one nano will
 always be a duration of one nano earlier.
 This may cause the local date-time to change by an amount other than one nano.
 Note that this is a different approach to that used by days, months and years.

 This instance is immutable and unaffected by this method call.

 @param nanos  the nanos to subtract, may be negative
 @return a {@code ZonedDateTime} based on this date-time with the nanoseconds subtracted, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.ZonedDateTime" "long"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this ^long nanos]
   (.minusNanos this nanos)))

(defn is-supported
  {:arglists (quote
               (["java.time.ZonedDateTime" "java.time.temporal.TemporalField"]
                ["java.time.ZonedDateTime" "java.time.temporal.TemporalUnit"]))}
  (^java.lang.Boolean [this arg0]
   (cond (and (instance? java.time.temporal.TemporalField arg0))
           (let [field ^"java.time.temporal.TemporalField" arg0]
             (.isSupported ^java.time.ZonedDateTime this field))
         (and (instance? java.time.temporal.ChronoUnit arg0))
           (let [unit ^"java.time.temporal.ChronoUnit" arg0]
             (.isSupported ^java.time.ZonedDateTime this unit))
         :else (throw (java.lang.IllegalArgumentException.
                        "no corresponding java.time method with these args")))))

(defn minus-years
  "Returns a copy of this {@code ZonedDateTime} with the specified number of years subtracted.

 This operates on the local time-line,
 {@link LocalDateTime#minusYears(long) subtracting years} to the local date-time.
 This is then converted back to a {@code ZonedDateTime}, using the zone ID
 to obtain the offset.

 When converting back to {@code ZonedDateTime}, if the local date-time is in an overlap,
 then the offset will be retained if possible, otherwise the earlier offset will be used.
 If in a gap, the local date-time will be adjusted forward by the length of the gap.

 This instance is immutable and unaffected by this method call.

 @param years  the years to subtract, may be negative
 @return a {@code ZonedDateTime} based on this date-time with the years subtracted, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.ZonedDateTime" "long"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this ^long years]
   (.minusYears this years)))

(defn get-chronology
  "Gets the chronology of this date-time.

 The {@code Chronology} represents the calendar system in use.
 The era and other fields in {@link ChronoField} are defined by the chronology.

 @return the chronology, not null"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.time.chrono.Chronology [^java.time.ZonedDateTime this]
   (.getChronology this)))

(defn parse
  {:arglists (quote (["java.lang.CharSequence"]
                     ["java.lang.CharSequence"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.time.ZonedDateTime [^java.lang.CharSequence text]
   (java.time.ZonedDateTime/parse text))
  (^java.time.ZonedDateTime
   [^java.lang.CharSequence text ^java.time.format.DateTimeFormatter formatter]
   (java.time.ZonedDateTime/parse text formatter)))

(defn with-second
  "Returns a copy of this {@code ZonedDateTime} with the second-of-minute altered.

 This operates on the local time-line,
 {@linkplain LocalDateTime#withSecond(int) changing the time} of the local date-time.
 This is then converted back to a {@code ZonedDateTime}, using the zone ID
 to obtain the offset.

 When converting back to {@code ZonedDateTime}, if the local date-time is in an overlap,
 then the offset will be retained if possible, otherwise the earlier offset will be used.
 If in a gap, the local date-time will be adjusted forward by the length of the gap.

 This instance is immutable and unaffected by this method call.

 @param second  the second-of-minute to set in the result, from 0 to 59
 @return a {@code ZonedDateTime} based on this date-time with the requested second, not null
 @throws DateTimeException if the second value is invalid"
  {:arglists (quote (["java.time.ZonedDateTime" "int"]))}
  (^java.time.ZonedDateTime
   [^java.time.ZonedDateTime this ^java.lang.Integer second]
   (.withSecond this second)))

(defn to-local-date
  "Gets the {@code LocalDate} part of this date-time.

 This returns a {@code LocalDate} with the same year, month and day
 as this date-time.

 @return the date part of this date-time, not null"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.time.LocalDate [^java.time.ZonedDateTime this] (.toLocalDate this)))

(defn get-minute
  "Gets the minute-of-hour field.

 @return the minute-of-hour, from 0 to 59"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.lang.Integer [^java.time.ZonedDateTime this] (.getMinute this)))

(defn hash-code
  "A hash code for this date-time.

 @return a suitable hash code"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.lang.Integer [^java.time.ZonedDateTime this] (.hashCode this)))

(defn with
  {:arglists (quote (["java.time.ZonedDateTime"
                      "java.time.temporal.TemporalAdjuster"]
                     ["java.time.ZonedDateTime"
                      "java.time.temporal.TemporalField" "long"]))}
  (^java.time.ZonedDateTime
   [^java.time.ZonedDateTime this ^java.time.temporal.TemporalAdjuster adjuster]
   (.with this adjuster))
  (^java.time.ZonedDateTime
   [^java.time.ZonedDateTime this ^java.time.temporal.TemporalField field
    ^long new-value]
   (.with this field new-value)))

(defn now
  {:arglists (quote ([] ["java.time.Clock"] ["java.time.ZoneId"]))}
  (^java.time.ZonedDateTime [] (java.time.ZonedDateTime/now))
  (^java.time.ZonedDateTime [arg0]
   (cond (and (instance? java.time.Clock arg0))
           (let [clock ^"java.time.Clock" arg0]
             (java.time.ZonedDateTime/now clock))
         (and (instance? java.time.ZoneId arg0))
           (let [zone ^"java.time.ZoneId" arg0]
             (java.time.ZonedDateTime/now zone))
         :else (throw (java.lang.IllegalArgumentException.
                        "no corresponding java.time method with these args")))))

(defn to-local-date-time
  "Gets the {@code LocalDateTime} part of this date-time.

 This returns a {@code LocalDateTime} with the same year, month, day and time
 as this date-time.

 @return the local date-time part of this date-time, not null"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.time.LocalDateTime [^java.time.ZonedDateTime this]
   (.toLocalDateTime this)))

(defn get-month-value
  "Gets the month-of-year field from 1 to 12.

 This method returns the month as an {@code int} from 1 to 12.
 Application code is frequently clearer if the enum {@link Month}
 is used by calling {@link #getMonth()}.

 @return the month-of-year, from 1 to 12
 @see #getMonth()"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.lang.Integer [^java.time.ZonedDateTime this] (.getMonthValue this)))

(defn with-day-of-year
  "Returns a copy of this {@code ZonedDateTime} with the day-of-year altered.

 This operates on the local time-line,
 {@link LocalDateTime#withDayOfYear(int) changing the day-of-year} of the local date-time.
 This is then converted back to a {@code ZonedDateTime}, using the zone ID
 to obtain the offset.

 When converting back to {@code ZonedDateTime}, if the local date-time is in an overlap,
 then the offset will be retained if possible, otherwise the earlier offset will be used.
 If in a gap, the local date-time will be adjusted forward by the length of the gap.

 This instance is immutable and unaffected by this method call.

 @param dayOfYear  the day-of-year to set in the result, from 1 to 365-366
 @return a {@code ZonedDateTime} based on this date with the requested day, not null
 @throws DateTimeException if the day-of-year value is invalid,
  or if the day-of-year is invalid for the year"
  {:arglists (quote (["java.time.ZonedDateTime" "int"]))}
  (^java.time.ZonedDateTime
   [^java.time.ZonedDateTime this ^java.lang.Integer day-of-year]
   (.withDayOfYear this day-of-year)))

(defn compare-to
  "Compares this date-time to another date-time, including the chronology.

 The comparison is based first on the instant, then on the local date-time,
 then on the zone ID, then on the chronology.
 It is \"consistent with equals\", as defined by {@link Comparable}.

 If all the date-time objects being compared are in the same chronology, then the
 additional chronology stage is not required.

 This default implementation performs the comparison defined above.

 @param other  the other date-time to compare to, not null
 @return the comparator value, negative if less, positive if greater"
  {:arglists (quote (["java.time.ZonedDateTime"
                      "java.time.chrono.ChronoZonedDateTime"]))}
  (^java.lang.Integer
   [^java.time.ZonedDateTime this ^java.time.chrono.ChronoZonedDateTime other]
   (.compareTo this other)))

(defn of-strict
  "Obtains an instance of {@code ZonedDateTime} strictly validating the
 combination of local date-time, offset and zone ID.

 This creates a zoned date-time ensuring that the offset is valid for the
 local date-time according to the rules of the specified zone.
 If the offset is invalid, an exception is thrown.

 @param localDateTime  the local date-time, not null
 @param offset  the zone offset, not null
 @param zone  the time-zone, not null
 @return the zoned date-time, not null"
  {:arglists (quote (["java.time.LocalDateTime" "java.time.ZoneOffset"
                      "java.time.ZoneId"]))}
  (^java.time.ZonedDateTime
   [^java.time.LocalDateTime local-date-time ^java.time.ZoneOffset offset
    ^java.time.ZoneId zone]
   (java.time.ZonedDateTime/ofStrict local-date-time offset zone)))

(defn get-month
  "Gets the month-of-year field using the {@code Month} enum.

 This method returns the enum {@link Month} for the month.
 This avoids confusion as to what {@code int} values mean.
 If you need access to the primitive {@code int} value then the enum
 provides the {@link Month#getValue() int value}.

 @return the month-of-year, not null
 @see #getMonthValue()"
  {:arglists (quote (["java.time.ZonedDateTime"]))}
  (^java.time.Month [^java.time.ZonedDateTime this] (.getMonth this)))

(defn of-instant
  {:arglists (quote (["java.time.Instant" "java.time.ZoneId"]
                     ["java.time.LocalDateTime" "java.time.ZoneOffset"
                      "java.time.ZoneId"]))}
  (^java.time.ZonedDateTime [^java.time.Instant instant ^java.time.ZoneId zone]
   (java.time.ZonedDateTime/ofInstant instant zone))
  (^java.time.ZonedDateTime
   [^java.time.LocalDateTime local-date-time ^java.time.ZoneOffset offset
    ^java.time.ZoneId zone]
   (java.time.ZonedDateTime/ofInstant local-date-time offset zone)))

(defn plus-seconds
  "Returns a copy of this {@code ZonedDateTime} with the specified number of seconds added.

 This operates on the instant time-line, such that adding one second will
 always be a duration of one second later.
 This may cause the local date-time to change by an amount other than one second.
 Note that this is a different approach to that used by days, months and years.

 This instance is immutable and unaffected by this method call.

 @param seconds  the seconds to add, may be negative
 @return a {@code ZonedDateTime} based on this date-time with the seconds added, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.ZonedDateTime" "long"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this ^long seconds]
   (.plusSeconds this seconds)))

(defn get
  "Gets the value of the specified field from this date-time as an {@code int}.

 This queries this date-time for the value of the specified field.
 The returned value will always be within the valid range of values for the field.
 If it is not possible to return the value, because the field is not supported
 or for some other reason, an exception is thrown.

 If the field is a {@link ChronoField} then the query is implemented here.
 The {@link #isSupported(TemporalField) supported fields} will return valid
 values based on this date-time, except {@code NANO_OF_DAY}, {@code MICRO_OF_DAY},
 {@code EPOCH_DAY}, {@code PROLEPTIC_MONTH} and {@code INSTANT_SECONDS} which are too
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
  {:arglists (quote (["java.time.ZonedDateTime"
                      "java.time.temporal.TemporalField"]))}
  (^java.lang.Integer
   [^java.time.ZonedDateTime this ^java.time.temporal.TemporalField field]
   (.get this field)))

(defn equals
  "Checks if this date-time is equal to another date-time.

 The comparison is based on the offset date-time and the zone.
 Only objects of type {@code ZonedDateTime} are compared, other types return false.

 @param obj  the object to check, null returns false
 @return true if this is equal to the other date-time"
  {:arglists (quote (["java.time.ZonedDateTime" "java.lang.Object"]))}
  (^java.lang.Boolean [^java.time.ZonedDateTime this ^java.lang.Object obj]
   (.equals this obj)))

(defn format
  "Formats this date-time using the specified formatter.

 This date-time will be passed to the formatter to produce a string.

 @param formatter  the formatter to use, not null
 @return the formatted date-time string, not null
 @throws DateTimeException if an error occurs during printing"
  {:arglists (quote (["java.time.ZonedDateTime"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.lang.String
   [^java.time.ZonedDateTime this ^java.time.format.DateTimeFormatter formatter]
   (.format this formatter)))

(defn plus-years
  "Returns a copy of this {@code ZonedDateTime} with the specified number of years added.

 This operates on the local time-line,
 {@link LocalDateTime#plusYears(long) adding years} to the local date-time.
 This is then converted back to a {@code ZonedDateTime}, using the zone ID
 to obtain the offset.

 When converting back to {@code ZonedDateTime}, if the local date-time is in an overlap,
 then the offset will be retained if possible, otherwise the earlier offset will be used.
 If in a gap, the local date-time will be adjusted forward by the length of the gap.

 This instance is immutable and unaffected by this method call.

 @param years  the years to add, may be negative
 @return a {@code ZonedDateTime} based on this date-time with the years added, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.ZonedDateTime" "long"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this ^long years]
   (.plusYears this years)))

(defn minus-days
  "Returns a copy of this {@code ZonedDateTime} with the specified number of days subtracted.

 This operates on the local time-line,
 {@link LocalDateTime#minusDays(long) subtracting days} to the local date-time.
 This is then converted back to a {@code ZonedDateTime}, using the zone ID
 to obtain the offset.

 When converting back to {@code ZonedDateTime}, if the local date-time is in an overlap,
 then the offset will be retained if possible, otherwise the earlier offset will be used.
 If in a gap, the local date-time will be adjusted forward by the length of the gap.

 This instance is immutable and unaffected by this method call.

 @param days  the days to subtract, may be negative
 @return a {@code ZonedDateTime} based on this date-time with the days subtracted, not null
 @throws DateTimeException if the result exceeds the supported date range"
  {:arglists (quote (["java.time.ZonedDateTime" "long"]))}
  (^java.time.ZonedDateTime [^java.time.ZonedDateTime this ^long days]
   (.minusDays this days)))
