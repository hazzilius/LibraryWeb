package com.example.LibraryWeb.impl;

import com.example.LibraryWeb.dto.UserDto;
import com.example.LibraryWeb.model.Role;
import com.example.LibraryWeb.model.User;
import com.example.LibraryWeb.repository.UserRepo;
import com.example.LibraryWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    public User save(UserDto userDto) {
        return new User(userDto.getUsername(),
                passwordEncoder.encode(userDto.getPassword()),
                userDto.getEmail(),
                userDto.getName(),
                userDto.getPhone(),
                LocalDate.now(),
                Collections.singleton(Role.USER)
        );
    }

    @Override
    public User findUser(String username) {
        return userRepo.findByUsername(username);
    }
}
