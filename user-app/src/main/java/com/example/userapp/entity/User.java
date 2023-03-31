package com.example.userapp.entity;

import com.example.userapp.entity.enums.GenderEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private int id;

    private String firstName;

    private String lastName;

    private GenderEnum gender;

    private int age;
}
