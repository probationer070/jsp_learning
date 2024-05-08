package ch05.sec02;

public class ArraylengthEX {
	public static void main(String[] args) {
		
		int arr1[] = {80, 90, 100};
		int sum = 0;
		
		for(int i=0; i<arr1.length; i++) {
			sum += arr1[i];
		}
		
		System.out.println(sum);
		
		double avg = 0;
		avg = sum / arr1.length;
		System.out.println(avg);
	}
}
