(ns cljc.java-time.temporal.chrono-field
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time.temporal ChronoField]))

(def milli-of-second
  "The milli-of-second.

 This counts the millisecond within the second, from 0 to 999.
 This field has the same meaning for all calendar systems.

 This field is used to represent the milli-of-second handling any fraction of the second.
 Implementations of {@code TemporalAccessor} should provide a value for this field if
 they can return a value for {@link #SECOND_OF_MINUTE}, {@link #SECOND_OF_DAY} or
 {@link #INSTANT_SECONDS} filling unknown precision with zero.

 When this field is used for setting a value, it should behave in the same way as
 setting {@link #NANO_OF_SECOND} with the value multiplied by 1,000,000.

 When parsing this field it behaves equivalent to the following:
 The value is validated in strict and smart mode but not in lenient mode.
 The field is resolved in combination with {@code MICRO_OF_SECOND} to produce
 {@code NANO_OF_SECOND}."
  java.time.temporal.ChronoField/MILLI_OF_SECOND)

(def year-of-era
  "The year within the era.

 This represents the concept of the year within the era.
 This field is typically used with {@link #ERA}.

 The standard mental model for a date is based on three concepts - year, month and day.
 These map onto the {@code YEAR}, {@code MONTH_OF_YEAR} and {@code DAY_OF_MONTH} fields.
 Note that there is no reference to eras.
 The full model for a date requires four concepts - era, year, month and day. These map onto
 the {@code ERA}, {@code YEAR_OF_ERA}, {@code MONTH_OF_YEAR} and {@code DAY_OF_MONTH} fields.
 Whether this field or {@code YEAR} is used depends on which mental model is being used.
 See {@link ChronoLocalDate} for more discussion on this topic.

 In the default ISO calendar system, there are two eras defined, 'BCE' and 'CE'.
 The era 'CE' is the one currently in use and year-of-era runs from 1 to the maximum value.
 The era 'BCE' is the previous era, and the year-of-era runs backwards.

 For example, subtracting a year each time yield the following:<br>
 - year-proleptic 2  = 'CE' year-of-era 2<br>
 - year-proleptic 1  = 'CE' year-of-era 1<br>
 - year-proleptic 0  = 'BCE' year-of-era 1<br>
 - year-proleptic -1 = 'BCE' year-of-era 2<br>

 Note that the ISO-8601 standard does not actually define eras.
 Note also that the ISO eras do not align with the well-known AD/BC eras due to the
 change between the Julian and Gregorian calendar systems.

 Non-ISO calendar systems should implement this field using the most recognized
 year-of-era value for users of the calendar system.
 Since most calendar systems have only two eras, the year-of-era numbering approach
 will typically be the same as that used by the ISO calendar system.
 The year-of-era value should typically always be positive, however this is not required."
  java.time.temporal.ChronoField/YEAR_OF_ERA)

(def clock-hour-of-day
  "The clock-hour-of-day.

 This counts the hour within the AM/PM, from 1 to 24.
 This is the hour that would be observed on a 24-hour analog wall clock.
 This field has the same meaning for all calendar systems.

 When parsing this field it behaves equivalent to the following:
 The value is validated from 1 to 24 in strict mode and from
 0 to 24 in smart mode. In lenient mode the value is not validated.
 The field is converted to an {@code HOUR_OF_DAY} with the same value,
 unless the value is 24, in which case it is converted to 0."
  java.time.temporal.ChronoField/CLOCK_HOUR_OF_DAY)

(def era
  "The era.

 This represents the concept of the era, which is the largest division of the time-line.
 This field is typically used with {@link #YEAR_OF_ERA}.

 In the default ISO calendar system, there are two eras defined, 'BCE' and 'CE'.
 The era 'CE' is the one currently in use and year-of-era runs from 1 to the maximum value.
 The era 'BCE' is the previous era, and the year-of-era runs backwards.
 See {@link #YEAR_OF_ERA} for a full example.

 Non-ISO calendar systems should implement this field to define eras.
 The value of the era that was active on 1970-01-01 (ISO) must be assigned the value 1.
 Earlier eras must have sequentially smaller values.
 Later eras must have sequentially larger values,"
  java.time.temporal.ChronoField/ERA)

(def instant-seconds
  "The instant epoch-seconds.

 This represents the concept of the sequential count of seconds where
 1970-01-01T00:00Z (ISO) is zero.
 This field may be used with {@link #NANO_OF_SECOND} to represent the fraction of the second.

 An {@link Instant} represents an instantaneous point on the time-line.
 On their own, an instant has insufficient information to allow a local date-time to be obtained.
 Only when paired with an offset or time-zone can the local date or time be calculated.

 This field is strictly defined to have the same meaning in all calendar systems.
 This is necessary to ensure interoperation between calendars."
  java.time.temporal.ChronoField/INSTANT_SECONDS)

(def ampm-of-day
  "The am-pm-of-day.

 This counts the AM/PM within the day, from 0 (AM) to 1 (PM).
 This field has the same meaning for all calendar systems.

 When parsing this field it behaves equivalent to the following:
 The value is validated from 0 to 1 in strict and smart mode.
 In lenient mode the value is not validated. It is combined with
 {@code HOUR_OF_AMPM} to form {@code HOUR_OF_DAY} by multiplying
 the {AMPM_OF_DAY} value by 12."
  java.time.temporal.ChronoField/AMPM_OF_DAY)

(def offset-seconds
  "The offset from UTC/Greenwich.

 This represents the concept of the offset in seconds of local time from UTC/Greenwich.

 A {@link ZoneOffset} represents the period of time that local time differs from UTC/Greenwich.
 This is usually a fixed number of hours and minutes.
 It is equivalent to the {@link ZoneOffset#getTotalSeconds() total amount} of the offset in seconds.
 For example, during the winter Paris has an offset of {@code +01:00}, which is 3600 seconds.

 This field is strictly defined to have the same meaning in all calendar systems.
 This is necessary to ensure interoperation between calendars."
  java.time.temporal.ChronoField/OFFSET_SECONDS)

(def nano-of-second
  "The nano-of-second.

 This counts the nanosecond within the second, from 0 to 999,999,999.
 This field has the same meaning for all calendar systems.

 This field is used to represent the nano-of-second handling any fraction of the second.
 Implementations of {@code TemporalAccessor} should provide a value for this field if
 they can return a value for {@link #SECOND_OF_MINUTE}, {@link #SECOND_OF_DAY} or
 {@link #INSTANT_SECONDS} filling unknown precision with zero.

 When this field is used for setting a value, it should set as much precision as the
 object stores, using integer division to remove excess precision.
 For example, if the {@code TemporalAccessor} stores time to millisecond precision,
 then the nano-of-second must be divided by 1,000,000 before replacing the milli-of-second.

 When parsing this field it behaves equivalent to the following:
 The value is validated in strict and smart mode but not in lenient mode.
 The field is resolved in combination with {@code MILLI_OF_SECOND} and {@code MICRO_OF_SECOND}."
  java.time.temporal.ChronoField/NANO_OF_SECOND)

(def nano-of-day
  "The nano-of-day.

 This counts the nanosecond within the day, from 0 to (24 * 60 * 60 * 1,000,000,000) - 1.
 This field has the same meaning for all calendar systems.

 This field is used to represent the nano-of-day handling any fraction of the second.
 Implementations of {@code TemporalAccessor} should provide a value for this field if
 they can return a value for {@link #SECOND_OF_DAY} filling unknown precision with zero.

 When parsing this field it behaves equivalent to the following:
 The value is validated in strict and smart mode but not in lenient mode.
 The value is split to form {@code NANO_OF_SECOND}, {@code SECOND_OF_MINUTE},
 {@code MINUTE_OF_HOUR} and {@code HOUR_OF_DAY} fields."
  java.time.temporal.ChronoField/NANO_OF_DAY)

(def aligned-day-of-week-in-month
  "The aligned day-of-week within a month.

 This represents concept of the count of days within the period of a week
 where the weeks are aligned to the start of the month.
 This field is typically used with {@link #ALIGNED_WEEK_OF_MONTH}.

 For example, in a calendar systems with a seven day week, the first aligned-week-of-month
 starts on day-of-month 1, the second aligned-week starts on day-of-month 8, and so on.
 Within each of these aligned-weeks, the days are numbered from 1 to 7 and returned
 as the value of this field.
 As such, day-of-month 1 to 7 will have aligned-day-of-week values from 1 to 7.
 And day-of-month 8 to 14 will repeat this with aligned-day-of-week values from 1 to 7.

 Calendar systems that do not have a seven day week should typically implement this
 field in the same way, but using the alternate week length."
  java.time.temporal.ChronoField/ALIGNED_DAY_OF_WEEK_IN_MONTH)

(def month-of-year
  "The month-of-year, such as March.

 This represents the concept of the month within the year.
 In the default ISO calendar system, this has values from January (1) to December (12).

 Non-ISO calendar systems should implement this field using the most recognized
 month-of-year values for users of the calendar system.
 Normally, this is a count of months starting from 1."
  java.time.temporal.ChronoField/MONTH_OF_YEAR)

(def hour-of-ampm
  "The hour-of-am-pm.

 This counts the hour within the AM/PM, from 0 to 11.
 This is the hour that would be observed on a standard 12-hour digital clock.
 This field has the same meaning for all calendar systems.

 When parsing this field it behaves equivalent to the following:
 The value is validated from 0 to 11 in strict and smart mode.
 In lenient mode the value is not validated. It is combined with
 {@code AMPM_OF_DAY} to form {@code HOUR_OF_DAY} by multiplying
 the {AMPM_OF_DAY} value by 12."
  java.time.temporal.ChronoField/HOUR_OF_AMPM)

(def year
  "The proleptic year, such as 2012.

 This represents the concept of the year, counting sequentially and using negative numbers.
 The proleptic year is not interpreted in terms of the era.
 See {@link #YEAR_OF_ERA} for an example showing the mapping from proleptic year to year-of-era.

 The standard mental model for a date is based on three concepts - year, month and day.
 These map onto the {@code YEAR}, {@code MONTH_OF_YEAR} and {@code DAY_OF_MONTH} fields.
 Note that there is no reference to eras.
 The full model for a date requires four concepts - era, year, month and day. These map onto
 the {@code ERA}, {@code YEAR_OF_ERA}, {@code MONTH_OF_YEAR} and {@code DAY_OF_MONTH} fields.
 Whether this field or {@code YEAR_OF_ERA} is used depends on which mental model is being used.
 See {@link ChronoLocalDate} for more discussion on this topic.

 Non-ISO calendar systems should implement this field as follows.
 If the calendar system has only two eras, before and after a fixed date, then the
 proleptic-year value must be the same as the year-of-era value for the later era,
 and increasingly negative for the earlier era.
 If the calendar system has more than two eras, then the proleptic-year value may be
 defined with any appropriate value, although defining it to be the same as ISO may be
 the best option."
  java.time.temporal.ChronoField/YEAR)

(def micro-of-second
  "The micro-of-second.

 This counts the microsecond within the second, from 0 to 999,999.
 This field has the same meaning for all calendar systems.

 This field is used to represent the micro-of-second handling any fraction of the second.
 Implementations of {@code TemporalAccessor} should provide a value for this field if
 they can return a value for {@link #SECOND_OF_MINUTE}, {@link #SECOND_OF_DAY} or
 {@link #INSTANT_SECONDS} filling unknown precision with zero.

 When this field is used for setting a value, it should behave in the same way as
 setting {@link #NANO_OF_SECOND} with the value multiplied by 1,000.

 When parsing this field it behaves equivalent to the following:
 The value is validated in strict and smart mode but not in lenient mode.
 The field is resolved in combination with {@code MILLI_OF_SECOND} to produce
 {@code NANO_OF_SECOND}."
  java.time.temporal.ChronoField/MICRO_OF_SECOND)

(def aligned-week-of-year
  "The aligned week within a year.

 This represents concept of the count of weeks within the period of a year
 where the weeks are aligned to the start of the year.
 This field is typically used with {@link #ALIGNED_DAY_OF_WEEK_IN_YEAR}.

 For example, in a calendar systems with a seven day week, the first aligned-week-of-year
 starts on day-of-year 1, the second aligned-week starts on day-of-year 8, and so on.
 Thus, day-of-year values 1 to 7 are in aligned-week 1, while day-of-year values
 8 to 14 are in aligned-week 2, and so on.

 Calendar systems that do not have a seven day week should typically implement this
 field in the same way, but using the alternate week length."
  java.time.temporal.ChronoField/ALIGNED_WEEK_OF_YEAR)

(def proleptic-month
  "The proleptic-month based, counting months sequentially from year 0.

 This field is the sequential count of months where the first month
 in proleptic-year zero has the value zero.
 Later months have increasingly larger values.
 Earlier months have increasingly small values.
 There are no gaps or breaks in the sequence of months.
 Note that this uses the <i>local</i> time-line, ignoring offset and time-zone.

 In the default ISO calendar system, June 2012 would have the value
 {@code (2012 * 12 + 6 - 1)}. This field is primarily for internal use.

 Non-ISO calendar systems must implement this field as per the definition above.
 It is just a simple zero-based count of elapsed months from the start of proleptic-year 0.
 All calendar systems with a full proleptic-year definition will have a year zero.
 If the calendar system has a minimum year that excludes year zero, then one must
 be extrapolated in order for this method to be defined."
  java.time.temporal.ChronoField/PROLEPTIC_MONTH)

(def day-of-month
  "The day-of-month.

 This represents the concept of the day within the month.
 In the default ISO calendar system, this has values from 1 to 31 in most months.
 April, June, September, November have days from 1 to 30, while February has days
 from 1 to 28, or 29 in a leap year.

 Non-ISO calendar systems should implement this field using the most recognized
 day-of-month values for users of the calendar system.
 Normally, this is a count of days from 1 to the length of the month."
  java.time.temporal.ChronoField/DAY_OF_MONTH)

(def second-of-minute
  "The second-of-minute.

 This counts the second within the minute, from 0 to 59.
 This field has the same meaning for all calendar systems.

 When parsing this field it behaves equivalent to the following:
 The value is validated in strict and smart mode but not in lenient mode."
  java.time.temporal.ChronoField/SECOND_OF_MINUTE)

(def second-of-day
  "The second-of-day.

 This counts the second within the day, from 0 to (24 * 60 * 60) - 1.
 This field has the same meaning for all calendar systems.

 When parsing this field it behaves equivalent to the following:
 The value is validated in strict and smart mode but not in lenient mode.
 The value is split to form {@code SECOND_OF_MINUTE}, {@code MINUTE_OF_HOUR}
 and {@code HOUR_OF_DAY} fields."
  java.time.temporal.ChronoField/SECOND_OF_DAY)

(def epoch-day
  "The epoch-day, based on the Java epoch of 1970-01-01 (ISO).

 This field is the sequential count of days where 1970-01-01 (ISO) is zero.
 Note that this uses the <i>local</i> time-line, ignoring offset and time-zone.

 This field is strictly defined to have the same meaning in all calendar systems.
 This is necessary to ensure interoperation between calendars."
  java.time.temporal.ChronoField/EPOCH_DAY)

(def day-of-year
  "The day-of-year.

 This represents the concept of the day within the year.
 In the default ISO calendar system, this has values from 1 to 365 in standard
 years and 1 to 366 in leap years.

 Non-ISO calendar systems should implement this field using the most recognized
 day-of-year values for users of the calendar system.
 Normally, this is a count of days from 1 to the length of the year.

 Note that a non-ISO calendar system may have year numbering system that changes
 at a different point to the natural reset in the month numbering. An example
 of this is the Japanese calendar system where a change of era, which resets
 the year number to 1, can happen on any date. The era and year reset also cause
 the day-of-year to be reset to 1, but not the month-of-year or day-of-month."
  java.time.temporal.ChronoField/DAY_OF_YEAR)

(def aligned-week-of-month
  "The aligned week within a month.

 This represents concept of the count of weeks within the period of a month
 where the weeks are aligned to the start of the month.
 This field is typically used with {@link #ALIGNED_DAY_OF_WEEK_IN_MONTH}.

 For example, in a calendar systems with a seven day week, the first aligned-week-of-month
 starts on day-of-month 1, the second aligned-week starts on day-of-month 8, and so on.
 Thus, day-of-month values 1 to 7 are in aligned-week 1, while day-of-month values
 8 to 14 are in aligned-week 2, and so on.

 Calendar systems that do not have a seven day week should typically implement this
 field in the same way, but using the alternate week length."
  java.time.temporal.ChronoField/ALIGNED_WEEK_OF_MONTH)

(def day-of-week
  "The day-of-week, such as Tuesday.

 This represents the standard concept of the day of the week.
 In the default ISO calendar system, this has values from Monday (1) to Sunday (7).
 The {@link DayOfWeek} class can be used to interpret the result.

 Most non-ISO calendar systems also define a seven day week that aligns with ISO.
 Those calendar systems must also use the same numbering system, from Monday (1) to
 Sunday (7), which allows {@code DayOfWeek} to be used.

 Calendar systems that do not have a standard seven day week should implement this field
 if they have a similar concept of named or numbered days within a period similar
 to a week. It is recommended that the numbering starts from 1."
  java.time.temporal.ChronoField/DAY_OF_WEEK)

(def clock-hour-of-ampm
  "The clock-hour-of-am-pm.

 This counts the hour within the AM/PM, from 1 to 12.
 This is the hour that would be observed on a standard 12-hour analog wall clock.
 This field has the same meaning for all calendar systems.

 When parsing this field it behaves equivalent to the following:
 The value is validated from 1 to 12 in strict mode and from
 0 to 12 in smart mode. In lenient mode the value is not validated.
 The field is converted to an {@code HOUR_OF_AMPM} with the same value,
 unless the value is 12, in which case it is converted to 0."
  java.time.temporal.ChronoField/CLOCK_HOUR_OF_AMPM)

(def minute-of-day
  "The minute-of-day.

 This counts the minute within the day, from 0 to (24 * 60) - 1.
 This field has the same meaning for all calendar systems.

 When parsing this field it behaves equivalent to the following:
 The value is validated in strict and smart mode but not in lenient mode.
 The value is split to form {@code MINUTE_OF_HOUR} and {@code HOUR_OF_DAY} fields."
  java.time.temporal.ChronoField/MINUTE_OF_DAY)

(def aligned-day-of-week-in-year
  "The aligned day-of-week within a year.

 This represents concept of the count of days within the period of a week
 where the weeks are aligned to the start of the year.
 This field is typically used with {@link #ALIGNED_WEEK_OF_YEAR}.

 For example, in a calendar systems with a seven day week, the first aligned-week-of-year
 starts on day-of-year 1, the second aligned-week starts on day-of-year 8, and so on.
 Within each of these aligned-weeks, the days are numbered from 1 to 7 and returned
 as the value of this field.
 As such, day-of-year 1 to 7 will have aligned-day-of-week values from 1 to 7.
 And day-of-year 8 to 14 will repeat this with aligned-day-of-week values from 1 to 7.

 Calendar systems that do not have a seven day week should typically implement this
 field in the same way, but using the alternate week length."
  java.time.temporal.ChronoField/ALIGNED_DAY_OF_WEEK_IN_YEAR)

(def minute-of-hour
  "The minute-of-hour.

 This counts the minute within the hour, from 0 to 59.
 This field has the same meaning for all calendar systems.

 When parsing this field it behaves equivalent to the following:
 The value is validated in strict and smart mode but not in lenient mode."
  java.time.temporal.ChronoField/MINUTE_OF_HOUR)

(def hour-of-day
  "The hour-of-day.

 This counts the hour within the day, from 0 to 23.
 This is the hour that would be observed on a standard 24-hour digital clock.
 This field has the same meaning for all calendar systems.

 When parsing this field it behaves equivalent to the following:
 The value is validated in strict and smart mode but not in lenient mode.
 The field is combined with {@code MINUTE_OF_HOUR}, {@code SECOND_OF_MINUTE} and
 {@code NANO_OF_SECOND} to produce a {@code LocalTime}.
 In lenient mode, any excess days are added to the parsed date, or
 made available via {@link java.time.format.DateTimeFormatter#parsedExcessDays()}."
  java.time.temporal.ChronoField/HOUR_OF_DAY)

(def milli-of-day
  "The milli-of-day.

 This counts the millisecond within the day, from 0 to (24 * 60 * 60 * 1,000) - 1.
 This field has the same meaning for all calendar systems.

 This field is used to represent the milli-of-day handling any fraction of the second.
 Implementations of {@code TemporalAccessor} should provide a value for this field if
 they can return a value for {@link #SECOND_OF_DAY} filling unknown precision with zero.

 When this field is used for setting a value, it should behave in the same way as
 setting {@link #NANO_OF_DAY} with the value multiplied by 1,000,000.

 When parsing this field it behaves equivalent to the following:
 The value is validated in strict and smart mode but not in lenient mode.
 The value is split to form {@code MILLI_OF_SECOND}, {@code SECOND_OF_MINUTE},
 {@code MINUTE_OF_HOUR} and {@code HOUR_OF_DAY} fields."
  java.time.temporal.ChronoField/MILLI_OF_DAY)

(def micro-of-day
  "The micro-of-day.

 This counts the microsecond within the day, from 0 to (24 * 60 * 60 * 1,000,000) - 1.
 This field has the same meaning for all calendar systems.

 This field is used to represent the micro-of-day handling any fraction of the second.
 Implementations of {@code TemporalAccessor} should provide a value for this field if
 they can return a value for {@link #SECOND_OF_DAY} filling unknown precision with zero.

 When this field is used for setting a value, it should behave in the same way as
 setting {@link #NANO_OF_DAY} with the value multiplied by 1,000.

 When parsing this field it behaves equivalent to the following:
 The value is validated in strict and smart mode but not in lenient mode.
 The value is split to form {@code MICRO_OF_SECOND}, {@code SECOND_OF_MINUTE},
 {@code MINUTE_OF_HOUR} and {@code HOUR_OF_DAY} fields."
  java.time.temporal.ChronoField/MICRO_OF_DAY)

(defn get-range-unit
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.time.temporal.ChronoUnit [^java.time.temporal.ChronoField this]
   (.getRangeUnit this)))

(defn range
  "Gets the range of valid values for the field.

 All fields can be expressed as a {@code long} integer.
 This method returns an object that describes the valid range for that value.

 This method returns the range of the field in the ISO-8601 calendar system.
 This range may be incorrect for other calendar systems.
 Use {@link Chronology#range(ChronoField)} to access the correct range
 for a different calendar system.

 Note that the result only describes the minimum and maximum valid values
 and it is important not to read too much into them. For example, there
 could be values within the range that are invalid for the field.

 @return the range of valid values for the field, not null"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.time.temporal.ValueRange [^java.time.temporal.ChronoField this]
   (.range this)))

(defn values
  {:arglists (quote ([]))}
  (^"java.lang.Class" [] (java.time.temporal.ChronoField/values)))

(defn value-of
  {:arglists (quote (["java.lang.String"]
                     ["java.lang.Class" "java.lang.String"]))}
  (^java.time.temporal.ChronoField [^java.lang.String name]
   (java.time.temporal.ChronoField/valueOf name))
  (^java.lang.Enum [^java.lang.Class enum-type ^java.lang.String name]
   (java.time.temporal.ChronoField/valueOf enum-type name)))

(defn resolve
  "Resolves this field to provide a simpler alternative or a date.

 This method is invoked during the resolve phase of parsing.
 It is designed to allow application defined fields to be simplified into
 more standard fields, such as those on {@code ChronoField}, or into a date.

 Applications should not normally invoke this method directly.

 @implSpec
 If an implementation represents a field that can be simplified, or
 combined with others, then this method must be implemented.

 The specified map contains the current state of the parse.
 The map is mutable and must be mutated to resolve the field and
 any related fields. This method will only be invoked during parsing
 if the map contains this field, and implementations should therefore
 assume this field is present.

 Resolving a field will consist of looking at the value of this field,
 and potentially other fields, and either updating the map with a
 simpler value, such as a {@code ChronoField}, or returning a
 complete {@code ChronoLocalDate}. If a resolve is successful,
 the code must remove all the fields that were resolved from the map,
 including this field.

 For example, the {@code IsoFields} class contains the quarter-of-year
 and day-of-quarter fields. The implementation of this method in that class
 resolves the two fields plus the {@link ChronoField#YEAR YEAR} into a
 complete {@code LocalDate}. The resolve method will remove all three
 fields from the map before returning the {@code LocalDate}.

 A partially complete temporal is used to allow the chronology and zone
 to be queried. In general, only the chronology will be needed.
 Querying items other than the zone or chronology is undefined and
 must not be relied on.
 The behavior of other methods such as {@code get}, {@code getLong},
 {@code range} and {@code isSupported} is unpredictable and the results undefined.

 If resolution should be possible, but the data is invalid, the resolver
 style should be used to determine an appropriate level of leniency, which
 may require throwing a {@code DateTimeException} or {@code ArithmeticException}.
 If no resolution is possible, the resolve method must return null.

 When resolving time fields, the map will be altered and null returned.
 When resolving date fields, the date is normally returned from the method,
 with the map altered to remove the resolved fields. However, it would also
 be acceptable for the date fields to be resolved into other {@code ChronoField}
 instances that can produce a date, such as {@code EPOCH_DAY}.

 Not all {@code TemporalAccessor} implementations are accepted as return values.
 Implementations that call this method must accept {@code ChronoLocalDate},
 {@code ChronoLocalDateTime}, {@code ChronoZonedDateTime} and {@code LocalTime}.

 The default implementation must return null.

 @param fieldValues  the map of fields to values, which can be updated, not null
 @param partialTemporal  the partially complete temporal to query for zone and
  chronology; querying for other things is undefined and not recommended, not null
 @param resolverStyle  the requested type of resolve, not null
 @return the resolved temporal object; null if resolving only
  changed the map, or no resolve occurred
 @throws ArithmeticException if numeric overflow occurs
 @throws DateTimeException if resolving results in an error. This must not be thrown
  by querying a field on the temporal without first checking if it is supported"
  {:arglists (quote (["java.time.temporal.ChronoField" "java.util.Map"
                      "java.time.temporal.TemporalAccessor"
                      "java.time.format.ResolverStyle"]))}
  (^java.time.temporal.TemporalAccessor
   [^java.time.temporal.ChronoField this ^java.util.Map field-values
    ^java.time.temporal.TemporalAccessor partial-temporal
    ^java.time.format.ResolverStyle resolver-style]
   (.resolve this field-values partial-temporal resolver-style)))

(defn ordinal
  "Returns the ordinal of this enumeration constant (its position
 in its enum declaration, where the initial constant is assigned
 an ordinal of zero).

 Most programmers will have no use for this method.  It is
 designed for use by sophisticated enum-based data structures, such
 as {@link java.util.EnumSet} and {@link java.util.EnumMap}.

 @return the ordinal of this enumeration constant"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.lang.Integer [^java.time.temporal.ChronoField this] (.ordinal this)))

(defn check-valid-int-value
  "Checks that the specified value is valid and fits in an {@code int}.

 This validates that the value is within the outer range of valid values
 returned by {@link #range()}.
 It also checks that all valid values are within the bounds of an {@code int}.

 This method checks against the range of the field in the ISO-8601 calendar system.
 This range may be incorrect for other calendar systems.
 Use {@link Chronology#range(ChronoField)} to access the correct range
 for a different calendar system.

 @param value  the value to check
 @return the value that was passed in"
  {:arglists (quote (["java.time.temporal.ChronoField" "long"]))}
  (^java.lang.Integer [^java.time.temporal.ChronoField this ^long value]
   (.checkValidIntValue this value)))

(defn get-base-unit
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.time.temporal.ChronoUnit [^java.time.temporal.ChronoField this]
   (.getBaseUnit this)))

(defn to-string
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.lang.String [^java.time.temporal.ChronoField this] (.toString this)))

(defn is-date-based
  "Checks if this field represents a component of a date.

 Fields from day-of-week to era are date-based.

 @return true if it is a component of a date"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.lang.Boolean [^java.time.temporal.ChronoField this]
   (.isDateBased this)))

(defn get-display-name
  {:arglists (quote (["java.time.temporal.ChronoField" "java.util.Locale"]))}
  (^java.lang.String
   [^java.time.temporal.ChronoField this ^java.util.Locale locale]
   (.getDisplayName this locale)))

(defn name
  "Returns the name of this enum constant, exactly as declared in its
 enum declaration.

 <b>Most programmers should use the {@link #toString} method in
 preference to this one, as the toString method may return
 a more user-friendly name.</b>  This method is designed primarily for
 use in specialized situations where correctness depends on getting the
 exact name, which will not vary from release to release.

 @return the name of this enum constant"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.lang.String [^java.time.temporal.ChronoField this] (.name this)))

(defn is-supported-by
  {:arglists (quote (["java.time.temporal.ChronoField"
                      "java.time.temporal.TemporalAccessor"]))}
  (^java.lang.Boolean
   [^java.time.temporal.ChronoField this
    ^java.time.temporal.TemporalAccessor temporal]
   (.isSupportedBy this temporal)))

(defn range-refined-by
  {:arglists (quote (["java.time.temporal.ChronoField"
                      "java.time.temporal.TemporalAccessor"]))}
  (^java.time.temporal.ValueRange
   [^java.time.temporal.ChronoField this
    ^java.time.temporal.TemporalAccessor temporal]
   (.rangeRefinedBy this temporal)))

(defn get-declaring-class
  "Returns the Class object corresponding to this enum constant's
 enum type.  Two enum constants e1 and  e2 are of the
 same enum type if and only if
   e1.getDeclaringClass() == e2.getDeclaringClass().
 (The value returned by this method may differ from the one returned
 by the {@link Object#getClass} method for enum constants with
 constant-specific class bodies.)

 @return the Class object corresponding to this enum constant's
     enum type"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.lang.Class [^java.time.temporal.ChronoField this]
   (.getDeclaringClass this)))

(defn hash-code
  "Returns a hash code for this enum constant.

 @return a hash code for this enum constant."
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.lang.Integer [^java.time.temporal.ChronoField this] (.hashCode this)))

(defn adjust-into
  {:arglists (quote (["java.time.temporal.ChronoField"
                      "java.time.temporal.Temporal" "long"]))}
  (^java.time.temporal.Temporal
   [^java.time.temporal.ChronoField this ^java.time.temporal.Temporal temporal
    ^long new-value]
   (.adjustInto this temporal new-value)))

(defn get-from
  {:arglists (quote (["java.time.temporal.ChronoField"
                      "java.time.temporal.TemporalAccessor"]))}
  (^long
   [^java.time.temporal.ChronoField this
    ^java.time.temporal.TemporalAccessor temporal]
   (.getFrom this temporal)))

(defn compare-to
  "Compares this enum with the specified object for order.  Returns a
 negative integer, zero, or a positive integer as this object is less
 than, equal to, or greater than the specified object.

 Enum constants are only comparable to other enum constants of the
 same enum type.  The natural order implemented by this
 method is the order in which the constants are declared."
  {:arglists (quote (["java.time.temporal.ChronoField" "java.lang.Enum"]))}
  (^java.lang.Integer [^java.time.temporal.ChronoField this ^java.lang.Enum o]
   (.compareTo this o)))

(defn equals
  "Returns true if the specified object is equal to this
 enum constant.

 @param other the object to be compared for equality with this object.
 @return  true if the specified object is equal to this
          enum constant."
  {:arglists (quote (["java.time.temporal.ChronoField" "java.lang.Object"]))}
  (^java.lang.Boolean
   [^java.time.temporal.ChronoField this ^java.lang.Object other]
   (.equals this other)))

(defn is-time-based
  "Checks if this field represents a component of a time.

 Fields from nano-of-second to am-pm-of-day are time-based.

 @return true if it is a component of a time"
  {:arglists (quote (["java.time.temporal.ChronoField"]))}
  (^java.lang.Boolean [^java.time.temporal.ChronoField this]
   (.isTimeBased this)))

(defn check-valid-value
  "Checks that the specified value is valid for this field.

 This validates that the value is within the outer range of valid values
 returned by {@link #range()}.

 This method checks against the range of the field in the ISO-8601 calendar system.
 This range may be incorrect for other calendar systems.
 Use {@link Chronology#range(ChronoField)} to access the correct range
 for a different calendar system.

 @param value  the value to check
 @return the value that was passed in"
  {:arglists (quote (["java.time.temporal.ChronoField" "long"]))}
  (^long [^java.time.temporal.ChronoField this ^long value]
   (.checkValidValue this value)))
