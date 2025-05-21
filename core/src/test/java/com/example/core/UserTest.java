package com.example.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("Alice");
    }

    @Test
    void testBorrowBook_Success() {
        Book mockBook = mock(Book.class);
        when(mockBook.isAvailable()).thenReturn(true);
        user.borrowBook(mockBook);
        assertEquals(mockBook, user.getBorrowedBook());
        verify(mockBook).setAvailable(false);
    }

    @Test
    void testBorrowBook_AlreadyBorrowed() {
        Book firstBook = mock(Book.class);
        when(firstBook.isAvailable()).thenReturn(true);
        user.borrowBook(firstBook);

        Book secondBook = mock(Book.class);
        when(secondBook.isAvailable()).thenReturn(true);
        user.borrowBook(secondBook);

        assertEquals(firstBook, user.getBorrowedBook());
        verify(secondBook, never()).setAvailable(false);
    }

    @Test
    void testBorrowBook_BookNotAvailable() {
        Book mockBook = mock(Book.class);
        when(mockBook.isAvailable()).thenReturn(false);
        user.borrowBook(mockBook);
        assertNull(user.getBorrowedBook());
        verify(mockBook, never()).setAvailable(false);
    }

    @Test
    void testReturnBook_WhenBorrowed() {
        Book mockBook = mock(Book.class);
        when(mockBook.isAvailable()).thenReturn(true);
        user.borrowBook(mockBook);

        user.returnBook();
        assertNull(user.getBorrowedBook());
        verify(mockBook).setAvailable(true);
    }

    @Test
    void testReturnBook_NoBook() {
        user.returnBook(); // ничего не должно упасть
        assertNull(user.getBorrowedBook());
    }
}
