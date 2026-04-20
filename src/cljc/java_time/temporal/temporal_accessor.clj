(ns cljc.java-time.temporal.temporal-accessor
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time.temporal TemporalAccessor]))

(defn get
  "Gets the value of the specified field as an {@code int}.\n <p>\n This queries the date-time for the value of the specified field.\n The returned value will always be within the valid range of values for the field.\n If the date-time cannot return the value, because the field is unsupported or for\n some other reason, an exception will be thrown.\n\n @implSpec\n Implementations must check and handle all fields defined in {@link ChronoField}.\n If the field is supported and has an {@code int} range, then the value of\n the field must be returned.\n If unsupported, then an {@code UnsupportedTemporalTypeException} must be thrown.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument.\n <p>\n Implementations must ensure that no observable state is altered when this\n read-only method is invoked.\n <p>\n The default implementation must behave equivalent to this code:\n <pre>\n  if (range(field).isIntValue()) {\n    return range(field).checkValidIntValue(getLong(field), field);\n  }\n  throw new UnsupportedTemporalTypeException(\"Invalid field \" + field + \" + for get() method, use getLong() instead\");\n </pre>\n\n @param field  the field to get, not null\n @return the value for the field, within the valid range of values\n @throws DateTimeException if a value for the field cannot be obtained or\n         the value is outside the range of valid values for the field\n @throws UnsupportedTemporalTypeException if the field is not supported or\n         the range of values exceeds an {@code int}\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"
                      "java.time.temporal.TemporalField"]))}
  (^java.lang.Integer
   [^java.time.temporal.TemporalAccessor this
    ^java.time.temporal.TemporalField field]
   (.get this field)))

(defn get-long
  "Gets the value of the specified field as a {@code long}.\n <p>\n This queries the date-time for the value of the specified field.\n The returned value may be outside the valid range of values for the field.\n If the date-time cannot return the value, because the field is unsupported or for\n some other reason, an exception will be thrown.\n\n @implSpec\n Implementations must check and handle all fields defined in {@link ChronoField}.\n If the field is supported, then the value of the field must be returned.\n If unsupported, then an {@code UnsupportedTemporalTypeException} must be thrown.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument.\n <p>\n Implementations must ensure that no observable state is altered when this\n read-only method is invoked.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"
                      "java.time.temporal.TemporalField"]))}
  (^long
   [^java.time.temporal.TemporalAccessor this
    ^java.time.temporal.TemporalField field]
   (.getLong this field)))

(defn is-supported
  "Checks if the specified field is supported.\n <p>\n This checks if the date-time can be queried for the specified field.\n If false, then calling the {@link #range(TemporalField) range} and {@link #get(TemporalField) get}\n methods will throw an exception.\n\n @implSpec\n Implementations must check and handle all fields defined in {@link ChronoField}.\n If the field is supported, then true must be returned, otherwise false must be returned.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.isSupportedBy(TemporalAccessor)}\n passing {@code this} as the argument.\n <p>\n Implementations must ensure that no observable state is altered when this\n read-only method is invoked.\n\n @param field  the field to check, null returns false\n @return true if this date-time can be queried for the field, false if not"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"
                      "java.time.temporal.TemporalField"]))}
  (^java.lang.Boolean
   [^java.time.temporal.TemporalAccessor this
    ^java.time.temporal.TemporalField field]
   (.isSupported this field)))

(defn query
  "Queries this date-time.\n <p>\n This queries this date-time using the specified query strategy object.\n <p>\n Queries are a key tool for extracting information from date-times.\n They exists to externalize the process of querying, permitting different\n approaches, as per the strategy design pattern.\n Examples might be a query that checks if the date is the day before February 29th\n in a leap year, or calculates the number of days to your next birthday.\n <p>\n The most common query implementations are method references, such as\n {@code LocalDate::from} and {@code ZoneId::from}.\n Additional implementations are provided as static methods on {@link TemporalQuery}.\n\n @implSpec\n The default implementation must behave equivalent to this code:\n <pre>\n  if (query == TemporalQueries.zoneId() ||\n        query == TemporalQueries.chronology() || query == TemporalQueries.precision()) {\n    return null;\n  }\n  return query.queryFrom(this);\n </pre>\n Future versions are permitted to add further queries to the if statement.\n <p>\n All classes implementing this interface and overriding this method must call\n {@code TemporalAccessor.super.query(query)}. JDK classes may avoid calling\n super if they provide behavior equivalent to the default behaviour, however\n non-JDK classes may not utilize this optimization and must call {@code super}.\n <p>\n If the implementation can supply a value for one of the queries listed in the\n if statement of the default implementation, then it must do so.\n For example, an application-defined {@code HourMin} class storing the hour\n and minute must override this method as follows:\n <pre>\n  if (query == TemporalQueries.precision()) {\n    return MINUTES;\n  }\n  return TemporalAccessor.super.query(query);\n </pre>\n <p>\n Implementations must ensure that no observable state is altered when this\n read-only method is invoked.\n\n @param <R> the type of the result\n @param query  the query to invoke, not null\n @return the query result, null may be returned (defined by the query)\n @throws DateTimeException if unable to query\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object
   [^java.time.temporal.TemporalAccessor this
    ^java.time.temporal.TemporalQuery query]
   (.query this query)))

(defn range
  "Gets the range of valid values for the specified field.\n <p>\n All fields can be expressed as a {@code long} integer.\n This method returns an object that describes the valid range for that value.\n The value of this temporal object is used to enhance the accuracy of the returned range.\n If the date-time cannot return the range, because the field is unsupported or for\n some other reason, an exception will be thrown.\n <p>\n Note that the result only describes the minimum and maximum valid values\n and it is important not to read too much into them. For example, there\n could be values within the range that are invalid for the field.\n\n @implSpec\n Implementations must check and handle all fields defined in {@link ChronoField}.\n If the field is supported, then the range of the field must be returned.\n If unsupported, then an {@code UnsupportedTemporalTypeException} must be thrown.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessorl)}\n passing {@code this} as the argument.\n <p>\n Implementations must ensure that no observable state is altered when this\n read-only method is invoked.\n <p>\n The default implementation must behave equivalent to this code:\n <pre>\n  if (field instanceof ChronoField) {\n    if (isSupported(field)) {\n      return field.range();\n    }\n    throw new UnsupportedTemporalTypeException(\"Unsupported field: \" + field);\n  }\n  return field.rangeRefinedBy(this);\n </pre>\n\n @param field  the field to query the range for, not null\n @return the range of valid values for the field, not null\n @throws DateTimeException if the range for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"
                      "java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ValueRange
   [^java.time.temporal.TemporalAccessor this
    ^java.time.temporal.TemporalField field]
   (.range this field)))
