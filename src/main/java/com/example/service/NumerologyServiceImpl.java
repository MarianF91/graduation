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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NumerologyServiceImpl implements NumerologyService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final NumerologyMapper numerologyMapper;
    private final UserMapper userMapper;

    @Override
    public NumerologyProfileResponse calculateProfile(UserDto dto) {
        User user = userRepository
                .findByFirstNameAndLastNameAndBirthYearAndBirthMonthAndBirthDay(
                        dto.firstName(), dto.lastName(),
                        dto.birthYear(), dto.birthMonth(), dto.birthDay()
                ).orElseGet(() ->
                        userRepository.save(userMapper.toEntity(dto))
                );

        NumerologyProfile profile = NumerologyCalculator.generateProfile(user);
        NumerologyProfile saved   = profileRepository.save(profile);
        return numerologyMapper.toResponse(saved);
    }

    @Override
    public NumerologyProfileResponse findProfile(Long id) {
        NumerologyProfile p = profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found: " + id));
        return numerologyMapper.toResponse(p);
    }

    @Override
    public List<NumerologyProfileResponse> findAllProfiles() {
        return profileRepository.findAll().stream()
                .map(numerologyMapper::toResponse)
                .collect(Collectors.toList());
    }
}
