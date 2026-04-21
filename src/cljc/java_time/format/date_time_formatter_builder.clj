(ns cljc.java-time.format.date-time-formatter-builder
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time.format DateTimeFormatterBuilder]))

(defn new
  {:arglists (quote ([]))}
  (^java.time.format.DateTimeFormatterBuilder []
   (java.time.format.DateTimeFormatterBuilder.)))

(defn to-formatter
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]
                     ["java.time.format.DateTimeFormatterBuilder"
                      "java.util.Locale"]))}
  (^java.time.format.DateTimeFormatter
   [^java.time.format.DateTimeFormatterBuilder this]
   (.toFormatter this))
  (^java.time.format.DateTimeFormatter
   [^java.time.format.DateTimeFormatterBuilder this ^java.util.Locale locale]
   (.toFormatter this locale)))

(defn append-pattern
  "Appends the elements defined by the specified pattern to the builder.

 All letters 'A' to 'Z' and 'a' to 'z' are reserved as pattern letters.
 The characters '#', '{' and '}' are reserved for future use.
 The characters '[' and ']' indicate optional patterns.
 The following pattern letters are defined:
 <pre>
  Symbol  Meaning                     Presentation      Examples
  ------  -------                     ------------      -------
   G       era                         text              AD; Anno Domini; A
   u       year                        year              2004; 04
   y       year-of-era                 year              2004; 04
   D       day-of-year                 number            189
   M/L     month-of-year               number/text       7; 07; Jul; July; J
   d       day-of-month                number            10

   Q/q     quarter-of-year             number/text       3; 03; Q3; 3rd quarter
   Y       week-based-year             year              1996; 96
   w       week-of-week-based-year     number            27
   W       week-of-month               number            4
   E       day-of-week                 text              Tue; Tuesday; T
   e/c     localized day-of-week       number/text       2; 02; Tue; Tuesday; T
   F       week-of-month               number            3

   a       am-pm-of-day                text              PM
   h       clock-hour-of-am-pm (1-12)  number            12
   K       hour-of-am-pm (0-11)        number            0
   k       clock-hour-of-am-pm (1-24)  number            0

   H       hour-of-day (0-23)          number            0
   m       minute-of-hour              number            30
   s       second-of-minute            number            55
   S       fraction-of-second          fraction          978
   A       milli-of-day                number            1234
   n       nano-of-second              number            987654321
   N       nano-of-day                 number            1234000000

   V       time-zone ID                zone-id           America/Los_Angeles; Z; -08:30
   z       time-zone name              zone-name         Pacific Standard Time; PST
   O       localized zone-offset       offset-O          GMT+8; GMT+08:00; UTC-08:00;
   X       zone-offset 'Z' for zero    offset-X          Z; -08; -0830; -08:30; -083015; -08:30:15;
   x       zone-offset                 offset-x          +0000; -08; -0830; -08:30; -083015; -08:30:15;
   Z       zone-offset                 offset-Z          +0000; -0800; -08:00;

   p       pad next                    pad modifier      1

   '       escape for text             delimiter
   ''      single quote                literal           '
   [       optional section start
   ]       optional section end
   #       reserved for future use
   {       reserved for future use
   }       reserved for future use
 </pre>

 The count of pattern letters determine the format.
 See <a href=\"DateTimeFormatter.html#patterns\">DateTimeFormatter</a> for a user-focused description of the patterns.
 The following tables define how the pattern letters map to the builder.

 <b>Date fields</b>: Pattern letters to output a date.
 <pre>
  Pattern  Count  Equivalent builder methods
  -------  -----  --------------------------
    G       1      appendText(ChronoField.ERA, TextStyle.SHORT)
    GG      2      appendText(ChronoField.ERA, TextStyle.SHORT)
    GGG     3      appendText(ChronoField.ERA, TextStyle.SHORT)
    GGGG    4      appendText(ChronoField.ERA, TextStyle.FULL)
    GGGGG   5      appendText(ChronoField.ERA, TextStyle.NARROW)

    u       1      appendValue(ChronoField.YEAR, 1, 19, SignStyle.NORMAL);
    uu      2      appendValueReduced(ChronoField.YEAR, 2, 2000);
    uuu     3      appendValue(ChronoField.YEAR, 3, 19, SignStyle.NORMAL);
    u..u    4..n   appendValue(ChronoField.YEAR, n, 19, SignStyle.EXCEEDS_PAD);
    y       1      appendValue(ChronoField.YEAR_OF_ERA, 1, 19, SignStyle.NORMAL);
    yy      2      appendValueReduced(ChronoField.YEAR_OF_ERA, 2, 2000);
    yyy     3      appendValue(ChronoField.YEAR_OF_ERA, 3, 19, SignStyle.NORMAL);
    y..y    4..n   appendValue(ChronoField.YEAR_OF_ERA, n, 19, SignStyle.EXCEEDS_PAD);
    Y       1      append special localized WeekFields element for numeric week-based-year
    YY      2      append special localized WeekFields element for reduced numeric week-based-year 2 digits;
    YYY     3      append special localized WeekFields element for numeric week-based-year (3, 19, SignStyle.NORMAL);
    Y..Y    4..n   append special localized WeekFields element for numeric week-based-year (n, 19, SignStyle.EXCEEDS_PAD);

    Q       1      appendValue(IsoFields.QUARTER_OF_YEAR);
    QQ      2      appendValue(IsoFields.QUARTER_OF_YEAR, 2);
    QQQ     3      appendText(IsoFields.QUARTER_OF_YEAR, TextStyle.SHORT)
    QQQQ    4      appendText(IsoFields.QUARTER_OF_YEAR, TextStyle.FULL)
    QQQQQ   5      appendText(IsoFields.QUARTER_OF_YEAR, TextStyle.NARROW)
    q       1      appendValue(IsoFields.QUARTER_OF_YEAR);
    qq      2      appendValue(IsoFields.QUARTER_OF_YEAR, 2);
    qqq     3      appendText(IsoFields.QUARTER_OF_YEAR, TextStyle.SHORT_STANDALONE)
    qqqq    4      appendText(IsoFields.QUARTER_OF_YEAR, TextStyle.FULL_STANDALONE)
    qqqqq   5      appendText(IsoFields.QUARTER_OF_YEAR, TextStyle.NARROW_STANDALONE)

    M       1      appendValue(ChronoField.MONTH_OF_YEAR);
    MM      2      appendValue(ChronoField.MONTH_OF_YEAR, 2);
    MMM     3      appendText(ChronoField.MONTH_OF_YEAR, TextStyle.SHORT)
    MMMM    4      appendText(ChronoField.MONTH_OF_YEAR, TextStyle.FULL)
    MMMMM   5      appendText(ChronoField.MONTH_OF_YEAR, TextStyle.NARROW)
    L       1      appendValue(ChronoField.MONTH_OF_YEAR);
    LL      2      appendValue(ChronoField.MONTH_OF_YEAR, 2);
    LLL     3      appendText(ChronoField.MONTH_OF_YEAR, TextStyle.SHORT_STANDALONE)
    LLLL    4      appendText(ChronoField.MONTH_OF_YEAR, TextStyle.FULL_STANDALONE)
    LLLLL   5      appendText(ChronoField.MONTH_OF_YEAR, TextStyle.NARROW_STANDALONE)

    w       1      append special localized WeekFields element for numeric week-of-year
    ww      2      append special localized WeekFields element for numeric week-of-year, zero-padded
    W       1      append special localized WeekFields element for numeric week-of-month
    d       1      appendValue(ChronoField.DAY_OF_MONTH)
    dd      2      appendValue(ChronoField.DAY_OF_MONTH, 2)
    D       1      appendValue(ChronoField.DAY_OF_YEAR)
    DD      2      appendValue(ChronoField.DAY_OF_YEAR, 2)
    DDD     3      appendValue(ChronoField.DAY_OF_YEAR, 3)
    F       1      appendValue(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH)
    E       1      appendText(ChronoField.DAY_OF_WEEK, TextStyle.SHORT)
    EE      2      appendText(ChronoField.DAY_OF_WEEK, TextStyle.SHORT)
    EEE     3      appendText(ChronoField.DAY_OF_WEEK, TextStyle.SHORT)
    EEEE    4      appendText(ChronoField.DAY_OF_WEEK, TextStyle.FULL)
    EEEEE   5      appendText(ChronoField.DAY_OF_WEEK, TextStyle.NARROW)
    e       1      append special localized WeekFields element for numeric day-of-week
    ee      2      append special localized WeekFields element for numeric day-of-week, zero-padded
    eee     3      appendText(ChronoField.DAY_OF_WEEK, TextStyle.SHORT)
    eeee    4      appendText(ChronoField.DAY_OF_WEEK, TextStyle.FULL)
    eeeee   5      appendText(ChronoField.DAY_OF_WEEK, TextStyle.NARROW)
    c       1      append special localized WeekFields element for numeric day-of-week
    ccc     3      appendText(ChronoField.DAY_OF_WEEK, TextStyle.SHORT_STANDALONE)
    cccc    4      appendText(ChronoField.DAY_OF_WEEK, TextStyle.FULL_STANDALONE)
    ccccc   5      appendText(ChronoField.DAY_OF_WEEK, TextStyle.NARROW_STANDALONE)
 </pre>

 <b>Time fields</b>: Pattern letters to output a time.
 <pre>
  Pattern  Count  Equivalent builder methods
  -------  -----  --------------------------
    a       1      appendText(ChronoField.AMPM_OF_DAY, TextStyle.SHORT)
    h       1      appendValue(ChronoField.CLOCK_HOUR_OF_AMPM)
    hh      2      appendValue(ChronoField.CLOCK_HOUR_OF_AMPM, 2)
    H       1      appendValue(ChronoField.HOUR_OF_DAY)
    HH      2      appendValue(ChronoField.HOUR_OF_DAY, 2)
    k       1      appendValue(ChronoField.CLOCK_HOUR_OF_DAY)
    kk      2      appendValue(ChronoField.CLOCK_HOUR_OF_DAY, 2)
    K       1      appendValue(ChronoField.HOUR_OF_AMPM)
    KK      2      appendValue(ChronoField.HOUR_OF_AMPM, 2)
    m       1      appendValue(ChronoField.MINUTE_OF_HOUR)
    mm      2      appendValue(ChronoField.MINUTE_OF_HOUR, 2)
    s       1      appendValue(ChronoField.SECOND_OF_MINUTE)
    ss      2      appendValue(ChronoField.SECOND_OF_MINUTE, 2)

    S..S    1..n   appendFraction(ChronoField.NANO_OF_SECOND, n, n, false)
    A       1      appendValue(ChronoField.MILLI_OF_DAY)
    A..A    2..n   appendValue(ChronoField.MILLI_OF_DAY, n)
    n       1      appendValue(ChronoField.NANO_OF_SECOND)
    n..n    2..n   appendValue(ChronoField.NANO_OF_SECOND, n)
    N       1      appendValue(ChronoField.NANO_OF_DAY)
    N..N    2..n   appendValue(ChronoField.NANO_OF_DAY, n)
 </pre>

 <b>Zone ID</b>: Pattern letters to output {@code ZoneId}.
 <pre>
  Pattern  Count  Equivalent builder methods
  -------  -----  --------------------------
    VV      2      appendZoneId()
    z       1      appendZoneText(TextStyle.SHORT)
    zz      2      appendZoneText(TextStyle.SHORT)
    zzz     3      appendZoneText(TextStyle.SHORT)
    zzzz    4      appendZoneText(TextStyle.FULL)
 </pre>

 <b>Zone offset</b>: Pattern letters to output {@code ZoneOffset}.
 <pre>
  Pattern  Count  Equivalent builder methods
  -------  -----  --------------------------
    O       1      appendLocalizedOffsetPrefixed(TextStyle.SHORT);
    OOOO    4      appendLocalizedOffsetPrefixed(TextStyle.FULL);
    X       1      appendOffset(\"+HHmm\",\"Z\")
    XX      2      appendOffset(\"+HHMM\",\"Z\")
    XXX     3      appendOffset(\"+HH:MM\",\"Z\")
    XXXX    4      appendOffset(\"+HHMMss\",\"Z\")
    XXXXX   5      appendOffset(\"+HH:MM:ss\",\"Z\")
    x       1      appendOffset(\"+HHmm\",\"+00\")
    xx      2      appendOffset(\"+HHMM\",\"+0000\")
    xxx     3      appendOffset(\"+HH:MM\",\"+00:00\")
    xxxx    4      appendOffset(\"+HHMMss\",\"+0000\")
    xxxxx   5      appendOffset(\"+HH:MM:ss\",\"+00:00\")
    Z       1      appendOffset(\"+HHMM\",\"+0000\")
    ZZ      2      appendOffset(\"+HHMM\",\"+0000\")
    ZZZ     3      appendOffset(\"+HHMM\",\"+0000\")
    ZZZZ    4      appendLocalizedOffset(TextStyle.FULL);
    ZZZZZ   5      appendOffset(\"+HH:MM:ss\",\"Z\")
 </pre>

 <b>Modifiers</b>: Pattern letters that modify the rest of the pattern:
 <pre>
  Pattern  Count  Equivalent builder methods
  -------  -----  --------------------------
    [       1      optionalStart()
    ]       1      optionalEnd()
    p..p    1..n   padNext(n)
 </pre>

 Any sequence of letters not specified above, unrecognized letter or
 reserved character will throw an exception.
 Future versions may add to the set of patterns.
 It is recommended to use single quotes around all characters that you want
 to output directly to ensure that future changes do not break your application.

 Note that the pattern string is similar, but not identical, to
 {@link java.text.SimpleDateFormat SimpleDateFormat}.
 The pattern string is also similar, but not identical, to that defined by the
 Unicode Common Locale Data Repository (CLDR/LDML).
 Pattern letters 'X' and 'u' are aligned with Unicode CLDR/LDML.
 By contrast, {@code SimpleDateFormat} uses 'u' for the numeric day of week.
 Pattern letters 'y' and 'Y' parse years of two digits and more than 4 digits differently.
 Pattern letters 'n', 'A', 'N', and 'p' are added.
 Number types will reject large numbers.

 @param pattern  the pattern to add, not null
 @return this, for chaining, not null
 @throws IllegalArgumentException if the pattern is invalid"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"
                      "java.lang.String"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this ^java.lang.String pattern]
   (.appendPattern this pattern)))

(defn append-value
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"
                      "java.time.temporal.TemporalField"]
                     ["java.time.format.DateTimeFormatterBuilder"
                      "java.time.temporal.TemporalField" "int"]
                     ["java.time.format.DateTimeFormatterBuilder"
                      "java.time.temporal.TemporalField" "int" "int"
                      "java.time.format.SignStyle"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this
    ^java.time.temporal.TemporalField field]
   (.appendValue this field))
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this
    ^java.time.temporal.TemporalField field ^java.lang.Integer width]
   (.appendValue this field width))
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this
    ^java.time.temporal.TemporalField field ^java.lang.Integer min-width
    ^java.lang.Integer max-width ^java.time.format.SignStyle sign-style]
   (.appendValue this field min-width max-width sign-style)))

(defn append-instant
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]
                     ["java.time.format.DateTimeFormatterBuilder" "int"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this]
   (.appendInstant this))
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this
    ^java.lang.Integer fractional-digits]
   (.appendInstant this fractional-digits)))

(defn append-literal
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder" "char"]
                     ["java.time.format.DateTimeFormatterBuilder"
                      "java.lang.String"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this arg0]
   (cond (instance? java.lang.Character arg0)
           (let [literal ^"java.lang.Character" arg0]
             (.appendLiteral this literal))
         (instance? java.lang.String arg0) (let [literal ^"java.lang.String"
                                                         arg0]
                                             (.appendLiteral this literal))
         :else (throw (java.lang.IllegalArgumentException.
                        "no corresponding java.time method with these args")))))

(defn optional-start
  "Mark the start of an optional section.

 The output of formatting can include optional sections, which may be nested.
 An optional section is started by calling this method and ended by calling
 {@link #optionalEnd()} or by ending the build process.

 All elements in the optional section are treated as optional.
 During formatting, the section is only output if data is available in the
 {@code TemporalAccessor} for all the elements in the section.
 During parsing, the whole section may be missing from the parsed string.

 For example, consider a builder setup as
 {@code builder.appendValue(HOUR_OF_DAY,2).optionalStart().appendValue(MINUTE_OF_HOUR,2)}.
 The optional section ends automatically at the end of the builder.
 During formatting, the minute will only be output if its value can be obtained from the date-time.
 During parsing, the input will be successfully parsed whether the minute is present or not.

 @return this, for chaining, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this]
   (.optionalStart this)))

