package com.example.LibraryWeb.impl;

import com.example.LibraryWeb.model.Book;
import com.example.LibraryWeb.repository.BookRepo;
import com.example.LibraryWeb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepo bookRepo;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }


    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Книга не найдена"));
    }

    @Override
    public Book save(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }
}
