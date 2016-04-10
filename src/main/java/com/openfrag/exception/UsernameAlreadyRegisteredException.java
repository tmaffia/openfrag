package com.openfrag.exception;

/**
 * Created by tmaffia on 4/10/16.
 */
public class UsernameAlreadyRegisteredException extends Exception {

    public UsernameAlreadyRegisteredException() {}

    public UsernameAlreadyRegisteredException(String message) {
        super(message);
    }
}
