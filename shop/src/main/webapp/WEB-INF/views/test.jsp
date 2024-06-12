<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('.btn-test').on('click', function(){
			
			// $('#my-div').toggle();
			$('#my-div').animate({
			    height: 'toggle'
			}, "fast");
		})
	});
</script>
<style>

.MainContainer {
	display: flex;
	justify-content: center !important;
}

.auth-container {
	display: block;
    flex-direction: column;
    width: 100%;
    max-width: 654px;
}

.mt-20 {
	margin-top: 20px;
}

.input-cont {
	margin-top: 10px;
}

.button-cont {
	text-align:right;
	margin-top: 10px;
}

</style>
</head>
<body>
<div class="MainContainer pt-5">
	<div class="auth-container">
	    <div class="usrn-container mt-20">
			<div class="w-100">
		        <label for="username">Login ID (username)</label>
			</div>
	    	<div class="input-cont w-75">
		        <input class="w-100" type="text" id="username" name="username" placeholder="root" required="required"/>
	    	</div>
	    </div>
		
		<div class="password-container mt-20">
		    <div class="w-100">
		    	<div>
		        <label for="password">Password</label>
		    	</div>
		    	<div class="input-cont w-75">
		        <input class="w-100" type="password" id="password" name="password" placeholder="root" required="required"/>
		    	</div>
		    </div>
		</div>
		
		<div class="email-container mt-20">
		    <div>
  		    	<div>
		        <label for="email">Email</label>
  		    	</div>
  		    	<div class="input-cont w-75">
		        <input class="w-100" type="email" id="email" name="email" placeholder="root@naver.com" required="required"/>
  		    	</div>
		    </div>
		</div>
		
		<div class="name-container mt-20">
		    <div>
		    	<div>
		        <label for="name">Your name</label>
		    	</div>
   		    	<div class="input-cont w-75">
		        <input class="w-100" type="text" id="name" name="name" placeholder="홍길동" required="required"/>
   		    	</div>
		    </div>
		</div>
		
		<div class="button-cont">
		    <button type="submit">가입하기</button>
		</div>
	</div>
</div>

<!-- 버튼으로 div 숨기고 펼치기 -->
<button class="btn-test">Click</button>
<div id='my-div'>
	<p>test awoi oawkfop aiw owiaqpfo eogmowp ;awjfp  iawnp w aijd</p>
</div>
</body>
</html>