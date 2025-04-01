package com.example.LibraryWeb.impl;

import com.example.LibraryWeb.dto.BookDto;
import com.example.LibraryWeb.model.Book;
import com.example.LibraryWeb.repository.BookRepo;
import com.example.LibraryWeb.service.BookService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book save(BookDto bookDto) {
        Book book = new Book();
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setIsbn(bookDto.getIsbn());
        bookRepo.save(book);
        return book;
    }

    @Override
    public Slice<Book> findAll(Integer offset, Integer limit) {
        return bookRepo.findAll(PageRequest.of(offset, limit));
    }

    @Override
    public Slice<Book> findByTitle(String title, Integer offset, Integer limit) {
        return bookRepo.findByTitleContainingIgnoreCase(PageRequest.of(offset, limit), title);
    }

    @Override
    public Book findById(Long id) {
        return bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Книга не найдена!"));
    }

    @Override
    public void delete(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public void update(Book book, BookDto bookDto) {
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setIsbn(bookDto.getIsbn());
        bookRepo.save(book);
    }
}
