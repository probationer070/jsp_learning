<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>PAY RESULT</title>
<style>
	table, tr, th {
	border-collapse: collapse;
	border: 1px solid #000;
	padding: 4px;
	}
</style>
</head>
<body>
	<!-- <table>
		<thead>
			<tr>
			<th>orderNumber</th>
			<th>amount</th>
			<th>cardName</th>
			<th>authNumber</th>
			<th>authDateTime</th>
			<th>thansactionId</th>
			<th>responseCode</th>
			<th>responseMsg</th>
			</tr>
		</thead>	
		<tbody>
			<tr>
			<th>${data.orderNumber}</th>
			<th>${data.amount}</th>
			<th>${data.cardName}</th>
			<th>${data.authNumber}</th>
			<th>${data.authDateTime}</th>
			<th>${data.transactionId}</th>
			<th>${data.responseCode}</th>
			<th>${data.responseMsg}</th>
			</tr>
		</tbody>
	
	</table> -->
	<p>${data}</p>
	<c:if test="${data.responseCode eq '0000'}" >
		<p>${responseMsg}</p>
		<p>ó�� ����</p>
	</c:if>
	<!-- 'ne' == '!=' -->
	<c:if test="${data.responseCode ne '0000'}" >
		<p>${responseMsg}</p>
		<p>ó�� ����</p>
	</c:if>
	
	<!-- <a href="/cancelForm">����ϱ�</a> -->
	<a href="/cancelProc2">����ϱ�2</a>
</body>
</html>