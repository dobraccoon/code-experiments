package com.dobraccoon.springdatajpaexperiments;

import com.dobraccoon.springdatajpaexperiments.books.Book;
import com.dobraccoon.springdatajpaexperiments.books.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpringDataJpaExperimentsApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Test
	void bookRepositoryTest() {
		bookRepository.save(new Book(""));
		bookRepository.save(new Book(""));
		bookRepository.save(new Book(""));

		/*
		If you run this test twice
		it would be problem because created objects didn't was removed
		 */
		assertThat(bookRepository.count()).isEqualTo(3);
	}

	@Test
	void contextLoads() {
	}

}
