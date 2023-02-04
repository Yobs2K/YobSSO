package com.example.core.service;

import com.example.db.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyService {

    List<Company> getAll();

    Page<Company> getAllPageable(Pageable pageable);

    Company getById(Long id);
}
