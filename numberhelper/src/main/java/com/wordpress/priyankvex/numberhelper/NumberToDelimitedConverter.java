package com.wordpress.priyankvex.numberhelper;

import com.wordpress.priyankvex.numberhelper.exceptions.InvalidDelimiterException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidSeparatorException;

import java.util.HashMap;

/**
 * Created by Priyank(@priyankvex) on 1/10/15.
 */
public class NumberToDelimitedConverter extends NumberConverter{

    public NumberToDelimitedConverter(double rawNumber, HashMap<String, String> options){
        this.options = options;
        this.rawNumber = rawNumber;
    }

    public String convert() throws InvalidSeparatorException, InvalidDelimiterException{
        // Get the options
        String separator = options.get(NumberConverter.KEY_SEPARATOR);
        String delimiter = options.get(NumberConverter.KEY_DELIMITER);

        // Validate options
        if (!isSeparatorValid(separator)){
            throw new InvalidSeparatorException();
        }
        if (!isDelimiterValid(delimiter)){
            throw new InvalidDelimiterException();
        }
        // Options are valid. Start the converting process.
        setNumberDelimiter();
        return resultNumber;
    }

}
