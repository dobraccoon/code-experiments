package com.dobraccoon.springdatajpaexperiments.bootstrap;


import com.dobraccoon.springdatajpaexperiments.authors.Author;
import com.dobraccoon.springdatajpaexperiments.authors.AuthorRepository;
import com.dobraccoon.springdatajpaexperiments.books.Book;
import com.dobraccoon.springdatajpaexperiments.books.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 5; i++) {
            bookRepository.save(new Book("Book" + i));
            authorRepository.save(new Author("Author" + i));
        }

        bookRepository.findAll().forEach(book -> {
            System.out.println("BookId: " + book.getId());
        });

        authorRepository.findAll().forEach(author -> {
            System.out.println("AuthorId: " + author.getId());
        });
    }
}
