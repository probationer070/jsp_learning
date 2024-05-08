package ch07.sec02.exam03;

public class MyPets {

	public static void main(String[] args) {
		Animal a[] = {new Dog(), new Cat()};
		
//		a[0].eat();
//		a[1].move();
		
//		for (int i=0; i<a.length; i++) {
//			a[i].eat();
//			a[i].move();
//			a[i].sleep();
//		}
		
//		for(Animal a1: a) {
//			a1.sound();
//		}
		
		Mammals c[] = {(Mammals)a[0], (Mammals)a[1]};
		
		for(Mammals c1: c) {
			c1.sound();
		}
		
//		Mammals d[] = new Mammals[2];		//에러남
//		d = (Mammals[]) a;
//		
//		for(Mammals d1: d) {
//			d1.sound();
//		}
		
//		Mammals b[] = {new Dog(), new Cat(), new Dog()};
//		b[0].sound();
//		b[1].sound();
//		b[2].sound();
		
//		for(Animal b1: b) {
//			b1.sound();
//			b1.move();
//			b1.eat();
//			b1.sleep();
//		}
	}

}
