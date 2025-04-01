package com.example.LibraryWeb.repository;

import com.example.LibraryWeb.model.Author;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepo extends JpaRepository<Author, Long> {
    Slice<Author> findByNameContainingIgnoreCase(PageRequest request, String name);
}
