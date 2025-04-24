package com.example.service;

import com.example.dto.UserDto;
import java.util.List;

public interface UserService {
    UserDto createUser(UserDto dto);
    UserDto findUser(Long id);
    List<UserDto> findAllUsers();
}