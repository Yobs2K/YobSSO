package com.example.db.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company extends AbstractBaseEntity<Long>{

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "company_user",
        joinColumns = @JoinColumn(name = "company_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();

    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Group> groups = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
        user.getCompanies().add(this);
    }

    public void removeUser(User user) {
        users.remove(user);
        user.getCompanies().remove(this);
    }

    public void addGroup(Group group) {
        groups.add(group);
        group.setCompany(this);
    }

    public void removeGroup(Group group) {
        groups.remove(group);
        group.setCompany(null);
    }

    public Set<User> getUsers() {
        return users;
    }

    public List<Group> getGroups() {
        return groups;
    }
}
