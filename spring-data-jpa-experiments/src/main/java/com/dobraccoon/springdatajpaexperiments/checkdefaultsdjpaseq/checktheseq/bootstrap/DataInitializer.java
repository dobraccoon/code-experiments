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
        Book book1 = new Book("Book1");
        Book savedBook1 = bookRepository.save(book1);

        Book book2 = new Book("Book1");
        Book savedBook2 = bookRepository.save(book2);

        Author author1 = new Author("Author1");
        Author savedAuthor1 = authorRepository.save(author1);

        Author author2 = new Author("Author1");
        Author savedAuthor2 = authorRepository.save(author2);

        System.out.println("savedBookId: " + savedBook1.getId());
        System.out.println("savedBookId: " + savedBook2.getId());
        System.out.println("savedAuthorId: " + savedAuthor1.getId());
        System.out.println("savedAuthorId: " + savedAuthor2.getId());
        System.out.println("Experiment: By default SDJPA create default sequence " +
                "and all ids with @GeneratedValue(strategy = GenerationType.SEQUENCE) use it");

    }
}
