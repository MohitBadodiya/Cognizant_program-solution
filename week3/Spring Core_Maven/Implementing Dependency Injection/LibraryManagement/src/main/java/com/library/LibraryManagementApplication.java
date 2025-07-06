package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

public class LibraryManagementApplication {

	public static void main(String[] args) {
		// Load application context from XML file
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve BookService bean from container
		BookService bookService = context.getBean("bookService", BookService.class);

		// Call the service method
		bookService.displayBook();
	}
}
