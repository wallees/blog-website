package org.wallees.blogwebsite.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.wallees.blogwebsite.model.User;
import org.wallees.blogwebsite.web.UserRegistrationDto;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User findByUsername(String username);

    User save(UserRegistrationDto registration);

}