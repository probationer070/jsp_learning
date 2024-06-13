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
		<c:choose>
       		<c:when test="${ssKey.m_role=='admin'}">
            	<c:import url="./admin/header.jsp" />
       		</c:when>
       		<c:otherwise>
            	<c:import url="./header.jsp" />
       		</c:otherwise>
       	</c:choose>
        <div class="container">
        	<div class="AsideSign">
		        <aside>
		        	<c:choose>
		        		<c:when test="${ssKey.m_role=='admin'}">
			            	<c:import url="./admin/Aside.jsp"/>
		        		</c:when>
		        		<c:otherwise>
			            	<c:import url="./Aside.jsp"/>
		        		</c:otherwise>
		        	</c:choose>
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