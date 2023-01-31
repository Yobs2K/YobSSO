package com.example.db.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends AbstractBaseEntity<Long> {

    @ManyToMany(mappedBy = "users")
    private Set<Company> companies = new HashSet<>();

    @ManyToMany(mappedBy = "users")
    private Set<Group> groups = new HashSet<>();

    public Set<Company> getCompanies() {
        return companies;
    }

    public Set<Group> getGroups() {
        return groups;
    }
}
