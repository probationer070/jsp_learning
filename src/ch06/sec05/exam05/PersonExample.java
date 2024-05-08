package ch06.sec05.exam05;

public class PersonExample {
	public static void main(String[] args) {
		Person p1 = new Person("123456-1234567", "박성현");
		
		System.out.println(p1.nation);
		System.out.println(p1.name);
		System.out.println(p1.ssn);
		
//		p1.ssn = "234-253"	이미 정의된 값을 수정할 수 없음
		p1.name = "김길현";
	}
}
