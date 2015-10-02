package com.wordpress.priyankvex.numberhelper.builders;

import com.wordpress.priyankvex.numberhelper.NumberConverter;
import com.wordpress.priyankvex.numberhelper.NumberToCurrencyConverter;
import com.wordpress.priyankvex.numberhelper.NumberToPercentageConverter;
import com.wordpress.priyankvex.numberhelper.NumberToPhoneConverter;

import java.util.HashMap;

/**
 * Created by Priyank(@priyankvex) on 1/10/15.
 */
public class NumberToPhoneConverterBuilder {

    private HashMap<String, String> options;
    private double rawNumber;

    public NumberToPhoneConverterBuilder(double rawNumber){
        // Using a copy of default options.
        this.options = NumberConverter.numberToCurrencyOptions;
        this.rawNumber = rawNumber;
    }

    /**
     * Sets the country code for the phone number
     * @param countryCode country code as a String.
     */
    public void setCountryCode(String countryCode){
        options.put(NumberConverter.KEY_COUNTRY_CODE, countryCode);
    }

    /**
     * Returns instance of {@link NumberToCurrencyConverter}
     * @return instance of NumberToCurrencyConverter
     */
    public NumberToPhoneConverter build(){
        return new NumberToPhoneConverter(rawNumber, options);
    }

}
