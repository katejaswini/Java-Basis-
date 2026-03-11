package Polymorphism;

class Bank{
	Bank(){
		System.out.println("hi welcome to bank");
	}
	public void roi() {
		System.out.println("10%");
	}
}
class Sbi extends Bank {
	/*constructor overriding is not possible in subclasses because
	 * class name and constructor name should be same
	 
	Bank(){
		System.out.println("hi");
	}
	*/
	
}
class Axis extends Bank{
	
	/*constructor overriding is not possible in subclasses because
	 * class name and constructor name should be same
	 
	Bank(){
		System.out.println("hi");
	}
	*/
	
	//only method overriding is possible 
	//same method name +same return type+same parameter type but different value is
	//method overriding
	public void roi() {
		System.out.println("12%");
	}
}

public class overriding {

	public static void main(String[] args) {
		Bank s=new Bank();s.roi();
		
		Axis a=new Axis();a.roi();

	}

}
