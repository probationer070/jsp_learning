<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
<link rel="stylesheet" type="text/css" href="./css/ProductMgt.css" />
<script type="text/javascript" src="./js/product.js"></script>
</head>
<body>
<div id="productmgt">
   	<h2>상품정보 수정</h2>
	<form action="" name="form1" method="post" enctype="multipart/form-data">
   	<table>
   		<tbody>
			<tr>
				<th class="pcol1">상품명</th>
				<th class="pcol2">
					<input type="text" name="p_name" class="chk" title="상품명" value="${product.p_name}" > 
					<input type="hidden" name="p_no" title="상품명" value="${product.p_no}" > 
				</th>
				<th class="pcol3"><font></font></th>
  			</tr>
			<tr>
				<th class="pcol1">재고수량</th>
				<th class="pcol2">
					<input type="text" name="stock" class="chk inNum number" title="재고수량" value="${product.stock}" > 
				</th>
				<th class="pcol3"><font></font></th>
  			</tr>
			<tr>
				<th class="pcol1">상품가격</th>
				<th class="pcol2">
					<input type="text" name="price" class="chk inNum number" title="상품가격" value="${product.price}" > 
				</th>
				<th class="pcol3"><font></font></th>
  			</tr>
			<tr>
				<th class="pcol1">상품설명</th>
				<th class="pcol2">
					<input type="text" name="detail" class="chk" title="상품설명" value="${product.detail}" > 
				</th>
				<th class="pcol3"><font></font></th>
  			</tr>
			<tr>
				<th class="pcol1">상품이미지</th>
				<th class="pcol2">
					<a href="#">
						<img alt="이미지" src="/upload/${product.image}">
						<input type="file" name="image2" value="${product.image}">
						<input type="hidden" name="image" value="${product.image}">
					</a>
				</th>
				<th class="pcol3"><font></font></th>
  			</tr>
   		</tbody>
   	</table>
   	<div class="btnArea">
   		<button type="button" name="updatePro" class="btn-primary psubmit">수정완료</button>
   		<button type="button" class="btn-second" onclick="javascript:location.href='/productDetail?p_no=${product.p_no}'">상품페이지로</button>
   	</div>
	</form>
</div>
</body>
</html>