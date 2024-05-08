package ch09.sec02.exam04;

public class Anonymous {
	private int field;
	
	public void method(final int arg1, int arg2) {
		final int var1 = 0;
		int var2 = 0;
		
		field = 10;
		
//		arg1 = 20;	// (X)
//		arg2 = 20;
		
//		var1 = 30; // (X)
//		var2 = 30;

		Calculatable calc = new Calculatable() {
			
			//arg2는 외부에 선언된 것을 받을 수 없다
			//파라메터로 받아서 일반 클래스 안에서 선언되지 않으면 사용 불가
			// int arg2 = 20 -> 사용가능 따로 선언시
			// int var2 = 30 -> 사용가능 따로 선언시
			// 외부 클래스의 지역변수는 내부클래스에서 사용불가
			
			//이유1: 지역 변수는 매서드 블록이나 블록내에서만 유효하며 내부클래스는 별도의 블록으로 인식되기 때문
			//이유2: 컴파일 시점에서 지역변수는 스택메모리에 할당되고 메소드 종료 후에는 해제되는 반면에 
			// 내부 클래스는 힙 메모리에 할당되고 메서드 종료 후에도 유지되므로 내부클래스는 메서드 종료 후에는 
			// 더이상 존재하지 않는 지역변수에 접근 불가
			
			@Override
			public int sum() {
				int result = field + arg1 + arg2 + var1 + var2;
				return result;
			}
		};
		
		System.out.println(calc.sum());
	}
}
