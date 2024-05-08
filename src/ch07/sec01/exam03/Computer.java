package ch07.sec01.exam03;

public class Computer extends Calculator{
	@Override	// 어노테이션, 컴퓨터에게 정보 알려주기 위함, 생략가능
	double areaCircle(double r) {
		System.out.println("Computer.areaCircle()");
		return r * r * Math.PI;
	}
}
