package com.example.departmentapp.mappers;

import com.example.departmentapp.DepartmentFullResponseGrpc;
import com.example.departmentapp.DepartmentResponseGrpc;
import com.example.departmentapp.model.Department;
import com.example.model.DepartmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentResponseGrpc toResponseGrpc(Department department);

    DepartmentFullResponseGrpc toFullResponseGrpc(Department department);

    @Mapping(target = "departmentId", source = "id")
    DepartmentResponse toDto(Department department);
}
