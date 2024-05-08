package ch05.sec02;

public class finalfieldex {

	public static void main(String[] args) {
		
		singelt_test singt1 = singelt_test.getInstance();
		singelt_test singt2 = singelt_test.getInstance();
		
		System.out.println(singt2 == singt1);
		
	}

}
