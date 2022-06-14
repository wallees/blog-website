package org.wallees.blogwebsite.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.wallees.blogwebsite.model.User;
import org.wallees.blogwebsite.web.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User getUserById(Long id);

    User findByEmail(String email);

    User findByUsername(String username);

    void save(UserRegistrationDto registration);

}