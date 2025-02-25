package com.example.LibraryWeb.service;

import com.example.LibraryWeb.dto.UserDto;
import com.example.LibraryWeb.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService{
    User save(UserDto userDto);
    User findUser(String username);
}
