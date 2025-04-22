package com.example.controller;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.ProfileDto;
import com.example.dto.UserDto;
import com.example.model.MeaningType;
import com.example.service.NumerologyService;
import com.example.service.MeaningService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class NumerologyController {

    private final NumerologyService numerologyService;
    private final MeaningService meaningService;

    public NumerologyController(NumerologyService numerologyService,
                                MeaningService meaningService) {
        this.numerologyService = numerologyService;
        this.meaningService = meaningService;
    }

    @Operation(summary = "Generates and saves a user's numerology profile.")
    @PostMapping
    public ResponseEntity<NumerologyProfileResponse> create(@RequestBody UserDto dto) {
        return ResponseEntity.ok(numerologyService.generateAndSaveProfile(dto));
    }

    @Operation(summary = "Gets a numerology profile using ID")
    @GetMapping("/{id}")
    public ResponseEntity<NumerologyProfileResponse> read(@PathVariable Long id) {
        return ResponseEntity.ok(numerologyService.findProfile(id));
    }

    @Operation(summary = "Gets all numerology profiles")
    @GetMapping
    public ResponseEntity<List<NumerologyProfileResponse>> getAllProfiles() {
        return ResponseEntity.ok(numerologyService.findAllProfiles());
    }

    @Operation(summary = "Gets the meaning for a number and a type.")
    @GetMapping("/meanings")
    public ResponseEntity<ProfileDto> getMeaning(
            @RequestParam int number,
            @RequestParam MeaningType type) {

        String meaning = meaningService.getMeaning(number, type);
        return ResponseEntity.ok(new ProfileDto(number, meaning));
    }

    @Operation(summary = "Updates a numerology profile")
    @PutMapping("/{id}")
    public ResponseEntity<NumerologyProfileResponse> updateProfile(
            @PathVariable Long id,
            @RequestBody UserDto dto) {
        return ResponseEntity.ok(numerologyService.updateProfile(id, dto));
    }

    @Operation(summary = "Deletes a numerology profile using ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable Long id) {
        numerologyService.deleteProfile(id);
        return ResponseEntity.ok("Profile with ID " + id + " was successfully deleted.");
    }
}