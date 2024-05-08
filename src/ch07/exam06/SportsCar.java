package ch07.sec01.exam06;

public class SportsCar extends Car {
	@Override
	public void speedUp() {speed += 10;}
	
//	@Override					// 재정의 불가
//	public void stop() {
//		System.out.println("스포츠카 정지");
//		speed = 0;
//	}
}
