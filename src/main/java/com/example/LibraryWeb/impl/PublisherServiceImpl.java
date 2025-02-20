package com.example.LibraryWeb.impl;

import com.example.LibraryWeb.model.Publisher;
import com.example.LibraryWeb.repository.PublisherRepo;
import com.example.LibraryWeb.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepo publisherRepo;

    @Autowired
    public PublisherServiceImpl(PublisherRepo publisherRepo) {
        this.publisherRepo = publisherRepo;
    }


    @Override
    public List<Publisher> findAll() {
        return publisherRepo.findAll();
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepo.save(publisher);
    }
}
