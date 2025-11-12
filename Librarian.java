public class Librarian {
    private String name;

    // Constructor
    public Librarian(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void displayInfo() {
        System.out.println("Librarian: " + name);
    }
}