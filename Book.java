public class Book {
    private int id;
    private String title;
    private String author;
    private boolean available;

    // Constructor
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    // Set book availability
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // How the book prints when shown
    public String toString() {
        return id + ". " + title + " by " + author + (available ? " (Available)" : " (Borrowed)");
    }
}