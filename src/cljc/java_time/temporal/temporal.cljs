(ns cljc.java-time.temporal.temporal
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time.temporal :refer [Temporal]]))

(defn range
  "Gets the range of valid values for the specified field.\n <p>\n All fields can be expressed as a {@code long} integer.\n This method returns an object that describes the valid range for that value.\n The value of this temporal object is used to enhance the accuracy of the returned range.\n If the date-time cannot return the range, because the field is unsupported or for\n some other reason, an exception will be thrown.\n <p>\n Note that the result only describes the minimum and maximum valid values\n and it is important not to read too much into them. For example, there\n could be values within the range that are invalid for the field.\n\n @implSpec\n Implementations must check and handle all fields defined in {@link ChronoField}.\n If the field is supported, then the range of the field must be returned.\n If unsupported, then an {@code UnsupportedTemporalTypeException} must be thrown.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessorl)}\n passing {@code this} as the argument.\n <p>\n Implementations must ensure that no observable state is altered when this\n read-only method is invoked.\n <p>\n The default implementation must behave equivalent to this code:\n <pre>\n  if (field instanceof ChronoField) {\n    if (isSupported(field)) {\n      return field.range();\n    }\n    throw new UnsupportedTemporalTypeException(\"Unsupported field: \" + field);\n  }\n  return field.rangeRefinedBy(this);\n </pre>\n\n @param field  the field to query the range for, not null\n @return the range of valid values for the field, not null\n @throws DateTimeException if the range for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported"
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalField"]))}
  (^js/JSJoda.ValueRange
   [^js/JSJoda.Temporal this ^js/JSJoda.TemporalField field]
   (.range this field)))

(defn plus
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalAmount"]
                     ["java.time.temporal.Temporal" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.Temporal
   [^js/JSJoda.Temporal this ^js/JSJoda.TemporalAmount amount]
   (.plus this amount))
  (^js/JSJoda.Temporal
   [^js/JSJoda.Temporal this ^long amount-to-add ^js/JSJoda.TemporalUnit unit]
   (.plus this amount-to-add unit)))

(defn query
  "Queries this date-time.\n <p>\n This queries this date-time using the specified query strategy object.\n <p>\n Queries are a key tool for extracting information from date-times.\n They exists to externalize the process of querying, permitting different\n approaches, as per the strategy design pattern.\n Examples might be a query that checks if the date is the day before February 29th\n in a leap year, or calculates the number of days to your next birthday.\n <p>\n The most common query implementations are method references, such as\n {@code LocalDate::from} and {@code ZoneId::from}.\n Additional implementations are provided as static methods on {@link TemporalQuery}.\n\n @implSpec\n The default implementation must behave equivalent to this code:\n <pre>\n  if (query == TemporalQueries.zoneId() ||\n        query == TemporalQueries.chronology() || query == TemporalQueries.precision()) {\n    return null;\n  }\n  return query.queryFrom(this);\n </pre>\n Future versions are permitted to add further queries to the if statement.\n <p>\n All classes implementing this interface and overriding this method must call\n {@code TemporalAccessor.super.query(query)}. JDK classes may avoid calling\n super if they provide behavior equivalent to the default behaviour, however\n non-JDK classes may not utilize this optimization and must call {@code super}.\n <p>\n If the implementation can supply a value for one of the queries listed in the\n if statement of the default implementation, then it must do so.\n For example, an application-defined {@code HourMin} class storing the hour\n and minute must override this method as follows:\n <pre>\n  if (query == TemporalQueries.precision()) {\n    return MINUTES;\n  }\n  return TemporalAccessor.super.query(query);\n </pre>\n <p>\n Implementations must ensure that no observable state is altered when this\n read-only method is invoked.\n\n @param <R> the type of the result\n @param query  the query to invoke, not null\n @return the query result, null may be returned (defined by the query)\n @throws DateTimeException if unable to query\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object [^js/JSJoda.Temporal this ^js/JSJoda.TemporalQuery query]
   (.query this query)))

(defn minus
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalAmount"]
                     ["java.time.temporal.Temporal" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^js/JSJoda.Temporal
   [^js/JSJoda.Temporal this ^js/JSJoda.TemporalAmount amount]
   (.minus this amount))
  (^js/JSJoda.Temporal
   [^js/JSJoda.Temporal this ^long amount-to-subtract
    ^js/JSJoda.TemporalUnit unit]
   (.minus this amount-to-subtract unit)))

(defn get-long
  "Gets the value of the specified field as a {@code long}.\n <p>\n This queries the date-time for the value of the specified field.\n The returned value may be outside the valid range of values for the field.\n If the date-time cannot return the value, because the field is unsupported or for\n some other reason, an exception will be thrown.\n\n @implSpec\n Implementations must check and handle all fields defined in {@link ChronoField}.\n If the field is supported, then the value of the field must be returned.\n If unsupported, then an {@code UnsupportedTemporalTypeException} must be thrown.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument.\n <p>\n Implementations must ensure that no observable state is altered when this\n read-only method is invoked.\n\n @param field  the field to get, not null\n @return the value for the field\n @throws DateTimeException if a value for the field cannot be obtained\n @throws UnsupportedTemporalTypeException if the field is not supported\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalField"]))}
  (^long [^js/JSJoda.Temporal this ^js/JSJoda.TemporalField field]
   (.getLong this field)))

