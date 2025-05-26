package com.example.core;

/**
 * Класс, представляющий пользователя библиотеки.
 * Пользователь может брать книгу взаймы и возвращать её.
 */
public class User {

    /**
     * Имя пользователя.
     */
    private final String name;

    /**
     * Книга, взятая пользователем в данный момент.
     * Может быть null, если книга не взята.
     */
    private Book borrowedBook;

    /**
     * Создает пользователя с заданным именем.
     *
     * @param nameParam имя пользователя
     */
    public User(final String nameParam) {
        this.name = nameParam;
        this.borrowedBook = null;
    }

    /**
     * Позволяет пользователю взять книгу, если у него нет текущей взятой книги
     * и книга доступна.
     *
     * @param book книга для взятия взаймы
     */
    public void borrowBook(final Book book) {
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

    /**
     * Возвращает книгу в библиотеку, если пользователь её взял.
     */
    public void returnBook() {
        if (borrowedBook != null) {
            borrowedBook.setAvailable(true);
            System.out.println(name + " returned: " + borrowedBook.getTitle());
            borrowedBook = null;
        } else {
            System.out.println(name + " has no book to return.");
        }
    }

    /**
     * Возвращает строковое представление пользователя,
     * включая информацию о взятой книге, если таковая есть.
     *
     * @return строка с именем пользователя и информацией о взятой книге
     */
    @Override
    public String toString() {
        return name + (borrowedBook != null ? " (has: "
            + borrowedBook.getTitle() + ")" : " (no books)");
    }

     /**
     * Возвращает книгу, взятую пользователем.
     *
     * @return книга, взятая взаймы, или null, если книги нет
     */
    public Book getBorrowedBook() {
        return borrowedBook;
    }
}
