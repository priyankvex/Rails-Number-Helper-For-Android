package com.wordpress.priyankvex.numberhelper.exceptions;

/**
 * Created by Priyank(@priyankvex) on 30/9/15.
 * Custom exception for invalid unit.
 */
public class InvalidUnitException extends Exception{

    private String message;

    public InvalidUnitException(){
        super();
        this.message = "Invalid unit. You sure unit is not null?";
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
