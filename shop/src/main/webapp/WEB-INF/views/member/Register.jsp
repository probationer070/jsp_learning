<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<form action="registerProc" name="form1" method="post">
	<table>
		<tr>
			<th colspan="2">회원가입</th>
		</tr>
		<tr>
			<th>아이디</th>
			<th><input type="text" id="idchk" title="ID" class="chk" placeholder="ID 입력 필수">
				<font id="warning" size="2" color="red"></font>
			</th>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" id="idchk">회원가입</button>
			</td>
		</tr>
	</table>
	
</form>
</body>
<script type="text/javascript" src="js/jquery-3.7.1.min.js" defer></script>
<script type="text/javascript" src="js/member.js" defer></script>
</html>