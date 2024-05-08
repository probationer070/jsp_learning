package test_Ex01;

public class outerClinfimpl implements OutsideClass.innerinterface{

	@Override
	public void innerinfabstMethod() {
		// TODO Auto-generated method stub
		System.out.println("어떤 외부클래스안에 있는 내부 인터페이스를 구현한 메소드에서 실행함");
	}
	
	public static void main(String[] args) {
		outerClinfimpl o = new outerClinfimpl();
		o.innerinfabstMethod();
		
		// 정적(static) 붙어있는 경우는 공공으로 사용되므로 위치만 정확히 알려주면 사용가능
		OutsideClass.staticinnerCl sc = new OutsideClass.staticinnerCl();
		
		sc.staticinnerClMethod();
	}
	
}
