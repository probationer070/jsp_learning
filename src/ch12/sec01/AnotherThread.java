package ch12.sec01;

public class AnotherThread extends Thread {
	@Override
	public void run() {
		System.out.println("AnotherThread에서 출력함");
	}
}
