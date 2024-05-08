package ch06.sec04;

public class Calculaotor {
	
	void powerOn() {
		System.err.println("Turn On");
	}
	
	int plus(int a, int b) {
		int res = a+b;
		return res;
	}
	
	double divide(int a, int b) {
//		double res = (double)a / (double)b;
		int res = a / b;
		return res;
	}
	
	void powerOff() {
		System.out.println("Turn Off");
	}
}