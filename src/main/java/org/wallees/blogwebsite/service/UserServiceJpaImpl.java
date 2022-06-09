package org.wallees.blogwebsite.service;

import org.wallees.blogwebsite.model.User;
import org.wallees.blogwebsite.repository.UserRepository;
import org.wallees.blogwebsite.service.UserServiceJpaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UserServiceJpaImpl implements UserService {

@Autowired
private UserRepository userRepo;

@Override
public List<User> findAll() {
return this.userRepo.findAll();
}

@Override
public User findById(Long id) {
return this.userRepo.findById(id).get();
}

@Override
public User create(User user) {
return this.userRepo.save(user);
}

@Override
public User edit(User user) {
return this.userRepo.save(user);
}

@Override
public void deleteById(Long id) {
this.userRepo.deleteById(id);
}

}
