<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="/cancelProc">
	
		<h1>CancelPayform</h1>
		<label>주문번호</label>
			<input name="transactionId">
		<br>
		<input type="submit" value="취소하기">
		&nbsp;
		<a href="/payFrom">돌아가기</a>
	</form>
</body>
</html>