(defn append-fraction
  "Appends the fractional value of a date-time field to the formatter.

 The fractional value of the field will be output including the
 preceding decimal point. The preceding value is not output.
 For example, the second-of-minute value of 15 would be output as {@code .25}.

 The width of the printed fraction can be controlled. Setting the
 minimum width to zero will cause no output to be generated.
 The printed fraction will have the minimum width necessary between
 the minimum and maximum widths - trailing zeroes are omitted.
 No rounding occurs due to the maximum width - digits are simply dropped.

 When parsing in strict mode, the number of parsed digits must be between
 the minimum and maximum width. When parsing in lenient mode, the minimum
 width is considered to be zero and the maximum is nine.

 If the value cannot be obtained then an exception will be thrown.
 If the value is negative an exception will be thrown.
 If the field does not have a fixed set of valid values then an
 exception will be thrown.
 If the field value in the date-time to be printed is invalid it
 cannot be printed and an exception will be thrown.

 @param field  the field to append, not null
 @param minWidth  the minimum width of the field excluding the decimal point, from 0 to 9
 @param maxWidth  the maximum width of the field excluding the decimal point, from 1 to 9
 @param decimalPoint  whether to output the localized decimal point symbol
 @return this, for chaining, not null
 @throws IllegalArgumentException if the field has a variable set of valid values or
  either width is invalid"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"
                      "java.time.temporal.TemporalField" "int" "int"
                      "boolean"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this
    ^java.time.temporal.TemporalField field ^java.lang.Integer min-width
    ^java.lang.Integer max-width ^java.lang.Boolean decimal-point]
   (.appendFraction this field min-width max-width decimal-point)))

