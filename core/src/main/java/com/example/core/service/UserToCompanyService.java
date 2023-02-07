package com.example.core.service;

import com.example.db.entity.UserToCompany;

import java.util.Optional;

public interface UserToCompanyService {
    Optional<UserToCompany> findByCompanyIdAndUserId(Long userId, Long companyId);
}
