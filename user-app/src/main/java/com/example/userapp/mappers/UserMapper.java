package com.example.userapp.mappers;

import com.example.model.DepartmentResponse;
import com.example.model.UserFullResponse;
import com.example.model.UserRequest;
import com.example.model.UserShortResponse;
import com.example.userapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User fromRequest(UserRequest request);

    @Mapping(target = "userId", source = "id")
    @Mapping(target = "name", expression = "java(user.getFirstName() + \" \" + user.getLastName())")
    UserShortResponse toShortUserResponse(User user);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "name", source = "user.fullName")
    @Mapping(target = "department", source = "department")
    UserFullResponse toFullUserResponse(User user, DepartmentResponse department);
}
