package com.example.controller;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean; //marked for deprecation; will be replaced by @ReplaceWithMock
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean //marked for deprecation; will be replaced by @ReplaceWithMock
    private UserRepository userRepository;

    @Test
    void getAllUsers_returnsList() throws Exception {
        User user1 = new User("Ana", "Pop", 1990, 5, 15);
        User user2 = new User("Ion", "Ionescu", 1988, 3, 22);
        when(userRepository.findAll()).thenReturn(List.of(user1, user2));

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].firstName").value("Ana"))
                .andExpect(jsonPath("$[1].firstName").value("Ion"));
    }

    @Test
    void createUser_savesAndReturnsUser() throws Exception {
        User user = new User("Maria", "Enescu", 1995, 6, 10);
        when(userRepository.save(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "firstName": "Maria",
                                  "lastName": "Enescu",
                                  "birthYear": 1995,
                                  "birthMonth": 6,
                                  "birthDay": 10
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Maria"))
                .andExpect(jsonPath("$.lastName").value("Enescu"));
    }
}