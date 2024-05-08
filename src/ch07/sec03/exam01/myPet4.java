package ch07.sec03.exam01;

public class myPet4 {

	public static void main(String[] args) {
		Animal p[] = {new Dog(), new Dog(), new Cat(), new Dog()};
		
		for(Animal p1: p) p1.sound(); 
	}

}
