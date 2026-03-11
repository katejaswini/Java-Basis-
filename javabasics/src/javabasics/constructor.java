package javabasics;

import java.util.Scanner;

class Employee{
	
	Scanner sc=new Scanner(System.in);
	int myid;
	String name;
	int age;
	int salary;
	String des;
	public Employee() {
		System.out.println("enter the name:");
		name=sc.next();
		
		System.out.println("enter the id:");
		myid=sc.nextInt();
		
		System.out.println("enter the Age:");
		age=sc.nextInt();
	
		System.out.println("enter the salary:");
		salary=sc.nextInt();
		
		System.out.println("enter the desgination:");
		des=sc.next();
		
	}
	
	void display() {
		
		System.out.println("my name is :"+name);
		System.out.println("My ID :"+myid);
		System.out.println("My Age is :"+age);
		System.out.println("My salary is :"+salary);
		System.out.println("My des is :"+des);
	}
}


public class constructor {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp=new Employee();
		emp.display();
		
		

	}

}
