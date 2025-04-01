package com.example.LibraryWeb.repository;

import com.example.LibraryWeb.model.Book;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepo extends JpaRepository<Book, Long> {
    Slice<Book> findByTitleContainingIgnoreCase(PageRequest request, String title);
}
