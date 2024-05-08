package test_Ex01;

public class Circle2 extends Shape {
	int radius;
	
	Circle2(int radius) {
		this.radius = radius;
	}
	
	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("원을 그리다.");
	}
	
	public double findArea() {
		return pi * radius * radius;
	}
}
