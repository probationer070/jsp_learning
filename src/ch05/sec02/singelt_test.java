package ch05.sec02;

public class singelt_test {
	private static singelt_test singleton = new singelt_test();
	
	private singelt_test()  {
		
	}
	
	static singelt_test getInstance() {
		return singleton;
	}
}

