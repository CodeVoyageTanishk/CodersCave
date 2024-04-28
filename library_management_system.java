import java.util.*;
class Book {
    private String title;
    private String author;
    private int id;
    private boolean available;
    public Book(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.available = true;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getId() {
        return id;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
class User {
    private String name;
    private int id;
    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
}
class Library {
    private List<Book> books;
    private List<User> users;
    private Map<Integer, User> borrowedBooks;
    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        borrowedBooks = new HashMap<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void addUser(User user) {
        users.add(user);
    }
    public void borrowBook(int bookId, int userId) {
        for (Book book : books) {
            if (book.getId() == bookId && book.isAvailable()) {
                borrowedBooks.put(bookId, users.get(userId));
                book.setAvailable(false);
                System.out.println("Book borrowed successfully.");
                return;
            }
        }
        System.out.println("Book not available.");
    }
    public void returnBook(int bookId) {
        if (borrowedBooks.containsKey(bookId)) {
            borrowedBooks.remove(bookId);
            for (Book book : books) {
                if (book.getId() == bookId) {
                    book.setAvailable(true);
                    System.out.println("Book returned successfully.");
                    return;
                }
            }
        }
        System.out.println("Book not found or not borrowed.");
    }
    public void displayBooks() {
        System.out.println("Books available in the library:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getId() + ": " + book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 2));
        library.addBook(new Book("1984", "George Orwell", 3));
        library.addUser(new User("Tanishk", 1));
        library.addUser(new User("Kaushik", 2));
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Borrow a book");
            System.out.println("2. Return a book");
            System.out.println("3. Display available books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter book ID to borrow: ");
                    int borrowId = scanner.nextInt();
                    System.out.print("Enter your user ID: ");
                    int userId = scanner.nextInt();
                    library.borrowBook(borrowId, userId - 1);
                    break;
                case 2:
                    System.out.print("Enter book ID to return: ");
                    int returnId = scanner.nextInt();
                    library.returnBook(returnId);
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }
}
