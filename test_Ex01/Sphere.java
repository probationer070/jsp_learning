package test_Ex01;

public class Sphere extends Circle {
	final double pi = 3.14;
	
	public Sphere(double rad) {
		super(rad);
	}
	
	public double area() {
		return 4 * rad * rad * pi;
	}
}
