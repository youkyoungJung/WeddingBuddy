<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="/css/style.css">
<!-- 부트스트랩 -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">


<style type="text/css">
.nav {
	padding-top: 12px;
	padding-bottom: 5px;
	justify-content: space-between;
	align-items: center;
	display: flex;
	position: relative;
	margin: auto;
	max-width: 1128px;
	padding-left: 16px;
	padding-right: 16px;
	font-size: 14px;
	text-decoration: none;
}

.nav-link {
	font-weight: 900;
	margin-right: auto;
	color: #777;
	margin-left: 30px;
	cursor: pointer;
	text-decoration: none;
	padding: 0;
}

.navbar-brand {
	padding: 0;
}

.top-nav-menu {
	display: flex;
	list-style: none;
	margin: 0;
	padding: 0;
	align-items: center;
	margin-right: 20px;
}

.top-nav-account {
	display: flex;
	list-style: none;
	align-itmes: center;
	margin-right: 4px;
	margin: 0;
	padding: 0;
}

.top-nav-account li {
	display: inline-block;
	margin-right: 5px;
}

.top-nav-account li a {
	display: block;
	text-align: center;
}

.top-nav-menu li {
	display: inline-block;
	margin-right: 5px;
}

.top-nav-menu li a {
	display: block;
	text-align: center;
}

.menu-divider {
	display: flex;
	background-color: #777;
	width: 1px;
}
</style>



</head>
<body>




	<nav class="nav" aria-label="기본">

		<a class="nav-link navbar-brand" href="/weddingBuddy"
			style="padding: 0"> <span class="sr-only">WeddingBuddy</span> <icon
				class="" aria-hidden="true" aria-busy="false"> <img
				src="<c:url value='/images/logo.jpg'></c:url>" height="50"
				class="d-inline-block brand-image" alt=""> <b>WeddingBuddy</b></a>


		<ul class="top-nav-menu">
			<li class=""><a href="<c:url value='/search/planner'></c:url>"
				class=""> <span class="nav-link"> 플래너찾기 </span>
			</a></li>
			<li class=""><a href="<c:url value='/dress'></c:url>" class="">
					<span class="nav-link"> 스튜디오 </span>
			</a></li>
			<li class=""><a href="<c:url value='/#'></c:url>" class="">
					<span class="nav-link"> 드레스 </span>
			</a></li>
			<li class=""><a href="<c:url value='/#'></c:url>" class="">
					<span class="nav-link"> 메이크업 </span>
			</a></li>
		</ul>
		<span class="menu-divider" style="height: 33px;"></span>

		<ul class="top-nav-account">
			<c:if test="${!p_isLogin && !isLogin}">
				<li><a class="nav-link" href="<c:url value='/planner/login'/>"><i
						class="pe-7s-lock"></i>플래너 로그인</a></li>
				<li><a class="nav-link" href="<c:url value='/login'/>"><i
						class="pe-7s-lock"></i>유저 로그인</a></li>
			</c:if>
			<c:choose>
				<c:when test="${isLogin }">
					<li><a class="nav-link" href="<c:url value='/mypage'></c:url>">마이페이지</a></li>
					<li><a class="nav-link" href="<c:url value='/logout'/>"><i
							class="pe-7s-lock"></i>로그아웃</a></li>
				</c:when>
				<c:when test="${p_isLogin }">
					<li><a class="nav-link" href="<c:url value='/mypage'></c:url>">마이페이지</a></li>
					<li><a class="nav-link" href="<c:url value='/logout'/>"><i
							class="pe-7s-lock"></i>로그아웃</a></li>
				</c:when>
			</c:choose>
		</ul>

	</nav>
	<div style="height:1; background-color:#777; padding: 1px; margin:20;"></div>
	<div style="padding: 15px;"></div>





</body>
</html>