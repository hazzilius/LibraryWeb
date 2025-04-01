package com.example.LibraryWeb.service;

import com.example.LibraryWeb.dto.AuthorDto;
import com.example.LibraryWeb.model.Author;
import org.springframework.data.domain.Slice;

public interface AuthorService {
    Author save(AuthorDto authorDto);
    Slice<Author> findAll(Integer offset, Integer limit);
    Slice<Author> findByName(String name, Integer offset, Integer limit);
    Author findById(Long id);
    void delete(Long id);

    void update(Author author, AuthorDto authorDto);
}
