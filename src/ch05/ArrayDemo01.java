package ch05;

public class ArrayDemo01 {
	public static void main(String[] args) {
		int scores[] = new int[5];
		
		for (int i=0; i<5; i++) {
			scores[i] = 50;
		}
		
		for (int i=0; i<5; i++) {
			System.out.println("score["+i+"]: "+scores[i]);
		}
		
		String str[] = new String[5];
		for (int i=0; i<5; i++) {
			str[i] = "안녕";
		}
		
		for (int i=0; i<5; i++) {
			System.out.println("score["+i+"]: "+str[i]);
		}
	}
}
