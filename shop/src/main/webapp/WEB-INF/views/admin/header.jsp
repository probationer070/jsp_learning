<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- <link rel="stylesheet" href="css/bootstrap.min.css" /> -->
<link rel="stylesheet" type="text/css" href="../css/index.css" />
<link rel="stylesheet" type="text/css" href="../css/header.css" />
<link rel="stylesheet" type="text/css" href="../css/footer.css" />
<link rel="stylesheet" type="text/css" href="../css/common.css" />
<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../js/zipCheck.js"></script>

<!-- <input type="text" id="sample6_postcode" placeholder="우편번호">
<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="sample6_address" placeholder="주소"><br>
<input type="text" id="sample6_detailAddress" placeholder="상세주소">
<input type="hidden" id="sample6_extraAddress" placeholder="참고항목"> -->

<body>

	<!-- 네비게이션 바 추가 -->
	<div class="HeaderContainer">
	<nav class="">
	    <div class="head-container">
	        <a id="logo" href="/admin"><svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px" width="30" height="30" viewBox="0,0,256,256"><g fill="#ffffff" fill-rule="nonzero" stroke="none" stroke-width="1" stroke-linecap="butt" stroke-linejoin="miter" stroke-miterlimit="10" stroke-dasharray="" stroke-dashoffset="0" font-family="none" font-weight="none" font-size="none" text-anchor="none" style="mix-blend-mode: normal"><g transform="scale(8.53333,8.53333)"><path d="M15,3c-6.627,0 -12,5.373 -12,12c0,6.29 4.842,11.43922 11,11.94922v-3.14648c0,-0.474 -0.31534,-0.90281 -0.77734,-1.00781c-3.697,-0.839 -6.42294,-4.23247 -6.21094,-8.23047c0.217,-4.091 3.66381,-7.44555 7.75781,-7.56055c4.524,-0.128 8.23047,3.50109 8.23047,7.99609c0,0.383 -0.03589,0.75795 -0.08789,1.12695c-0.015,0.106 -0.03083,0.20945 -0.04883,0.31445c-0.042,0.23 -0.09525,0.45669 -0.15625,0.67969c-1.415,5.498 -7.83195,9.37003 -8.62695,9.83203c0.304,0.023 0.60992,0.04688 0.91992,0.04688c6.627,0 12,-5.373 12,-12c0,-6.627 -5.373,-12 -12,-12z"></path></g></g>
			</svg></a>
	        <div class="" id="navbarNav">
	            <ul class="navbar-nav">
	                <li class="nav-item active">
	                    <a href="/admin">Home <span class="sr-only">(current)</span></a>
	                </li>
	                <c:choose>
		             	<c:when test="${ssKey!=null and ssKey.m_role=='admin'}">
		             		<c:if test="${ssKey!=null}">
			             		<li class="nav-item">
				                    <a href="/logoutProc">logout</a>
				                </li>
				            	<li class="nav-item">
				                    <a href="/admin/info">INFO</a>
				                </li>
		             		</c:if>
			                <li class="nav-item">
			                    <a href="/notice">Notice</a>
			                </li>
			            </c:when>
			            <c:otherwise>
			            	<c:redirect url="/" context="/" />
			            </c:otherwise>
		            </c:choose>
	            </ul>
	        </div>
	    </div>
	</nav>		
	
	<header class="text-center py-4">
	    <h1>Header</h1>
	</header>
	<nav id="main_menu">
		<ul>
			<li><a href="/boardMgt">자유게시판 관리</a></li>
			<li><a href="/productMgt">상품관리</a></li>
			<li><a href="/orderMgt">주문관리</a></li>
			<li><a href="/memberMgt">회원관리</a></li>
			<li><a href="/DelveryMgt">배송관리</a></li>
		</ul>
	</nav>
	</div>
</body>