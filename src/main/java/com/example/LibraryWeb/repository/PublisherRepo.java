package com.example.LibraryWeb.repository;

import com.example.LibraryWeb.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<Publisher, Long> {
    Publisher findByName(String name);
}
