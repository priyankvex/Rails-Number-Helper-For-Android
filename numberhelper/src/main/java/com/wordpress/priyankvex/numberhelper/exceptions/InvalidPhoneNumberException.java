package com.wordpress.priyankvex.numberhelper.exceptions;

/**
 * Created by Priyank(@priyankvex) on 2/10/15.
 * Custom exception for invalid phone number.
 */
public class InvalidPhoneNumberException extends Exception{

    // The error message string
    private String message;

    public InvalidPhoneNumberException(){
        super();
        this.message = "Phone Number is invalid. You sure phone number you entered is valid?";
    }

    public InvalidPhoneNumberException(String message){
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
