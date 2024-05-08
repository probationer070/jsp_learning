package ch12.sec01;

public class RunableUse2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0; i<50; i++)
			System.out.println("RunableUse2에서 출력함"+i);
	}

}
