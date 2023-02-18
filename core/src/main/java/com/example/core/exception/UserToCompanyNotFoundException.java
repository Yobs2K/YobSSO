package com.example.core.exception;

public class UserToCompanyNotFoundException extends EntityNotFoundException{

    public UserToCompanyNotFoundException() {
        super("UserToCompany entity not found.");
    }
}
