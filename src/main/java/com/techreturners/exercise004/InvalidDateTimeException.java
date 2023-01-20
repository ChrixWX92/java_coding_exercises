package com.techreturners.exercise004;

public class InvalidDateTimeException extends RuntimeException {
    public InvalidDateTimeException(String errorMessage) {
        super(errorMessage);
    }
}
