package com.rpavliuk.calc.engine;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super("Invalid input: " + message);
    }
}
