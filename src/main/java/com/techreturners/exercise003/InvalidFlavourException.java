package com.techreturners.exercise003;

public class InvalidFlavourException extends RuntimeException {
    public InvalidFlavourException(String errorMessage) {
        super(errorMessage);
    }
}
