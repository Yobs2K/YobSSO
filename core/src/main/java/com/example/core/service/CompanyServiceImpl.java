package com.example.core.service;

import com.example.core.exceptions.CompanyNotFoundException;
import com.example.core.exceptions.UserNotFoundException;
import com.example.db.entity.Company;
import com.example.db.entity.User;
import com.example.db.entity.enumerated.UserCompanyRole;
import com.example.db.repository.CompanyRepository;
import com.example.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;

    private final UserRepository userRepository;

    @Autowired
    public CompanyServiceImpl(
            CompanyRepository companyRepository,
            UserRepository userRepository
    ) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public Page<Company> getAllPageable(Pageable pageable) {
        return companyRepository.findAllPageable(pageable);
    }

    public Company getById(Long id) {
        return companyRepository.findById(id).orElseThrow(CompanyNotFoundException::new);
    }

    @Override
    public List<Company> findAllUserCompaniesByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return new ArrayList<>(user.getCompanies());
    }

    @Override
    public List<Company> findAllUserIsAdminCompaniesByUserId(Long userId) {
        return companyRepository.findAllByUserIdIsAndUserRoleIs(userId, UserCompanyRole.ADMIN);
    }

    @Override
    public Company addCompany(Company company) {
        if (companyRepository.existsById(company.getId()))
            throw new RuntimeException("Company with that ID already exists");
        if (companyRepository.findByNameIgnoreCase(company.getName()).isPresent())
            throw new RuntimeException("Company with that name already exists");
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Company newCompany, Long id) {
        Company oldCompany = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Company with that ID"));
        if (!oldCompany.getName().equalsIgnoreCase(newCompany.getName()) &&
                companyRepository.existsByName(newCompany.getName()))
            throw new RuntimeException("Company with that name already exists");
        oldCompany
                .setName(newCompany.getName())
                .setDescription(newCompany.getDescription());
        return companyRepository.save(oldCompany);
    }

    @Override
    public Company deleteCompanyById(Long id) {
        Company deletingCompany = companyRepository.findById(id).orElseThrow(CompanyNotFoundException::new);
        companyRepository.delete(deletingCompany);
        return deletingCompany;
    }

    @Override
    public Company addUserToCompanyByIds(Long userId, Long companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(CompanyNotFoundException::new);
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        company.addUser(user);
        return companyRepository.save(company);
    }
}
