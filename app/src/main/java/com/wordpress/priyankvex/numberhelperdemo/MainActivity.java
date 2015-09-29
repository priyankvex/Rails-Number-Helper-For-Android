package com.wordpress.priyankvex.numberhelperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wordpress.priyankvex.numberhelper.Config;
import com.wordpress.priyankvex.numberhelper.NumberToCurrencyConverter;
import com.wordpress.priyankvex.numberhelper.NumberToCurrencyConverterBuilder;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidNumberException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Building NumberToCurrencyConverter class instance using builder
        NumberToCurrencyConverterBuilder builder = new NumberToCurrencyConverterBuilder(1212);
        builder.setUnit("Rs");
        builder.setDelimiter(".");
        NumberToCurrencyConverter numberToCurrencyConverter = builder.build();


    }

}
