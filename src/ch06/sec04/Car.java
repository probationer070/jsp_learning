package ch06.sec04;

public class Car {
	int gas;
	
	void setGas(int gas) {
		this.gas = gas;
	}
	
	boolean isleftGas() {
		if (gas == 0) {
			System.out.println("No gas!");
			return false;
		}
		System.out.println("Gas is remain!");
		return true;
	}
	
	void run() {
		while(true) {
			if(gas > 0) {
				System.out.println("Run! [ gas remain : "+gas+" ]");
				gas -= 1;
			} else {
				System.out.println("Stop! [ gas remain : "+gas+" ]");
				return;
			}
		}
	}
}
