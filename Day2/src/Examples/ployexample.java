package Examples;

import java.util.Scanner;

class Employee {
    Scanner sc = new Scanner(System.in);
    int myid, age;
    String name;
    int salary;
    String des;

    public Employee() {
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

class Clerk extends Employee {
    Clerk() {
        salary = 20000;
        des = "CLERK";
    }
}

class Developer extends Employee {
    Developer() {
        salary = 30000;
        des = "DEVELOPER";
    }
}

class Tester extends Employee {
    Tester() {
        salary = 40000;
        des = "TESTER";
    }
}

class Manager extends Employee {
    Manager() {
        salary = 50000;
        des = "MANAGER";
    }
}

public class ployexample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int ch1, ch2;

        Employee emp = null;

        do {
            System.out.println("\n1. CREATE");
            System.out.println("2. DISPLAY");
            System.out.println("3. EXIT");
            ch1 = sc.nextInt();

            if (ch1 == 1) {
                System.out.println("\n1. CLERK");
                System.out.println("2. DEVELOPER");
                System.out.println("3. TESTER");
                System.out.println("4. MANAGER");
                ch2 = sc.nextInt();

                if (ch2 == 1) emp = new Clerk();
                else if (ch2 == 2) emp = new Developer();
                else if (ch2 == 3) emp = new Tester();
                else if (ch2 == 4) emp = new Manager();
            }

            if (ch1 == 2) {
                if (emp != null)
                    emp.display();
                else
                    System.out.println("No employee created yet!");
            }

        } while (ch1 != 3);

        System.out.println("Thank you...");
    }
}

