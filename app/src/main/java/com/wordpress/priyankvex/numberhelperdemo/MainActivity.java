package com.wordpress.priyankvex.numberhelperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wordpress.priyankvex.numberhelper.Config;
import com.wordpress.priyankvex.numberhelper.NumberToCurrencyConverter;
import com.wordpress.priyankvex.numberhelper.NumberToHumanConverter;
import com.wordpress.priyankvex.numberhelper.NumberToHumanSizeConverter;
import com.wordpress.priyankvex.numberhelper.NumberToPercentageConverter;
import com.wordpress.priyankvex.numberhelper.NumberToPhoneConverter;
import com.wordpress.priyankvex.numberhelper.builders.NumberToCurrencyConverterBuilder;
import com.wordpress.priyankvex.numberhelper.builders.NumberToHumanConverterBuilder;
import com.wordpress.priyankvex.numberhelper.builders.NumberToHumanSizeConverterBuilder;
import com.wordpress.priyankvex.numberhelper.builders.NumberToPercentageConverterBuilder;
import com.wordpress.priyankvex.numberhelper.builders.NumberToPhoneConverterBuilder;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidCountryCodeException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidDelimiterException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidNumberException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidPhoneNumberException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidPrecisionException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidSeparatorException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidUnitException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Number to currency converter
        NumberToCurrencyConverterBuilder builder = new NumberToCurrencyConverterBuilder(123456);
        builder.setPrecision("3");
        builder.setDelimiter(",");
        builder.setSeparator(".");
        builder.setUnit("$");
        NumberToCurrencyConverter converter = builder.build();
        try {
            String currency = converter.convert();
            Log.d(Config.TAG, currency);
        } catch (InvalidUnitException | InvalidSeparatorException
                | InvalidPrecisionException | InvalidDelimiterException e) {
            e.printStackTrace();
        }

        // Number to human converter
        NumberToHumanConverterBuilder builder2 = new NumberToHumanConverterBuilder(123456);
        NumberToHumanConverter converter2 = builder2.build();
        try {
            String humanNumber = converter2.convert();
            Log.d(Config.TAG, humanNumber);
        } catch (InvalidSeparatorException | InvalidDelimiterException
                | InvalidPrecisionException e) {
            e.printStackTrace();
        }

        // Number to human size converter
        NumberToHumanSizeConverterBuilder builder3 = new NumberToHumanSizeConverterBuilder(1123456);
        NumberToHumanSizeConverter converter3 = builder3.build();
        try {
            String humanSize = converter3.convert();
            Log.d(Config.TAG, humanSize);
        } catch (InvalidSeparatorException | InvalidDelimiterException
                | InvalidPrecisionException | InvalidNumberException e) {
            e.printStackTrace();
        }

        // Number to percentage converter
        NumberToPercentageConverterBuilder builder4 = new NumberToPercentageConverterBuilder(67.4566);
        builder4.setPrecision("5");
        NumberToPercentageConverter converter4 = builder4.build();
        try {
            String percentage = converter4.convert();
            Log.d(Config.TAG, percentage);
        } catch (InvalidSeparatorException | InvalidDelimiterException
                | InvalidPrecisionException e) {
            e.printStackTrace();
        }

        // Number to phone converter
        NumberToPhoneConverterBuilder builder5 = new NumberToPhoneConverterBuilder("1234567898");
        builder5.setCountryCode("91");
        NumberToPhoneConverter converter5 = builder5.build();
        try {
            String phoneNumber =  converter5.convert();
            Log.d(Config.TAG, phoneNumber);
        } catch (InvalidCountryCodeException | InvalidPhoneNumberException e) {
            e.printStackTrace();
        }

    }

}
