package ch06.sec05.exam02;

public class CalculatorEx02 {
	public static void main(String[] args) {
		double result1 = 10 * 10 * Calculator.pi;
		int result2 = Calculator.plus(10, 30);
		int result3 = Calculator.minus(100, 30);
		
		System.out.println("result1 : "+result1);
		System.out.println("result2 : "+result2);
		System.out.println("result3 : "+result3);
	}
}
