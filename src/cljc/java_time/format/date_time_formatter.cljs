(ns cljc.java-time.format.date-time-formatter
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time.format :refer [DateTimeFormatter]]))

(def iso-local-time
  (goog.object/get java.time.format.DateTimeFormatter "ISO_LOCAL_TIME"))

(def iso-ordinal-date
  (goog.object/get java.time.format.DateTimeFormatter "ISO_ORDINAL_DATE"))

(def iso-offset-date
  (goog.object/get java.time.format.DateTimeFormatter "ISO_OFFSET_DATE"))

(def iso-time (goog.object/get java.time.format.DateTimeFormatter "ISO_TIME"))

(def iso-local-date-time
  (goog.object/get java.time.format.DateTimeFormatter "ISO_LOCAL_DATE_TIME"))

(def iso-instant
  (goog.object/get java.time.format.DateTimeFormatter "ISO_INSTANT"))

(def rfc-1123-date-time
  (goog.object/get java.time.format.DateTimeFormatter "RFC_1123_DATE_TIME"))

(def iso-date (goog.object/get java.time.format.DateTimeFormatter "ISO_DATE"))

(def iso-week-date
  (goog.object/get java.time.format.DateTimeFormatter "ISO_WEEK_DATE"))

(def iso-offset-time
  (goog.object/get java.time.format.DateTimeFormatter "ISO_OFFSET_TIME"))

(def iso-local-date
  (goog.object/get java.time.format.DateTimeFormatter "ISO_LOCAL_DATE"))

(def iso-zoned-date-time
  (goog.object/get java.time.format.DateTimeFormatter "ISO_ZONED_DATE_TIME"))

(def iso-offset-date-time
  (goog.object/get java.time.format.DateTimeFormatter "ISO_OFFSET_DATE_TIME"))

(def iso-date-time
  (goog.object/get java.time.format.DateTimeFormatter "ISO_DATE_TIME"))

(def basic-iso-date
  (goog.object/get java.time.format.DateTimeFormatter "BASIC_ISO_DATE"))

(defn of-pattern
  {:arglists (quote (["java.lang.String"]
                     ["java.lang.String" "java.util.Locale"]))}
  (^js/JSJoda.DateTimeFormatter [^java.lang.String pattern]
   (js-invoke java.time.format.DateTimeFormatter "ofPattern" pattern))
  (^js/JSJoda.DateTimeFormatter
   [^java.lang.String pattern ^java.util.Locale locale]
   (js-invoke java.time.format.DateTimeFormatter "ofPattern" pattern locale)))

(defn parse-best
  "Fully parses the text producing an object of one of the specified types.\n <p>\n This parse method is convenient for use when the parser can handle optional elements.\n For example, a pattern of 'uuuu-MM-dd HH.mm[ VV]' can be fully parsed to a {@code ZonedDateTime},\n or partially parsed to a {@code LocalDateTime}.\n The queries must be specified in order, starting from the best matching full-parse option\n and ending with the worst matching minimal parse option.\n The query is typically a method reference to a {@code from(TemporalAccessor)} method.\n <p>\n The result is associated with the first type that successfully parses.\n Normally, applications will use {@code instanceof} to check the result.\n For example:\n <pre>\n  TemporalAccessor dt = parser.parseBest(str, ZonedDateTime::from, LocalDateTime::from);\n  if (dt instanceof ZonedDateTime) {\n   ...\n  } else {\n   ...\n  }\n </pre>\n If the parse completes without reading the entire length of the text,\n or a problem occurs during parsing or merging, then an exception is thrown.\n\n @param text  the text to parse, not null\n @param queries  the queries defining the types to attempt to parse to,\n  must implement {@code TemporalAccessor}, not null\n @return the parsed date-time, not null\n @throws IllegalArgumentException if less than 2 types are specified\n @throws DateTimeParseException if unable to parse the requested result"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.lang.CharSequence"
                      "[Ljava.time.temporal.TemporalQuery;"]))}
  (^js/JSJoda.TemporalAccessor
   [^js/JSJoda.DateTimeFormatter this ^java.lang.CharSequence text
    ^"java.lang.Class" queries]
   (.parseBest this text queries)))

