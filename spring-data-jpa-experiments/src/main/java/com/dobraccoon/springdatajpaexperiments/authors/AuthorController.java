package com.dobraccoon.springdatajpaexperiments.authors;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("authors/")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/")
    public List<Author> getAllAuthors() {
        return authorService.getAll();
    }

    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable Long authorId) {
        return authorService.getById(authorId);
    }

    @PostMapping
    public Author addAuthor(@RequestBody final Author author) {
        return authorService.addAuthor(author);
    }

    @PutMapping
    public Author updateAuthor(@RequestBody final Author author) {
        return authorService.updateAuthor(author);
    }

    @DeleteMapping("/authorId")
    public long deleteById(@PathVariable final Long authorId) {
        return authorService.deleteById(authorId);
    }
}
