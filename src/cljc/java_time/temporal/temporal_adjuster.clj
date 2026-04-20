(ns cljc.java-time.temporal.temporal-adjuster
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time.temporal TemporalAdjuster]))

(defn adjust-into
  "Adjusts the specified temporal object.

 This adjusts the specified temporal object using the logic
 encapsulated in the implementing class.
 Examples might be an adjuster that sets the date avoiding weekends, or one that
 sets the date to the last day of the month.

 There are two equivalent ways of using this method.
 The first is to invoke this method directly.
 The second is to use {@link Temporal#with(TemporalAdjuster)}:
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   temporal = thisAdjuster.adjustInto(temporal);
   temporal = temporal.with(thisAdjuster);
 </pre>
 It is recommended to use the second approach, {@code with(TemporalAdjuster)},
 as it is a lot clearer to read in code.

 @implSpec
 The implementation must take the input object and adjust it.
 The implementation defines the logic of the adjustment and is responsible for
 documenting that logic. It may use any method on {@code Temporal} to
 query the temporal object and perform the adjustment.
 The returned object must have the same observable type as the input object

 The input object must not be altered.
 Instead, an adjusted copy of the original must be returned.
 This provides equivalent, safe behavior for immutable and mutable temporal objects.

 The input temporal object may be in a calendar system other than ISO.
 Implementations may choose to document compatibility with other calendar systems,
 or reject non-ISO temporal objects by {@link TemporalQueries#chronology() querying the chronology}.

 This method may be called from multiple threads in parallel.
 It must be thread-safe when invoked.

 @param temporal  the temporal object to adjust, not null
 @return an object of the same observable type with the adjustment made, not null
 @throws DateTimeException if unable to make the adjustment
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalAdjuster"
                      "java.time.temporal.Temporal"]))}
  (^java.time.temporal.Temporal
   [^java.time.temporal.TemporalAdjuster this
    ^java.time.temporal.Temporal temporal]
   (.adjustInto this temporal)))
