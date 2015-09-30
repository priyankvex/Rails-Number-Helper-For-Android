package com.wordpress.priyankvex.numberhelperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wordpress.priyankvex.numberhelper.Config;
import com.wordpress.priyankvex.numberhelper.NumberToCurrencyConverter;
import com.wordpress.priyankvex.numberhelper.builders.NumberToCurrencyConverterBuilder;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidDelimiterException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidPrecisionException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidSeparatorException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidUnitException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Building NumberToCurrencyConverter class instance using builder
        NumberToCurrencyConverterBuilder builder = new NumberToCurrencyConverterBuilder(23343433434.946);
        builder.setUnit("$");
        builder.setDelimiter(",");
        builder.setPrecision("2");
        NumberToCurrencyConverter numberToCurrencyConverter = builder.build();

        try {
            String result = numberToCurrencyConverter.convert();
            Log.d(Config.TAG, result);
        } catch (InvalidUnitException | InvalidSeparatorException
                | InvalidPrecisionException | InvalidDelimiterException e) {
            e.printStackTrace();
        }
    }

}
