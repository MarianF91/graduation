package com.example.service;

import com.example.dto.UserDto;
import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Business-layer implemented for the CRUD operations on the entity {@link User}.
 * <p> All the methods are <strong>read-only</strong> by default;
 * those that modify data, override the flag through {@code @Transactional} at method level</p>
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    /** Returns and saves a new {@link User}. */
    @Override
    @Transactional          // readOnly = false
    public UserDto createUser(UserDto dto) {
        User saved = repo.save(UserMapper.toEntity(dto));
        return UserMapper.toDto(saved);
    }

    /** Returns all existing users. */
    @Override
    public List<UserDto> findAllUsers() {
        return repo.findAll().stream()
                .map(UserMapper::toDto)
                .toList();
    }
}