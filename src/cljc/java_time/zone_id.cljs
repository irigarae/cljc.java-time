(ns cljc.java-time.zone-id
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [ZoneId]]))

(def short-ids
  "A map of zone overrides to enable the short time-zone names to be used.

 Use of short zone IDs has been deprecated in {@code java.util.TimeZone}.
 This map allows the IDs to continue to be used via the
 {@link #of(String, Map)} factory method.

 This map contains a mapping of the IDs that is in line with TZDB 2005r and
 later, where 'EST', 'MST' and 'HST' map to IDs which do not include daylight
 savings.

 This maps as follows:
 <ul>
 <li>EST - -05:00</li>
 <li>HST - -10:00</li>
 <li>MST - -07:00</li>
 <li>ACT - Australia/Darwin</li>
 <li>AET - Australia/Sydney</li>
 <li>AGT - America/Argentina/Buenos_Aires</li>
 <li>ART - Africa/Cairo</li>
 <li>AST - America/Anchorage</li>
 <li>BET - America/Sao_Paulo</li>
 <li>BST - Asia/Dhaka</li>
 <li>CAT - Africa/Harare</li>
 <li>CNT - America/St_Johns</li>
 <li>CST - America/Chicago</li>
 <li>CTT - Asia/Shanghai</li>
 <li>EAT - Africa/Addis_Ababa</li>
 <li>ECT - Europe/Paris</li>
 <li>IET - America/Indiana/Indianapolis</li>
 <li>IST - Asia/Kolkata</li>
 <li>JST - Asia/Tokyo</li>
 <li>MIT - Pacific/Apia</li>
 <li>NET - Asia/Yerevan</li>
 <li>NST - Pacific/Auckland</li>
 <li>PLT - Asia/Karachi</li>
 <li>PNT - America/Phoenix</li>
 <li>PRT - America/Puerto_Rico</li>
 <li>PST - America/Los_Angeles</li>
 <li>SST - Pacific/Guadalcanal</li>
 <li>VST - Asia/Ho_Chi_Minh</li>
 </ul>
 The map is unmodifiable."
  (goog.object/get java.time.ZoneId "SHORT_IDS"))

(defn get-available-zone-ids
  "Gets the set of available zone IDs.

 This set includes the string form of all available region-based IDs.
 Offset-based zone IDs are not included in the returned set.
 The ID can be passed to {@link #of(String)} to create a {@code ZoneId}.

 The set of zone IDs can increase over time, although in a typical application
 the set of IDs is fixed. Each call to this method is thread-safe.

 @return a modifiable copy of the set of zone IDs, not null"
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
  "Obtains an instance of {@code ZoneId} wrapping an offset.

 If the prefix is \"GMT\", \"UTC\", or \"UT\" a {@code ZoneId}
 with the prefix and the non-zero offset is returned.
 If the prefix is empty {@code \"\"} the {@code ZoneOffset} is returned.

 @param prefix  the time-zone ID, not null
 @param offset  the offset, not null
 @return the zone ID, not null
 @throws IllegalArgumentException if the prefix is not one of
     \"GMT\", \"UTC\", or \"UT\", or \"\""
  {:arglists (quote (["java.lang.String" "java.time.ZoneOffset"]))}
  (^js/JSJoda.ZoneId [^java.lang.String prefix ^js/JSJoda.ZoneOffset offset]
   (js-invoke java.time.ZoneId "ofOffset" prefix offset)))

(defn to-string
  "Outputs this zone as a {@code String}, using the ID.

 @return a string representation of this time-zone ID, not null"
  {:arglists (quote (["java.time.ZoneId"]))}
  (^java.lang.String [^js/JSJoda.ZoneId this] (.toString this)))

(defn get-display-name
  "Gets the textual representation of the zone, such as 'British Time' or
 '+02:00'.

 This returns the textual name used to identify the time-zone ID,
 suitable for presentation to the user.
 The parameters control the style of the returned text and the locale.

 If no textual mapping is found then the {@link #getId() full ID} is returned.

 @param style  the length of the text required, not null
 @param locale  the locale to use, not null
 @return the text value of the zone, not null"
  {:arglists (quote (["java.time.ZoneId" "java.time.format.TextStyle"
                      "java.util.Locale"]))}
  (^java.lang.String
   [^js/JSJoda.ZoneId this ^js/JSJoda.TextStyle style ^java.util.Locale locale]
   (.displayName this style locale)))

(defn get-rules
  "Gets the time-zone rules for this ID allowing calculations to be performed.

 The rules provide the functionality associated with a time-zone,
 such as finding the offset for a given instant or local date-time.

 A time-zone can be invalid if it is deserialized in a Java Runtime which
 does not have the same rules loaded as the Java Runtime that stored it.
 In this case, calling this method will throw a {@code ZoneRulesException}.

 The rules are supplied by {@link ZoneRulesProvider}. An advanced provider may
 support dynamic updates to the rules without restarting the Java Runtime.
 If so, then the result of this method may change over time.
 Each individual call will be still remain thread-safe.

 {@link ZoneOffset} will always return a set of rules where the offset never changes.

 @return the rules, not null
 @throws ZoneRulesException if no rules are available for this ID"
  {:arglists (quote (["java.time.ZoneId"]))}
  (^js/JSJoda.ZoneRules [^js/JSJoda.ZoneId this] (.rules this)))

(defn get-id
  "Gets the unique time-zone ID.

 This ID uniquely defines this object.
 The format of an offset based ID is defined by {@link ZoneOffset#getId()}.

 @return the time-zone unique ID, not null"
  {:arglists (quote (["java.time.ZoneId"]))}
  (^java.lang.String [^js/JSJoda.ZoneId this] (.id this)))

(defn normalized
  "Normalizes the time-zone ID, returning a {@code ZoneOffset} where possible.

 The returns a normalized {@code ZoneId} that can be used in place of this ID.
 The result will have {@code ZoneRules} equivalent to those returned by this object,
 however the ID returned by {@code getId()} may be different.

 The normalization checks if the rules of this {@code ZoneId} have a fixed offset.
 If they do, then the {@code ZoneOffset} equal to that offset is returned.
 Otherwise {@code this} is returned.

 @return the time-zone unique ID, not null"
  {:arglists (quote (["java.time.ZoneId"]))}
  (^js/JSJoda.ZoneId [^js/JSJoda.ZoneId this] (.normalized this)))

(defn system-default
  "Gets the system default time-zone.

 This queries {@link TimeZone#getDefault()} to find the default time-zone
 and converts it to a {@code ZoneId}. If the system default time-zone is changed,
 then the result of this method will also change.

 @return the zone ID, not null
 @throws DateTimeException if the converted zone ID has an invalid format
 @throws ZoneRulesException if the converted zone region ID cannot be found"
  {:arglists (quote ([]))}
  (^js/JSJoda.ZoneId [] (js-invoke java.time.ZoneId "systemDefault")))

(defn from
  "Obtains an instance of {@code ZoneId} from a temporal object.

 This obtains a zone based on the specified temporal.
 A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 which this factory converts to an instance of {@code ZoneId}.

 A {@code TemporalAccessor} represents some form of date and time information.
 This factory converts the arbitrary temporal object to an instance of {@code ZoneId}.

 The conversion will try to obtain the zone in a way that favours region-based
 zones over offset-based zones using {@link TemporalQueries#zone()}.

 This method matches the signature of the functional interface {@link TemporalQuery}
 allowing it to be used as a query via method reference, {@code ZoneId::from}.

 @param temporal  the temporal object to convert, not null
 @return the zone ID, not null
 @throws DateTimeException if unable to convert to a {@code ZoneId}"
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^js/JSJoda.ZoneId [^js/JSJoda.TemporalAccessor temporal]
   (js-invoke java.time.ZoneId "from" temporal)))

(defn hash-code
  "A hash code for this time-zone ID.

 @return a suitable hash code"
  {:arglists (quote (["java.time.ZoneId"]))}
  (^int [^js/JSJoda.ZoneId this] (.hashCode this)))

(defn equals
  "Checks if this time-zone ID is equal to another time-zone ID.

 The comparison is based on the ID.

 @param obj  the object to check, null returns false
 @return true if this is equal to the other time-zone ID"
  {:arglists (quote (["java.time.ZoneId" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.ZoneId this ^java.lang.Object obj] (.equals this obj)))