(defn append-optional
  "Appends a formatter to the builder which will optionally format/parse.

 This method has the same effect as appending each of the constituent
 parts directly to this builder surrounded by an {@link #optionalStart()} and
 {@link #optionalEnd()}.

 The formatter will format if data is available for all the fields contained within it.
 The formatter will parse if the string matches, otherwise no error is returned.

 @param formatter  the formatter to add, not null
 @return this, for chaining, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this
    ^java.time.format.DateTimeFormatter formatter]
   (.appendOptional this formatter)))

(defn optional-end
  "Ends an optional section.

 The output of formatting can include optional sections, which may be nested.
 An optional section is started by calling {@link #optionalStart()} and ended
 using this method (or at the end of the builder).

 Calling this method without having previously called {@code optionalStart}
 will throw an exception.
 Calling this method immediately after calling {@code optionalStart} has no effect
 on the formatter other than ending the (empty) optional section.

 All elements in the optional section are treated as optional.
 During formatting, the section is only output if data is available in the
 {@code TemporalAccessor} for all the elements in the section.
 During parsing, the whole section may be missing from the parsed string.

 For example, consider a builder setup as
 {@code builder.appendValue(HOUR_OF_DAY,2).optionalStart().appendValue(MINUTE_OF_HOUR,2).optionalEnd()}.
 During formatting, the minute will only be output if its value can be obtained from the date-time.
 During parsing, the input will be successfully parsed whether the minute is present or not.

 @return this, for chaining, not null
 @throws IllegalStateException if there was no previous call to {@code optionalStart}"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this]
   (.optionalEnd this)))

