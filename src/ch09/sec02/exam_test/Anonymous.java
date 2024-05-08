package ch09.sec02.exam_test;

public class Anonymous {
	Worker field = new Worker() {
		@Override
		public void start() {
			System.out.println("DESIGNING SOMETHING");
		}
	};
	
	void method1() {
		Worker localVar = new Worker() {
			@Override
			public void start() {
				System.out.println("DEVELOPEMENT WHATTHE");
			}
		};
		localVar.start();
	}
	
	void method2(Worker worker) {
		worker.start();
	}
}
