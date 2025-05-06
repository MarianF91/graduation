package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    private UserController controller;

    @BeforeEach
    void setUp() {
        controller = new UserController(userService);
    }

    @Test
    void getAllUsers_returnsList() {
        var u1 = new UserDto("Ana","Pop",1990,5,15);
        var u2 = new UserDto("Ion","Ionescu",1988,3,22);
        when(userService.findAllUsers()).thenReturn(List.of(u1, u2));

        ResponseEntity<List<UserDto>> resp = controller.getAllUsers();

        assertEquals(200, resp.getStatusCode().value());
        assertEquals(2, Objects.requireNonNull(resp.getBody()).size());
        assertEquals("Ana", resp.getBody().getFirst().firstName());
    }

    @Test
    void createUser_returnsDto() {
        var input = new UserDto("Maria","Enescu",1995,6,10);
        when(userService.createUser(input)).thenReturn(input);

        ResponseEntity<UserDto> resp = controller.createUser(input);

        assertEquals(200, resp.getStatusCode().value());
        assertEquals("Maria", Objects.requireNonNull(resp.getBody()).firstName());
        verify(userService).createUser(input);
    }
}
