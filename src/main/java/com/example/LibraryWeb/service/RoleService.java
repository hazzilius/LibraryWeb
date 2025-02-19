package com.example.LibraryWeb.service;

import com.example.LibraryWeb.model.Role;

public interface RoleService {
    Role findByName(String name);
}
