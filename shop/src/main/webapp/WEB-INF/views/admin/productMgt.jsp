<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>
<link rel="stylesheet" type="text/css" href="./css/ProductMgt.css" />
<script type="text/javascript" src="./js/jquery-3.7.1.min.js"></script>
<script src="./js/product.js" defer="defer"></script>
</head>
<body>
	<div class="BigConatiner">
		<c:import url="./header.jsp" />
        <div class="container">
        	<div class="AsideSign">
		        <aside>					
	            	<c:import url="./Aside.jsp"/>
				</aside>
        	</div>
			<div class="MainCont">
	            <div id="productmgt">
	            	<h2>상품목록</h2>
	            	<div class="totalitem" align="right">총 상품수 : 
	            		<input name="total" type="button" value="${pcnt}" readonly="readonly"></div>
	            	<table>
	            		<thead>
	            			<tr>
	            				<th class="pcol1">상품번호</th>
	            				<th class="pcol2">상품명</th>
	            				<th class="pcol3">상품가격</th>
	            				<th class="pcol4">등록일</th>
	            				<th class="pcol5">재고</th>
	            			</tr>
	            		</thead>
	            		<tbody>
	            			<c:choose>
	            				<c:when test="${fn:length(productList)==0}">
	            					<tr>
	            						<th colspan="5">등록된 상품이 없습니다.</th>
	            					</tr>
	            				</c:when>
	            				<c:when test="${fn:length(productList)>0}">
	            					<c:forEach var="product" items="${productList}">
	            						<tr>
				            				<td class="pcol1">
				            					<input type="text" name="p_no" value="${product.p_no}"
				            					class="" readonly="readonly">
				            				</td>
				            				<td class="pcol2 pDetail">
												<input type="text" name="p_name" value="${product.p_name}"
				            					class="" readonly="readonly">
											</td>
				            				<td class="pcol3">
				            					<input type="text" name="price" value="${product.price}"
				            					class="number" readonly="readonly">
				            				</td>
				            				<td class="pcol4">
				            					<input type="text" name="pr_date" value="${product.pr_date}"
				            					class="" readonly="readonly">
				            				</td>
				            				<td class="pcol5">
				            					<input type="text" name="stock" value="${product.stock}"
				            					class="number" readonly="readonly">
				            				</td>
				            			</tr>
	            					</c:forEach> 
	            				</c:when>
	            			</c:choose>
	            		</tbody>
	            	</table>
	            	<div class="btnArea">
	            		<button type="button" class="btn-primary" onclick="location.href='/productInForm'">상품등록</button>
	            	</div>
	            </div>
			</div>
        </div>
    </div>
    <div class="clear"></div>
	<c:import url="./footer.jsp" />
</body>
</html>