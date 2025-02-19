package com.example.LibraryWeb.repository;


import com.example.LibraryWeb.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
