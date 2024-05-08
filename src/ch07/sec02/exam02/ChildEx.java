package ch07.sec02.exam02;


public class ChildEx {
	public static void main(String[] args) {
		Child child = new Child();
		
		Parent parent = child;
		parent.method1();
		parent.method2();
		
		Child child2 = (Child) parent;
		child2.method2();
		child2.method3();
		
		Parent parent2 = new Child();
		parent2.method1();
		parent2.method2();
	}
}