(defn format-to
  "Formats a date-time object to an {@code Appendable} using this formatter.\n <p>\n This outputs the formatted date-time to the specified destination.\n {@link Appendable} is a general purpose interface that is implemented by all\n key character output classes including {@code StringBuffer}, {@code StringBuilder},\n {@code PrintStream} and {@code Writer}.\n <p>\n Although {@code Appendable} methods throw an {@code IOException}, this method does not.\n Instead, any {@code IOException} is wrapped in a runtime exception.\n\n @param temporal  the temporal object to format, not null\n @param appendable  the appendable to format to, not null\n @throws DateTimeException if an error occurs during formatting"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.time.temporal.TemporalAccessor"
                      "java.lang.Appendable"]))}
  (^void
   [^js/JSJoda.DateTimeFormatter this ^js/JSJoda.TemporalAccessor temporal
    ^java.lang.Appendable appendable]
   (.formatTo this temporal appendable)))

(defn get-decimal-style
  "Gets the DecimalStyle to be used during formatting.\n\n @return the locale of this formatter, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"]))}
  (^js/JSJoda.DecimalStyle [^js/JSJoda.DateTimeFormatter this]
   (.decimalStyle this)))

(defn with-chronology
  "Returns a copy of this formatter with a new override chronology.\n <p>\n This returns a formatter with similar state to this formatter but\n with the override chronology set.\n By default, a formatter has no override chronology, returning null.\n <p>\n If an override is added, then any date that is formatted or parsed will be affected.\n <p>\n When formatting, if the temporal object contains a date, then it will\n be converted to a date in the override chronology.\n Whether the temporal contains a date is determined by querying the\n {@link ChronoField#EPOCH_DAY EPOCH_DAY} field.\n Any time or zone will be retained unaltered unless overridden.\n <p>\n If the temporal object does not contain a date, but does contain one\n or more {@code ChronoField} date fields, then a {@code DateTimeException}\n is thrown. In all other cases, the override chronology is added to the temporal,\n replacing any previous chronology, but without changing the date/time.\n <p>\n When parsing, there are two distinct cases to consider.\n If a chronology has been parsed directly from the text, perhaps because\n {@link DateTimeFormatterBuilder#appendChronologyId()} was used, then\n this override chronology has no effect.\n If no zone has been parsed, then this override chronology will be used\n to interpret the {@code ChronoField} values into a date according to the\n date resolving rules of the chronology.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param chrono  the new chronology, null if no override\n @return a formatter based on this formatter with the requested override chronology, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.time.chrono.Chronology"]))}
  (^js/JSJoda.DateTimeFormatter
   [^js/JSJoda.DateTimeFormatter this ^js/JSJoda.Chronology chrono]
   (.withChronology this chrono)))

(defn get-resolver-style
  "Gets the resolver style to use during parsing.\n <p>\n This returns the resolver style, used during the second phase of parsing\n when fields are resolved into dates and times.\n By default, a formatter has the {@link ResolverStyle#SMART SMART} resolver style.\n See {@link #withResolverStyle(ResolverStyle)} for more details.\n\n @return the resolver style of this formatter, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"]))}
  (^js/JSJoda.ResolverStyle [^js/JSJoda.DateTimeFormatter this]
   (.resolverStyle this)))

(defn with-decimal-style
  "Returns a copy of this formatter with a new DecimalStyle.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param decimalStyle  the new DecimalStyle, not null\n @return a formatter based on this formatter with the requested DecimalStyle, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.time.format.DecimalStyle"]))}
  (^js/JSJoda.DateTimeFormatter
   [^js/JSJoda.DateTimeFormatter this ^js/JSJoda.DecimalStyle decimal-style]
   (.withDecimalStyle this decimal-style)))

