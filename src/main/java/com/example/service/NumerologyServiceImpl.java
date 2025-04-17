package com.example.service;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.UserDto;
import com.example.exception.ProfileNotFoundException;
import com.example.mapper.NumerologyMapper;
import com.example.model.NumerologyProfile;
import com.example.model.User;
import com.example.repository.ProfileRepository;
import com.example.repository.UserRepository;
import com.example.utils.NumerologyCalculator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NumerologyServiceImpl implements NumerologyService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final NumerologyMapper numerologyMapper;

    public NumerologyServiceImpl(UserRepository userRepository,
                                 ProfileRepository profileRepository,
                                 NumerologyMapper numerologyMapper) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.numerologyMapper = numerologyMapper;
    }

    @Override
    public NumerologyProfileResponse generateAndSaveProfile(UserDto dto) {
        Optional<User> optionalUser = userRepository.findByFirstNameAndLastNameAndBirthYearAndBirthMonthAndBirthDay(
                dto.firstName(), dto.lastName(), dto.birthYear(), dto.birthMonth(), dto.birthDay());

        User user = optionalUser.orElseGet(() -> userRepository.save(
                new User(dto.firstName(), dto.lastName(), dto.birthYear(), dto.birthMonth(), dto.birthDay())
        ));

        NumerologyProfile profile = NumerologyCalculator.generateProfile(user);
        profile.setUser(user);
        profileRepository.save(profile);

        return numerologyMapper.toDto(profile);
    }

    @Override
    public NumerologyProfileResponse findProfile(Long id) {
        NumerologyProfile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found with id: " + id));
        return numerologyMapper.toDto(profile);
    }

    @Override
    public List<NumerologyProfileResponse> findAllProfiles() {
        return profileRepository.findAll().stream()
                .map(numerologyMapper::toDto)
                .toList();
    }

    @Override
    public void deleteProfile(Long id) {
        if (!profileRepository.existsById(id)) {
            throw new ProfileNotFoundException("Profile not found with id: " + id);
        }
        profileRepository.deleteById(id);
    }

    @Override
    public NumerologyProfileResponse updateProfile(Long id, UserDto dto) {
        NumerologyProfile existing = profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found with id: " + id));

        User updatedUser = userRepository.save(new User(
                dto.firstName(),
                dto.lastName(),
                dto.birthYear(),
                dto.birthMonth(),
                dto.birthDay()
        ));

        NumerologyProfile updatedProfile = NumerologyCalculator.generateProfile(updatedUser);
        updatedProfile.setId(id); // păstrăm același ID
        updatedProfile.setUser(updatedUser);
        profileRepository.save(updatedProfile);

        return numerologyMapper.toDto(updatedProfile);
    }
}