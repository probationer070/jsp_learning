package ch07.sec03.exam01;

public abstract class Phone {
	public String owner;
	
	public Phone(String owner) {
		this.owner = owner;
	}
	
	public void turnOn() {
		System.out.println("ON");
	}
	
	public void turnoff() {
		System.out.println("OFF");
	}
}
