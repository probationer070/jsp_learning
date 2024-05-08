package ch12.sec01;

public class AnotherThreadUserExam extends Thread {
	public static void main(String[] args) {
		System.out.println("main에서 출력함");
	
		Thread a = new AnotherThread();	
		a.start(); // 스레드 시작
		
		Thread b = new BeepThread();
		b.start(); 
		
		
	}
}
