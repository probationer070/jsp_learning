package test_Ex01;

public class AbstractClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle2 c = new Circle2(3);
		c.draw();
		System.out.printf("원의 넓이 : %.1f\n", c.findArea());
		
		Rectangle r = new Rectangle(3, 4);
		r.draw();
		System.out.printf("사각형의 넓이 : %.1f\n", r.findArea());
	}

}
