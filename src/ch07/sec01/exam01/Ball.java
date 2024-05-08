package ch07.sec01.exam01;

public class Ball extends Circle{
	private String color;
	
	public Ball(String color) {
		this.color = color;
	}
	
	protected void findColor() {
		System.out.println(color+"색 공이다.");
	}
	
	public void FindVolume() {
		System.out.println("넓이 : π * 반지름 * 반지름 * 반지름");
	}
}
