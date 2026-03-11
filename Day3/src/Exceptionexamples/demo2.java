package Exceptionexamples;

import java.util.Scanner;
import java.io.*;

// how to create custom exceptions//user defined
//to create the first create a constructor and then extend the class from the super class

class A{
	void display() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the age");
		int age=sc.nextInt();
		if(age> 60) {
			throw new InvalidAgeException("Age must be less than 60");
		}
		else if(age <18) {
			throw new InvalidAgeException("Age must be greater than 18");

		}
		else {
			System.out.println("Age is ok");
		}
	}
}
public class demo2 {

	public static void main(String[] args) {
		try {
			A a=new A();
			a.display();
		}
		catch(InvalidAgeException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {}

	}

}
class InvalidAgeException extends RuntimeException{
	InvalidAgeException(String msg){
		super(msg);
	}
}
