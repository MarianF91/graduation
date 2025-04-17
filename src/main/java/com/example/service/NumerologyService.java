package com.example.service;

import com.example.model.NumerologyProfile;
import com.example.model.User;
import com.example.repository.ProfileRepository;
import com.example.repository.UserRepository;
import com.example.utils.NumerologyCalculator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumerologyService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public NumerologyService(UserRepository userRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    public NumerologyProfile generateAndSaveProfile(User user) {
        userRepository.save(user);

        NumerologyProfile profile = NumerologyCalculator.generateProfile(user);
        profile.setUser(user);

        return profileRepository.save(profile);
    }

    public NumerologyProfile findProfile(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    public List<NumerologyProfile> findAllProfiles() {
        return profileRepository.findAll();
    }
}
