package com.example.userapp.controller.sync;

import com.example.api.UserApi;
import com.example.model.UserFullResponse;
import com.example.model.UserRequest;
import com.example.model.UserShortResponse;
import com.example.userapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<UserFullResponse> createUser(UserRequest request) {
        return ResponseEntity.ok(userService.save(request));
    }

    @Override
    public ResponseEntity<Void> deleteUserById(Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserFullResponse> findUserById(Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Override
    public ResponseEntity<List<UserShortResponse>> findAllUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @Override
    public ResponseEntity<UserFullResponse> updateUser(Long id, UserRequest user) {
        return ResponseEntity.ok(new UserFullResponse());
    }
}
