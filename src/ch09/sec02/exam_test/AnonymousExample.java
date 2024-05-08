package ch09.sec02.exam_test;

public class AnonymousExample {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();	
		
		anony.field.start();
		anony.method1();
		
		anony.method2(
			new Worker() {
				@Override
				public void start() {
					System.out.println("TESTING ANYTHING");
				}
			}
		);
	}
}
