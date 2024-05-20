package action;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BoardDAO;
import model.BoardDTO;
import model.Pageinfo;

public class BoardListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDAO dao = BoardDAO.getDAO();
		// 전체 레코드 수
		int total = dao.getTotal();
		System.out.println("전체 게시글 수 : "+total);
		
		int pageNum;
		if (request.getParameter("pageNum") != null && 
				request.getParameter("pageNum").length() > 0 ) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} else {
			pageNum = 1;
		}
		
		// total page 수
		int totalPageCnt 
		= (total % Pageinfo.LINE_OF_PAGE == 0) ? total / Pageinfo.LINE_OF_PAGE : total/Pageinfo.LINE_OF_PAGE+1;
		int start, end;		
		start = (pageNum - 1) * Pageinfo.LINE_OF_PAGE + 1;
		end = (pageNum * Pageinfo.LINE_OF_PAGE > total) ? total: pageNum * Pageinfo.LINE_OF_PAGE;
		List<BoardDTO> articles = dao.getArticles(start, end);	
		
		request.setAttribute("total", total);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPageCnt", totalPageCnt);
		request.setAttribute("articles", articles);
		
		return "view/BoardList.jsp?pageNum="+pageNum;
	}

}
