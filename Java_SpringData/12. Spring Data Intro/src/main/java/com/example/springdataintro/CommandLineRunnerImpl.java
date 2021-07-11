package com.example.springdataintro;

import com.example.springdataintro.models.entity.Book;
import com.example.springdataintro.services.AuthorService;
import com.example.springdataintro.services.BookService;
import com.example.springdataintro.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();

        printAllBooksAfter2000(2000);
    }

    private void printAllBooksAfter2000(int year) {
        System.out.println("All books after year 2000:");
        bookService.findAllBooksAfterYear(year).stream()
                .map(Book::getTitle).forEach(System.out::println);
    }
}
