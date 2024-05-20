package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BoardDAO;
import model.BoardDTO;

public class WriteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String view = "view/WriteForm.jsp";
		BoardDTO dto = new BoardDTO();
		if (request.getParameter("bno") != null && 
				request.getParameter("bno").length() > 0) {
			dto.setBno(Integer.parseInt(request.getParameter("bno")));
			dto.setBref(Integer.parseInt(request.getParameter("bref")));
			dto.setBlevel(Integer.parseInt(request.getParameter("blevel")));
			dto.setBstep(Integer.parseInt(request.getParameter("bstep")));
		} 
		int pageNum;
		if (request.getParameter("pageNum") != null && 
				request.getParameter("pageNum").length() > 0) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} else {
			pageNum = 1;
		}
		
		request.setAttribute("article", dto);
		request.setAttribute("pageNum", pageNum);
		
		return view;
	}
}
