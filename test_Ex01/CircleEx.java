package test_Ex01;

public class CircleEx {
	public static void main(String[] args) {
		Circle c1 = new Circle(5.0);
		Circle c2 = new Circle(7.0);
		
//		c1.rad = 5.0;
//		c2.rad = 7.0;
		
		System.out.println(c1.area());
		System.out.println(c2.area());
		
		System.out.println("-------------");
		
		Sphere c3 = new Sphere(5.0);
		
		System.out.println("구의 겉넓이 : "+c3.area());

		Cylinder c4 = new Cylinder(10.0, 5.0);
		
		System.out.println("원통의 겉넓이 : "+c4.area());
		
		System.out.println("-------------");
		
		Circle arr[] = {new Sphere(5.0), 
						new Sphere(7.0), 
						new Cylinder(5.0, 5.0),
						new Cylinder(6.0, 10.0)};
		
		for (int i=0; i<arr.length; i++) {
			if (arr[i] instanceof Sphere) {
				Sphere sphere = (Sphere) arr[i];
				System.out.println((i+1)+" 구의 겉넓이 : "+sphere.area());
			} else if (arr[i] instanceof Cylinder) {
				Cylinder cylin = (Cylinder) arr[i];
				System.out.println((i+1)+" 원통의 겉넓이 : "+cylin.area());
			}
		}
	}
}