(defn get-locale
  "Gets the locale to be used during formatting.\n <p>\n This is used to lookup any part of the formatter needing specific\n localization, such as the text or localized pattern.\n\n @return the locale of this formatter, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"]))}
  (^java.util.Locale [^js/JSJoda.DateTimeFormatter this] (.locale this)))

(defn to-string
  "Returns a description of the underlying formatters.\n\n @return a description of this formatter, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"]))}
  (^java.lang.String [^js/JSJoda.DateTimeFormatter this] (.toString this)))

(defn parsed-leap-second
  "A query that provides access to whether a leap-second was parsed.\n <p>\n This returns a singleton {@linkplain TemporalQuery query} that provides\n access to additional information from the parse. The query always returns\n a non-null boolean, true if parsing saw a leap-second, false if not.\n <p>\n Instant parsing handles the special \"leap second\" time of '23:59:60'.\n Leap seconds occur at '23:59:60' in the UTC time-zone, but at other\n local times in different time-zones. To avoid this potential ambiguity,\n the handling of leap-seconds is limited to\n {@link DateTimeFormatterBuilder#appendInstant()}, as that method\n always parses the instant with the UTC zone offset.\n <p>\n If the time '23:59:60' is received, then a simple conversion is applied,\n replacing the second-of-minute of 60 with 59. This query can be used\n on the parse result to determine if the leap-second adjustment was made.\n The query will return {@code true} if it did adjust to remove the\n leap-second, and {@code false} if not. Note that applying a leap-second\n smoothing mechanism, such as UTC-SLS, is the responsibility of the\n application, as follows:\n <pre>\n  TemporalAccessor parsed = formatter.parse(str);\n  Instant instant = parsed.query(Instant::from);\n  if (parsed.query(DateTimeFormatter.parsedLeapSecond())) {\n    // validate leap-second is correct and apply correct smoothing\n  }\n </pre>\n @return a query that provides access to whether a leap-second was parsed"
  {:arglists (quote ([]))}
  (^js/JSJoda.TemporalQuery []
   (js-invoke java.time.format.DateTimeFormatter "parsedLeapSecond")))

(defn with-zone
  "Returns a copy of this formatter with a new override zone.\n <p>\n This returns a formatter with similar state to this formatter but\n with the override zone set.\n By default, a formatter has no override zone, returning null.\n <p>\n If an override is added, then any instant that is formatted or parsed will be affected.\n <p>\n When formatting, if the temporal object contains an instant, then it will\n be converted to a zoned date-time using the override zone.\n Whether the temporal is an instant is determined by querying the\n {@link ChronoField#INSTANT_SECONDS INSTANT_SECONDS} field.\n If the input has a chronology then it will be retained unless overridden.\n If the input does not have a chronology, such as {@code Instant}, then\n the ISO chronology will be used.\n <p>\n If the temporal object does not contain an instant, but does contain\n an offset then an additional check is made. If the normalized override\n zone is an offset that differs from the offset of the temporal, then\n a {@code DateTimeException} is thrown. In all other cases, the override\n zone is added to the temporal, replacing any previous zone, but without\n changing the date/time.\n <p>\n When parsing, there are two distinct cases to consider.\n If a zone has been parsed directly from the text, perhaps because\n {@link DateTimeFormatterBuilder#appendZoneId()} was used, then\n this override zone has no effect.\n If no zone has been parsed, then this override zone will be included in\n the result of the parse where it can be used to build instants and date-times.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param zone  the new override zone, null if no override\n @return a formatter based on this formatter with the requested override zone, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.time.ZoneId"]))}
  (^js/JSJoda.DateTimeFormatter
   [^js/JSJoda.DateTimeFormatter this ^js/JSJoda.ZoneId zone]
   (.withZone this zone)))

