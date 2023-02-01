package com.example.db.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends AbstractBaseEntity<Long> {

    private String username;
    private String email;
    private String password;
    private boolean isBanned = false;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    @JoinTable(name = "user_to_company",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private Set<Company> companies;

    public Set<Company> getCompanies() {
        return companies;
    }

    public User setCompanies(Set<Company> companies) {
        this.companies = companies;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public User setBanned(boolean banned) {
        isBanned = banned;
        return this;
    }
}
