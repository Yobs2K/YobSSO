package com.example.core.service;

import com.example.db.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    Company getCompanyById(Long id);
}
