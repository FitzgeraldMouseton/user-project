package com.example.profileapp.service;

import com.example.profileapp.mappers.ProfileMapper;
import com.example.profileapp.model.Profile;
import com.example.profileapp.model.dto.ProfileRequest;
import com.example.profileapp.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void createProfile(ProfileRequest request) {
        Profile profile = ProfileMapper.INSTANCE.fromRequest(request);
            kafkaTemplate.send("profile", profile);
    }
}
