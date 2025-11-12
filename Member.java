import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private List<Book> borrowedBooks;

    // Constructor
    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Borrow a book
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Return a book
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    // Show all borrowed books
    public void viewBorrowedBooks() {
        System.out.println("\n--- Borrowed Books ---");
        if (borrowedBooks.isEmpty()) {
            System.out.println("You have not borrowed any books.");
        } else {
            for (Book b : borrowedBooks) {
                System.out.println(b);
            }
        }
    }
}