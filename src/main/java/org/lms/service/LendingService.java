package org.lms.service;

import org.lms.model.Book;
import org.lms.model.Patron;

public class LendingService {
    private BookService bookService;
    private PatronService patronService;

    public LendingService(BookService bookService, PatronService patronService) {
        this.bookService = bookService;
        this.patronService = patronService;
    }

    public void checkoutBook(String patronId, String isbn) {
        Patron patron = patronService.getPatron(patronId);
        Book book = bookService.searchByISBN(isbn);

        if (patron == null || book == null) {
            System.out.println("Checkout failed: Patron or Book not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed.");
            return;
        }

        bookService.markAsBorrowed(isbn);
        patron.borrowBook(book);
        System.out.println(patron.getName() + " borrowed " + book.getTitle());
    }

    public void returnBook(String patronId, String isbn) {
        Patron patron = patronService.getPatron(patronId);
        Book book = bookService.searchByISBN(isbn);

        if (patron == null || book == null) {
            System.out.println("Return failed: Patron or Book not found.");
            return;
        }

        bookService.markAsReturned(isbn);
        patron.returnBook(book);
        System.out.println(patron.getName() + " returned " + book.getTitle());
    }
}
