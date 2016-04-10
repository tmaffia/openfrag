package com.openfrag.exception;

/**
 * Created by tmaffia on 4/10/16.
 */
public class InvalidPasswordException extends Exception {

    public InvalidPasswordException() {}

    public InvalidPasswordException(String message) {
        super(message);
    }

}
