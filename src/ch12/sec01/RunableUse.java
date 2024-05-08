package ch12.sec01;

public class RunableUse implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0; i<10; i++)
			System.out.println("RunableUse에서 출력함"+i);
	}

}
