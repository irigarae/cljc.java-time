(ns cljc.java-time.format.decimal-style
  (:refer-clojure :exclude
                  [abs get range format min max next name resolve short])
  (:require [cljc.java-time.extn.calendar-awareness]
            [goog.object]
            [java.time.format :refer [DecimalStyle]]))

(def standard
  "The standard set of non-localized decimal style symbols.

 This uses standard ASCII characters for zero, positive, negative and a dot for the decimal point."
  (goog.object/get java.time.format.DecimalStyle "STANDARD"))

(defn with-decimal-separator
  "Returns a copy of the info with a new character that represents the decimal point.

 The character used to represent a decimal point may vary by culture.
 This method specifies the character to use.

 @param decimalSeparator  the character for the decimal point
 @return  a copy with a new character that represents the decimal point, not null"
  {:arglists (quote (["java.time.format.DecimalStyle" "char"]))}
  (^js/JSJoda.DecimalStyle
   [^js/JSJoda.DecimalStyle this ^char decimal-separator]
   (.withDecimalSeparator this decimal-separator)))

(defn of
  "Obtains the DecimalStyle for the specified locale.

 This method provides access to locale sensitive decimal style symbols.

 @param locale  the locale, not null
 @return the decimal style, not null"
  {:arglists (quote (["java.util.Locale"]))}
  (^js/JSJoda.DecimalStyle [^java.util.Locale locale]
   (js-invoke java.time.format.DecimalStyle "of" locale)))

(defn with-positive-sign
  "Returns a copy of the info with a new character that represents the positive sign.

 The character used to represent a positive number may vary by culture.
 This method specifies the character to use.

 @param positiveSign  the character for the positive sign
 @return  a copy with a new character that represents the positive sign, not null"
  {:arglists (quote (["java.time.format.DecimalStyle" "char"]))}
  (^js/JSJoda.DecimalStyle [^js/JSJoda.DecimalStyle this ^char positive-sign]
   (.withPositiveSign this positive-sign)))

(defn get-decimal-separator
  "Gets the character that represents the decimal point.

 The character used to represent a decimal point may vary by culture.
 This method specifies the character to use.

 @return the character for the decimal point"
  {:arglists (quote (["java.time.format.DecimalStyle"]))}
  (^char [^js/JSJoda.DecimalStyle this] (.decimalSeparator this)))

(defn of-default-locale
  "Obtains the DecimalStyle for the default
 {@link java.util.Locale.Category#FORMAT FORMAT} locale.

 This method provides access to locale sensitive decimal style symbols.

 This is equivalent to calling
 {@link #of(Locale)
     of(Locale.getDefault(Locale.Category.FORMAT))}.

 @see java.util.Locale.Category#FORMAT
 @return the decimal style, not null"
  {:arglists (quote ([]))}
  (^js/JSJoda.DecimalStyle []
   (js-invoke java.time.format.DecimalStyle "ofDefaultLocale")))

(defn with-zero-digit
  "Returns a copy of the info with a new character that represents zero.

 The character used to represent digits may vary by culture.
 This method specifies the zero character to use, which implies the characters for one to nine.

 @param zeroDigit  the character for zero
 @return  a copy with a new character that represents zero, not null"
  {:arglists (quote (["java.time.format.DecimalStyle" "char"]))}
  (^js/JSJoda.DecimalStyle [^js/JSJoda.DecimalStyle this ^char zero-digit]
   (.withZeroDigit this zero-digit)))

(defn to-string
  "Returns a string describing this DecimalStyle.

 @return a string description, not null"
  {:arglists (quote (["java.time.format.DecimalStyle"]))}
  (^java.lang.String [^js/JSJoda.DecimalStyle this] (.toString this)))

(defn get-zero-digit
  "Gets the character that represents zero.

 The character used to represent digits may vary by culture.
 This method specifies the zero character to use, which implies the characters for one to nine.

 @return the character for zero"
  {:arglists (quote (["java.time.format.DecimalStyle"]))}
  (^char [^js/JSJoda.DecimalStyle this] (.zeroDigit this)))

(defn with-negative-sign
  "Returns a copy of the info with a new character that represents the negative sign.

 The character used to represent a negative number may vary by culture.
 This method specifies the character to use.

 @param negativeSign  the character for the negative sign
 @return  a copy with a new character that represents the negative sign, not null"
  {:arglists (quote (["java.time.format.DecimalStyle" "char"]))}
  (^js/JSJoda.DecimalStyle [^js/JSJoda.DecimalStyle this ^char negative-sign]
   (.withNegativeSign this negative-sign)))

(defn get-available-locales
  "Lists all the locales that are supported.

 The locale 'en_US' will always be present.

 @return a Set of Locales for which localization is supported"
  {:arglists (quote ([]))}
  (^java.util.Set []
   (js-invoke java.time.format.DecimalStyle "getAvailableLocales")))

(defn get-positive-sign
  "Gets the character that represents the positive sign.

 The character used to represent a positive number may vary by culture.
 This method specifies the character to use.

 @return the character for the positive sign"
  {:arglists (quote (["java.time.format.DecimalStyle"]))}
  (^char [^js/JSJoda.DecimalStyle this] (.positiveSign this)))

(defn hash-code
  "A hash code for this DecimalStyle.

 @return a suitable hash code"
  {:arglists (quote (["java.time.format.DecimalStyle"]))}
  (^int [^js/JSJoda.DecimalStyle this] (.hashCode this)))

(defn get-negative-sign
  "Gets the character that represents the negative sign.

 The character used to represent a negative number may vary by culture.
 This method specifies the character to use.

 @return the character for the negative sign"
  {:arglists (quote (["java.time.format.DecimalStyle"]))}
  (^char [^js/JSJoda.DecimalStyle this] (.negativeSign this)))

(defn equals
  "Checks if this DecimalStyle is equal to another DecimalStyle.

 @param obj  the object to check, null returns false
 @return true if this is equal to the other date"
  {:arglists (quote (["java.time.format.DecimalStyle" "java.lang.Object"]))}
  (^boolean [^js/JSJoda.DecimalStyle this ^java.lang.Object obj]
   (.equals this obj)))
