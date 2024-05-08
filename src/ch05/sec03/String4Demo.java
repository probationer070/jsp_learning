package ch05.sec03;

public class String4Demo {
	public static void main(String[] args) {
		String[] week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SON"};
		String[] book = {"java", "oracle", "HTML"};
		
		for (String w : week) {
			System.out.println(w);
		}
		
		for (String b : book) {
			System.out.println(b);
		}
		
		week[3] = book[1];
		
		for(String w : week)
			System.out.println(w);
	}
}
