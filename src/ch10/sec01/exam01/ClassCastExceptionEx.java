package ch10.sec01.exam01;

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public class ClassCastExceptionEx {
	public static void main(String[] args) {
		Dog dog = new Dog();
		changeDog(dog);
		
		Cat cat = new Cat();
		changeDog(cat);
	}
	
	public static void changeDog(Animal animal) {
		if (animal instanceof Dog) {
			Dog dog = (Dog) animal;			
		} else {
			System.out.println("ClassCastException");
		}
	}
}
