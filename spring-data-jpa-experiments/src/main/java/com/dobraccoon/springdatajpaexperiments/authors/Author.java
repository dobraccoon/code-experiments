package com.dobraccoon.springdatajpaexperiments.authors;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTHOR_SEQ")
    private Long id;
    private String name;

    public Author(String name) {
        this.name = name;
    }
}
