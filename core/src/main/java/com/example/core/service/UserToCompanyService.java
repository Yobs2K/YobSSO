package com.example.core.service;

import com.example.db.entity.UserToCompany;
import com.example.db.entity.enumerated.UserCompanyRole;

import java.util.Optional;

public interface UserToCompanyService {
    Optional<UserToCompany> findByCompanyIdAndUserId(Long userId, Long companyId);

    UserToCompany addUserToCompany(Long userId, Long companyId, UserCompanyRole userRole);
}
