package ch07.sec01.exam04;

public class SupersonicAirplaneEx {
	public static void main(String[] args) {
		SupersonicAirplane pl = new SupersonicAirplane();
		
		pl.takeOff();
		pl.fly();
		pl.flyMode = SupersonicAirplane.SUPERSONIC;
		pl.fly();
		pl.flyMode = SupersonicAirplane.NORMAL;
		pl.fly();
		pl.land();
		
	}
}
