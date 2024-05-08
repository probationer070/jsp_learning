package test_Ex01;

public class castDemo {
	public static void main(String[] args) {
		int i;
		double d;
		byte b;
		
		i = 7 / 4;
		System.out.println(i);

		d = 7 / 4;
		System.out.println(d);
		
		d = 7 / (double)4;
		System.out.println(d);
		
		// i = 7 / (double) 4 ;
		
		i = 300;
		
		if (Byte.MIN_VALUE > Byte.MAX_VALUE) {
			System.out.println("byte타입으로 변경 가능");
		} else {
			b = (byte) i;
		}
	}
}
