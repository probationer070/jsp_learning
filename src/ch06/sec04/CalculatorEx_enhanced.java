package ch06.sec04;

import java.util.Scanner;

public class CalculatorEx_enhanced {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String numbers = sc.nextLine();
		String arr[] = numbers.split(" ");
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		int arr_conv[] = new int[arr.length];
		for (int i=0; i<arr.length; i++) {
			arr_conv[i] = Integer.parseInt(arr[i]);
		}
		
		Calculaotor_enhanced Calc_enh = new Calculaotor_enhanced();	
		Calc_enh.excute(arr_conv);
	}
}
