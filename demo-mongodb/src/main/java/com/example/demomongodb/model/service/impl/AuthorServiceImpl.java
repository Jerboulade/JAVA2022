package com.example.demomongodb.model.service.impl;

import com.example.demomongodb.model.entity.Author;
import com.example.demomongodb.model.service.AuthorService;
import com.example.demomongodb.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public String insert(Author author) {
        author.setBooks(new ArrayList<>());
        return authorRepository.save(author).getId().toString();
    }

    @Override
    public List<Author> getAll(){
        return authorRepository.findAll();
    }
}
