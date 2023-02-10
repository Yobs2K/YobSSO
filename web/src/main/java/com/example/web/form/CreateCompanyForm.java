package com.example.web.form;

public class CreateCompanyForm {

    private Long id;

    private String username;

    private String description;

    public Long getId() {
        return id;
    }

    public CreateCompanyForm setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CreateCompanyForm setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CreateCompanyForm setDescription(String description) {
        this.description = description;
        return this;
    }
}
