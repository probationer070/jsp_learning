package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BoardDAO;
import model.BoardDTO;

public class WriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDTO article = new BoardDTO();
		// 답글인가?
		if(request.getParameter("bno") != null && request.getParameter("bno").length() != 0) {
			
		} else {
			article.setSubject(request.getParameter("subject"));
			article.setWriter(request.getParameter("writer"));
			article.setContent(request.getParameter("content"));
			article.setPasswd(request.getParameter("passwd"));
			article.setIp(request.getRemoteAddr());
		}
		
		BoardDAO dao = BoardDAO.getDAO();
		
		String msg;
		
		int r = dao.writeArticle(article);
		if (r>0) msg = "게시글 등록 성공";
		else msg = "게시글 등록 실패";
		
	
		request.setAttribute("msg", msg);
		request.setAttribute("newView", "list.do");
		
		return "view/MsgPage.jsp";
	}

}
