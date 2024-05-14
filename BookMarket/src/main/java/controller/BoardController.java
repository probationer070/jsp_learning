package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

import action.ControllerAction;
import action.BoardContentView;
import action.BoardDeleteProAction;
import action.BoardListAction;
import action.BoardUpdateAction;
import action.BoardUpdateProAction;
import action.BoardWriteProAction;

/**
 * Servlet implementation class BoardController
 */
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		HttpSession session = request.getSession();
		session.setAttribute("sessionId", session.getAttribute("sessionId"));
		ControllerAction action = null;
		String view = "./board/list.jsp";
		
		if(command.equals("/boardList.do")) {
			action = new BoardListAction();		// 비즈니스 로직
			Map<String, Object> resMap = null;
			try {
				resMap = action.requestPro(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 받은 결과중에서 페이지와, 전체 페이지 수, 전체 레코드 수, 가져온 게시글 리스트를 저장해 view로 전달
			// 결과 저장
			
			request.setAttribute("pageNum", resMap.get("pageNum"));
			request.setAttribute("articles", resMap.get("articles"));
			request.setAttribute("totalPage", resMap.get("totalPage"));
			request.setAttribute("totArticles", resMap.get("totArticles"));
			view = "./board/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view); 
			rd.forward(request, response);
			
		} else if (command.equals("/boardWrite.do")) {
			// 해당 action 으로 전송하고 데이터 받기
			request.setAttribute("pageNum", request.getParameter("pageNum"));
			view = "./board/writeForm.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view); 
			rd.forward(request, response);
			
		} else if (command.equals("/boardWritePro.do")) {
			action = new BoardWriteProAction();
			try {
				action.requestPro(request, response);
			} catch (Exception e) { e.printStackTrace(); }
			int pageNum = 1;
			if(request.getParameter("pageNum") == null) pageNum = 1;
			else if (request.getParameter("pageNum") != null) {
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			}
			request.setAttribute("pageNum", pageNum);
			view = "./boardList.do?pageNum="+pageNum;
			response.sendRedirect(view);
			
		} else if (command.equals("/boardView.do")) {
			action = new BoardContentView();
			
			Map<String, Object> reMap = null;
			try {
				reMap = action.requestPro(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (request.getParameter("num") == null) {
				view = "./boardList.do?pageNum="+reMap.get("pageNum");
				response.sendRedirect(view);
			}	
			
			request.setAttribute("pageNum", reMap.get("pageNum"));
			view = "./board/contentView.jsp";
			request.setAttribute("article", reMap.get("article"));
			RequestDispatcher rd = request.getRequestDispatcher(view); 
			rd.forward(request, response);
		
		} else if (command.equals("/boardUpdate.do")) {	// 데이터베이스에 해당 데이터 갖고와서 뿌려주기
			action = new BoardUpdateAction();
			
			Map<String, Object> reMap = null;
			try {
				reMap = action.requestPro(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (request.getParameter("num") == null) {
				view = "./boardList.do?pageNum="+reMap.get("pageNum");
				response.sendRedirect(view);
			}	
			
			request.setAttribute("pageNum", reMap.get("pageNum"));
			view = "./board/updateView.jsp";
			request.setAttribute("article", reMap.get("article"));
			RequestDispatcher rd = request.getRequestDispatcher(view); 
			rd.forward(request, response);
			
		} else if (command.equals("/boardUpdatePro.do")) {
			action = new BoardUpdateProAction();
			Map<String, Object> reMap = null;
			try {
				reMap = action.requestPro(request, response);
			} catch (Exception e) { e.printStackTrace(); }
			
			request.setAttribute("pageNum", reMap.get("pageNum"));
			view = "./boardList.do?pageNum="+reMap.get("pageNum");
			response.sendRedirect(view);
		
		} else if (command.equals("/boardDelete.do")) {
			action = new BoardDeleteProAction();
			Map<String, Object> reMap = null;
			try {
				reMap = action.requestPro(request, response);
			} catch (Exception e) { e.printStackTrace(); }
			
			request.setAttribute("pageNum", reMap.get("pageNum"));
			view = "./boardList.do?pageNum="+reMap.get("pageNum");
			response.sendRedirect(view);
		}
		// view 페이지 호출
		
	}

}
