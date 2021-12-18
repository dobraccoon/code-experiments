package com.dobraccoon.springdatajpaexperiments.checkdefaultsdjpaseq.checktheseq.authors;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
