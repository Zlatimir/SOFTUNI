package com.example.springdataintro.services;

import com.example.springdataintro.models.entity.Author;

import java.io.IOException;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();
}
