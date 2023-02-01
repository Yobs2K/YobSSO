package com.example.db.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company extends AbstractBaseEntity<Long>{

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "company_user",
        joinColumns = @JoinColumn(name = "company_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public Company setUsers(Set<User> users) {
        this.users = users;
        return this;
    }
}
