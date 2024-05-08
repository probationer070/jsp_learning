package ch05.sec03;

public class ConstantDemo {
	public static void main(String[] args) {
		//
		String version = String.format("%s %d", "JDK", 14);
		System.out.println(version);
		
		String fruits = String.join(",", "apple", "banana", "cherru", "durain");
		System.out.println(fruits);
		
		String pi = String.valueOf(3.14);
		System.out.println(pi);
	}
}
