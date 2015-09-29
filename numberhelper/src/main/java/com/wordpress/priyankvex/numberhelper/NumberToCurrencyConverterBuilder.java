package com.wordpress.priyankvex.numberhelper;

import java.util.HashMap;

/**
 * Created by Priyank(@priyankvex) on 27/9/15.
 * Builder for {@link NumberToCurrencyConverter}
 */
public class NumberToCurrencyConverterBuilder extends NumberConverter{

    private HashMap<String, String> options;

    public NumberToCurrencyConverterBuilder(double rawNumber){
        // Using a copy of default options.
        this.options = NumberConverter.numberToCurrencyOptions;
        this.rawNumber = rawNumber;
    }

    /**
     * Sets the unit for number to currency options.
     * @param unit String representing the unit.
     */
    public void setUnit(String unit) {
        // Overriding the value of the options map.
        options.put(NumberConverter.KEY_UNIT, unit);
    }

    /**
     * Sets the separator to be used.
     * @param separator String representing the separator.
     */
    public void setSeparator(String separator) {
        // Overriding the value of the options map.
        options.put(NumberConverter.KEY_SEPARATOR, separator);
    }

    /**
     * Sets the delimiter to be used.
     * @param delimiter String representing the delimiter.
     */
    public void setDelimiter(String delimiter) {
        // Overriding the value of the options map.
        options.put(NumberConverter.KEY_DELIMITER, delimiter);
    }

    /**
     * Sets the precision for the number
     * @param precision String containing precision value as integer.
     */
    public void setPrecision(String precision) {
        // Overriding the value of the options map.
        options.put(NumberConverter.KEY_PRECISION, precision);
    }

    /**
     * Returns instance of {@link NumberToCurrencyConverter}
     * @return instance of NumberToCurrencyConverter
     */
    public NumberToCurrencyConverter build(){
        return new NumberToCurrencyConverter(rawNumber, options);
    }
}
