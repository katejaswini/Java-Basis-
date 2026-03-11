package stringmethods;

public class demo1 {

	public static void main(String[] args) {
		String n1="Suresh";
		String n2="Suresh";
		String n3="suresh";
		String n4=new String("Suresh");
		String n5=new String("Suresh");
		System.out.println(n1==n2);
		System.out.println(n1==n3);
		System.out.println(n1==n4);
		System.out.println(n4==n5);//reference it takes // string pool
		System.out.println(n4.equals(n5));// it takes the value// string pool
		
		String name="suResH Is a jAvA TrAiner";
		System.out.println(name);
		System.out.println(name.length());
		System.out.println(name.trim().length());
		System.out.println(name.startsWith("s"));
		//so like this many string methods are can be used
		
		String words[]=name.split(" ");
		for(String wrd:words) {
			System.out.println(wrd);
		}
		n1.concat("kumar");//will not happen because of string pool // String is immutable
		//so we can use string buffer
		StringBuffer sb=new StringBuffer("Developer");// mutable
		System.out.println(sb);
		sb.append("sr"); System.out.println(sb);
		sb.reverse(); System.out.println(sb);
		sb.insert(0, "sr "); System.out.println(sb);
		
		
		//String ab="tejaswini";
		//System.out.println(ab.concat(" K A"));//String pool
		
		

	}

}
