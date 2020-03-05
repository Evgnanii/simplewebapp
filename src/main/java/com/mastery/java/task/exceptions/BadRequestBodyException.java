package com.mastery.java.task.exceptions;

public class BadRequestBodyException extends RuntimeException {
    public BadRequestBodyException(String message) {
        super(message);
    }
}
