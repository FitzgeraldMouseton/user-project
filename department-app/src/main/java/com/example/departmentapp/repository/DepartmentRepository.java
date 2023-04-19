package com.example.departmentapp.repository;

import com.example.departmentapp.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, String> {

}
