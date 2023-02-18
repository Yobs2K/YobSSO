package com.example.core.service;

import com.example.core.exception.CompanyNotFoundException;
import com.example.core.exception.UserNotFoundException;
import com.example.core.exception.UserToCompanyNotFoundException;
import com.example.db.entity.Company;
import com.example.db.entity.User;
import com.example.db.entity.UserToCompany;
import com.example.db.entity.enumerated.UserCompanyRole;
import com.example.db.repository.CompanyRepository;
import com.example.db.repository.UserRepository;
import com.example.db.repository.UserToCompanyRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserToCompanyServiceImpl implements  UserToCompanyService{
    private final UserToCompanyRepository userToCompanyRepository;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public UserToCompanyServiceImpl(
            UserToCompanyRepository userToCompanyRepository,
            UserRepository userRepository,
            CompanyRepository companyRepository
    ) {
        this.userToCompanyRepository = userToCompanyRepository;
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public Optional<UserToCompany> findByCompanyIdAndUserId(@NotNull Long userId,@NotNull Long companyId) {
        return userToCompanyRepository.findFirstByCompanyIdAndUserId(companyId, userId);
    }

    @Override
    public UserToCompany addUserToCompany(@NotNull Long userId, @NotNull Long companyId, UserCompanyRole userRole) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        Company company = companyRepository.findById(companyId).orElseThrow(CompanyNotFoundException::new);
        userRepository.save(user.addCompany(company));
        UserToCompany userToCompany = userToCompanyRepository
                .findFirstByCompanyIdAndUserId(companyId, userId)
                .orElseThrow(UserToCompanyNotFoundException::new); // Добавить Exception
        userToCompany.setUserRole(userRole);
        return userToCompanyRepository.save(userToCompany);
    }
}
