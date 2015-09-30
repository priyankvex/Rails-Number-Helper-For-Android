package com.wordpress.priyankvex.numberhelperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wordpress.priyankvex.numberhelper.Config;
import com.wordpress.priyankvex.numberhelper.NumberToDelimitedConverter;
import com.wordpress.priyankvex.numberhelper.builders.NumberToDelimitedConverterBuilder;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidDelimiterException;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidSeparatorException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Building NumberToCurrencyConverter class instance using builder
        NumberToDelimitedConverterBuilder builder = new NumberToDelimitedConverterBuilder(23434.9454);
        builder.setDelimiter(",");
        NumberToDelimitedConverter converter = builder.build();
        try {
            String result = converter.convert();
            Log.d(Config.TAG, result);
        } catch (InvalidSeparatorException | InvalidDelimiterException e) {
            e.printStackTrace();
        }
    }

}
