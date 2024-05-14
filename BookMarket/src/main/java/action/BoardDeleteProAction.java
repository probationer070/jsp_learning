package action;

import java.util.HashMap;
import java.util.Map;

import dao.BoardDAO;
import dto.BoardBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardDeleteProAction implements ControllerAction {

	@Override
	public Map<String, Object> requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, Object> reMap = new HashMap<String, Object>();
		int pageNum;
		if (request.getParameter("pageNum") == null) pageNum=1;
		else {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		reMap.put("pageNum", pageNum);
		
		
		BoardBean article = new BoardBean();
		BoardDAO dao = BoardDAO.getDao();
		if (request.getParameter("num") != null) 
			article.setNum(Integer.parseInt(request.getParameter("num")));
		dao.deleteArticle(article);
		
		return reMap;
	}

}
