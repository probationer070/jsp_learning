package ch07.sec01.exam02;

public class BallExample extends Circle{
	public static void main(String[] args) {
		Ball b1 = new Ball("Banta BLACK");
		Circle c1 = new Circle();
		
		System.out.println("CIRCLE");
		c1.findRadius();
		c1.findArea();
		
		System.out.println();
		
		System.out.println("BALL");
		b1.findRadius();
		b1.findColor();
		b1.findArea();
		b1.findVolume();
	}
}
