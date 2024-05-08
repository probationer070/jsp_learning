package ch07.sec01.exam01;

public class InheriteanceDemo {
	public static void main(String[] args) {
		
		Circle c1 = new Circle();
		Ball c2 = new Ball("검은");
		
		System.out.println("원 :");
		c1.findRadius();
		c1.FindArea();
		
		System.out.println("공 :");
		c2.findColor();
		c2.findRadius();
		c2.FindArea();
		c2.FindVolume();
	}
}
