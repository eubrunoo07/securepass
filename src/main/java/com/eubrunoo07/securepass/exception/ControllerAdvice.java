package com.eubrunoo07.securepass.exception;

import com.eubrunoo07.securepass.exception.exceptions.EmailAlreadyExistsException;
import com.eubrunoo07.securepass.exception.exceptions.EmailAndUsernameAlreadyExistsException;
import com.eubrunoo07.securepass.exception.exceptions.PasswordFormatIsInvalidException;
import com.eubrunoo07.securepass.exception.exceptions.UsernameAlreadyExistsException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiError methodArgumentNotValidException(MethodArgumentNotValidException e){
        return new ApiError(e.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PasswordFormatIsInvalidException.class)
    public ApiError passwordFormatIsInvalidException(PasswordFormatIsInvalidException e){
        return new ApiError(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ApiError emailAlreadyExistsException(EmailAlreadyExistsException e){
        return new ApiError(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmailAndUsernameAlreadyExistsException.class)
    public ApiError emailAndUsernameAlreadyExistsException(EmailAndUsernameAlreadyExistsException e){
        return new ApiError(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ApiError usernameAlreadyExistsException(UsernameAlreadyExistsException e){
        return new ApiError(e.getMessage());
    }
}
