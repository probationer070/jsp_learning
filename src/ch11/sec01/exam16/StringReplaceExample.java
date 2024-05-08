package ch11.sec01.exam16;

public class StringReplaceExample {

	public static void main(String[] args) {
		String ssn= "4017125097029";
		int length = ssn.length();
		if (length == 13) {
			System.out.println("주민번호 자릿수가 맞습니다");
		} else {
			System.out.println("주민번호 자릿수가 맞지 않습니다");
		}
	}

}
