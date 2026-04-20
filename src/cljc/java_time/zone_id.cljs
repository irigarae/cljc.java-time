(ns cljc.java-time.zone-id
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [ZoneId]]))

(def short-ids (goog.object/get java.time.ZoneId "SHORT_IDS"))

(defn get-available-zone-ids
  "Gets the set of available zone IDs.\n <p>\n This set includes the string form of all available region-based IDs.\n Offset-based zone IDs are not included in the returned set.\n The ID can be passed to {@link #of(String)} to create a {@code ZoneId}.\n <p>\n The set of zone IDs can increase over time, although in a typical application\n the set of IDs is fixed. Each call to this method is thread-safe.\n\n @return a modifiable copy of the set of zone IDs, not null"
  {:arglists (quote ([]))}
  (^java.util.Set [] (js-invoke java.time.ZoneId "getAvailableZoneIds")))

(defn of
  {:arglists (quote (["java.lang.String"]
                     ["java.lang.String" "java.util.Map"]))}
  (^js/JSJoda.ZoneId [^java.lang.String zone-id]
   (js-invoke java.time.ZoneId "of" zone-id))
  (^js/JSJoda.ZoneId [^java.lang.String zone-id ^java.util.Map alias-map]
   (js-invoke java.time.ZoneId "of" zone-id alias-map)))

(defn of-offset
  "Obtains an instance of {@code ZoneId} wrapping an offset.\n <p>\n If the prefix is \"GMT\", \"UTC\", or \"UT\" a {@code ZoneId}\n with the prefix and the non-zero offset is returned.\n If the prefix is empty {@code \"\"} the {@code ZoneOffset} is returned.\n\n @param prefix  the time-zone ID, not null\n @param offset  the offset, not null\n @return the zone ID, not null\n @throws IllegalArgumentException if the prefix is not one of\n     \"GMT\", \"UTC\", or \"UT\", or \"\""
  {:arglists (quote (["java.lang.String" "java.time.ZoneOffset"]))}
  (^js/JSJoda.ZoneId [^java.lang.String prefix ^js/JSJoda.ZoneOffset offset]
   (js-invoke java.time.ZoneId "ofOffset" prefix offset)))

(defn to-string
  "Outputs this zone as a {@code String}, using the ID.\n\n @return a string representation of this time-zone ID, not null"
  {:arglists (quote (["java.time.ZoneId"]))}
  (^java.lang.String [^js/JSJoda.ZoneId this] (.toString this)))

(defn get-display-name
  "Gets the textual representation of the zone, such as 'British Time' or\n '+02:00'.\n <p>\n This returns the textual name used to identify the time-zone ID,\n suitable for presentation to the user.\n The parameters control the style of the returned text and the locale.\n <p>\n If no textual mapping is found then the {@link #getId() full ID} is returned.\n\n @param style  the length of the text required, not null\n @param locale  the locale to use, not null\n @return the text value of the zone, not null"
  {:arglists (quote (["java.time.ZoneId" "java.time.format.TextStyle"
                      "java.util.Locale"]))}
  (^java.lang.String
   [^js/JSJoda.ZoneId this ^js/JSJoda.TextStyle style ^java.util.Locale locale]
   (.displayName this style locale)))

(defn get-rules
  "Gets the time-zone rules for this ID allowing calculations to be performed.\n <p>\n The rules provide the functionality associated with a time-zone,\n such as finding the offset for a given instant or local date-time.\n <p>\n A time-zone can be invalid if it is deserialized in a Java Runtime which\n does not have the same rules loaded as the Java Runtime that stored it.\n In this case, calling this method will throw a {@code ZoneRulesException}.\n <p>\n The rules are supplied by {@link ZoneRulesProvider}. An advanced provider may\n support dynamic updates to the rules without restarting the Java Runtime.\n If so, then the result of this method may change over time.\n Each individual call will be still remain thread-safe.\n <p>\n {@link ZoneOffset} will always return a set of rules where the offset never changes.\n\n @return the rules, not null\n @throws ZoneRulesException if no rules are available for this ID"
  {:arglists (quote (["java.time.ZoneId"]))}
  (^js/JSJoda.ZoneRules [^js/JSJoda.ZoneId this] (.rules this)))

(defn get-id
  "Gets the unique time-zone ID.\n <p>\n This ID uniquely defines this object.\n The format of an offset based ID is defined by {@link ZoneOffset#getId()}.\n\n @return the time-zone unique ID, not null"
  {:arglists (quote (["java.time.ZoneId"]))}
  (^java.lang.String [^js/JSJoda.ZoneId this] (.id this)))

(defn normalized
  "Normalizes the time-zone ID, returning a {@code ZoneOffset} where possible.\n <p>\n The returns a normalized {@code ZoneId} that can be used in place of this ID.\n The result will have {@code ZoneRules} equivalent to those returned by this object,\n however the ID returned by {@code getId()} may be different.\n <p>\n The normalization checks if the rules of this {@code ZoneId} have a fixed offset.\n If they do, then the {@code ZoneOffset} equal to that offset is returned.\n Otherwise {@code this} is returned.\n\n @return the time-zone unique ID, not null"
  {:arglists (quote (["java.time.ZoneId"]))}
  (^js/JSJoda.ZoneId [^js/JSJoda.ZoneId this] (.normalized this)))

(defn system-default
  "Gets the system default time-zone.\n <p>\n This queries {@link TimeZone#getDefault()} to find the default time-zone\n and converts it to a {@code ZoneId}. If the system default time-zone is changed,\n then the result of this method will also change.\n\n @return the zone ID, not null\n @throws DateTimeException if the converted zone ID has an invalid format\n @throws ZoneRulesException if the converted zone region ID cannot be found"
  {:arglists (quote ([]))}
  (^js/JSJoda.ZoneId [] (js-invoke java.time.ZoneId "systemDefault")))

(defn from
  "Obtains an instance of {@code ZoneId} from a temporal object.\n <p>\n This obtains a zone based on the specified temporal.\n A {@code TemporalAccessor} represents an arbitrary set of date and time information,\n which this factory converts to an instance of {@code ZoneId}.\n <p>\n A {@code TemporalAccessor} represents some form of date and time information.\n This factory converts the arbitrary temporal object to an instance of {@code ZoneId}.\n <p>\n The conversion will try to obtain the zone in a way that favours region-based\n zones over offset-based zones using {@link TemporalQueries#zone()}.\n <p>\n This method matches the signature of the functional interface {@link TemporalQuery}\n allowing it to be used as a query via method reference, {@code ZoneId::from}.\n\n @param temporal  the temporal object to convert, not null\n @return the zone ID, not null\n @throws DateTimeException if unable to convert to a {@code ZoneId}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^js/JSJoda.ZoneId [^js/JSJoda.TemporalAccessor temporal]
   (js-invoke java.time.ZoneId "from" temporal)))

(defn hash-code
  "A hash code for this time-zone ID.\n\n @return a suitable hash code"
  {:arglists (quote (["java.time.ZoneId"]))}
  (^int [^js/JSJoda.ZoneId this] (.hashCode this)))

(defn equals
  "Checks if this time-zone ID is equal to another time-zone ID.\n <p>\n The comparison is based on the ID.\n\n @param obj  the object to check, null returns false\n @return true if this is equal to the other time-zone ID"
  {:arglists (quote (["java.time.ZoneId" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.ZoneId this ^java.lang.Object obj] (.equals this obj)))
