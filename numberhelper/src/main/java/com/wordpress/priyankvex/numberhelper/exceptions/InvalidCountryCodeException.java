package com.wordpress.priyankvex.numberhelper.exceptions;

/**
 * Created by Priyank(@priyankvex) on 1/10/15.
 * Custom exception for invalid country code.
 */
public class InvalidCountryCodeException extends Exception{

    private String message;

    public InvalidCountryCodeException(){
        super();
        this.message = "Invalid country code. You are country code is valid?";
    }

    @Override
    public String toString() {
        return this.message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
