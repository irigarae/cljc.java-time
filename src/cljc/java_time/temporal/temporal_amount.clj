(ns cljc.java-time.temporal.temporal-amount
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time.temporal TemporalAmount]))

(defn add-to
  "Adds to the specified temporal object.\n <p>\n Adds the amount to the specified temporal object using the logic\n encapsulated in the implementing class.\n <p>\n There are two equivalent ways of using this method.\n The first is to invoke this method directly.\n The second is to use {@link Temporal#plus(TemporalAmount)}:\n <pre>\n   // These two lines are equivalent, but the second approach is recommended\n   dateTime = amount.addTo(dateTime);\n   dateTime = dateTime.plus(adder);\n </pre>\n It is recommended to use the second approach, {@code plus(TemporalAmount)},\n as it is a lot clearer to read in code.\n\n @implSpec\n The implementation must take the input object and add to it.\n The implementation defines the logic of the addition and is responsible for\n documenting that logic. It may use any method on {@code Temporal} to\n query the temporal object and perform the addition.\n The returned object must have the same observable type as the input object\n <p>\n The input object must not be altered.\n Instead, an adjusted copy of the original must be returned.\n This provides equivalent, safe behavior for immutable and mutable temporal objects.\n <p>\n The input temporal object may be in a calendar system other than ISO.\n Implementations may choose to document compatibility with other calendar systems,\n or reject non-ISO temporal objects by {@link TemporalQueries#chronology() querying the chronology}.\n <p>\n This method may be called from multiple threads in parallel.\n It must be thread-safe when invoked.\n\n @param temporal  the temporal object to add the amount to, not null\n @return an object of the same observable type with the addition made, not null\n @throws DateTimeException if unable to add\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalAmount"
                      "java.time.temporal.Temporal"]))}
  (^java.time.temporal.Temporal
   [^java.time.temporal.TemporalAmount this
    ^java.time.temporal.Temporal temporal]
   (.addTo this temporal)))

(defn get
  "Returns the value of the requested unit.\n The units returned from {@link #getUnits()} uniquely define the\n value of the {@code TemporalAmount}.  A value must be returned\n for each unit listed in {@code getUnits}.\n\n @implSpec\n Implementations may declare support for units not listed by {@link #getUnits()}.\n Typically, the implementation would define additional units\n as conversions for the convenience of developers.\n\n @param unit the {@code TemporalUnit} for which to return the value\n @return the long value of the unit\n @throws DateTimeException if a value for the unit cannot be obtained\n @throws UnsupportedTemporalTypeException if the {@code unit} is not supported"
  {:arglists (quote (["java.time.temporal.TemporalAmount"
                      "java.time.temporal.TemporalUnit"]))}
  (^long
   [^java.time.temporal.TemporalAmount this ^java.time.temporal.ChronoUnit unit]
   (.get this unit)))

(defn get-units
  "Returns the list of units uniquely defining the value of this TemporalAmount.\n The list of {@code TemporalUnits} is defined by the implementation class.\n The list is a snapshot of the units at the time {@code getUnits}\n is called and is not mutable.\n The units are ordered from longest duration to the shortest duration\n of the unit.\n\n @implSpec\n The list of units completely and uniquely represents the\n state of the object without omissions, overlaps or duplication.\n The units are in order from longest duration to shortest.\n\n @return the List of {@code TemporalUnits}; not null"
  {:arglists (quote (["java.time.temporal.TemporalAmount"]))}
  (^java.util.List [^java.time.temporal.TemporalAmount this] (.getUnits this)))

(defn subtract-from
  "Subtracts this object from the specified temporal object.\n <p>\n Subtracts the amount from the specified temporal object using the logic\n encapsulated in the implementing class.\n <p>\n There are two equivalent ways of using this method.\n The first is to invoke this method directly.\n The second is to use {@link Temporal#minus(TemporalAmount)}:\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   dateTime = amount.subtractFrom(dateTime);\n   dateTime = dateTime.minus(amount);\n </pre>\n It is recommended to use the second approach, {@code minus(TemporalAmount)},\n as it is a lot clearer to read in code.\n\n @implSpec\n The implementation must take the input object and subtract from it.\n The implementation defines the logic of the subtraction and is responsible for\n documenting that logic. It may use any method on {@code Temporal} to\n query the temporal object and perform the subtraction.\n The returned object must have the same observable type as the input object\n <p>\n The input object must not be altered.\n Instead, an adjusted copy of the original must be returned.\n This provides equivalent, safe behavior for immutable and mutable temporal objects.\n <p>\n The input temporal object may be in a calendar system other than ISO.\n Implementations may choose to document compatibility with other calendar systems,\n or reject non-ISO temporal objects by {@link TemporalQueries#chronology() querying the chronology}.\n <p>\n This method may be called from multiple threads in parallel.\n It must be thread-safe when invoked.\n\n @param temporal  the temporal object to subtract the amount from, not null\n @return an object of the same observable type with the subtraction made, not null\n @throws DateTimeException if unable to subtract\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalAmount"
                      "java.time.temporal.Temporal"]))}
  (^java.time.temporal.Temporal
   [^java.time.temporal.TemporalAmount this
    ^java.time.temporal.Temporal temporal]
   (.subtractFrom this temporal)))
