package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

public class Demo5 {

	public static void main(String[] args) {
		//MAPS
		HashMap map=new HashMap(); //no duplicate+no order
		//LinkedHashMap map=new LinkedHashMap(); //no duplicates + user order
		//TreeMap map=new TreeMap(); // no duplicates+ sorted order
		
		map.put(777,"Rakesh");
		map.put(888,"Rajesh");
		map.put(555,"Ramesh");
		map.put(222,"ganesh");
		map.put(333,"suresh");
		map.put(777,"Parveen");
		
		Set s=map.entrySet();
		Iterator i=s.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}

	}

}
