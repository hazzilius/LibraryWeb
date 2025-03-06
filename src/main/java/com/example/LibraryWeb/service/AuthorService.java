package com.example.LibraryWeb.service;

import com.example.LibraryWeb.dto.AuthorDto;
import com.example.LibraryWeb.model.Author;

import java.util.List;

public interface AuthorService {
    void save(AuthorDto authorDto);
    List<Author> findAll();
    Author findById(Long id);

    void deleteById(Long id);

    void edit(Author author, AuthorDto authorDto);
}
