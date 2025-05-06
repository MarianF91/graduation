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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Business-layer component which orchestrates all operations on the entity {@code NumerologyProfile}
 * (create, search, delete)
 *
 * <p> Is used internally by the controllers. It does not expose HTTP endpoints directly.</p>
 *
 * @implNote <ul>
 *   <li> The class is {@code @Transactional(readOnly = true)} – by default, all the operations are non-mutative
 *       All the methods which write in the DB, override, at method level, with {@code readOnly = false}.</li>
 *   <li> All the Entity ↔ DTO conversions are made through {@link NumerologyMapper} /
 *       {@link UserMapper} in order to maintain a strict separation between layers.</li>
 * </ul>
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class NumerologyServiceImpl implements NumerologyService {

    private final UserRepository     userRepository;
    private final ProfileRepository  profileRepository;
    private final NumerologyMapper   numerologyMapper;

    /** Creates or returns a profile for a user from {@code dto}. */
    @Override
    @Transactional
    public NumerologyProfileResponse calculateProfile(UserDto dto) {

        // 1.  Searches or saves a user
        User user = userRepository
                .findByFirstNameAndLastNameAndBirthYearAndBirthMonthAndBirthDay(
                        dto.firstName(), dto.lastName(),
                        dto.birthYear(), dto.birthMonth(), dto.birthDay())
                .orElseGet(() -> userRepository.save(UserMapper.toEntity(dto)));

        // 2.  Searches or generates a profile
        NumerologyProfile profile = profileRepository.findByUser(user)
                .orElseGet(() -> profileRepository.save(
                        NumerologyCalculator.generateProfile(user)));

        // 3.  Mapping towards DTO for a respons
        return numerologyMapper.toResponse(profile);
    }

    /** Returns a profile using its ID or throws {@link ProfileNotFoundException}. */
    @Override
    public NumerologyProfileResponse findProfile(Long id) {
        NumerologyProfile p = profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found: " + id));
        return numerologyMapper.toResponse(p);
    }

    /** Prints all existing profiles. */
    @Override
    public List<NumerologyProfileResponse> findAllProfiles() {
        return profileRepository.findAll().stream()
                .map(numerologyMapper::toResponse)
                .toList();
    }

    /** Erases a profile using its ID. */
    @Override
    @Transactional
    public void deleteProfile(Long id) {
        NumerologyProfile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found: " + id));
        profileRepository.delete(profile);
    }

    /** Deletes all the profiles in the db (bulk delete). */
    @Override
    @Transactional
    public void deleteAllProfiles() {
        profileRepository.deleteAllInBatch();
    }
}