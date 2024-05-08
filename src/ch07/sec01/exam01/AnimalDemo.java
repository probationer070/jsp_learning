package ch07.sec01.exam01;

public class AnimalDemo extends Circle{
	public static void main(String[] args) {
		Animal a1 =  new Animal();
		Eagle e1 = new Eagle();
		Tiger t1 = new Tiger();
		Goldfish g1 = new Goldfish();
		
		Animal a2 = new Eagle();
		
		a1.sleep();
		a1.eat();
		
		e1.sleep();
		e1.eat();
		e1.fly();
		
		t1.sleep();
		t1.eat();
		t1.attack();
		
		g1.sleep();
		g1.eat();
		g1.swim();
		
		a2.sleep();
//		a2.fly();
	}
	
	
	
}
