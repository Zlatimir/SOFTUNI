package com.example.springdataintro.services;

import com.example.springdataintro.models.entity.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);
}
