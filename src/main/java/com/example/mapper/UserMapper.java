package com.example.mapper;

import com.example.dto.UserDto;
import com.example.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserDto dto) {
        return new User(
                dto.firstName(),
                dto.lastName(),
                dto.birthYear(),
                dto.birthMonth(),
                dto.birthDay()
        );
    }

    public UserDto toDto(User user) {
        return new UserDto(
                user.getFirstName(),
                user.getLastName(),
                user.getBirthYear(),
                user.getBirthMonth(),
                user.getBirthDay()
        );
    }
}
