package ch05.sec02;

public class ArrayCreatedByValueListExample1 {
	public static void main(String[] args) {
		int scores[] = {86, 90, 87};
		
		System.out.println("scores[0] : "+ scores[0]);
		System.out.println("scores[1] : "+ scores[1]);
		System.out.println("scores[2] : "+ scores[2]);
		
		int sum = 0;
		for (int i=0; i<3; i++) {
			sum += scores[i];
		}
		System.out.println("total : "+sum);
		double avg = (double)sum / 3;
		System.out.println("average : "+avg);
		
		String str = "1234";
		System.out.println(1234+1234+str);
		// String 과 정수과 실수 연산이 만나면 그냥 모두 앞에서부터 문자열로 인식
		System.out.println(1234*1234+str);
	}
}
