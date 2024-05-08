package test_Ex01;

public class Rectangle extends Shape{
	int height;
	int width;
	
	Rectangle(int height, int width) {
		this.height = height;
		this.width = width;
	}
	
	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("사각형을 그리다.");
	}
	
	public double findArea() {
		return width * height;
	}
}
