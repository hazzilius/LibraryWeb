package com.example.LibraryWeb.impl;

import com.example.LibraryWeb.dto.UserDto;
import com.example.LibraryWeb.model.Role;
import com.example.LibraryWeb.model.User;
import com.example.LibraryWeb.repository.UserRepo;
import com.example.LibraryWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder passwordEncoder;
    UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo,  BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(UserDto userDto) {
        if (userRepo.findByUsername(userDto.getUsername()) == null) {
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setName(userDto.getName());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setEmail(userDto.getEmail());
            user.setPhone(userDto.getPhone());
            user.setRegDate(LocalDate.now());
            user.setRoles(Collections.singleton(Role.USER));
            userRepo.save(user);
        }
    }

    @Override
    public User findUser(String username) {
        return userRepo.findByUsername(username);
    }
}
