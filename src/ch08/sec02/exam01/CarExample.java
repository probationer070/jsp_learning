package ch08.sec02.exam01;

public class CarExample {
	public static void main(String[] args) {
		Car my_car = new Car();
		
		my_car.run();
		
		my_car.FrontleftTire = new KumhoTire();
		my_car.FrontrightTire = new KumhoTire();
		
		my_car.run();

	}
}
