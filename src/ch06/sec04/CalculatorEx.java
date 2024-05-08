package ch06.sec04;

public class CalculatorEx {
	public static void main(String[] args) {
		Computer myCom = new Computer();	
		
		int values[] = {1, 2, 3};
		int res = myCom.sum1(values);
		System.out.println(res);
		
		int res2 = myCom.sum1(new int[] {1, 2 ,3 ,5, 7});
		System.out.println(res2);

		int res3 = myCom.sum2(values);
		System.out.println(res3);
		
		int res4 = myCom.sum2(1, 2 ,3 ,5, 7);
		System.out.println(res4);
	}
}
