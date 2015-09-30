package com.wordpress.priyankvex.numberhelper;

import android.util.Log;

import com.wordpress.priyankvex.numberhelper.exceptions.InvalidDelimiterException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidPrecisionException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidSeparatorException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidUnitException;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Priyank(@priyankvex) on 27/9/15.
 * Converts the number given as String to currency String according to the options specified.
 */
public class NumberToCurrencyConverter extends NumberConverter{

    private HashMap<String, String> options;

    public NumberToCurrencyConverter(double rawNumber, HashMap<String, String> options){
        this.options = options;
        this.rawNumber = rawNumber;

        // DEVELOPMENT
        Log.d(Config.TAG, options.toString());
        Log.d(Config.TAG, rawNumber+"");
    }

    public String convert() throws InvalidUnitException, InvalidSeparatorException,
            InvalidDelimiterException, InvalidPrecisionException {
        // Get the options
        String unit = options.get(NumberConverter.KEY_UNIT);
        String separator = options.get(NumberConverter.KEY_SEPARATOR);
        String delimiter = options.get(NumberConverter.KEY_DELIMITER);
        String precision = options.get(NumberConverter.KEY_PRECISION);
        // Validate options
        if (!isUnitValid(unit)){
            throw new InvalidUnitException();
        }
        if (!isSeparatorValid(separator)){
            throw new InvalidSeparatorException();
        }
        if (!isDelimiterValid(delimiter)){
            throw new InvalidDelimiterException();
        }
        if (!isPrecisionValid(precision)){
            throw new InvalidPrecisionException();
        }
        // Options are valid. Start the converting process.
        setNumberPrecision();
        setNumberDelimiter();
        setNumberUnit();
        return resultNumber;
    }

    /**
     * Sets number precised to specified number of decimal points.
     */
    private void setNumberPrecision(){
        int precisionValue = Integer.valueOf(options.get(NumberConverter.KEY_PRECISION));
        rawNumber = new BigDecimal(rawNumber)
                .setScale(precisionValue, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * Sets number as String with delimiter for thousands.
     */
    private void setNumberDelimiter(){
        int precisionValue = Integer.valueOf(options.get(NumberConverter.KEY_PRECISION));
        String delimiterValue = options.get(NumberConverter.KEY_DELIMITER);
        String delimitedNumber = NumberFormat.getNumberInstance(Locale.US).format(rawNumber);
        resultNumber = delimitedNumber.replace(",", delimiterValue);
        // Setting specified decimal digits.
        resultNumber = (String.format("%."+precisionValue+"f", rawNumber));
    }

    private void setNumberUnit(){
        String unit = options.get(NumberConverter.KEY_UNIT);
        resultNumber = unit + resultNumber;
    }
}
