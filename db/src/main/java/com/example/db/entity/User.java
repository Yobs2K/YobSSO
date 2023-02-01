package com.example.db.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends AbstractBaseEntity<Long> {

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Set<Company> companies = new HashSet<>();

    public Set<Company> getCompanies() {
        return companies;
    }

    public User setCompanies(Set<Company> companies) {
        this.companies = companies;
        return this;
    }
}
