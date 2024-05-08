package ch09.sec02.exam01;

public class Anonymous {
	Person field = new Person() {
		void work() {
			System.out.println("출근");
		}
		@Override
		void wake() {
			System.out.println("기상 6시");
			work();
		}
	};
	
	void method1() {
		Person localVar = new Person() {
			void walk() {
				System.out.println("산책");
			}
			@Override
			void wake() {
				System.out.println("기상 7시");
				walk();
			}
		};
		
		localVar.wake();
	}
	
	void method2(Person person) {
		person.wake();
	}
		
	
}
