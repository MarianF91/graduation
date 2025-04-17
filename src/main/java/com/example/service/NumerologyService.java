package com.example.service;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.UserDto;

import java.util.List;

public interface NumerologyService {

    NumerologyProfileResponse generateAndSaveProfile(UserDto dto);

    NumerologyProfileResponse findProfile(Long id);

    List<NumerologyProfileResponse> findAllProfiles();

    void deleteProfile(Long id);

    NumerologyProfileResponse updateProfile(Long id, UserDto dto);

}