package com.example.controller;

import com.example.dto.ProfileDto;
import com.example.model.MeaningType;
import com.example.service.MeaningService;
import com.example.service.NumerologyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "Numerology operations",
        description = "Endpoints for meanings & bulk-deletes"
)
@RestController
@RequestMapping("/api/numerology")
@RequiredArgsConstructor
public class NumerologyController {

    private final NumerologyService numerologyService;
    private final MeaningService meaningService;

    @Operation(
            summary = "Get meaning for a number/type",
            description = "Returns the textual description (meaning) of a number " +
                    "for the requested numerological category.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Meaning found",
                            content = @Content(schema = @Schema(implementation = ProfileDto.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "No meaning in DB")
            }
    )
    @GetMapping("/meaning")
    public ResponseEntity<ProfileDto> getMeaning(@RequestParam int number,
                                                 @RequestParam MeaningType type) {
        String text = meaningService.getMeaning(number, type);
        return ResponseEntity.ok(new ProfileDto(number, text));
    }

    @Operation(
            summary = "Delete single profile",
            description = "Erases the numerology profile (and cascaded user) by ID."
    )
    @DeleteMapping("/profiles/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        numerologyService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Delete **all** profiles",
            description = "Bulk-delete of every profile and its linked user."
    )
    @DeleteMapping("/profiles")
    public ResponseEntity<Void> deleteAllProfiles() {
        numerologyService.deleteAllProfiles();
        return ResponseEntity.noContent().build();
    }
}