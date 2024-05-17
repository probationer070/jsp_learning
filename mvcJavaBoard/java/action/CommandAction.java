package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CommandAction {
	
	String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
