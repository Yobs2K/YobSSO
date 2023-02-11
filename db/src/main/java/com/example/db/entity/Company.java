package com.example.db.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company extends AbstractBaseEntity<Long>{

    private String name;
    private String description;

    private Long ownerId;

    @ManyToMany(mappedBy = "companies", fetch = FetchType.LAZY)
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public Company setUsers(Set<User> users) {
        this.users = users;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Company setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public Company setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
        return this;
    }
}
