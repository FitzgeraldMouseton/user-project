package com.example.userapp.service;

import com.example.model.DepartmentResponse;
import com.example.model.UserFullResponse;
import com.example.model.UserRequest;
import com.example.model.UserShortResponse;
import com.example.userapp.DepartmentResponseGrpc;
import com.example.userapp.entity.User;
import com.example.userapp.mappers.UserMapper;
import com.example.userapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final DepartmentService departmentService;

    public UserFullResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->  new EntityNotFoundException(String.format("User with id = %d not found", id)));
        return UserMapper.INSTANCE.toFullUserResponse(user, getDepartment(user));
    }

    public List<UserShortResponse> findAll() {
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(UserMapper.INSTANCE::toShortUserResponse)
                .collect(Collectors.toList());
    }

    public UserFullResponse updateUser(Long id, UserRequest request) {
        getUserById(id);
        User user = userRepository.save(UserMapper.INSTANCE.fromRequest(request));
        return UserMapper.INSTANCE.toFullUserResponse(user, getDepartment(user));
    }

    public UserFullResponse save(UserRequest request) {
        User user = userRepository.save(UserMapper.INSTANCE.fromRequest(request));
        return UserMapper.INSTANCE.toFullUserResponse(user, getDepartment(user));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Nullable
    private DepartmentResponse getDepartment(User user) {
        DepartmentResponseGrpc department = null;
        if (user != null && user.getDepartmentId() != null) {
            department = departmentService.getDepartment(user.getDepartmentId());
        }
        // TODO что-то не понятно пока, как мапить mapstruct'ом джиэрписишные сущности
        DepartmentResponse response = new DepartmentResponse();
        if (department != null) {
            response.setDepartmentId(department.getId());
            response.setName(department.getName());
        }
        return response;
    }

//    @KafkaListener(topics = "profile", groupId = "profile-group")
//    public void listenProfileGroup(String message) {
//        System.out.println("Message" + message);
//    }
}
