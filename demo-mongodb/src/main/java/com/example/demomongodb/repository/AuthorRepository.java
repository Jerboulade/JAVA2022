package com.example.demomongodb.repository;

import com.example.demomongodb.model.entity.Author;
import com.example.demomongodb.model.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
