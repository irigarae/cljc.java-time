(ns cljc.java-time.clock
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time :refer [Clock]]))

(defn tick
  "Obtains a clock that returns instants from the specified clock truncated\n to the nearest occurrence of the specified duration.\n <p>\n This clock will only tick as per the specified duration. Thus, if the duration\n is half a second, the clock will return instants truncated to the half second.\n <p>\n The tick duration must be positive. If it has a part smaller than a whole\n millisecond, then the whole duration must divide into one second without\n leaving a remainder. All normal tick durations will match these criteria,\n including any multiple of hours, minutes, seconds and milliseconds, and\n sensible nanosecond durations, such as 20ns, 250,000ns and 500,000ns.\n <p>\n A duration of zero or one nanosecond would have no truncation effect.\n Passing one of these will return the underlying clock.\n <p>\n Implementations may use a caching strategy for performance reasons.\n As such, it is possible that the start of the requested duration observed\n via this clock will be later than that observed directly via the underlying clock.\n <p>\n The returned implementation is immutable, thread-safe and {@code Serializable}\n providing that the base clock is.\n\n @param baseClock  the base clock to base the ticking clock on, not null\n @param tickDuration  the duration of each visible tick, not negative, not null\n @return a clock that ticks in whole units of the duration, not null\n @throws IllegalArgumentException if the duration is negative, or has a\n  part smaller than a whole millisecond such that the whole duration is not\n  divisible into one second\n @throws ArithmeticException if the duration is too large to be represented as nanos"
  {:arglists (quote (["java.time.Clock" "java.time.Duration"]))}
  (^js/JSJoda.Clock
   [^js/JSJoda.Clock base-clock ^js/JSJoda.Duration tick-duration]
   (js-invoke java.time.Clock "tick" base-clock tick-duration)))

(defn offset
  "Obtains a clock that returns instants from the specified clock with the\n specified duration added\n <p>\n This clock wraps another clock, returning instants that are later by the\n specified duration. If the duration is negative, the instants will be\n earlier than the current date and time.\n The main use case for this is to simulate running in the future or in the past.\n <p>\n A duration of zero would have no offsetting effect.\n Passing zero will return the underlying clock.\n <p>\n The returned implementation is immutable, thread-safe and {@code Serializable}\n providing that the base clock is.\n\n @param baseClock  the base clock to add the duration to, not null\n @param offsetDuration  the duration to add, not null\n @return a clock based on the base clock with the duration added, not null"
  {:arglists (quote (["java.time.Clock" "java.time.Duration"]))}
  (^js/JSJoda.Clock
   [^js/JSJoda.Clock base-clock ^js/JSJoda.Duration offset-duration]
   (js-invoke java.time.Clock "offset" base-clock offset-duration)))

(defn system-utc
  "Obtains a clock that returns the current instant using the best available\n system clock, converting to date and time using the UTC time-zone.\n <p>\n This clock, rather than {@link #systemDefaultZone()}, should be used when\n you need the current instant without the date or time.\n <p>\n This clock is based on the best available system clock.\n This may use {@link System#currentTimeMillis()}, or a higher resolution\n clock if one is available.\n <p>\n Conversion from instant to date or time uses the {@linkplain ZoneOffset#UTC UTC time-zone}.\n <p>\n The returned implementation is immutable, thread-safe and {@code Serializable}.\n It is equivalent to {@code system(ZoneOffset.UTC)}.\n\n @return a clock that uses the best available system clock in the UTC zone, not null"
  {:arglists (quote ([]))}
  (^js/JSJoda.Clock [] (js-invoke java.time.Clock "systemUTC")))

(defn system-default-zone
  "Obtains a clock that returns the current instant using the best available\n system clock, converting to date and time using the default time-zone.\n <p>\n This clock is based on the best available system clock.\n This may use {@link System#currentTimeMillis()}, or a higher resolution\n clock if one is available.\n <p>\n Using this method hard codes a dependency to the default time-zone into your application.\n It is recommended to avoid this and use a specific time-zone whenever possible.\n The {@link #systemUTC() UTC clock} should be used when you need the current instant\n without the date or time.\n <p>\n The returned implementation is immutable, thread-safe and {@code Serializable}.\n It is equivalent to {@code system(ZoneId.systemDefault())}.\n\n @return a clock that uses the best available system clock in the default zone, not null\n @see ZoneId#systemDefault()"
  {:arglists (quote ([]))}
  (^js/JSJoda.Clock [] (js-invoke java.time.Clock "systemDefaultZone")))

