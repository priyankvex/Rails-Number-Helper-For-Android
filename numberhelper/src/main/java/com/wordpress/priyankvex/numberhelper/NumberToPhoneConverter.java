package com.wordpress.priyankvex.numberhelper;

import android.util.Log;

import com.wordpress.priyankvex.numberhelper.exceptions.InvalidCountryCodeException;

import java.text.DecimalFormat;
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
        if (!isPhoneNumberValid()){
        }
        if (!isCountryCodeValid(countryCode)){
            throw new InvalidCountryCodeException();
        }
        // Options are valid. Start the converting process.
        setPhoneNumber();
        return resultNumber;
    }

    private void setPhoneNumber(){
        //get a 12 digits String, filling with left '0' (on the prefix)
        String countryCode = options.get(NumberConverter.KEY_COUNTRY_CODE);
        DecimalFormat phoneDecimalFmt = new DecimalFormat("0000000000");
        String phoneRawString= phoneDecimalFmt.format(rawNumber);

        java.text.MessageFormat phoneMsgFmt = new java.text.MessageFormat("({0})-{1}-{2}");
        // Grouping of 3-3-4
        String[] phoneNumArr={phoneRawString.substring(0, 3),
                phoneRawString.substring(3,6),
                phoneRawString.substring(6)};

        resultNumber = phoneMsgFmt.format(phoneNumArr);

        if (!countryCode.equals("")){
            resultNumber = "+" + countryCode + "-" + resultNumber;
        }

    }

    private boolean isPhoneNumberValid(){
        String numberString = String.valueOf(rawNumber);
        Log.d(Config.TAG, "Phone number string : " + numberString);
        if (numberString.length() != 10){
            return false;
        }
        return true;
    }
}
