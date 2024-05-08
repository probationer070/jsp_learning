package test_Ex01;

public class Circle {
	public double rad;
	final double pi = 3.14;
	
	public Circle() {}
	
	public Circle(double rad) {
		this.rad = rad;
	}
	
	public double area() {
		return rad * rad * pi;
	}
}
