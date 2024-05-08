package ch05.sec03;

public class TextBlockDemo {
	public static void main(String[] args) {
		// 텍스트 블록
		String html1 = """
				<html>
					<p>Hi, world!</p>
				</html>
				""";
		System.out.println(html1);
		
		// jdk 15 이전
		String htmls = "<html> \n" 
				+ "		<p>Hi, world!</p> \n"
				+ "</html> ";
		System.out.println(htmls);
		
		// 텍스트 블록 jdk 15이후 버전
		// """ 다음은 반드시 줄바꿈 필요
		String html2 = """
				<html>
					<p>Hi, world!</p>
				</html>
			""";
			System.out.println(html2);
			
		String escape = """
				\\""";
		System.out.println(escape);
		
		String quote = """
				안녕, "수정아!"
				""";
		System.out.println(quote);
		
		String op = """
				가나라""".replace("라", "다");
		System.out.println(op);
		
	}
}
