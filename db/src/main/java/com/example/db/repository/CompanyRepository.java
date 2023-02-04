package com.example.db.repository;

import com.example.db.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    
    Page<Company> findAll(Pageable pageable);

}
