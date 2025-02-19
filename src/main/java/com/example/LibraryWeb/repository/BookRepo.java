package com.example.LibraryWeb.repository;

import com.example.LibraryWeb.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByAuthorNameIgnoreCase(String authorName);
    List<Book> findByCategoryNameIgnoreCase(String categoryName);
    List<Book> findByPublicationYear(int year);
}
