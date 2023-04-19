package com.example.userapp.entity.dto;

import lombok.Data;

@Data
public class ProfileResponse {

    private String id;

    private String userId;

    private String login;

    private String password;

    private String image;
}
