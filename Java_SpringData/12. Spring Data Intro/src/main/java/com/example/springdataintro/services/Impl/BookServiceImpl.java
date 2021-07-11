package com.example.springdataintro.services.Impl;

import com.example.springdataintro.models.entity.*;
import com.example.springdataintro.repositories.BookRepository;
import com.example.springdataintro.services.AuthorService;
import com.example.springdataintro.services.BookService;
import com.example.springdataintro.services.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    public static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;

    private final AuthorService authorService;

    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }


    @Override
    public void seedBooks() throws IOException {

        if (bookRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(BOOKS_FILE_PATH)).forEach(row -> {

            String[] info = row.split("\\s+");
            Book book = createBook(info);

            bookRepository.save(book);
        });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {

        return bookRepository.findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    private Book createBook(String[] info) {
        EditionType editionType = EditionType.values()[Integer.parseInt(info[0])];
        LocalDate releaseDate = LocalDate.parse(info[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(info[2]);
        BigDecimal price = new BigDecimal(info[3]);
        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(info[4])];
        String title = Arrays.stream(info).skip(5).collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();

        Set<Category> categories = categoryService.getRandomCategory();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);
    }
}
