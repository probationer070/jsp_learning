package ch06.sec02;

public class CarEx {
	public static void main(String[] args) {
		
		Car myCar = new Car();
		
		System.out.println(myCar.comp);
		System.out.println(myCar.model);
		System.out.println(myCar.color);
		System.out.println(myCar.maxSpeed);
		System.out.println(myCar.speed);
		
		myCar.speed = 60;
		System.out.println(myCar.speed);
		
	}
}
