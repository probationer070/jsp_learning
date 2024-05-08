package ch07.sec01.exam01;

public class Circle {
	private void secret() {
		System.out.println("비밀");
	}
	
	protected void findRadius() {
		System.out.println("반지름이 10cm이다");
	}
	
	public void FindArea() {
		System.out.println("넓이 : π * 반지름 * 반지름");
	}
}
