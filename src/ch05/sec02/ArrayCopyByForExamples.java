package ch05.sec02;

public class ArrayCopyByForExamples {
	public static void main(String[] args) {
		int oldIntArr[] = {1,2,3};
		int newIntArr[] = new int[5];
		
		for (int i=0; i<oldIntArr.length; i++) {
			newIntArr[i] = oldIntArr[i];
		}
		
		for (int i=0; i<newIntArr.length; i++) {
			System.out.println(newIntArr[i]);
		}
		System.out.println("-------------------------");
		
		String oldStrArr[] = {"java", "Spring", "copy"};
		String newStrArr[] = new String[5];
		
		System.arraycopy(oldStrArr, 0, newStrArr, 0, oldStrArr.length);
		
		for (int i=0; i<newStrArr.length; i++) {
			System.out.println(newStrArr[i]);
		}
	}
}
