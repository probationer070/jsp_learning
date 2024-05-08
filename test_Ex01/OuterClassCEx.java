package test_Ex01;

public class OuterClassCEx {

	public static void main(String[] args) {
		// 외부 클래스 생성
		OutsideClass outer = new OutsideClass();
		// 외부클래스안에 있는 내부 클래스 타입이고 inner 라는 래퍼런스 변수에
		// outer가 가리키는 객체안에 있는 내부클래스 생성자 호출
		OutsideClass.InsideClass inner = outer.new InsideClass();
		inner.InsideClassMethod();
		
		outer.OutsideClassMethod();
		
	}

}
