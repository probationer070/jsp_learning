package ch12.sec01;

import java.awt.Toolkit;

public class BeepThread extends Thread {
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i=0; i<5; i++) {
			toolkit.beep();
			System.out.println("Eod");
			try { Thread.sleep(500); } catch (Exception e) {}
		}
	}
}
