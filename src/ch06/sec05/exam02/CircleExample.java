package ch06.sec05.exam02;

public class CircleExample {
	public static void main(String[] args) {
		Circle myCircle = new Circle(10.0);
		Circle yourCircle = new Circle(5.0);
		
		System.out.println("Count of Circles : "+Circle.numOfCircles);
		System.out.println("Count of Circles : "+yourCircle.numCircles);
		System.out.println("Count of Circles : "+myCircle.numCircles);
		System.out.println(myCircle.numOfCircles);
		System.out.println(yourCircle.numOfCircles);
	}
	
	void print() {
		System.out.println("Instance Method !");
	}
}
