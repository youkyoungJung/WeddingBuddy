<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Arrays"%>


<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>플래너 상세보기</title>

<!-- bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

<style>

	.review-item {

	margin-bottom: 20px;
	padding: 10px;
	border: 1px solid #ccc;
	background-color: #f5f5f5;
	/* 원하는 스타일을 여기에 추가하거나 수정하세요 */
}

.review-item h3 {
	margin-top: 0;
}

.review-item p {
	margin: 0;
}

.review-item .content {
	margin-bottom: 10px;
}

.review-item img {
	max-width: 100%;
	height: auto;
}

.review-image {
	max-height: 200px;
	width: auto;
}

.image-about-planner {
	padding-top: 15px;
	display: inline-flex;
}

.image-container {
	align-items: center;
	position: relative;
}

.image-about-planner {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	margin-bottom: 20px;
	border-radius: 50px;
}

.main-image {
	margin-bottom: 10px;
	width: 20% !important;
	display: flex;
	margin-right: 6px;
	img
	{
	height
	:;
}

}
.thumbnail-images {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
	width: 35% !important;
}

.thumbnail {
	flex-basis: calc(50% - 5px);
	margin-bottom: 10px;
	object-fit: cover; img { width : 100%;
	height: auto;
	border-radius: 5px;
	object-fit: cover;
}

}
.all-photos-button {
	background-color: #f7f7f7;
	border: none;
	padding: 10px;
	margin-bottom: 20px;
	cursor: pointer; . all-images { display : flex;
	align-items: center; svg { width : 16px;
	height: 16px;
	fill: currentColor;
	margin-right: 5px;
}

}
}
.page-header {
	margin-bottom: 2rem !important;
}

.content-container {
	border-radius: 5px;
	border: thin;
	border-style: solid;
	padding: 50px;
}

.form-container {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	margin-bottom: 20px;
	border-radius: 5px;
	border: thin;
	border-style: solid;
	align-content: center;
	flex-direction: column;
}

.form-container form {
	display: flex;
	align-items: center;
}

.form-container label {
	margin: 0px;
	padding-right: 5px;
	width: 50px;
	height: 29px;
	justify-content: center;
}

.form-container select, .form-container input[type="date"],
	.form-container input[type="submit"] {
	margin-right: 10px;
	padding: 0;
	border: 1px solid #ccc;
	border-radius: 3px;
}

.form-container input[type="submit"] {
	background-color: #f7f7f7;
	cursor: pointer;
}

.form-container div {
	margin-left: 10px;
	font-size: 18px;
	color: #888;
	display: flex;
}

.all-photos-button {
	justify-content: flex-end;
	padding: 0;
	margin: 0;
}

.all-image-button {
	margin-right: 10px;
	padding: 0;
}

.form-box-wrap {
	display: flex;
	flex-direction: row;
	align-items: center;
	text-align: center;
}

.form-reservation {
	margin: 0;
}

.review-container {
	margin-top: 20px;
}

.main-content-container {
	padding: 0px 200px;
}

.reservation-container {
	padding: 0px 200px;
	margin-top: 20px;
}

.form-container-main {
	padding: 20px 0px;
}

.all-images {
	display: flex;
	justify-content: flex-end;
	padding-right: 200px;
}

.breadcrumb {
	background-color: pink;
}
</style>


