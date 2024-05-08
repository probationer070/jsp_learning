package ch07.sec03.last;

public class FileDownloadServlet extends HttpServlet{
	public FileDownloadServlet() {
		super();
	}
	
	@Override
	public void service() {
		System.out.println("File downloading");
	}
}
