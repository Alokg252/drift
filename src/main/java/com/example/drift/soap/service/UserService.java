package com.example.drift.soap.service;

import com.example.drift.soap.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {

    private final Map<Long, User> users = new HashMap<>();
    private final AtomicLong userIdCounter = new AtomicLong(1);

    public UserService() {
        // Initialize with sample data
        users.put(1L, new User(1L, "John Doe", "john@example.com", "123-456-7890"));
        users.put(2L, new User(2L, "Jane Smith", "jane@example.com", "098-765-4321"));
    }

    public User getUserById(Long id) {
        return users.get(id);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User createUser(String name, String email, String phone) {
        Long id = userIdCounter.getAndIncrement();
        User user = new User(id, name, email, phone);
        users.put(id, user);
        return user;
    }

    public User updateUser(Long id, String name, String email, String phone) {
        User user = users.get(id);
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            user.setPhone(phone);
        }
        return user;
    }

    public boolean deleteUser(Long id) {
        return users.remove(id) != null;
    }
}
