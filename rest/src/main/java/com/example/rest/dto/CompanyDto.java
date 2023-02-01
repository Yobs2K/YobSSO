package com.example.rest.dto;

import java.util.List;

public class CompanyDto {

    private Long id;

    private List<Long> userIds;

    public Long getId() {
        return id;
    }

    public CompanyDto setId(Long id) {
        this.id = id;
        return this;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public CompanyDto setUserIds(List<Long> userIds) {
        this.userIds = userIds;
        return this;
    }
}
