package dev.xero.task9.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.xero.task9.application.service.UserService;
import dev.xero.task9.application.service.controller.UserController;
import dev.xero.task9.domain.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@ContextConfiguration(classes = {UserController.class, UserControllerTest.TestConfig.class})
class UserControllerTest {

    @Configuration
    static class TestConfig {
        @Bean
        public UserService userService() {
            return Mockito.mock(UserService.class);
        }
    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllUsers_shouldReturnUserList() throws Exception {
        User user1 = new User(1L, "John", "john@example.com");
        User user2 = new User(2L, "Jane", "jane@example.com");
        when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].username").value("John"))
                .andExpect(jsonPath("$[1].username").value("Jane"));
    }

    @Test
    void getUserById_shouldReturnUser_whenExists() throws Exception {
        User user = new User(1L, "John", "john@example.com");
        when(userService.getUserById(1L)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("John"))
                .andExpect(jsonPath("$.email").value("john@example.com"));
    }

    @Test
    void getUserById_shouldReturn404_whenNotExists() throws Exception {
        when(userService.getUserById(999L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/users/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void createUser_shouldReturnCreatedUser() throws Exception {
        User input = new User(null, "John", "john@example.com");
        User created = new User(1L, "John", "john@example.com");
        when(userService.createUser(any(User.class))).thenReturn(created);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("John"));
    }

    @Test
    void updateUser_shouldReturnUpdatedUser_whenExists() throws Exception {
        User input = new User(null, "John Updated", "john.new@example.com");
        User updated = new User(1L, "John Updated", "john.new@example.com");
        when(userService.updateUser(eq(1L), any(User.class))).thenReturn(Optional.of(updated));

        mockMvc.perform(put("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("John Updated"));
    }

    @Test
    void updateUser_shouldReturn404_whenNotExists() throws Exception {
        User input = new User(null, "John", "john@example.com");
        when(userService.updateUser(eq(999L), any(User.class))).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/users/999")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteUser_shouldReturn204_whenExists() throws Exception {
        when(userService.deleteUser(1L)).thenReturn(true);

        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteUser_shouldReturn404_whenNotExists() throws Exception {
        when(userService.deleteUser(999L)).thenReturn(false);

        mockMvc.perform(delete("/api/users/999"))
                .andExpect(status().isNotFound());
    }
}