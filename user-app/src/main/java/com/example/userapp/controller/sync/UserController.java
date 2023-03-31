package com.example.userapp.controller.sync;

import com.example.api.UserApi;
import com.example.model.UserRequest;
import com.example.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {

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
        return ResponseEntity.ok().body(List.of(new UserResponse(), new UserResponse()));
    }

    @Override
    public ResponseEntity<UserResponse> findUserById(Long id) {
        return ResponseEntity.ok(new UserResponse());
    }

    @Override
    public ResponseEntity<UserResponse> updateUser(Long id, UserRequest user) {
        return ResponseEntity.ok(new UserResponse());
    }
}
