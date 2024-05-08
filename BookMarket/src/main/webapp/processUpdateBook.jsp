<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="com.oreilly.servlet.*"%>
<%@ page import="com.oreilly.servlet.multipart.*"%>
<%@ page import="java.util.*"%>
<%@ include file="dbconn.jsp" %>
<%
	String filename = "";

	String realFolder = "E:/EcomWork/WorkSpace6/BookMarket/src/main/webapp/resources/images";
	int maxSize = 5 * 1024 * 1024; //최대 업로드될 파일의 크기5Mb
	String encType = "utf-8"; //인코딩 타입
	

	MultipartRequest multi = 
	   new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());


	String bookId = multi.getParameter("bookId");
	String name = multi.getParameter("name");
	String unitPrice = multi.getParameter("unitPrice");
	String author = multi.getParameter("author");
	String publisher = multi.getParameter("publisher");
	String releaseDate = multi.getParameter("releaseDate");	
	String description = multi.getParameter("description");	
	String category = multi.getParameter("category");
	String unitsInStock = multi.getParameter("unitsInStock");
	String condition = multi.getParameter("condition");

	Enumeration<Object> files = multi.getFileNames();
	String fname = (String) files.nextElement();
	String fileName = multi.getFilesystemName(fname);
	
	
	int price;

	if (unitPrice.isEmpty())
		price = 0;
	else
		price = Integer.valueOf(unitPrice);

	long stock;

	if (unitsInStock.isEmpty())
		stock = 0;
	else
		stock = Long.valueOf(unitsInStock);	
	
	
    PreparedStatement pstmt = null;	
	
	String sql = "UPDATE BOOK SET B_NAME=?, B_UNITPRICE=? ,B_AUTHOR=?, "; 
	       sql+="B_DESCRIPTION =? , B_PUBLISHER=? , B_CATEGORY=?, ";
	       sql+="B_UNITSINSTOCK=?, B_RELEASEDATE=?, ";
	       sql+="B_CONDITION=? ";
	       if(fileName!=null){
	    	sql+=" , B_FILENAME=? ";
	       }
	       sql+="WHERE B_ID = ?";
	pstmt = conn.prepareStatement(sql);//쿼리 실행하기 위해 쿼리로 생성
	pstmt.setString(1, name);
	pstmt.setInt(2, price);
	pstmt.setString(3, author);
	pstmt.setString(4, description);
	pstmt.setString(5, publisher);
	pstmt.setString(6, category);
	pstmt.setLong(7, stock);
	pstmt.setString(8, releaseDate);	
	pstmt.setString(9, condition);
	if(fileName!=null){
		pstmt.setString(10, fileName);
		pstmt.setString(11, bookId);
	}else{
		pstmt.setString(10, bookId);
	}
	pstmt.executeUpdate();//쿼리 실행
	
	if (pstmt != null)
		pstmt.close();
	if (conn != null)
		conn.close();

	response.sendRedirect("editBook.jsp?edit=update");
%>
