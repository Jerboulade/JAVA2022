package com.example.demomongodb.model.service;

import com.example.demomongodb.model.entity.Library;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface LibraryService {
    String insert(Library library);

    List<Library> getAll();
}
