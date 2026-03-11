package ComA;
class A{
	A(){
		System.out.println ("A class constructor ");
		
	}
	A(int a){
		System.out.println("A class with parametrisez constructor");
	}
}

class B extends A{
	B(){
		System.out.println("B class constructor");
	}
	B(int a){
		System.out.println("B class with parametrized constructor");
	}
}
public class demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b1 = new B();
		System.out.println("==========");
		B b2= new B(100);
		//as soon as we create child class object
		//it will autamacitcally will call the super class as default

	}

}
