package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BoardDAO;
import model.BoardDTO;

public class UpdateProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDTO article = new BoardDTO();
		BoardDAO dao = BoardDAO.getDAO();
		
		int pageNum;
		if (request.getParameter("pageNum") != null && 
				request.getParameter("pageNum").length() > 0) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} else {
			pageNum = 1;
		}

		if (request.getParameter("bno") != null) 
			article.setBno(Integer.parseInt(request.getParameter("bno")));
			article.setWriter(request.getParameter("writer"));
			article.setSubject(request.getParameter("subject"));
			article.setContent(request.getParameter("content"));
			article.setPasswd(request.getParameter("passwd"));
			article.setIp(request.getRemoteAddr());
		
		int r = 0;
		r = dao.updateArticle(article);
		
		String msg;
		if (r > 0) msg = "수정 성공";
		else msg = "수정 실패";
		
		String newView = "list.do?pageNum="+pageNum;
		request.setAttribute("msg", msg);
		request.setAttribute("newView", newView);
		
		return "view/MsgPage.jsp";
	}

}
