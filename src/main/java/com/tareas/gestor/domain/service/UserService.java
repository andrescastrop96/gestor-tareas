package com.tareas.gestor.domain.service;

import com.tareas.gestor.domain.User;
import com.tareas.gestor.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int userId) {
        return userRepository.getUser(userId);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean delete(int userId) {
        return getUser(userId).map(user -> {
            userRepository.delete(userId);
            return true;
        }).orElse(false);
    }
}
