package ch07.sec02.exam03;

public class MyPets2 {

	public static void main(String[] args) {
		Dog d1 = new Dog();
		Cat c1 = new Cat();
		
		Mammals p1 = d1;	// 자동 형변환
		Mammals p2 = c1;
		
		Dog d2 = (Dog) p1;	// 강제 형변환
		Cat c2 = (Cat) p2;
		d2.sound();
		c2.sound();
		
		Dog d3;
//		d3.sound();		// 컴파일 오류는 없음.
		if (p2 instanceof Dog) {
			d3 = (Dog) p2;
			d3.sound();
		} else {
			System.out.println("캐스팅 불가");
		}
		
	}

}
