<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<title>게시글List</title>
	<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
	<link rel="stylesheet" href="./resources/css/border.css" />
	<script src="./resources/js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="./resources/js/boardScript.js"></script>
</head>
<body>
	<div class="container py-8">
		<div align="center" class="title mt-5">
			<h2>게시글 작성</h2>
		</div>
		<div id="content" align="center">
			<div class="row align-items-md-stretch" style="width: 60%;">
				<form name="form1" action="writePro.do" method="post">
				
					<div style="padding-top: 20px;" align="center">
						<table class="table table-hover text-center table-bordered" style="">

							<tr>
								<th width="45%" class="col-sm-4 control-label">제목</th>
								<td align="right">
								<c:choose>
									<c:when test="${articles!=null && articles.bno!=0}">
										<input name="subject" class="form-control chk" 
												title="제목" placeholder="제목을 입력하시오." value="[답글]">	
									</c:when>
									<c:otherwise>
										<input name="subject" class="form-control chk" 
												title="제목" placeholder="제목을 입력하시오.">	
									</c:otherwise>
								</c:choose>
								</td>
							</tr>
							<tr>
								<th width="45%" class="col-sm-4 control-label">작성자</th>
								<td align="right"><input name="writer"
									class="form-control chk" title="작성자" placeholder="작성자"></td>
							</tr>
							<tr>
								<th width="45%" class="col-sm-4 control-label">내용</th>
								<td align="right"><textarea cols="50" rows="7" title="내용"
										style="resize: none;" name="content" class="form-control chk"
										placeholder="내용"></textarea></td>
							</tr>
							<tr>
								<th width="45%" class="col-sm-4 control-label">비문</th>
								<td align="right"><input name="passwd" type="password"
									title="비밀번호" class="form-control chk" placeholder="비밀번호"></td>
							</tr>

						</table>
					</div>
					
					<div class="py-3" align="right">
						<button type="button" class="btn btn-outline-secondary" id="callList">글목록</button>
						<button type="button" class="btn btn-outline-primary" id="sendSubmit">등록</button>
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