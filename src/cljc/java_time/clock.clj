(ns cljc.java-time.clock
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness])
  (:import [java.time Clock]))

(defn tick
  "Obtains a clock that returns instants from the specified clock truncated
 to the nearest occurrence of the specified duration.

 This clock will only tick as per the specified duration. Thus, if the duration
 is half a second, the clock will return instants truncated to the half second.

 The tick duration must be positive. If it has a part smaller than a whole
 millisecond, then the whole duration must divide into one second without
 leaving a remainder. All normal tick durations will match these criteria,
 including any multiple of hours, minutes, seconds and milliseconds, and
 sensible nanosecond durations, such as 20ns, 250,000ns and 500,000ns.

 A duration of zero or one nanosecond would have no truncation effect.
 Passing one of these will return the underlying clock.

 Implementations may use a caching strategy for performance reasons.
 As such, it is possible that the start of the requested duration observed
 via this clock will be later than that observed directly via the underlying clock.

 The returned implementation is immutable, thread-safe and {@code Serializable}
 providing that the base clock is.

 @param baseClock  the base clock to base the ticking clock on, not null
 @param tickDuration  the duration of each visible tick, not negative, not null
 @return a clock that ticks in whole units of the duration, not null
 @throws IllegalArgumentException if the duration is negative, or has a
  part smaller than a whole millisecond such that the whole duration is not
  divisible into one second
 @throws ArithmeticException if the duration is too large to be represented as nanos"
  {:arglists (quote (["java.time.Clock" "java.time.Duration"]))}
  (^java.time.Clock
   [^java.time.Clock base-clock ^java.time.Duration tick-duration]
   (java.time.Clock/tick base-clock tick-duration)))

(defn offset
  "Obtains a clock that returns instants from the specified clock with the
 specified duration added

 This clock wraps another clock, returning instants that are later by the
 specified duration. If the duration is negative, the instants will be
 earlier than the current date and time.
 The main use case for this is to simulate running in the future or in the past.

 A duration of zero would have no offsetting effect.
 Passing zero will return the underlying clock.

 The returned implementation is immutable, thread-safe and {@code Serializable}
 providing that the base clock is.

 @param baseClock  the base clock to add the duration to, not null
 @param offsetDuration  the duration to add, not null
 @return a clock based on the base clock with the duration added, not null"
  {:arglists (quote (["java.time.Clock" "java.time.Duration"]))}
  (^java.time.Clock
   [^java.time.Clock base-clock ^java.time.Duration offset-duration]
   (java.time.Clock/offset base-clock offset-duration)))

