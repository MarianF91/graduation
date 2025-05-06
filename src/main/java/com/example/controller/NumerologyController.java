package com.example.controller;

import com.example.dto.ProfileDto;
import com.example.model.MeaningType;
import com.example.service.MeaningService;
import com.example.service.NumerologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST gateway for operations related to:
 * <ul>
 *   <li> obtaining the meaning of a number;</li>
 *   <li> deleting one or all the profiles.</li>
 * </ul>
 * It's base path is: {@code /api/numerology}.
 */
@RestController
@RequestMapping("/api/numerology")
@RequiredArgsConstructor
public class NumerologyController {

    private final NumerologyService numerologyService;
    private final MeaningService   meaningService;

    /**
     * Returns the description of a number from a specific category
     * (e.g. {@code DESTINY}, {@code LIFE_PATH} etc.).
     *
     * @param number numerical value (1-9, 11, 22, 33…)
     * @param type   numerological category
     * @return {@link ProfileDto} with the number and its meaning
     */
    @GetMapping("/meaning")
    public ResponseEntity<ProfileDto> getMeaning(@RequestParam int number,
                                                 @RequestParam MeaningType type) {
        String text = meaningService.getMeaning(number, type);
        return ResponseEntity.ok(new ProfileDto(number, text));
    }

    /**
     * Erases a profile using its ID.
     *
     * @param id profile ID
     */
    @DeleteMapping("/profiles/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        numerologyService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Erases all the profiles and their associated users.
     */
    @DeleteMapping("/profiles")
    public ResponseEntity<Void> deleteAllProfiles() {
        numerologyService.deleteAllProfiles();
        return ResponseEntity.noContent().build();
    }
}