<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Arrays"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>플래너 상세보기</title>

<!-- bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

<style>
#carouselExampleFade {
	height: 300px;
}

.carousel-item img {
	max-height: 300px; /* 원하는 높이로 설정 */
	width: auto; /* 이미지의 가로 크기는 자동으로 조정됨 */
}
</style>

<jsp:include page="navbar2.jsp" />

</head>
<body>



	<div id="carouselExampleFade" class="carousel slide"
		data-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<div class="row">
					<div class="col">
						<img src="<c:url value='/images/사진1.jpeg'></c:url>"
							class="d-block w-100" alt="...">
					</div>
					<div class="col">
						<img src="<c:url value='/images/사진2.jpeg'></c:url>"
							class="d-block w-100" alt="...">
					</div>
					<div class="col">
						<img src="<c:url value='/images/사진3.jpeg'></c:url>"
							class="d-block w-100" alt="...">
					</div>
				</div>
			</div>
			<div class="carousel-item">
				<div class="row">
					<div class="col">
						<img src="<c:url value='/images/사진4.jpeg'></c:url>"
							class="d-block w-100" alt="...">
					</div>
					<div class="col">
						<img src="<c:url value='/images/사진5.jpeg'></c:url>"
							class="d-block w-100" alt="...">
					</div>
					<div class="col">
						<img src="<c:url value='/images/사진6.jpeg'></c:url>"
							class="d-block w-100" alt="...">
					</div>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleFade"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleFade"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>

	<div>
		<div class="col-md-2 col-sm-2">
			<img src="https://bootdey.com/img/Content/avatar/avatar7.png"
				alt="user" class="profile-photo-lg">
		</div>
		<div class="planner-name">
			<h1>이름 :${ planner.name }</h1>
		</div>
		<div class="planner-agency">
			<h1>소속 :${ agency.name }</h1>
		</div>
		<div class="planner-intro">
			<h1>소개 :${ planner.intro }</h1>
		</div>
	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
		crossorigin="anonymous"></script>
</body>

</html>