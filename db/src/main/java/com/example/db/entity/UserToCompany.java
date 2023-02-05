package com.example.db.entity;

import com.example.db.entity.enumerated.UserCompanyRole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name= "user_to_company")
public class UserToCompany extends AbstractBaseEntity<Long> {

    @Column(name = "company_id", insertable = false, updatable = false)
    private Long companyId;
    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;
    @Enumerated
    private UserCompanyRole userRole;

    public Long getCompanyId() {
        return companyId;
    }

    public UserToCompany setCompanyId(Long companyId) {
        this.companyId = companyId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserToCompany setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public UserCompanyRole getUserRole() {
        return userRole;
    }

    public UserToCompany setUserRole(UserCompanyRole userRole) {
        this.userRole = userRole;
        return this;
    }
}
