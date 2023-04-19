package com.example.userapp.service;

import com.example.model.UserResponse;
import com.example.userapp.DepartmentResponseGrpc;
import com.example.userapp.entity.User;
import com.example.userapp.mappers.UserMapper;
import com.example.userapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final DepartmentService departmentService;

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        DepartmentResponseGrpc department = null;
        if (user != null && user.getDepartmentId() != null) {
            department = departmentService.getDepartment(user.getDepartmentId());
        }
        return UserMapper.INSTANCE.toFullUserResponse(user, department);
    }

    public List<UserResponse> findAll() {
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(UserMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @KafkaListener(topics = "profile", groupId = "profile-group")
    public void listenProfileGroup(String message) {
        System.out.println("Message" + message);
    }
}
