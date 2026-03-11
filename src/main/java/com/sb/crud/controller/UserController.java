package com.sb.crud.controller;

import com.sb.crud.entity.User;
import com.sb.crud.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "User Management", description = "Operations for User entities")
public class UserController {

    @Autowired
    public UserService userService;

    @Operation(summary = "Get all users", description = "Returns a all user object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.finduser();
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @Operation(summary = "Get user by ID", description = "update a single user object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer id) {
        User u = userService.updateUser(user, id);
        return ResponseEntity.ok(u);
    }

    @DeleteMapping("/user/{id}")
    public void updateUser(@PathVariable Integer id) {
        User u = userService.delateUser(id);
    }
}
