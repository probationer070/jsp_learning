package ch08.sec02.exam01;

public class Car {
	Tire FrontleftTire = new HankookTire();
	Tire FrontrightTire = new HankookTire();
	Tire BackleftTire = new KumhoTire();
	Tire BackrightTire = new KumhoTire();
	
	void run() {
		FrontleftTire.roll();
		FrontrightTire.roll();
		BackleftTire.roll();
		BackrightTire.roll();
	}
}
