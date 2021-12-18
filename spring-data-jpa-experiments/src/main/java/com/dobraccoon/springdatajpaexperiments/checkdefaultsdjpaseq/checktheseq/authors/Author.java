package com.dobraccoon.springdatajpaexperiments.checkdefaultsdjpaseq.checktheseq.authors;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_one")
    private Long id;
    private String name;

    public Author(String name) {
        this.name = name;
    }
}
