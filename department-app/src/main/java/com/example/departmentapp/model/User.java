package com.example.departmentapp.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;

    private LocalDateTime createdAt;

    private String firstName;

    private String lastName;

    private GenderEnum gender;

    private int age;
}
