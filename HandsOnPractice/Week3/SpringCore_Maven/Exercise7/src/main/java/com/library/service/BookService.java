package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private String libraryName;

    // Constructor Injection
    public BookService(String libraryName) {
        this.libraryName = libraryName;
    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String name) {
        System.out.println("[" + libraryName + "] Adding book...");
        bookRepository.save(name);
    }
}
