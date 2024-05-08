package ch05.sec02;

public class ArrayCreatedByValueListExample2 {
	public static void main(String[] args) {
		int scores[];
		scores = new int[] {83, 90, 87};
		int sum1 = 0;
		for (int i=0; i<3; i++) {
			sum1 += scores[i];
		}
		System.out.println("total : "+sum1);
		
		
		int sum2 = add( new int[] {83, 90, 87});
		System.out.println("total : "+sum2);
		System.out.println("\n");
	}
		
	public static int add(int[] number) {
		int sum = 0;
		for (int i=0; i<number.length; i++) {
			sum += number[i];
		}
		return sum;

	}
}
