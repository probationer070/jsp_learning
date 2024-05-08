package ch07.sec02.exam02;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

public class Child extends Parent{
	@Override
	public void method2() {
		System.out.println("Child-method2()");
	}

	public void method3() {
		System.out.println("Child-method3()");
	}
	/*
	 @Override : @들어가서 단어를 입력 ---> 어노테이션
	 
	 role 1) 컴파일러에게 문법 에러 체크하도록 정보 제공
		  2) 프로그램 빌드 시 코드를 자동으로 생성할 수 있도록 정보 제공
	 	  3) 런타임(실행)에 특정 기능을 실행하도록 정보 제공
	 
	 종류
	 	표준 어노테이션 : 기본 제공(자바)
	 	@Override, @Deprecated, @FuntionalInterface,
	 	@SuppressWarnings(경고제거), @SafeVarargs(제너릭에서 경고 없애기)
	 	
	 	메타 어노테이션 : 어노테이션에 붙이는 어노테이션,
	 	@Target @Documented @Inherited @Retention @Repeatable
	 	
	 	사용자 정의 어노테이션 : 개발자(사용자)가 만들어서 사용하는 어노테이션
	 	
	 	사용안해도 무관
	 * */
}
