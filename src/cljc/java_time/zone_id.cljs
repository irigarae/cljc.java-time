(ns cljc.java-time.zone-id
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [ZoneId]]))

(def short-ids (goog.object/get java.time.ZoneId "SHORT_IDS"))

(defn get-available-zone-ids
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
  {:arglists (quote (["java.lang.String" "java.time.ZoneOffset"]))}
  (^js/JSJoda.ZoneId [^java.lang.String prefix ^js/JSJoda.ZoneOffset offset]
   (js-invoke java.time.ZoneId "ofOffset" prefix offset)))

(defn to-string
  {:arglists (quote (["java.time.ZoneId"]))}
  (^java.lang.String [^js/JSJoda.ZoneId this] (.toString this)))

(defn get-display-name
  {:arglists (quote (["java.time.ZoneId" "java.time.format.TextStyle"
                      "java.util.Locale"]))}
  (^java.lang.String
   [^js/JSJoda.ZoneId this ^js/JSJoda.TextStyle style ^java.util.Locale locale]
   (.displayName this style locale)))

(defn get-rules
  {:arglists (quote (["java.time.ZoneId"]))}
  (^js/JSJoda.ZoneRules [^js/JSJoda.ZoneId this] (.rules this)))

(defn get-id
  {:arglists (quote (["java.time.ZoneId"]))}
  (^java.lang.String [^js/JSJoda.ZoneId this] (.id this)))

(defn normalized
  {:arglists (quote (["java.time.ZoneId"]))}
  (^js/JSJoda.ZoneId [^js/JSJoda.ZoneId this] (.normalized this)))

(defn system-default
  {:arglists (quote ([]))}
  (^js/JSJoda.ZoneId [] (js-invoke java.time.ZoneId "systemDefault")))

(defn from
  {:arglists (quote (["java.time.temporal.TemporalAccessor"]))}
  (^js/JSJoda.ZoneId [^js/JSJoda.TemporalAccessor temporal]
   (js-invoke java.time.ZoneId "from" temporal)))

(defn hash-code
  {:arglists (quote (["java.time.ZoneId"]))}
  (^int [^js/JSJoda.ZoneId this] (.hashCode this)))

(defn equals
  {:arglists (quote (["java.time.ZoneId" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.ZoneId this ^java.lang.Object obj] (.equals this obj)))
