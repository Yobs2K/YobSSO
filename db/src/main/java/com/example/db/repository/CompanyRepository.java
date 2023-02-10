package com.example.db.repository;

import com.example.db.entity.Company;
import com.example.db.entity.enumerated.UserCompanyRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("select c from Company c inner join UserToCompany uc where uc.userId = :userId and uc.userRole = :userRole")
    List<Company> findAllByUserIdIsAndUserRoleIs(Long userId, UserCompanyRole userRole);
}
