package ch11.sec01.exam16;

public class StringSubstringExample {

	public static void main(String[] args) {
		String ssn= "401712-5097029";
		
		String firstNum= ssn.substring(0, 6);
		System.out.println(firstNum);
		
		String SecondNum= ssn.substring(7);
		System.out.println(SecondNum);
	}

}
