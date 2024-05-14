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
	function checkSession(url) {
		var s = '${sessionId}';
		if(s.length == 0) {
			alert("로그인이 필요합니다.");
			location.href ="./member/loginMember.jsp";
		} else {
			location.href = url;
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
		<form action="boardUpdatePro.do" name="newWrite" method="post">
			<input type="hidden" name="pageNum" value="${pageNum}">
			<input type="hidden" name="sessionId" value="${sessionId}">
			<div class="mb-3 row">
				<label class="col-sm-2 control-label" >작성자</label>
				<div class="col-sm-3">
					<input name="num" value="${article.num}" type="hidden">
					<input name="name" type="text" class="form-control" value="${article.name}" >
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 control-label" >제목</label>
				<div class="col-sm-5">
					<input name="subject" type="text" class="form-control" value="${article.subject}" >
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 control-label" >작성일자</label>
				<div class="col-sm-5">
					<input name="regist_day" type="text" class="form-control" value="${article.regist_day}" readonly="readonly">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 control-label" >접근IP</label>
				<div class="col-sm-3">
					<input name="ip" type="text" class="form-control" value="${article.ip}" readonly="readonly">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 control-label" >내용</label>
				<div class="col-sm-8">
					<textarea name="content" cols="50" rows="5" class="form-control"  style="resize: none;">${article.content}</textarea>
				</div>
			</div>
			
		</form>
			<div class="py-2" align="center">
				<a href="./boardList.do?pageNum=${pageNum}" 
				class="btn btn-outline-secondary"> 글목록</a>
				<a href="#" onclick="checkData()" 
				class="btn btn-outline-primary"> 수정</a>
			</div>
	</div>
	<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>



