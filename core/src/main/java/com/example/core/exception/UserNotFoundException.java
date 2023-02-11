package com.example.core.exception;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException() {
        super("User entity not found.");
    }
}
