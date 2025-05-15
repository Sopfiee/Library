package com.example.core;

public class User {
    private String name;
    private Book borrowedBook;

    public User(String name) {
        this.name = name;
        this.borrowedBook = null;
    }

    public void borrowBook(Book book) {
        if (borrowedBook != null) {
            System.out.println(name + " already has a borrowed book.");
        } else if (book.isAvailable()) {
            borrowedBook = book;
            book.setAvailable(false);
            System.out.println(name + " borrowed: " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is not available.");
        }
    }

    public void returnBook() {
        if (borrowedBook != null) {
            borrowedBook.setAvailable(true);
            System.out.println(name + " returned: " + borrowedBook.getTitle());
            borrowedBook = null;
        } else {
            System.out.println(name + " has no book to return.");
        }
    }

    @Override
    public String toString() {
        return name + (borrowedBook != null ? " (has: " + borrowedBook.getTitle() + ")" : " (no books)");
    }
}