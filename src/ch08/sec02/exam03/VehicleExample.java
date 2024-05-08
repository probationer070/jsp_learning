package ch08.sec02.exam03;

public class VehicleExample {
	public static void main(String[] args) {
		
		Vehicle vehicle = new Bus();
		
		vehicle.run();
//		vehicle.checkFare(); // vehicle 인터페이스에는 checkFare()가 없음
		
		Bus bus = (Bus) vehicle;
		
		bus.run();
		bus.checkFare();
	}
}
