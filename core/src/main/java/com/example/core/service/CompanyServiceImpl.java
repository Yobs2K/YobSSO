package com.example.core.service;

import com.example.core.exceptions.CompanyNotFoundException;
import com.example.db.entity.Company;
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
        return companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException());
    }
}
