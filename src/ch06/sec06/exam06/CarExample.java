package ch06.sec06.exam06;

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.setspeed(-50);
		
		System.out.println("Current SPEED : "+myCar.getspeed());
		myCar.setspeed(60);
		System.out.println("Current SPEED : "+myCar.getspeed());
		
		if(!myCar.isStop()) {
			myCar.setStop(true);
		}
		
		System.out.println("Current SPEED : "+myCar.getspeed());
		
	}
}
