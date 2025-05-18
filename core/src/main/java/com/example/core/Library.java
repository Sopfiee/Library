package com.example.core;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(String title) {
        return books.removeIf(book -> book.getTitle().equals(title));
    }

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

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Библиотека пуста.");
            return;
        }
        else {
            System.out.println("All books:");
            for (Book book : books) {
                String status = book.isAvailable() ? "Доступна" : "Занята";
                System.out.println("ID: " + book.getId() + " | Название: " + book.getTitle() + " | Автор: " + book.getAuthor() + " | Статус: " + status);
            }
        }
    }

}