package ch06.sec04;

public class CarExample2 {
	public static void main(String[] args) {
		Car2 Mycar1 = new Car2();
		System.out.println(Mycar1.comp);
		System.out.println();

		Car2 Mycar2 = new Car2("SUV");
		System.out.println(Mycar2.comp);
		System.out.println(Mycar2.model);
		System.out.println();
		
		Car2 Mycar3 = new Car2("SUV", "WHITE");
		System.out.println(Mycar3.comp);
		System.out.println(Mycar3.model);
		System.out.println(Mycar3.color);
		System.out.println();
		
		Car2 Mycar4 = new Car2("SUV", "WHITE", 300);
		System.out.println(Mycar4.comp);
		System.out.println(Mycar4.model);
		System.out.println(Mycar4.color);
		System.out.println(Mycar4.maxSpeed);
	}
}
