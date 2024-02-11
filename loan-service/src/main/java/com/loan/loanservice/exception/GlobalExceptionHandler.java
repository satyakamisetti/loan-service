package com.loan.loanservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(LoanNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage loanNotFoundException(LoanNotFoundException ex ) {
        ErrorMessage message = new ErrorMessage(
                "4467", ex.getMessage());
        return message;
    }
    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage invalidinputException(InvalidInputException ex ) {
        ErrorMessage message = new ErrorMessage(
                "4468", ex.getMessage());
        return message;
    }
}
