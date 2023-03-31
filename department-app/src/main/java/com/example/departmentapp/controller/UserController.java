package com.example.departmentapp.controller;

import com.example.departmentapp.model.User;
import com.example.departmentapp.service.UserService;
import com.example.grpc.UserServiceOuterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user/{id}")
    public User getUserById(@PathVariable String id) {
        UserServiceOuterClass.GrpcUserResponse userResponse = userService.findUserById(id);
        if (userResponse != null) {
            return User.builder().firstName(userResponse.getFirstName())
                    .lastName(userResponse.getLastName())
                    .age(userResponse.getAge()).build();
        }
        return null;
    }

}
