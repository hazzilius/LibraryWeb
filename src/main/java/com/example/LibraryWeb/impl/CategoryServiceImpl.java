package com.example.LibraryWeb.impl;

import com.example.LibraryWeb.model.Category;
import com.example.LibraryWeb.repository.CategoryRepo;
import com.example.LibraryWeb.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> findAll(){
        return categoryRepo.findAll();
    }

    @Override
    public Category save(Category category){
        return categoryRepo.save(category);
    }
}
