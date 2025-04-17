package com.example.controller;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.UserDto;
import com.example.model.MeaningType;
import com.example.service.NumerologyService;
import com.example.service.MeaningService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class NumerologyController {

    private final NumerologyService numerologyService;
    private final MeaningService meaningService;

    public NumerologyController(NumerologyService numerologyService, MeaningService meaningService) {
        this.numerologyService = numerologyService;
        this.meaningService = meaningService;
    }

    @PostMapping
    public ResponseEntity<NumerologyProfileResponse> create(@RequestBody UserDto dto) {
        return ResponseEntity.ok(numerologyService.generateAndSaveProfile(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NumerologyProfileResponse> read(@PathVariable Long id) {
        return ResponseEntity.ok(numerologyService.findProfile(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<NumerologyProfileResponse>> getAllProfiles() {
        return ResponseEntity.ok(numerologyService.findAllProfiles());
    }

    @GetMapping("/meaning")
    public ResponseEntity<String> getMeaning(
            @RequestParam int number,
            @RequestParam String type) {

        return ResponseEntity.ok(meaningService.getMeaning(number, MeaningType.valueOf(type.toUpperCase())));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NumerologyProfileResponse> updateProfile(
            @PathVariable Long id,
            @RequestBody UserDto dto) {
        return ResponseEntity.ok(numerologyService.updateProfile(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable Long id) {
        numerologyService.deleteProfile(id);
        return ResponseEntity.ok("Profile with ID " + id + " was successfully deleted.");
    }
}