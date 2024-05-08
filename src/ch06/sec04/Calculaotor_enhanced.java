package ch06.sec04;

public class Calculaotor_enhanced {
	
	int plus(int ... value) {
		int result = 0;
		for (int i=0; i<value.length; i++) {
			result += value[i];
		}
		return result;
	}
	
	double average(int ... value) {
		double sum = plus(value);
		double result = sum / value.length;
		return result;
	}
	
	void excute(int ...value) {
		double result = average(value);
		println("Result : "+result);
	}
	
	
	void println(String Message) {
		System.out.println(Message);
	}
}