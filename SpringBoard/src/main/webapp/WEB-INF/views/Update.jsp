<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글</title>
<link rel="stylesheet" href="recs/css/bootstrap.min.css" />
<link rel="stylesheet" href="recs/css/border.css" />
<script src="recs/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="recs/js/boardScript.js"></script>
</head>
<body>
	<div class="container py-8">
		<div align="center" class="title mt-5">
			<h2>게시글 수정</h2>
		</div>
		<div id="content" align="center">
			<div class="row align-items-md-stretch" style="width: 60%;">
				<form name="form1" action="updatePro" method="post">
				
					<div style="padding-top: 20px;" align="center">
						<table class="table table-hover text-center table-bordered" style="">

							<tr>
								<th width="45%" class="col-sm-4 control-label table-primary">제목</th>
								<td align="right"><input name="subject"
									class="form-control-plaintext" value="${article.subject}" ></td>
							</tr>
							<tr>
								<th width="45%" class="col-sm-4 control-label table-primary">작성자</th>
								<td align="right"><input name="writer"
									class="form-control-plaintext" value="${article.writer}" ></td>
							</tr>
							<tr>
								<th width="45%" class="col-sm-4 control-label table-primary">내용</th>
								<td align="right"><textarea cols="50" rows="7" 
										style="resize: none;" name="content" class="form-control-plaintext "
										>${article.content}</textarea></td>
							</tr>
							<tr>
								<th width="45%" class="col-sm-4 control-label table-primary">작성일</th>
								<td align="right"><input name="regdate" type="text" 
									 class="form-control-plaintext " value="${article.regdate}"></td>
							</tr>
							<tr>
								<th width="45%" class="col-sm-4 control-label table-primary">비문</th>
								<td align="right"><input name="passwd" type="password" 
									class="form-control-plaintext chk" value="${article.passwd}"></td>
							</tr>

						</table>
					</div>
					
					<div class="py-3" align="right">
						<button type="button" class="btn btn-outline-secondary" id="callList">글목록</button>
						<button type="button" class="btn btn-outline-info" id="saveContent">저장</button>
					</div>
				
					<input type="hidden" name="curPg" value="${pdto.curPg}" />
					<input type="hidden" name="curBlock" value="${pdto.curBlock}" />
					<input type="hidden" name="bno" value="${article.bno}" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>