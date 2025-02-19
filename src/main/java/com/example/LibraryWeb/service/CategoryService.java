package com.example.LibraryWeb.service;

import com.example.LibraryWeb.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category save(Category category);
}
