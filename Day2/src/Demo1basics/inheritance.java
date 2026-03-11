package Demo1basics;

class A{
	int a=10000;
}

class B extends A{
	//constructor
	B(){//no return type constructor name and class name should be same
		System.out.println("Hi B class");
	}
	void abc() {
		System.out.println("Hi ABC method");
	}
	int a=1000;
	//method
	void display() {// we have return type in 
		System.out.println(a);//100 // to call the same class
		System.out.println(this.a);//1000 // to call the current class contrustor
		System.out.println(super.a);//10000 //to call the parent class
	}
}

public class inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b=new B(); 
		//b.abc();//here we call the display method manually
		b.display();

	}

}
