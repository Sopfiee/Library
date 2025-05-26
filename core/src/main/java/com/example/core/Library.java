package com.example.core;

import java.util.ArrayList;
import java.util.List;


/**
 * Класс, представляющий библиотеку, содержащую коллекцию книг.
 * Позволяет добавлять, удалять книги, искать их и выводить
 * списки доступных и всех книг.
 */
public class Library {

    /**
     * Список книг в библиотеке.
     */
    private List<Book> books;

    /**
     * Создаёт новую пустую библиотеку.
     */
    public Library() {
        books = new ArrayList<>();
    }

    /**
     * Возвращает копию списка всех книг в библиотеке.
     *
     * @return список книг
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Добавляет книгу в библиотеку.
     *
     * @param bookParam книга для добавления
     */
    public void addBook(final Book bookParam) {
        books.add(bookParam);
    }

    /**
     * Удаляет книгу из библиотеки по её названию.
     *
     * @param titleParam название книги, которую нужно удалить
     * @return {@code true}, если книга была найдена и удалена, иначе {@code false}
     */
    public boolean removeBook(final String titleParam) {
        return books.removeIf(book -> book.getTitle().equals(titleParam));
    }

    /**
     * Выводит в консоль список доступных для чтения книг.
     * Если доступных книг нет, выводит соответствующее сообщение.
     */
    public void showAvailableBooks() {
        boolean any = false;
        System.out.println("Available books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
                any = true;
            }
        }
        if (!any) {
            System.out.println("Нет доступных книг");
        }
    }

     /**
     * Ищет книгу в библиотеке по названию без учёта регистра.
     *
     * @param titleParam название книги для поиска
     * @return объект книги, если найден, иначе {@code null}
     */
    public Book findBookByTitle(final String titleParam) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(titleParam)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Выводит в консоль список всех книг в библиотеке с их статусами.
     * Если библиотека пуста, выводит соответствующее сообщение.
     */
    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Библиотека пуста.");
        }
        else {
            System.out.println("All books:");
            for (Book book : books) {
                String status = book.isAvailable() ? "Доступна" : "Занята";
                System.out.println("ID: "
                    + book.getId() + " | Название: "
                    + book.getTitle() + " | Автор: "
                    + book.getAuthor() + " | Статус: " + status);
            }
        }
    }
}
