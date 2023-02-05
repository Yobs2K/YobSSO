package com.example.core.service;

import com.example.db.entity.UserToCompany;
import com.example.db.repository.UserToCompanyRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserToCompanyServiceImpl implements  UserToCompanyService{
    private final UserToCompanyRepository userToCompanyRepository;

    @Autowired
    public UserToCompanyServiceImpl(UserToCompanyRepository userToCompanyRepository) {
        this.userToCompanyRepository = userToCompanyRepository;
    }

    @Override
    public Optional<UserToCompany> findByCompanyIdAndUserId(@NotNull Long userId,@NotNull Long companyId) {
        return userToCompanyRepository.findFirstByCompanyIdAndUserId(userId, companyId);
    }
}
