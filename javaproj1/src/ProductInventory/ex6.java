package ProductInventory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product {
    int id;
    String name;
    int quantity;
    double price;
    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    void display() {
        System.out.println("----------------------------");
        System.out.println("Product ID   : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Price        : " + price);
        System.out.println("----------------------------");
    }
}

public class ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Product> productMap = new HashMap<>();
        int choice;
        do {
            System.out.println("\n==== PRODUCT INVENTORY (HashMap) ====");
            System.out.println("1. Add Product (CREATE)");
            System.out.println("2. View All Products (READ)");
            System.out.println("3. Update Quantity by ID (UPDATE)");
            System.out.println("4. Delete Product by ID (DELETE)");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID   : ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name         : ");
                    String name = sc.next();
                    System.out.print("Enter Quantity     : ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price        : ");
                    double price = sc.nextDouble();
                    if (productMap.containsKey(id)) {
                        System.out.println("Product ID already exists.");
                    } else {
                        productMap.put(id, new Product(id, name, qty, price));
                        System.out.println("Product Added.");
                    }
                    break;
                case 2:
                    if (productMap.isEmpty()) {
                        System.out.println("No products in inventory.");
                    } else {
                        for (Product p : productMap.values()) {
                            p.display();
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Product ID to update quantity: ");
                    int uid = sc.nextInt();
                    Product p = productMap.get(uid);
                    if (p != null) {
                        System.out.print("Current Qty = " + p.quantity + ". Enter New Qty: ");
                        p.quantity = sc.nextInt();
                        System.out.println("Quantity Updated.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Product ID to delete: ");
                    int did = sc.nextInt();
                    if (productMap.remove(did) != null) {
                        System.out.println("Product removed.");
                    } else {
                        System.out.println("Product not found.");
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