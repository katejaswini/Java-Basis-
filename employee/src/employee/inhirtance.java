package employee;

import java.util.Scanner;


class Employee{
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
class clerk extends Employee{
	public clerk() {
		salary=20000;
		des="CLERK";
	}
}
class Developer extends Employee{
	public Developer() {
		salary=30000;
		des="DEVELOPER";
	}
}
class Tester extends Employee{
	public Tester() {
		salary=40000;
		des="TESTER";
	}
}
class Manager extends Employee{
	public Manager() {
		salary=50000;
		des="MANAGER";
	}
}

public class inhirtance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int ch1, ch2, ch3;

        clerk c = null;
        Developer d = null;
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

                    if (ch2 == 1) c = new clerk();
                    else if (ch2 == 2) d = new Developer();
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


