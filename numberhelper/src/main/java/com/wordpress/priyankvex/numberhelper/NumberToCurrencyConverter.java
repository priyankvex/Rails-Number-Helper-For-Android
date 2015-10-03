package com.wordpress.priyankvex.numberhelper;

import com.wordpress.priyankvex.numberhelper.exceptions.InvalidDelimiterException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidPrecisionException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidSeparatorException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidUnitException;

import java.util.HashMap;

/**
 * Created by Priyank(@priyankvex) on 27/9/15.
 * Converts the number given as String to currency String according to the options specified.
 */
public class NumberToCurrencyConverter extends NumberConverter{

    public NumberToCurrencyConverter(double rawNumber, HashMap<String, String> options){
        this.options = options;
        this.rawNumber = rawNumber;
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

    private void setNumberUnit(){
        String unit = options.get(NumberConverter.KEY_UNIT);
        resultNumber = unit + resultNumber;
    }
}
