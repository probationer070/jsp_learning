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
		<label>ī���ȣ</label>
		<input name="cardNo" maxlength="16">
		<br>
		<label>��ȿ����(��)</label>
		<input name="expireMonth" maxlength="2">
		<br>
		<label>��ȿ����(��)</label>
		<input name="expireYear" maxlength="2">
		<br>
		<label>��й�ȣ ��2�ڸ� </label>
		<input name="cardPw" maxlength="2">
		<br>
		<label>�������(6����)</label>
		<input name="birthday" maxlength="6">
		<br>
		<label>�ݾ�</label>
		<input name="amount">
		<br>
		<input type="submit" value="�����ϱ�">
		&nbsp;
		<a href="/cancelForm">����ϱ�</a>
	</form>
</body>
</html>