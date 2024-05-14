package action;

import java.util.HashMap;
import java.util.Map;

import dao.BoardDAO;
import dto.BoardBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class BoardUpdateProAction implements ControllerAction {

	@Override
	public Map<String, Object> requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// BoardBean 을 생성하고
		Map<String, Object> reMap = new HashMap<String, Object>();
		int pageNum;
		if (request.getParameter("pageNum") == null) pageNum=1;
		else {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		BoardBean article = new BoardBean();
		if (request.getParameter("num") != null) 
			article.setNum(Integer.parseInt(request.getParameter("num")));
		if (request.getParameter("name") != null) 
			article.setName(request.getParameter("name"));
		if (request.getParameter("subject") != null) 
			article.setSubject(request.getParameter("subject"));
		if (request.getParameter("content") != null) 
			article.setContent(request.getParameter("content"));
		article.setIp(request.getRemoteAddr());
		reMap.put("pageNum", pageNum);
		
		BoardDAO dao = BoardDAO.getDao();
		dao.updateArticle(article);
		
		return reMap;
	}

}
