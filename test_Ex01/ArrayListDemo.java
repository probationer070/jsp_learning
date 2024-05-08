package test_Ex01;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		ArrayList<Integer> scores = new ArrayList<>();
//		int data;
//		int sum = 0;
//		
//		while ((data = sc.nextInt()) >= 0) {
//			scores.add(data);
//		}
//		
//		for (int i=0; i < scores.size(); i++) {
//			sum += scores.get(i);
//		}
//		
//		System.out.println("Avg = "+ (double)sum / scores.size());
		
		ArrayList<String> array2 = new ArrayList<String>();
		array2.add("사과");
		array2.add("포도");
		array2.add("망고");
		array2.add("딸기");
		
		array2.remove("포도");
		
		System.out.println(array2);
		array2.add(0, "복숭아");

		System.out.println(array2);
	}

}
