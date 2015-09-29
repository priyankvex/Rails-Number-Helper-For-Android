package com.wordpress.priyankvex.numberhelper.exceptions;

/**
 * Created by Priyank(@priyankvex) on 30/9/15.
 * Custom exception for invalid precision.
 */
public class InvalidPrecisionException extends Exception{

    private String message;

    public InvalidPrecisionException(){
        super();
        this.message = "Invalid precision. You sure precision is a number?";
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
