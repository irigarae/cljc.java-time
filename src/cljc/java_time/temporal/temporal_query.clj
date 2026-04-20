(ns cljc.java-time.temporal.temporal-query
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time.temporal TemporalQuery]))

(defn query-from
  "Queries the specified temporal object.

 This queries the specified temporal object to return an object using the logic
 encapsulated in the implementing class.
 Examples might be a query that checks if the date is the day before February 29th
 in a leap year, or calculates the number of days to your next birthday.

 There are two equivalent ways of using this method.
 The first is to invoke this method directly.
 The second is to use {@link TemporalAccessor#query(TemporalQuery)}:
 <pre>
   // these two lines are equivalent, but the second approach is recommended
   temporal = thisQuery.queryFrom(temporal);
   temporal = temporal.query(thisQuery);
 </pre>
 It is recommended to use the second approach, {@code query(TemporalQuery)},
 as it is a lot clearer to read in code.

 @implSpec
 The implementation must take the input object and query it.
 The implementation defines the logic of the query and is responsible for
 documenting that logic.
 It may use any method on {@code TemporalAccessor} to determine the result.
 The input object must not be altered.

 The input temporal object may be in a calendar system other than ISO.
 Implementations may choose to document compatibility with other calendar systems,
 or reject non-ISO temporal objects by {@link TemporalQueries#chronology() querying the chronology}.

 This method may be called from multiple threads in parallel.
 It must be thread-safe when invoked.

 @param temporal  the temporal object to query, not null
 @return the queried value, may return null to indicate not found
 @throws DateTimeException if unable to query
 @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalQuery"
                      "java.time.temporal.TemporalAccessor"]))}
  (^java.lang.Object
   [^java.time.temporal.TemporalQuery this
    ^java.time.temporal.TemporalAccessor temporal]
   (.queryFrom this temporal)))
