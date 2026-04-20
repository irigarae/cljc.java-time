(ns cljc.java-time.temporal.temporal-field
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time.temporal TemporalField]))

(defn get-range-unit
  "Gets the range that the field is bound by.\n <p>\n The range of the field is the period that the field varies within.\n For example, in the field 'MonthOfYear', the range is 'Years'.\n See also {@link #getBaseUnit()}.\n <p>\n The range is never null. For example, the 'Year' field is shorthand for\n 'YearOfForever'. It therefore has a unit of 'Years' and a range of 'Forever'.\n\n @return the unit defining the range of the field, not null"
  {:arglists (quote (["java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ChronoUnit [^java.time.temporal.TemporalField this]
   (.getRangeUnit this)))

(defn range
  "Gets the range of valid values for the field.\n <p>\n All fields can be expressed as a {@code long} integer.\n This method returns an object that describes the valid range for that value.\n This method is generally only applicable to the ISO-8601 calendar system.\n <p>\n Note that the result only describes the minimum and maximum valid values\n and it is important not to read too much into them. For example, there\n could be values within the range that are invalid for the field.\n\n @return the range of valid values for the field, not null"
  {:arglists (quote (["java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ValueRange [^java.time.temporal.TemporalField this]
   (.range this)))

(defn resolve
  "Resolves this field to provide a simpler alternative or a date.\n <p>\n This method is invoked during the resolve phase of parsing.\n It is designed to allow application defined fields to be simplified into\n more standard fields, such as those on {@code ChronoField}, or into a date.\n <p>\n Applications should not normally invoke this method directly.\n\n @implSpec\n If an implementation represents a field that can be simplified, or\n combined with others, then this method must be implemented.\n <p>\n The specified map contains the current state of the parse.\n The map is mutable and must be mutated to resolve the field and\n any related fields. This method will only be invoked during parsing\n if the map contains this field, and implementations should therefore\n assume this field is present.\n <p>\n Resolving a field will consist of looking at the value of this field,\n and potentially other fields, and either updating the map with a\n simpler value, such as a {@code ChronoField}, or returning a\n complete {@code ChronoLocalDate}. If a resolve is successful,\n the code must remove all the fields that were resolved from the map,\n including this field.\n <p>\n For example, the {@code IsoFields} class contains the quarter-of-year\n and day-of-quarter fields. The implementation of this method in that class\n resolves the two fields plus the {@link ChronoField#YEAR YEAR} into a\n complete {@code LocalDate}. The resolve method will remove all three\n fields from the map before returning the {@code LocalDate}.\n <p>\n A partially complete temporal is used to allow the chronology and zone\n to be queried. In general, only the chronology will be needed.\n Querying items other than the zone or chronology is undefined and\n must not be relied on.\n The behavior of other methods such as {@code get}, {@code getLong},\n {@code range} and {@code isSupported} is unpredictable and the results undefined.\n <p>\n If resolution should be possible, but the data is invalid, the resolver\n style should be used to determine an appropriate level of leniency, which\n may require throwing a {@code DateTimeException} or {@code ArithmeticException}.\n If no resolution is possible, the resolve method must return null.\n <p>\n When resolving time fields, the map will be altered and null returned.\n When resolving date fields, the date is normally returned from the method,\n with the map altered to remove the resolved fields. However, it would also\n be acceptable for the date fields to be resolved into other {@code ChronoField}\n instances that can produce a date, such as {@code EPOCH_DAY}.\n <p>\n Not all {@code TemporalAccessor} implementations are accepted as return values.\n Implementations that call this method must accept {@code ChronoLocalDate},\n {@code ChronoLocalDateTime}, {@code ChronoZonedDateTime} and {@code LocalTime}.\n <p>\n The default implementation must return null.\n\n @param fieldValues  the map of fields to values, which can be updated, not null\n @param partialTemporal  the partially complete temporal to query for zone and\n  chronology; querying for other things is undefined and not recommended, not null\n @param resolverStyle  the requested type of resolve, not null\n @return the resolved temporal object; null if resolving only\n  changed the map, or no resolve occurred\n @throws ArithmeticException if numeric overflow occurs\n @throws DateTimeException if resolving results in an error. This must not be thrown\n  by querying a field on the temporal without first checking if it is supported"
  {:arglists (quote (["java.time.temporal.TemporalField" "java.util.Map"
                      "java.time.temporal.TemporalAccessor"
                      "java.time.format.ResolverStyle"]))}
  (^java.time.temporal.TemporalAccessor
   [^java.time.temporal.TemporalField this ^java.util.Map field-values
    ^java.time.temporal.TemporalAccessor partial-temporal
    ^java.time.format.ResolverStyle resolver-style]
   (.resolve this field-values partial-temporal resolver-style)))

(defn get-base-unit
  "Gets the unit that the field is measured in.\n <p>\n The unit of the field is the period that varies within the range.\n For example, in the field 'MonthOfYear', the unit is 'Months'.\n See also {@link #getRangeUnit()}.\n\n @return the unit defining the base unit of the field, not null"
  {:arglists (quote (["java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ChronoUnit [^java.time.temporal.TemporalField this]
   (.getBaseUnit this)))

(defn to-string
  "Gets a descriptive name for the field.\n <p>\n The should be of the format 'BaseOfRange', such as 'MonthOfYear',\n unless the field has a range of {@code FOREVER}, when only\n the base unit is mentioned, such as 'Year' or 'Era'.\n\n @return the name of the field, not null"
  {:arglists (quote (["java.time.temporal.TemporalField"]))}
  (^java.lang.String [^java.time.temporal.TemporalField this] (.toString this)))

(defn is-date-based
  "Checks if this field represents a component of a date.\n <p>\n A field is date-based if it can be derived from\n {@link ChronoField#EPOCH_DAY EPOCH_DAY}.\n Note that it is valid for both {@code isDateBased()} and {@code isTimeBased()}\n to return false, such as when representing a field like minute-of-week.\n\n @return true if this field is a component of a date"
  {:arglists (quote (["java.time.temporal.TemporalField"]))}
  (^java.lang.Boolean [^java.time.temporal.TemporalField this]
   (.isDateBased this)))

(defn get-display-name
  "Gets the display name for the field in the requested locale.\n <p>\n If there is no display name for the locale then a suitable default must be returned.\n <p>\n The default implementation must check the locale is not null\n and return {@code toString()}.\n\n @param locale  the locale to use, not null\n @return the display name for the locale or a suitable default, not null"
  {:arglists (quote (["java.time.temporal.TemporalField" "java.util.Locale"]))}
  (^java.lang.String
   [^java.time.temporal.TemporalField this ^java.util.Locale locale]
   (.getDisplayName this locale)))

(defn is-supported-by
  "Checks if this field is supported by the temporal object.\n <p>\n This determines whether the temporal accessor supports this field.\n If this returns false, then the temporal cannot be queried for this field.\n <p>\n There are two equivalent ways of using this method.\n The first is to invoke this method directly.\n The second is to use {@link TemporalAccessor#isSupported(TemporalField)}:\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   temporal = thisField.isSupportedBy(temporal);\n   temporal = temporal.isSupported(thisField);\n </pre>\n It is recommended to use the second approach, {@code isSupported(TemporalField)},\n as it is a lot clearer to read in code.\n <p>\n Implementations should determine whether they are supported using the fields\n available in {@link ChronoField}.\n\n @param temporal  the temporal object to query, not null\n @return true if the date-time can be queried for this field, false if not"
  {:arglists (quote (["java.time.temporal.TemporalField"
                      "java.time.temporal.TemporalAccessor"]))}
  (^java.lang.Boolean
   [^java.time.temporal.TemporalField this
    ^java.time.temporal.TemporalAccessor temporal]
   (.isSupportedBy this temporal)))

(defn range-refined-by
  "Get the range of valid values for this field using the temporal object to\n refine the result.\n <p>\n This uses the temporal object to find the range of valid values for the field.\n This is similar to {@link #range()}, however this method refines the result\n using the temporal. For example, if the field is {@code DAY_OF_MONTH} the\n {@code range} method is not accurate as there are four possible month lengths,\n 28, 29, 30 and 31 days. Using this method with a date allows the range to be\n accurate, returning just one of those four options.\n <p>\n There are two equivalent ways of using this method.\n The first is to invoke this method directly.\n The second is to use {@link TemporalAccessor#range(TemporalField)}:\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   temporal = thisField.rangeRefinedBy(temporal);\n   temporal = temporal.range(thisField);\n </pre>\n It is recommended to use the second approach, {@code range(TemporalField)},\n as it is a lot clearer to read in code.\n <p>\n Implementations should perform any queries or calculations using the fields\n available in {@link ChronoField}.\n If the field is not supported an {@code UnsupportedTemporalTypeException} must be thrown.\n\n @param temporal  the temporal object used to refine the result, not null\n @return the range of valid values for this field, not null\n @throws DateTimeException if the range for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported by the temporal"
  {:arglists (quote (["java.time.temporal.TemporalField"
                      "java.time.temporal.TemporalAccessor"]))}
  (^java.time.temporal.ValueRange
   [^java.time.temporal.TemporalField this
    ^java.time.temporal.TemporalAccessor temporal]
   (.rangeRefinedBy this temporal)))

(defn adjust-into
  "Returns a copy of the specified temporal object with the value of this field set.\n <p>\n This returns a new temporal object based on the specified one with the value for\n this field changed. For example, on a {@code LocalDate}, this could be used to\n set the year, month or day-of-month.\n The returned object has the same observable type as the specified object.\n <p>\n In some cases, changing a field is not fully defined. For example, if the target object is\n a date representing the 31st January, then changing the month to February would be unclear.\n In cases like this, the implementation is responsible for resolving the result.\n Typically it will choose the previous valid date, which would be the last valid\n day of February in this example.\n <p>\n There are two equivalent ways of using this method.\n The first is to invoke this method directly.\n The second is to use {@link Temporal#with(TemporalField, long)}:\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   temporal = thisField.adjustInto(temporal);\n   temporal = temporal.with(thisField);\n </pre>\n It is recommended to use the second approach, {@code with(TemporalField)},\n as it is a lot clearer to read in code.\n <p>\n Implementations should perform any queries or calculations using the fields\n available in {@link ChronoField}.\n If the field is not supported an {@code UnsupportedTemporalTypeException} must be thrown.\n <p>\n Implementations must not alter the specified temporal object.\n Instead, an adjusted copy of the original must be returned.\n This provides equivalent, safe behavior for immutable and mutable implementations.\n\n @param <R>  the type of the Temporal object\n @param temporal the temporal object to adjust, not null\n @param newValue the new value of the field\n @return the adjusted temporal object, not null\n @throws DateTimeException if the field cannot be set\n @throws UnsupportedTemporalTypeException if the field is not supported by the temporal\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalField"
                      "java.time.temporal.Temporal" "long"]))}
  (^java.time.temporal.Temporal
   [^java.time.temporal.TemporalField this ^java.time.temporal.Temporal temporal
    ^long new-value]
   (.adjustInto this temporal new-value)))

(defn get-from
  "Gets the value of this field from the specified temporal object.\n <p>\n This queries the temporal object for the value of this field.\n <p>\n There are two equivalent ways of using this method.\n The first is to invoke this method directly.\n The second is to use {@link TemporalAccessor#getLong(TemporalField)}\n (or {@link TemporalAccessor#get(TemporalField)}):\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   temporal = thisField.getFrom(temporal);\n   temporal = temporal.getLong(thisField);\n </pre>\n It is recommended to use the second approach, {@code getLong(TemporalField)},\n as it is a lot clearer to read in code.\n <p>\n Implementations should perform any queries or calculations using the fields\n available in {@link ChronoField}.\n If the field is not supported an {@code UnsupportedTemporalTypeException} must be thrown.\n\n @param temporal  the temporal object to query, not null\n @return the value of this field, not null\n @throws DateTimeException if a value for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported by the temporal\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalField"
                      "java.time.temporal.TemporalAccessor"]))}
  (^long
   [^java.time.temporal.TemporalField this
    ^java.time.temporal.TemporalAccessor temporal]
   (.getFrom this temporal)))

(defn is-time-based
  "Checks if this field represents a component of a time.\n <p>\n A field is time-based if it can be derived from\n {@link ChronoField#NANO_OF_DAY NANO_OF_DAY}.\n Note that it is valid for both {@code isDateBased()} and {@code isTimeBased()}\n to return false, such as when representing a field like minute-of-week.\n\n @return true if this field is a component of a time"
  {:arglists (quote (["java.time.temporal.TemporalField"]))}
  (^java.lang.Boolean [^java.time.temporal.TemporalField this]
   (.isTimeBased this)))
