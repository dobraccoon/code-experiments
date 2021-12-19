package com.dobraccoon.springdatajpaexperiments;

import com.dobraccoon.springdatajpaexperiments.books.Book;
import com.dobraccoon.springdatajpaexperiments.books.BookRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
class ExperimentDataJpaTest {

	@Autowired
	private BookRepository bookRepository;

	@Rollback(value = false)
	@Order(1)
	@Test
	void BookRepositoryTest1() {
		bookRepository.save(new Book(""));
		long count = bookRepository.count();

		assertThat(count).isEqualTo(1);
		//After method end all transaction into method will rollback
	}

	@Order(2)
	@Test
	void BookRepositoryTest2() {
		//That's why this check will fail without @Rollback in previous test
		assertThat(bookRepository.count()).isEqualTo(1);
	}

	@Test
	void contextLoads() {
	}

}
