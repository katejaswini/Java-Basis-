package NonAccessModifers;
//final class car  // if we are using that then we can't inherit the properties
class Car{
	final int speed=250;
	int model=2025;
	String color="red";
	
	//final void gare() // we cannot override if we use final in method
	void gare() {
		System.out.println("5 gare car");
	}
}

class Benz extends Car{
	
}
class Bmw extends Car{
	@Override
	void gare() {
		System.out.println("Auto gae car");
		//System.out.println(speed);
		//System.out.println(model);
		//System.out.println(color);
	}
}

public class ex2 {
	

	public static void main(String[] args) {
		//Car c=new Car();
		Benz c= new Benz();
		System.out.println(c.speed);
		//c.speed=250;// we cannot reassign once we have given the final variable
		//System.out.println(c.speed);
		c.gare();
		Bmw b=new Bmw();
		b.gare();

	}

}

//final keyword example

/*
class Emp{
	
}
class Clerk extends Emp{
	
}
final class Dev extends Emp{ // then I cannot inherit this class properties // this the use of final keyword
	
}

class Manager extends Emp{
	
}
*/









