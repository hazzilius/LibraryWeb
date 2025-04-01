package com.example.LibraryWeb.service;

import com.example.LibraryWeb.dto.BookDto;
import com.example.LibraryWeb.model.Book;
import org.springframework.data.domain.Slice;

public interface BookService {
    Book save(BookDto bookDto);
    Slice<Book> findAll(Integer offset, Integer limit);
    Slice<Book> findByTitle(String title, Integer offset, Integer limit);
    Book findById(Long id);
    void delete(Long id);
    void update(Book book, BookDto bookDto);
}
