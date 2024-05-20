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
		
		String view = "view/BoardContent.jsp";
		int bno;
		if (request.getParameter("bno") != null && 
				request.getParameter("bno").length() > 0) {
			bno = Integer.parseInt(request.getParameter("bno"));
		} else {
			bno = 0;
			request.setAttribute("msg", "등록된 게시글이 없습니다.");
			view = "view/MsgPage.jsp";
		}
		
		if (request.getParameter("bno") != null) 
			article.setBno(Integer.parseInt(request.getParameter("bno")));
		if (request.getParameter("writer") != null) 
			article.setWriter(request.getParameter("writer"));
		if (request.getParameter("subject") != null) 
			article.setSubject(request.getParameter("subject"));
		if (request.getParameter("content") != null) 
			article.setContent(request.getParameter("content"));
		article.setPasswd(request.getParameter("passwd"));
		
		dao.updateArticle(article);
		
		request.setAttribute("bno", bno);
		request.setAttribute("newView", "list.do");
		
		return "index.jsp";
	}

}
