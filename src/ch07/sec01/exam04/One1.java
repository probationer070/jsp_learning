package ch07.sec01.exam04;

public class One1 extends One {
	void print() {
//		System.err.println(secret); // Private 선언된 것 사용불가
		System.out.println(roommate);
		System.out.println(child);
		System.out.println(anybody);
	}
	
	//public void show() {} // Override는 상위 클래스보다 범위가 넓거나 같아야 한다.
}
