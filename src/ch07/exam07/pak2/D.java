package ch07.sec01.exam07.pak2;

import ch07.sec01.exam07.pak1.A;

public class D extends A{	
	public D() {
		super();		// 접근 불가
		this.field = "value";
		this.method();
	}
}
