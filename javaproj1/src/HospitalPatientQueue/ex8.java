package HospitalPatientQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Patient {
    int id;
    String name;
    String problem;
    public Patient(int id, String name, String problem) {
        this.id = id;
        this.name = name;
        this.problem = problem;
    }
    void display() {
        System.out.println("[" + id + "] " + name + " - " + problem);
    }
}
// ---------- MAIN CLASS ---------
public class ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Patient> queue = new LinkedList<>();
        int choice;
        do {
            System.out.println("\n==== HOSPITAL PATIENT QUEUE (LinkedList) ====");
            System.out.println("1. Add Patient (Enqueue / CREATE)");
            System.out.println("2. Call Next Patient (Dequeue / DELETE)");
            System.out.println("3. View Waiting Patients (READ)");
            System.out.println("4. Peek First Patient (READ)");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID   : ");
                    int id = sc.nextInt();
                    System.out.print("Enter Patient Name : ");
                    String name = sc.next();
                    System.out.print("Enter Problem      : ");
                    String prob = sc.next();
                    queue.offer(new Patient(id, name, prob));
                    System.out.println("Patient added to queue.");
                    break;
                case 2:
                    Patient next = queue.poll();
                    if (next != null) {
                        System.out.print("Calling Patient: ");
                        next.display();
                    } else {
                        System.out.println("No patients in queue.");
                    }
                    break;
                case 3:
                    if (queue.isEmpty()) {
                        System.out.println("No patients waiting.");
                    } else {
                        System.out.println("Waiting Patients:");
                        for (Patient p : queue) {
                            p.display();
                        }
                    }
                    break;
                case 4:
                    Patient first = queue.peek();
                    if (first != null) {
                        System.out.print("First Patient: ");
                        first.display();
                    } else {
                        System.out.println("No patients in queue.");
                    }
                    break;
                case 5:
                    System.out.println("Clinic closed for the day.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}