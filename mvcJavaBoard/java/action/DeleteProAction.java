package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BoardDAO;
import model.BoardDTO;

public class DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDTO article = new BoardDTO();
		BoardDAO dao = BoardDAO.getDAO();
		
		if (request.getParameter("bno") != null) 
			article.setBno(Integer.parseInt(request.getParameter("bno")));
		dao.deleteArticle(article);
		
		return "index.jsp";
	}

}
