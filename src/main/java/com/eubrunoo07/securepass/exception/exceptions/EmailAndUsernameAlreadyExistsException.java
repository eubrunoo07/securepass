package com.eubrunoo07.securepass.exception.exceptions;

public class EmailAndUsernameAlreadyExistsException extends RuntimeException{
    public EmailAndUsernameAlreadyExistsException(String message) {
        super(message);
    }
}
