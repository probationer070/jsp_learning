<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Order Form</h1>
	<form action="/orderProc">
		<input type="text" name="amount" value="">
		<input type="hidden" name="itemName" value="Test">
		<input type="hidden" name="userName" value="Testor">
		<input type="submit" value="�ֹ��ϱ�">
		&nbsp;
		<a href="/cancelForm">����ϱ�</a>
	</form>
</body>
</html>