package com.example.demomongodb.model.controller;

import com.example.demomongodb.model.entity.Author;
import com.example.demomongodb.model.entity.Book;
import com.example.demomongodb.model.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/add")
    public String insert(@RequestBody Author author){
        return authorService.insert(author);
    }

    @GetMapping("/all")
    public List<Author> getAll(){
        return authorService.getAll();
    }
}
