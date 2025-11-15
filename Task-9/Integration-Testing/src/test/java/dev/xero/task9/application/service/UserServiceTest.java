package dev.xero.task9.application.service;

import dev.xero.task9.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void createUser_shouldAssignIdAndReturnUser() {
        User user = new User(null, "John Doe", "john@example.com");

        User created = userService.createUser(user);

        assertNotNull(created.getId());
        assertEquals("John Doe", created.getUsername());
        assertEquals("john@example.com", created.getEmail());
    }

    @Test
    void getAllUsers_shouldReturnEmptyListInitially() {
        List<User> users = userService.getAllUsers();

        assertTrue(users.isEmpty());
    }

    @Test
    void getAllUsers_shouldReturnAllCreatedUsers() {
        userService.createUser(new User(null, "User1", "user1@example.com"));
        userService.createUser(new User(null, "User2", "user2@example.com"));

        List<User> users = userService.getAllUsers();

        assertEquals(2, users.size());
    }

    @Test
    void getUserById_shouldReturnUserWhenExists() {
        User created = userService.createUser(new User(null, "John", "john@example.com"));

        Optional<User> found = userService.getUserById(created.getId());

        assertTrue(found.isPresent());
        assertEquals("John", found.get().getUsername());
    }

    @Test
    void getUserById_shouldReturnEmptyWhenNotExists() {
        Optional<User> found = userService.getUserById(999L);

        assertFalse(found.isPresent());
    }

    @Test
    void updateUser_shouldUpdateExistingUser() {
        User created = userService.createUser(new User(null, "John", "john@example.com"));
        User updated = new User(null, "John Updated", "john.new@example.com");

        Optional<User> result = userService.updateUser(created.getId(), updated);

        assertTrue(result.isPresent());
        assertEquals(created.getId(), result.get().getId());
        assertEquals("John Updated", result.get().getUsername());
        assertEquals("john.new@example.com", result.get().getEmail());
    }

    @Test
    void updateUser_shouldReturnEmptyWhenUserNotExists() {
        User user = new User(null, "John", "john@example.com");

        Optional<User> result = userService.updateUser(999L, user);

        assertFalse(result.isPresent());
    }

    @Test
    void deleteUser_shouldReturnTrueWhenUserExists() {
        User created = userService.createUser(new User(null, "John", "john@example.com"));

        boolean deleted = userService.deleteUser(created.getId());

        assertTrue(deleted);
        assertFalse(userService.getUserById(created.getId()).isPresent());
    }

    @Test
    void deleteUser_shouldReturnFalseWhenUserNotExists() {
        boolean deleted = userService.deleteUser(999L);

        assertFalse(deleted);
    }
}