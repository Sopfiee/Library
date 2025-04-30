public class Book {
    private String title;
    private String author;
    private boolean isAvailable;
    private static int idCounter = 1;
    private final int id;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.id = idCounter++;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getId() { return id; }

    @Override
    public String toString() {
        return "ID: " + id +
           " | Название: " + title +
           " | Автор: " + author +
           " | Статус: " + (isAvailable ? "Доступна" : "Занята");
    }
}