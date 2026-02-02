import java.util.Scanner;

public class Book {

    // Book attributes
    int bookID;
    String title;
    String author;
    boolean isAvailable;

    // Constructor
    Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Display book
    void displayBook() {
        System.out.println(bookID + "\t" + title + "\t" + author + "\t" + isAvailable);
    }

    // MAIN METHOD (IMPORTANT)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book[] books = new Book[5];
        int count = 0;
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (count == books.length) {
                        System.out.println("Library is full");
                        break;
                    }

                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    books[count++] = new Book(id, title, author);
                    System.out.println("Book added successfully");
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = sc.nextInt();
                    boolean removed = false;

                    for (int i = 0; i < count; i++) {
                        if (books[i].bookID == removeId) {
                            books[i] = books[count - 1];
                            count--;
                            removed = true;
                            System.out.println("Book removed successfully");
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Book not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (books[i].bookID == searchId) {
                            System.out.println("ID\tTitle\tAuthor\tAvailable");
                            books[i].displayBook();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Book not found");
                    }
                    break;

                case 4:
                    if (count == 0) {
                        System.out.println("No books available");
                    } else {
                        System.out.println("ID\tTitle\tAuthor\tAvailable");
                        for (int i = 0; i < count; i++) {
                            books[i].displayBook();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);
    }
}
