<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<article id="login_box">
		<div id="login_buttonn">
		<c:choose>
			<c:when test="${ssKey!=null and ssKey.m_role=='admin'}">
				<img id="login-title" src="../images/ttl_logOut.png"
					style="height: 25px; border-radius: 5px;">
				<p style="text-align: center">ADMIN님 환영합니다</p>
			</c:when>
			<c:when test="${ssKey==null}">
				<img id="login-title" src="../images/ttl_login.png"
					style="height: 25px; border-radius: 5px;">
			</c:when>
		</c:choose>
		</div>
	<div class="clear"></div>
	</article>
</body>
</html>