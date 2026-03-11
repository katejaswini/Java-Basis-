package Polymorphism;

class A{
	//same contructor name +different parameter+ in same class = constructor overloading
	void A() {
		System.out.println("Draw a pitcure");
	}
	void A(int r) {
		System.out.println("Cirlce: "+2*3.14*r);
	}
	void A(int l, int b) {
		System.out.println("Rectangle: "+l*b);
	}
	
	//same method name+diff parameter+in same class = method overloading
	void draw() {
		System.out.println("Draw a pitcure");
		
	}
	void draw(int r) {
		System.out.println("Cirlce: "+2*3.14*r);
	}
	void draw(int l, int b) {
		System.out.println("Rectangle: "+l*b);
	}
}

public class overloading {
	public static void main(String args[]) {
		A a=new A();
		a.draw();
		a.draw(10);
		a.draw(10,20);
	}

}

