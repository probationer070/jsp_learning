<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="dto.Book"%>
<%@ page errorPage = "exceptionNoBookId.jsp"%>

<html>
<head>
 <link href = "./resources/css/bootstrap.min.css" rel="stylesheet">
<title>도서 정보</title>
<script type="text/javascript">
	function addToCart() {
		if (confirm("상품을 장바구니에 추가하시겠습니까?")) {
			document.addForm.submit();
		} else {		
			document.addForm.reset();
		}
	}
</script>

</head>
<body>
<div class="container py-4">
   <%@ include file="menu.jsp"%>	

   <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">도서정보</h1>
        <p class="col-md-8 fs-4">BookInfo</p>      
      </div>
    </div>
	<%@ include file="dbconn.jsp" %>
	<%
		String id = request.getParameter("id");
	    String sql ="SELECT * FROM BOOK WHERE B_ID=?"; 
	    PreparedStatement pstmt=null;
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, id);
	    ResultSet rs = pstmt.executeQuery();
	    Book book= new Book();
	    if(rs.next()){
	    	book.setBookId(rs.getString("b_id"));
	    	book.setName(rs.getString("b_name"));
	    	book.setUnitPrice(rs.getInt("b_unitprice"));
	    	book.setDescription(rs.getString("b_description"));
	    	book.setPublisher(rs.getString("b_publisher"));
	    	book.setCategory(rs.getString("b_category"));
	    	book.setUnitsInStock(rs.getLong("b_unitsinstock"));
	    	book.setReleaseDate(rs.getString("b_releasedate"));
	    	book.setCondition(rs.getString("b_condition"));
	    	book.setFilename(rs.getString("b_filename"));
	    }
	   
	%>
	 <div class="row align-items-md-stretch">	 	
	 		<div class="col-md-5">
				<img src="./resources/images/<%=book.getFilename()%>" style="width: 70%">
			</div>
			<div class="col-md-6">
				<h3><b><%=book.getName()%></b></h3>
				<p><%=book.getDescription()%>
				<p><b>도서코드 : </b><span class="badge text-bg-danger"> <%=book.getBookId()%></span>							
				<p><b>저자</b> : <%=book.getAuthor()%>	
				<p><b>출판사</b> : <%=book.getPublisher()%>	
				<p><b>출판일</b> : <%=book.getReleaseDate()%>					
				<p><b>분류</b> : <%=book.getCategory()%>
				<p><b>재고수</b> : <%=book.getUnitsInStock()%>
				<h4><%=book.getUnitPrice()%>원</h4>
				<p>
				    <form name="addForm" action="./addCart.jsp?id=<%=book.getBookId()%>" 
				      method="post"><a href="#" class="btn btn-info" 
				                       onclick="addToCart()"> 도서주문 &raquo;</a> 
				      <a href="./cart.jsp" class="btn btn-warning"> 장바구니 &raquo;</a>				
					  <a href="./books.jsp" class="btn btn-secondary"> 도서목록 &raquo;</a>
					</form>
			</div>
		</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