(defn parsed-excess-days
  "A query that provides access to the excess days that were parsed.\n <p>\n This returns a singleton {@linkplain TemporalQuery query} that provides\n access to additional information from the parse. The query always returns\n a non-null period, with a zero period returned instead of null.\n <p>\n There are two situations where this query may return a non-zero period.\n <ul>\n <li>If the {@code ResolverStyle} is {@code LENIENT} and a time is parsed\n  without a date, then the complete result of the parse consists of a\n  {@code LocalTime} and an excess {@code Period} in days.\n\n <li>If the {@code ResolverStyle} is {@code SMART} and a time is parsed\n  without a date where the time is 24:00:00, then the complete result of\n  the parse consists of a {@code LocalTime} of 00:00:00 and an excess\n  {@code Period} of one day.\n </ul>\n <p>\n In both cases, if a complete {@code ChronoLocalDateTime} or {@code Instant}\n is parsed, then the excess days are added to the date part.\n As a result, this query will return a zero period.\n <p>\n The {@code SMART} behaviour handles the common \"end of day\" 24:00 value.\n Processing in {@code LENIENT} mode also produces the same result:\n <pre>\n  Text to parse        Parsed object                         Excess days\n  \"2012-12-03T00:00\"   LocalDateTime.of(2012, 12, 3, 0, 0)   ZERO\n  \"2012-12-03T24:00\"   LocalDateTime.of(2012, 12, 4, 0, 0)   ZERO\n  \"00:00\"              LocalTime.of(0, 0)                    ZERO\n  \"24:00\"              LocalTime.of(0, 0)                    Period.ofDays(1)\n </pre>\n The query can be used as follows:\n <pre>\n  TemporalAccessor parsed = formatter.parse(str);\n  LocalTime time = parsed.query(LocalTime::from);\n  Period extraDays = parsed.query(DateTimeFormatter.parsedExcessDays());\n </pre>\n @return a query that provides access to the excess days that were parsed"
  {:arglists (quote ([]))}
  (^js/JSJoda.TemporalQuery []
   (js-invoke java.time.format.DateTimeFormatter "parsedExcessDays")))

(defn get-zone
  "Gets the overriding zone to be used during formatting.\n <p>\n This returns the override zone, used to convert instants.\n By default, a formatter has no override zone, returning null.\n See {@link #withZone(ZoneId)} for more details on overriding.\n\n @return the override zone of this formatter, null if no override"
  {:arglists (quote (["java.time.format.DateTimeFormatter"]))}
  (^js/JSJoda.ZoneId [^js/JSJoda.DateTimeFormatter this] (.zone this)))

(defn of-localized-date-time
  {:arglists (quote (["java.time.format.FormatStyle"]
                     ["java.time.format.FormatStyle"
                      "java.time.format.FormatStyle"]))}
  (^js/JSJoda.DateTimeFormatter [^js/JSJoda.FormatStyle date-time-style]
   (js-invoke java.time.format.DateTimeFormatter
              "ofLocalizedDateTime"
              date-time-style))
  (^js/JSJoda.DateTimeFormatter
   [^js/JSJoda.FormatStyle date-style ^js/JSJoda.FormatStyle time-style]
   (js-invoke java.time.format.DateTimeFormatter
              "ofLocalizedDateTime"
              date-style
              time-style)))

(defn get-resolver-fields
  "Gets the resolver fields to use during parsing.\n <p>\n This returns the resolver fields, used during the second phase of parsing\n when fields are resolved into dates and times.\n By default, a formatter has no resolver fields, and thus returns null.\n See {@link #withResolverFields(Set)} for more details.\n\n @return the immutable set of resolver fields of this formatter, null if no fields"
  {:arglists (quote (["java.time.format.DateTimeFormatter"]))}
  (^java.util.Set [^js/JSJoda.DateTimeFormatter this] (.resolverFields this)))

(defn get-chronology
  "Gets the overriding chronology to be used during formatting.\n <p>\n This returns the override chronology, used to convert dates.\n By default, a formatter has no override chronology, returning null.\n See {@link #withChronology(Chronology)} for more details on overriding.\n\n @return the override chronology of this formatter, null if no override"
  {:arglists (quote (["java.time.format.DateTimeFormatter"]))}
  (^js/JSJoda.Chronology [^js/JSJoda.DateTimeFormatter this]
   (.chronology this)))

