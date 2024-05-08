package test_Ex01;

import java.util.Scanner;

public class NestedDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String grade;
		System.out.println("점수를 입력하세요: ");
		int score = sc.nextInt();
		
		if (score >= 90) {
			grade = "A";
		} else {
			if (score > 80) {
				grade = "B";
			} else {
				if (score > 70) {
					grade = "C";
				} else {
					if (score > 80) {
						grade = "D";
					}else {
						if (score > 80) {
							grade = "E";
							
						} else {
							grade = "F";
						}
					}
				}	
			}
		}
		System.out.println(grade);
	}
}
