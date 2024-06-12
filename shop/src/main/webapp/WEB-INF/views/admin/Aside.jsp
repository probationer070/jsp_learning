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
		<div id="login_button">
		<form name="LoginForm" action="" method="post">
		<c:choose>
			<c:when test="${ssKey!=null or ssKey.m_role=='mem'}">
				<img id="login-title" src="/images/ttl_logOut.png"
					style="height: 25px; border-radius: 5px;">
			<div class="login_form">
				<ul id="login_input">
					<li style="height: 20px;">${ssKey.m_name}님</li>
					<li style="height: 20px;">반갑습니다</li>
				</ul>
				<span id="logout_btn"><img alt="logout" id="login_btn" src="/images/btn_logout.png" 
					style="width: 60px; height: 35px; border-radius: 5px;"></span>
			</div>
			</c:when>
			<c:when test="${ssKey==null}">
				<img id="login-title" src="/images/ttl_login.png"
						style="height: 25px; border-radius: 5px;">
				<div class="login_form">
					<ul id="login_input">
						<li><input type="text" name="mem_id" class="chk" title="아이디"></li>
						<li><input type="password" name="m_passwd" class="chk" title="패스워드"></li>
					</ul>
					<span id="submitTop"><img alt="login" id="login_btn" src="/images/btn_Login.gif"></span>
				</div>	
			</c:when>
		</c:choose>
		</form>
		</div>
	</article>
</body>
</html>