(defn parse-lenient
  "Changes the parse style to be lenient for the remainder of the formatter.
 Note that case sensitivity is set separately to this method.

 Parsing can be strict or lenient - by default its strict.
 This controls the degree of flexibility in matching the text and sign styles.
 Applications calling this method should typically also call {@link #parseCaseInsensitive()}.

 When used, this method changes the parsing to be lenient from this point onwards.
 The change will remain in force until the end of the formatter that is eventually
 constructed or until {@code parseStrict} is called.

 @return this, for chaining, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this]
   (.parseLenient this)))

(defn pad-next
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder" "int"]
                     ["java.time.format.DateTimeFormatterBuilder" "int"
                      "char"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this
    ^java.lang.Integer pad-width]
   (.padNext this pad-width))
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this ^java.lang.Integer pad-width
    ^java.lang.Character pad-char]
   (.padNext this pad-width pad-char)))

(defn append-chronology-id
  "Appends the chronology ID, such as 'ISO' or 'ThaiBuddhist', to the formatter.

 This appends an instruction to format/parse the chronology ID to the builder.

 During formatting, the chronology is obtained using a mechanism equivalent
 to querying the temporal with {@link TemporalQueries#chronology()}.
 It will be printed using the result of {@link Chronology#getId()}.
 If the chronology cannot be obtained then an exception is thrown unless the
 section of the formatter is optional.

 During parsing, the chronology is parsed and must match one of the chronologies
 in {@link Chronology#getAvailableChronologies()}.
 If the chronology cannot be parsed then an exception is thrown unless the
 section of the formatter is optional.
 The parser uses the {@linkplain #parseCaseInsensitive() case sensitive} setting.

 @return this, for chaining, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this]
   (.appendChronologyId this)))

(defn append-zone-or-offset-id
  "Appends the time-zone ID, such as 'Europe/Paris' or '+02:00', to
 the formatter, using the best available zone ID.

 This appends an instruction to format/parse the best available
 zone or offset ID to the builder.
 The zone ID is obtained in a lenient manner that first attempts to
 find a true zone ID, such as that on {@code ZonedDateTime}, and
 then attempts to find an offset, such as that on {@code OffsetDateTime}.

 During formatting, the zone is obtained using a mechanism equivalent
 to querying the temporal with {@link TemporalQueries#zone()}.
 It will be printed using the result of {@link ZoneId#getId()}.
 If the zone cannot be obtained then an exception is thrown unless the
 section of the formatter is optional.

 During parsing, the text must match a known zone or offset.
 There are two types of zone ID, offset-based, such as '+01:30' and
 region-based, such as 'Europe/London'. These are parsed differently.
 If the parse starts with '+', '-', 'UT', 'UTC' or 'GMT', then the parser
 expects an offset-based zone and will not match region-based zones.
 The offset ID, such as '+02:30', may be at the start of the parse,
 or prefixed by  'UT', 'UTC' or 'GMT'. The offset ID parsing is
 equivalent to using {@link #appendOffset(String, String)} using the
 arguments 'HH:MM:ss' and the no offset string '0'.
 If the parse starts with 'UT', 'UTC' or 'GMT', and the parser cannot
 match a following offset ID, then {@link ZoneOffset#UTC} is selected.
 In all other cases, the list of known region-based zones is used to
 find the longest available match. If no match is found, and the parse
 starts with 'Z', then {@code ZoneOffset.UTC} is selected.
 The parser uses the {@linkplain #parseCaseInsensitive() case sensitive} setting.

 For example, the following will parse:
 <pre>
   \"Europe/London\"           -- ZoneId.of(\"Europe/London\")
   \"Z\"                       -- ZoneOffset.UTC
   \"UT\"                      -- ZoneId.of(\"UT\")
   \"UTC\"                     -- ZoneId.of(\"UTC\")
   \"GMT\"                     -- ZoneId.of(\"GMT\")
   \"+01:30\"                  -- ZoneOffset.of(\"+01:30\")
   \"UT+01:30\"                -- ZoneOffset.of(\"UT+01:30\")
   \"UTC+01:30\"               -- ZoneOffset.of(\"UTC+01:30\")
   \"GMT+01:30\"               -- ZoneOffset.of(\"GMT+01:30\")
 </pre>

 Note that this method is identical to {@code appendZoneId()} except
 in the mechanism used to obtain the zone.

 @return this, for chaining, not null
 @see #appendZoneId()"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this]
   (.appendZoneOrOffsetId this)))

(defn parse-case-sensitive
  "Changes the parse style to be case sensitive for the remainder of the formatter.

 Parsing can be case sensitive or insensitive - by default it is case sensitive.
 This method allows the case sensitivity setting of parsing to be changed.

 Calling this method changes the state of the builder such that all
 subsequent builder method calls will parse text in case sensitive mode.
 See {@link #parseCaseInsensitive} for the opposite setting.
 The parse case sensitive/insensitive methods may be called at any point
 in the builder, thus the parser can swap between case parsing modes
 multiple times during the parse.

 Since the default is case sensitive, this method should only be used after
 a previous call to {@code #parseCaseInsensitive}.

 @return this, for chaining, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this]
   (.parseCaseSensitive this)))

(defn parse-strict
  "Changes the parse style to be strict for the remainder of the formatter.

 Parsing can be strict or lenient - by default its strict.
 This controls the degree of flexibility in matching the text and sign styles.

 When used, this method changes the parsing to be strict from this point onwards.
 As strict is the default, this is normally only needed after calling {@link #parseLenient()}.
 The change will remain in force until the end of the formatter that is eventually
 constructed or until {@code parseLenient} is called.

 @return this, for chaining, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this]
   (.parseStrict this)))

(defn append-chronology-text
  "Appends the chronology name to the formatter.

 The calendar system name will be output during a format.
 If the chronology cannot be obtained then an exception will be thrown.

 @param textStyle  the text style to use, not null
 @return this, for chaining, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"
                      "java.time.format.TextStyle"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this
    ^java.time.format.TextStyle text-style]
   (.appendChronologyText this text-style)))

(defn append-offset-id
  "Appends the zone offset, such as '+01:00', to the formatter.

 This appends an instruction to format/parse the offset ID to the builder.
 This is equivalent to calling {@code appendOffset(\"+HH:MM:ss\", \"Z\")}.

 @return this, for chaining, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this]
   (.appendOffsetId this)))

(defn append-zone-region-id
  "Appends the time-zone region ID, such as 'Europe/Paris', to the formatter,
 rejecting the zone ID if it is a {@code ZoneOffset}.

 This appends an instruction to format/parse the zone ID to the builder
 only if it is a region-based ID.

 During formatting, the zone is obtained using a mechanism equivalent
 to querying the temporal with {@link TemporalQueries#zoneId()}.
 If the zone is a {@code ZoneOffset} or it cannot be obtained then
 an exception is thrown unless the section of the formatter is optional.
 If the zone is not an offset, then the zone will be printed using
 the zone ID from {@link ZoneId#getId()}.

 During parsing, the text must match a known zone or offset.
 There are two types of zone ID, offset-based, such as '+01:30' and
 region-based, such as 'Europe/London'. These are parsed differently.
 If the parse starts with '+', '-', 'UT', 'UTC' or 'GMT', then the parser
 expects an offset-based zone and will not match region-based zones.
 The offset ID, such as '+02:30', may be at the start of the parse,
 or prefixed by  'UT', 'UTC' or 'GMT'. The offset ID parsing is
 equivalent to using {@link #appendOffset(String, String)} using the
 arguments 'HH:MM:ss' and the no offset string '0'.
 If the parse starts with 'UT', 'UTC' or 'GMT', and the parser cannot
 match a following offset ID, then {@link ZoneOffset#UTC} is selected.
 In all other cases, the list of known region-based zones is used to
 find the longest available match. If no match is found, and the parse
 starts with 'Z', then {@code ZoneOffset.UTC} is selected.
 The parser uses the {@linkplain #parseCaseInsensitive() case sensitive} setting.

 For example, the following will parse:
 <pre>
   \"Europe/London\"           -- ZoneId.of(\"Europe/London\")
   \"Z\"                       -- ZoneOffset.UTC
   \"UT\"                      -- ZoneId.of(\"UT\")
   \"UTC\"                     -- ZoneId.of(\"UTC\")
   \"GMT\"                     -- ZoneId.of(\"GMT\")
   \"+01:30\"                  -- ZoneOffset.of(\"+01:30\")
   \"UT+01:30\"                -- ZoneOffset.of(\"+01:30\")
   \"UTC+01:30\"               -- ZoneOffset.of(\"+01:30\")
   \"GMT+01:30\"               -- ZoneOffset.of(\"+01:30\")
 </pre>

 Note that this method is identical to {@code appendZoneId()} except
 in the mechanism used to obtain the zone.
 Note also that parsing accepts offsets, whereas formatting will never
 produce one.

 @return this, for chaining, not null
 @see #appendZoneId()"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this]
   (.appendZoneRegionId this)))

(defn parse-defaulting
  "Appends a default value for a field to the formatter for use in parsing.

 This appends an instruction to the builder to inject a default value
 into the parsed result. This is especially useful in conjunction with
 optional parts of the formatter.

 For example, consider a formatter that parses the year, followed by
 an optional month, with a further optional day-of-month. Using such a
 formatter would require the calling code to check whether a full date,
 year-month or just a year had been parsed. This method can be used to
 default the month and day-of-month to a sensible value, such as the
 first of the month, allowing the calling code to always get a date.

 During formatting, this method has no effect.

 During parsing, the current state of the parse is inspected.
 If the specified field has no associated value, because it has not been
 parsed successfully at that point, then the specified value is injected
 into the parse result. Injection is immediate, thus the field-value pair
 will be visible to any subsequent elements in the formatter.
 As such, this method is normally called at the end of the builder.

 @param field  the field to default the value of, not null
 @param value  the value to default the field to
 @return this, for chaining, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"
                      "java.time.temporal.TemporalField" "long"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this
    ^java.time.temporal.TemporalField field ^long value]
   (.parseDefaulting this field value)))

(defn append-zone-id
  "Appends the time-zone ID, such as 'Europe/Paris' or '+02:00', to the formatter.

 This appends an instruction to format/parse the zone ID to the builder.
 The zone ID is obtained in a strict manner suitable for {@code ZonedDateTime}.
 By contrast, {@code OffsetDateTime} does not have a zone ID suitable
 for use with this method, see {@link #appendZoneOrOffsetId()}.

 During formatting, the zone is obtained using a mechanism equivalent
 to querying the temporal with {@link TemporalQueries#zoneId()}.
 It will be printed using the result of {@link ZoneId#getId()}.
 If the zone cannot be obtained then an exception is thrown unless the
 section of the formatter is optional.

 During parsing, the text must match a known zone or offset.
 There are two types of zone ID, offset-based, such as '+01:30' and
 region-based, such as 'Europe/London'. These are parsed differently.
 If the parse starts with '+', '-', 'UT', 'UTC' or 'GMT', then the parser
 expects an offset-based zone and will not match region-based zones.
 The offset ID, such as '+02:30', may be at the start of the parse,
 or prefixed by  'UT', 'UTC' or 'GMT'. The offset ID parsing is
 equivalent to using {@link #appendOffset(String, String)} using the
 arguments 'HH:MM:ss' and the no offset string '0'.
 If the parse starts with 'UT', 'UTC' or 'GMT', and the parser cannot
 match a following offset ID, then {@link ZoneOffset#UTC} is selected.
 In all other cases, the list of known region-based zones is used to
 find the longest available match. If no match is found, and the parse
 starts with 'Z', then {@code ZoneOffset.UTC} is selected.
 The parser uses the {@linkplain #parseCaseInsensitive() case sensitive} setting.

 For example, the following will parse:
 <pre>
   \"Europe/London\"           -- ZoneId.of(\"Europe/London\")
   \"Z\"                       -- ZoneOffset.UTC
   \"UT\"                      -- ZoneId.of(\"UT\")
   \"UTC\"                     -- ZoneId.of(\"UTC\")
   \"GMT\"                     -- ZoneId.of(\"GMT\")
   \"+01:30\"                  -- ZoneOffset.of(\"+01:30\")
   \"UT+01:30\"                -- ZoneOffset.of(\"+01:30\")
   \"UTC+01:30\"               -- ZoneOffset.of(\"+01:30\")
   \"GMT+01:30\"               -- ZoneOffset.of(\"+01:30\")
 </pre>

 @return this, for chaining, not null
 @see #appendZoneRegionId()"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this]
   (.appendZoneId this)))

(defn get-localized-date-time-pattern
  "Gets the formatting pattern for date and time styles for a locale and chronology.
 The locale and chronology are used to lookup the locale specific format
 for the requested dateStyle and/or timeStyle.

 @param dateStyle  the FormatStyle for the date, null for time-only pattern
 @param timeStyle  the FormatStyle for the time, null for date-only pattern
 @param chrono  the Chronology, non-null
 @param locale  the locale, non-null
 @return the locale and Chronology specific formatting pattern
 @throws IllegalArgumentException if both dateStyle and timeStyle are null"
  {:arglists (quote (["java.time.format.FormatStyle"
                      "java.time.format.FormatStyle"
                      "java.time.chrono.Chronology" "java.util.Locale"]))}
  (^java.lang.String
   [^java.time.format.FormatStyle date-style
    ^java.time.format.FormatStyle time-style ^java.time.chrono.Chronology chrono
    ^java.util.Locale locale]
   (java.time.format.DateTimeFormatterBuilder/getLocalizedDateTimePattern
     date-style
     time-style
     chrono
     locale)))

(defn parse-case-insensitive
  "Changes the parse style to be case insensitive for the remainder of the formatter.

 Parsing can be case sensitive or insensitive - by default it is case sensitive.
 This method allows the case sensitivity setting of parsing to be changed.

 Calling this method changes the state of the builder such that all
 subsequent builder method calls will parse text in case insensitive mode.
 See {@link #parseCaseSensitive()} for the opposite setting.
 The parse case sensitive/insensitive methods may be called at any point
 in the builder, thus the parser can swap between case parsing modes
 multiple times during the parse.

 @return this, for chaining, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this]
   (.parseCaseInsensitive this)))

(defn append-localized-offset
  "Appends the localized zone offset, such as 'GMT+01:00', to the formatter.

 This appends a localized zone offset to the builder, the format of the
 localized offset is controlled by the specified {@link FormatStyle style}
 to this method:
 <ul>
 <li>{@link TextStyle#FULL full} - formats with localized offset text, such
 as 'GMT, 2-digit hour and minute field, optional second field if non-zero,
 and colon.
 <li>{@link TextStyle#SHORT short} - formats with localized offset text,
 such as 'GMT, hour without leading zero, optional 2-digit minute and
 second if non-zero, and colon.
 </ul>

 During formatting, the offset is obtained using a mechanism equivalent
 to querying the temporal with {@link TemporalQueries#offset()}.
 If the offset cannot be obtained then an exception is thrown unless the
 section of the formatter is optional.

 During parsing, the offset is parsed using the format defined above.
 If the offset cannot be parsed then an exception is thrown unless the
 section of the formatter is optional.

 @param style  the format style to use, not null
 @return this, for chaining, not null
 @throws IllegalArgumentException if style is neither {@link TextStyle#FULL
 full} nor {@link TextStyle#SHORT short}"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"
                      "java.time.format.TextStyle"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this
    ^java.time.format.TextStyle style]
   (.appendLocalizedOffset this style)))

(defn append
  "Appends all the elements of a formatter to the builder.

 This method has the same effect as appending each of the constituent
 parts of the formatter directly to this builder.

 @param formatter  the formatter to add, not null
 @return this, for chaining, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"
                      "java.time.format.DateTimeFormatter"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this
    ^java.time.format.DateTimeFormatter formatter]
   (.append this formatter)))

(defn append-text
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"
                      "java.time.temporal.TemporalField"]
                     ["java.time.format.DateTimeFormatterBuilder"
                      "java.time.temporal.TemporalField"
                      "java.time.format.TextStyle"]
                     ["java.time.format.DateTimeFormatterBuilder"
                      "java.time.temporal.TemporalField" "java.util.Map"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this
    ^java.time.temporal.TemporalField field]
   (.appendText this field))
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this arg0 arg1]
   (cond (and (instance? java.time.temporal.TemporalField arg0)
              (instance? java.time.format.TextStyle arg1))
           (let [field ^"java.time.temporal.TemporalField" arg0
                 text-style ^"java.time.format.TextStyle" arg1]
             (.appendText this field text-style))
         (and (instance? java.time.temporal.TemporalField arg0)
              (instance? java.util.Map arg1))
           (let [field ^"java.time.temporal.TemporalField" arg0
                 text-lookup ^"java.util.Map" arg1]
             (.appendText this field text-lookup))
         :else (throw (java.lang.IllegalArgumentException.
                        "no corresponding java.time method with these args")))))

(defn append-localized
  "Appends a localized date-time pattern to the formatter.

 This appends a localized section to the builder, suitable for outputting
 a date, time or date-time combination. The format of the localized
 section is lazily looked up based on four items:
 <ul>
 <li>the {@code dateStyle} specified to this method
 <li>the {@code timeStyle} specified to this method
 <li>the {@code Locale} of the {@code DateTimeFormatter}
 <li>the {@code Chronology}, selecting the best available
 </ul>
 During formatting, the chronology is obtained from the temporal object
 being formatted, which may have been overridden by
 {@link DateTimeFormatter#withChronology(Chronology)}.

 During parsing, if a chronology has already been parsed, then it is used.
 Otherwise the default from {@code DateTimeFormatter.withChronology(Chronology)}
 is used, with {@code IsoChronology} as the fallback.

 Note that this method provides similar functionality to methods on
 {@code DateFormat} such as {@link java.text.DateFormat#getDateTimeInstance(int, int)}.

 @param dateStyle  the date style to use, null means no date required
 @param timeStyle  the time style to use, null means no time required
 @return this, for chaining, not null
 @throws IllegalArgumentException if both the date and time styles are null"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"
                      "java.time.format.FormatStyle"
                      "java.time.format.FormatStyle"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this
    ^java.time.format.FormatStyle date-style
    ^java.time.format.FormatStyle time-style]
   (.appendLocalized this date-style time-style)))

(defn append-offset
  "Appends the zone offset, such as '+01:00', to the formatter.

 This appends an instruction to format/parse the offset ID to the builder.

 During formatting, the offset is obtained using a mechanism equivalent
 to querying the temporal with {@link TemporalQueries#offset()}.
 It will be printed using the format defined below.
 If the offset cannot be obtained then an exception is thrown unless the
 section of the formatter is optional.

 During parsing, the offset is parsed using the format defined below.
 If the offset cannot be parsed then an exception is thrown unless the
 section of the formatter is optional.

 The format of the offset is controlled by a pattern which must be one
 of the following:
 <ul>
 <li>{@code +HH} - hour only, ignoring minute and second
 <li>{@code +HHmm} - hour, with minute if non-zero, ignoring second, no colon
 <li>{@code +HH:mm} - hour, with minute if non-zero, ignoring second, with colon
 <li>{@code +HHMM} - hour and minute, ignoring second, no colon
 <li>{@code +HH:MM} - hour and minute, ignoring second, with colon
 <li>{@code +HHMMss} - hour and minute, with second if non-zero, no colon
 <li>{@code +HH:MM:ss} - hour and minute, with second if non-zero, with colon
 <li>{@code +HHMMSS} - hour, minute and second, no colon
 <li>{@code +HH:MM:SS} - hour, minute and second, with colon
 </ul>
 The \"no offset\" text controls what text is printed when the total amount of
 the offset fields to be output is zero.
 Example values would be 'Z', '+00:00', 'UTC' or 'GMT'.
 Three formats are accepted for parsing UTC - the \"no offset\" text, and the
 plus and minus versions of zero defined by the pattern.

 @param pattern  the pattern to use, not null
 @param noOffsetText  the text to use when the offset is zero, not null
 @return this, for chaining, not null"
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"
                      "java.lang.String" "java.lang.String"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this ^java.lang.String pattern
    ^java.lang.String no-offset-text]
   (.appendOffset this pattern no-offset-text)))

(defn append-value-reduced
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"
                      "java.time.temporal.TemporalField" "int" "int" "int"]
                     ["java.time.format.DateTimeFormatterBuilder"
                      "java.time.temporal.TemporalField" "int" "int"
                      "java.time.chrono.ChronoLocalDate"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this arg0 arg1 arg2 arg3]
   (cond (and (instance? java.time.temporal.TemporalField arg0)
              (instance? java.lang.Number arg1)
              (instance? java.lang.Number arg2)
              (instance? java.lang.Number arg3))
           (let [field ^"java.time.temporal.TemporalField" arg0
                 width (int arg1)
                 max-width (int arg2)
                 base-value (int arg3)]
             (.appendValueReduced this field width max-width base-value))
         (and (instance? java.time.temporal.TemporalField arg0)
              (instance? java.lang.Number arg1)
              (instance? java.lang.Number arg2)
              (instance? java.time.chrono.ChronoLocalDate arg3))
           (let [field ^"java.time.temporal.TemporalField" arg0
                 width (int arg1)
                 max-width (int arg2)
                 base-date ^"java.time.chrono.ChronoLocalDate" arg3]
             (.appendValueReduced this field width max-width base-date))
         :else (throw (java.lang.IllegalArgumentException.
                        "no corresponding java.time method with these args")))))

(defn append-zone-text
  {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"
                      "java.time.format.TextStyle"]
                     ["java.time.format.DateTimeFormatterBuilder"
                      "java.time.format.TextStyle" "java.util.Set"]))}
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this
    ^java.time.format.TextStyle text-style]
   (.appendZoneText this text-style))
  (^java.time.format.DateTimeFormatterBuilder
   [^java.time.format.DateTimeFormatterBuilder this
    ^java.time.format.TextStyle text-style ^java.util.Set preferred-zones]
   (.appendZoneText this text-style preferred-zones)))
