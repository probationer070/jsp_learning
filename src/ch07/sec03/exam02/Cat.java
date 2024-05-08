package ch07.sec03.exam02;

public class Cat extends Animal{
	public Cat() {
		this.kind = "Mammal";
	}
	
	@Override
	public void sound() {
		System.out.println("야옹야옹");
	}
}
