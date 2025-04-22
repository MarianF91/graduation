package com.example.mapper;

import com.example.dto.UserDto;
import com.example.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto(User entity) {
        return new UserDto(
                entity.getFirstName(),
                entity.getLastName(),
                entity.getBirthYear(),
                entity.getBirthMonth(),
                entity.getBirthDay()
        );
    }

    public User toEntity(UserDto dto) {
        return new User(
                dto.firstName(),
                dto.lastName(),
                dto.birthYear(),
                dto.birthMonth(),
                dto.birthDay()
        );
    }
}