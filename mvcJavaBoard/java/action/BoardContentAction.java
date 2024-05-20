package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BoardDAO;
import model.BoardDTO;

public class BoardContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 페이지 번호 받아서 저장
		int pageNum;
		if (request.getParameter("pageNum") != null && 
				request.getParameter("pageNum").length() > 0) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} else {
			pageNum = 1;
		}
		String view = "view/BoardContent.jsp";
		// bno 받아서 
		int bno;
		if (request.getParameter("bno") != null && 
				request.getParameter("bno").length() > 0) {
			bno = Integer.parseInt(request.getParameter("bno"));
		} else {
			bno = 0;
			request.setAttribute("msg", "등록된 게시글이 없습니다.");
			view = "view/MsgPage.jsp";
		}
		
		// BoardDAO에 bno 넣어주고 실행하게 내용 갖고오기 + 내용 저장
		BoardDAO dao = BoardDAO.getDAO();
		// 조회수 증가하고 가져오기 dao에서. autocommit 이 되어있음
		// 취소하고 에러가 없으면 commit
		BoardDTO article = dao.getArticle(bno);
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("article", article);
		return "view/BoardContent.jsp";
	}

}
