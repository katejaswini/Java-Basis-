package HelpDeskTicketQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Ticket {
    int id;
    String issue;
    int priority; // 1 = High, 2 = Medium, 3 = Low
    public Ticket(int id, String issue, int priority) {
        this.id = id;
        this.issue = issue;
        this.priority = priority;
    }
    void display() {
        System.out.println("Ticket[" + id + "] (" + priority + ") - " + issue);
    }
}
// ---------- MAIN CLASS ---------
public class ex9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Ticket> pq =
                new PriorityQueue<>(Comparator.comparingInt(t -> t.priority));
        int choice;
        do {
            System.out.println("\n==== HELPDESK TICKET QUEUE (PriorityQueue) ====");
            System.out.println("1. Raise Ticket (CREATE)");
            System.out.println("2. Resolve Next Ticket (DELETE)");
            System.out.println("3. View All Tickets (READ)");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID   : ");
                    int id = sc.nextInt();
                    System.out.print("Enter Issue       : ");
                    String issue = sc.next();
                    System.out.print("Enter Priority(1-High,2-Med,3-Low): ");
                    int pr = sc.nextInt();
                    pq.offer(new Ticket(id, issue, pr));
                    System.out.println("Ticket raised.");
                    break;
                case 2:
                    Ticket t = pq.poll();
                    if (t != null) {
                        System.out.print("Resolving Ticket: ");
                        t.display();
                    } else {
                    }
                        System.out.println("No tickets in queue.");
                    break;
                case 3:
                    if (pq.isEmpty()) {
                        System.out.println("No tickets in queue.");
                    } else {
                        System.out.println("Pending Tickets (by internal order):");
                        for (Ticket tk : pq) {
                            tk.display();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Helpdesk closed.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
        sc.close();
    }
}