package com.example.departmentapp.controller;

import com.example.departmentapp.feignclient.UserClient;
import com.example.departmentapp.service.DepartmentService;
import com.example.model.DepartmentResponse;
import com.example.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private final UserClient userClient;
    private final DepartmentService departmentService;

    @GetMapping("all")
    public ResponseEntity<List<DepartmentResponse>> getDepartments() {
        List<DepartmentResponse> departments = departmentService.getDepartments();
        List<UserResponse> users = userClient.findAllUsers().getBody();
        return ResponseEntity.ok(departments);
    }
}

