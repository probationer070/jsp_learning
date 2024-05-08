package ch05;

public class StringDemo02 {
	public static void main(String[] args) {
		// 선언할 때 hobby라는 객체 변수(참조 변수에 값이 없다. 즉 가리키고 있는 객체가 없다.
		String hobby = null;
		// 여행이라는 객체를 만들고 hobby가 여행이라는 객체의 참조값을 갖는다
		hobby = "여행";
		
		System.out.println(hobby);
	}
}
