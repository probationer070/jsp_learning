package ch06.sec05.exam04;

public class SingletonEx {
	public static void main(String[] args) {
		
		/*
		 * Singleton st1 = new Singleton(); 
		 * Singleton st2 = new Singleton();
		 */
		
		Singleton st1 = Singleton.getInstance();
		Singleton st2 = Singleton.getInstance();
		
		if(st1 == st2) {
			System.out.println("같은 Singleton 객체 입니다.");
		} else {
			System.out.println("다른 Singleton 객체 입니다.");
		}
	}
}
