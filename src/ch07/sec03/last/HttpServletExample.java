package ch07.sec03.last;

public class HttpServletExample {
	public static void main(String[] args) {
		method(new LoginServlet());		// Login
		method(new FileDownloadServlet());		// file downloading 
	}
	
	public static void method(HttpServlet servlet) {
		servlet.service();
	}
}


