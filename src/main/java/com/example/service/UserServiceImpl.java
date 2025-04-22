// src/main/java/com/example/service/UserServiceImpl.java
package com.example.service;

import com.example.dto.UserDto;
import com.example.exception.UserNotFoundException;
import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper     userMapper;

    @Override
    public UserDto createUser(UserDto dto) {
        User saved = userRepository.save(userMapper.toEntity(dto));
        return userMapper.toDto(saved);
    }

    @Override
    public UserDto findUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }
}