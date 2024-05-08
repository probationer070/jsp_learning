package ch06.sec06.exam05.package2;

import ch06.sec06.exam05.package1.A;
import ch06.sec06.exam05.package1.B;

public class C {
	public C() {
		A a = new A();
		a.field1=1;
//		a.field2=1; // 다른 패키지 (default)
//		a.field3=1; // 다른 클래스 (private)
		
		a.method1();
//		a.method2(); // 다른 패키지 (default)
//		a.method3(); // 다른 클래스 (private)
		
		B b = new B(); // 생성자 호출 가능, 필드가 없음 -> 생성자만 사용가능
	}
}
