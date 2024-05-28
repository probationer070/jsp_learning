<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="../recs/css/bootstrap.min.css" />
</head>
<body>
<div class="container py-1">
	<div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5 d-flex flex-column text-center">
        <h1 class="fw-bold">회원 로그인</h1>
        <p class="fs-4 text-center">Membership Login</p>      
      </div>
    </div>
	
	

	<div class="container" align="center">
		<div class="col-md-4 col-md-offset-4">
			<h3 class="form-signin-heading">Please sign in</h3>
  			<form class="form-signin" action="loginPro" method="post">
  
    			<div class="form-floating mb-3 row">     
      				<input type="text" class="form-control" name='id' id="floatingInput" placeholder="ID" required autofocus>
      				<label for="floatingInput">ID</label>      
    			</div>
    			<div class="form-floating  mb-3 row">     
     	 			<input type="password" class="form-control" name='password' placeholder="Password">
    				 <label for="floatingPassword">Password</label>
			</div>

   
  				<button class="btn btn btn-lg btn-primary btn-block" type="submit">로그인</button>
   				
  			</form>

		</div>
	</div>
</div>


</body>
</html>