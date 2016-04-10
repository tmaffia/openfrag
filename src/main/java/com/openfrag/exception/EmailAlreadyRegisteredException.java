package com.openfrag.exception;

/**
 * Created by tmaffia on 4/10/16.
 */
public class EmailAlreadyRegisteredException extends Exception {

    public EmailAlreadyRegisteredException() {}

    public EmailAlreadyRegisteredException(String message) {
        super(message);
    }
}
