package ch12.sec01;

public class User2 extends Thread{
	private Calculator calculator;
	
	public void setCalculator(Calculator calculator) {
		this.setName("User2");
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(50);
	}
}
