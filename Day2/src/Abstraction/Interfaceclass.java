package Abstraction;
interface I{
	//int a;//cannot be intialized without gving value
	int x=10;
	
	/*I(){
		//cannot have constructor
	}*/
	
	/*void abc{
		// cannot have non abstarct classes
	}*/
	
	abstract void abc();
	
interface J{
	
}
interface K extends I,J{
	//can have multiple inheritance
}
}
public class Interfaceclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
