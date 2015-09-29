package com.wordpress.priyankvex.numberhelper.exceptions;

/**
 * Created by Priyank(@priyankvex) on 30/9/15.
 * Custom exception for invalid number.
 */
public class InvalidNumberException extends Exception{

    // The error message string
    private String message;

    public InvalidNumberException(){
        super();
        this.message = "Number is invalid. You sure number you entered is valid?";
    }

    public InvalidNumberException(String message){
        super(message);
        this.message = message;
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
