package action;

import java.util.Map;

import dao.BoardDAO;
import dto.BoardBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class BoardWriteProAction implements ControllerAction {

	@Override
	public Map<String, Object> requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		// BoardBean 을 생성하고
		BoardBean dto = new BoardBean();
		// request 로 들어온 모든 데이터를 받고
		// bean 에 저장하고
		dto.setId((String) session.getAttribute("sessionId"));
		dto.setName(request.getParameter("name"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setIp(request.getRemoteAddr());
		
		// 데이터 처리(저장) 호출(bean) 넣고 호출
		// dao를 가져와서 호출
		BoardDAO dao = BoardDAO.getDao();
		dao.insertArticle(dto);
		
		return null;
	}

}
