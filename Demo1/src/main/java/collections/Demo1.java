package collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

class Dev1{
	
}

public class Demo1 {

	public static void main(String[] args) {
		//List l =new List();// in list we cannot create object bz list is interface
		
		ArrayList al=new ArrayList();
		//if only for integer
		//ArrayList <Integer> al=new ArrayList<>();
		al.add(100);
		al.add(345);
		al.add(234);
		al.add("tejas");
		al.add(10.7);
		al.add(true);
		al.add(new Date());
		al.add(new Dev1());
		System.out.println(al);
		System.out.println("========");
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}
		System.out.println("=============");// instead of for loop to repeat the iteration we have iteration method
		Iterator i=al.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}

	}

}
