package com.example.LibraryWeb.service;

import com.example.LibraryWeb.model.Book;
import com.example.LibraryWeb.model.Publisher;

import java.util.List;

public interface PublisherService {
    List<Publisher> findAll();
    Publisher save(Publisher publisher);
}
