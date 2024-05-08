package ch07.sec03.last;

public class LoginServlet extends HttpServlet {
	public LoginServlet() {
		super();
	}
	
	@Override
	public void service() {
		System.out.println("Login");
	}
}
