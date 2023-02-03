package com.example.demomongodb.repository;

import com.example.demomongodb.model.entity.Library;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibraryRepository extends MongoRepository<Library, String> {

}
