package ch05.sec02;

public class MainStringArrayArgument {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("value less");
			System.exit(0);
		}
		
		String strNum1 = args[0];
		String strNum2 = args[1];
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		int res = num1 + num2;
		System.out.println(res);
	}
}
