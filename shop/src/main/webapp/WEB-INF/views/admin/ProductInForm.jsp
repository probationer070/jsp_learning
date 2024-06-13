<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" type="text/css" href="./css/ProductMgt.css" />
<script type="text/javascript" src="./js/product.js"></script>
</head>
<body>
<div id="productmgt">
   	<h2>상품등록</h2>
	<form action="" name="form1" method="post" enctype="multipart/form-data">
   	<table>
   		<tbody>
			<tr>
				<th class="pcol1">상품명</th>
				<th class="pcol2">
					<input type="text" name="p_name" class="chk" title="상품명" placeholder="상품명 입력"> 
				</th>
				<th class="pcol3"><font></font></th>
  			</tr>
			<tr>
				<th class="pcol1">재고수량</th>
				<th class="pcol2">
					<input type="text" name="stock" class="chk" title="재고수량" placeholder="재고 입력"> 
				</th>
				<th class="pcol3"><font></font></th>
  			</tr>
			<tr>
				<th class="pcol1">상품가격</th>
				<th class="pcol2">
					<input type="text" name="price" class="chk" title="상품가격" placeholder="상품가격 입력"> 
				</th>
				<th class="pcol3"><font></font></th>
  			</tr>
			<tr>
				<th class="pcol1">상품설명</th>
				<th class="pcol2">
					<input type="text" name="detail" class="chk" title="상품설명" placeholder="상품설명 입력"> 
				</th>
				<th class="pcol3"><font></font></th>
  			</tr>
			<tr>
				<th class="pcol1">상품이미지</th>
				<th class="pcol2">
					<input type="file" name="image2" class="chk" title="상품이미지"> 
				</th>
				<th class="pcol3"><font></font></th>
  			</tr>
   		</tbody>
   	</table>
   	<div class="btnArea">
   		<button type="button" name="insert" class="btn-primary psubmit">등록</button>
   		<button type="button" name="update" class="btn-primary psubmit">수정</button>
   	</div>
	</form>
</div>
</body>
</html>