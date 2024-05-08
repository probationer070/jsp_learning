package test_Ex01;

public class Circle_2 {
	double radius;
	
	public Circle_2(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	double findArea() {
		return 3.14 * radius * radius;
	}
}
