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
		String items = request.getParameter("items");
		String text = request.getParameter("text");
		int total = dao.getTotal(items ,text);
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
		
		List<BoardDTO> articles = null;
		
		if(text != null && items != null) 
			// To do 검색 후  페이지 설정 확인 필요
			articles = dao.getArticles(start, end, items, text);	
		else
			articles = dao.getArticles(start, end);	
		
		request.setAttribute("total", total);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPageCnt", totalPageCnt);
		request.setAttribute("articles", articles);
		
		request.setAttribute("text", text);		//	현재 검색어에 대한 정보를 저장 !!!
		request.setAttribute("items", items);
		
		return "view/BoardList.jsp?pageNum="+pageNum;
	}

}
