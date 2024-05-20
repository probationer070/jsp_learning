<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<title>게시글</title>
	<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
	<link rel="stylesheet" href="./resources/css/border.css" />
	<script src="./resources/js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="./resources/js/boardScript.js"></script>
</head>
<body>
	<div class="container py-8">
		<div align="center" class="title mt-5">
			<h2>게시글 내용</h2>
		</div>
		<div id="content" align="center">
			<div class="row align-items-md-stretch" style="width: 60%;">
				<form name="form1" action="" method="post">
				
					<div style="padding-top: 20px;" align="center">
						<table class="table table-hover text-center table-bordered" style="">

							<tr>
								<th width="45%" class="col-sm-4 control-label">제목</th>
								<td align="right"><input name="subject"
									class="form-control-plaintext" value="${article.subject}" readonly="readonly"></td>
							</tr>
							<tr>
								<th width="45%" class="col-sm-4 control-label">작성자</th>
								<td align="right"><input name="writer"
									class="form-control-plaintext" value="${article.writer}" readonly="readonly"></td>
							</tr>
							<tr>
								<th width="45%" class="col-sm-4 control-label">내용</th>
								<td align="right"><textarea cols="50" rows="7" 
										style="resize: none;" name="content" class="form-control-plaintext "
										readonly="readonly">${article.content}</textarea></td>
							</tr>
							<tr>
								<th width="45%" class="col-sm-4 control-label">작성일</th>
								<td align="right"><input name="regdate" type="text" readonly="readonly"
									 class="form-control-plaintext " value="${article.regdate}"></td>
							</tr>
							<tr>
								<th width="45%" class="col-sm-4 control-label">비문</th>
								<td align="right"><input name="passwd" type="password" readonly="readonly"
									class="form-control-plaintext " value="${article.passwd}"></td>
							</tr>

						</table>
					</div>
					
				<div class="py-3" align="right">
					<button type="button" class="btn btn-outline-secondary" id="callList">글목록</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-outline-info" id="reply">답글</button>
					<button type="button" class="btn btn-outline-primary" id="update">글수정</button>
					<button type="button" class="btn btn-outline-danger" id="delete">글삭제</button>
				</div>
				
				<input type="hidden" name="pageNum" value="${pageNum}" />
				<input type="hidden" name="bno" value="${article.bno}" />
				<input type="hidden" name="bref" value="${article.bref}" />
				<input type="hidden" name="blevel" value="${article.blevel}" />
				<input type="hidden" name="bstep" value="${article.bstep}" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>