package com.example.core;

/**
 * Класс книги с id, названием, автором и статусом доступности.
 */
public class Book {

    private final String title;
    private final String author;

    /**
     * Доступность книги.
     */
    private boolean isAvailable;

    /**
     * Счётчик id.
     */
    private static int idCounter = 1;

    /**
     * Уникальное id.
     */
    private final int id;

    /**
     * Конструктор для создания новой книги.
     *
     * @param title_  Название книги.
     * @param author_ Автор книги.
     */
    public Book(String title_, String author_) {
        this.title = title_;
        this.author = author_;
        this.isAvailable = true;
        this.id = idCounter++;
    }

    /**
     * Возвращает название книги.
     *
     * @return название книги.
     */
    public String getTitle() {
        return title;
    }

     /**
     * Возвращает автора книги.
     *
     * @return автор книги.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Проверяет доступность книги.
     *
     * @return true, если книга доступна, иначе false.
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Устанавливает статус доступности книги.
     *
     * @param available_ новый статус доступности.
     */
    public void setAvailable(boolean available_) {
        isAvailable = available_;
    }

    /**
     * Возвращает уникальный идентификатор книги.
     *
     * @return идентификатор книги.
     */
    public int getId() { return id; }

    /**
     * Возвращает строковое представление книги.
     *
     * @return строковое представление книги
     */
    @Override
    public String toString() {
        return "ID: " + id 
            + " | Название: " + title 
            + " | Автор: " + author 
            + " | Статус: " + (isAvailable ? "Доступна" : "Занята");
    }
}
