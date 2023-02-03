package com.example.demomongodb.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter @Setter
public class Author {
    private String id;
    private String firstName;
    private String lastName;
    @DBRef
    private List<Book> books;
}
