package ch07.sec01.exam04.other;

import ch07.sec01.exam04.One;

public class One2 extends One{
	void print() {
//		System.out.println(secret);	// private 사용불가
//		System.out.println(roommate); // default 다른 패키지서 사용불가
		System.out.println(child);		// protected 다른 패키지 자식 클래스여서 허용
		System.out.println(anybody);
	}
}
