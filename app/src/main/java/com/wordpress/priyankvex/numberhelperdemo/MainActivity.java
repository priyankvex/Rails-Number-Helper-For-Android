package com.wordpress.priyankvex.numberhelperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wordpress.priyankvex.numberhelper.Config;
import com.wordpress.priyankvex.numberhelper.NumberToRoundedConverter;
import com.wordpress.priyankvex.numberhelper.builders.NumberToRoundedConverterBuilder;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidDelimiterException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidPrecisionException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidSeparatorException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Building NumberToCurrencyConverter class instance using builder
        NumberToRoundedConverterBuilder builder = new NumberToRoundedConverterBuilder(23434.9454);
        builder.setDelimiter(",");
        builder.setPrecision("2");
        NumberToRoundedConverter converter = builder.build();

        try {
            String result = converter.convert();
            Log.d(Config.TAG, result);
        } catch (InvalidSeparatorException
                | InvalidPrecisionException | InvalidDelimiterException e) {
            e.printStackTrace();
        }
    }

}
