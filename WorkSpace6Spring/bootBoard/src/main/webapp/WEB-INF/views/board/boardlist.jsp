<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글List</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css" />
<link rel="stylesheet" href="static/css/border.css" />
<script src="static/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="static/js/boardScript.js"></script>
<script type="text/javascript">
	$(function () {
		$('#Logout').on("click", function() {
			$("form[name=form1]").attr('action', "member/logout")
			$("form[name=form1]").submit();									
		})
		
		$('#Login').on("click", function() {
			$("form[name=form1]").attr('action', "member/login")
			$("form[name=form1]").submit();									
		})

		$('#arti').on("click", function() {
			var s = '${user}';
			alert(s);
			if(s.length == 0) {
				alert("로그인이 필요합니다.");
				return 0;
			}
			return false;
		}) 
	})
</script>
</head>
<body>
<div class="container py-4">
	<div align="center" class="title">
		<h2>게시글 리스트</h2>
	</div>
	<div id="content" align="center">
	<div class="row align-items-md-stretch" style="width: 100%;">
		<form action="" method="post" name="form1">
			<div style="padding-top: 20px;" align="center">
				<div class="text_end text-right mb-2" style="text-align: right;">
					<span class="btn btn-outline-primary">전체 게시글 수 ${totArticle} 건</span>
					
					<%-- <c:choose>
						<c:when test="${empty user}">
							<span class="btn btn-outline-success" id="Login">Login</span>
						</c:when>
						<c:otherwise>
							<span class="btn btn-outline-danger" id="Logout">Logout</span>
						</c:otherwise>
					</c:choose> --%>
				
				</div>
				<table class="table table-hover text-center table-bordered table-striped">
					<thead class="table-primary" style="background: #111">
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
								<c:forEach var="article" items="${articles}">
									<tr>
										<td>${article.rn}</td>
								        <td style="text-align: left; padding-left: 20px;">
								        	<c:choose>
								        		<c:when test="${article.blevel>0}">
								        			<img src="static/images/level.gif" width="${article.blevel*10}" height="5">
								        			<img src="static/images/re.gif">
											        <a href="#" id="arti" onclick="callContent('${article.bno}')">
											        	${article.subject}</a>
								        		</c:when>
								        		<c:otherwise>
								        			<img src="static/images/level.gif" width="5" height="5">
											        <a href="#" id="arti" onclick="callContent('${article.bno}')">
											        	${article.subject}</a>
								        		</c:otherwise>
								        	</c:choose>
								        	<c:if test="${article.readcount > 10}">
								        		<img src="static/images/hot.gif" width="30" height="20">
								        	</c:if>
								        </td>
								        <td>${article.regdate}</td>
								        <td>${article.readcount}</td>
								        <td>${article.writer}</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="5"> 게시글이 없습니다. </td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
				<div class="py-3" align="right">							
					<a href="writeForm"> 
						<button type="button" class="btn btn-outline-secondary">글쓰기</button>
					</a>				
				</div>
			</div>
	       	<%-- <input type="hidden" name="bno" value="0">
			<input type="hidden" name="curPg" value="${pdto.curPg}" />
			<input type="hidden" name="curBlock" value="${pdto.curBlock}" />
			<div align="center">
				<c:if test="${pdto.startPage>pblock}">
					<font color="4c5317">
						<a href="boardlist?curPg=${pdto.startPage-pblock}&curBlock=${pdto.curBlock-1}">[이전]</a>
					</font>
				</c:if>
				<c:forEach var="pno" begin="${pdto.startPage}" end="${pdto.endPage}" step="1">
					<c:set scope="page" var="list" value="./boardlist?curPg=${pno}&curBlock=${pdto.curBlock}&items=${sdto.items}&text=${sdto.text}"/>
					<a href="${list}" >
						<c:choose>
							<c:when test="${pdto.curPg == pno}">
								<font color=" 4c5317" style="font-weight: bold">[${pno}]</font>
							</c:when>
							<c:otherwise>
								<font color=" 4c5317">[${pno}]</font>
							</c:otherwise>
						</c:choose>
					</a>
				</c:forEach>
				<c:if test="${pdto.endPage < pdto.pgCnt}">
					<font color="4c5317">
						<a href="boardlist?curPg=${pdto.startPage + pblock}&curBlock=${pdto.curBlock+1}">[다음]</a>
					</font>
				</c:if>
			</div>
			<div class="mt-5 d-inline-flex justify-content-between" style="width: 350px; float:left">
				<script type="text/javascript">
				$(function() {
					var items='${sdto.items}';
					if(items!=null && items!='')
						$('#searchText').val(items);
				})
				</script>
				<select id="searchText" name="items" class="txt">
					<option value="">선택</option>
					<option value="subject">제목에서</option>
					<option value="content">본문에서</option>
					<option value="writer">글쓴이에서</option>
				</select> 
				<input id="text" name="text" type="text" value="${sdto.text}"/> 
				<input type="button" id="searchBtn" class="btn btn-primary btn-sm" value="검색"/>		
			</div> --%>
			</form>
		</div>
	</div>
</div>
</body>
</html>