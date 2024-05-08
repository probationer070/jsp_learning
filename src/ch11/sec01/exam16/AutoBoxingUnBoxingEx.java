package ch11.sec01.exam16;

public class AutoBoxingUnBoxingEx {

	public static void main(String[] args) {
		// 박싱
		Integer obj = 100;
		System.out.println("value: " + obj.intValue());
		
		int value = obj;
		System.out.println("value: " + value);
		
		int result = obj + 100;
		System.out.println("result: " + result);
	}

}
