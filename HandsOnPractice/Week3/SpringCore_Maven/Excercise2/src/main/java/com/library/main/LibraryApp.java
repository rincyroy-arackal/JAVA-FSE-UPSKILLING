package com.library.main;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryApp {
    public static void main(String[] args) {
        // Load context from applicationContext.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get bean from context
        BookService bookService = (BookService) context.getBean("bookService");

        // Test the method
        bookService.addBook("The Spring Way");

        ((ClassPathXmlApplicationContext) context).close();
    }
}
