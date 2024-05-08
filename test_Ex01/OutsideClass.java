package test_Ex01;

public class OutsideClass {
	public class InsideClass {
		void InsideClassMethod() {
			System.out.println("외부클래스 안에 있는 내부 클래스의 메소드 실행시 출력됨.");
		}
	}
	
	public interface innerinterface {
		void innerinfabstMethod();
	}
	
	public static class staticinnerCl {
		void staticinnerClMethod() {
			System.out.println("외부 클래스의 정적내부클래스에 있는 메소드 실행");
		}
	}
	
	public void OutsideClassMethod() {
		class OutsClMethodClass {
			String s1 = "local";
			void OutsMethodinClMethod() {
				System.out.println("지역 클래스의 메소드를 실행했음.");
			}
		}
		OutsClMethodClass lc = new OutsClMethodClass();
		System.out.println(lc.s1);
		lc.OutsMethodinClMethod();
		
	}
}
