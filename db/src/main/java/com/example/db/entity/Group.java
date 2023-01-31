package com.example.db.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "group")
public class Group extends AbstractBaseEntity<Long>{

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "group_user",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();

    public void addUser(User user) {
        users.add(user);
        user.getGroups().add(this);
    }

    public void removeUser(User user) {
        users.remove(user);
        user.getGroups().remove(this);
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<User> getUsers() {
        return users;
    }
}
