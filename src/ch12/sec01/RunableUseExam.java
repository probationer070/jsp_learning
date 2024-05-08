package ch12.sec01;

public class RunableUseExam {

	public static void main(String[] args) {
		System.out.println("Main에서 출력");
		Thread a = new Thread(new RunableUse());
		Thread b = new Thread(new RunableUse2());
		
		a.start();
		b.start();
	}

}
