package ch11.sec01.exam01;

public class EqualsExample01 {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		
		boolean b1 = obj1.equals(obj2);
		boolean b2 = obj1 == obj2;
		
		System.out.println(b1);
		System.out.println(b2);
		
		System.out.println("------------------");
		
		obj2 = obj1;
		b1 = obj1.equals(obj2);
		b2 = obj1 == obj2;
		
		System.out.println(b1);
		System.out.println(b2);
	}
}
