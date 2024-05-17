<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글List</title>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="./resources/css/border.css" />
</head>
<body>
<div class="container py-4">
	<div align="center" class="title">
		<h2>게시글 리스트</h2>
	</div>
	<div id="content" align="center">
	<div class="row align-items-md-stretch" style="width: 100%;">
		<form action="">
		<div style="padding-top: 20px;" align="center">
		<div class="text_end text-right mb-2" style="text-align: right;">
			<span class="btn btn-outline-primary">전체 게시글 수 ${total} 건</span>
		</div>
		<table class="table table-hover text-center table-bordered" style="">
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
						         <td>${article.subject}</td>
						         <td>${article.regdate}</td>
						         <td>${article.readcount}</td>
						         <td>${article.writer}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:when test="${fn:length(articles) == 0}">
						<tr>
							<td colspan="5"> 게시글이 없습니다. </td>
						</tr>
					</c:when>
				</c:choose>
			</tbody>
			
		</table>
		</div>
		</form>
		<div class="py-3" align="right">							
			<a href="writeForm.do"> 
				<button type="button" class="btn btn-outline-secondary">글쓰기</button>
			</a>				
		</div>
		<input type="hidden" name="pageNum" value="${pageNum}" />
		</div>
	</div>
</div>
</body>
</html>