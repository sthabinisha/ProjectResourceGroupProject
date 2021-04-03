package com.itlize.res.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {

        super(message);
    }
}
