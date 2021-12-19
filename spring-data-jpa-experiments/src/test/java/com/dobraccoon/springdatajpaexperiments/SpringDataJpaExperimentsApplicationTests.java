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
	void contextLoads() {
	}

}
