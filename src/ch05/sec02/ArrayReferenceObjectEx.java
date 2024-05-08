package ch05.sec02;

public class ArrayReferenceObjectEx {
	public static void main(String[] args) {
		String strArr[] = new String[3];
		
		strArr[0] = "Java";
		strArr[1] = "Java";
		strArr[2] = new String("Java");
		
		System.out.println( strArr[0] == strArr[1]);
		System.out.println( strArr[0] == strArr[2]);
		System.out.println( strArr[0].equals(strArr[2]));
	}
}
