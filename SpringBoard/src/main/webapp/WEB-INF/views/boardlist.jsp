<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글List</title>
<link rel="stylesheet" href="recs/css/bootstrap.min.css" />
<link rel="stylesheet" href="recs/css/border.css" />
<script src="recs/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="recs/js/boardScript.js"></script>
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
				</div>
				<table class="table table-hover text-center table-bordered table-striped">
					<thead class="table-primary">
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
								        			<img src="recs/images/level.gif" width="${article.blevel*10}" height="5">
								        			<img src="recs/images/re.gif">
											        <a href="#" onclick="callContent('${article.bno}')">
											        	${article.subject}</a>
								        		</c:when>
								        		<c:otherwise>
								        			<img src="recs/images/level.gif" width="5" height="5">
											        <a href="#" onclick="callContent('${article.bno}')">
											        	${article.subject}</a>
								        		</c:otherwise>
								        	</c:choose>
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
	       	<input type="hidden" name="bno" value="">
			<input type="hidden" name="pageNum" value="${pageNum}" />
			<div align="center">
				<c:forEach var="pno" begin="${pdto.startPage}" end="${pdto.endPage}">
					<c:choose>
						<c:when test="${items != null && text != null}">
							<c:set scope="request" var="items" value="${items}"></c:set>
							<c:set scope="request" var="text" value="${text}"></c:set>
							<c:set scope="page" var="list" value="./boardlist?curPg=${pno}&${pdto.curBlock}&text=${text}&items=${items}"></c:set>
						</c:when>
						<c:otherwise>
							<c:set scope="page" var="list" value="./boardlist?curPg=${pno}&${pdto.curBlock}"></c:set>
						</c:otherwise>
					</c:choose>
					<%-- <a href="./boardlist?curPg=${pno}"> --%>
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
			</div>
			<div class="mt-5 d-inline-flex justify-content-between" style="width: 350px; float:left">
				<select name="items" class="txt">
					<option value="subject">제목에서</option>
					<option value="content">본문에서</option>
					<option value="writer">글쓴이에서</option>
				</select> 
				<input id="text" name="text" type="text" value="${text}"/> 
				<input type="button" id="searchBtn" class="btn btn-primary btn-sm" value="검색"/>		
			</div>
		</form>
		</div>
	</div>
</div>
</body>
</html>