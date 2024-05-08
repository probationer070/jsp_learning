package ch09.sec02.exam01;

public class familyintro {
	public static void main(String[] args) {
		Parent f = new Parent();
		f.talk("홍길동");
		f.wake();
		
		Parent f1 = new Parent() {
			@Override
			public void talk(String name) {
				super.name = name;
				System.out.println("Baby"+name);
			}
			
			@Override
			public void wake() {
				System.out.println("Just Sleeping"+name);
			}
		};
		
		f1.talk("KIM");
		f1.wake();
	}

}
