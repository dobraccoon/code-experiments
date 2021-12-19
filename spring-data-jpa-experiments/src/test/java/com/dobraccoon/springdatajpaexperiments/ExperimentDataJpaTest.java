package com.dobraccoon.springdatajpaexperiments;

import com.dobraccoon.springdatajpaexperiments.books.Book;
import com.dobraccoon.springdatajpaexperiments.books.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("test")
@DataJpaTest
class ExperimentDataJpaTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void bookRepositoryTest() {
        bookRepository.save(new Book(""));
        long count = bookRepository.count();

        assertThat(count).isEqualTo(1);
    }

    @Test
    void contextLoads() {
    }

}
