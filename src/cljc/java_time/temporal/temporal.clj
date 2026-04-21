(ns cljc.java-time.temporal.temporal
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time.temporal Temporal]))

(defn range
  "Gets the range of valid values for the specified field.

 All fields can be expressed as a {@code long} integer.
 This method returns an object that describes the valid range for that value.
 The value of this temporal object is used to enhance the accuracy of the returned range.
 If the date-time cannot return the range, because the field is unsupported or for
 some other reason, an exception will be thrown.

 Note that the result only describes the minimum and maximum valid values
 and it is important not to read too much into them. For example, there
 could be values within the range that are invalid for the field.

 @implSpec
 Implementations must check and handle all fields defined in {@link ChronoField}.
 If the field is supported, then the range of the field must be returned.
 If unsupported, then an {@code UnsupportedTemporalTypeException} must be thrown.

 If the field is not a {@code ChronoField}, then the result of this method
 is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessorl)}
 passing {@code this} as the argument.

 Implementations must ensure that no observable state is altered when this
 read-only method is invoked.

 The default implementation must behave equivalent to this code:
 <pre>
  if (field instanceof ChronoField) {
    if (isSupported(field)) {
      return field.range();
    }
    throw new UnsupportedTemporalTypeException(\"Unsupported field: \" + field);
  }
  return field.rangeRefinedBy(this);
 </pre>

 @param field  the field to query the range for, not null
 @return the range of valid values for the field, not null
 @throws DateTimeException if the range for the field cannot be obtained
 @throws UnsupportedTemporalTypeException if the field is not supported"
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalField"]))}
  (^java.time.temporal.ValueRange
   [^java.time.temporal.Temporal this ^java.time.temporal.TemporalField field]
   (.range this field)))

(defn plus
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalAmount"]
                     ["java.time.temporal.Temporal" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.temporal.Temporal
   [^java.time.temporal.Temporal this ^java.time.temporal.TemporalAmount amount]
   (.plus this amount))
  (^java.time.temporal.Temporal
   [^java.time.temporal.Temporal this ^long amount-to-add
    ^java.time.temporal.ChronoUnit unit]
   (.plus this amount-to-add unit)))

(defn query
  "Queries this date-time.

 This queries this date-time using the specified query strategy object.

 Queries are a key tool for extracting information from date-times.
 They exists to externalize the process of querying, permitting different
 approaches, as per the strategy design pattern.
 Examples might be a query that checks if the date is the day before February 29th
 in a leap year, or calculates the number of days to your next birthday.

 The most common query implementations are method references, such as
 {@code LocalDate::from} and {@code ZoneId::from}.
 Additional implementations are provided as static methods on {@link TemporalQuery}.

 @implSpec
 The default implementation must behave equivalent to this code:
 <pre>
  if (query == TemporalQueries.zoneId() ||
        query == TemporalQueries.chronology() || query == TemporalQueries.precision()) {
    return null;
  }
  return query.queryFrom(this);
 </pre>
 Future versions are permitted to add further queries to the if statement.

 All classes implementing this interface and overriding this method must call
 {@code TemporalAccessor.super.query(query)}. JDK classes may avoid calling
 super if they provide behavior equivalent to the default behaviour, however
 non-JDK classes may not utilize this optimization and must call {@code super}.

 If the implementation can supply a value for one of the queries listed in the
 if statement of the default implementation, then it must do so.
 For example, an application-defined {@code HourMin} class storing the hour
 and minute must override this method as follows:
 <pre>
  if (query == TemporalQueries.precision()) {
    return MINUTES;
  }
  return TemporalAccessor.super.query(query);
 </pre>

 Implementations must ensure that no observable state is altered when this
 read-only method is invoked.

 @param <R> the type of the result
 @param query  the query to invoke, not null
 @return the query result, null may be returned (defined by the query)
 @throws DateTimeException if unable to query
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.lang.Object
   [^java.time.temporal.Temporal this ^java.time.temporal.TemporalQuery query]
   (.query this query)))

(defn minus
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalAmount"]
                     ["java.time.temporal.Temporal" "long"
                      "java.time.temporal.TemporalUnit"]))}
  (^java.time.temporal.Temporal
   [^java.time.temporal.Temporal this ^java.time.temporal.TemporalAmount amount]
   (.minus this amount))
  (^java.time.temporal.Temporal
   [^java.time.temporal.Temporal this ^long amount-to-subtract
    ^java.time.temporal.ChronoUnit unit]
   (.minus this amount-to-subtract unit)))

(defn get-long
  "Gets the value of the specified field as a {@code long}.

 This queries the date-time for the value of the specified field.
 The returned value may be outside the valid range of values for the field.
 If the date-time cannot return the value, because the field is unsupported or for
 some other reason, an exception will be thrown.

 @implSpec
 Implementations must check and handle all fields defined in {@link ChronoField}.
 If the field is supported, then the value of the field must be returned.
 If unsupported, then an {@code UnsupportedTemporalTypeException} must be thrown.

 If the field is not a {@code ChronoField}, then the result of this method
 is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}
 passing {@code this} as the argument.

 Implementations must ensure that no observable state is altered when this
 read-only method is invoked.

 @param field  the field to get, not null
 @return the value for the field
 @throws DateTimeException if a value for the field cannot be obtained
 @throws UnsupportedTemporalTypeException if the field is not supported
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalField"]))}
  (^long
   [^java.time.temporal.Temporal this ^java.time.temporal.TemporalField field]
   (.getLong this field)))

