package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BoardDTO;

public class UpdateContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDTO article = new BoardDTO();
		
		article.setBno(Integer.parseInt(request.getParameter("bno")));
		article.setSubject(request.getParameter("subject"));
		article.setWriter(request.getParameter("writer"));
		article.setContent(request.getParameter("content"));
		article.setRegdate(request.getParameter("regdate"));
		article.setPasswd(request.getParameter("passwd"));
		article.setIp(request.getRemoteAddr());
		
		int pageNum;
		if (request.getParameter("pageNum") != null && 
				request.getParameter("pageNum").length() > 0) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} else {
			pageNum = 1;
		}
		
		request.setAttribute("article", article);
		request.setAttribute("pageNum", pageNum);
		return "view/UpdateView.jsp";
	}
}
