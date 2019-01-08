package com.mango.swaggertraining.controller;

import com.mango.swaggertraining.exception.ApiError;
import com.mango.swaggertraining.model.User;
import com.mango.swaggertraining.service.UserService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "User", tags = "User")
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Get all users", response = User.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Unauthorized", response = ApiError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = ApiError.class),
            @ApiResponse(code = 404, message = "Not Found", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class)
    })
    @GetMapping("/users")
    public List<User> getUsers() {
        return this.userService.getAllUsers();
    }

    @ApiOperation(value = "Get an user", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Unauthorized", response = ApiError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = ApiError.class),
            @ApiResponse(code = 404, message = "Not Found", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class)
    })
    @GetMapping("/users/{userId}")
    public User getUser(@ApiParam(value = "The ID of the user", required = true)
                        @PathVariable("userId") long userId) {
        return this.userService.getUser(userId);
    }

    @ApiOperation(value = "Add an user", response = User.class)
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return this.userService.add(user);
    }

    @ApiOperation(value = "Update an user", response = User.class)
    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable("userId") long userId, @RequestBody User user) {
        return this.userService.updateUser(userId, user);
    }

    @ApiOperation(value = "Delete an user", response = User.class)
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") long userId) {
        this.userService.deleteUser(userId);
    }
}
