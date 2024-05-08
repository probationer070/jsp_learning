package ch07.sec02.exam06;

class Mammals {
	public void sound() {
		
	}
}

class Dog extends Mammals {
	public void sound() {
		System.out.println("Bark!");
	}
}

class Cat extends Mammals {
	public void sound() {
		System.out.println("Meow!");
	}
}


public class MyPets3 {
	public static void main(String[] args) {
		Mammals p[] = {new Dog(), new Cat(), new Dog()};
		
		for (Mammals p1: p) {
			if (p1 instanceof Dog) {
				Dog d1 = (Dog) p1;
				d1.sound();
			} else if (p1 instanceof Cat) {
				Cat c1 = (Cat) p1;
				c1.sound();
			}
		}
	}
}
