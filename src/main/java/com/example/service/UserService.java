package com.example.service;

import com.example.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUsers();
    UserDto createUser(UserDto dto);
}