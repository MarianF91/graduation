package com.example.controller;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.ProfileDto;
import com.example.dto.UserDto;
import com.example.model.MeaningType;
import com.example.service.MeaningService;
import com.example.service.NumerologyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/numerology")
@RequiredArgsConstructor
public class NumerologyController {

    private final NumerologyService numerologyService;
    private final MeaningService meaningService;

    @PostMapping
    public ResponseEntity<NumerologyProfileResponse> create(
            @Valid @RequestBody UserDto dto
    ) {
        NumerologyProfileResponse response = numerologyService.calculateProfile(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/meaning")
    public ResponseEntity<ProfileDto> getMeaning(
            @RequestParam int number,
            @RequestParam MeaningType type
    ) {
        String text = meaningService.getMeaning(number, type);
        return ResponseEntity.ok(new ProfileDto(number, text));
    }

}