(ns cljc.java-time.temporal.temporal-query
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time.temporal TemporalQuery]))

(defn query-from
  "Queries the specified temporal object.\n <p>\n This queries the specified temporal object to return an object using the logic\n encapsulated in the implementing class.\n Examples might be a query that checks if the date is the day before February 29th\n in a leap year, or calculates the number of days to your next birthday.\n <p>\n There are two equivalent ways of using this method.\n The first is to invoke this method directly.\n The second is to use {@link TemporalAccessor#query(TemporalQuery)}:\n <pre>\n   // these two lines are equivalent, but the second approach is recommended\n   temporal = thisQuery.queryFrom(temporal);\n   temporal = temporal.query(thisQuery);\n </pre>\n It is recommended to use the second approach, {@code query(TemporalQuery)},\n as it is a lot clearer to read in code.\n\n @implSpec\n The implementation must take the input object and query it.\n The implementation defines the logic of the query and is responsible for\n documenting that logic.\n It may use any method on {@code TemporalAccessor} to determine the result.\n The input object must not be altered.\n <p>\n The input temporal object may be in a calendar system other than ISO.\n Implementations may choose to document compatibility with other calendar systems,\n or reject non-ISO temporal objects by {@link TemporalQueries#chronology() querying the chronology}.\n <p>\n This method may be called from multiple threads in parallel.\n It must be thread-safe when invoked.\n\n @param temporal  the temporal object to query, not null\n @return the queried value, may return null to indicate not found\n @throws DateTimeException if unable to query\n @throws ArithmeticException if numeric overflow occurs"
  {:arglists (quote (["java.time.temporal.TemporalQuery"
                      "java.time.temporal.TemporalAccessor"]))}
  (^java.lang.Object
   [^java.time.temporal.TemporalQuery this
    ^java.time.temporal.TemporalAccessor temporal]
   (.queryFrom this temporal)))
