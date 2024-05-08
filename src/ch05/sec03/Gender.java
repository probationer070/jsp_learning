package ch05.sec03;

public enum Gender {
	FEMALE("여성"),
	MALE("남성");
	
	// 필드
	private String gender;
	
	// 생성자
	Gender (String gender) {
		this.gender = gender;
	}
	
	// 메소드
	public String toString() {
		return gender;
	}
}
