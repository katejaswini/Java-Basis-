package ComA;
class Parent{
	int site=5;
	int money=10000000;
	String car="BMW";
	String land="5 acers";
	private int brush=2;
	
	void use() {
		System.out.println("SITE :"+site);
		System.out.println("MONEY :"+money);
		System.out.println("CAR :"+car);
	}
	
}
class Child extends Parent{
	int money=5000;
	void use() {
		System.out.println("SITE :"+site);
		System.out.println("MONEY :"+money);
		System.out.println("Parent Money:" +super.money);
		
		System.out.println("TOTAL MONEY: "+(super.money+money));
		System.out.println("CAR:"+car);
		//
		//System.out.println("parent Brush" +brush);
	}
}

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p=new Parent();
		p.use();
		System.out.println("============");
		Child c=new Child();
		c.use();

	}

}
