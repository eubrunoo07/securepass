package com.eubrunoo07.securepass.exception.exceptions;

public class PasswordNotFoundException extends RuntimeException{
    public PasswordNotFoundException(String message) {
        super(message);
    }
}
