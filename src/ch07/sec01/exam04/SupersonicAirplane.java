package ch07.sec01.exam04;

public class SupersonicAirplane extends Airplane {
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 1;
	
	public int flyMode = NORMAL;
	
	public void fly() {
		if (flyMode == SUPERSONIC) {
			System.out.println("초음속비행");
		} else {
			super.fly();
		}
	}
}
