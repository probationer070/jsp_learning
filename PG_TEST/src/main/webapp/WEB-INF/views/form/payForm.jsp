<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="/payProc">
	
		<h1>Payform</h1>
		<label>카드번호</label>
		<input name="cardNo" maxlength="16">
		<br>
		<label>유효가간(월)</label>
		<input name="expireMonth" maxlength="2">
		<br>
		<label>유효가간(년)</label>
		<input name="expireYear" maxlength="2">
		<br>
		<label>비밀번호 앞2자리 </label>
		<input name="cardPw" maxlength="2">
		<br>
		<label>생년월일(6저라)</label>
		<input name="birthday" maxlength="6">
		<br>
		<label>금액</label>
		<input name="amount">
		<br>
		<input type="submit" value="결제하기">
		&nbsp;
		<a href="/cancelForm">취소하기</a>
	</form>
</body>
</html>