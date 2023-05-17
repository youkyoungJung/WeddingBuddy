<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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

</head>
<body>
	<section class="header-top-section">
		<div class="container">
			<div class="row">
				<div class="col-md-6"></div>
				<div class="col-md-6">
					<div class="header-top-menu">
						<ul class="nav nav-pills navbar-right">
							<c:if test="${!isLogin}">
								<li><a href="<c:url value='/login'/>"><i
										class="pe-7s-lock"></i>Login/Register</a></li>
							</c:if>
							<c:if test="${isLogin}">
								<li><a href="<c:url value='/mypage'></c:url>">My Page</a></li>
								<li><a href="<c:url value='/logout'/>"><i
										class="pe-7s-lock"></i>Logout</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>

	<header class="header-section">
		<nav class="navbar navbar-default">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/weddingBuddy" style="padding-top: 0">
						<img src="<c:url value='/images/logo.jpg'></c:url>" width="50"
						height="50" class="d-inline-block brand-image" alt="">
					</a> <a class="navbar-brand" href="/weddingBuddy"><b>WeddingBuddy</b></a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class=""><a href="<c:url value='/'></c:url>">Home</a></li>
						<li><a href="<c:url value='/search/planner'></c:url>">플래너찾기</a></li>
						<li><a href="#">드레스</a></li>
						<li><a href="#">헤어</a></li>
						<li><a href="#">메이크업</a></li>
						<li><a href="#">웨딩홀</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container -->
		</nav>
	</header>

<script src="//code.jquery.com/jquery-3.2.1.min.js"></script><script src="js/owl.carousel.js"></script>

</body>
</html>