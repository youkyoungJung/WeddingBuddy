<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>navbar_</title>
<!-- <meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description"> -->

<!-- Favicon -->
<link href="<c:url value="/img/favicon.ico"/>" rel="icon">

<!-- Google Web Fonts -->
<!-- <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Inter:wght@700;800&display=swap"
	rel="stylesheet"> -->

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="<c:url value ="/lib/animate/animate.min.css"/>"
	rel="stylesheet">
<link
	href="<c:url value ="/lib/owlcarousel/assets/owl.carousel.min.css" />"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="<c:url value ="/css/bootstrap.min.css"/>" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="<c:url value = "/css/style.css"/>" rel="stylesheet">

<style>
@font-face {
	font-family: 'Cafe24Simplehae';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Simplehae.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

body {
	font-family: Cafe24Simplehae;
}
</style>
</head>
<body>
	<!-- Spinner Start -->
	<div id="spinner"
		class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
		<div class="spinner-border text-primary"
			style="width: 3rem; height: 3rem;" role="status">
			<span class="sr-only">Loading...</span>
		</div>
	</div>
	<!-- Spinner End -->


	<!-- Navbar & Hero Start -->
	<div class="container-xxl position-relative p-0">
		<nav
			class="navbar navbar-expand-lg navbar-light px-4 px-lg-5 py-3 py-lg-0">
			<a href="<c:url value= "/"/>" class="navbar-brand p-0">
				<h1 class="m-0">WeddingBuddy</h1> <%-- <img src="<c:url value= "/images/logo.jpg"/>" alt="Logo"> --%>
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
				<span class="fa fa-bars"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<div class="navbar-nav ms-auto py-0">
					<a href="<c:url value= "/"/>" class="nav-item nav-link active">Home</a>
					<a href="<c:url value= "/search/planner"/>"
						class="nav-item nav-link">플래너찾기</a>
					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown">Pages</a>
						<div class="dropdown-menu m-0">

							<a href="<c:url value= "/studio"/>" class="dropdown-item">스튜디오 찾기</a> 
							<a href="<c:url value= "/dress"/>" class="dropdown-item">드레스 찾기</a> 
							<a href="<c:url value= "/beauty_Salon"/>" class="dropdown-item">메이크업 찾기</a>

						</div>
					</div>
				</div>
				<ul class="nav nav-pills navbar-right">
					<c:if test="${!p_isLogin && !isLogin}">
						<li><a href="<c:url value='/planner/login'/>"
							class="btn btn-light rounded-pill text-primary py-2 px-4 ms-lg-5">Planner
								Login/Register</a></li>
						<li><a href="<c:url value='/login'/>"
							class="btn btn-light rounded-pill text-primary py-2 px-4 ms-lg-5">Login/Register</a></li>
					</c:if>
					<c:choose>
						<c:when test="${isLogin }">
							<li><a href="<c:url value='/mypage'/>"
							class="btn btn-light rounded-pill text-primary py-2 px-4 ms-lg-5">User My Page</a></li>
							<li><a href="<c:url value='/logout'/>"
							class="btn btn-light rounded-pill text-primary py-2 px-4 ms-lg-5">Logout</a></li>
						</c:when>
						<c:when test="${p_isLogin }">
							<li><a href="<c:url value='/mypage'/>"
							class="btn btn-light rounded-pill text-primary py-2 px-4 ms-lg-5">Planner My Page</a></li>
							<li><a href="<c:url value='/planner/logout'/>"
							class="btn btn-light rounded-pill text-primary py-2 px-4 ms-lg-5">Logout</a></li>
						</c:when>
					</c:choose>
				</ul>
			</div>
		</nav>
	</div>
	
	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="<c:url value = "/lib/wow/wow.min.js" />"></script>
	<script src="<c:url value = "/lib/easing/easing.min.js" />"></script>
	<script src="<c url value = "/lib/waypoints/waypoints.min.js" />"></script>
	<script src="<c:url value = "/lib/owlcarousel/owl.carousel.min.js"/>"></script>

	<!-- Template Javascript -->
	<script src="<c:url value = "/js/main.js" />"></script>
</body>
</html>