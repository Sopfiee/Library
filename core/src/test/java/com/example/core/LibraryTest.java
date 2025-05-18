package com.example.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test 
    void testAddBook() {
        Library library = new Library();
        Book book = new Book("1984", "George Orwell");
        library.addBook(book);

        assertTrue(library.getBooks().contains(book));
    }

    @Test
    void testFindBookByTitle_found() {
        Library library = new Library();
        Book book = new Book("1984", "George Orwell");
        library.addBook(book);

        Book found = library.findBookByTitle("1984");
        assertNotNull(found);
        assertEquals("1984", found.getTitle());
    }

    @Test
    void testFindBookByTitle_notFound() {
        Library library = new Library();
        Book found = library.findBookByTitle("Nonexistent");
        assertNull(found);
    }

}