(defn system-utc
  "Obtains a clock that returns the current instant using the best available
 system clock, converting to date and time using the UTC time-zone.

 This clock, rather than {@link #systemDefaultZone()}, should be used when
 you need the current instant without the date or time.

 This clock is based on the best available system clock.
 This may use {@link System#currentTimeMillis()}, or a higher resolution
 clock if one is available.

 Conversion from instant to date or time uses the {@linkplain ZoneOffset#UTC UTC time-zone}.

 The returned implementation is immutable, thread-safe and {@code Serializable}.
 It is equivalent to {@code system(ZoneOffset.UTC)}.

 @return a clock that uses the best available system clock in the UTC zone, not null"
  {:arglists (quote ([]))}
  (^java.time.Clock [] (java.time.Clock/systemUTC)))

(defn system-default-zone
  "Obtains a clock that returns the current instant using the best available
 system clock, converting to date and time using the default time-zone.

 This clock is based on the best available system clock.
 This may use {@link System#currentTimeMillis()}, or a higher resolution
 clock if one is available.

 Using this method hard codes a dependency to the default time-zone into your application.
 It is recommended to avoid this and use a specific time-zone whenever possible.
 The {@link #systemUTC() UTC clock} should be used when you need the current instant
 without the date or time.

 The returned implementation is immutable, thread-safe and {@code Serializable}.
 It is equivalent to {@code system(ZoneId.systemDefault())}.

 @return a clock that uses the best available system clock in the default zone, not null
 @see ZoneId#systemDefault()"
  {:arglists (quote ([]))}
  (^java.time.Clock [] (java.time.Clock/systemDefaultZone)))

(defn fixed
  "Obtains a clock that always returns the same instant.

 This clock simply returns the specified instant.
 As such, it is not a clock in the conventional sense.
 The main use case for this is in testing, where the fixed clock ensures
 tests are not dependent on the current clock.

 The returned implementation is immutable, thread-safe and {@code Serializable}.

 @param fixedInstant  the instant to use as the clock, not null
 @param zone  the time-zone to use to convert the instant to date-time, not null
 @return a clock that always returns the same instant, not null"
  {:arglists (quote (["java.time.Instant" "java.time.ZoneId"]))}
  (^java.time.Clock [^java.time.Instant fixed-instant ^java.time.ZoneId zone]
   (java.time.Clock/fixed fixed-instant zone)))

(defn tick-minutes
  "Obtains a clock that returns the current instant ticking in whole minutes
 using best available system clock.

 This clock will always have the nano-of-second and second-of-minute fields set to zero.
 This ensures that the visible time ticks in whole minutes.
 The underlying clock is the best available system clock, equivalent to
 using {@link #system(ZoneId)}.

 Implementations may use a caching strategy for performance reasons.
 As such, it is possible that the start of the minute observed via this
 clock will be later than that observed directly via the underlying clock.

 The returned implementation is immutable, thread-safe and {@code Serializable}.
 It is equivalent to {@code tick(system(zone), Duration.ofMinutes(1))}.

 @param zone  the time-zone to use to convert the instant to date-time, not null
 @return a clock that ticks in whole minutes using the specified zone, not null"
  {:arglists (quote (["java.time.ZoneId"]))}
  (^java.time.Clock [^java.time.ZoneId zone]
   (java.time.Clock/tickMinutes zone)))

(defn tick-seconds
  "Obtains a clock that returns the current instant ticking in whole seconds
 using best available system clock.

 This clock will always have the nano-of-second field set to zero.
 This ensures that the visible time ticks in whole seconds.
 The underlying clock is the best available system clock, equivalent to
 using {@link #system(ZoneId)}.

 Implementations may use a caching strategy for performance reasons.
 As such, it is possible that the start of the second observed via this
 clock will be later than that observed directly via the underlying clock.

 The returned implementation is immutable, thread-safe and {@code Serializable}.
 It is equivalent to {@code tick(system(zone), Duration.ofSeconds(1))}.

 @param zone  the time-zone to use to convert the instant to date-time, not null
 @return a clock that ticks in whole seconds using the specified zone, not null"
  {:arglists (quote (["java.time.ZoneId"]))}
  (^java.time.Clock [^java.time.ZoneId zone]
   (java.time.Clock/tickSeconds zone)))

(defn millis
  {:arglists (quote (["java.time.Clock"]))}
  (^long [^java.time.Clock this] (.millis this)))

(defn with-zone
  {:arglists (quote (["java.time.Clock" "java.time.ZoneId"]))}
  (^java.time.Clock [^java.time.Clock this ^java.time.ZoneId zone]
   (.withZone this zone)))

(defn get-zone
  {:arglists (quote (["java.time.Clock"]))}
  (^java.time.ZoneId [^java.time.Clock this] (.getZone this)))

(defn hash-code
  {:arglists (quote (["java.time.Clock"]))}
  (^java.lang.Integer [^java.time.Clock this] (.hashCode this)))

(defn system
  "Obtains a clock that returns the current instant using best available
 system clock.

 This clock is based on the best available system clock.
 This may use {@link System#currentTimeMillis()}, or a higher resolution
 clock if one is available.

 Conversion from instant to date or time uses the specified time-zone.

 The returned implementation is immutable, thread-safe and {@code Serializable}.

 @param zone  the time-zone to use to convert the instant to date-time, not null
 @return a clock that uses the best available system clock in the specified zone, not null"
  {:arglists (quote (["java.time.ZoneId"]))}
  (^java.time.Clock [^java.time.ZoneId zone] (java.time.Clock/system zone)))

(defn instant
  {:arglists (quote (["java.time.Clock"]))}
  (^java.time.Instant [^java.time.Clock this] (.instant this)))

(defn equals
  {:arglists (quote (["java.time.Clock" "java.lang.Object"]))}
  (^java.lang.Boolean [^java.time.Clock this ^java.lang.Object obj]
   (.equals this obj)))
