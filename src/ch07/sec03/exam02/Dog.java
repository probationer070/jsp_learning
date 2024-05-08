package ch07.sec03.exam02;

public class Dog extends Animal{
	public Dog() {
		this.kind = "Mammal";
	}
	
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
