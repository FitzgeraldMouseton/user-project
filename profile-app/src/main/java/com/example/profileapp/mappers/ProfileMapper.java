package com.example.profileapp.mappers;

import com.example.profileapp.model.Profile;
import com.example.profileapp.model.dto.ProfileRequest;
import com.example.profileapp.model.dto.ProfileResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfileMapper {

    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    ProfileResponse toDto(Profile profile);

    Profile fromRequest(ProfileRequest request);
}
