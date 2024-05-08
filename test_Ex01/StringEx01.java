package test_Ex01;

public class StringEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 묵시적 , 암시적 방법
		String s1 = "Hello, JAVA";
		String s2 = "Hello, JAVA";
		
		// 명시적 방법
		String s3 = new String("Hello, JAVA");
		
		
		if (s1 == s2) {
			System.out.println("같은 곳을 가리키고 있음");
		} else {
			System.out.println("다른 곳을 가리키고 있음");
		}

		if (s1 == s3) {
			System.out.println("같은 곳을 가리키고 있음");
		} else {
			System.out.println("다른 곳을 가리키고 있음");
		}

		if (s1.equals(s2)) {
			System.out.println("같은 내용");
		} else {
			System.out.println("다른 내용");
		}

		if (s1.equals(s3)) {
			System.out.println("같은 내용");
		} else {
			System.out.println("다른 내용");
		}
	}

}
