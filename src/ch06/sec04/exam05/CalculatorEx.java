package ch06.sec04.exam05;

public class CalculatorEx {
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		double result1 = calc.areaRectangle(10);
		
		double result2 = calc.areaRectangle(10, 20);
		
		System.out.println(result1);
		System.out.println(result2);
	}
}
