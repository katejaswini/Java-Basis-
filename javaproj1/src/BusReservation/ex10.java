package BusReservation;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Passenger {
    int id;
    String name;
    String fromCity;
    String toCity;
    public Passenger(int id, String name, String fromCity, String toCity) {
        this.id = id;
        this.name = name;
        this.fromCity = fromCity;
        this.toCity = toCity;
    }
    void display() {
        System.out.println("[" + id + "] " + name + " (" + fromCity + " -> " + toCity + ")");
    }
}
// ---------- MAIN CLASS ---------
public class ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Passenger> waitlist = new LinkedList<>();
        int choice;
        do {
            System.out.println("\n==== BUS WAITLIST (LinkedList) ====");
            System.out.println("1. Add Passenger to Waitlist (CREATE)");
            System.out.println("2. Confirm Next Passenger (DELETE)");
            System.out.println("3. View Waitlist (READ)");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Passenger ID   : ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name           : ");
                    String name = sc.next();
                    System.out.print("Enter From City      : ");
                    String from = sc.next();
                    System.out.print("Enter To City        : ");
                    String to = sc.next();
                    waitlist.offer(new Passenger(id, name, from, to));
                    System.out.println("Passenger added to waitlist.");
                    break;
                case 2:
                    Passenger p = waitlist.poll();
                    if (p != null) {
                        System.out.print("Confirming Seat for: ");
                        p.display();
                    } else {
                        System.out.println("No passengers in waitlist.");
                    }
                    break;
                case 3:
                    if (waitlist.isEmpty()) {
                        System.out.println("Waitlist is empty.");
                    } else {
                        System.out.println("Current Waitlist:");
                        for (Passenger ps : waitlist) {
                            ps.display();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Bus booking system closed.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
        sc.close();
    }
}