package org.lms.service;

import org.lms.model.Book;
import java.util.*;

public class BookService {
    private Map<String, Book> books = new HashMap<>();
    //private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    public void updateBook(String isbn, Book updatedBook) {
        books.put(isbn, updatedBook);
    }

    public Book searchByISBN(String isbn) {
        return books.get(isbn);
    }

    public List<Book> searchByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                results.add(book);
            }
        }
        return results;
    }

    public boolean isAvailable(String isbn) {
        Book book = books.get(isbn);
        return book != null && book.isAvailable();
    }

    public void markAsBorrowed(String isbn) {
        Book book = books.get(isbn);
        if (book != null) book.setAvailable(false);
    }

    public void markAsReturned(String isbn) {
        Book book = books.get(isbn);
        if (book != null) book.setAvailable(true);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }
    public List<Book> getAvailableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                available.add(book);
            }
        }
        return available;
    }

    public List<Book> getBorrowedBooks() {
        List<Book> borrowed = new ArrayList<>();
        for (Book book : books.values()) {
            if (!book.isAvailable()) {
                borrowed.add(book);
            }
        }
        return borrowed;
    }

}
