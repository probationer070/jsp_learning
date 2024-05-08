package test_Ex01;

public class switch3Demo {
	public static void main(String[] args) {
		whoisIt("호랑이");
		whoisIt("비둘기");
		whoisIt("고래");
		whoisIt("개");
	}
	
	static void whoisIt(String bio) {
		String kind = "...";
		switch(bio) {
			case "호랑이", "사자" -> kind = "포유류";
			case "비둘기", "백조" -> kind = "조류";
			case "상어", "고래" -> kind = "어류";
			default -> System.out.println("?");
		}
		System.out.println(kind);
	}
}
