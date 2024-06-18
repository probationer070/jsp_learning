<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/ProductList.css" />
<script type="text/javascript" src="./js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="./js/product.js"></script>
</head>
<body>
<div id="orderMgt">
	<form action="" name="form1" method="post">
		OD
		<table class="table">
   			<tr>
   				<td class="cols">
   					<a>
	   					<img alt="이미지" src="/upload/${order.image}" height="300" width="300">
   					</a>
   				</td>
   				<td class="cols">
   					<h2>구매상품정보</h2>
   					<table>
						<tr>
							<th class="pcol1-1">상품명</th>
							<th class="pcol2-1">
								<input type="text" name="p_name" class="chk" title="상품명" value="${order.p_name}" readonly="readonly"> 
								<input type="hidden" name="p_no" title="상품명" value="${order.p_no}" readonly="readonly"> 
							</th>
							
			  			</tr>
						<tr>
							<th class="pcol1-1">상품단가</th>
							<th class="pcol2-1">
								<input type="text" name="price" class="chk number" title="재고수량" value="${order.price}" readonly="readonly"> 
							</th>
			  			</tr>
						<tr>
							<th class="pcol1-1">구매수량</th>
							<th class="pcol2-1">
								<input type="text" name="quantity" class="chk inNum" title=" 구매수량"value="${order.quantity}" readonly="readonly"> 
							</th>
			  			</tr>
						<tr>
							<th class="pcol1-1">결재금액</th>
							<th class="pcol2-1">
								<input type="text" name="amount" class="chk number" title="상품가격" value="${order.amount}" readonly="readonly"> 
							</th>
			  			</tr>
				
				   	</table>
				   	
   				</td>
   			</tr>
   		</table>
	</form>
</div>
</body>
</html>