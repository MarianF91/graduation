package com.example.controller;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.UserDto;
import com.example.service.NumerologyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "Profile operations",
        description = "Create & read numerology profiles"
)
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
    @Operation(summary = "Generate a profile",
            description = "Calculates all numerology numbers for the provided user " +
                    "and persists the result.",
            responses = @ApiResponse(
                    responseCode = "201",
                    description = "Profile created",
                    content = @Content(schema = @Schema(
                            implementation = NumerologyProfileResponse.class))
            ))
    @PostMapping
    public ResponseEntity<NumerologyProfileResponse> create(@RequestBody @Valid UserDto dto) {
        NumerologyProfileResponse response = numerologyService.calculateProfile(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Finds a profile using its ID.
     */
    @Operation(
            summary = "Get profile by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Profile found",
                            content = @Content(schema = @Schema(
                                    implementation = NumerologyProfileResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Profile not found")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<NumerologyProfileResponse> find(@PathVariable Long id) {
        return ResponseEntity.ok(numerologyService.findProfile(id));
    }

    /**
     * Lists all existing profiles.
     */
    @Operation(
            summary = "List all profiles",
            responses = @ApiResponse(
                    responseCode = "200", description = "Array of profiles",
                    content = @Content(schema = @Schema(
                            implementation = NumerologyProfileResponse.class, type = "array"))
            )
    )
    @GetMapping
    public List<NumerologyProfileResponse> findAll() {
        return numerologyService.findAllProfiles();
    }
}