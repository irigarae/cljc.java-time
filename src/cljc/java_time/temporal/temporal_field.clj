(ns cljc.java-time.temporal.temporal-field
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time.temporal TemporalField]))

(defn get-range-unit
  "Gets the range that the field is bound by.

 The range of the field is the period that the field varies within.
 For example, in the field 'MonthOfYear', the range is 'Years'.
 See also {@link #getBaseUnit()}.

 The range is never null. For example, the 'Year' field is shorthand for
 'YearOfForever'. It therefore has a unit of 'Years' and a range of 'Forever'.

 @return the unit defining the range of the field, not null"
  {:arglists (quote (["java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ChronoUnit [^java.time.temporal.TemporalField this]
   (.getRangeUnit this)))

(defn range
  "Gets the range of valid values for the field.

 All fields can be expressed as a {@code long} integer.
 This method returns an object that describes the valid range for that value.
 This method is generally only applicable to the ISO-8601 calendar system.

 Note that the result only describes the minimum and maximum valid values
 and it is important not to read too much into them. For example, there
 could be values within the range that are invalid for the field.

 @return the range of valid values for the field, not null"
  {:arglists (quote (["java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ValueRange [^java.time.temporal.TemporalField this]
   (.range this)))

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
  {:arglists (quote (["java.time.temporal.TemporalField" "java.util.Map"
                      "java.time.temporal.TemporalAccessor"
                      "java.time.format.ResolverStyle"]))}
  (^java.time.temporal.TemporalAccessor
   [^java.time.temporal.TemporalField this ^java.util.Map field-values
    ^java.time.temporal.TemporalAccessor partial-temporal
    ^java.time.format.ResolverStyle resolver-style]
   (.resolve this field-values partial-temporal resolver-style)))

(defn get-base-unit
  "Gets the unit that the field is measured in.

 The unit of the field is the period that varies within the range.
 For example, in the field 'MonthOfYear', the unit is 'Months'.
 See also {@link #getRangeUnit()}.

 @return the unit defining the base unit of the field, not null"
  {:arglists (quote (["java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ChronoUnit [^java.time.temporal.TemporalField this]
   (.getBaseUnit this)))

(defn to-string
  "Gets a descriptive name for the field.

 The should be of the format 'BaseOfRange', such as 'MonthOfYear',
 unless the field has a range of {@code FOREVER}, when only
 the base unit is mentioned, such as 'Year' or 'Era'.

 @return the name of the field, not null"
  {:arglists (quote (["java.time.temporal.TemporalField"]))}
  (^java.lang.String [^java.time.temporal.TemporalField this] (.toString this)))

(defn is-date-based
  "Checks if this field represents a component of a date.

 A field is date-based if it can be derived from
 {@link ChronoField#EPOCH_DAY EPOCH_DAY}.
 Note that it is valid for both {@code isDateBased()} and {@code isTimeBased()}
 to return false, such as when representing a field like minute-of-week.

 @return true if this field is a component of a date"
  {:arglists (quote (["java.time.temporal.TemporalField"]))}
  (^java.lang.Boolean [^java.time.temporal.TemporalField this]
   (.isDateBased this)))

(defn get-display-name
  "Gets the display name for the field in the requested locale.

 If there is no display name for the locale then a suitable default must be returned.

 The default implementation must check the locale is not null
 and return {@code toString()}.

 @param locale  the locale to use, not null
 @return the display name for the locale or a suitable default, not null"
  {:arglists (quote (["java.time.temporal.TemporalField" "java.util.Locale"]))}
  (^java.lang.String
   [^java.time.temporal.TemporalField this ^java.util.Locale locale]
   (.getDisplayName this locale)))

(defn is-supported-by
  "Checks if this field is supported by the temporal object.

 This determines whether the temporal accessor supports this field.
 If this returns false, then the temporal cannot be queried for this field.

 There are two equivalent ways of using this method.
 The first is to invoke this method directly.
 The second is to use {@link TemporalAccessor#isSupported(TemporalField)}:
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   temporal = thisField.isSupportedBy(temporal);
   temporal = temporal.isSupported(thisField);
 </pre>
 It is recommended to use the second approach, {@code isSupported(TemporalField)},
 as it is a lot clearer to read in code.

 Implementations should determine whether they are supported using the fields
 available in {@link ChronoField}.

 @param temporal  the temporal object to query, not null
 @return true if the date-time can be queried for this field, false if not"
  {:arglists (quote (["java.time.temporal.TemporalField"
                      "java.time.temporal.TemporalAccessor"]))}
  (^java.lang.Boolean
   [^java.time.temporal.TemporalField this
    ^java.time.temporal.TemporalAccessor temporal]
   (.isSupportedBy this temporal)))

(defn range-refined-by
  "Get the range of valid values for this field using the temporal object to
 refine the result.

 This uses the temporal object to find the range of valid values for the field.
 This is similar to {@link #range()}, however this method refines the result
 using the temporal. For example, if the field is {@code DAY_OF_MONTH} the
 {@code range} method is not accurate as there are four possible month lengths,
 28, 29, 30 and 31 days. Using this method with a date allows the range to be
 accurate, returning just one of those four options.

 There are two equivalent ways of using this method.
 The first is to invoke this method directly.
 The second is to use {@link TemporalAccessor#range(TemporalField)}:
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   temporal = thisField.rangeRefinedBy(temporal);
   temporal = temporal.range(thisField);
 </pre>
 It is recommended to use the second approach, {@code range(TemporalField)},
 as it is a lot clearer to read in code.

 Implementations should perform any queries or calculations using the fields
 available in {@link ChronoField}.
 If the field is not supported an {@code UnsupportedTemporalTypeException} must be thrown.

 @param temporal  the temporal object used to refine the result, not null
 @return the range of valid values for this field, not null
 @throws DateTimeException if the range for the field cannot be obtained
 @throws UnsupportedTemporalTypeException if the field is not supported by the temporal"
  {:arglists (quote (["java.time.temporal.TemporalField"
                      "java.time.temporal.TemporalAccessor"]))}
  (^java.time.temporal.ValueRange
   [^java.time.temporal.TemporalField this
    ^java.time.temporal.TemporalAccessor temporal]
   (.rangeRefinedBy this temporal)))

(defn adjust-into
  "Returns a copy of the specified temporal object with the value of this field set.

 This returns a new temporal object based on the specified one with the value for
 this field changed. For example, on a {@code LocalDate}, this could be used to
 set the year, month or day-of-month.
 The returned object has the same observable type as the specified object.

 In some cases, changing a field is not fully defined. For example, if the target object is
 a date representing the 31st January, then changing the month to February would be unclear.
 In cases like this, the implementation is responsible for resolving the result.
 Typically it will choose the previous valid date, which would be the last valid
 day of February in this example.

 There are two equivalent ways of using this method.
 The first is to invoke this method directly.
 The second is to use {@link Temporal#with(TemporalField, long)}:
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   temporal = thisField.adjustInto(temporal);
   temporal = temporal.with(thisField);
 </pre>
 It is recommended to use the second approach, {@code with(TemporalField)},
 as it is a lot clearer to read in code.

 Implementations should perform any queries or calculations using the fields
 available in {@link ChronoField}.
 If the field is not supported an {@code UnsupportedTemporalTypeException} must be thrown.

 Implementations must not alter the specified temporal object.
 Instead, an adjusted copy of the original must be returned.
 This provides equivalent, safe behavior for immutable and mutable implementations.

 @param <R>  the type of the Temporal object
 @param temporal the temporal object to adjust, not null
 @param newValue the new value of the field
 @return the adjusted temporal object, not null
 @throws DateTimeException if the field cannot be set
 @throws UnsupportedTemporalTypeException if the field is not supported by the temporal
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalField"
                      "java.time.temporal.Temporal" "long"]))}
  (^java.time.temporal.Temporal
   [^java.time.temporal.TemporalField this ^java.time.temporal.Temporal temporal
    ^long new-value]
   (.adjustInto this temporal new-value)))

(defn get-from
  "Gets the value of this field from the specified temporal object.

 This queries the temporal object for the value of this field.

 There are two equivalent ways of using this method.
 The first is to invoke this method directly.
 The second is to use {@link TemporalAccessor#getLong(TemporalField)}
 (or {@link TemporalAccessor#get(TemporalField)}):
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   temporal = thisField.getFrom(temporal);
   temporal = temporal.getLong(thisField);
 </pre>
 It is recommended to use the second approach, {@code getLong(TemporalField)},
 as it is a lot clearer to read in code.

 Implementations should perform any queries or calculations using the fields
 available in {@link ChronoField}.
 If the field is not supported an {@code UnsupportedTemporalTypeException} must be thrown.

 @param temporal  the temporal object to query, not null
 @return the value of this field, not null
 @throws DateTimeException if a value for the field cannot be obtained
 @throws UnsupportedTemporalTypeException if the field is not supported by the temporal
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalField"
                      "java.time.temporal.TemporalAccessor"]))}
  (^long
   [^java.time.temporal.TemporalField this
    ^java.time.temporal.TemporalAccessor temporal]
   (.getFrom this temporal)))

(defn is-time-based
  "Checks if this field represents a component of a time.

 A field is time-based if it can be derived from
 {@link ChronoField#NANO_OF_DAY NANO_OF_DAY}.
 Note that it is valid for both {@code isDateBased()} and {@code isTimeBased()}
 to return false, such as when representing a field like minute-of-week.

 @return true if this field is a component of a time"
  {:arglists (quote (["java.time.temporal.TemporalField"]))}
  (^java.lang.Boolean [^java.time.temporal.TemporalField this]
   (.isTimeBased this)))
