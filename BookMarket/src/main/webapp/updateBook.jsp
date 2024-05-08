<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="dto.Book"%>
<%@ page errorPage = "exceptionNoBookId.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
 <link href = "./resources/css/bootstrap.min.css" rel="stylesheet">
 <script type="text/javascript" src="./resources/validation.js"></script>
<title>도서 수정</title>
</head>
<body>
<fmt:setLocale value='<%= request.getParameter("language") %>'/>
<fmt:bundle basename="bundle.message" >
<div class="container py-4">
   <%@ include file="menu.jsp"%>	

   <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">도서정보</h1>
        <p class="col-md-8 fs-4">Book updating</p>      
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
	    	book.setAuthor(rs.getString("b_author"));
	    }
	   
	%>
	 <div class="row align-items-md-stretch">	 	
	 		<div class="col-md-5">
				<img src="./resources/images/<%=book.getFilename()%>" style="width: 70%">
			</div>
			<div class="col-md-7">
			
			<form name="newBook" id="newBook" action="./processUpdateBook.jsp" method="post" enctype ="multipart/form-data">		
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="bookId" /></label>
				<div class="col-sm-3">
					<input type="text" name="bookId" id="bookId" class="form-control" 
					     value="<%=book.getBookId()%>" readonly="readonly">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="name" /></label>
				<div class="col-sm-3">
					<input type="text" name="name" id="name" class="form-control"
					   value="<%=book.getName()%>" >
				</div>
			</div>
				<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="unitPrice" /></label>
				<div class="col-sm-3">
					<input type="text" name="unitPrice" id="unitPrice" 
					   class="form-control" value="<%=book.getUnitPrice() %>" >
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="author" /></label>
				<div class="col-sm-3">
					<input type="text" name="author" id="author" 
					class="form-control"  value="<%=book.getAuthor() %>">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="publisher" /></label>
				<div class="col-sm-3">
					<input type="text" name="publisher" id="publisher" 
					  class="form-control"  value="<%=book.getPublisher()%>">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="releaseDate" /></label>
				<div class="col-sm-3">
					<input type="text" name="releaseDate" id="releaseDate"
					 class="form-control"  value="<%=book.getReleaseDate()%>">
				</div>
			</div>
	
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="description" /></label>
				<div class="col-sm-5">
					<textarea name="description" id="description" cols="50" rows="2" 
						class="form-control" 
						placeholder="100자 이상 적어주세요"><%=book.getDescription()%></textarea>
				</div>
			</div>			
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="category" /></label>
				<div class="col-sm-3">
					<input type="text" name="category" id="category" 
					  class="form-control" value="<%=book.getCategory()%>">
				</div>
			</div>
				<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="unitsInStock" /></label>
				<div class="col-sm-3">
					<input type="text" name="unitsInStock"  id = "unitsInStock" 
					  class="form-control"  value="<%=book.getUnitsInStock()%>">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="condition" /></label>
				<div class="col-sm-5">
					<input type="radio" name="condition" value="New "><fmt:message key="condition_New" />
					<input type="radio" name="condition" value="Old" > <fmt:message key="condition_Old" /> 
					<input type="radio" name="condition" value="EBook" ><fmt:message key="condition_Ebook" />
				</div>				
			</div>		
			
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="bookImage" /></label>
				<div class="col-sm-5">
					<input type="file" name="bookImage" class="form-control">
				</div>
			</div>
			
			<div class="mb-3 row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<input type="button" class="btn btn-primary" value="<fmt:message key="button" />" onclick="checkAdd()">
				</div>
			</div>
		</form>
			</div>
		</div>
	<jsp:include page="footer.jsp" />
</div>
</fmt:bundle>
</body>
</html>