(defn fixed
  "Obtains a clock that always returns the same instant.\n <p>\n This clock simply returns the specified instant.\n As such, it is not a clock in the conventional sense.\n The main use case for this is in testing, where the fixed clock ensures\n tests are not dependent on the current clock.\n <p>\n The returned implementation is immutable, thread-safe and {@code Serializable}.\n\n @param fixedInstant  the instant to use as the clock, not null\n @param zone  the time-zone to use to convert the instant to date-time, not null\n @return a clock that always returns the same instant, not null"
  {:arglists (quote (["java.time.Instant" "java.time.ZoneId"]))}
  (^js/JSJoda.Clock [^js/JSJoda.Instant fixed-instant ^js/JSJoda.ZoneId zone]
   (js-invoke java.time.Clock "fixed" fixed-instant zone)))

(defn tick-minutes
  "Obtains a clock that returns the current instant ticking in whole minutes\n using best available system clock.\n <p>\n This clock will always have the nano-of-second and second-of-minute fields set to zero.\n This ensures that the visible time ticks in whole minutes.\n The underlying clock is the best available system clock, equivalent to\n using {@link #system(ZoneId)}.\n <p>\n Implementations may use a caching strategy for performance reasons.\n As such, it is possible that the start of the minute observed via this\n clock will be later than that observed directly via the underlying clock.\n <p>\n The returned implementation is immutable, thread-safe and {@code Serializable}.\n It is equivalent to {@code tick(system(zone), Duration.ofMinutes(1))}.\n\n @param zone  the time-zone to use to convert the instant to date-time, not null\n @return a clock that ticks in whole minutes using the specified zone, not null"
  {:arglists (quote (["java.time.ZoneId"]))}
  (^js/JSJoda.Clock [^js/JSJoda.ZoneId zone]
   (js-invoke java.time.Clock "tickMinutes" zone)))

(defn tick-seconds
  "Obtains a clock that returns the current instant ticking in whole seconds\n using best available system clock.\n <p>\n This clock will always have the nano-of-second field set to zero.\n This ensures that the visible time ticks in whole seconds.\n The underlying clock is the best available system clock, equivalent to\n using {@link #system(ZoneId)}.\n <p>\n Implementations may use a caching strategy for performance reasons.\n As such, it is possible that the start of the second observed via this\n clock will be later than that observed directly via the underlying clock.\n <p>\n The returned implementation is immutable, thread-safe and {@code Serializable}.\n It is equivalent to {@code tick(system(zone), Duration.ofSeconds(1))}.\n\n @param zone  the time-zone to use to convert the instant to date-time, not null\n @return a clock that ticks in whole seconds using the specified zone, not null"
  {:arglists (quote (["java.time.ZoneId"]))}
  (^js/JSJoda.Clock [^js/JSJoda.ZoneId zone]
   (js-invoke java.time.Clock "tickSeconds" zone)))

(defn millis
  {:arglists (quote (["java.time.Clock"]))}
  (^long [^js/JSJoda.Clock this] (.millis this)))

(defn with-zone
  {:arglists (quote (["java.time.Clock" "java.time.ZoneId"]))}
  (^js/JSJoda.Clock [^js/JSJoda.Clock this ^js/JSJoda.ZoneId zone]
   (.withZone this zone)))

(defn get-zone
  {:arglists (quote (["java.time.Clock"]))}
  (^js/JSJoda.ZoneId [^js/JSJoda.Clock this] (.zone this)))

(defn hash-code
  {:arglists (quote (["java.time.Clock"]))}
  (^int [^js/JSJoda.Clock this] (.hashCode this)))

(defn system
  "Obtains a clock that returns the current instant using best available\n system clock.\n <p>\n This clock is based on the best available system clock.\n This may use {@link System#currentTimeMillis()}, or a higher resolution\n clock if one is available.\n <p>\n Conversion from instant to date or time uses the specified time-zone.\n <p>\n The returned implementation is immutable, thread-safe and {@code Serializable}.\n\n @param zone  the time-zone to use to convert the instant to date-time, not null\n @return a clock that uses the best available system clock in the specified zone, not null"
  {:arglists (quote (["java.time.ZoneId"]))}
  (^js/JSJoda.Clock [^js/JSJoda.ZoneId zone]
   (js-invoke java.time.Clock "system" zone)))

(defn instant
  {:arglists (quote (["java.time.Clock"]))}
  (^js/JSJoda.Instant [^js/JSJoda.Clock this] (.instant this)))

(defn equals
  {:arglists (quote (["java.time.Clock" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.Clock this ^java.lang.Object obj] (.equals this obj)))
