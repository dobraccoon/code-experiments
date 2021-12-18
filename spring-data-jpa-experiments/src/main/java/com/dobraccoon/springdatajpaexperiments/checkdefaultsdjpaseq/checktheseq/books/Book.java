package com.dobraccoon.springdatajpaexperiments.checkdefaultsdjpaseq.checktheseq.books;

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
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_one")
    private Long id;
    private String title;

    public Book(String title) {
        this.title = title;
    }
}
