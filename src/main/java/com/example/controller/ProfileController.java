package com.example.controller;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.UserDto;
import com.example.service.NumerologyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// controller used to generate and show numerological profiles

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final NumerologyService numerologyService;

    // creates a new profile for the user sent in the request
    @PostMapping
    public ResponseEntity<NumerologyProfileResponse> create(@RequestBody @Valid UserDto dto) {
        NumerologyProfileResponse response = numerologyService.calculateProfile(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // finds  profile using it's ID
    @GetMapping("/{id}")
    public ResponseEntity<NumerologyProfileResponse> find(@PathVariable Long id) {
        return ResponseEntity.ok(numerologyService.findProfile(id));
    }

    // returns all the profiles from the db
    @GetMapping
    public List<NumerologyProfileResponse> findAll() {
        return numerologyService.findAllProfiles();
    }
}
