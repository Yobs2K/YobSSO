package com.example.db.repository;

import com.example.db.entity.Company;
import com.example.db.entity.enumerated.UserCompanyRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(
            value = "select c from company c " +
                    "inner join user_to_company on c.id = user_to_company.company_id " +
                    "where user_to_company.user_id = :userId"
            , nativeQuery = true
    )
    List<Company> findAllUserCompanies(Long userId);

    @Query(
            value = "select c from company c " +
                    "inner join user_to_company on c.id = user_to_company.company_id " +
                    "where user_to_company.user_id = :userId and user_to_company.user_role = :userRole"
            , nativeQuery = true
    )
    List<Company> findAllUserCompaniesByUserRole(Long userId, UserCompanyRole userRole);
}
