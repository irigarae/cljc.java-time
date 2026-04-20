(ns cljc.java-time.temporal.temporal-amount
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time.temporal TemporalAmount]))

(defn add-to
  "Adds to the specified temporal object.

 Adds the amount to the specified temporal object using the logic
 encapsulated in the implementing class.

 There are two equivalent ways of using this method.
 The first is to invoke this method directly.
 The second is to use {@link Temporal#plus(TemporalAmount)}:
 <pre>
   // These two lines are equivalent, but the second approach is recommended
   dateTime = amount.addTo(dateTime);
   dateTime = dateTime.plus(adder);
 </pre>
 It is recommended to use the second approach, {@code plus(TemporalAmount)},
 as it is a lot clearer to read in code.

 @implSpec
 The implementation must take the input object and add to it.
 The implementation defines the logic of the addition and is responsible for
 documenting that logic. It may use any method on {@code Temporal} to
 query the temporal object and perform the addition.
 The returned object must have the same observable type as the input object

 The input object must not be altered.
 Instead, an adjusted copy of the original must be returned.
 This provides equivalent, safe behavior for immutable and mutable temporal objects.

 The input temporal object may be in a calendar system other than ISO.
 Implementations may choose to document compatibility with other calendar systems,
 or reject non-ISO temporal objects by {@link TemporalQueries#chronology() querying the chronology}.

 This method may be called from multiple threads in parallel.
 It must be thread-safe when invoked.

 @param temporal  the temporal object to add the amount to, not null
 @return an object of the same observable type with the addition made, not null
 @throws DateTimeException if unable to add
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalAmount"
                      "java.time.temporal.Temporal"]))}
  (^java.time.temporal.Temporal
   [^java.time.temporal.TemporalAmount this
    ^java.time.temporal.Temporal temporal]
   (.addTo this temporal)))

(defn get
  "Returns the value of the requested unit.
 The units returned from {@link #getUnits()} uniquely define the
 value of the {@code TemporalAmount}.  A value must be returned
 for each unit listed in {@code getUnits}.

 @implSpec
 Implementations may declare support for units not listed by {@link #getUnits()}.
 Typically, the implementation would define additional units
 as conversions for the convenience of developers.

 @param unit the {@code TemporalUnit} for which to return the value
 @return the long value of the unit
 @throws DateTimeException if a value for the unit cannot be obtained
 @throws UnsupportedTemporalTypeException if the {@code unit} is not supported"
  {:arglists (quote (["java.time.temporal.TemporalAmount"
                      "java.time.temporal.TemporalUnit"]))}
  (^long
   [^java.time.temporal.TemporalAmount this ^java.time.temporal.ChronoUnit unit]
   (.get this unit)))

(defn get-units
  "Returns the list of units uniquely defining the value of this TemporalAmount.
 The list of {@code TemporalUnits} is defined by the implementation class.
 The list is a snapshot of the units at the time {@code getUnits}
 is called and is not mutable.
 The units are ordered from longest duration to the shortest duration
 of the unit.

 @implSpec
 The list of units completely and uniquely represents the
 state of the object without omissions, overlaps or duplication.
 The units are in order from longest duration to shortest.

 @return the List of {@code TemporalUnits}; not null"
  {:arglists (quote (["java.time.temporal.TemporalAmount"]))}
  (^java.util.List [^java.time.temporal.TemporalAmount this] (.getUnits this)))

(defn subtract-from
  "Subtracts this object from the specified temporal object.

 Subtracts the amount from the specified temporal object using the logic
 encapsulated in the implementing class.

 There are two equivalent ways of using this method.
 The first is to invoke this method directly.
 The second is to use {@link Temporal#minus(TemporalAmount)}:
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   dateTime = amount.subtractFrom(dateTime);
   dateTime = dateTime.minus(amount);
 </pre>
 It is recommended to use the second approach, {@code minus(TemporalAmount)},
 as it is a lot clearer to read in code.

 @implSpec
 The implementation must take the input object and subtract from it.
 The implementation defines the logic of the subtraction and is responsible for
 documenting that logic. It may use any method on {@code Temporal} to
 query the temporal object and perform the subtraction.
 The returned object must have the same observable type as the input object

 The input object must not be altered.
 Instead, an adjusted copy of the original must be returned.
 This provides equivalent, safe behavior for immutable and mutable temporal objects.

 The input temporal object may be in a calendar system other than ISO.
 Implementations may choose to document compatibility with other calendar systems,
 or reject non-ISO temporal objects by {@link TemporalQueries#chronology() querying the chronology}.

 This method may be called from multiple threads in parallel.
 It must be thread-safe when invoked.

 @param temporal  the temporal object to subtract the amount from, not null
 @return an object of the same observable type with the subtraction made, not null
 @throws DateTimeException if unable to subtract
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalAmount"
                      "java.time.temporal.Temporal"]))}
  (^java.time.temporal.Temporal
   [^java.time.temporal.TemporalAmount this
    ^java.time.temporal.Temporal temporal]
   (.subtractFrom this temporal)))
