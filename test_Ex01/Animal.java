package test_Ex01;

public abstract class Animal {
	public String kind;
	
	public final void eat(String bite) {
		System.out.println(bite+"먹는다");
	}
	public abstract void move();
	public abstract void sound();
}
