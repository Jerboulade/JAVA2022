package com.example.demomongodb.model.service;

import com.example.demomongodb.model.entity.Book;

import java.util.List;

public interface BookService {
    String insert(Book book, String idAuthor);

    List<Book> getAll();
}
