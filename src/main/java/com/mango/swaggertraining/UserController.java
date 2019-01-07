package com.mango.swaggertraining;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return this.userService.getAllUsers();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return this.userService.add(user);
    }
}
