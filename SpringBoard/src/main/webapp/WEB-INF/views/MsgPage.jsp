<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message</title>
<script src="recs/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		var msg = "${msg}";
		alert(msg);
		$(location).attr('href', '${newView}');
	})
</script>
</head>
<body>
</body>
</html>