(defn parse
  {:arglists (quote
               (["java.time.format.DateTimeFormatter" "java.lang.CharSequence"]
                ["java.time.format.DateTimeFormatter" "java.lang.CharSequence"
                 "java.text.ParsePosition"]
                ["java.time.format.DateTimeFormatter" "java.lang.CharSequence"
                 "java.time.temporal.TemporalQuery"]))}
  (^js/JSJoda.TemporalAccessor
   [^js/JSJoda.DateTimeFormatter this ^java.lang.CharSequence text]
   (.parse this text))
  (^java.lang.Object [this arg0 arg1]
   (.parse ^js/JSJoda.DateTimeFormatter this arg0 arg1)))

(defn with-locale
  "Returns a copy of this formatter with a new locale.\n <p>\n This is used to lookup any part of the formatter needing specific\n localization, such as the text or localized pattern.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param locale  the new locale, not null\n @return a formatter based on this formatter with the requested locale, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.util.Locale"]))}
  (^js/JSJoda.DateTimeFormatter
   [^js/JSJoda.DateTimeFormatter this ^java.util.Locale locale]
   (.withLocale this locale)))

(defn with-resolver-fields
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "[Ljava.time.temporal.TemporalField;"]
                     ["java.time.format.DateTimeFormatter" "java.util.Set"]))}
  (^js/JSJoda.DateTimeFormatter [this arg0]
   (.withResolverFields ^js/JSJoda.DateTimeFormatter this arg0)))

(defn parse-unresolved
  "Parses the text using this formatter, without resolving the result, intended\n for advanced use cases.\n <p>\n Parsing is implemented as a two-phase operation.\n First, the text is parsed using the layout defined by the formatter, producing\n a {@code Map} of field to value, a {@code ZoneId} and a {@code Chronology}.\n Second, the parsed data is <em>resolved</em>, by validating, combining and\n simplifying the various fields into more useful ones.\n This method performs the parsing stage but not the resolving stage.\n <p>\n The result of this method is {@code TemporalAccessor} which represents the\n data as seen in the input. Values are not validated, thus parsing a date string\n of '2012-00-65' would result in a temporal with three fields - year of '2012',\n month of '0' and day-of-month of '65'.\n <p>\n The text will be parsed from the specified start {@code ParsePosition}.\n The entire length of the text does not have to be parsed, the {@code ParsePosition}\n will be updated with the index at the end of parsing.\n <p>\n Errors are returned using the error index field of the {@code ParsePosition}\n instead of {@code DateTimeParseException}.\n The returned error index will be set to an index indicative of the error.\n Callers must check for errors before using the result.\n <p>\n If the formatter parses the same field more than once with different values,\n the result will be an error.\n <p>\n This method is intended for advanced use cases that need access to the\n internal state during parsing. Typical application code should use\n {@link #parse(CharSequence, TemporalQuery)} or the parse method on the target type.\n\n @param text  the text to parse, not null\n @param position  the position to parse from, updated with length parsed\n  and the index of any error, not null\n @return the parsed text, null if the parse results in an error\n @throws DateTimeException if some problem occurs during parsing\n @throws IndexOutOfBoundsException if the position is invalid"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.lang.CharSequence" "java.text.ParsePosition"]))}
  (^js/JSJoda.TemporalAccessor
   [^js/JSJoda.DateTimeFormatter this ^java.lang.CharSequence text
    ^java.text.ParsePosition position]
   (.parseUnresolved this text position)))

