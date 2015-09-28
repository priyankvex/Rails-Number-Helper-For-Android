package com.wordpress.priyankvex.numberhelper;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by Priyank(@priyankvex) on 27/9/15.
 * Converts the number given as String to curency String according to the options specified.
 */
public class NumberToCurrencyConverter extends NumberConverter{

    private HashMap<String, String> options;
    private double rawNumber;

    public NumberToCurrencyConverter(double rawNumber, HashMap<String, String> options){
        this.options = options;
        this.rawNumber = rawNumber;

        // DEVELOPMENT
        Log.d(Config.TAG, options.toString());
        Log.d(Config.TAG, rawNumber+"");
    }
}
