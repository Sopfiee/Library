package com.example.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testBookConstructorAndGetters() {
        Book book = new Book("1984", "George Orwell");

        assertEquals("1984", book.getTitle());
        assertEquals("George Orwell", book.getAuthor());
        assertTrue(book.isAvailable());
        assertTrue(book.getId() > 0); // Просто проверим, что ID проставился
    }

    @Test
    void testSetAvailable() {
        Book book = new Book("1984", "George Orwell");

        book.setAvailable(false);
        assertFalse(book.isAvailable());

        book.setAvailable(true);
        assertTrue(book.isAvailable());
    }

    @Test
    void testToString_Available() {
        Book book = new Book("1984", "George Orwell");

        String str = book.toString();
        assertTrue(str.contains("1984"));
        assertTrue(str.contains("George Orwell"));
        assertTrue(str.contains("Доступна"));
    }

    @Test
    void testToString_NotAvailable() {
        Book book = new Book("1984", "George Orwell");
        book.setAvailable(false);

        String str = book.toString();
        assertTrue(str.contains("Занята"));
    }
}
