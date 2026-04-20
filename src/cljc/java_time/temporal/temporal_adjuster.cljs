(ns cljc.java-time.temporal.temporal-adjuster
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time.temporal :refer [TemporalAdjuster]]))

(defn adjust-into
  "Adjusts the specified temporal object.\n <p>\n This adjusts the specified temporal object using the logic\n encapsulated in the implementing class.\n Examples might be an adjuster that sets the date avoiding weekends, or one that\n sets the date to the last day of the month.\n <p>\n There are two equivalent ways of using this method.\n The first is to invoke this method directly.\n The second is to use {@link Temporal#with(TemporalAdjuster)}:\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   temporal = thisAdjuster.adjustInto(temporal);\n   temporal = temporal.with(thisAdjuster);\n </pre>\n It is recommended to use the second approach, {@code with(TemporalAdjuster)},\n as it is a lot clearer to read in code.\n\n @implSpec\n The implementation must take the input object and adjust it.\n The implementation defines the logic of the adjustment and is responsible for\n documenting that logic. It may use any method on {@code Temporal} to\n query the temporal object and perform the adjustment.\n The returned object must have the same observable type as the input object\n <p>\n The input object must not be altered.\n Instead, an adjusted copy of the original must be returned.\n This provides equivalent, safe behavior for immutable and mutable temporal objects.\n <p>\n The input temporal object may be in a calendar system other than ISO.\n Implementations may choose to document compatibility with other calendar systems,\n or reject non-ISO temporal objects by {@link TemporalQueries#chronology() querying the chronology}.\n <p>\n This method may be called from multiple threads in parallel.\n It must be thread-safe when invoked.\n\n @param temporal  the temporal object to adjust, not null\n @return an object of the same observable type with the adjustment made, not null\n @throws DateTimeException if unable to make the adjustment\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalAdjuster"
                      "java.time.temporal.Temporal"]))}
  (^js/JSJoda.Temporal
   [^js/JSJoda.TemporalAdjuster this ^js/JSJoda.Temporal temporal]
   (.adjustInto this temporal)))
