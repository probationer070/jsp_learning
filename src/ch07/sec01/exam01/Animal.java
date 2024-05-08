package ch07.sec01.exam01;

public class Animal extends Circle{
	String eye;
	String mouth;
	void eat() {System.out.println("EAT");};
	void sleep() {System.out.println("ZZZ");};
}
class Eagle extends Animal {
	String wing;
	void fly() {System.out.println("FLY");};
}

class Tiger extends Animal {
	String Claw;
	void attack() {System.out.println("ATTACK");};
}

class Goldfish extends Animal {
	String fin;
	void swim() {System.out.println("SWIM");};
}
	
	
	

