package com.example.LibraryWeb.service;

import com.example.LibraryWeb.dto.BookDto;
import com.example.LibraryWeb.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    void save(BookDto bookDto);
    List<Book> findAll();
    Book findById(Long id);
    void deleteById(Long id);
    void edit(Book book, BookDto bookDto);
}
