import java.util.Scanner;

//using array in java and array list// we have many methods to use in array like sort, reverse, first, last
//but arrays are homogenous only one type of values it can take
//so for that we have Collections in java
public class Demo1 {
	public static void main(String[] args) {
		int arr[]= {3,2,3,5,6};
		for(int i=0;i<arr.length;i++) {
			System.out.println("I : "+arr[i]);//to print with for loop 
		}
		System.out.println("=========FOR EACH LOOP======");
		
		for(int x:arr) {
			System.out.println("I: "+x);// to print with for each loop
		}
		System.out.println("=======");
		int ar[]=new int[5];// creating array 
		ar[0]=111; ar[3]=333;// the input is already given
		ar[2]=222; ar[4]=444;
		
		for(int x: ar) {
			System.out.println("I: "+x);
		}
		// this is using the enter the input by the user
		System.out.println("====Enter the size of array===");
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		int a[]=new int[size];
		for(int i=0;i<size;i++) {
			a[i]=sc.nextInt();
			
		}
		for(int z :a) {
			System.out.println(z);
		}

	}

}
