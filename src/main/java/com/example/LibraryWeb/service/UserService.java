package com.example.LibraryWeb.service;

import com.example.LibraryWeb.model.User;

import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
