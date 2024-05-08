package ch06.sec04;

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.setGas(10);
		
		boolean remain_gas = myCar.isleftGas();
		if (remain_gas) {
			System.out.println("go!");
			myCar.run();
		} 
		
		if (myCar.isleftGas()) {
			System.out.println("No more gas needed!");
		} else {
			System.out.println("Need gas");
		}
		
	}
}
