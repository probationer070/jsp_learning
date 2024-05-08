package ch11.sec01.exam16;

public class StringIndexOfExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String subject = "자바 프로그래밍";
		
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		
		if (subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책");
		} else {
			System.out.println("자바와 관련업는 책");			
		}
	}

}
