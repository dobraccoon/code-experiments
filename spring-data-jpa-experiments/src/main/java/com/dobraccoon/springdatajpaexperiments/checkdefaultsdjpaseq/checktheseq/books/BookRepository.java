package com.dobraccoon.springdatajpaexperiments.checkdefaultsdjpaseq.checktheseq.books;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
