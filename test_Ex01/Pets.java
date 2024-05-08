package test_Ex01;

public abstract class Pets {
	public static void main(String[] args) {
		Animal mines[] = {new Cat(),
						  new Dog(),
						  new Crow()};
		
		mines[0].kind = "포유류";
		mines[1].kind = "포유류";
		mines[2].kind = "조류";
		
		for(Animal a : mines) {
			a.sound();
		}
		
		
	}
}
