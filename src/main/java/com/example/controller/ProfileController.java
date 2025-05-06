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

/**
 * Exposes CRUD operations for numerological profiles.
 * Base path: {@code /api/profiles}.
 */
@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final NumerologyService numerologyService;

    /**
     * Creates a new profile for the user from payload.
     *
     * @param dto user's data
     * @return generated profile
     */
    @PostMapping
    public ResponseEntity<NumerologyProfileResponse> create(@RequestBody @Valid UserDto dto) {
        NumerologyProfileResponse response = numerologyService.calculateProfile(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Finds a profile using its ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<NumerologyProfileResponse> find(@PathVariable Long id) {
        return ResponseEntity.ok(numerologyService.findProfile(id));
    }

    /**
     * Lists all existing profiles.
     */
    @GetMapping
    public List<NumerologyProfileResponse> findAll() {
        return numerologyService.findAllProfiles();
    }
}