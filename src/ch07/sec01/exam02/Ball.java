package ch07.sec01.exam02;

public class Ball extends Circle{
	public String color;
	
	public Ball(String color) {
		this.color=color;
	}
	
	public void findColor() {
		System.out.println(color+"공");
	}
	
	public void findArea() {
		System.out.println("Area : π * r * r");
	}
	
	public void findVolume() {
		System.out.println("Volume : 4/3 * π * r^3 ");
	}
}
