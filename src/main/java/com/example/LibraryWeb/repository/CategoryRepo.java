package com.example.LibraryWeb.repository;

import com.example.LibraryWeb.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
