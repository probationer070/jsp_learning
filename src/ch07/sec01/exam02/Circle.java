package ch07.sec01.exam02;

public class Circle {
	private void secret() {
		System.out.println("비밀");
	}
	
	protected void findRadius() {
		System.out.println("radius : 10cm");
	}
	
	public void findArea() {
		System.out.println("Area : π * r * r");
	}
}
