package com.example.core.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
        super("Entity not found.");
    }

    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
