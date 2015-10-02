package com.wordpress.priyankvex.numberhelperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wordpress.priyankvex.numberhelper.Config;
import com.wordpress.priyankvex.numberhelper.NumberToPhoneConverter;
import com.wordpress.priyankvex.numberhelper.builders.NumberToPhoneConverterBuilder;
import com.wordpress.priyankvex.numberhelper.exceptions.InvalidCountryCodeException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Building NumberToCurrencyConverter class instance using builder
        NumberToPhoneConverterBuilder builder = new NumberToPhoneConverterBuilder(9685587861l);
        NumberToPhoneConverter converter = builder.build();
        try {
            String result = converter.convert();
            Log.d(Config.TAG, result);
        } catch (InvalidCountryCodeException e) {
            e.printStackTrace();
        }
    }

}
