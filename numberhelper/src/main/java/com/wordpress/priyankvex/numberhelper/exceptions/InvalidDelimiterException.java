package com.wordpress.priyankvex.numberhelper.exceptions;

/**
 * Created by Priyank(@priyankvex) on 30/9/15.
 * Custom exception for invalid delimiter.
 */
public class InvalidDelimiterException extends Exception{

    private String message;

    public InvalidDelimiterException(){
        super();
        this.message = "Invalid Delimiter. You sure separator is not null?";
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
