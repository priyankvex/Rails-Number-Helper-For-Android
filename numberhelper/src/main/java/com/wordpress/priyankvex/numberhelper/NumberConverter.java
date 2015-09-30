package com.wordpress.priyankvex.numberhelper;

import android.util.Log;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Priyank(@priyankvex) on 27/9/15.
 *
 * Base class to all other utility classes.
 */
public class NumberConverter {

    public double rawNumber;
    String resultNumber;
    HashMap<String, String> options;

    /**
     * Options for {@link NumberToCurrencyConverter}.
     */
    public static HashMap<String, String> numberToCurrencyOptions;

    // Keys for options maps
    public static final String KEY_UNIT = "unit";
    public static final String KEY_SEPARATOR = "separator";
    public static final String KEY_DELIMITER = "delimiter";
    public static final String KEY_PRECISION = "precision";
    public static final String KEY_COUNTRY_CODE = "countryCode";

    static {
        numberToCurrencyOptions = new HashMap<>();
        numberToCurrencyOptions.put(KEY_UNIT, "$");
        numberToCurrencyOptions.put(KEY_SEPARATOR, ".");
        numberToCurrencyOptions.put(KEY_DELIMITER, ",");
        numberToCurrencyOptions.put(KEY_PRECISION, "2");
        numberToCurrencyOptions.put(KEY_COUNTRY_CODE, "");
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

    /**
     * Sets number precised to specified number of decimal points.
     */
    void setNumberPrecision(){
        int precisionValue = Integer.valueOf(options.get(NumberConverter.KEY_PRECISION));
        rawNumber = new BigDecimal(rawNumber)
                .setScale(precisionValue, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * Sets number as String with delimiter for thousands.
     */
    void setNumberDelimiter(){
        int precisionValue = Integer.valueOf(options.get(NumberConverter.KEY_PRECISION));
        String separator = options.get(KEY_SEPARATOR);
        resultNumber = (String.format("%."+precisionValue+"f", rawNumber));
        String temp[] = resultNumber.split("\\.");
        double integerPart = Double.valueOf(temp[0]);
        String decimalPart = "";
        if (temp.length == 2){
            // Only if decimal part is there.
            decimalPart = separator + (resultNumber.split("\\.")[1]);
        }
        String delimiterValue = options.get(NumberConverter.KEY_DELIMITER);
        String delimitedIntegerPart = NumberFormat.getNumberInstance(Locale.US)
                .format(integerPart)
                .replace(",", delimiterValue);
        Log.d(Config.TAG, "int " + integerPart);
        Log.d(Config.TAG, "dec " + decimalPart);
        resultNumber = delimitedIntegerPart + decimalPart;
    }
}