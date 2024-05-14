<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% String sessionId = (String) session.getAttribute("sessionId"); %>
<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<link href = "./resources/css/border.css" rel="stylesheet">
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
<title>게시판</title>
</head>
<body>
<div class="container py-4">
   <jsp:include page="/menu.jsp" />

 <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">게시판</h1>
        <p class="col-md-8 fs-4">Membership Community</p>      
      </div>
    </div>

	<div class="row align-items-md-stretch   text-center">
		<form action="./boardList.do" method="post">
		
			<div class="text-end"> 
					<span class="badge text-bg-warning">전체 ${totArticles} 건</span>
			</div>
			<!-- forEach 출력 -->
			<div style="padding-top: 20px">
				<table class="table table-hover text-center">
					<thead>
						<tr>
							<th style="width: 15%">번호</th>
							<th style="width: 40%">제목</th>
							<th style="width: 15%">작성일</th>
							<th style="width: 15%">조회</th>
							<th style="width: 15%">글쓴이</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${fn:length(articles) > 0}">
								<!-- forEach 사용해서 모두 출력 -->
								<c:forEach var="article" items="${articles}" varStatus="status">
									<tr>
										<td>${article.rn}</td>
										<td style="text-align: left; padding-left: 10px;">
										<a href="./boardView.do?num=${article.num}&pageNum=${pageNum}">${article.subject}</a></td>
										<td>${article.regist_day}</td>
										<td>${article.hit}</td>
										<td>${article.name}</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:when test="${fn:length(articles) == 0}">
								<!-- 테이블의 모든 필드를 합치고 게시글이 없습니다. -->
								<tr>
									<td colspan="5"> 게시글이 없습니다. </td>
								</tr>
							</c:when>
						</c:choose>
					</tbody>
					
				</table>
			</div>
			<div align="center">
				<c:set var="pageNum" value="${pageNum}"/>
				<c:forEach var="p" begin="1" end="${totalPage}">
					<a href="boardList.do?pageNum=${p}">
						<c:choose>
							<c:when test="${pageNum == p}">
								<font color=" 4c5317" style="font-weight: bold">[${p}]</font>
							</c:when>
							<c:otherwise>
								<font color=" 4c5317">[${p}]</font>
							</c:otherwise>
						</c:choose>
					</a>
				</c:forEach>
			</div>
			<div align="left">
				<select name="items" class="txt">
					<option value="subject">제목에서</option>
					<option value="content">본문에서</option>
					<option value="name">글쓴이에서</option>
				</select> 
				<input name="text" type="text" /> 
				<input type="submit" id="btnAdd" class="btn btn-primary " value="검색 " />		
			</div>
		</form>			
		<div class="py-3" align="right">							
			<a href="#" onclick="checkSession()" class="btn btn-secondary"> 글쓰기</a>				
		</div>		
	</div>
  	<jsp:include page="/footer.jsp" />
  </div>	
</body>
</html>