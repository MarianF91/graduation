package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for operations on the entity {@code User}.
 * Base path {@code /api/users}.
 */
@Tag(
        name = "User operations",
        description = "Create users and list all registered users"
)
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns all existing users.
     */
    @Operation(
            summary = "List all users",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Array of users",
                    content = @Content(schema = @Schema(
                            implementation = UserDto.class, type = "array"))
            )
    )
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    /**
     * Creates a new user.
     */
    @Operation(
            summary = "Create a new user",
            description = "Adds a user and returns the stored representation.",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "User created",
                    content = @Content(schema = @Schema(implementation = UserDto.class))
            )
    )
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto dto) {
        UserDto created = userService.createUser(dto);
        return ResponseEntity.ok(created);
    }
}