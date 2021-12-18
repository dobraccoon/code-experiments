package com.dobraccoon.springdatajpaexperiments.checkdefaultsdjpaseq.checktheseq.bootstrap;


import com.dobraccoon.springdatajpaexperiments.checkdefaultsdjpaseq.checktheseq.authors.Author;
import com.dobraccoon.springdatajpaexperiments.checkdefaultsdjpaseq.checktheseq.authors.AuthorRepository;
import com.dobraccoon.springdatajpaexperiments.checkdefaultsdjpaseq.checktheseq.books.Book;
import com.dobraccoon.springdatajpaexperiments.checkdefaultsdjpaseq.checktheseq.books.BookRepository;
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

        for (int i = 0; i < 30; i++) {
            Book book = new Book("Book" + i);
            bookRepository.save(book);
            Author author = new Author("Author" + i);
            authorRepository.save(author);
        }

        for (int i = 0; i < 5; i++) {
            Author author = new Author("Author" + i);
            authorRepository.save(author);
        }

        for (int i = 0; i < 30; i++) {
            Book book = new Book("Book" + i);
            bookRepository.save(book);
        }

        bookRepository.findAll().forEach(book -> {
            System.out.println("BookId: " + book.getId());
        });

        authorRepository.findAll().forEach(author -> {
            System.out.println("AuthorId: " + author.getId());
        });

        System.out.println("EXPERIMENT: If set one seq for all entities" +
                "(@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = \"seq_one\")), " +
                "it will generate by some magik logic");
    }
}
