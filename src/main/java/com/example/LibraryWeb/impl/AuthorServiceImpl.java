package com.example.LibraryWeb.impl;

import com.example.LibraryWeb.dto.AuthorDto;
import com.example.LibraryWeb.model.Author;
import com.example.LibraryWeb.repository.AuthorRepo;
import com.example.LibraryWeb.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public void save(AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setBio(authorDto.getBio());
        authorRepo.save(author);
    }

    @Override
    public List<Author> findAll() {
        return authorRepo.findAll();
    }
}
