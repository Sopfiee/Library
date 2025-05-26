package com.example.core;

/**
 * Класс книги с id, названием, автором и статусом доступности.
 */
public class Book {

    /**
     * Название книги.
     */
    private final String title;

    /**
     * Автор книги.
     */
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
     * @param titleParam  Название книги.
     * @param authorParam Автор книги.
     */
    public Book(final String titleParam, final String authorParam) {
        this.title = titleParam;
        this.author = authorParam;
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
     * @param availableParam новый статус доступности.
     */
    public void setAvailable(final boolean availableParam) {
        isAvailable = availableParam;
    }

    /**
     * Возвращает уникальный идентификатор книги.
     *
     * @return идентификатор книги.
     */
    public int getId() {
        return id;
    }

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
