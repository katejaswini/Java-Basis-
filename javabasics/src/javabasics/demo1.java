package javabasics;

import java.util.Scanner;

public class demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hi");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the name:");
		String name=sc.next();
		
		System.out.println("enter the id:");
		int Id=sc.nextInt();
		
		System.out.println("enter the Age:");
		int age=sc.nextInt();
	
		System.out.println("enter the salary:");
		int salary=sc.nextInt();
		
		System.out.println("enter the desgination:");
		String des=sc.next();
		
		System.out.println("my name is :"+name);
		System.out.println("My ID :"+Id);
		System.out.println("My Age is :"+age);
		System.out.println("My salary is :"+salary);
		System.out.println("My des is :"+des);
		

	}

}
