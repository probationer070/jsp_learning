<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>
<link rel="stylesheet" type="text/css" href="./css/MemberList.css" />
<script type="text/javascript" src="./js/jquery-3.7.1.min.js"></script>
<script src="./js/product.js" defer="defer"></script>
</head>
<body>
	
<div id="productmgt">
	<h2>상품목록</h2>
	<div class="totalitem" align="right">총 회원수 : ${memTot}</div>
	<table>
		<thead>
			<tr>
				<th class="mcol1">회원번호</th>
				<th class="mcol2">회원비밀번호</th>
				<th class="mcol3">회원이름</th>
				<th class="mcol4">이메일</th>
				<th class="mcol5">전화번호</th>
				<th class="mcol6">직업</th>
				<th class="mcol7">등록일</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(members)==0}">
					<tr>
						<th colspan="5">등록된 고객이 없습니다.</th>
					</tr>
				</c:when>
				<c:when test="${fn:length(members)>0}">
					<c:forEach var="member" items="${members}">
						<tr>
	   					<td class="mcol1">
	   					<input type="text" name="mem_id" value="${member.mem_id}"
	    					class="" readonly="readonly">
		    				</td>
	    				<td class="mcol2 pDetail">
						<input type="text" name="m_passwd" value="${member.m_passwd}"
						     					class="" readonly="readonly">
						</td>
	     				<td class="mcol3">
     					<input type="text" name="m_name" value="${member.m_name}"
	   						class="number" readonly="readonly">
		   				</td>
		   				<td class="mcol4">
	   					<input type="text" name="m_email" value="${member.m_email}"
		   					class="" readonly="readonly">
		   				</td>
		   				<td class="mcol5">
	   					<input type="text" name="m_phone" value="${member.m_phone}"
		   					class="number" readonly="readonly">
		   				</td>
		   				<td class="mcol6">
	   					<input type="text" name="m_job" value="${member.m_job}"
		   					class="number" readonly="readonly">
		   				</td>
		   				<td class="mcol7">
	   					<input type="text" name="m_regdate" value="${member.m_regdate}"
		   					class="number" readonly="readonly">
		   				</td>
		   				</tr>
					</c:forEach> 
				</c:when>
			</c:choose>
		</tbody>
	</table>
</div>
			
</body>
</html>