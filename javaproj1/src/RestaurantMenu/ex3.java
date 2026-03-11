package RestaurantMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MenuItem {
    int id;
    String name;
    double price;
    public MenuItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    void display() {
        System.out.println("----------------------------");
        System.out.println("Item ID   : " + id);
        System.out.println("Item Name : " + name);
        System.out.println("Price     : " + price);
        System.out.println("----------------------------");
    }
}

public class ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MenuItem> menu = new ArrayList<>();
        int choice;
        do {
            System.out.println("\n==== RESTAURANT MENU (ArrayList) ====");
            System.out.println("1. Add Menu Item (CREATE)");
            System.out.println("2. View All Items (READ)");
            System.out.println("3. Update Price by ID (UPDATE)");
            System.out.println("4. Delete Item by ID (DELETE)");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: // CREATE
                    System.out.print("Enter Item ID   : ");
                    int id = sc.nextInt();
                    System.out.print("Enter Item Name : ");
                    String name = sc.next();
                    System.out.print("Enter Price     : ");
                    double price = sc.nextDouble();
                    menu.add(new MenuItem(id, name, price));
                    System.out.println("Item Added.");
                    break;
                case 2: // READ
                    if (menu.isEmpty()) {
                        System.out.println("No items in menu.");
                    } else {
                        for (MenuItem m : menu) {
                            m.display();
                        }
                    }
                    break;
                case 3: // UPDATE
                    System.out.print("Enter Item ID to update price: ");
                    int uid = sc.nextInt();
                    boolean found = false;
                    for (MenuItem m : menu) {
                        if (m.id == uid) {
                            System.out.print("Current Price = " + m.price +
                                             ". Enter New Price: ");
                            m.price = sc.nextDouble();
                            System.out.println("Price Updated.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Item not found.");
                    }
                    break;
                case 4: // DELETE
                    System.out.print("Enter Item ID to delete: ");
                    int did = sc.nextInt();
                    MenuItem toRemove = null;
                    for (MenuItem m : menu) {
                        if (m.id == did) {
                            toRemove = m;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        menu.remove(toRemove);
                        System.out.println("Item removed.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you, visit again!");
                    break;
                default:
                    System.out.println("Invalid choice.");

   
            }
        } while (choice != 5);
        sc.close();
   }
}
