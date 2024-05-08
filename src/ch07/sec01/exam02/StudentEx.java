package ch07.sec01.exam02;

public class StudentEx {
	public static void main(String[] args) {
		Student std = new Student("박민규", "12345-12343", 0);
		
		System.out.println("Name : "+std.name);
		System.out.println("ssn : "+std.ssn);
		System.out.println("학생번호 : "+std.studentNo);
	}
}
