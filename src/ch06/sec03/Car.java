package ch06.sec03;

public class Car {
	public String color;
	public int cc;
	
	public Car () {
		this("black", 3000);
		System.out.println("Car() call");
	}
	
	public Car (String color, int cc) {
		this.color = color;
		this.cc = cc;
		System.out.println("Car (String color, int cc) call");
	}
}
