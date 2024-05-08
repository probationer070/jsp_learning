package ch07.sec01.exam03;

public class ComputerExample {
	public static void main(String[] args) {
		int r = 10;
		
		Calculator calc1 = new Calculator();
		System.out.println(calc1.areaCircle(r));
		
		System.out.println("");
		
		Computer calc2 = new Computer();	
		System.out.println(calc2.areaCircle(r));
	}
}
