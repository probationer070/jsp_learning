package ch09.sec02.exam01;

public class Parent {
	String name;
	public void talk(String name) {
		this.name = name;
		System.out.println(name+"talking");
	}
	public void wake() {
		System.out.println(name+" Wake up");
	}
}
