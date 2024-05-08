package ch07.sec01.exam02;

public class Student extends People{
	public int studentNo;
	
	public Student(String name, String ssn, int studentNo) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.studentNo = studentNo;
	}
}
