package com.example.core.service.security;

import com.example.core.exceptions.UserNotFoundException;
import com.example.core.model.AuthUser;
import com.example.db.entity.User;
import com.example.db.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmailIgnoreCase(username)
                .orElseThrow(() -> new UserNotFoundException());

        return new AuthUser(user, Collections.emptyList());
    }
}
