package test_Ex01;

public class Method2Demo {
	public static void main(String[] args) {
		
		System.out.println(sum(1,10));
		System.out.println(sum(10,100));
		System.out.println(sum(100,1000));
	}
	
	public static int sum(int a, int b) {
		int sums = 0;
		for (int i = a; i <= b; i++) {
			sums += i;
		}
		return sums;
	}
}
