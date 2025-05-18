package com.example.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @Test
    void testRemoveBook_success() {
        Library library = new Library();
        Book book = new Book("1984", "George Orwell");
        library.addBook(book);

        boolean removed = library.removeBook("1984");

        assertTrue(removed);
        assertFalse(library.getBooks().contains(book));
    }

    @Test
    void testRemoveBook_notFound() {
        Library library = new Library();
        library.addBook(new Book("1984", "George Orwell"));

        boolean removed = library.removeBook("Brave New World");

        assertFalse(removed);
    }
    
    @Test
    void testShowAvailableBooks_withAvailableBooks() {
        Library library = new Library();
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("Brave New World", "Aldous Huxley");
        book2.setAvailable(false);
        library.addBook(book1);
        library.addBook(book2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        library.showAvailableBooks();

        String output = outContent.toString();
        assertTrue(output.contains("Available books:"));
        assertTrue(output.contains("1984"));
        assertFalse(output.contains("Brave New World"));

        System.setOut(System.out); // Восстановить стандартный вывод
    }

    @Test
    void testShowAvailableBooks_noAvailableBooks() {
        Library library = new Library();
        Book book1 = new Book("1984", "George Orwell");
        book1.setAvailable(false);
        library.addBook(book1);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        library.showAvailableBooks();

        String output = outContent.toString();
        assertTrue(output.contains("Нет доступных книг"));

        System.setOut(System.out);
    }

}
