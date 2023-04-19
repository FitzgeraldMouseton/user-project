package com.example.userapp.controller.sync;

import com.example.api.UserApi;
import com.example.model.UserRequest;
import com.example.model.UserResponse;
import com.example.userapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<UserResponse> createUser(UserRequest user) {
        return ResponseEntity.ok(new UserResponse());
    }

    @Override
    public ResponseEntity<Void> deleteUserById(Long id) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @Override
    public ResponseEntity<UserResponse> findUserById(Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Override
    public ResponseEntity<UserResponse> updateUser(Long id, UserRequest user) {
        return ResponseEntity.ok(new UserResponse());
    }
}
