(ns cljc.java-time.format.date-time-formatter
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time.format DateTimeFormatter]))

(def iso-local-time java.time.format.DateTimeFormatter/ISO_LOCAL_TIME)

(def iso-ordinal-date java.time.format.DateTimeFormatter/ISO_ORDINAL_DATE)

(def iso-offset-date java.time.format.DateTimeFormatter/ISO_OFFSET_DATE)

(def iso-time java.time.format.DateTimeFormatter/ISO_TIME)

(def iso-local-date-time java.time.format.DateTimeFormatter/ISO_LOCAL_DATE_TIME)

(def iso-instant java.time.format.DateTimeFormatter/ISO_INSTANT)

(def rfc-1123-date-time java.time.format.DateTimeFormatter/RFC_1123_DATE_TIME)

(def iso-date java.time.format.DateTimeFormatter/ISO_DATE)

(def iso-week-date java.time.format.DateTimeFormatter/ISO_WEEK_DATE)

(def iso-offset-time java.time.format.DateTimeFormatter/ISO_OFFSET_TIME)

(def iso-local-date java.time.format.DateTimeFormatter/ISO_LOCAL_DATE)

(def iso-zoned-date-time java.time.format.DateTimeFormatter/ISO_ZONED_DATE_TIME)

(def iso-offset-date-time
  java.time.format.DateTimeFormatter/ISO_OFFSET_DATE_TIME)

(def iso-date-time java.time.format.DateTimeFormatter/ISO_DATE_TIME)

(def basic-iso-date java.time.format.DateTimeFormatter/BASIC_ISO_DATE)

(defn of-pattern
  {:arglists (quote (["java.lang.String"]
                     ["java.lang.String" "java.util.Locale"]))}
  (^java.time.format.DateTimeFormatter [^java.lang.String pattern]
   (java.time.format.DateTimeFormatter/ofPattern pattern))
  (^java.time.format.DateTimeFormatter
   [^java.lang.String pattern ^java.util.Locale locale]
   (java.time.format.DateTimeFormatter/ofPattern pattern locale)))

(defn parse-best
  "Fully parses the text producing an object of one of the specified types.

 This parse method is convenient for use when the parser can handle optional elements.
 For example, a pattern of 'uuuu-MM-dd HH.mm[ VV]' can be fully parsed to a {@code ZonedDateTime},
 or partially parsed to a {@code LocalDateTime}.
 The queries must be specified in order, starting from the best matching full-parse option
 and ending with the worst matching minimal parse option.
 The query is typically a method reference to a {@code from(TemporalAccessor)} method.

 The result is associated with the first type that successfully parses.
 Normally, applications will use {@code instanceof} to check the result.
 For example:
 <pre>
  TemporalAccessor dt = parser.parseBest(str, ZonedDateTime::from, LocalDateTime::from);
  if (dt instanceof ZonedDateTime) {
   ...
  } else {
   ...
  }
 </pre>
 If the parse completes without reading the entire length of the text,
 or a problem occurs during parsing or merging, then an exception is thrown.

 @param text  the text to parse, not null
 @param queries  the queries defining the types to attempt to parse to,
  must implement {@code TemporalAccessor}, not null
 @return the parsed date-time, not null
 @throws IllegalArgumentException if less than 2 types are specified
 @throws DateTimeParseException if unable to parse the requested result"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.lang.CharSequence"
                      "[Ljava.time.temporal.TemporalQuery;"]))}
  (^java.time.temporal.TemporalAccessor
   [^java.time.format.DateTimeFormatter this ^java.lang.CharSequence text
    ^"java.lang.Class" queries]
   (.parseBest this text queries)))

