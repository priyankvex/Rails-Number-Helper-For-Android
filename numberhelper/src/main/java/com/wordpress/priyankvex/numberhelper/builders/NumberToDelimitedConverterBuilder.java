package com.wordpress.priyankvex.numberhelper.builders;

import com.wordpress.priyankvex.numberhelper.NumberConverter;
import com.wordpress.priyankvex.numberhelper.NumberToCurrencyConverter;
import com.wordpress.priyankvex.numberhelper.NumberToDelimitedConverter;

import java.util.HashMap;

/**
 * Created by Priyank(@priyankvex) on 1/10/15.
 * Builder for {@link com.wordpress.priyankvex.numberhelper.NumberToDelimitedConverter}
 */
public class NumberToDelimitedConverterBuilder {

    private HashMap<String, String> options;
    private double rawNumber;

    public NumberToDelimitedConverterBuilder(double rawNumber){
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
     * Sets the precision as the number of decimal digits.
     * In short we are keeping the current precision of the number.
     */
    private void setPrecision(){
        int precision;
        String numberString = String.valueOf(rawNumber);
        String temp[] = numberString.split("\\.");
        if (temp.length == 2){
            // decimal part is present.
            String decimalPart = temp[1];
            precision = decimalPart.length();
        }
        else{
            // Decimal part is absent. Set precision to 0.
            precision = 0;
        }
        options.put(NumberConverter.KEY_PRECISION, String.valueOf(precision));
    }

    /**
     * Returns instance of {@link NumberToCurrencyConverter}
     * @return instance of NumberToCurrencyConverter
     */
    public NumberToDelimitedConverter build(){
        // Setting precision as the current precision of the number.
        setPrecision();
        return new NumberToDelimitedConverter(rawNumber, options);
    }
}
