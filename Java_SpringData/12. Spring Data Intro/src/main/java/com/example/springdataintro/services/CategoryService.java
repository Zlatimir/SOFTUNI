package com.example.springdataintro.services;

import com.example.springdataintro.models.entity.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> getRandomCategory();
}