(defn format-to
  "Formats a date-time object to an {@code Appendable} using this formatter.

 This outputs the formatted date-time to the specified destination.
 {@link Appendable} is a general purpose interface that is implemented by all
 key character output classes including {@code StringBuffer}, {@code StringBuilder},
 {@code PrintStream} and {@code Writer}.

 Although {@code Appendable} methods throw an {@code IOException}, this method does not.
 Instead, any {@code IOException} is wrapped in a runtime exception.

 @param temporal  the temporal object to format, not null
 @param appendable  the appendable to format to, not null
 @throws DateTimeException if an error occurs during formatting"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.time.temporal.TemporalAccessor"
                      "java.lang.Appendable"]))}
  (^java.lang.Object
   [^java.time.format.DateTimeFormatter this
    ^java.time.temporal.TemporalAccessor temporal
    ^java.lang.Appendable appendable]
   (.formatTo this temporal appendable)))

(defn get-decimal-style
  "Gets the DecimalStyle to be used during formatting.

 @return the locale of this formatter, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"]))}
  (^java.time.format.DecimalStyle [^java.time.format.DateTimeFormatter this]
   (.getDecimalStyle this)))

(defn with-chronology
  "Returns a copy of this formatter with a new override chronology.

 This returns a formatter with similar state to this formatter but
 with the override chronology set.
 By default, a formatter has no override chronology, returning null.

 If an override is added, then any date that is formatted or parsed will be affected.

 When formatting, if the temporal object contains a date, then it will
 be converted to a date in the override chronology.
 Whether the temporal contains a date is determined by querying the
 {@link ChronoField#EPOCH_DAY EPOCH_DAY} field.
 Any time or zone will be retained unaltered unless overridden.

 If the temporal object does not contain a date, but does contain one
 or more {@code ChronoField} date fields, then a {@code DateTimeException}
 is thrown. In all other cases, the override chronology is added to the temporal,
 replacing any previous chronology, but without changing the date/time.

 When parsing, there are two distinct cases to consider.
 If a chronology has been parsed directly from the text, perhaps because
 {@link DateTimeFormatterBuilder#appendChronologyId()} was used, then
 this override chronology has no effect.
 If no zone has been parsed, then this override chronology will be used
 to interpret the {@code ChronoField} values into a date according to the
 date resolving rules of the chronology.

 This instance is immutable and unaffected by this method call.

 @param chrono  the new chronology, null if no override
 @return a formatter based on this formatter with the requested override chronology, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.time.chrono.Chronology"]))}
  (^java.time.format.DateTimeFormatter
   [^java.time.format.DateTimeFormatter this
    ^java.time.chrono.Chronology chrono]
   (.withChronology this chrono)))

(defn get-resolver-style
  "Gets the resolver style to use during parsing.

 This returns the resolver style, used during the second phase of parsing
 when fields are resolved into dates and times.
 By default, a formatter has the {@link ResolverStyle#SMART SMART} resolver style.
 See {@link #withResolverStyle(ResolverStyle)} for more details.

 @return the resolver style of this formatter, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"]))}
  (^java.time.format.ResolverStyle [^java.time.format.DateTimeFormatter this]
   (.getResolverStyle this)))

(defn with-decimal-style
  "Returns a copy of this formatter with a new DecimalStyle.

 This instance is immutable and unaffected by this method call.

 @param decimalStyle  the new DecimalStyle, not null
 @return a formatter based on this formatter with the requested DecimalStyle, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.time.format.DecimalStyle"]))}
  (^java.time.format.DateTimeFormatter
   [^java.time.format.DateTimeFormatter this
    ^java.time.format.DecimalStyle decimal-style]
   (.withDecimalStyle this decimal-style)))

(defn get-locale
  "Gets the locale to be used during formatting.

 This is used to lookup any part of the formatter needing specific
 localization, such as the text or localized pattern.

 @return the locale of this formatter, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"]))}
  (^java.util.Locale [^java.time.format.DateTimeFormatter this]
   (.getLocale this)))

(defn to-string
  "Returns a description of the underlying formatters.

 @return a description of this formatter, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"]))}
  (^java.lang.String [^java.time.format.DateTimeFormatter this]
   (.toString this)))

(defn parsed-leap-second
  "A query that provides access to whether a leap-second was parsed.

 This returns a singleton {@linkplain TemporalQuery query} that provides
 access to additional information from the parse. The query always returns
 a non-null boolean, true if parsing saw a leap-second, false if not.

 Instant parsing handles the special \"leap second\" time of '23:59:60'.
 Leap seconds occur at '23:59:60' in the UTC time-zone, but at other
 local times in different time-zones. To avoid this potential ambiguity,
 the handling of leap-seconds is limited to
 {@link DateTimeFormatterBuilder#appendInstant()}, as that method
 always parses the instant with the UTC zone offset.

 If the time '23:59:60' is received, then a simple conversion is applied,
 replacing the second-of-minute of 60 with 59. This query can be used
 on the parse result to determine if the leap-second adjustment was made.
 The query will return {@code true} if it did adjust to remove the
 leap-second, and {@code false} if not. Note that applying a leap-second
 smoothing mechanism, such as UTC-SLS, is the responsibility of the
 application, as follows:
 <pre>
  TemporalAccessor parsed = formatter.parse(str);
  Instant instant = parsed.query(Instant::from);
  if (parsed.query(DateTimeFormatter.parsedLeapSecond())) {
    // validate leap-second is correct and apply correct smoothing
  }
 </pre>
 @return a query that provides access to whether a leap-second was parsed"
  {:arglists (quote ([]))}
  (^java.time.temporal.TemporalQuery []
   (java.time.format.DateTimeFormatter/parsedLeapSecond)))

(defn with-zone
  "Returns a copy of this formatter with a new override zone.

 This returns a formatter with similar state to this formatter but
 with the override zone set.
 By default, a formatter has no override zone, returning null.

 If an override is added, then any instant that is formatted or parsed will be affected.

 When formatting, if the temporal object contains an instant, then it will
 be converted to a zoned date-time using the override zone.
 Whether the temporal is an instant is determined by querying the
 {@link ChronoField#INSTANT_SECONDS INSTANT_SECONDS} field.
 If the input has a chronology then it will be retained unless overridden.
 If the input does not have a chronology, such as {@code Instant}, then
 the ISO chronology will be used.

 If the temporal object does not contain an instant, but does contain
 an offset then an additional check is made. If the normalized override
 zone is an offset that differs from the offset of the temporal, then
 a {@code DateTimeException} is thrown. In all other cases, the override
 zone is added to the temporal, replacing any previous zone, but without
 changing the date/time.

 When parsing, there are two distinct cases to consider.
 If a zone has been parsed directly from the text, perhaps because
 {@link DateTimeFormatterBuilder#appendZoneId()} was used, then
 this override zone has no effect.
 If no zone has been parsed, then this override zone will be included in
 the result of the parse where it can be used to build instants and date-times.

 This instance is immutable and unaffected by this method call.

 @param zone  the new override zone, null if no override
 @return a formatter based on this formatter with the requested override zone, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.time.ZoneId"]))}
  (^java.time.format.DateTimeFormatter
   [^java.time.format.DateTimeFormatter this ^java.time.ZoneId zone]
   (.withZone this zone)))

(defn parsed-excess-days
  "A query that provides access to the excess days that were parsed.

 This returns a singleton {@linkplain TemporalQuery query} that provides
 access to additional information from the parse. The query always returns
 a non-null period, with a zero period returned instead of null.

 There are two situations where this query may return a non-zero period.
 <ul>
 <li>If the {@code ResolverStyle} is {@code LENIENT} and a time is parsed
  without a date, then the complete result of the parse consists of a
  {@code LocalTime} and an excess {@code Period} in days.

 <li>If the {@code ResolverStyle} is {@code SMART} and a time is parsed
  without a date where the time is 24:00:00, then the complete result of
  the parse consists of a {@code LocalTime} of 00:00:00 and an excess
  {@code Period} of one day.
 </ul>

 In both cases, if a complete {@code ChronoLocalDateTime} or {@code Instant}
 is parsed, then the excess days are added to the date part.
 As a result, this query will return a zero period.

 The {@code SMART} behaviour handles the common \"end of day\" 24:00 value.
 Processing in {@code LENIENT} mode also produces the same result:
 <pre>
  Text to parse        Parsed object                         Excess days
  \"2012-12-03T00:00\"   LocalDateTime.of(2012, 12, 3, 0, 0)   ZERO
  \"2012-12-03T24:00\"   LocalDateTime.of(2012, 12, 4, 0, 0)   ZERO
  \"00:00\"              LocalTime.of(0, 0)                    ZERO
  \"24:00\"              LocalTime.of(0, 0)                    Period.ofDays(1)
 </pre>
 The query can be used as follows:
 <pre>
  TemporalAccessor parsed = formatter.parse(str);
  LocalTime time = parsed.query(LocalTime::from);
  Period extraDays = parsed.query(DateTimeFormatter.parsedExcessDays());
 </pre>
 @return a query that provides access to the excess days that were parsed"
  {:arglists (quote ([]))}
  (^java.time.temporal.TemporalQuery []
   (java.time.format.DateTimeFormatter/parsedExcessDays)))

(defn get-zone
  "Gets the overriding zone to be used during formatting.

 This returns the override zone, used to convert instants.
 By default, a formatter has no override zone, returning null.
 See {@link #withZone(ZoneId)} for more details on overriding.

 @return the override zone of this formatter, null if no override"
  {:arglists (quote (["java.time.format.DateTimeFormatter"]))}
  (^java.time.ZoneId [^java.time.format.DateTimeFormatter this]
   (.getZone this)))

(defn of-localized-date-time
  {:arglists (quote (["java.time.format.FormatStyle"]
                     ["java.time.format.FormatStyle"
                      "java.time.format.FormatStyle"]))}
  (^java.time.format.DateTimeFormatter
   [^java.time.format.FormatStyle date-time-style]
   (java.time.format.DateTimeFormatter/ofLocalizedDateTime date-time-style))
  (^java.time.format.DateTimeFormatter
   [^java.time.format.FormatStyle date-style
    ^java.time.format.FormatStyle time-style]
   (java.time.format.DateTimeFormatter/ofLocalizedDateTime date-style
                                                           time-style)))

(defn get-resolver-fields
  "Gets the resolver fields to use during parsing.

 This returns the resolver fields, used during the second phase of parsing
 when fields are resolved into dates and times.
 By default, a formatter has no resolver fields, and thus returns null.
 See {@link #withResolverFields(Set)} for more details.

 @return the immutable set of resolver fields of this formatter, null if no fields"
  {:arglists (quote (["java.time.format.DateTimeFormatter"]))}
  (^java.util.Set [^java.time.format.DateTimeFormatter this]
   (.getResolverFields this)))

(defn get-chronology
  "Gets the overriding chronology to be used during formatting.

 This returns the override chronology, used to convert dates.
 By default, a formatter has no override chronology, returning null.
 See {@link #withChronology(Chronology)} for more details on overriding.

 @return the override chronology of this formatter, null if no override"
  {:arglists (quote (["java.time.format.DateTimeFormatter"]))}
  (^java.time.chrono.Chronology [^java.time.format.DateTimeFormatter this]
   (.getChronology this)))

(defn parse
  {:arglists (quote
               (["java.time.format.DateTimeFormatter" "java.lang.CharSequence"]
                ["java.time.format.DateTimeFormatter" "java.lang.CharSequence"
                 "java.text.ParsePosition"]
                ["java.time.format.DateTimeFormatter" "java.lang.CharSequence"
                 "java.time.temporal.TemporalQuery"]))}
  (^java.time.temporal.TemporalAccessor
   [^java.time.format.DateTimeFormatter this ^java.lang.CharSequence text]
   (.parse this text))
  (^java.lang.Object [^java.time.format.DateTimeFormatter this arg0 arg1]
   (cond (and (instance? java.lang.CharSequence arg0)
              (instance? java.text.ParsePosition arg1))
           (let [text ^"java.lang.CharSequence" arg0
                 position ^"java.text.ParsePosition" arg1]
             (.parse this text position))
         (and (instance? java.lang.CharSequence arg0)
              (instance? java.time.temporal.TemporalQuery arg1))
           (let [text ^"java.lang.CharSequence" arg0
                 query ^"java.time.temporal.TemporalQuery" arg1]
             (.parse this text query))
         :else (throw (java.lang.IllegalArgumentException.
                        "no corresponding java.time method with these args")))))

(defn with-locale
  "Returns a copy of this formatter with a new locale.

 This is used to lookup any part of the formatter needing specific
 localization, such as the text or localized pattern.

 This instance is immutable and unaffected by this method call.

 @param locale  the new locale, not null
 @return a formatter based on this formatter with the requested locale, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.util.Locale"]))}
  (^java.time.format.DateTimeFormatter
   [^java.time.format.DateTimeFormatter this ^java.util.Locale locale]
   (.withLocale this locale)))

(defn with-resolver-fields
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "[Ljava.time.temporal.TemporalField;"]
                     ["java.time.format.DateTimeFormatter" "java.util.Set"]))}
  (^java.time.format.DateTimeFormatter
   [^java.time.format.DateTimeFormatter this arg0]
   (cond (= java.time.temporal.TemporalField (.getComponentType (class arg0)))
           (let [resolver-fields ^"[Ljava.time.temporal.TemporalField;" arg0]
             (.withResolverFields this resolver-fields))
         (instance? java.util.Set arg0)
           (let [resolver-fields ^"java.util.Set" arg0]
             (.withResolverFields this resolver-fields))
         :else (throw (java.lang.IllegalArgumentException.
                        "no corresponding java.time method with these args")))))

(defn parse-unresolved
  "Parses the text using this formatter, without resolving the result, intended
 for advanced use cases.

 Parsing is implemented as a two-phase operation.
 First, the text is parsed using the layout defined by the formatter, producing
 a {@code Map} of field to value, a {@code ZoneId} and a {@code Chronology}.
 Second, the parsed data is <em>resolved</em>, by validating, combining and
 simplifying the various fields into more useful ones.
 This method performs the parsing stage but not the resolving stage.

 The result of this method is {@code TemporalAccessor} which represents the
 data as seen in the input. Values are not validated, thus parsing a date string
 of '2012-00-65' would result in a temporal with three fields - year of '2012',
 month of '0' and day-of-month of '65'.

 The text will be parsed from the specified start {@code ParsePosition}.
 The entire length of the text does not have to be parsed, the {@code ParsePosition}
 will be updated with the index at the end of parsing.

 Errors are returned using the error index field of the {@code ParsePosition}
 instead of {@code DateTimeParseException}.
 The returned error index will be set to an index indicative of the error.
 Callers must check for errors before using the result.

 If the formatter parses the same field more than once with different values,
 the result will be an error.

 This method is intended for advanced use cases that need access to the
 internal state during parsing. Typical application code should use
 {@link #parse(CharSequence, TemporalQuery)} or the parse method on the target type.

 @param text  the text to parse, not null
 @param position  the position to parse from, updated with length parsed
  and the index of any error, not null
 @return the parsed text, null if the parse results in an error
 @throws DateTimeException if some problem occurs during parsing
 @throws IndexOutOfBoundsException if the position is invalid"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.lang.CharSequence" "java.text.ParsePosition"]))}
  (^java.time.temporal.TemporalAccessor
   [^java.time.format.DateTimeFormatter this ^java.lang.CharSequence text
    ^java.text.ParsePosition position]
   (.parseUnresolved this text position)))

(defn of-localized-time
  "Returns a locale specific time format for the ISO chronology.

 This returns a formatter that will format or parse a time.
 The exact format pattern used varies by locale.

 The locale is determined from the formatter. The formatter returned directly by
 this method will use the {@link Locale#getDefault(Locale.Category) default FORMAT locale}.
 The locale can be controlled using {@link DateTimeFormatter#withLocale(Locale) withLocale(Locale)}
 on the result of this method.

 Note that the localized pattern is looked up lazily.
 This {@code DateTimeFormatter} holds the style required and the locale,
 looking up the pattern required on demand.

 The returned formatter has a chronology of ISO set to ensure dates in
 other calendar systems are correctly converted.
 It has no override zone and uses the {@link ResolverStyle#SMART SMART} resolver style.

 @param timeStyle  the formatter style to obtain, not null
 @return the time formatter, not null"
  {:arglists (quote (["java.time.format.FormatStyle"]))}
  (^java.time.format.DateTimeFormatter
   [^java.time.format.FormatStyle time-style]
   (java.time.format.DateTimeFormatter/ofLocalizedTime time-style)))

(defn of-localized-date
  "Returns a locale specific date format for the ISO chronology.

 This returns a formatter that will format or parse a date.
 The exact format pattern used varies by locale.

 The locale is determined from the formatter. The formatter returned directly by
 this method will use the {@link Locale#getDefault(Locale.Category) default FORMAT locale}.
 The locale can be controlled using {@link DateTimeFormatter#withLocale(Locale) withLocale(Locale)}
 on the result of this method.

 Note that the localized pattern is looked up lazily.
 This {@code DateTimeFormatter} holds the style required and the locale,
 looking up the pattern required on demand.

 The returned formatter has a chronology of ISO set to ensure dates in
 other calendar systems are correctly converted.
 It has no override zone and uses the {@link ResolverStyle#SMART SMART} resolver style.

 @param dateStyle  the formatter style to obtain, not null
 @return the date formatter, not null"
  {:arglists (quote (["java.time.format.FormatStyle"]))}
  (^java.time.format.DateTimeFormatter
   [^java.time.format.FormatStyle date-style]
   (java.time.format.DateTimeFormatter/ofLocalizedDate date-style)))

(defn format
  "Formats a date-time object using this formatter.

 This formats the date-time to a String using the rules of the formatter.

 @param temporal  the temporal object to format, not null
 @return the formatted string, not null
 @throws DateTimeException if an error occurs during formatting"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.time.temporal.TemporalAccessor"]))}
  (^java.lang.String
   [^java.time.format.DateTimeFormatter this
    ^java.time.temporal.TemporalAccessor temporal]
   (cljc.java-time.extn.calendar-awareness/calendar-aware-clj
     (.format this temporal))))

(defn to-format
  {:arglists (quote (["java.time.format.DateTimeFormatter"]
                     ["java.time.format.DateTimeFormatter"
                      "java.time.temporal.TemporalQuery"]))}
  (^java.text.Format [^java.time.format.DateTimeFormatter this]
   (.toFormat this))
  (^java.text.Format
   [^java.time.format.DateTimeFormatter this
    ^java.time.temporal.TemporalQuery parse-query]
   (.toFormat this parse-query)))

(defn with-resolver-style
  "Returns a copy of this formatter with a new resolver style.

 This returns a formatter with similar state to this formatter but
 with the resolver style set. By default, a formatter has the
 {@link ResolverStyle#SMART SMART} resolver style.

 Changing the resolver style only has an effect during parsing.
 Parsing a text string occurs in two phases.
 Phase 1 is a basic text parse according to the fields added to the builder.
 Phase 2 resolves the parsed field-value pairs into date and/or time objects.
 The resolver style is used to control how phase 2, resolving, happens.
 See {@code ResolverStyle} for more information on the options available.

 This instance is immutable and unaffected by this method call.

 @param resolverStyle  the new resolver style, not null
 @return a formatter based on this formatter with the requested resolver style, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatter"
                      "java.time.format.ResolverStyle"]))}
  (^java.time.format.DateTimeFormatter
   [^java.time.format.DateTimeFormatter this
    ^java.time.format.ResolverStyle resolver-style]
   (.withResolverStyle this resolver-style)))
