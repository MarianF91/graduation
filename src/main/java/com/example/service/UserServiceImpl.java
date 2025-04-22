package com.example.service;

import com.example.dto.UserDto;
import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<UserDto> findAllUsers() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public UserDto createUser(UserDto dto) {
        User saved = repository.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }
}