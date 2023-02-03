package com.example.demomongodb.model.service;

import com.example.demomongodb.model.entity.Author;

import java.util.List;

public interface AuthorService {
    String insert(Author author);

    List<Author> getAll();
}
