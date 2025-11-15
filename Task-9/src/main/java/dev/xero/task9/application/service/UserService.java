package dev.xero.task9.application.service;

import dev.xero.task9.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    private final Map<Long, User> users = new ConcurrentHashMap<Long, User>();
    private final AtomicLong counter = new AtomicLong();

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    public User createUser(User user) {
        Long id = counter.incrementAndGet();
        user.setId(id);
        users.put(id, user);
        return user;
    }

    public Optional<User> updateUser(Long id, User user) {
        if (!users.containsKey(id)) {
            return Optional.empty();
        }
        user.setId(id);
        users.put(id, user);
        return Optional.of(user);
    }

    public boolean deleteUser(Long id) {
        return users.remove(id) != null;
    }

}
