package control;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import action.CommandAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, CommandAction> cMap = new HashMap<String, CommandAction>();
	
	public void init(ServletConfig config) throws ServletException {
		// properties 를 읽고 키 (list.do) 와 value(action.ListAction 객체)로 만들어서 저장
		// 파일의 정보를 받기 위해 키 읽어오기
		String props = config.getInitParameter("propertyConfig");
		// property 를 읽기 위한 객체 생성
		Properties pr = new Properties();
		// 파일 내용 읽기 위해 BufferedInputStream 사용
		BufferedInputStream bf = null;	// 파일 읽기용인데 buffer 를 씌워서 꾸미기 Decoration
		try {
			bf = new BufferedInputStream(new FileInputStream(props));
			pr.load(bf);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bf!=null) try { bf.close(); } catch (IOException e) {}
		}
		// properties 로 읽어온 내용을 하나씩 읽어서 좌우 각각 키, 클래스이름은 해당경로로 가서 생성 후 value
		Iterator<Object> keyset = pr.keySet().iterator();
		
		while (keyset.hasNext()) {
			String command = (String) keyset.next();
			String className = pr.getProperty(command);
			
			// 해당 클래스를 클래스로 읽어서 생성				
			try {
				Class<?> commandClass = Class.forName(className);
				CommandAction commInstance = (CommandAction) commandClass.getDeclaredConstructor().newInstance();
				cMap.put(command ,commInstance);
			} catch ( ClassNotFoundException 
					| InstantiationException 
					| IllegalAccessException 
					| IllegalArgumentException 
					| InvocationTargetException 
					| NoSuchMethodException 
					| SecurityException e) {
				e.printStackTrace();
			}
		}	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommandAction action = null;
		String view = null;
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		
		action = cMap.get(command);
		try {
			view = action.requestPro(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
}
