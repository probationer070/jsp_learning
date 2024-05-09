<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="dbconn.jsp"%>
<%
	String bookId = request.getParameter("id");

	PreparedStatement pstmt = null;	
	int r = 0;
	if (bookId == null) out.print("<script>alert('도서번호 오류')</script>");
	else {
		String sql = "delete from book where b_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bookId);
		r=pstmt.executeUpdate();
	}
	
	if(r==0) {
		 out.println("일치하는 도서가 없습니다.");
	}
	
	if (pstmt != null)
		pstmt.close();
	if (conn != null)
		conn.close();

	
	response.sendRedirect("editBook.jsp?edit=delete");
%>
