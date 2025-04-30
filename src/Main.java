/*
                            Система управления библиотекой
Создать мини-систему для учёта книг и пользователей библиотеки. Реализовать 3 класса:
1. Класс Book - представляет книгу в библиотеке.
    Поля:
        String title
        String author
        boolean isAvailable
    Методы:
        Конструктор
        Геттеры/сеттеры
        Метод toString() для красивого вывода
2. Класс User - представляет читателя.
    Поля:
        String name
        Book borrowedBook (можно взять только одну книгу)
    Методы:
        Конструктор
        Метод borrowBook(Book book) — берёт книгу, если она доступна
        Метод returnBook() — возвращает книгу
        Метод toString()
3. Класс Library - класс библиотеки.
    Поля:
        List<Book> books
    Методы:
        addBook(Book book)
        showAvailableBooks()
        findBookByTitle(String title) — возвращает Book по названию
Задача:
    Создать несколько книг и пользователей.
    Дать пользователям взять и вернуть книги.
    Вывести доступные книги до и после операций.
 */

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));

        // Создание пользователей
        User alice = new User("Alice");
        User bob = new User("Bob");

        // Начальное состояние
        library.showAvailableBooks();
        System.out.println();

        // Операции
        alice.borrowBook(library.findBookByTitle("1984"));
        bob.borrowBook(library.findBookByTitle("1984")); // уже взята
        bob.borrowBook(library.findBookByTitle("The Hobbit"));
        System.out.println();

        // После взятия книг
        library.showAvailableBooks();
        System.out.println();

        // Возврат книг
        alice.returnBook();
        bob.returnBook();
        System.out.println();

        // После возврата
        library.showAvailableBooks();
        library.listAllBooks();
    }
}