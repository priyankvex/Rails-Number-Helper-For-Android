package com.wordpress.priyankvex.numberhelper.builders;

import com.wordpress.priyankvex.numberhelper.NumberConverter;
import com.wordpress.priyankvex.numberhelper.NumberToCurrencyConverter;
import com.wordpress.priyankvex.numberhelper.NumberToHumanConverter;

import java.util.HashMap;

/**
 * Created by Priyank(@priyankvex) on 2/10/15.
 */
public class NumberToHumanConverterBuilder {

    private HashMap<String, String> options;
    private double rawNumber;

    public NumberToHumanConverterBuilder(double rawNumber){
        // Using a copy of default options.
        this.options = NumberConverter.numberToCurrencyOptions;
        this.rawNumber = rawNumber;
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
     * Sets the precision to be used.
     * @param precision String having the precision.
     */
    public void setPrecision(String precision){
        options.put(NumberConverter.KEY_PRECISION, precision);
    }


    /**
     * Returns instance of {@link NumberToCurrencyConverter}
     * @return instance of NumberToCurrencyConverter
     */
    public NumberToHumanConverter build(){
        return new NumberToHumanConverter(rawNumber, options);
    }
}
