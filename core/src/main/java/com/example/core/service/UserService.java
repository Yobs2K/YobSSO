package com.example.core.service;

import com.example.db.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    List<User> getAll();

    Page<User> getAllPageable(Pageable pageable);

    User getById(Long id);

    User addUser(User user);
}
