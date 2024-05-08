package ch06.sec06.exam05.package1;

public class B {
	
	public B() {
		A a = new A();
		a.field1 =1;
		a.field2 =1;
//		a.field3 =1; // 접근 불가(private)
		
		a.method1();
		a.method2();
//		a.method3(); // 접근 불가(private)
	}
}
