package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

public class LibraryManagementApplication {

	public static void main(String[] args) {
		// Load Spring container from XML
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve BookService bean and call its method
		BookService bookService = context.getBean("bookService", BookService.class);
		bookService.displayBook();
	}
}
