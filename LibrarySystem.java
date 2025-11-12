import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {

    private static List<Book> books = new ArrayList<>();
    private static Member member = new Member("Rachel");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        addSampleBooks();

        System.out.println("Welcome to the Library Management System!");
        System.out.println("Are you a: ");
        System.out.println("1. Librarian");
        System.out.println("2. Member");
        System.out.print("Enter your choice (as a number from list): ");
        int role = scanner.nextInt();

        if (role == 1) {
            librarianMenu(scanner);
        } else if (role == 2) {
            memberMenu(scanner);
        } else {
            System.out.println("Invalid option. Exiting...");
        }

        scanner.close();
    }

    // Librarian menu
    private static void librarianMenu(Scanner scanner) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("\nLibrarian Menu: ");
            System.out.println("1. View all books");
            System.out.println("2. Add a new book");
            System.out.println("3. Remove a book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice (as a number from list): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                viewAllBooks();
            } else if (choice == 2) {
                System.out.print("Enter book ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();
                System.out.print("Enter book author: ");
                String author = scanner.nextLine();
                books.add(new Book(id, title, author));
                System.out.println("Book added!");
            } else if (choice == 3) {
                System.out.print("Enter book ID to remove: ");
                int id = scanner.nextInt();
                Book toRemove = null;
                for (Book b : books) {
                    if (b.getId() == id) {
                        toRemove = b;
                        break;
                    }
                }
                if (toRemove != null) {
                    books.remove(toRemove);
                    System.out.println("Book removed!");
                } else {
                    System.out.println("Book not found.");
                }
            } else if (choice == 0) {
                System.out.println("Goodbye, librarian!");
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Member menu
    private static void memberMenu(Scanner scanner) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("\nMember Menu: ");
            System.out.println("1. View all books");
            System.out.println("2. Search for a book");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. View borrowed books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice == 1) {
                viewAllBooks();
            } else if (choice == 2) {
                searchBook(scanner);
            } else if (choice == 3) {
                borrowBook(scanner);
            } else if (choice == 4) {
                returnBook(scanner);
            } else if (choice == 5) {
                member.viewBorrowedBooks();
            } else if (choice == 0) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Sample books
    private static void addSampleBooks() {
        books.add(new Book(001, "Charlotte's Web", "E. B. White"));
        books.add(new Book(002, "The Cat in the Hat", "Dr. Seuss"));
        books.add(new Book(003, "Green Eggs and Ham", "Dr. Seuss"));
        books.add(new Book(004, "The Giving Tree", "Shel Silverstein"));
        books.add(new Book(005, "The Very Hungry Caterpillar", "Eric Carle"));
    }

    private static void viewAllBooks() {
        System.out.println("\nBook List: ");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private static void searchBook(Scanner scanner) {
        System.out.print("Enter a word from the title: ");
        String keyword = scanner.next();
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found.");
        }
    }

    private static void borrowBook(Scanner scanner) {
        System.out.print("Enter book ID to borrow: ");
        int id = scanner.nextInt();
        for (Book b : books) {
            if (b.getId() == id && b.isAvailable()) {
                b.setAvailable(false);
                member.borrowBook(b);
                System.out.println("You borrowed: " + b.getTitle());
                return;
            }
        }
        System.out.println("Book not found or already borrowed.");
    }

    private static void returnBook(Scanner scanner) {
        System.out.print("Enter book ID to return: ");
        int id = scanner.nextInt();
        for (Book b : member.getBorrowedBooks()) {
            if (b.getId() == id) {
                b.setAvailable(true);
                member.returnBook(b);
                System.out.println("You returned: " + b.getTitle());
                return;
            }
        }
        System.out.println("You don't have that book borrowed.");
    }
}
