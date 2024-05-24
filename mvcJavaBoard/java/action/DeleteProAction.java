package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BoardDAO;

public class DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int pageNum;
		if (request.getParameter("pageNum") != null && 
				request.getParameter("pageNum").length() > 0) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} else {
			pageNum = 1;
		}
		
		int bno;
		if (request.getParameter("bno") != null && request.getParameter("bno").length() > 0) 
			bno = Integer.parseInt(request.getParameter("bno"));
		else
			bno = 0;
		
		BoardDAO dao = BoardDAO.getDAO();
		
		int r = 0;
		r = dao.deleteArticle(bno);

		// 페이지 번호 받고 저장
		// bno 번호 받고 게시글 삭제
		
		String msg;
		
		if (r > 0) msg = "삭제 실패";
		else msg = "삭제 성공";
		
		String newView = "list.do?PageNum="+pageNum;
		request.setAttribute("msg", msg);
		request.setAttribute("newView", newView);
		
		return "view/MsgPage.jsp";
	}

}
