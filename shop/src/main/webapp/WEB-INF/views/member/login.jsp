	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/aloneLogin.css" />
<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
</head>
<body>
<div class="BigConatiner">
	<div class="container">
			<div class="loginform">
			<div id="Large-login-box">
			<h1 class="login-title">LOGIN</h1>
			<form action="loginProc" method="post" name="LoginForm">
				<ul class="large-login-input">
					<li>
						<input type="text" name="mem_id" class="id chk" title="ID" placeholder="ID">
					</li>
					<li>
						<input type="password" name="m_passwd" class="pw chk" title="PW" placeholder="PASSWORD">
					</li>
				</ul>
				<button class="btn-primary login-btn">Login</button>
			
			</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>