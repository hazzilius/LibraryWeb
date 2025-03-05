package com.example.LibraryWeb.service;

import com.example.LibraryWeb.dto.UserDto;
import com.example.LibraryWeb.model.User;

public interface UserService{
    void save(UserDto userDto);
    User findUser(String username);
}
