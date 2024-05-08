package ch12.sec02;

public class DaemonExample extends Thread {
	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setDaemon(true);		// 데몬 스레드로 만듦
		autoSaveThread.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		System.out.println("메인 스레드 종료");
	}
}
