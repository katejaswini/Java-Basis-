package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

abstract class Employee {
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

    abstract void raiseSalary();

    void display() {
        System.out.println("====================");
        System.out.println("Name: " + name);
        System.out.println("ID: " + myid);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Designation: " + des);
    }
}

final class Clerk extends Employee {

    public Clerk() {
        salary = 20000;
        des = "CLERK";
    }

    @Override
    void raiseSalary() {
        salary += 2000;
    }
}

final class Developer extends Employee {

    public Developer() {
        salary = 30000;
        des = "DEVELOPER";
    }

    @Override
    void raiseSalary() {
        salary += 5000;
    }
}

final class Tester extends Employee {

    public Tester() {
        salary = 40000;
        des = "TESTER";
    }

    @Override
    void raiseSalary() {
        salary += 4000;
    }
}

final class Manager extends Employee {

    public Manager() {
        salary = 50000;
        des = "MANAGER";
    }

    @Override
    void raiseSalary() {
        salary += 8000;
    }
}

public class excollection1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int ch1, ch2;
        ArrayList<Employee> al = new ArrayList<>();

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

                    if (ch2 == 1) al.add(new Clerk());
                    else if (ch2 == 2) al.add(new Developer());
                    else if (ch2 == 3) al.add(new Tester());
                    else if (ch2 == 4) al.add(new Manager());

                } while (ch2 != 5);
            }

            if (ch1 == 2) {
                Iterator<Employee> i = al.iterator();
                while (i.hasNext()) {
                    Employee e = i.next();
                    e.raiseSalary();  
                    e.display();
                }
            }

        } while (ch1 != 3);

        System.out.println("Thank you...");
    }
}
