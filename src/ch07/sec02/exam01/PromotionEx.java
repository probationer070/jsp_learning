package ch07.sec02.exam01;

class A {}

class B extends A {}
class C extends A {}

class D extends B {}
class E extends C {}

public class PromotionEx {
	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;
		
		B b1 = d;
		C c1 = e;
		
		// 클래스의 최상위 클래스인 Object에 저장됨
		Object o1 = b;
		Object o2 = e;
		
//		B b2 = e; // 서로 다른 클래스를 상속받고 있으므로 불가
//		C c2 = d;
	}
}
