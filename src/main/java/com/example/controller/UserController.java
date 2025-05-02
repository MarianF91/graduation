package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "UserController", description = "Handles user creation and retrieval operations")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Return all users")
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @Operation(summary = "Create new user")
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto dto) {
        UserDto created = userService.createUser(dto);
        return ResponseEntity.ok(created);
    }
}