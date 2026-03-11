package NonAccessModifers;

//static class, static variable, static method


class Employee{
	int x=10000;         //instance variable
	static String company="SLK"; //static variable // can be accessed without creating object
	static void display() { //static method
		System.out.println("Hi display");
	}
	void abc() {
		
	}
}
public class ex1 {
	public static void main(String args[]) {
		//Employee e =new Employee();//with creating an object if sataic is not declared
		//e.display(); with displaying if static is not declared
		//System.out.println(e.company);
		System.out.println("================");
		
		Employee.display();//with static
		System.out.println(Employee.company);//with static
	}

}



