package com.example.userapp.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {

    private Integer id;

    private String email;

    private User user;
}
