package com.example.departmentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DepartmentAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentAppApplication.class, args);
    }
}
