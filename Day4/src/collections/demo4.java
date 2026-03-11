package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class demo4 {
	public static void main(String args[]) {
		//List : will allow duplicates 
		//ArrayList al=new ArrayList();//best for search// worst for add/remove
		//LinkedList al=new LinkedList();//best for add/remove  // worst for search
		//Vector al=new Vector();// it's legacy
		//Stack al=new Stack();
		
		//Set dpoes'nt allow duplicates
		//HashSet al= new HashSet();// no duplicates +no order
		//LinkedHashSet al=new LinkedHashSet();// no duplicates+user order
		TreeSet al=new TreeSet();// no duplicates + sorted order
		
		al.add(100);
		al.add(222);
		al.add(222);
		al.add(436);
		al.add(893);
		al.add(457);
		al.add(783);
		Iterator i=al.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}


}
