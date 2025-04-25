package com.example.controller;

import com.example.dto.ProfileDto;
import com.example.model.MeaningType;
import com.example.service.MeaningService;
import com.example.service.NumerologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// controller for "Meaning" type operations and profile deletion

@RestController
@RequestMapping("/api/numerology")
@RequiredArgsConstructor
public class NumerologyController {

    private final NumerologyService numerologyService;
    private final MeaningService meaningService;

    // returns the description of a number, depending on its type (e.g.: DESTINY, LIFE_PATH etc.)
    @GetMapping("/meaning")
    public ResponseEntity<ProfileDto> getMeaning(
            @RequestParam int number,
            @RequestParam MeaningType type
    ) {
        String text = meaningService.getMeaning(number, type);
        return ResponseEntity.ok(new ProfileDto(number, text));
    }

    // deletes a profile in accordance with it's id
    @DeleteMapping("/profiles/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        numerologyService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }

    // deletes all profiles and their users
    @DeleteMapping("/profiles")
    public ResponseEntity<Void> deleteAllProfiles() {
        numerologyService.deleteAllProfiles();
        return ResponseEntity.noContent().build();
    }
}