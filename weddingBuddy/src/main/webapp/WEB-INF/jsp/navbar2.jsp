<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAVBAR2</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<style>
.fixed-top {
	position: relative;
}

.navbar-new-top {
	background: #fff;
}

.navbar-brand {
	font-weight: 600;
}

.navbar-brand img {
	width: 20%;
}

.navbar-new-top ul {
	margin-right: 9%;
}

.navbar-new-top ul li {
	margin-right: 8%;
}

.navbar-new-bottom {
	background-color: #f7f7f7;
	box-shadow: 0 5px 6px -2px rgba(0, 0, 0, .3);
	border-top: 1px solid #e0e0e0;
	margin-top: 4%;
	height: 40px;
}

.navbar-new-bottom ul li {
	margin-left: 2%;
	margin-right: 2%;
}

.navbar-nav .nav-item a {
	color: #333;
	font-size: 14px;
	font-weight: 600;
	transition: 1s ease;
}

.navbar-nav .nav-item a:hover {
	color: #0062cc;
}

.dropdown-menu.show {
	background: #f8f9fa;
	border-radius: 0;
}

.header-btn {
	width: 161%;
	border: none;
	border-radius: 1rem;
	padding: 8%;
	background: #0062cc;
	color: #fff;
	font-weight: 700;
	font-size: 13px;
	cursor: pointer;
}
</style>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
</head>
<body>
	<nav
		class="navbar fixed-top navbar-expand-md flex-nowrap navbar-new-top">
<!-- 		<a href="/" class="navbar-brand"><img src="#" alt="" />WeddingBuddy</a>
 -->		<ul class="nav navbar-nav mr-auto"></ul>
		<ul class="navbar-nav flex-row">
			<li class="nav-item"><a class="nav-link px-2">Link</a></li>
			<li class="nav-item"><a class="nav-link px-2">Link</a></li>
			<li class="nav-item">
				<button type="button" class="header-btn">Button</button>
			</li>
		</ul>
		<button class="navbar-toggler ml-auto" type="button"
			data-toggle="collapse" data-target="#navbar2">
			<span class="navbar-toggler-icon"></span>
		</button>
	</nav>
	<nav class="navbar fixed-top navbar-expand-md navbar-new-bottom">
		<div class="navbar-collapse collapse pt-2 pt-md-0" id="navbar2">
			<ul class="navbar-nav w-100 justify-content-center px-3">
				<a class="navbar-brand" href="/weddingBuddy"><b>WeddingBuddy</b></a>
				<li class="nav-item"><a class="nav-link">드레스</a></a></li>
				<li class="nav-item"><a class="nav-link">헤어</a></li>
				<li class="nav-item"><a class="nav-link">메이크업</a></li>
				<li class="nav-item"><a class="nav-link">웨딩홀</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>