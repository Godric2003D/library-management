package org.lms;

import org.lms.*;
import org.lms.model.Book;
import org.lms.model.Patron;
import org.lms.service.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize services
        BookService bookService = new BookService();
        PatronService patronService = new PatronService();
        LendingService lendingService = new LendingService(bookService, patronService);

        // Add sample books
        bookService.addBook(new Book("Harry Potter", "J.K. Rowling", "111", 2001));
        bookService.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "222", 1937));

        // Add a patron
        Patron patron = new Patron("P001", "Debayan Ray", "debayan@example.com");
        patronService.addPatron(patron);

        // Checkout and return
        lendingService.checkoutBook("P001", "111");
        lendingService.returnBook("P001", "111");

        // Show available books
        System.out.println("\n📚 Available Books:");
        List<Book> availableBooks = bookService.getAvailableBooks();
        if (availableBooks.isEmpty()) {
            System.out.println("None");
        } else {
            for (Book b : availableBooks) {
                System.out.println(b);
            }
        }

        // Show borrowed books
        System.out.println("\n📕 Borrowed Books:");
        List<Book> borrowedBooks = bookService.getBorrowedBooks();
        if (borrowedBooks.isEmpty()) {
            System.out.println("None");
        } else {
            for (Book b : borrowedBooks) {
                System.out.println(b);
            }
        }

        // Show borrowing history
        System.out.println("\n📜 Borrowing History for " + patron.getName() + ":");
        for (Book b : patron.getBorrowingHistory()) {
            System.out.println(b);
        }
    }
}
