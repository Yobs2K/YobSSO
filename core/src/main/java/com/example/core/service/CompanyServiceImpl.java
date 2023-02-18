package com.example.core.service;

import com.example.core.exception.CompanyNotFoundException;
import com.example.db.entity.Company;
import com.example.db.entity.enumerated.UserCompanyRole;
import com.example.db.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(
            CompanyRepository companyRepository
    ) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public Page<Company> getAllPageable(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    public Company getById(Long id) {
        return companyRepository.findById(id).orElseThrow(CompanyNotFoundException::new);
    }

    @Override
    public Page<Company> findAllUserCompaniesByUserId(Long userId, Pageable pageable) {
        return companyRepository.findAllUserCompanies(userId, pageable);
    }

    @Override
    public Page<Company> findAllUserCompaniesByUserIdAndRole(Long userId, UserCompanyRole userRole, Pageable pageable) {
        return companyRepository.findAllUserCompaniesByUserRole(userId, userRole.name(), pageable);
    }

    @Override
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company deleteCompanyById(Long id) {
        Company deletingCompany = companyRepository.findById(id).orElseThrow(CompanyNotFoundException::new);
        companyRepository.delete(deletingCompany);
        return deletingCompany;
    }
}
