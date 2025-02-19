package com.example.LibraryWeb.controller;

import com.example.LibraryWeb.model.Category;
import com.example.LibraryWeb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories/new")
    public String showCategoryForm(Model model){
        model.addAttribute("category", new Category());
        return "category-form";
    }

    @PostMapping("/categories")
    public String addCategory(Category category){
        categoryService.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories")
    public String listCategories(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "category-list";
    }
}