(defn until
  "Calculates the amount of time until another temporal in terms of the specified unit.

 This calculates the amount of time between two temporal objects
 in terms of a single {@code TemporalUnit}.
 The start and end points are {@code this} and the specified temporal.
 The end point is converted to be of the same type as the start point if different.
 The result will be negative if the end is before the start.
 For example, the amount in hours between two temporal objects can be
 calculated using {@code startTime.until(endTime, HOURS)}.

 The calculation returns a whole number, representing the number of
 complete units between the two temporals.
 For example, the amount in hours between the times 11:30 and 13:29
 will only be one hour as it is one minute short of two hours.

 There are two equivalent ways of using this method.
 The first is to invoke this method directly.
 The second is to use {@link TemporalUnit#between(Temporal, Temporal)}:
 <pre>
   // these two lines are equivalent
   temporal = start.until(end, unit);
   temporal = unit.between(start, end);
 </pre>
 The choice should be made based on which makes the code more readable.

 For example, this method allows the number of days between two dates to
 be calculated:
 <pre>
  long daysBetween = start.until(end, DAYS);
  // or alternatively
  long daysBetween = DAYS.between(start, end);
 </pre>

 @implSpec
 Implementations must begin by checking to ensure that the input temporal
 object is of the same observable type as the implementation.
 They must then perform the calculation for all instances of {@link ChronoUnit}.
 An {@code UnsupportedTemporalTypeException} must be thrown for {@code ChronoUnit}
 instances that are unsupported.

 If the unit is not a {@code ChronoUnit}, then the result of this method
 is obtained by invoking {@code TemporalUnit.between(Temporal, Temporal)}
 passing {@code this} as the first argument and the converted input temporal as
 the second argument.

 In summary, implementations must behave in a manner equivalent to this pseudo-code:
 <pre>
  // convert the end temporal to the same type as this class
  if (unit instanceof ChronoUnit) {
    // if unit is supported, then calculate and return result
    // else throw UnsupportedTemporalTypeException for unsupported units
  }
  return unit.between(this, convertedEndTemporal);
 </pre>

 Note that the unit's {@code between} method must only be invoked if the
 two temporal objects have exactly the same type evaluated by {@code getClass()}.

 Implementations must ensure that no observable state is altered when this
 read-only method is invoked.

 @param endExclusive  the end temporal, exclusive, converted to be of the
  same type as this object, not null
 @param unit  the unit to measure the amount in, not null
 @return the amount of time between this temporal object and the specified one
  in terms of the unit; positive if the specified object is later than this one,
  negative if it is earlier than this one
 @throws DateTimeException if the amount cannot be calculated, or the end
  temporal cannot be converted to the same type as this temporal
 @throws UnsupportedTemporalTypeException if the unit is not supported
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.Temporal"
                      "java.time.temporal.TemporalUnit"]))}
  (^long
   [^java.time.temporal.Temporal this ^java.time.temporal.Temporal end-exclusive
    ^java.time.temporal.ChronoUnit unit]
   (.until this end-exclusive unit)))

(defn is-supported
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalUnit"]
                     ["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalField"]))}
  (^java.lang.Boolean [this arg0]
   (cond (and (instance? java.time.temporal.ChronoUnit arg0))
           (let [unit ^"java.time.temporal.ChronoUnit" arg0]
             (.isSupported ^java.time.temporal.Temporal this unit))
         (and (instance? java.time.temporal.TemporalField arg0))
           (let [field ^"java.time.temporal.TemporalField" arg0]
             (.isSupported ^java.time.temporal.Temporal this field))
         :else (throw (java.lang.IllegalArgumentException.
                        "no corresponding java.time method with these args")))))

(defn with
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalAdjuster"]
                     ["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalField" "long"]))}
  (^java.time.temporal.Temporal
   [^java.time.temporal.Temporal this
    ^java.time.temporal.TemporalAdjuster adjuster]
   (.with this adjuster))
  (^java.time.temporal.Temporal
   [^java.time.temporal.Temporal this ^java.time.temporal.TemporalField field
    ^long new-value]
   (.with this field new-value)))

(defn get
  "Gets the value of the specified field as an {@code int}.

 This queries the date-time for the value of the specified field.
 The returned value will always be within the valid range of values for the field.
 If the date-time cannot return the value, because the field is unsupported or for
 some other reason, an exception will be thrown.

 @implSpec
 Implementations must check and handle all fields defined in {@link ChronoField}.
 If the field is supported and has an {@code int} range, then the value of
 the field must be returned.
 If unsupported, then an {@code UnsupportedTemporalTypeException} must be thrown.

 If the field is not a {@code ChronoField}, then the result of this method
 is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}
 passing {@code this} as the argument.

 Implementations must ensure that no observable state is altered when this
 read-only method is invoked.

 The default implementation must behave equivalent to this code:
 <pre>
  if (range(field).isIntValue()) {
    return range(field).checkValidIntValue(getLong(field), field);
  }
  throw new UnsupportedTemporalTypeException(\"Invalid field \" + field + \" + for get() method, use getLong() instead\");
 </pre>

 @param field  the field to get, not null
 @return the value for the field, within the valid range of values
 @throws DateTimeException if a value for the field cannot be obtained or
         the value is outside the range of valid values for the field
 @throws UnsupportedTemporalTypeException if the field is not supported or
         the range of values exceeds an {@code int}
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.Temporal"
                      "java.time.temporal.TemporalField"]))}
  (^java.lang.Integer
   [^java.time.temporal.Temporal this ^java.time.temporal.TemporalField field]
   (.get this field)))
