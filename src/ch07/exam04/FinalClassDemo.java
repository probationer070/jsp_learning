package ch07.sec01.exam04;

class Good {
	
}

class Better extends Good {
	
}

final class Best extends Better {
	
}

//class NumberOne extends Best {} // final 클래스는 상속 불가

public class FinalClassDemo {

	public static void main(String[] args) {
//		new NumberOne();
		new Best();
	}

}
