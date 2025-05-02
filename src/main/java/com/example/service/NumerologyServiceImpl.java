package com.example.service;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.UserDto;
import com.example.exception.ProfileNotFoundException;
import com.example.mapper.NumerologyMapper;
import com.example.mapper.UserMapper;
import com.example.model.NumerologyProfile;
import com.example.model.User;
import com.example.repository.ProfileRepository;
import com.example.repository.UserRepository;
import com.example.utils.NumerologyCalculator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "UserServiceImpl",
        description = "Service class - manages the logic for creating, searching and deleting numerological profiles")
@Service
@RequiredArgsConstructor
public class NumerologyServiceImpl implements NumerologyService {

    // Injecting the 3 necessary components
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final NumerologyMapper numerologyMapper;

    @Operation(summary = "Creates or returns a profile for a specific user")
    @Override
    public NumerologyProfileResponse calculateProfile(UserDto dto) {
        // Checks if the user already exists
        User user = userRepository
                .findByFirstNameAndLastNameAndBirthYearAndBirthMonthAndBirthDay(
                        dto.firstName(), dto.lastName(),
                        dto.birthYear(), dto.birthMonth(), dto.birthDay()
                )
                // If it's not there, then it's saved in to the db
                .orElseGet(() -> userRepository.save(UserMapper.toEntity(dto)));

        // Checks if the user has a numerological profile
        NumerologyProfile profile = profileRepository.findByUser(user)
                .orElseGet(() -> {
                    // Creates a profile if it doesn't find one for the specified user
                    NumerologyProfile newProfile = NumerologyCalculator.generateProfile(user);
                    return profileRepository.save(newProfile);
                });

        // Converts the entity in to a DTO object
        return numerologyMapper.toResponse(profile);
    }

    @Operation(summary = "Returns a profile using its ID")
    @Override
    public NumerologyProfileResponse findProfile(Long id) {
        NumerologyProfile p = profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found: " + id));
        return numerologyMapper.toResponse(p);
    }

    @Operation(summary = "Returns all the existing profiles as a DTO list")
    @Override
    public List<NumerologyProfileResponse> findAllProfiles() {
        return profileRepository.findAll().stream()
                .map(numerologyMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Erases a profile using its ID")
    @Override
    public void deleteProfile(Long id) {
        NumerologyProfile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found: " + id));
        profileRepository.delete(profile);
    }

    @Operation(summary = "Erases all profiles")
    @Override
    public void deleteAllProfiles() {
        profileRepository.findAll().forEach(profileRepository::delete);
    }
}