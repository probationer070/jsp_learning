package ch11.sec01.exam05;

public class ClassExample {
	public static void main(String[] args) throws Exception {
//		Class clazz = Car.class;
		
//		Class clazz = Class.forName("ch11.sec01.exam05.Car");
		
		Car car = new Car();
		Class clazz = car.getClass();
		
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getPackage().getName());
	}
}