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

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final NumerologyService numerologyService;

    @PostMapping
    public ResponseEntity<NumerologyProfileResponse> create(@RequestBody @Valid UserDto dto) {
        NumerologyProfileResponse response = numerologyService.calculateProfile(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NumerologyProfileResponse> find(@PathVariable Long id) {
        return ResponseEntity.ok(numerologyService.findProfile(id));
    }

    @GetMapping
    public List<NumerologyProfileResponse> findAll() {
        return numerologyService.findAllProfiles();
    }
}
