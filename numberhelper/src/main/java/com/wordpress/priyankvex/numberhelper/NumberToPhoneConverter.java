package com.wordpress.priyankvex.numberhelper;

import android.util.Log;

import com.wordpress.priyankvex.numberhelper.exceptions.InvalidCountryCodeException;

import java.util.HashMap;

/**
 * Created by Priyank(@priyankvex) on 1/10/15.
 */
public class NumberToPhoneConverter extends NumberConverter{

    public NumberToPhoneConverter(double rawNumber, HashMap<String, String> options){
        this.options = options;
        this.rawNumber = rawNumber;

        // DEVELOPMENT
        Log.d(Config.TAG, options.toString());
        Log.d(Config.TAG, rawNumber + "");
    }

    public String convert() throws InvalidCountryCodeException {
        // Get the options
        String countryCode = options.get(NumberConverter.KEY_COUNTRY_CODE);
        // Validate options
        if (!isCountryCodeValid(countryCode)){
            throw new InvalidCountryCodeException();
        }
        // Options are valid. Start the converting process.
        return resultNumber;
    }

    private void setPhoneNumber(){

    }
}
