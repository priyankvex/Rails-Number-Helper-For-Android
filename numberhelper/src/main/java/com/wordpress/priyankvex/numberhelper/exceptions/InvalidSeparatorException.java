package com.wordpress.priyankvex.numberhelper.exceptions;

/**
 * Created by Priyank(@priyankvex) on 30/9/15.
 * Custom exception for invalid separator.
 */
public class InvalidSeparatorException extends Exception{

    private String message;

    public InvalidSeparatorException(){
        super();
        this.message = "Invalid separator. You sure separator is not null?";
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