</head>
<body>

	<div class="container-xxl bg-white p-0" style="padding-bottom: 30px;">
		<%@ include file="navbar.jsp"%>
		<div class="container-xxl bg-primary page-header"
			style="margin-bottom: 3">
			<div class="container text-center">
				<h1 class="text-white animated zoomIn mb-3">플래너 ${planner.name }</h1>
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb justify-content-center">
						<li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
						<li class="breadcrumb-item"><a class="text-white" href="#">instagram</a></li>
						<li class="breadcrumb-item text-white active" aria-current="page">contact</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>


	<div class="image-container">
		<div class="image-about-planner">
			<div class="main-image">
				<img
					src="<c:url value='/images/plannerImage_${planner.name}_1.jpeg' ></c:url>"
					class="d-block w-100" alt="..." onclick="showImage(this)">
			</div>
			<div class="thumbnail-images">
				<div class="thumbnail">
					<img
						src="<c:url value='/images/plannerImage_${planner.name}_2.jpeg'></c:url>"
						class="d-block w-100" alt="..." onclick="showImage(this)">
				</div>
				<div class="thumbnail">
					<img
						src="<c:url value='/images/plannerImage_${planner.name}_3.jpeg'></c:url>"
						class="d-block w-100" alt="..." onclick="showImage(this)">
				</div>
				<div class="thumbnail">
					<img
						src="<c:url value='/images/plannerImage_${planner.name}_4.jpeg'></c:url>"
						class="d-block w-100" alt="..." onclick="showImage(this)">
				</div>
				<div class="thumbnail">
					<img
						src="<c:url value='/images/plannerImage_${planner.name}_5.jpeg'></c:url>"
						class="d-block w-100" alt="..." onclick="showImage(this)">
				</div>
			</div>
		</div>
	</div>
	<div class="all-images">
		<button type="button"
			class="btn btn-primary rounded-pill px-5 mt-2 all-photos-button"
			style="background-color: pink; height: 40px;">
			<div class="all-image-button">사진 더보기</div>
		</button>
	</div>


	<!-- 모달 창 -->
	<div class="modal fade" id="imageModal" tabindex="-1"
		aria-labelledby="imageModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-body">
					<img id="modalImage" src="" class="d-block mx-auto img-fluid"
						alt="...">
				</div>
			</div>
		</div>
	</div>


	<div class="reservation-container">
		<div class="form-container ">
			<div class="form-container-main">
				<form class="form-box-wrap"
					action="${pageContext.request.contextPath}/search/planner/detail?planner_id=${planner.planner_id}"
					method="post">
					<h5 class="form-reservation">상담예약</h5>
					<div>
						<label for="date ">날짜:</label> <input type="date" id="date"
							name="date">
					</div>
					<label for="hour ">시간:</label> <select id="hour" name="hour">
						<c:forEach var="hour" begin="0" end="23">
							<option value="${hour}">${hour}시</option>
						</c:forEach>
					</select>
					<div>

						<input class="btn btn-primary rounded-pill px-5 mt-2"
							style="background-color: pink; height: 40px;" type="submit"
							value="예약하기"> <br>
					</div>
				</form>
			</div>
			<div>${reservation_message }</div>
		</div>
	</div>

	<div class="main-content-container">
		<div class="content-container">
			<div class="">
				<div>
					<h2>플래너 소개</h2>
				</div>
				<div>
					<div style="padding-left: 15px;">
						<div class="planner-name">
							<div>이름 :${ planner.name }</div>
						</div>
						<div class="planner-agency">
							<div>소속 :${ agency.name }</div>
						</div>
						<div class="planner-intro">
							<div>소개 :${ planner.intro }</div>
						</div>
					</div>
				</div>
				<div class="review-container">
					<h2>리뷰</h2>


					<div class="row g-4">

						<c:forEach var="review" items="${top3Reviews}" varStatus="status">
							<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s"
								style="visibility: visible; animation-delay: 0.1s;">
								<div class="service-item rounded h-100"
									style="border-radius: 90px;">
									<div class="d-flex justify-content-between"></div>
									<div class="p-5">
										<h5 class="mb-3">${userNames[status.index]}</h5>
										<span>${review.content}</span>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>


				</div>
			</div>
		</div>

	</div>


	<script>
	function showImage(element) {
	  var imageUrl = element.src;
	  var modalImage = document.getElementById('modalImage');
	  modalImage.src = imageUrl;
	  $('#imageModal').modal('show');
	}
	</script>

	<jsp:include page="footer.jsp" />

</body>

</html>