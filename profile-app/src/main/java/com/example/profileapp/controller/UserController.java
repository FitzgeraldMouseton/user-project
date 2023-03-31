package com.example.profileapp.controller;

import com.example.departmentapp.model.User;
import com.example.profileapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("user/{id}")
    public User getUserById(@PathVariable String id) {
        return null;
    }

}
