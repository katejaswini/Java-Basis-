package expections;

import java.util.InputMismatchException;
import java.util.Scanner;

public class demo1 {
	public static void main(String args[]) {
		m1();
	}
	static void m1() {
		m2();
		System.out.println("Hi m1");
	}
	static void m2() {
		m3();
		System.out.println("hi m2");
	}
	static void m3() {
		
			try{
				Scanner sc=new Scanner(System.in);
			
			//read two integers
			int n1=sc.nextInt();
			int n2=sc.nextInt();
			System.out.println(n1+"/"+n2+"="+(n1/n2));
			}
		
		catch(InputMismatchException e) {
			System.out.println("please enter the number only");
			 //one Exception in thread "main" java.util.InputMismatchException
		}
		catch(ArithmeticException ae) { 
			System.out.println("diving with 0 is not possible");
			
			//100/0 Exception in thread "main" java.lang.ArithmeticException: / by zero
		}
		finally {
			System.out.println("thank you");
		}
		
	}

}
