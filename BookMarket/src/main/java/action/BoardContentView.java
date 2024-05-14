package action;

import java.util.HashMap;
import java.util.Map;

import dao.BoardDAO;
import dto.BoardBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardContentView implements ControllerAction {

	@Override
	public Map<String, Object> requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, Object> reMap = new HashMap<String, Object>();
		
		int pageNum =1;
		if(request.getParameter("pageNum") == null) pageNum = 1;
		else if (request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		int num;
		if (request.getParameter("num") != null) 
			num = Integer.parseInt(request.getParameter("num"));
		else num = 0;
		reMap.put("pageNum", pageNum);
		BoardDAO dao = BoardDAO.getDao();
		BoardBean article =  dao.getArticle(num);
		reMap.put("article", article);
		return reMap;
	}
}
