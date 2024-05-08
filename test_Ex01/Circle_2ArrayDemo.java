package test_Ex01;

public class Circle_2ArrayDemo {
	public static void main(String[] args) {
		Circle_2 circles[] = new Circle_2[5];
		
		for (int i=0; i < circles.length; i++) {
			circles[i] = new Circle_2(i+1.0);
			System.out.printf("원의 넓이(반지름 : %.1f) = %.2f\n", circles[i].radius, circles[i].findArea());
		}
	}
}
