package ch05.sec03;

public enum Week {
	
	/* 
	 열거형 상수에 특정 값을 지정해 같이 사용하고 싶을 때
	 1. 각 상수에 (값)을 넣고
	 2. private 값의 타입 변수; //  ex) private int(String) num(chars);
	 
	 3. 열거형 이름으로 생성자 만듦.
	 	열거형 이름 (값의 타입 변수) {
	 		this.변수 = 변수
	 	}
	 	
	 4. toString을 오버라이드 한다.
	 	public String toString() {
	 		return 변수;
	 		}
	 	
	 */
	MONDAY("월"),
	TUESDAY("화"), 
	WEDNESDAY("수"), 
	THURSDAY("목"), 
	FRIDAY("금"), 
	SATURDAY("토"), 
	SUNDAY("일");
	
	// 필드
	private String str;
	
	// 생성자
	Week (String str) {
		this.str = str;
	}
	
	// 메소드
	public String toString() {
		System.out.println("Overwriting");
		return str;
	}
	
	public String toString(String str) {
		System.out.println("Overwriting 2");
		return str;
	}
}
