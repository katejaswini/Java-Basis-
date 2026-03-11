package EmployeeManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Emp {
	    int id;
	    String name;
	    int age;
	    double salary;
	    String desig;
	    public Emp(int id, String name, int age, double salary, String desig) {
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.salary = salary;
	        this.desig = desig;
	    }
	    void display() {
	        System.out.println("----------------------------");
	        System.out.println("ID       : " + id);
	        System.out.println("Name     : " + name);
	        System.out.println("Age      : " + age);
	        System.out.println("Salary   : " + salary);
	        System.out.println("Desig    : " + desig);
	        System.out.println("----------------------------");
	    }
	}
	
	public class ex1 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        List<Emp> empList = new ArrayList<>();
	        int choice;
	        do {
	            System.out.println("\n==== EMPLOYEE MANAGEMENT (ArrayList) ====");
	            System.out.println("1. Add Employee (CREATE)");
	            System.out.println("2. View All Employees (READ)");
	            System.out.println("3. Update Salary by ID (UPDATE)");
	            System.out.println("4. Delete Employee by ID (DELETE)");
	            System.out.println("5. Exit");
	            System.out.print("Enter Choice: ");
	            choice = sc.nextInt();
	            switch (choice) {
	                case 1:     // CREATE
	                    System.out.print("Enter ID   : ");
	                    int id = sc.nextInt();
	                    System.out.print("Enter Name : ");
	                    String name = sc.next();
	                    System.out.print("Enter Age  : ");
	                    int age = sc.nextInt();
	                    System.out.print("Enter Salary: ");
	                    double sal = sc.nextDouble();
	                    System.out.print("Enter Desig: ");
	                    String desig = sc.next();
	                    empList.add(new Emp(id, name, age, sal, desig));
	                    System.out.println("Employee Added.");
	                    break;
	                case 2:     // READ
	                    if (empList.isEmpty()) {
	                        System.out.println("No employees to display.");
	                    } else {
	                        System.out.println("\n--- Employee Details ---");
	                        for (Emp e : empList) {
	                            e.display();
	                        }
	                    }
	                    break;
	                case 3:     // UPDATE
	                    System.out.print("Enter ID to update salary: ");
	                    int uid = sc.nextInt();
	                    boolean found = false;
	                    for (Emp e : empList) {
	                        if (e.id == uid) {
	                            System.out.print("Current Salary = " + e.salary +
	                                             ". Enter Increment Amount: ");
	                            double inc = sc.nextDouble();
	                            e.salary += inc;
	                            System.out.println("Salary updated. New Salary = " + e.salary);
	                            found = true;
	                            break;
	                        }
	                    }
	                    if (!found) {
	                        System.out.println("Employee not found.");
	                    }
	                    break;
	                case 4:     // DELETE
	                    System.out.print("Enter ID to delete: ");
	                    int did = sc.nextInt();
	                    Emp toRemove = null;
	                    for (Emp e : empList) {
	                        if (e.id == did) {
	                            toRemove = e;
	                            break;
	                        }
	                    }
	                    if (toRemove != null) {
	                        empList.remove(toRemove);
	                        System.out.println("Employee removed.");
	                    } else {
	                        System.out.println("Employee not found.");
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


