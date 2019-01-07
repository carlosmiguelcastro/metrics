package com.mango.swaggertraining;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User add(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
