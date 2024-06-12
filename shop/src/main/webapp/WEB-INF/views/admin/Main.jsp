<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ShopTest</title>

</head>
<body>	
	
	<div class="BigConatiner">
		<c:import url="./header.jsp" />
        <div class="container">
        	<div class="AsideSign">
		        <aside>					
	            	<c:import url="./Aside.jsp"/>
				</aside>
        	</div>
			<div class="MainCont">
	            <div id="contents">
	            	<c:import url="${content}"></c:import>
	            </div>
			</div>
        </div>
    </div>
    <div class="clear"></div>
	<c:import url="./footer.jsp" />
</body>
</html>