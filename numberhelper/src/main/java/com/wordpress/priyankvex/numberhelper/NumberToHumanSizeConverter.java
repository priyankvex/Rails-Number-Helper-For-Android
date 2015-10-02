package com.wordpress.priyankvex.numberhelper;

import android.util.Log;

import com.wordpress.priyankvex.numberhelper.exceptions.InvalidDelimiterException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidPrecisionException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidSeparatorException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Priyank(@priyankvex) on 2/10/15.
 */
public class NumberToHumanSizeConverter extends NumberConverter {

    ArrayList<String> sizeUnits = new ArrayList<>();

    public NumberToHumanSizeConverter(double rawNumber, HashMap<String, String> options){
        this.options = options;
        this.rawNumber = rawNumber;

        // Adding the sizes to sizeUnits
        sizeUnits.add("Bytes");
        sizeUnits.add("KB");
        sizeUnits.add("MB");
        sizeUnits.add("GB");
        sizeUnits.add("TB");

        // DEVELOPMENT
        Log.d(Config.TAG, options.toString());
    }

    public String convert() throws InvalidSeparatorException, InvalidDelimiterException, InvalidPrecisionException {
        // Get the options
        String separator = options.get(NumberConverter.KEY_SEPARATOR);
        String delimiter = options.get(NumberConverter.KEY_DELIMITER);
        String precision = options.get(NumberConverter.KEY_PRECISION);

        // Validate options
        if (!isSeparatorValid(separator)){
            throw new InvalidSeparatorException();
        }
        if (!isPrecisionValid(precision)){
            throw new InvalidPrecisionException();
        }
        if (!isDelimiterValid(delimiter)){
            throw new InvalidDelimiterException();
        }
        if (!isPrecisionValid(precision)){
            throw new InvalidPrecisionException();
        }
        // Options are valid. Start the converting process.
        convertNumberToHumanSize();
        return resultNumber;
    }

    private void convertNumberToHumanSize(){
        int i;
        for (i = 0; i < 4; i++){
            if (rawNumber < 1024){
                break;
            }
            rawNumber = rawNumber / 1024;
        }
        String humanUnit = sizeUnits.get(i);
        setNumberPrecision();
        resultNumber = rawNumber + " " + humanUnit;
    }

}
