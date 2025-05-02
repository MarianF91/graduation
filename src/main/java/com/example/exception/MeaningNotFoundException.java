package com.example.exception;

public class MeaningNotFoundException extends RuntimeException {
    public MeaningNotFoundException(int number, Enum<?> type) {
        super("No meaning found for " + number + " (" + type + ")");
    }
}