package com.example.db.repository;

import com.example.db.entity.UserToCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserToCompanyRepository extends JpaRepository<UserToCompany, Long> {

    Optional<UserToCompany> findFirstByCompanyIdAndUserId(Long companyId, Long userId);
}
