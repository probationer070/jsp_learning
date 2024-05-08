package ch10.sec02.exam01;

public class TryCatchfinallyEx {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("java.lang.String2");
		} catch(ClassNotFoundException e) {
			System.err.println("클래스가 존재하지 않습니다."+e.getMessage());
			// e.printStackTrace();
		}
	}
}
