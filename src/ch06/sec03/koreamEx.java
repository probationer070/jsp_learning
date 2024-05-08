package ch06.sec03;

public class koreamEx {
	public static void main(String[] args) {
		Koream kor = new Koream("Rula", "011225-1234567");
		System.out.println(kor.name);
		System.out.println(kor.nation);
		System.out.println(kor.ssn);
		
		Koream kor2 = new Koream("MariaDv", "315901-0987654");
		System.out.println(kor2.name);
		System.out.println(kor2.nation);
		System.out.println(kor2.ssn);
	}
}
