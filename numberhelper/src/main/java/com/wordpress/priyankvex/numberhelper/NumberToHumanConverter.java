package com.wordpress.priyankvex.numberhelper;

import android.util.Log;

import com.wordpress.priyankvex.numberhelper.exceptions.InvalidDelimiterException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidPrecisionException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidSeparatorException;

import java.util.HashMap;

/**
 * Created by Priyank(@priyankvex) on 2/10/15.
 */
public class NumberToHumanConverter extends NumberConverter{

    private String humanUnit;

    public NumberToHumanConverter(double rawNumber, HashMap<String, String> options){
        this.options = options;
        this.rawNumber = rawNumber;
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
        convertNumberToHuman();
        return resultNumber;
    }

    private void convertNumberToHuman(){
        double rawExponent = Math.log10(Math.abs(rawNumber));
        if (rawExponent < 0){
            // Number was less than 1
            int exponent = getExponentForNegativeExpo(rawExponent);
            rawNumber = rawNumber * (Math.pow(10, exponent));
        }
        else{
            // Number was greater than 1
            int exponent = getExponentForPositiveExpo(rawExponent);
            rawNumber = rawNumber / (Math.pow(10, exponent));
        }
        setNumberPrecision();
        resultNumber = rawNumber + " " + humanUnit;
    }

    private int getExponentForPositiveExpo(double rawExponent){
        if (rawExponent < 3){
            // Number is less than 1000. In hundreds.
             humanUnit = "";
            return  0;
        }
        else if (rawExponent >= 3 && rawExponent < 6){
            // Number is less than million. In thousands.
            humanUnit = "Thousands";
            return  3;
        }
        else if (rawExponent >= 6 && rawExponent < 9){
            // Number is less than billion. In millions.
            humanUnit = "Millions";
            return  6;
        }
        else if (rawExponent >= 9 && rawExponent < 12){
            // Number is less than trillion. In billions.
            humanUnit = "Billions";
            return  9;
        }
        else if (rawExponent >= 12 && rawExponent < 15){
            // Number is less than quadrillion. In trillions.
            humanUnit = "Trillions";
            return  12;
        }
        else {
          // Number is in quadrillions.
            humanUnit = "Quadrillions";
            return  15;
        }
    }

    private int getExponentForNegativeExpo(double rawExponent){
        if (rawExponent >= -1 && rawExponent < 0){
            // 0.1 to 0.9999999... deci
            humanUnit = "deci";
            return 1;
        }
        else if (rawExponent >= -2 && rawExponent < -1) {
            // 0.01 to 0.0999999... centi
            humanUnit = "centi";
            return 2;
        }
        else if (rawExponent >= -3 && rawExponent < -2) {
            // 0.001 to 0.009999999.... milli
            humanUnit = "milli";
            return 3;

        }
        else if (rawExponent >= -6 && rawExponent < -3) {
            // 0.000999999 to 0.00000999999 micro
            humanUnit = "micro";
            return 6;
        }
        else if (rawExponent >= -9 && rawExponent < -6){
            // 0.000001 etc. nano
            humanUnit = "nano";
            return 9;
        }
        else if (rawExponent >= -12 && rawExponent < -9){
            // 0.0000000001 etc. pico
            humanUnit = "pico";
            return 12;
        }
        else {
            // 0.0000000000001 etc. femto
            humanUnit = "femto";
            return 15;
        }

    }
}
