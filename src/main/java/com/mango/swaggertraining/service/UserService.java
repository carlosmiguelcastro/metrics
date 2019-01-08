package com.mango.swaggertraining.service;

import com.mango.swaggertraining.exception.NotFoundException;
import com.mango.swaggertraining.model.User;
import com.mango.swaggertraining.repository.UserRepository;
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
        List<User> allUsers = this.userRepository.findAll();
        if (allUsers.isEmpty()) {
            throw new NotFoundException("Could not found any user");
        }
        return allUsers;
    }

    public User getUser(long userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id " + userId));
    }

    public User updateUser(long userId, User user) {
        User oldUser = getUser(userId);
        oldUser.setName(user.getName());
        oldUser.setAge(user.getAge());
        return this.userRepository.save(oldUser);
    }

    public void deleteUser(long userId) {
        this.userRepository.deleteById(userId);
    }
}
