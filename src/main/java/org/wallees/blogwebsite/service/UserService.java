package org.wallees.blogwebsite.service;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.wallees.blogwebsite.model.User;
import org.wallees.blogwebsite.web.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User findByUsername(String username);

    void save(UserRegistrationDto registration);

//    Colin adding this 6/13
    Page<User> findPaginated(int pageNo, int pageSize);
}