package com.example.controller;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.UserDto;
import com.example.model.NumerologyProfile;
import com.example.model.User;
import com.example.service.MeaningService;
import com.example.service.NumerologyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class NumerologyController {

    private final NumerologyService service;
    private final MeaningService meaningService;

    public NumerologyController(NumerologyService service, MeaningService meaningService) {
        this.service = service;
        this.meaningService = meaningService;
    }

    @PostMapping
    public ResponseEntity<NumerologyProfileResponse> create(@RequestBody UserDto dto) {
        User user = new User(dto.firstName(), dto.lastName(),
                dto.birthYear(), dto.birthMonth(), dto.birthDay());

        NumerologyProfile p = service.generateAndSaveProfile(user);
        return ResponseEntity.ok(toDto(p));
    }

    @GetMapping("/all")
    public ResponseEntity<List<NumerologyProfileResponse>> getAllProfiles() {
        List<NumerologyProfile> profiles = service.findAllProfiles();
        List<NumerologyProfileResponse> responses = profiles.stream()
                .map(this::toDto)
                .toList();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/get-meaning")
    public ResponseEntity<String> getMeaning(@RequestParam int number, @RequestParam String type) {
        String meaning = meaningService.getMeaning(number, type);
        return ResponseEntity.ok(meaning);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NumerologyProfileResponse> read(@PathVariable Long id) {
        return ResponseEntity.ok(toDto(service.findProfile(id)));
    }

    private NumerologyProfileResponse toDto(NumerologyProfile p) {
        return new NumerologyProfileResponse(
                p.getId(),
                p.getDestinyNumber(),
                p.getSoulUrgeNumber(),
                p.getPersonalityNumber(),
                p.getExpressionNumber(),
                p.getMaturityNumber(),
                p.getUser().getFirstName(),
                p.getUser().getLastName()
        );
    }
}