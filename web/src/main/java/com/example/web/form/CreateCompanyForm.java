package com.example.web.form;

public class CreateCompanyForm {

    private Long id;

    private String name;

    private String description;

    public Long getId() {
        return id;
    }

    public CreateCompanyForm setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreateCompanyForm setName(String name) {
        this.name = name;
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
