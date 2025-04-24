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
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public NumerologyProfileResponse calculateProfile(UserDto dto) {
        User user = userRepository
                .findByFirstNameAndLastNameAndBirthYearAndBirthMonthAndBirthDay(
                        dto.firstName(), dto.lastName(),
                        dto.birthYear(), dto.birthMonth(), dto.birthDay()
                )
                .orElseGet(() -> userRepository.save(UserMapper.toEntity(dto)));

        NumerologyProfile profile = profileRepository.findByUser(user)
                .orElseGet(() -> {
                    NumerologyProfile newProfile = NumerologyCalculator.generateProfile(user);
                    return profileRepository.save(newProfile);
                });

        return numerologyMapper.toResponse(profile);
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

    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }

    @Override
    public void deleteAllProfiles() {
        profileRepository.deleteAll();
        userRepository.deleteAll();

        entityManager.createNativeQuery("ALTER SEQUENCE numerology_profile_id_seq RESTART WITH 1").executeUpdate();
        entityManager.createNativeQuery("ALTER SEQUENCE users_id_seq RESTART WITH 1").executeUpdate();
    }
}