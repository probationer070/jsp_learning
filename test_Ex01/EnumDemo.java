package test_Ex01;

public class EnumDemo {
	public static void main(String[] args) {
		Gender gender = Gender.MALE;
		if (gender == Gender.MALE)
			System.out.println(Gender.MALE + "은 병역의무가 있다.");
		else 
			System.out.println(Gender.FEMALE + "은 병역의무가 없다.");
		
//		if (gender == Direction.SOUTH)
//			System.out.println(Direction.SOUTH+ "는 누구?");
//		gender = 5;
	}
}

enum Gender { 
	MALE("남성"), FEMALE("여성");
	
	private String gender;
	
	Gender(String gender) {
		this.gender = gender;
	}
	
	public String toString() {
		return gender;
	}
}


enum Direction { 
	EAST("동쪽"), WEST("서쪽"), SOUTH("남쪽"), NORTH("북쪽");
	
	private String direction;
	
	Direction(String direction) {
		this.direction = direction;
	}
	
	public String toString() {
		return direction;
	}
}