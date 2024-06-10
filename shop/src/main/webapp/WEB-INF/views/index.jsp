<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShopTest</title>
</head>
<body>	
	
	<div class="BigConatiner">
		<c:import url="./header.jsp" />
        <div class="container">
        	<div class="AsideSign">
		        <aside>
					<article id="login_box">
					<form name="form1" action="" method="post">
						<div id="login_buttonn">
						<c:choose>
							<c:when test="${ssKey!=null and ssKey.m_role=='admin'}">
								<img id="login-title" src="/images/ttl_logOut.png"
									style="height: 25px; border-radius: 5px;">
								
							<div class="login_form">
								<span id="logout_btn"><img alt="logout" id="login_btn" src="/images/btn_logout.png" 
									style="width: 80px; height: 40px; border-radius: 5px;"></span>
								<ul id="login_input">
									<li style="height: 20px;">${ssKey.m_name}님</li>
									<li style="height: 20px;">반갑습니다</li>
								</ul>
							</div>
							</c:when>
							<c:when test="${ssKey==null}">
									<img id="login-title" src="/images/ttl_login.png"
										style="height: 25px; border-radius: 5px;">
								<div class="login_form">
									<span id="submitTop"><img alt="login" id="login_btn" src="/images/btn_Login.gif"></span>
									<ul id="login_input">
										<li><input type="text" name="mem_id" class="chk" title="아이디"></li>
										<li><input type="password" name="m_passwd" class="chk" title="패스워드"></li>
									</ul>
								</div>	
							</c:when>
						</c:choose>
						</div>
					</form>
					<div class="clear"></div>
					<div id="join_Search">
						<a href="join"><img src="/images/btn_join.gif" style="width: 50px; height: 18px;"></a>
						<a href="join"><img src="/images/btn_search.gif" style="width: 110px; height: 18px;"></a>
					</div>
					</article>
				</aside>
        	</div>
			<div class="MainCont">
	            <div id="contents">
	            	<img src="/images/xp.gif" style="width: 100%;" />
	            	<h2>TEST</h2>
	            	<p>awoeigawelgiawo;eigjawlekmgoaiwevaoieflkawnefoim;weflkawmeofiwefo</p>
	            </div>
			</div>
        </div>
    </div>
    <div class="clear"></div>
	<c:import url="./footer.jsp" />
</body>
</html>