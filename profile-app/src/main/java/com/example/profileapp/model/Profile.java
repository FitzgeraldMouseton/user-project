package com.example.profileapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document
public class Profile {

    @Id
    private String id;

    private String userId;

    private String login;

    private String password;

    private String image;

    private LocalDateTime createdAt;

    private LocalDateTime lastVisitedAt;
}
