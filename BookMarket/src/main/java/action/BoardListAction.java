package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.BoardDAO;
import dto.BoardBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardListAction implements ControllerAction {

	@Override
	public Map<String, Object> requestPro(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		
		int pageNum = 1;
		if(request.getParameter("pageNum") == null ) pageNum =1;
		else if (request.getParameter("pageNum") != null 
				|| request.getParameter("pageNum").length() > 0) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} 
		
		
		// 데이터베이스 일은 데이터 접근 객체를 가지고 할 것 DAO
		BoardDAO dao = BoardDAO.getDao();
		// 전체 레코드 수를 받아서 저장
		// dao 에 있는 레코드 수를 구하는 메소드 호출
		int totArticles = dao.getTotalArticles();
		// 결과받아서 저장
		resMap.put("totArticles", totArticles);
		
		// 데이터가 많아 1개씩 가져올 때 전달용 객체(DTO)를 이용해 가져올 것임
		
		// pageNum를 받아서 저장할 것
		
		// 전체 페이지 계산
		int totalPage = (totArticles % 5 == 0) ? (totArticles/5) : (totArticles/5+1);
		resMap.put("totalPage", totalPage);
		// 해당 페이지 계산
		
		// 해당 페이지의 있는 모든 게시글 가져와서 저장
		int start;		// 페이지의  시작 레코드
		int end;		// 페이지의  끝 레코드
		start = (pageNum - 1) * 5 + 1;
		end = (pageNum * 5 > totArticles) ? totArticles: pageNum * 5;
		ArrayList<BoardBean> articles = null;
		String items = request.getParameter("items");
		String text = request.getParameter("text");
		if(items == null || text == null) {
			articles = dao.getArticles(start, end);	
		} else {
			articles = dao.getArticles(start, end, items, text);			
		}
		
		resMap.put("articles", articles);
		resMap.put("pageNum", pageNum);
		return resMap;
	}

}
