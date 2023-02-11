package com.example.core.exception;

public class CompanyNotFoundException extends EntityNotFoundException {
    public CompanyNotFoundException() {
        super("Company entity not found.");
    }
}
