package ch07.sec03.exam01;

public abstract class Animal {
	public void slepp() {
		System.out.println("SLEEP");
	}
	
	public void eat() {
		System.out.println("EATING");
	}
	
	public abstract void sound();
}
