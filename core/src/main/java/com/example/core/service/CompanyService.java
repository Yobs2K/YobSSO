package com.example.core.service;

import com.example.db.entity.Company;
import com.example.db.entity.enumerated.UserCompanyRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyService {

    List<Company> getAll();

    Page<Company> getAllPageable(Pageable pageable);

    Company getById(Long id);

    Page<Company> findAllUserCompaniesByUserId(Long userId, Pageable pageable);

    Page<Company> findAllUserCompaniesByUserIdAndRole(Long userId, UserCompanyRole userRole, Pageable pageable);

    Company addCompany(Company company);

    Company deleteCompanyById(Long id);
}
