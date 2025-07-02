package org.lms.model;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String id;
    private String name;
    private String email;
    private List<Book> borrowedBooks;
    private List<Book> borrowingHistory;

    public Patron(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
        this.borrowingHistory = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
    public List<Book> getBorrowingHistory() { return borrowingHistory; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        borrowingHistory.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return String.format("Patron[%s]: %s", id, name);
    }
}
