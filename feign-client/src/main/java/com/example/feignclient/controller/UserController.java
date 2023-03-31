package com.example.feignclient.controller;

import com.example.feignclient.clients.UserClient;
import com.example.model.UserRequest;
import com.example.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserClient userClient;

    public UserController(UserClient userClient) {
        this.userClient = userClient;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(UserRequest user) {
        return userClient.createUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        return userClient.deleteUserById(id);
    }

    @GetMapping("all")
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        return userClient.findAllUsers();
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable Long id) {
       return userClient.findUserById(id);
    }

    @PutMapping({"{id}"})
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest user) {
        return userClient.updateUser(id, user);
    }
}
