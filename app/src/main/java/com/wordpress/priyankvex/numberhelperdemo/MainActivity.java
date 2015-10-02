package com.wordpress.priyankvex.numberhelperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wordpress.priyankvex.numberhelper.NumberToHumanConverter;
import com.wordpress.priyankvex.numberhelper.builders.NumberToHumanConverterBuilder;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidDelimiterException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidPrecisionException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidSeparatorException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Building NumberToCurrencyConverter class instance using builder
        NumberToHumanConverterBuilder builder = new NumberToHumanConverterBuilder(-0.0002323232);
        NumberToHumanConverter converter = builder.build();
        try {
            String result = converter.convert();
            //Log.d(Config.TAG, result);
        } catch (InvalidSeparatorException | InvalidPrecisionException | InvalidDelimiterException e) {
            e.printStackTrace();
        }
    }

}
