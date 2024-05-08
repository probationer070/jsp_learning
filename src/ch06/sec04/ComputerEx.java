package ch06.sec04;

public class ComputerEx {
	public static void main(String[] args) {
		Calculaotor myCal = new Calculaotor();
		
		myCal.powerOn();
		
		int result1 = myCal.plus(5, 10);
		System.out.println(result1);
		
		byte x =10;
		byte y =4;
		
		double result2 = myCal.divide(x, y);
		System.out.println(result2);
		
		myCal.powerOff();
	}
}
