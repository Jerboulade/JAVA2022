package com.example.demomongodb.model.service.impl;

import com.example.demomongodb.model.entity.Library;
import com.example.demomongodb.model.service.LibraryService;
import com.example.demomongodb.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    private final LibraryRepository libraryRepository;

    public LibraryServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public String insert(Library library) {
        return libraryRepository.insert(library).getId();
    }

    @Override
    public List<Library> getAll() {
        return libraryRepository.findAll();
    }
}
