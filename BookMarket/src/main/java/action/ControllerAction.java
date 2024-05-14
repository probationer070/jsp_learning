package action;

import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ControllerAction {
	public Map<String, Object> requestPro(HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
}
