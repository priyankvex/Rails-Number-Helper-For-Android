package com.wordpress.priyankvex.numberhelper;

import java.util.HashMap;

/**
 * Created by Priyank(@priyankvex) on 27/9/15.
 *
 * Base class to all other utility classes.
 */
public class NumberConverter {

    double rawNumber;

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

    /**
     * Checks if the unit is valid or not
     * @param unit String having the unit as a String
     * @return true if unit is valid, false otherwise.
     */
    boolean isUnitValid(String unit){
        return unit != null;
    }

    /**
     * Checks id separator is valid or not.
     * @param separator String having the separator as String.
     * @return true if valid, false otherwise.
     */
    boolean isSeparatorValid(String separator){
        return separator != null;
    }

    boolean isDelimiterValid(String delimiter){
        return delimiter != null;
    }

    boolean isPrecisionValid(String precision){
        if (precision == null){
            return false;
        }
        else if(!precision.matches(Config.NUMERIC_REGEX)){
            return false;
        }
        return true;
    }
}