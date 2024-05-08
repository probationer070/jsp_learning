package ch09.sec02.exam02;

public class AnonymousExample {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		
		anony.field.turnOn();
		anony.method1();
		anony.method2(
			new RemoteControl() {
				
				@Override
				public void turnOn() {
					// TODO Auto-generated method stub
					System.out.println("SmartTV on");
				}
				
				@Override
				public void turnOff() {
					// TODO Auto-generated method stub
					System.out.println("SmartTV off");
				}
			}
		);
	}
}
