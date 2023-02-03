package com.example.demomongodb.model.service.impl;

import com.example.demomongodb.model.entity.Author;
import com.example.demomongodb.model.entity.Book;
import com.example.demomongodb.model.service.BookService;
import com.example.demomongodb.repository.AuthorRepository;
import com.example.demomongodb.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public String insert(Book book, String idAuthor){
        Book entity = bookRepository.save(book);
        Author author = authorRepository.findById(idAuthor).orElseThrow();
        author.getBooks().add(entity);
        authorRepository.save(author);
        return entity.getId().toString();
    }

    @Override
    public List<Book> getAll(){
        return bookRepository.findAll();
    }
}
