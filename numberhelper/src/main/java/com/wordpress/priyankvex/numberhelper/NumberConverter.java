package com.wordpress.priyankvex.numberhelper;

import java.util.HashMap;

/**
 * Created by Priyank(@priyankvex) on 27/9/15.
 *
 * Base class to all other utility classes.
 */
public class NumberConverter {

    /**
     * Options for {@link NumberToCurrencyConverter}.
     */
    public static HashMap<String, String> numberToCurrencyOptions;

    // Keys for options maps
    public static final String KEY_UNIT = "unit";
    public static final String KEY_SEPARATOR = "separator";
    public static final String KEY_DELIMITER = "delimiter";
    public static final String KEY_PRECISION = "precision";

    static {
        numberToCurrencyOptions = new HashMap<>();
        numberToCurrencyOptions.put(KEY_UNIT, "$");
        numberToCurrencyOptions.put(KEY_SEPARATOR, ".");
        numberToCurrencyOptions.put(KEY_DELIMITER, ",");
        numberToCurrencyOptions.put(KEY_PRECISION, "2");
    }


}