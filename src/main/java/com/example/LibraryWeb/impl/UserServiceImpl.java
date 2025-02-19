package com.example.LibraryWeb.impl;

import com.example.LibraryWeb.model.User;
import com.example.LibraryWeb.repository.UserRepo;
import com.example.LibraryWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user){
        return userRepo.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email){
        return userRepo.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email){
        return userRepo.existsByEmail(email);
    }

}
