package ch07.sec02.exam03;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();
		
		for (int i=1; i<=8; i++) {
			int problemLocation = car.run();
			
			switch(problemLocation) {
			case 1:
				System.out.println("앞좌측 타이어 교체");
				car.frontLeftTire = new HankookTire("앞좌측", 15);
				break;
			case 2:
				System.out.println("앞우측 타이어 교체");
				car.frontRightTire = new KumhoTire("앞우측", 13);
				break;
			case 3:
				System.out.println("뒤좌측 타이어 교체");
				car.backLeftTire = new HankookTire("뒤좌측", 14);
				break;
			case 4:
				System.out.println("뒤우측 타이어 교체");
				car.backRightTire = new KumhoTire("뒤우측", 17);
				break;

			}
			System.out.println("---------------------------------");
		}
	}
}
