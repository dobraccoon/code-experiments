package com.dobraccoon.springdatajpaexperiments.authors;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(final Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(final Author author) {
        if (author.getId() == null) {
            throw new IllegalArgumentException("Value Author.id can't be null by trying to update");
        }
        return authorRepository.save(author);
    }

    public Author getById(final long authorId) {
        return authorRepository.findById(authorId).orElseThrow();
    }

    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public long deleteById(final long authorId) {
        authorRepository.deleteById(authorId);
        return authorId;
    }

}
