package StudentManagment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String course;
    int marks;
    public Student(int id, String name, String course, int marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }
    void display() {
        System.out.println("----------------------------");
        System.out.println("ID      : " + id);
        System.out.println("Name    : " + name);
        System.out.println("Course  : " + course);
        System.out.println("Marks   : " + marks);
        System.out.println("----------------------------");
    }
}

public class ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> stuList = new ArrayList<>();
        int choice;
        do {
            System.out.println("\n==== STUDENT MANAGEMENT (ArrayList) ====");
            System.out.println("1. Add Student (CREATE)");
            System.out.println("2. View All Students (READ)");
            System.out.println("3. Update Marks by ID (UPDATE)");
            System.out.println("4. Delete Student by ID (DELETE)");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: // CREATE
                    System.out.print("Enter ID     : ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name   : ");
                    String name = sc.next();
                    System.out.print("Enter Course : ");
                    String course = sc.next();
                    System.out.print("Enter Marks  : ");
                    int marks = sc.nextInt();
                    stuList.add(new Student(id, name, course, marks));
                    System.out.println("Student Added.");
                    break;
                case 2: // READ
                    if (stuList.isEmpty()) {
                        System.out.println("No students to display.");
                    } else {
                        for (Student s : stuList) {
                            s.display();
                        }
                    }
                    break;
                case 3: // UPDATE
                    System.out.print("Enter ID to update marks: ");
                    int uid = sc.nextInt();
                    boolean found = false;
                    for (Student s : stuList) {
                        if (s.id == uid) {
                            System.out.print("Current Marks = " + s.marks +
                                             ". Enter New Marks: ");
                            s.marks = sc.nextInt();
                            System.out.println("Marks Updated.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4: // DELETE
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    Student toRemove = null;
                    for (Student s : stuList) {
                        if (s.id == did) {
                            toRemove = s;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        stuList.remove(toRemove);
                        System.out.println("Student removed.");
                    } else {
                        System.out.println("Student not found.");
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