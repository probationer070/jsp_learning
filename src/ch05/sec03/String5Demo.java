package ch05.sec03;

public class String5Demo {
	public static void main(String[] args) {
		Gender gender = Gender.FEMALE;
		gender = Gender.MALE;
		
		if (gender == Gender.MALE)
			System.out.println(Gender.MALE);
		else 
			System.err.println(Gender.FEMALE);
		
		/*
		 * if (gender == Direction.SOUTH) System.out.println(Direction.SOUTH); gender =
		 * 5;
		 */
	}
}

enum Direction {
	NORTH, SOUTH, EAST, WEST
}