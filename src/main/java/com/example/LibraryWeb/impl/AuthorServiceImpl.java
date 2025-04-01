package com.example.LibraryWeb.impl;

import com.example.LibraryWeb.dto.AuthorDto;
import com.example.LibraryWeb.model.Author;
import com.example.LibraryWeb.repository.AuthorRepo;
import com.example.LibraryWeb.service.AuthorService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public Author save(AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setBio(authorDto.getBio());
        authorRepo.save(author);
        return author;
    }

    @Override
    public Slice<Author> findAll(Integer offset, Integer limit) {
        return authorRepo.findAll(PageRequest.of(offset, limit));
    }

    @Override
    public Slice<Author> findByName(String name, Integer offset, Integer limit) {
        return authorRepo.findByNameContainingIgnoreCase(PageRequest.of(offset, limit), name);
    }

    @Override
    public Author findById(Long id) {
        return authorRepo.findById(id).orElseThrow(() -> new RuntimeException("Автор не найден!"));
    }

    @Override
    public void delete(Long id) {
        authorRepo.deleteById(id);
    }

    @Override
    public void update(Author author, AuthorDto authorDto) {
        author.setName(authorDto.getName());
        author.setBio(authorDto.getBio());
        authorRepo.save(author);
    }
}
