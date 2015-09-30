package com.wordpress.priyankvex.numberhelper;

import android.util.Log;

import com.wordpress.priyankvex.numberhelper.exceptions.InvalidDelimiterException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidPrecisionException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidSeparatorException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidUnitException;

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

    public String convert() {
        // Get the options
        String countryCode = options.get(NumberConverter.KEY_COUNTRY_CODE);
        // Validate options
        // Options are valid. Start the converting process.
        return resultNumber;
    }

    private void setPhoneNumber(){

    }
}
