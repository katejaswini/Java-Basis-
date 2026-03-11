package Exceptionexamples;

//all these are built in expections
public class demo1 {

	public static void main(String[] args) {
		
		//ArithmeticExpection
		//int a=10/0;
		//System.out.println(a);
		
	
		String name="sandesh";
		System.out.println(name.length());
		name=null;//NullPointerExpection
		//System.out.println(name.length());
		
		//ArrayIndexOutOfBoundExpection
		int arr[]= {50,20,30,50,600};
		System.out.println(arr[3]);
		//System.out.println(arr[6]);
		
		
		String num="100A";
		System.out.println(num);
		//NumberFormatExpection
		//int x=Integer.parseInt(num);// when converting string to integer
		//System.out.println(x);
		
		//InputMismatchExpection
	}

}
