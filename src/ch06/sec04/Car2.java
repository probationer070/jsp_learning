package ch06.sec04;

public class Car2 {
	String comp = "hyeonDai";
	String model;
	String color;
	int maxSpeed;
	
	Car2 () {
		this("Audi", "RED", 31);
		System.out.println("Call 1");
	}
	
	Car2 (String model) {
		this(model, "black", 350);
		System.out.println("Call 2");
	}
	
	Car2 (String model, String color) {
		this(model, color, 350);
		System.out.println("Call 3");
	}
	
	Car2 (String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		System.out.println("Call 4");
	}
}
