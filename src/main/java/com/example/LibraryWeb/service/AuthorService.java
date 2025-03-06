package com.example.LibraryWeb.service;

import com.example.LibraryWeb.dto.AuthorDto;
import com.example.LibraryWeb.model.Author;

import java.util.List;

public interface AuthorService {
    void save(AuthorDto authorDto);
    List<Author> findAll();
}
