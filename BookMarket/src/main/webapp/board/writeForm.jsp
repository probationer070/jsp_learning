<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String name = (String) request.getAttribute("name");
	
%>
<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<link href = "./resources/css/border.css" rel="stylesheet">
<script type="text/javascript" src="./resources/js/validation.js"></script>
<script type="text/javascript">
	function checkSession() {
		if(${sessionId == null}) {
			alert("로그인이 필요합니다.");
			location.href ="./member/loginMember.jsp";
		} else {
			location.href = "./boardWrite.do?pageNum=${pageNum}";
		}
	}
</script>
<title>Board</title>
</head>

<body>
<div class="container py-4">
	<jsp:include page="../menu.jsp" />
	
	 <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">게시판</h1>
        <p class="col-md-8 fs-4">Board</p>      
      </div>
    </div>

	<div class="row align-items-md-stretch   text-center">	 	
		<form action="./boardWritePro.do" name="newWrite" method="post">
			<input type="hidden" name="pageNum" value="${pageNum}">
			<input type="hidden" name="id" value="${sessionId}">
			<div class="mb-3 row">
				<label class="col-sm-2 control-label" >작성자</label>
				<div class="col-sm-3">
					<input name="name" type="text" class="form-control" placeholder="name">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 control-label" >제목</label>
				<div class="col-sm-5">
					<input name="subject" type="text" class="form-control"	placeholder="subject">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 control-label" >내용</label>
				<div class="col-sm-8">
					<textarea name="content" cols="50" rows="5" class="form-control" placeholder="content" style="resize: none;"></textarea>
				</div>
			</div>
			
		</form>
			<div class="py-2" align="center">
				<a href="./boardList.do?pageNum=${pageNum}" class="btn btn-secondary"> 글목록</a>
				<a href="#" onclick="checkData()" class="btn btn-primary"> 저장</a>
			</div>
	</div>
	<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>



