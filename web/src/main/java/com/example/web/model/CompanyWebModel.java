package com.example.web.model;

public class CompanyWebModel extends BaseWebModel<CompanyWebModel> {

    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public CompanyWebModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CompanyWebModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
