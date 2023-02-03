package com.example.demomongodb.model.controller;

import com.example.demomongodb.model.entity.Author;
import com.example.demomongodb.model.entity.Book;
import com.example.demomongodb.model.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add/{idAuthor}")
    public String insert(@RequestBody Book book, @PathVariable("idAuthor") String idAuthor){
        return bookService.insert(book, idAuthor);
    }

    @GetMapping("/all")
    public List<Book> getAll(){
        return bookService.getAll();
    }
}
