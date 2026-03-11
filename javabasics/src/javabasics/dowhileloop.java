package javabasics;

import java.util.Scanner;

class Clerk {
    Scanner sc = new Scanner(System.in);
    int myid, age;
    String name;
    int salary = 10000;
    String des = "Clerk";

    public Clerk() {
        System.out.print("Enter the name: ");
        name = sc.next();
        System.out.print("Enter the id: ");
        myid = sc.nextInt();
        System.out.print("Enter the age: ");
        age = sc.nextInt();
    }

    void display() {
        System.out.println("====================");
        System.out.println("Name: " + name);
        System.out.println("ID: " + myid);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Designation: " + des);
    }
}

class Dev {
    Scanner sc = new Scanner(System.in);
    int myid, age;
    String name;
    int salary = 20000;
    String des = "Developer";

    public Dev() {
        System.out.print("Enter the name: ");
        name = sc.next();
        System.out.print("Enter the id: ");
        myid = sc.nextInt();
        System.out.print("Enter the age: ");
        age = sc.nextInt();
    }

    void display() {
        System.out.println("====================");
        System.out.println("Name: " + name);
        System.out.println("ID: " + myid);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Designation: " + des);
    }
}

class Tester {
    Scanner sc = new Scanner(System.in);
    int myid, age;
    String name;
    int salary = 30000;
    String des = "Tester";

    public Tester() {
        System.out.print("Enter the name: ");
        name = sc.next();
        System.out.print("Enter the id: ");
        myid = sc.nextInt();
        System.out.print("Enter the age: ");
        age = sc.nextInt();
    }

    void display() {
        System.out.println("====================");
        System.out.println("Name: " + name);
        System.out.println("ID: " + myid);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Designation: " + des);
    }
}

class Manager {
    Scanner sc = new Scanner(System.in);
    int myid, age;
    String name;
    int salary = 50000;
    String des = "Manager";

    public Manager() {
        System.out.print("Enter the name: ");
        name = sc.next();
        System.out.print("Enter the id: ");
        myid = sc.nextInt();
        System.out.print("Enter the age: ");
        age = sc.nextInt();
    }

    void display() {
        System.out.println("====================");
        System.out.println("Name: " + name);
        System.out.println("ID: " + myid);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Designation: " + des);
    }
}

public class dowhileloop {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int ch1, ch2, ch3;

        Clerk c = null;
        Dev d = null;
        Tester t = null;
        Manager m = null;

        do {
            System.out.println("\n1. CREATE");
            System.out.println("2. DISPLAY");
            System.out.println("3. EXIT");
            ch1 = sc.nextInt();

            if (ch1 == 1) {
                do {
                    System.out.println("\n1. CLERK");
                    System.out.println("2. DEVELOPER");
                    System.out.println("3. TESTER");
                    System.out.println("4. MANAGER");
                    System.out.println("5. EXIT");
                    ch2 = sc.nextInt();

                    if (ch2 == 1) c = new Clerk();
                    else if (ch2 == 2) d = new Dev();
                    else if (ch2 == 3) t = new Tester();
                    else if (ch2 == 4) m = new Manager();

                } while (ch2 != 5);
            }

            if (ch1 == 2) {
                do {
                    System.out.println("\n1. CLERK");
                    System.out.println("2. DEVELOPER");
                    System.out.println("3. TESTER");
                    System.out.println("4. MANAGER");
                    System.out.println("5. EXIT");
                    ch3 = sc.nextInt();

                    if (ch3 == 1 && c != null) c.display();
                    else if (ch3 == 2 && d != null) d.display();
                    else if (ch3 == 3 && t != null) t.display();
                    else if (ch3 == 4 && m != null) m.display();
                    else if (ch3 != 5) System.out.println("Data not created yet!");

                } while (ch3 != 5);
            }

        } while (ch1 != 3);

        System.out.println("Thank you...");
    }
}
