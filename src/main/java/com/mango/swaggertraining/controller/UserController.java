package com.mango.swaggertraining.controller;

import com.mango.swaggertraining.model.User;
import com.mango.swaggertraining.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable("userId") long userId) {
        return this.userService.getUser(userId);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return this.userService.add(user);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable("userId") long userId, @RequestBody User user) {
        return this.userService.updateUser(userId, user);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") long userId) {
        this.userService.deleteUser(userId);
    }
}
