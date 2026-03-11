package CourseRegistration;

import java.util.*;
public class ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> courses = new HashSet<>();
        int choice;
        do {
            System.out.println("\n==== COURSE REGISTRATION (HashSet) ====");
            System.out.println("1. Add Course (CREATE)");
            System.out.println("2. View All Courses (READ)");
            System.out.println("3. Remove Course (DELETE)");
            System.out.println("4. Check if Course Exists (READ)");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Course Name: ");
                    String c = sc.next();
                    if (courses.add(c)) {
                        System.out.println("Course Added.");
                    } else {
                        System.out.println("Course already exists.");
                    }
                    break;
                case 2:
                    if (courses.isEmpty()) {
                        System.out.println("No courses registered.");
                    } else {
                        System.out.println("Registered Courses:");
                        for (String s : courses) {
                            System.out.println("- " + s);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Course Name to remove: ");
                    String rc = sc.next();
                    if (courses.remove(rc)) {
                        System.out.println("Course removed.");
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Course Name to search: ");
                    String scourse = sc.next();
                    if (courses.contains(scourse)) {
                        System.out.println("Course is available.");
                    } else {
                        System.out.println("Course not found.");
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