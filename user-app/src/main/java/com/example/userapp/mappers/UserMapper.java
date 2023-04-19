package com.example.userapp.mappers;

import com.example.model.UserResponse;
import com.example.userapp.DepartmentResponseGrpc;
import com.example.userapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "userId", source = "id")
    UserResponse toDTO(User user);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "name", source = "user.fullName")
    UserResponse toFullUserResponse(User user, DepartmentResponseGrpc department);
}
