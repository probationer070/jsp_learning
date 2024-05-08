package test_Ex01;

public class Dog extends Animal{

	@Override
	public void move() {
		System.out.println("정신사납다");
	}
	
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
