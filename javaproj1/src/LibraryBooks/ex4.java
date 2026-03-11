package LibraryBooks;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class Book {
    int id;
    String title;
    String author;
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        Book b = (Book) obj;
        return this.id == b.id;
    }
    void display() {
        System.out.println("----------------------------");
        System.out.println("Book ID   : " + id);
        System.out.println("Title     : " + title);
        System.out.println("Author    : " + author);
        System.out.println("----------------------------");
    }
}

public class ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Book> bookSet = new HashSet<>();
        int choice;
        do {
            System.out.println("\n==== LIBRARY BOOKS (HashSet) ====");
            System.out.println("1. Add Book (CREATE)");
            System.out.println("2. View All Books (READ)");
            System.out.println("3. Update Title by ID (UPDATE)");
            System.out.println("4. Delete Book by ID (DELETE)");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: // CREATE
                    System.out.print("Enter Book ID   : ");
                    int id = sc.nextInt();
                    System.out.print("Enter Title     : ");
                    String title = sc.next();
                    System.out.print("Enter Author    : ");
                    String author = sc.next();
                    boolean exists = bookSet.contains(new Book(id, "", ""));
                    if (exists) {
                        System.out.println("Book with this ID already exists.");
                    } else {
                        bookSet.add(new Book(id, title, author));
                        System.out.println("Book Added.");
                    }
                    break;
                case 2: // READ
                    if (bookSet.isEmpty()) {
                        System.out.println("No books in library.");
                    } else {
                        for (Book b : bookSet) {
                            b.display();
                        }
                    }
                    break;
                case 3: // UPDATE
                    System.out.print("Enter Book ID to update title: ");
                    int uid = sc.nextInt();
                    Book toUpdate = null;
                    for (Book b : bookSet) {
                        if (b.id == uid) {
                            toUpdate = b;
                            break;
                        }
                    }
                    if (toUpdate != null) {
                        System.out.print("Enter New Title: ");
                        String newTitle = sc.next();
                        toUpdate.title = newTitle;
                        System.out.println("Title Updated.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4: // DELETE
                    System.out.print("Enter Book ID to delete: ");
                    int did = sc.nextInt();
                    Book toRemove = null;
                    for (Book b : bookSet) {
                        if (b.id == did) {
                            toRemove = b;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        bookSet.remove(toRemove);
                        System.out.println("Book removed.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}
