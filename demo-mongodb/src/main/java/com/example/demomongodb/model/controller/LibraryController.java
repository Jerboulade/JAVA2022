package com.example.demomongodb.model.controller;

import com.example.demomongodb.model.entity.Book;
import com.example.demomongodb.model.entity.Library;
import com.example.demomongodb.model.service.LibraryService;
import com.example.demomongodb.repository.LibraryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;


    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/add")
    public String insert(@RequestBody Library library) {
        return libraryService.insert(library);
    }

    @GetMapping("/all")
    public List<Library> getAll(){
        return libraryService.getAll();
    }
}
