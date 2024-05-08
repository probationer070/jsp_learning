package ch06.sec05.exam02;

public class Circle {
	double radius;
	static int numOfCircles = 0;
	int numCircles = 0;
	
	public Circle(double radius) {
		this.radius = radius;
		numOfCircles++;
		numCircles++;
	}
}
