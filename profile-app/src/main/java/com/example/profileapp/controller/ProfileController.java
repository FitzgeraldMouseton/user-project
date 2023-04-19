package com.example.profileapp.controller;

import com.example.profileapp.model.dto.ProfileRequest;
import com.example.profileapp.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("add")
    public void createProfile(ProfileRequest request) {
        profileService.createProfile(request);
    }

}
