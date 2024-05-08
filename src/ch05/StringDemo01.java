package ch05;

public class StringDemo01 {
	public static void main(String[] args) {
		String str1 = "안녕";
		String str2 = "안녕";
		String str3 = new String("안녕");
		
		System.out.println(str1==str2); //true
		System.out.println(str2==str3); //true
		System.out.println(str1.equals(str2)); //true
		System.out.println(str1.equals(str3)); //true
		
	}
}
