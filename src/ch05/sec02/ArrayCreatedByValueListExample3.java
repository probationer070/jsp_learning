package ch05.sec02;

public class ArrayCreatedByValueListExample3 {
	public static void main(String[] args) {
		int su[] = {10, 20, 30};
		int a=10, b=20, c=30;
		
		System.out.println(a+", "+b+", "+c);
		System.out.println(su[0]+", "+su[1]+", "+su[2]);
		callByValueMethod(a, b, c);
		callByReferenceMethod(su); // 참조값 보냄
		
		System.out.println(a+", "+b+", "+c); // 값 변화 없음
		System.out.println(su[0]+", "+su[1]+", "+su[2]);	// 값이 바뀌어서 출력
		
		callNoneMethod(su[0], su[1], su[2]);	// 값을 하나씩 꺼내서 복사 참조값 없음 
		
		System.out.println(a+", "+b+", "+c);
		System.out.println(su[0]+", "+su[1]+", "+su[2]);
	}
		
	private static void callNoneMethod(int i, int j, int k) {
		i=20;
		j=30;
		k=40;
	}
	
	public static void callByValueMethod(int a, int b, int c) {
		a=20;
		b=30;
		c=40;
	}
	
	public static void callByReferenceMethod(int[] su2) {
		su2[0]=20;
		su2[1]=30;
		su2[2]=40;
	}
	
}
