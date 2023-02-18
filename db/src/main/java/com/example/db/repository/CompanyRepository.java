package com.example.db.repository;

import com.example.db.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(
            value = "select c.* from company c " +
                    "inner join user_to_company on c.id = user_to_company.company_id " +
                    "where user_to_company.user_id = :userId"
            , nativeQuery = true
    )
    Page<Company> findAllUserCompanies(Long userId, Pageable pageable);

    @Query(
            value = "select c.* from company c " +
                    "inner join user_to_company on c.id = user_to_company.company_id " +
                    "where user_to_company.user_id = :userId and user_to_company.user_role = :userRole"
            , nativeQuery = true
    )
    Page<Company> findAllUserCompaniesByUserRole(Long userId, String userRole, Pageable pageable);
}