(defn of-localized-time
  "Returns a locale specific time format for the ISO chronology.\n <p>\n This returns a formatter that will format or parse a time.\n The exact format pattern used varies by locale.\n <p>\n The locale is determined from the formatter. The formatter returned directly by\n this method will use the {@link Locale#getDefault(Locale.Category) default FORMAT locale}.\n The locale can be controlled using {@link DateTimeFormatter#withLocale(Locale) withLocale(Locale)}\n on the result of this method.\n <p>\n Note that the localized pattern is looked up lazily.\n This {@code DateTimeFormatter} holds the style required and the locale,\n looking up the pattern required on demand.\n <p>\n The returned formatter has a chronology of ISO set to ensure dates in\n other calendar systems are correctly converted.\n It has no override zone and uses the {@link ResolverStyle#SMART SMART} resolver style.\n\n @param timeStyle  the formatter style to obtain, not null\n @return the time formatter, not null"
  {:arglists (quote (["java.time.format.FormatStyle"]))}
  (^js/JSJoda.DateTimeFormatter [^js/JSJoda.FormatStyle time-style]
   (js-invoke java.time.format.DateTimeFormatter "ofLocalizedTime" time-style)))

(defn of-localized-date
  "Returns a locale specific date format for the ISO chronology.\n <p>\n This returns a formatter that will format or parse a date.\n The exact format pattern used varies by locale.\n <p>\n The locale is determined from the formatter. The formatter returned directly by\n this method will use the {@link Locale#getDefault(Locale.Category) default FORMAT locale}.\n The locale can be controlled using {@link DateTimeFormatter#withLocale(Locale) withLocale(Locale)}\n on the result of this method.\n <p>\n Note that the localized pattern is looked up lazily.\n This {@code DateTimeFormatter} holds the style required and the locale,\n looking up the pattern required on demand.\n <p>\n The returned formatter has a chronology of ISO set to ensure dates in\n other calendar systems are correctly converted.\n It has no override zone and uses the {@link ResolverStyle#SMART SMART} resolver style.\n\n @param dateStyle  the formatter style to obtain, not null\n @return the date formatter, not null"
  {:arglists (quote (["java.time.format.FormatStyle"]))}
  (^js/JSJoda.DateTimeFormatter [^js/JSJoda.FormatStyle date-style]
   (js-invoke java.time.format.DateTimeFormatter "ofLocalizedDate" date-style)))

(defn format
  "Formats a date-time object using this formatter.\n <p>\n This formats the date-time to a String using the rules of the formatter.\n\n @param temporal  the temporal object to format, not null\n @return the formatted string, not null\n @throws DateTimeException if an error occurs during formatting"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.time.temporal.TemporalAccessor"]))}
  (^java.lang.String
   [^js/JSJoda.DateTimeFormatter this ^js/JSJoda.TemporalAccessor temporal]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-cljs
     (.format this temporal))))

(defn to-format
  {:arglists (quote (["java.time.format.DateTimeFormatter"]
                     ["java.time.format.DateTimeFormatter"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.text.Format [^js/JSJoda.DateTimeFormatter this] (.toFormat this))
  (^java.text.Format
   [^js/JSJoda.DateTimeFormatter this ^js/JSJoda.TemporalQuery parse-query]
   (.toFormat this parse-query)))

(defn with-resolver-style
  "Returns a copy of this formatter with a new resolver style.\n <p>\n This returns a formatter with similar state to this formatter but\n with the resolver style set. By default, a formatter has the\n {@link ResolverStyle#SMART SMART} resolver style.\n <p>\n Changing the resolver style only has an effect during parsing.\n Parsing a text string occurs in two phases.\n Phase 1 is a basic text parse according to the fields added to the builder.\n Phase 2 resolves the parsed field-value pairs into date and/or time objects.\n The resolver style is used to control how phase 2, resolving, happens.\n See {@code ResolverStyle} for more information on the options available.\n <p>\n This instance is immutable and unaffected by this method call.\n\n @param resolverStyle  the new resolver style, not null\n @return a formatter based on this formatter with the requested resolver style, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.time.format.ResolverStyle"]))}
  (^js/JSJoda.DateTimeFormatter
   [^js/JSJoda.DateTimeFormatter this ^js/JSJoda.ResolverStyle resolver-style]
   (.withResolverStyle this resolver-style)))
