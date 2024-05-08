package test_Ex01;

public class Cat extends Animal{

	@Override
	public void move() {
		System.out.println("날아간다");
	}
	
	@Override
	public void sound() {
		System.out.println("까악까악");
	}
}
