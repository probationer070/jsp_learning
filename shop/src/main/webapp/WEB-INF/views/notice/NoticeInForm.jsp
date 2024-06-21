<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" type="text/css" href="/css/notice.css" />
<script type="text/javascript" src="/js/notice.js"></script>
<script type="text/javascript" src="/js/product.js"></script>
</head>
<body>
<div id="Notice">
   	<h2>공지사항 등록</h2>
	<form action="" name="form1" method="post">
   	<table>
   		<tbody>
			<tr>
				<th class="ncol1">제목</th>
				<th class="ncol2">
					<input type="text" name="subject" class="chk" title="제목" placeholder="상품명 입력"> 
				</th>
				<th class="ncol3"><font></font></th>
  			</tr>
			<tr>
				<th class="ncol1">작성자</th>
				<th class="ncol2">
					<input type="text" name="writer" class="chk" title="작성자" placeholder="재고 입력"> 
				</th>
				<th class="ncol3"><font></font></th>
  			</tr>
			<tr>
				<th class="ncol1">내용</th>
				<th class="ncol2">
					<input type="text" name="content" class="chk" title="내용" placeholder="재고 입력"> 
				</th>
				<th class="ncol3"><font></font></th>
  			</tr>
			<tr>
				<th class="ncol1">작성일자</th>
				<th class="ncol2">
					<input type="text" name="vdate" class="chk" title="작성일자" placeholder="상품가격 입력"> 
				</th>
				<th class="ncol3"><font></font></th>
  			</tr>
			<tr>
				<th class="ncol1">생성일자</th>
				<th class="ncol2">
					<input type="text" name="regdate" class="chk" title="생성일자" placeholder="상품설명 입력"> 
				</th>
				<th class="ncol3"><font></font></th>
  			</tr>
   		</tbody>
   	</table>
   	<div class="btnArea">
   		<button type="button" name="insert nsubmit" class="btn-primary">등록</button>
   		<button type="button" class="btn-second btn-primary" onclick="location.href='/admin/notice'">공지사항목록</button>
   		<!-- <button type="button" name="update" class="btn-primary psubmit">수정</button> -->
   	</div>
	</form>
</div>
</body>
</html>