(defn until
  "Calculates the amount of time until another temporal in terms of the specified unit.\n <p>\n This calculates the amount of time between two temporal objects\n in terms of a single {@code TemporalUnit}.\n The start and end points are {@code this} and the specified temporal.\n The end point is converted to be of the same type as the start point if different.\n The result will be negative if the end is before the start.\n For example, the amount in hours between two temporal objects can be\n calculated using {@code startTime.until(endTime, HOURS)}.\n <p>\n The calculation returns a whole number, representing the number of\n complete units between the two temporals.\n For example, the amount in hours between the times 11:30 and 13:29\n will only be one hour as it is one minute short of two hours.\n <p>\n There are two equivalent ways of using this method.\n The first is to invoke this method directly.\n The second is to use {@link TemporalUnit#between(Temporal, Temporal)}:\n <pre>\n   // these two lines are equivalent\n   temporal = start.until(end, unit);\n   temporal = unit.between(start, end);\n </pre>\n The choice should be made based on which makes the code more readable.\n <p>\n For example, this method allows the number of days between two dates to\n be calculated:\n <pre>\n  long daysBetween = start.until(end, DAYS);\n  // or alternatively\n  long daysBetween = DAYS.between(start, end);\n </pre>\n\n @implSpec\n Implementations must begin by checking to ensure that the input temporal\n object is of the same observable type as the implementation.\n They must then perform the calculation for all instances of {@link ChronoUnit}.\n An {@code UnsupportedTemporalTypeException} must be thrown for {@code ChronoUnit}\n instances that are unsupported.\n <p>\n If the unit is not a {@code ChronoUnit}, then the result of this method\n is obtained by invoking {@code TemporalUnit.between(Temporal, Temporal)}\n passing {@code this} as the first argument and the converted input temporal as\n the second argument.\n <p>\n In summary, implementations must behave in a manner equivalent to this pseudo-code:\n <pre>\n  // convert the end temporal to the same type as this class\n  if (unit instanceof ChronoUnit) {\n    // if unit is supported, then calculate and return result\n    // else throw UnsupportedTemporalTypeException for unsupported units\n  }\n  return unit.between(this, convertedEndTemporal);\n </pre>\n <p>\n Note that the unit's {@code between} method must only be invoked if the\n two temporal objects have exactly the same type evaluated by {@code getClass()}.\n <p>\n Implementations must ensure that no observable state is altered when this\n read-only method is invoked.\n\n @param endExclusive  the end temporal, exclusive, converted to be of the\n  same type as this object, not null\n @param unit  the unit to measure the amount in, not null\n @return the amount of time between this temporal object and the specified one\n  in terms of the unit; positive if the specified object is later than this one,\n  negative if it is earlier than this one\n @throws DateTimeException if the amount cannot be calculated, or the end\n  temporal cannot be converted to the same type as this temporal\n @throws UnsupportedTemporalTypeException if the unit is not supported\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.Temporal"
                      "java.time.temporal.TemporalUnit"]))}
  (^long
   [^js/JSJoda.Temporal this ^js/JSJoda.Temporal end-exclusive
    ^js/JSJoda.TemporalUnit unit]
   (.until this end-exclusive unit)))

(defn is-supported
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalUnit"]
                     ["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalField"]))}
  (^boolean [this arg0] (.isSupported ^js/JSJoda.Temporal this arg0)))

(defn with
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalAdjuster"]
                     ["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalField" "long"]))}
  (^js/JSJoda.Temporal
   [^js/JSJoda.Temporal this ^js/JSJoda.TemporalAdjuster adjuster]
   (.with this adjuster))
  (^js/JSJoda.Temporal
   [^js/JSJoda.Temporal this ^js/JSJoda.TemporalField field ^long new-value]
   (.with this field new-value)))

(defn get
  "Gets the value of the specified field as an {@code int}.\n <p>\n This queries the date-time for the value of the specified field.\n The returned value will always be within the valid range of values for the field.\n If the date-time cannot return the value, because the field is unsupported or for\n some other reason, an exception will be thrown.\n\n @implSpec\n Implementations must check and handle all fields defined in {@link ChronoField}.\n If the field is supported and has an {@code int} range, then the value of\n the field must be returned.\n If unsupported, then an {@code UnsupportedTemporalTypeException} must be thrown.\n <p>\n If the field is not a {@code ChronoField}, then the result of this method\n is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}\n passing {@code this} as the argument.\n <p>\n Implementations must ensure that no observable state is altered when this\n read-only method is invoked.\n <p>\n The default implementation must behave equivalent to this code:\n <pre>\n  if (range(field).isIntValue()) {\n    return range(field).checkValidIntValue(getLong(field), field);\n  }\n  throw new UnsupportedTemporalTypeException(\"Invalid field \" + field + \" + for get() method, use getLong() instead\");\n </pre>\n\n @param field  the field to get, not null\n @return the value for the field, within the valid range of values\n @throws DateTimeException if a value for the field cannot be obtained or\n         the value is outside the range of valid values for the field\n @throws UnsupportedTemporalTypeException if the field is not supported or\n         the range of values exceeds an {@code int}\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalField"]))}
  (^int [^js/JSJoda.Temporal this ^js/JSJoda.TemporalField field]
   (.get this field)))
