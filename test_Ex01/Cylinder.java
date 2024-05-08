package test_Ex01;

public class Cylinder extends Circle {
	public double height;
	final double pi = 3.14;
	
	public Cylinder(double height, double rad) {
		super(rad);
		this.height = height;
	}
	
	@Override
	public double area() {
		double res = height * 2 * pi * rad + super.area() * 2;
		return res;
	}
}
